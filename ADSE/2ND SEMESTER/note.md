
# **Class Note: Introduction to `java.util` Package**

### **Course Title:** Advanced Java Concepts

### **Session:** Java Utility APIs

### **Topic:** Introduction to `java.util` Package

### **Duration:** 15 minutes

---

## 🧠 **Learning Objectives**

By the end of this lesson, learners should be able to:

1. Understand what the `java.util` package is and why it is important.
2. Identify key classes and interfaces contained in the package.
3. Import and use some basic utility classes in simple programs.

---

## 🧩 **1. What is the `java.util` Package?**

The `java.util` package is one of the **core utility packages** in the Java Standard Library. It provides **utility classes and interfaces** that are essential for day-to-day programming tasks.

It contains:

* **Collection Framework classes** – for handling groups of objects such as lists, sets, and maps.
* **Utility classes** – for date, time, random numbers, and more.
* **Legacy classes** – such as `Hashtable`, `Stack`, and `Vector` (still supported for backward compatibility).

👉 **Think of `java.util`** as Java’s **toolbox** — it gives you pre-built tools for managing data, performing operations, and simplifying complex tasks.

---

## 🧱 **2. Major Components of `java.util` Package**

### **a. Collections Framework**

The Collections Framework is the heart of the `java.util` package.
It provides **interfaces** and **classes** for storing and manipulating groups of objects.

| Category  | Interfaces         | Common Implementations                             | Description                           |
| --------- | ------------------ | -------------------------------------------------- | ------------------------------------- |
| **List**  | `List`             | `ArrayList`, `LinkedList`, `Vector`                | Ordered collection, allows duplicates |
| **Set**   | `Set`, `SortedSet` | `HashSet`, `TreeSet`, `LinkedHashSet`              | Unordered, no duplicates              |
| **Queue** | `Queue`, `Deque`   | `LinkedList`, `PriorityQueue`                      | FIFO (First-In-First-Out) structure   |
| **Map**   | `Map`, `SortedMap` | `HashMap`, `TreeMap`, `LinkedHashMap`, `Hashtable` | Key–value pair collections            |

---

### **b. Utility Classes**

Some non-collection utility classes commonly used include:

| Class               | Description                                  | Example Use                                    |
| ------------------- | -------------------------------------------- | ---------------------------------------------- |
| `Arrays`            | Utility methods for working with arrays      | Sorting, searching, converting arrays to lists |
| `Collections`       | Utility methods for working with collections | Sorting, reversing, synchronizing collections  |
| `Date` / `Calendar` | For working with dates and time              | Getting current date/time                      |
| `Random`            | For generating random numbers                | Simulating games, lottery, etc.                |
| `Scanner`           | For reading input from user or files         | Reading console input                          |
| `StringTokenizer`   | For splitting strings into tokens            | Parsing CSV or command-line input              |

---

## 🧮 **3. Importing and Using `java.util` Classes**

To use any class from this package, you must **import** it at the top of your program using one of two methods:

### **Option 1: Import a specific class**

```java
import java.util.Scanner;
```

### **Option 2: Import the entire package**

```java
import java.util.*;
```

---

## 🧑‍💻 **4. Practical Examples**

### **Example 1: Using the Scanner class**

```java
import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello, " + name + "!");
        input.close();
    }
}
```

🟢 *Explanation:*
The `Scanner` class from `java.util` allows reading user input easily from the console.

---

### **Example 2: Using Random class**

```java
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(10); // Generates number between 0-9
        System.out.println("Random number: " + number);
    }
}
```

🟢 *Explanation:*
The `Random` class generates random values for simulations, games, or testing.

---

### **Example 3: Using Arrays class**

```java
import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1};
        Arrays.sort(numbers);
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));
    }
}
```

🟢 *Explanation:*
The `Arrays` class provides static methods like `sort()` and `toString()` to handle arrays efficiently.

---

## 📘 **5. Key Takeaways**

✅ `java.util` is a core utility package in Java containing powerful tools for handling data.
✅ The **Collections Framework** is the most important part of `java.util`.
✅ Utility classes like `Scanner`, `Random`, and `Arrays` simplify common programming tasks.
✅ Always **import** the package before using its classes.

---

## 🧩 **6. Quick Quiz (Check Your Understanding)**

1. What is the purpose of the `java.util` package?
2. Name any **three** classes found in the package.
3. What is the difference between `List` and `Set`?
4. Which `java.util` class is used for reading user input?
5. What method in the `Arrays` class can you use to sort elements?

---

## 🧠 **7. Assignment / Practice Task**

Create a Java program that:

1. Reads five numbers from the user using `Scanner`.
2. Stores them in an array.
3. Sorts them using the `Arrays.sort()` method.
4. Displays the sorted numbers.

---
