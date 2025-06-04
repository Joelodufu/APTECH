
1. **Understanding Time Complexity**
2. **Clear, step-by-step explanation of the algorithm**
3. **Commented and easy-to-follow C and JavaScript programs**

---

## 📌 **1. What is Time Complexity? (Simple Explanation)**

Time complexity tells us **how fast an algorithm runs** as the **input size (n)** increases.

Imagine sorting:

* 10 items – quick
* 1,000 items – slower
* 1,000,000 items – much slower

### For Selection Sort:

* It always goes through the list again and again to find the smallest item, even if it's already sorted.
* It takes about `n * (n - 1) / 2` comparisons (that's **O(n²)**).

So:

* ✅ **Good for small lists**
* ❌ **Bad for large lists**

> Think of **O(n²)** as "the time it takes grows like n times n"

---

## 🧠 **2. Step-by-Step Algorithm (Plain English)**

Suppose we have an array: `[29, 10, 14, 37, 13]`

### Step-by-step:

1. Look at the whole list and find the smallest number → `10`
2. Swap it with the first item → `[10, 29, 14, 37, 13]`
3. Now, ignore the first item (it's sorted). Look at the rest.
4. Find the smallest from the rest → `13`, swap with `29` → `[10, 13, 14, 37, 29]`
5. Keep doing that until the list is sorted.

---

## 💻 **3. C Program with FULL Comments**

```c
#include <stdio.h>

// Function to perform Selection Sort
void selectionSort(int arr[], int n) {
    int i, j, minIdx, temp;

    // Loop over each element except the last one
    for (i = 0; i < n - 1; i++) {
        minIdx = i; // Assume the current i is the smallest

        // Loop to find the actual smallest element in the rest of the array
        for (j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j; // Update minIdx if we find a smaller element
            }
        }

        // Swap the smallest found with the element at index i
        temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;

        // At this point, arr[0..i] is sorted
    }
}

// Function to print the array
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++)
        printf("%d ", arr[i]); // Print each element
    printf("\n");
}

int main() {
    int arr[] = {29, 10, 14, 37, 13};
    int n = sizeof(arr) / sizeof(arr[0]); // Calculate number of elements

    printf("Original array:\n");
    printArray(arr, n);

    selectionSort(arr, n); // Call selection sort

    printf("Sorted array:\n");
    printArray(arr, n);

    return 0;
}
```

---

## 🌐 **4. JavaScript Program with FULL Comments**

```javascript
// Function to perform Selection Sort
function selectionSort(arr) {
    const n = arr.length;

    // Outer loop: goes from index 0 to second last index
    for (let i = 0; i < n - 1; i++) {
        let minIndex = i; // Assume current index i has the smallest value

        // Inner loop: check from i+1 to end of array
        for (let j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j; // Update if a smaller value is found
            }
        }

        // Swap the smallest found with arr[i]
        let temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;

        // After each pass, arr[0..i] is sorted
    }

    return arr; // Return the sorted array
}
// Example usage:
const array = [29, 10, 14, 37, 13];

console.log("Original array:", array);

const sorted = selectionSort([...array]); // Make a copy and sort
console.log("Sorted array:", sorted);
```

---

## ✅ Summary

| Item                      | Meaning                                               |
| ------------------------- | ----------------------------------------------------- |
| **Selection Sort**        | Repeatedly find the smallest and move it to the front |
| **Time Complexity O(n²)** | It checks every other element again and again         |
| **Good for**              | Small arrays                                          |
| **Bad for**               | Large datasets                                        |
| **In-place**              | Doesn’t use extra memory                              |
| **Stable?**               | No (can change order of equal elements)               |

---