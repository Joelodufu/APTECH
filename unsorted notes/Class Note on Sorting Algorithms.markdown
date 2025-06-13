# Class Note: Designing Algorithms, Pseudocode, and Flowcharts for Major Sorting Algorithms

This note introduces five major sorting algorithms: Bubble Sort, Selection Sort, Insertion Sort, Merge Sort, and Quick Sort. For each algorithm, we provide a description, pseudocode, time complexity, and a flowchart description to aid in understanding the algorithm's flow.

## 1. Bubble Sort
### Description
Bubble Sort is a simple comparison-based sorting algorithm. It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The process continues until no swaps are needed, indicating the list is sorted.

### Time Complexity
- Best Case: O(n) (when the array is already sorted)
- Average Case: O(n²)
- Worst Case: O(n²)

### Pseudocode
```
BubbleSort(arr, n)
    for i from 0 to n-1
        swapped = false
        for j from 0 to n-i-2
            if arr[j] > arr[j+1]
                swap arr[j] and arr[j+1]
                swapped = true
        if swapped == false
            break
    return arr
```

### Flowchart Description
1. **Start**: Begin the process.
2. **Initialize**: Set `i = 0` and `swapped = false`.
3. **Outer Loop Check**: If `i < n`, proceed; else, end.
4. **Inner Loop**: For `j = 0` to `n-i-2`, compare `arr[j]` and `arr[j+1]`.
5. **Decision**: If `arr[j] > arr[j+1]`, swap them and set `swapped = true`.
6. **Check Swapped**: After the inner loop, if `swapped = false`, end; else, increment `i` and repeat.
7. **End**: Return the sorted array.

## 2. Selection Sort
### Description
Selection Sort divides the array into sorted and unsorted parts. In each iteration, it finds the minimum element in the unsorted part and places it at the beginning of the sorted part.

### Time Complexity
- Best Case: O(n²)
- Average Case: O(n²)
- Worst Case: O(n²)

### Pseudocode
```
SelectionSort(arr, n)
    for i from 0 to n-1
        min_idx = i
        for j from i+1 to n-1
            if arr[j] < arr[min_idx]
                min_idx = j
        swap arr[i] and arr[min_idx]
    return arr
```

### Flowchart Description
1. **Start**: Begin the process.
2. **Initialize**: Set `i = 0`.
3. **Outer Loop Check**: If `i < n`, proceed; else, end.
4. **Set Minimum**: Set `min_idx = i`.
5. **Inner Loop**: For `j = i+1` to `n-1`, compare `arr[j]` with `arr[min_idx]`.
6. **Decision**: If `arr[j] < arr[min_idx]`, update `min_idx = j`.
7. **Swap**: After the inner loop, swap `arr[i]` and `arr[min_idx]`.
8. **Increment**: Increment `i` and repeat.
9. **End**: Return the sorted array.

## 3. Insertion Sort
### Description
Insertion Sort builds the sorted array one element at a time by taking an element from the unsorted part and inserting it into the correct position in the sorted part.

### Time Complexity
- Best Case: O(n) (when the array is already sorted)
- Average Case: O(n²)
- Worst Case: O(n²)

### Pseudocode
```
InsertionSort(arr, n)
    for i from 1 to n-1
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key
            arr[j+1] = arr[j]
            j = j - 1
        arr[j+1] = key
    return arr
```

### Flowchart Description
1. **Start**: Begin the process.
2. **Initialize**: Set `i = 1`.
3. **Outer Loop Check**: If `i < n`, proceed; else, end.
4. **Set Key**: Store `key = arr[i]` and `j = i - 1`.
5. **Inner Loop**: While `j >= 0` and `arr[j] > key`, shift `arr[j]` to `arr[j+1]` and decrement `j`.
6. **Insert**: Place `key` at `arr[j+1]`.
7. **Increment**: Increment `i` and repeat.
8. **End**: Return the sorted array.

## 4. Merge Sort
### Description
Merge Sort is a divide-and-conquer algorithm. It recursively divides the array into two halves, sorts each half, and then merges the sorted halves to produce a fully sorted array.

### Time Complexity
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n log n)

### Pseudocode
```
MergeSort(arr, left, right)
    if left < right
        mid = (left + right) / 2
        MergeSort(arr, left, mid)
        MergeSort(arr, mid+1, right)
        Merge(arr, left, mid, right)
    return arr

Merge(arr, left, mid, right)
    n1 = mid - left + 1
    n2 = right - mid
    Create arrays L[n1] and R[n2]
    for i from 0 to n1-1
        L[i] = arr[left + i]
    for j from 0 to n2-1
        R[j] = arr[mid + 1 + j]
    i = 0, j = 0, k = left
    while i < n1 and j < n2
        if L[i] <= R[j]
            arr[k] = L[i]
            i = i + 1
        else
            arr[k] = R[j]
            j = j + 1
        k = k + 1
    while i < n1
        arr[k] = L[i]
        i = i + 1
        k = k + 1
    while j < n2
        arr[k] = R[j]
        j = j + 1
        k = k + 1
```

### Flowchart Description
1. **Start**: Begin the process.
2. **Check**: If `left < right`, proceed; else, return.
3. **Divide**: Calculate `mid = (left + right) / 2`.
4. **Recurse Left**: Call `MergeSort(arr, left, mid)`.
5. **Recurse Right**: Call `MergeSort(arr, mid+1, right)`.
6. **Merge**: Call `Merge(arr, left, mid, right)`:
   - Create arrays `L` and `R` for left and right halves.
   - Copy elements to `L` and `R`.
   - Compare elements from `L` and `R`, merging them back into `arr` in sorted order.
   - Copy remaining elements from `L` or `R` if any.
7. **End**: Return the sorted array.

## 5. Quick Sort
### Description
Quick Sort is a divide-and-conquer algorithm that selects a pivot, partitions the array around it, and recursively sorts the sub-arrays. The pivot can be chosen in various ways (e.g., first element, last element, or random).

### Time Complexity
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n²) (when the array is already sorted or reverse sorted)

### Pseudocode
```
QuickSort(arr, low, high)
    if low < high
        pi = Partition(arr, low, high)
        QuickSort(arr, low, pi-1)
        QuickSort(arr, pi+1, high)
    return arr

Partition(arr, low, high)
    pivot = arr[high]
    i = low - 1
    for j from low to high-1
        if arr[j] <= pivot
            i = i + 1
            swap arr[i] and arr[j]
    swap arr[i+1] and arr[high]
    return i+1
```

### Flowchart Description
1. **Start**: Begin the process.
2. **Check**: If `low < high`, proceed; else, return.
3. **Partition**: Call `Partition(arr, low, high)`:
   - Set `pivot = arr[high]` and `i = low - 1`.
   - For `j = low` to `high-1`, if `arr[j] <= pivot`, increment `i` and swap `arr[i]` with `arr[j]`.
   - Swap `arr[i+1]` with `arr[high]`.
   - Return `i+1` as the partition index.
4. **Recurse Left**: Call `QuickSort(arr, low, pi-1)`.
5. **Recurse Right**: Call `QuickSort(arr, pi+1, high)`.
6. **End**: Return the sorted array.

## Summary Table
| Algorithm       | Best Case | Average Case | Worst Case | Space Complexity | Stable? |
|-----------------|-----------|--------------|------------|------------------|---------|
| Bubble Sort     | O(n)      | O(n²)        | O(n²)      | O(1)             | Yes     |
| Selection Sort  | O(n²)     | O(n²)        | O(n²)      | O(1)             | No      |
| Insertion Sort  | O(n)      | O(n²)        | O(n²)      | O(1)             | Yes     |
| Merge Sort      | O(n log n)| O(n log n)   | O(n log n) | O(n)             | Yes     |
| Quick Sort      | O(n log n)| O(n log n)   | O(n²)      | O(log n)         | No      |

## Notes for Flowchart Creation
- Use standard flowchart symbols: ovals for start/end, diamonds for decisions, rectangles for processes, and arrows for flow.
- Ensure each algorithm’s flowchart clearly shows the iterative or recursive nature of the process.
- For recursive algorithms (Merge Sort, Quick Sort), represent recursive calls as subprocesses that loop back to the main function.
- Label all decision points and processes clearly to reflect the pseudocode logic.