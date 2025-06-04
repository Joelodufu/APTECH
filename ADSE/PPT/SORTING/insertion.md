Absolutely, Joel! Let's go through **Insertion Sort** just like we did for Selection Sort—step-by-step, with full comments and easy-to-understand code.

---

## 🧠 1. **Insertion Sort Algorithm (Plain English)**

**Main idea**: Build the sorted array one item at a time, just like how you might sort playing cards in your hand.

### How it works:

1. Start from the **second element** (index 1).
2. Compare it with the elements before it.
3. Shift larger elements **one position to the right**.
4. Insert the current element into its correct sorted position.

Example with `[29, 10, 14, 37, 13]`:

* Start with `10`: place it before `29` → `[10, 29, 14, 37, 13]`
* Then `14`: place it between `10` and `29` → `[10, 14, 29, 37, 13]`
* Continue until all elements are in order.

---

## ⏱ 2. **Time Complexity**

| Case                  | Time Complexity | Meaning                                |
| --------------------- | --------------- | -------------------------------------- |
| Best (already sorted) | **O(n)**        | Only compares once per item            |
| Worst (reverse order) | **O(n²)**       | Shifts almost everything each time     |
| Space                 | **O(1)**        | In-place                               |
| Stable?               | ✅ Yes           | Doesn’t change order of equal elements |

> Insertion sort is **faster than Selection Sort** for nearly-sorted arrays.

---

## 📋 3. **Pseudocode**

```
procedure insertionSort(A)
    for i from 1 to length(A) - 1
        key = A[i]
        j = i - 1
        while j >= 0 and A[j] > key
            A[j + 1] = A[j]
            j = j - 1
        A[j + 1] = key
```

---

## 💻 4. C Program with FULL Comments

```c
#include <stdio.h>

// Function to perform Insertion Sort
void insertionSort(int arr[], int n) {
    int i, key, j;

    // Loop through each element starting from the second one
    for (i = 1; i < n; i++) {
        key = arr[i];  // Current element to insert into the sorted part
        j = i - 1;

        // Shift elements of arr[0..i-1] that are greater than key
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];  // Move larger element one step right
            j = j - 1;
        }

        // Place the key at its correct position
        arr[j + 1] = key;
    }
}

// Function to print array
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int arr[] = {29, 10, 14, 37, 13};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original array:\n");
    printArray(arr, n);

    insertionSort(arr, n);  // Call the sort function

    printf("Sorted array:\n");
    printArray(arr, n);

    return 0;
}
```

---

## 🌐 5. JavaScript Program with FULL Comments

```javascript
function insertionSort(arr) {
    const n = arr.length;

    // Loop from second element to the end
    for (let i = 1; i < n; i++) {
        let key = arr[i];  // The current number to place correctly
        let j = i - 1;

        // Move elements greater than key one position to the right
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]; // Shift element
            j--; // Move left
        }

        // Place the key in the right spot
        arr[j + 1] = key;
    }

    return arr;
}

// Example usage:
const array = [29, 10, 14, 37, 13];

console.log("Original array:", array);

const sorted = insertionSort([...array]); // Copy and sort
console.log("Sorted array:", sorted);
```

---

## ✅ Summary Table

| Feature    | Insertion Sort                 |
| ---------- | ------------------------------ |
| Best Time  | O(n) (almost sorted)           |
| Worst Time | O(n²)                          |
| Space      | O(1)                           |
| Stable     | ✅ Yes                          |
| Use When   | Data is nearly sorted or small |

---

