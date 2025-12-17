### 1) Threads in Java

- **Thread**: a single path of execution. You create a thread either by:

  - Extending `Thread` and overriding `run()`, or
  - Implementing `Runnable` (preferred) and passing it to a `Thread` object.

- **Starting**: call `.start()` to begin concurrent execution, not `run()` directly.

### 2) Shared resources & race conditions

- When multiple threads access the same data (like a counter) without proper coordination, they can cause wrong results. This is a **race condition**.
- **Example**: both threads read a number at same time, increment, then write — you lose updates.

### 3) Locks and synchronization

- `synchronized` keyword ensures only one thread executes a block/method guarded by the same monitor (object) at a time.
- Use ```java synchronized(obj) { ... }``` to acquire the monitor (lock) on `obj`. Releases when block ends.

### 4) wait() / notify() / notifyAll()

- Only usable inside a `synchronized` block on the same object.
- `wait()` — current thread releases the monitor and goes to waiting state until another thread calls `notify()`/`notifyAll()` on that same object.
- `notify()` — wakes one waiting thread; `notifyAll()` — wakes all waiting threads.
- Typical pattern to coordinate threads: thread checks condition in a loop ```java while (!condition) wait();```

### 5) Volatile and Atomic variables

- `volatile` ensures reads/writes go straight to main memory; good for visibility but **not** for compound actions (like increment).
- For atomic operations use `AtomicInteger` or synchronization for compound operations.

### 6) ReentrantLock and Condition (java.util.concurrent)

- `ReentrantLock` is an explicit lock with methods `lock()`/`unlock()`.
- `Condition` objects created from a lock implement `await()`/`signal()`/`signalAll()` — similar to `wait`/`notify`, but more flexible (e.g., multiple conditions).
- Preferred in complex scenarios.

### 7) Thread lifecycle & interruption

- Threads can be `NEW`, `RUNNABLE`, `BLOCKED`, `WAITING`, `TIMED_WAITING`, `TERMINATED`.
- Use `Thread.interrupt()` to request a thread stop; thread should check `Thread.currentThread().isInterrupted()` or catch `InterruptedException`.

### 8) Avoiding deadlocks

- Deadlock: two or more threads each waiting for locks held by the others. Avoid by:

  - Always acquiring locks in the same global order.
  - Minimizing number of locks held at once.
  - Using lock timeouts or try-lock patterns.

### 9) Implementation pattern for alternating printing

- Shared state indicates whose turn it is (e.g., `boolean oddTurn` or an integer `current`).
- Each thread:

  - Acquires lock / enters `synchronized` block.
  - Checks whether it’s their turn.
  - If not their turn, `wait()`.
  - If their turn, print and update state, then `notify()` (or `signal()`), and continue.

---

# Pseudocode / Implementation plan

Goal: Two threads print numbers from 1..N, odd thread prints odd numbers, even thread prints even numbers, and they alternate correctly.

Plan (wait/notify approach):

1. Shared object `Printer`:

   - Fields: `int max`, `int current = 1`, `Object lock = new Object()`.
   - Method `printOdd()`:

     - while `current <= max`:

       - synchronized(lock):

         - while `current <= max` and `current` is even -> `lock.wait()`
         - if `current <= max`: print `current`, increment `current`, `lock.notify()`

   - Method `printEven()`:

     - same but waits when `current` is odd.

2. Main:

   - Create `Printer` with `max`.
   - Create two threads with `Runnable` that call `printer.printOdd()` and `printer.printEven()`.
   - Start threads, join threads.

Edge cases/worth noting:

- Always use `while` around `wait()` to handle spurious wakeups.
- After increment, call `notify()` to wake the other thread.
- Use `notifyAll()` if unsure; here `notify()` is enough because only one other thread waits.
- Check `current <= max` after waking up to avoid printing out of range.

Alternative approach (using `ReentrantLock` + `Condition`):

- Create `lock = new ReentrantLock()`, `Condition oddCondition`, `Condition evenCondition`.
- Use `await()`/`signal()` in analogous places.

---

# Java implementation (well-commented) — Primary: wait/notify approach

```java
/**
 * AlternatingOddEven.java
 *
 * Two threads alternate printing numbers from 1 to N.
 * One thread prints odd numbers, the other prints even numbers.
 *
 * This implementation uses a shared Printer object with wait()/notify().
 */

public class AlternatingOddEven {

    // Shared Printer class encapsulates the counting and synchronization.
    static class Printer {
        private final int max;
        private int current = 1;         // next number to print
        private final Object lock = new Object();

        public Printer(int max) {
            this.max = max;
        }

        // Called by the odd-number thread
        public void printOdd() {
            while (true) {
                synchronized (lock) {
                    // Wait while current is not odd and we're still in range
                    while (current <= max && current % 2 == 0) {
                        try {
                            lock.wait(); // releases lock and waits
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return; // Exit if interrupted
                        }
                    }

                    if (current > max) {
                        // No more numbers to print; notify any waiting thread and exit.
                        lock.notify(); // wake other thread to allow it to finish if waiting
                        return;
                    }

                    // It's odd's turn
                    System.out.println(Thread.currentThread().getName() + " prints: " + current);
                    current++;

                    // Wake up the other thread waiting on the lock
                    lock.notify();
                }
            }
        }

        // Called by the even-number thread
        public void printEven() {
            while (true) {
                synchronized (lock) {
                    // Wait while current is not even and we're still in range
                    while (current <= max && current % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    if (current > max) {
                        lock.notify();
                        return;
                    }

                    // It's even's turn
                    System.out.println(Thread.currentThread().getName() + " prints: " + current);
                    current++;

                    // Wake up the other thread waiting on the lock
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int MAX = 20; // print numbers 1..20 (change as needed)

        Printer printer = new Printer(MAX);

        // Thread that prints odd numbers
        Thread oddThread = new Thread(printer::printOdd, "Odd-Thread");

        // Thread that prints even numbers
        Thread evenThread = new Thread(printer::printEven, "Even-Thread");

        // Start both threads
        oddThread.start();
        evenThread.start();

        // Wait for both threads to finish
        oddThread.join();
        evenThread.join();

        System.out.println("Done printing 1.." + MAX);
    }
}
```

**Notes about the implementation**

- `while` is used around `wait()` to handle spurious wakeups.
- After finishing (`current > max`), each side does a `notify()` to wake the other thread so it can check the condition and terminate.
- We check `current > max` inside the synchronized block to ensure consistent view.
- The `Thread.currentThread().interrupt()` on `InterruptedException` ensures proper propagation of interruption status.

---

# Alternative implementation — ReentrantLock + Condition

This is slightly more advanced but clearer in some cases.

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatingOddEvenLock {
    static class Printer {
        private final int max;
        private int current = 1;
        private final Lock lock = new ReentrantLock();
        private final Condition oddTurn = lock.newCondition();
        private final Condition evenTurn = lock.newCondition();

        public Printer(int max) { this.max = max; }

        public void printOdd() {
            while (true) {
                lock.lock();
                try {
                    while (current <= max && current % 2 == 0) {
                        oddTurn.await();
                    }
                    if (current > max) {
                        // signal even thread in case it's waiting, then exit
                        evenTurn.signal();
                        return;
                    }
                    System.out.println(Thread.currentThread().getName() + " prints: " + current);
                    current++;
                    evenTurn.signal(); // wake even thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                } finally {
                    lock.unlock();
                }
            }
        }

        public void printEven() {
            while (true) {
                lock.lock();
                try {
                    while (current <= max && current % 2 != 0) {
                        evenTurn.await();
                    }
                    if (current > max) {
                        oddTurn.signal();
                        return;
                    }
                    System.out.println(Thread.currentThread().getName() + " prints: " + current);
                    current++;
                    oddTurn.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int MAX = 20;
        Printer printer = new Printer(MAX);
        Thread odd = new Thread(printer::printOdd, "Odd-Thread");
        Thread even = new Thread(printer::printEven, "Even-Thread");
        odd.start();
        even.start();
        odd.join();
        even.join();
        System.out.println("Done printing 1.." + MAX);
    }
}
```

**Why use `ReentrantLock` + `Condition`?**

- More control: multiple `Condition`s let you wake specific waiters.
- Helpful when you have several different waiting conditions.

---

# Quick debugging / testing tips

- Print thread names with each output so you can see alternation.
- Test with both even and odd `MAX` (e.g., 5 and 6) to ensure termination logic works.
- Put short sleeps (e.g., `Thread.sleep(50)`) during debugging to make prints easier to follow.
- Test interruption: call `oddThread.interrupt()` while running to understand behavior.

---

If you want I can:

- Convert the code into multiple small testable classes (unit-test friendly).
- Provide a GUI / console menu to choose `MAX`.
- Create a single-file zip or paste-ready snippet formatted for your IDE.
