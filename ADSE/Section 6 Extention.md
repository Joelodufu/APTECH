### Advanced Class Notes: Advanced Looping Techniques (Extension for Section 6)

#### Overview
This advanced note extends Section 6 ("Decision Making and Looping") by exploring sophisticated looping techniques in C, including nested loops, loop optimization, and best practices for selecting the appropriate loop type (`while`, `do-while`, `for`). It builds on prior knowledge to tackle complex problems and optimize code efficiency.

#### Learning Objectives
- Master nested loops for multi-dimensional tasks.
- Optimize loops using control statements and conditions.
- Understand when to use `while`, `do-while`, or `for` loops based on problem requirements.
- Apply advanced looping to real-world scenarios.

---

### Key Concepts

#### 1. Nested Loops
- **Definition**: A loop inside another loop, useful for multi-level iterations (e.g., matrices, patterns).
- **Example**: Printing a 5x5 grid.
  ```c
  #include <stdio.h>
  int main() {
      for (int i = 1; i <= 5; i++) {
          for (int j = 1; j <= 5; j++) {
              printf("%d ", i * j);
          }
          printf("\n");
      }
      return 0;
  }
  ```
- **Use Case**: Ideal for 2D arrays or grid-based problems.

#### 2. Loop Optimization
- **Early Exit**: Use `break` to terminate loops when a condition is met, avoiding unnecessary iterations.
- **Skip Logic**: Use `continue` to bypass specific iterations efficiently.
- **Example**: Finding the first even number.
  ```c
  #include <stdio.h>
  int main() {
      int arr[] = {1, 3, 4, 7, 8};
      for (int i = 0; i < 5; i++) {
          if (arr[i] % 2 == 0) {
              printf("First even number: %d\n", arr[i]);
              break;
          }
      }
      return 0;
  }
  ```

#### 3. Best Cases for Loop Types
- **For Loops**:
  - **Best Used When**: 
    1. The number of iterations is known beforehand (e.g., printing a fixed range like 1 to 10).
    2. Iterating over arrays or collections with a defined size (e.g., summing array elements).
    3. Generating patterns or tables (e.g., multiplication tables).
    4. When initialization, condition, and increment can be managed in one line for clarity.
  - **Example**: `for (int i = 0; i < 5; i++)` for array traversal.
- **While Loops**:
  - **Best Used When**: The number of iterations is unknown or depends on dynamic conditions (e.g., reading input until a sentinel value like -1).
  - **Example**: `while (input != -1)` for continuous user input.
- **Do-While Loops**:
  - **Best Used When**: The loop body must execute at least once before checking the condition (e.g., menu systems or input validation).
  - **Example**: `do { scanf("%d", &num); } while (num <= 0);` for ensuring positive input.

---

### Advanced Examples

#### Example 1: Nested Loop - Pascal’s Triangle
```c
#include <stdio.h>
int main() {
    int rows = 5, coef = 1;
    for (int i = 0; i < rows; i++) {
        for (int space = 1; space <= rows - i; space++) {
            printf("  ");
        }
        for (int j = 0; j <= i; j++) {
            if (j == 0 || i == j) {
                coef = 1;
            } else {
                coef = coef * (i - j + 1) / j;
            }
            printf("%4d", coef);
        }
        printf("\n");
    }
    return 0;
}
```
**Output**: Prints the first 5 rows of Pascal’s Triangle.  
**Explanation**: Nested loops handle spacing and coefficient calculations.

#### Example 2: Optimized Loop - Search with Break
```c
#include <stdio.h>
int main() {
    int arr[] = {3, 15, 7, 12, 9};
    int target = 12;
    for (int i = 0; i < 5; i++) {
        if (arr[i] == target) {
            printf("Found at index %d\n", i);
            break;
        }
    }
    return 0;
}
```
**Explanation**: `break` stops the loop upon finding the target, improving efficiency.

---

### Classwork

#### Task 1: Nested Loop - Star Pyramid
Write a program to print a pyramid of stars with a user-specified height using nested `for` loops.

**Expected Output** (for height 4):
```
   *
  ***
 *****
*******
```

#### Task 2: Optimized Loop - GCD Finder
Write a program to find the Greatest Common Divisor (GCD) of two numbers using a `while` loop with an early `break`.

#### Task 3: Loop Selection Practice
For each scenario, choose the best loop type and justify:
- Printing numbers 1 to 100.
- Validating user input until a positive number is entered.
- Summing elements of a 10-element array.

---

### Real-World Applications

#### Application 1: Data Processing Pipeline
**Context**: Process a list of transactions until an end marker is found.
```c
#include <stdio.h>
int main() {
    int transaction;
    while (1) {
        scanf("%d", &transaction);
        if (transaction == -1) break;
        if (transaction > 0) printf("Valid transaction: %d\n", transaction);
    }
    return 0;
}
```
**Discussion**: `while` with `break` suits dynamic input termination.

#### Application 2: Game Loop
**Context**: A game loop runs until the player quits.
```c
#include <stdio.h>
int main() {
    char choice;
    do {
        printf("Play again? (y/n): ");
        scanf(" %c", &choice);
    } while (choice == 'y' || choice == 'Y');
    printf("Game ended\n");
    return 0;
}
```
**Discussion**: `do-while` ensures at least one game iteration.

---

### Discussion Points

#### Question 1: Nested Loop Efficiency
How can you optimize a nested loop to reduce execution time?
**Answer**: Limit inner loop range or use `break` on early conditions.

#### Question 2: Loop Selection
Why is a `for` loop preferred for array iteration over `while`?
**Answer**: `for` consolidates initialization and increment, making it more readable and less error-prone.

#### Question 3: Design Challenge
Write a program to print a 5x5 magic square using nested loops (hint: adjust numbers to sum to 15 in each row, column, and diagonal).
**Solution**: Involves careful number placement in a 2D array.

---

### Additional Notes
- **Practice**: Experiment with loop unrolling or reducing iterations for performance.
- **Extension**: Explore loop-invariant code motion or parallel loops in advanced contexts.

These advanced notes enhance looping skills with practical insights and optimal use cases, preparing students for complex programming challenges. Let me know if you'd like further details!