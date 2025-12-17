## 🧠 **Class Note: Collection Interface and Its Methods (Java Util Package)**

### **1. Introduction**

- The **Collection Interface** is part of the **Java Collections Framework (JCF)** in the **`java.util`** package.
- It is the **root interface** for all collection classes like `List`, `Set`, and `Queue`.
- It defines the **basic operations** that can be performed on groups of objects, known as **elements**.

```java
import java.util.Collection;
```

---

### **2. Hierarchy**

```
        Iterable
           ↑
      Collection
      /     |     \
   List    Set    Queue
```

- **Subinterfaces of Collection:**

  - **List** → e.g. `ArrayList`, `LinkedList`
  - **Set** → e.g. `HashSet`, `LinkedHashSet`, `TreeSet`
  - **Queue** → e.g. `PriorityQueue`, `LinkedList`

---

### **3. Key Characteristics**

- Stores a **group of objects (elements)**.
- Allows **adding**, **removing**, and **iterating** over elements.
- Can **check size**, **emptiness**, and **membership**.
- Does **not** store elements in key-value pairs (that’s for **Map** interface).

---

### **4. Commonly Used Methods of Collection Interface**

| **Method**                                  | **Return Type** | **Description / Example**                                             |
| ------------------------------------------- | --------------- | --------------------------------------------------------------------- |
| `boolean add(E e)`                          | boolean         | Adds element `e` to the collection. <br>✅ `collection.add("Apple");` |
| `boolean addAll(Collection<? extends E> c)` | boolean         | Adds all elements from another collection `c`.                        |
| `void clear()`                              | void            | Removes all elements from the collection.                             |
| `boolean contains(Object o)`                | boolean         | Checks if element `o` exists. <br>✅ `collection.contains("Apple");`  |
| `boolean containsAll(Collection<?> c)`      | boolean         | Checks if collection contains all elements in `c`.                    |
| `boolean isEmpty()`                         | boolean         | Returns true if collection has no elements.                           |
| `Iterator<E> iterator()`                    | Iterator        | Returns an iterator to traverse the collection.                       |
| `boolean remove(Object o)`                  | boolean         | Removes a single instance of specified element `o`.                   |
| `boolean removeAll(Collection<?> c)`        | boolean         | Removes all elements that are also in `c`.                            |
| `boolean retainAll(Collection<?> c)`        | boolean         | Keeps only the elements that are also in `c`.                         |
| `int size()`                                | int             | Returns the number of elements in the collection.                     |
| `Object[] toArray()`                        | Object[]        | Converts collection to an array.                                      |
| `<T> T[] toArray(T[] a)`                    | T[]             | Converts collection to an array of specified type.                    |
| `default Stream<E> stream()`                | Stream          | Returns a sequential stream (Java 8+).                                |
| `default Stream<E> parallelStream()`        | Stream          | Returns a parallel stream (Java 8+).                                  |

---

### **5. Example Usage**

```java
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Collection<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        // Display elements
        System.out.println("Fruits: " + fruits);

        // Check if contains an element
        System.out.println("Contains Mango? " + fruits.contains("Mango"));

        // Remove an element
        fruits.remove("Banana");
        System.out.println("After removal: " + fruits);

        // Iterate over elements
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Size of collection
        System.out.println("Total fruits: " + fruits.size());
    }
}
```

**Output:**

```
Fruits: [Apple, Banana, Mango]
Contains Mango? true
After removal: [Apple, Mango]
Apple
Mango
Total fruits: 2
```

---

### **6. Summary**

- The **Collection interface** provides the **foundation** for all collection classes.
- Defines **common operations** such as adding, removing, checking membership, and iteration.
- Specialized interfaces (`List`, `Set`, `Queue`) extend it to provide additional features.

---
