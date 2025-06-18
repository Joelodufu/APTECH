# Class Note: Subroutines (Session 9)

## Overview

Subroutines are modular blocks of code that perform specific tasks, enhancing program organization, reusability, and maintainability. This session introduces subroutines, focusing on **procedures** (task-oriented) and **functions** (return value-oriented) in pseudocode, with flowchart visualizations. By the end of this class, you will be able to define and call subroutines, pass parameters, return values, and create flowcharts for subroutine-based algorithms, applying structured programming principles.

## Learning Objectives

- Understand the purpose and types of subroutines (procedures and functions).
- Define and call subroutines in pseudocode.
- Use parameters and return values effectively.
- Integrate subroutines with arrays, loops, and selection constructs.
- Design flowcharts and pseudocode for subroutine-based solutions to practical problems.

## Key Concepts

1. **What Are Subroutines?**

   - A subroutine is a named block of code designed to perform a specific task, called from multiple parts of a program.
   - **Types**:
     - **Procedures**: Perform tasks (e.g., display output) without returning a value.
     - **Functions**: Perform tasks and return a value (e.g., calculate a result).
   - Example: A procedure to print a menu or a function to compute the square of a number.
   - Benefits: Modularity, reusability, reduced code duplication, easier debugging.

2. **Defining Subroutines**

   - **Procedure Syntax**:
     ```
     PROCEDURE ProcedureName(parameter1, parameter2, ...)
         // Statements
     END PROCEDURE
     ```
   - **Function Syntax**:
     ```
     FUNCTION FunctionName(parameter1, parameter2, ...) RETURNS dataType
         // Statements
         RETURN value
     END FUNCTION
     ```
   - Parameters are optional inputs passed to the subroutine.
   - Example: `PROCEDURE DisplayGreeting(name)` or `FUNCTION Square(number) RETURNS INTEGER`.

3. **Calling Subroutines**

   - **Procedure Call**: `CALL ProcedureName(argument1, argument2, ...)`
   - **Function Call**: `SET result = FunctionName(argument1, argument2, ...)`
   - Arguments are actual values passed to parameters.
   - Example: `CALL DisplayGreeting("Alice")` or `SET result = Square(5)`.

4. **Parameters**

   - **Types**:
     - **By Value**: A copy of the argument is passed; changes don’t affect the original.
     - **By Reference**: The original argument is passed; changes affect the original (not covered in depth here).
   - Example: In `PROCEDURE UpdateScore(score)`, `score` is typically passed by value.
   - Parameters allow subroutines to work with different inputs.

5. **Return Values**

   - Functions return a value using `RETURN`.
   - Example: `FUNCTION Square(number) RETURNS INTEGER` returns `number * number`.
   - Procedures do not return values but may modify outputs via parameters or global variables.

6. **Subroutines with Arrays**

   - Arrays can be passed as parameters to process multiple values.
   - Example: A function to find the maximum value in an array.
   - Combines with loops for efficient processing.

7. **Flowchart Representation**

   - **Subroutine Block**: A rectangle with double vertical lines or a labeled box (e.g., “Call ProcedureName”).
   - **Parameters**: Indicated in the call (e.g., “Call CalculateSum(arr)”).
   - **Return**: Shown as an output or arrow returning to the main flow.
   - **Main vs. Subroutine Flowcharts**: Separate flowcharts for main program and each subroutine.

8. **Structured Programming Principles**
   - Subroutines promote **modularity** (breaking programs into smaller, reusable units).
   - Use **top-down design**: Define main tasks, then implement subroutines.
   - Ensure **single entry, single exit** for clarity.
   - Combine with control structures (sequence, selection, iteration) for robust solutions.

## Examples

1. **Procedure to Display Array Elements**

   - **Problem**: Create a procedure to display all elements of an array of 4 integers.
   - **Pseudocode**:

     ```
     PROCEDURE DisplayArray(arr[4])
         FOR i = 0 TO 3
             OUTPUT arr[i]
         END FOR
     END PROCEDURE

     DECLARE numbers[4] OF INTEGER
     START
     OUTPUT "Enter 4 numbers:"
     FOR i = 0 TO 3
         INPUT numbers[i]
     END FOR
     CALL DisplayArray(numbers)
     END
     ```

   - **Flowchart** (main, text-based):
     ```
     [Start] → [DECLARE numbers[4]] → [Output "Enter 4 numbers:"] → [i = 0] → [i <= 3?] → Yes → [Input numbers[i]] → [i = i + 1] → [Back to i <= 3?]
                                                    ↓ No
                                               [Call DisplayArray(numbers)] → [End]
     ```
     - **DisplayArray Flowchart**:
       ```
       [Start DisplayArray] → [i = 0] → [i <= 3?] → Yes → [Output arr[i]] → [i = i + 1] → [Back to i <= 3?]
                                          ↓ No
                                       [End DisplayArray]
       ```
   - **Explanation**: The procedure modularizes array output, called after inputting values.

2. **Function to Calculate Cube**

   - **Problem**: Write a function to calculate the cube of a number and use it in a program.
   - **Pseudocode**:

     ```
     FUNCTION Cube(number) RETURNS INTEGER
         SET result = number * number * number
         RETURN result
     END FUNCTION

     START
     INPUT num
     SET cubed = Cube(num)
     OUTPUT "Cube of ", num, " is ", cubed
     END
     ```

   - **Flowchart** (main, text-based):
     ```
     [Start] → [Input num] → [Call Cube(num)] → [Output "Cube of ", num, " is ", cubed] → [End]
     ```
     - **Cube Flowchart**:
       ```
       [Start Cube] → [result = number * number * number] → [Return result] → [End Cube]
       ```
   - **Explanation**: The function returns the cube, which is used in the main program to display the result.

3. **Procedure to Swap Array Elements**

   - **Problem**: Create a procedure to swap two elements in an array at user-specified indices.
   - **Pseudocode**:

     ```
     PROCEDURE SwapElements(arr[5], index1, index2)
         SET temp = arr[index1]
         SET arr[index1] = arr[index2]
         SET arr[index2] = temp
     END PROCEDURE

     DECLARE values[5] OF INTEGER
     START
     OUTPUT "Enter 5 values:"
     FOR i = 0 TO 4
         INPUT values[i]
     END FOR
     OUTPUT "Enter two indices (0-4):"
     INPUT index1, index2
     CALL SwapElements(values, index1, index2)
     OUTPUT "Array after swap:"
     FOR i = 0 TO 4
         OUTPUT values[i]
     END FOR
     END
     ```

   - **Flowchart** (main, text-based):
     ```
     [Start] → [DECLARE values[5]] → [Output "Enter 5 values:"] → [i = 0] → [i <= 4?] → Yes → [Input values[i]] → [i = i + 1] → [Back to i <= 4?]
                                                ↓ No
                                           [Output "Enter two indices (0-4):"] → [Input index1, index2] → [Call SwapElements(values, index1, index2)] → [Output "Array after swap:"] → [i = 0] → [i <= 4?] → Yes → [Output values[i]] → [i = i + 1] → [Back to i <= 4?]
                                                                                                                                                                                                 ↓ No
                                                                                                                                                                                              [End]
     ```
     - **SwapElements Flowchart**:
       ```
       [Start SwapElements] → [temp = arr[index1]] → [arr[index1] = arr[index2]] → [arr[index2] = temp] → [End SwapElements]
       ```
   - **Explanation**: The procedure swaps elements using a temporary variable, modifying the array directly.

4. **Function to Find Array Average**

   - **Problem**: Write a function to calculate the average of an array of 6 floating-point numbers and count values above average using a procedure.
   - **Pseudocode**:

     ```
     FUNCTION CalculateAverage(arr[6]) RETURNS FLOAT
         SET sum = 0
         FOR i = 0 TO 5
             sum = sum + arr[i]
         END FOR
         RETURN sum / 6
     END FUNCTION

     PROCEDURE CountAboveAverage(arr[6], avg)
         SET count = 0
         FOR i = 0 TO 5
             IF arr[i] > avg THEN
                 count = count + 1
             END IF
         END FOR
         OUTPUT "Values above average: ", count
     END PROCEDURE

     DECLARE scores[6] OF FLOAT
     START
     OUTPUT "Enter 6 scores:"
     FOR i = 0 TO 5
         INPUT scores[i]
     END FOR
     SET avg = CalculateAverage(scores)
     OUTPUT "Average score: ", avg
     CALL CountAboveAverage(scores, avg)
     END
     ```

   - **Flowchart** (main, text-based):
     ```
     [Start] → [DECLARE scores[6]] → [Output "Enter 6 scores:"] → [i = 0] → [i <= 5?] → Yes → [Input scores[i]] → [i = i + 1] → [Back to i <= 5?]
                                                ↓ No
                                           [Call CalculateAverage] → [Output "Average score: ", avg] → [Call CountAboveAverage(scores, avg)] → [End]
     ```
     - **CalculateAverage Flowchart**:
       ```
       [Start CalculateAverage] → [sum = 0, i = 0] → [i <= 5?] → Yes → [sum = sum + arr[i]] → [i = i + 1] → [Back to i <= 5?]
                                               ↓ No
                                          [Return sum / 6] → [End CalculateAverage]
       ```
     - **CountAboveAverage Flowchart**:
       ```
       [Start CountAboveAverage] → [count = 0, i = 0] → [i <= 5?] → Yes → [arr[i] > avg?] → Yes → [count = count + 1] → [i = i + 1] → [Back to i <= 5?]
                                                     ↓ No                             ↓ No                        ↓
                                                [Output "Values above average: ", count] → [End CountAboveAverage] [i = i + 1] → [Back to i <= 5?]
       ```
   - **Explanation**: Combines a function for average calculation with a procedure to count elements above it, showcasing parameter passing and modularity.

## Classwork Activities

1. **Pseudocode Writing**:

   - **Task**: Write pseudocode for a procedure that reverses the elements of an array of 5 integers (e.g., [1, 2, 3, 4, 5] becomes [5, 4, 3, 2, 1]).
   - **Expected Pseudocode**:

     ```
     PROCEDURE ReverseArray(arr[5])
         FOR i = 0 TO 2
             SET temp = arr[i]
             SET arr[i] = arr[4 - i]
             SET arr[4 - i] = temp
         END FOR
     END PROCEDURE

     DECLARE numbers[5] OF INTEGER
     START
     OUTPUT "Enter 5 numbers:"
     FOR i = 0 TO 4
         INPUT numbers[i]
     END FOR
     CALL ReverseArray(numbers)
     OUTPUT "Reversed array:"
     FOR i = 0 TO 4
         OUTPUT numbers[i]
     END FOR
     END
     ```

2. **Flowchart Design**:

   - **Task**: Create a flowchart for a program that uses a function to calculate the factorial of a user-input number.
   - **Expected Flowchart** (main, text-based):
     ```
     [Start] → [Input num] → [Call Factorial(num)] → [Output "Factorial: ", result] → [End]
     ```
     - **Factorial Flowchart**:
       ```
       [Start Factorial] → [result = 1, i = 1] → [i <= num?] → Yes → [result = result * i] → [i = i + 1] → [Back to i <= num?]
                                            ↓ No
                                         [Return result] → [End Factorial]
       ```

3. **Error Correction**:

   - **Task**: Fix errors in this pseudocode:
     ```
     FUNCTION Sum(num1, num2)
         SET total = num1 + num2
         RETURN total
     END
     START
         INPUT a, b
         OUTPUT Sum
     END
     ```
   - **Issues**:
     - Function lacks `RETURNS dataType` (e.g., `RETURNS INTEGER`).
     - Function call `Sum` needs arguments (`Sum(a, b)`).
     - Missing `END FUNCTION`.
   - **Corrected Pseudocode**:

     ```
     FUNCTION Sum(num1, num2) RETURNS INTEGER
         SET total = num1 + num2
         RETURN total
     END FUNCTION

     START
         INPUT a, b
         SET result = Sum(a, b)
         OUTPUT result
     END
     ```

4. **Group Activity: Real-World Scenario**:

   - **Task**: In pairs, design pseudocode and a flowchart for a program that:
     - Uses a procedure to validate 5 test scores (ensure 0–100).
     - Uses a function to calculate the highest score.
     - Outputs valid scores and the highest score.
   - **Example Pseudocode**:

     ```
     PROCEDURE ValidateScores(scores[5])
         FOR i = 0 TO 4
             WHILE scores[i] < 0 OR scores[i] > 100
                 OUTPUT "Invalid score, re-enter:"
                 INPUT scores[i]
             END WHILE
         END FOR
     END PROCEDURE

     FUNCTION FindHighest(scores[5]) RETURNS INTEGER
         SET maxScore = scores[0]
         FOR i = 1 TO 4
             IF scores[i] > maxScore THEN
                 maxScore = scores[i]
             END IF
         END FOR
         RETURN maxScore
     END FUNCTION

     DECLARE scores[5] OF INTEGER
     START
     OUTPUT "Enter 5 test scores:"
     FOR i = 0 TO 4
         INPUT scores[i]
     END FOR
     CALL ValidateScores(scores)
     OUTPUT "Valid scores:"
     FOR i = 0 TO 4
         OUTPUT scores[i]
     END FOR
     SET highest = FindHighest(scores)
     OUTPUT "Highest score: ", highest
     END
     ```

   - **Discussion**: Share solutions and discuss how subroutines improve code clarity.

## Objective Questions (Multiple Choice)

Test your understanding of subroutines with the following questions:

1. **What is a subroutine?**

   - A. A loop structure
   - B. A named block of code for a specific task
   - C. A data type
   - D. An array index
   - **Answer**: B
   - **Explanation**: A subroutine is a modular code block (procedure or function) for a task. Loops (A), data types (C), and indices (D) are unrelated.

2. **What is the difference between a procedure and a function?**

   - A. Procedures return values; functions do not
   - B. Functions return values; procedures do not
   - C. Procedures use loops; functions use decisions
   - D. Functions are called; procedures are not
   - **Answer**: B
   - **Explanation**: Functions return a value (e.g., `RETURN result`), while procedures perform tasks without returning. Other options are incorrect.

3. **How is a procedure called in pseudocode?**

   - A. SET ProcedureName
   - B. CALL ProcedureName(arguments)
   - C. RETURN ProcedureName
   - D. INPUT ProcedureName
   - **Answer**: B
   - **Explanation**: Procedures are invoked with `CALL ProcedureName(arguments)`. SET (A) assigns values, RETURN (C) is for functions, and INPUT (D) is for user input.

4. **What does this function do?**

   ```
   FUNCTION Double(number) RETURNS INTEGER
       RETURN number * 2
   END FUNCTION
   ```

   - A. Squares the number
   - B. Doubles the number
   - C. Halves the number
   - D. Adds 2
   - **Answer**: B
   - **Explanation**: The function returns `number * 2`, doubling the input. Other options describe different operations.

5. **What is wrong with this pseudocode?**

   ```
   PROCEDURE PrintMessage
       OUTPUT "Hello"
   END
   START
       PrintMessage
   END
   ```

   - A. Missing parameters
   - B. Incorrect procedure call
   - C. No OUTPUT
   - D. Invalid syntax
   - **Answer**: B
   - **Explanation**: Procedure calls require `CALL` (e.g., `CALL PrintMessage`). Parameters (A) are optional, OUTPUT exists (C), and syntax is otherwise valid (D).

6. **What does this pseudocode output if `values = [10, 20, 30]`?**

   ```
   PROCEDURE SumArray(arr[3])
       SET sum = 0
       FOR i = 0 TO 2
           sum = sum + arr[i]
       END FOR
       OUTPUT sum
   END PROCEDURE
   DECLARE values[3] OF INTEGER
   SET values = [10, 20, 30]
   CALL SumArray(values)
   ```

   - A. 60
   - B. 30
   - C. 10
   - D. Nothing
   - **Answer**: A
   - **Explanation**: The procedure sums `10 + 20 + 30 = 60` and outputs it. Other options miscalculate or assume no output.

7. **In a flowchart, how is a subroutine call represented?**

   - A. Diamond
   - B. Rectangle with double vertical lines
   - C. Oval
   - D. Parallelogram
   - **Answer**: B
   - **Explanation**: Subroutine calls use a rectangle with double vertical lines or a labeled box. Diamonds (A) are for decisions, ovals (C) for start/end, and parallelograms (D) for input/output.

8. **What does this function return if `x = 4`?**

   ```
   FUNCTION IsEven(x) RETURNS BOOLEAN
       IF x MOD 2 == 0 THEN
           RETURN TRUE
       ELSE
           RETURN FALSE
       END IF
   END FUNCTION
   ```

   - A. TRUE
   - B. FALSE
   - C. 4
   - D. 2
   - **Answer**: A
   - **Explanation**: Since `4 % 2 = 0`, the function returns `TRUE`. Other options are incorrect for `x = 4`.

9. **Why use parameters in subroutines?**

   - A. To change the program’s structure
   - B. To allow subroutines to work with different inputs
   - C. To avoid loops
   - D. To store arrays
   - **Answer**: B
   - **Explanation**: Parameters enable subroutines to process different inputs (e.g., different numbers or arrays). Other options are unrelated.

10. **What is the output of this pseudocode?**
    ```
    PROCEDURE Greet(name)
        OUTPUT "Hello, ", name
    END PROCEDURE
    START
        CALL Greet("Bob")
    END
    ```
    - A. Hello, Bob
    - B. Bob
    - C. Hello
    - D. Nothing
    - **Answer**: A
    - **Explanation**: The procedure outputs "Hello, Bob" with the argument "Bob". Other options omit parts or assume no output.

## Homework

1. **Pseudocode Practice**:
   - Write pseudocode for a function that calculates the square root of a number (approximate using a simple method) and a procedure to display it.
2. **Flowchart Creation**:
   - Design a flowchart for a program that uses a procedure to validate and display 4 user-input ages (ensure positive).
3. **Real-World Application**:
   - Describe a scenario where subroutines are used (e.g., a grading system). Write a paragraph and pseudocode with a function to calculate a grade and a procedure to display results.
4. **Debugging Challenge**:
   - Fix this pseudocode:
     ```
     FUNCTION Max(a, b)
         IF a > b THEN
             RETURN a
         ELSE
             RETURN b
     END
     START
         INPUT x, y
         OUTPUT Max(x, y)
     END
     ```
     - Issues: Missing `RETURNS dataType`, missing `END IF`, missing `END FUNCTION`.
     - Provide the corrected version.

## Additional Notes

- **Teaching Tips**:
  - **Duration**: 2–3 class periods (3–4.5 hours).
    - **Period 1**: Subroutine basics, Example 1, Activity 1.
    - **Period 2**: Parameters and return values, Examples 2 and 3, Activities 2 and 3.
    - **Period 3 (optional)**: Example 4, Activity 4, review, quiz.
  - **Visual Aids**: Draw call stacks (main → subroutine → return) to clarify execution flow.
  - **Engagement**: Use relatable scenarios (e.g., greeting users, grading scores).
  - **Differentiation**:
    - Beginners: Focus on simple procedures and single-parameter functions.
    - Advanced: Introduce recursive functions or multiple return values.
- **Resources**:
  - Flowchart tools: Draw.io, Lucidchart, or paper templates.
  - Text editor for pseudocode: Notepad++, Visual Studio Code.
- **Assessment**:
  - Use objective questions for quizzes or homework.
  - Grade classwork for correct subroutine syntax, parameter usage, and flowchart accuracy.
- **Extension**:

  - Implement a pseudocode example in Python:

    ```python
    def calculate_average(arr):
        total = sum(arr)
        return total / len(arr)

    def count_above_average(arr, avg):
        count = sum(1 for x in arr if x > avg)
        print(f"Values above average: {count}")

    scores = [float(input("Enter score: ")) for _ in range(6)]
    avg = calculate_average(scores)
    print(f"Average score: {avg}")
    count_above_average(scores, avg)
    ```

- **Connections**:
  - Builds on Sessions 7 (structured programming) and 8 (arrays) for modular array processing.
  - Prepares for future sessions (e.g., file handling, object-oriented programming) by emphasizing modularity.
