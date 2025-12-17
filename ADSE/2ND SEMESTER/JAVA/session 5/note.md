
# 🧵 **Java Multithreading – Comprehensive Class Note**

---

## 📘 **Table 5.1: Differences Between Multithreading and Multitasking**

| Feature            | Multithreading                                 ****                              | Multitasking                                                   |
| ------------------ | ---------------------------------------------------------------------------- | -------------------------------------------------------------- |
| **Definition**     | Running multiple threads (small parts) of the same program at the same time. | Running multiple programs at the same time.                    |
| **Level**          | Happens **inside one program**.                                              | Happens **between multiple programs**.                         |
| **Example**        | A browser loading multiple tabs simultaneously.                              | A computer running MS Word and playing music at the same time. |
| **Resource Usage** | Shares the same memory space.                                                | Each program has its own memory space.                         |
| **Efficiency**     | Faster because threads share memory and communicate easily.                  | Slower compared to threads due to context switching.           |

---

## 🧩 **Necessity for Multithreading**

### **Definition:**

Multithreading allows a program to perform **many tasks at the same time** without waiting for one task to finish before starting another.

### **Why It’s Needed:**

1. **Improves performance** — tasks run concurrently.
2. **Better resource utilization** — uses CPU efficiently.
3. **Responsive applications** — e.g., UI doesn’t freeze while loading data.
4. **Parallel execution** — useful in games, servers, and real-time systems.

### **Example:**

* Downloading a file while showing download progress.
* A chat app sending and receiving messages simultaneously.

### 🧠 **Class Task:**

Write a simple Java program that starts two threads:

1. One prints numbers 1–5.
2. The other prints letters A–E.
   Observe how they interleave in the output.

---

## 🧭 **5.2 More Methods of the Thread Class**

---

### **5.2.1 `isAlive()` Method**

**Definition:**
Checks whether a thread is **still running** or **has finished execution**.

**Syntax:**

```java
boolean isAlive()
```

**Explanation:**
Returns `true` if the thread has started and not yet finished, otherwise `false`.

**Simple Example:**

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class TestAlive {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        System.out.println("Before start: " + t1.isAlive());
        t1.start();
        System.out.println("After start: " + t1.isAlive());
    }
}
```

**Complex Example:**

```java
class Worker extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++)
            System.out.println(getName() + " working " + i);
    }
}

public class AliveCheck {
    public static void main(String[] args) throws InterruptedException {
        Worker t1 = new Worker();
        t1.start();
        while (t1.isAlive()) {
            System.out.println("Main thread: Worker is still alive...");
            Thread.sleep(500);
        }
        System.out.println("Worker finished!");
    }
}
```

🧠 **Class Task:**
Write a program that starts two threads and uses `isAlive()` to print their status before, during, and after execution.

---

### **5.2.2 `join()` Method**

**Definition:**
Makes one thread **wait** for another thread to finish before continuing.

**Syntax:**

```java
void join()  
void join(long timeout)  
void join(long timeout, int nanoseconds)
```

**Explanation:**

* `join()` → waits till the other thread finishes completely.
* `join(long timeout)` → waits for the given milliseconds, then continues even if thread is not done.
* `join(long timeout, int nanoseconds)` → adds nanosecond precision.

---

**Simple Example (using `join()`):**

```java
class Task extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++)
            System.out.println(getName() + " - Step " + i);
    }
}

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Task t1 = new Task();
        t1.start();
        t1.join(); // Main thread waits for t1
        System.out.println("Main thread resumes after t1 completes.");
    }
}
```

---

**Complex Example (using timeouts):**

```java
class Worker extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " working " + i);
            try { Thread.sleep(400); } catch (Exception e) {}
        }
    }
}

public class JoinTimeoutExample {
    public static void main(String[] args) throws InterruptedException {
        Worker t1 = new Worker();
        t1.start();
        t1.join(1000); // Wait 1 second only
        System.out.println("Main thread continues even if t1 not finished.");
    }
}
```

🧠 **Class Task:**
Create 3 threads: `t1`, `t2`, `t3`.
Make main wait for `t1` to finish, then start `t2` and `t3` together. Observe the order of execution.

---

## 🔒 **5.3 Thread Synchronization**

---

### **Definition:**

Synchronization means **controlling the access** of multiple threads to shared resources so that **data remains consistent**.

Without synchronization, multiple threads may change shared data at the same time, causing **errors** known as **race conditions**.

---

### **5.3.1 Race Conditions**

**Definition:**
A **race condition** happens when two or more threads access shared data and try to change it at the same time — leading to **unexpected results**.

**Example (Problem):**

```java
class Counter {
    int count = 0;
    void increment() {
        count++;
    }
}

public class RaceExample {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> { for(int i=0;i<1000;i++) c.increment(); });
        Thread t2 = new Thread(() -> { for(int i=0;i<1000;i++) c.increment(); });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final Count: " + c.count); // May not be 2000!
    }
}
```

🧠 **Class Task:**
Run the above code multiple times — observe that the final result changes.
Then fix it using synchronization (below).

---

### **5.3.2 Synchronized Blocks and Methods**

**Definition:**
The `synchronized` keyword prevents multiple threads from accessing a block or method at the same time.

**Syntax:**

```java
synchronized (object) {
    // critical section
}
```

**Example (Block):**

```java
class Table {
    void printTable(int n) {
        synchronized(this) {
            for (int i = 1; i <= 5; i++)
                System.out.println(n * i);
        }
    }
}
```

---

### **5.3.3 Synchronized Methods**

**Definition:**
When a method is declared `synchronized`, only one thread can call it at a time on the same object.

**Example (Fixing Race Condition):**

```java
class Counter {
    int count = 0;
    synchronized void increment() { count++; }
}

public class SyncMethodExample {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> { for(int i=0;i<1000;i++) c.increment(); });
        Thread t2 = new Thread(() -> { for(int i=0;i<1000;i++) c.increment(); });
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Final Count: " + c.count); // Always 2000
    }
}
```

🧠 **Class Task:**
Take the race condition example earlier and make the `increment()` method synchronized. Compare the results.

---

### **5.3.4 Intrinsic Locks and Synchronization**

**Explanation:**

* Every Java object has a built-in lock called an **intrinsic lock**.
* When a thread enters a synchronized block or method, it **locks** the object.
* No other thread can enter another synchronized block on the same object until the first thread releases the lock.

**Example:**

```java
class Printer {
    synchronized void print(String msg) {
        System.out.print("[" + msg);
        try { Thread.sleep(500); } catch (Exception e) {}
        System.out.println("]");
    }
}

public class LockExample {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(() -> printer.print("Hello"));
        Thread t2 = new Thread(() -> printer.print("World"));
        t1.start(); t2.start();
    }
}
```

➡ Output always shows complete `[Hello] [World]`, not mixed lines — because of intrinsic locks.

🧠 **Class Task:**
Create a class `Printer` that prints messages from multiple threads. Remove synchronization and observe the mixed output, then add synchronization and see the difference.

---

## ✅ **Summary**

| Concept        | Purpose                             |
| -------------- | ----------------------------------- |
| Multithreading | Run multiple threads in one program |
| `isAlive()`    | Check if thread is running          |
| `join()`       | Wait for thread to finish           |
| Race Condition | Error from unsynchronized threads   |
| `synchronized` | Prevent concurrent access           |
| Intrinsic Lock | Automatic lock mechanism per object |

---
