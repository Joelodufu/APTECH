> 1. Identify the use of `wait()` and `notify()` methods
> 2. Define deadlock and the ways to overcome it

We’ll keep the same simple, **student-friendly** style with **micro examples**, **real-world analogies**, and **applied code** for deeper understanding.

---

# 🧵 **Java Multithreading Class Note (Part 2)**

## 🎯 **Learning Objectives**

By the end of this lesson, students should be able to:

1. Explain and demonstrate how `wait()` and `notify()` work in thread communication.
2. Define **deadlock**, identify when it happens, and discuss ways to prevent or fix it.

---

## 🕐 **1. The `wait()` and `notify()` Methods**

### **Simple Definition**

`wait()` and `notify()` are methods used for **inter-thread communication** — they allow threads to **cooperate** rather than **compete**.

- `wait()` → tells a thread to **pause** and **release the lock** until another thread notifies it.
- `notify()` → tells **one waiting thread** to wake up and continue.
- `notifyAll()` → wakes up **all waiting threads**.

### ⚙️ **Where They Belong**

They are defined in the **`Object` class**, not the `Thread` class — meaning **every Java object** can use them (because every object has an intrinsic lock).

---

### **Example (Simple Producer–Consumer Demo)**

#### 🧠 Concept:

One thread produces data (Producer), another thread consumes it (Consumer).
The Consumer should wait until data is available.

#### 💻 Code Example:

```java
class SharedData {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) {
        while (hasData) {
            try { wait(); } catch (InterruptedException e) {}
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify(); // wake up consumer
    }

    public synchronized void consume() {
        while (!hasData) {
            try { wait(); } catch (InterruptedException e) {}
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify(); // wake up producer
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedData shared = new SharedData();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                shared.produce(i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                shared.consume();
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
```

### 🧾 **Explanation:**

1. **Producer** produces a number, then calls `notify()` to wake up the Consumer.
2. **Consumer** waits using `wait()` until Producer produces new data.
3. They take turns smoothly without clashing — thanks to synchronization + wait/notify.

---

### 💡 **Real-Life Analogy**

Imagine a **restaurant kitchen**:

- The **chef (producer)** waits for the waiter to serve food before cooking more.
- The **waiter (consumer)** waits for the chef to finish cooking before serving.
  → They signal each other — like `wait()` and `notify()` in Java.

---

## ⚠️ **2. Deadlock**

### **Definition (Simple)**

A **deadlock** happens when **two or more threads are waiting for each other forever**, and none can continue.
It’s like a “you first — no, you first” situation.

---

### **Example (Simple Code Demo)**

```java
class Resource {
    void useResource() {
        System.out.println(Thread.currentThread().getName() + " is using the resource");
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        final Resource resource1 = new Resource();
        final Resource resource2 = new Resource();

        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 locked Resource 1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resource2) {
                    System.out.println("Thread 1 locked Resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2 locked Resource 2");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resource1) {
                    System.out.println("Thread 2 locked Resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

### 🧩 **What Happens**

- Thread 1 locks **Resource 1** and waits for **Resource 2**.
- Thread 2 locks **Resource 2** and waits for **Resource 1**.
  → Both keep waiting **forever** — a deadlock.

---

## 🧰 **Ways to Overcome Deadlock**

| **Method**                                      | **Explanation**                                                                             |
| ----------------------------------------------- | ------------------------------------------------------------------------------------------- |
| **Avoid Nested Locks**                          | Try to lock one resource at a time instead of multiple.                                     |
| **Lock Ordering**                               | Always lock resources in the same order in all threads.                                     |
| **TryLock (from `java.util.concurrent.locks`)** | Use timed locks that fail instead of waiting forever.                                       |
| **Deadlock Detection**                          | Use tools like thread dumps or monitoring tools (e.g., VisualVM) to detect blocked threads. |

---

### **Improved Version (Avoiding Deadlock using Lock Ordering)**

```java
class SafeExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void doTask() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " locked lock1");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " locked lock2");
            }
        }
    }
}

public class NoDeadlockExample {
    public static void main(String[] args) {
        SafeExample obj = new SafeExample();

        Thread t1 = new Thread(() -> obj.doTask());
        Thread t2 = new Thread(() -> obj.doTask());

        t1.start();
        t2.start();
    }
}
```

✅ Both threads can safely complete their tasks — no deadlock.

---

## 🧾 **Summary Table**

| Concept        | Meaning                                          | Example                    | Fix / Best Practice                   |
| -------------- | ------------------------------------------------ | -------------------------- | ------------------------------------- |
| **`wait()`**   | Causes thread to wait and release lock           | Producer-Consumer          | Use inside synchronized block         |
| **`notify()`** | Wakes one waiting thread                         | Producer-Consumer          | Use inside synchronized block         |
| **Deadlock**   | Two or more threads stuck waiting for each other | Nested synchronized blocks | Use lock ordering, avoid nested locks |

---

## 💡 **Real-World Analogy**

- **Deadlock:** Two cars on a narrow bridge — both waiting for the other to move.
- **Solution:** Follow **traffic rules (lock ordering)** or **use signals (`notify()`)** to coordinate who moves first.

---
