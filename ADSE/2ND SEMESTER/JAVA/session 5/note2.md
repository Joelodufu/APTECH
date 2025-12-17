> 1. Explain race conditions and ways to overcome them
> 2. Elaborate on intrinsic lock and synchronization
> 3. Identify atomic access

---

# 🧵 **Java Multithreading Class Note**

## 🎯 **Learning Objectives**

By the end of this lesson, students should be able to:

1. Explain what race conditions are and how to prevent them.
2. Understand the concept of intrinsic locks and synchronization.
3. Identify atomic access and its importance in thread safety.

---

## 🧩 **1. Race Conditions**

### **Definition (Simple)**

A **race condition** happens when **two or more threads try to access and modify shared data at the same time**, and the final result depends on which thread runs first.

### **Example (Simple)**

```java
class Counter {
    int count = 0;

    void increment() {
        count++;  // shared resource
    }
}

public class RaceExample {
    public static void main(String[] args) {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start();
        t2.start();

        try { t1.join(); t2.join(); } catch (Exception e) {}
        System.out.println("Final count: " + c.count);
    }
}
```

### **Expected Output**

You might expect:
`Final count: 2000`

But sometimes it shows:
`Final count: 1980`, `1992`, or another wrong number.

### **Why?**

Because both threads **interfere** with each other while reading and updating `count`.

---

### 🧠 **How to Overcome Race Conditions**

1. **Use Synchronization** — ensure only one thread can access the shared code at a time.
2. **Use Locks** — explicit lock objects to manage thread access.
3. **Use Atomic Variables** — for small data operations like increment/decrement.

---

## 🔒 **2. Intrinsic Lock and Synchronization**

### **Definition (Simple)**

An **intrinsic lock** (also called a **monitor lock**) is a built-in lock that every Java object has.
When a thread enters a **synchronized block or method**, it **acquires the lock** of that object — other threads must wait until the lock is released.

---

### **Example (Synchronized Method)**

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}

public class SyncExample {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final count: " + c.count);
    }
}
```

### ✅ **Output**

`Final count: 2000` (Always correct)

### **Explanation**

The `synchronized` keyword ensures that:

- Only one thread at a time can execute `increment()`.
- Other threads must **wait** until the lock is released.

---

### **Example (Synchronized Block)**

```java
class Printer {
    void printJob(String message) {
        synchronized (this) {
            for (int i = 1; i <= 3; i++) {
                System.out.println(message + " " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }
    }
}
```

Here, the lock is on **this** object (the Printer instance), so only one thread can print at a time.

---

## ⚙️ **3. Atomic Access**

### **Definition (Simple)**

An **atomic operation** is one that **happens completely or not at all** — it cannot be interrupted by other threads.

### **Example (Non-Atomic)**

`count++` is **not atomic** because it’s actually 3 steps:

1. Read count
2. Add 1
3. Write back count

Two threads can interfere between these steps.

---

### **Example (AtomicInteger)**

Java provides atomic classes in `java.util.concurrent.atomic`.

```java
import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    AtomicInteger count = new AtomicInteger(0);

    void increment() {
        count.incrementAndGet(); // atomic operation
    }
}

public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter c = new AtomicCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final count: " + c.count);
    }
}
```

✅ Always gives `Final count: 2000`

---

## 🧰 **Applied Example: Bank Transaction**

```java
class BankAccount {
    private int balance = 1000;

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " cannot withdraw, insufficient funds.");
        }
    }
}

public class BankExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw(700), "User1");
        Thread t2 = new Thread(() -> account.withdraw(700), "User2");

        t1.start(); t2.start();
    }
}
```

### **What Happens**

Without synchronization → both users could withdraw at the same time (negative balance).
With `synchronized` → one transaction completes before another starts.

---

## 🧾 **Summary Table**

| Concept            | Meaning                                         | Fix / Tool                     |
| ------------------ | ----------------------------------------------- | ------------------------------ |
| **Race Condition** | Multiple threads access shared data incorrectly | Synchronization / Locks        |
| **Intrinsic Lock** | Built-in lock on every Java object              | Used by `synchronized` keyword |
| **Atomic Access**  | Operation that can’t be interrupted             | `AtomicInteger`, etc.          |

---

## 💡 **Real-World Analogy**

Imagine two people trying to **withdraw from one ATM account** at the same time:

- **Race condition** = both access at once → wrong balance
- **Synchronization** = ATM allows one at a time
- **Atomic operation** = instant update of balance — no interference possible

---
