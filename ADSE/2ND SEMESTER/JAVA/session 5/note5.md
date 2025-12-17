Here we’ll cover two advanced but fascinating areas of **modern Java performance and interoperability**:

> 1️⃣ The process to build a **Radix Sort** program using the **Foreign Function & Memory API (Foreign API)**
> 2️⃣ The difference between **on-heap** and **off-heap** memory areas

We’ll still keep it **simple**, **practical**, and **classroom-ready** — with plain definitions, mini examples, and applied insights.

---

# 🧵 **Java Multithreading and Memory — Part 4**

## 🎯 **Learning Objectives**

By the end of this class, students should be able to:

1. Explain how to build and run a simple **Radix Sort** algorithm using the **Foreign API**.
2. Distinguish between **on-heap** and **off-heap** memory areas.
3. Understand when and why off-heap memory might be used in high-performance Java systems.

---

## ⚙️ **1️⃣ Building a Radix Sort Program with the Foreign API**

### 🧠 **What is the Foreign API?**

The **Foreign Function & Memory API (FFM API)** allows Java programs to:

- **Call native (C / C++) functions** safely — no need for JNI boilerplate.
- **Access memory outside the Java heap**, called **off-heap memory**.
  It was added as an incubating feature in **Java 19+** (and stabilized in 21).

---

### 📘 **Why Use It for Radix Sort?**

Radix Sort is a **fast non-comparison sorting algorithm** that works well with large arrays of integers.
Using the FFM API, we can allocate and manipulate a big array of numbers **off-heap**, perform the sort efficiently, and reduce garbage-collection (GC) pressure.

---

### 🪄 **Steps to Build a Radix Sort Program Using Foreign API**

#### ✅ Step 1: Import the API Classes

```java
import java.lang.foreign.*;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
```

#### ✅ Step 2: Allocate Off-Heap Memory

```java
try (Arena arena = Arena.ofConfined()) {
    // Allocate space for 10 integers off-heap
    MemorySegment segment = arena.allocate(10 * Integer.BYTES);
    VarHandle intHandle =
        ValueLayout.JAVA_INT.withOrder(ByteOrder.nativeOrder()).varHandle(int.class);
```

#### ✅ Step 3: Initialize Data

```java
    for (int i = 0; i < 10; i++) {
        intHandle.set(segment, (long) i * Integer.BYTES, (int) (Math.random() * 100));
    }
```

#### ✅ Step 4: Implement a Simple Radix Sort (Using Java on Off-Heap Data)

```java
    // Simple LSD radix sort working directly on the off-heap segment
    for (int exp = 1; exp <= 100; exp *= 10) {
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                int a = (int) intHandle.get(segment, (long) i * Integer.BYTES);
                int b = (int) intHandle.get(segment, (long) j * Integer.BYTES);
                if ((a / exp) % 10 > (b / exp) % 10) {
                    intHandle.set(segment, (long) i * Integer.BYTES, b);
                    intHandle.set(segment, (long) j * Integer.BYTES, a);
                }
            }
        }
    }
```

#### ✅ Step 5: Read Back the Sorted Data

```java
    System.out.println("Sorted Numbers:");
    for (int i = 0; i < 10; i++) {
        int value = (int) intHandle.get(segment, (long) i * Integer.BYTES);
        System.out.print(value + " ");
    }
}
```

---

### 🧾 **Explanation**

- `Arena.ofConfined()` → safely allocates off-heap memory; freed automatically when closed.
- `MemorySegment` → represents a continuous block of memory.
- `VarHandle` → provides typed read/write access.
- The algorithm reads and writes integers **directly in off-heap memory** — no arrays, no GC.

---

### 💡 **Real-World Analogy**

Imagine you’re sorting papers not on your office desk (the heap) but on a **large table outside** (off-heap).
You can handle huge piles quickly without cluttering your desk, and when done, you clear the table yourself.

---

## 🧮 **2️⃣ On-Heap vs Off-Heap Memory Areas**

| **Aspect**     | **On-Heap Memory**                             | **Off-Heap Memory**                                  |
| -------------- | ---------------------------------------------- | ---------------------------------------------------- |
| **Managed By** | Java Virtual Machine (JVM) / Garbage Collector | Programmer or Foreign API                            |
| **Storage**    | Objects and arrays created with `new`          | Data stored outside the JVM heap                     |
| **Speed**      | Easier to use but affected by GC pauses        | Faster access for large data sets, avoids GC pauses  |
| **Safety**     | Automatic memory management                    | Manual allocation / deallocation required            |
| **Use Case**   | Everyday Java objects                          | High-performance apps, large buffers, native interop |

---

### 💻 **Mini Example**

```java
// On-heap
int[] numbers = new int[1000];

// Off-heap
try (Arena arena = Arena.ofConfined()) {
    MemorySegment offHeap = arena.allocate(1000 * Integer.BYTES);
    System.out.println("Off-heap memory allocated successfully!");
}
```

Here, `numbers` live in the heap, while `offHeap` lives **outside** and won’t burden the garbage collector.

---

### 🚀 **When to Use Off-Heap Memory**

- Large data processing (big arrays, images, logs)
- High-frequency trading and game engines
- Interfacing with native C/C++ code for performance
- Reducing GC overhead in real-time systems

---

## 🧾 **Summary Table**

| **Concept**                     | **Meaning**                                              | **Benefit**                           |
| ------------------------------- | -------------------------------------------------------- | ------------------------------------- |
| **Foreign API**                 | Allows Java to access native memory and functions safely | High performance, low overhead        |
| **Radix Sort with Foreign API** | Sorts off-heap integers using direct memory              | Fast and GC-free sorting              |
| **On-Heap Memory**              | Managed by JVM                                           | Safe, automatic                       |
| **Off-Heap Memory**             | Managed manually via Foreign API                         | Faster, flexible, used for large data |

---

## 💬 **Key Takeaway**

> _“The Foreign API extends Java beyond its own memory, giving developers both power and responsibility.”_
> Use on-heap for simplicity; off-heap for performance and advanced interoperability.

---

## 🧠 **Class Exercises**

1. Implement a simple **Bubble Sort** using off-heap memory.
2. Compare the time taken by a normal (on-heap) sort vs an off-heap sort.
3. Try connecting to a native C function that prints a message from within Java using the Foreign API.

---
