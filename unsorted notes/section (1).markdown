# Class Note: Introduction to C Programming (Section 1)

## Overview
This section introduces the fundamentals of programming with a focus on C, one of the most influential programming languages. It covers the importance of algorithms and pseudocode for problem-solving, the structure of a C program, and basic programming concepts. As of May 14, 2025, this note reflects current teaching practices to prepare students for practical coding.

## Learning Objectives
- Understand the role of algorithms and pseudocode in programming.
- Learn the basic structure and components of a C program.
- Grasp the concept of problem-solving using step-by-step logic.
- Prepare for hands-on coding by exploring simple examples.

---

## Key Concepts

### 1. What is Programming?
- **Definition**: Writing instructions for a computer to perform tasks.
- **C Language**: A structured, efficient language developed in the 1970s, widely used for system programming and applications.

### 2. Algorithms
- **Definition**: A step-by-step procedure to solve a problem.
- **Characteristics**: Clear, finite, effective, and generalizable.
- **Example**: Algorithm to add two numbers:
  1. Take two numbers as input.
  2. Add the numbers to get the sum.
  3. Display the sum.

### 3. Pseudocode
- **Definition**: A high-level, language-independent description of an algorithm.
- **Purpose**: Helps plan logic before writing code.
- **Example**:
  ```
  INPUT firstNumber, secondNumber
  SET sum = firstNumber + secondNumber
  OUTPUT sum
  ```

### 4. Structure of a C Program
- **Components**:
  - **Preprocessor Directives**: `#include <stdio.h>` (includes standard input-output library).
  - **Main Function**: `int main()` (entry point of the program).
  - **Statements**: Code executed within `{}`.
  - **Return Statement**: `return 0;` indicates successful execution.
- **Basic Template**:
  ```c
  #include <stdio.h>
  int main() {
      // Code here
      return 0;
  }
  ```

### 5. First C Program
- A simple program to print a message.

---

## Examples

### Example 1: Hello World Program
```c
#include <stdio.h>
int main() {
    printf("Hello, World! Today is May 14, 2025!\n");
    return 0;
}
```
**Output**:
```
Hello, World! Today is May 14, 2025!
```
**Explanation**: Uses `printf` to display a message, reflecting the current date.

### Example 2: Pseudocode to C - Sum of Two Numbers
**Pseudocode**:
```
INPUT num1, num2
SET sum = num1 + num2
OUTPUT sum
```
**C Code**:
```c
#include <stdio.h>
int main() {
    int num1, num2, sum;
    printf("Enter two numbers: ");
    scanf("%d %d", &num1, &num2);
    sum = num1 + num2;
    printf("Sum: %d\n", sum);
    return 0;
}
```
**Output** (for inputs 5 and 3):
```
Enter two numbers: 5 3
Sum: 8
```
**Explanation**: Converts pseudocode logic into a working C program.

### Example 3: Algorithm with Decision (Even or Odd)
**Pseudocode**:
```
INPUT number
IF number % 2 == 0 THEN
    OUTPUT "Even"
ELSE
    OUTPUT "Odd"
ENDIF
```
**C Code**:
```c
#include <stdio.h>
int main() {
    int number;
    printf("Enter a number: ");
    scanf("%d", &number);
    if (number % 2 == 0) {
        printf("Even\n");
    } else {
        printf("Odd\n");
    }
    return 0;
}
```
**Output** (for input 4):
```
Enter a number: 4
Even
```
**Explanation**: Implements a decision-making algorithm in C.

---

## Classwork

### Task 1: Write Pseudocode
Write pseudocode to find the average of three numbers input by the user.

### Task 2: Convert to C Program
Convert the pseudocode from Task 1 into a C program that calculates and prints the average.

### Task 3: Simple Calculator Pseudocode
Write pseudocode for a program that takes two numbers and an operator (+, -, *, /) as input and performs the calculation.

### Task 4: Implement Calculator in C
Convert the pseudocode from Task 3 into a C program using `if-else` statements to handle the operations.

---

## Real-World Applications

### Application 1: Basic Inventory Tracker
**Context**: A small store tracks the total cost of items.
**Pseudocode**:
```
INPUT item1, item2
SET total = item1 + item2
OUTPUT total
```
**C Code**:
```c
#include <stdio.h>
int main() {
    float item1, item2, total;
    printf("Enter cost of item 1: ");
    scanf("%f", &item1);
    printf("Enter cost of item 2: ");
    scanf("%f", &item2);
    total = item1 + item2;
    printf("Total cost: %.2f\n", total);
    return 0;
}
```
**Output** (for inputs 10.50 and 20.75):
```
Enter cost of item 1: 10.50
Enter cost of item 2: 20.75
Total cost: 31.25
```
**Discussion**: Shows how basic algorithms translate to real-world tasks.

### Application 2: Daily Log Entry
**Context**: Log the current date and a user’s activity (as of May 14, 2025).
```c
#include <stdio.h>
int main() {
    char activity[50];
    printf("Enter your activity for May 14, 2025: ");
    scanf("%s", activity);
    printf("Activity logged: %s on May 14, 2025\n", activity);
    return 0;
}
```
**Output** (for input "Studying"):
```
Enter your activity for May 14, 2025: Studying
Activity logged: Studying on May 14, 2025
```
**Discussion**: Introduces input handling with a current date context.

---

## Objective Questions

1. **What is the purpose of an algorithm?**
   a) To write C code  
   b) To provide a step-by-step solution to a problem  
   c) To compile a program  
   d) To debug code  
   **Answer**: b) To provide a step-by-step solution to a problem

2. **Which of the following is a valid C program entry point?**
   a) `start()`  
   b) `int main()`  
   c) `begin()`  
   d) `run()`  
   **Answer**: b) `int main()`

3. **What does pseudocode represent?**
   a) Machine code  
   b) A high-level description of an algorithm  
   c) Compiled C code  
   d) A flowchart  
   **Answer**: b) A high-level description of an algorithm

4. **What is the output of the following code?**
   ```c
   #include <stdio.h>
   int main() {
       printf("Hello");
       return 0;
   }
   ```
   a) Hello 0  
   b) Hello  
   c) Error  
   d) Nothing  
   **Answer**: b) Hello

5. **Which directive is used to include the standard input-output library in C?**
   a) `#define`  
   b) `#include <stdio.h>`  
   c) `#import`  
   d) `#library`  
   **Answer**: b) `#include <stdio.h>`

---

## Additional Notes
- **Practice**: Experiment with different inputs to understand program behavior.
- **Tools**: Use NetBeans to run and test these programs.
- **Extension**: Explore flowcharts or more complex algorithms in future sessions.