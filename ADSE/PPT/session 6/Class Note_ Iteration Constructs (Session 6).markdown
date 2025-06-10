# Class Note: Iteration Constructs (Session 6)

## Overview
Iteration constructs, or loops, allow a program to repeat a block of code multiple times based on a condition or a set number of iterations. They are essential for automating repetitive tasks, such as summing numbers or processing lists. This session covers **while**, **for**, and **do-while** loops, focusing on their use in pseudocode and flowcharts. By the end of this class, you will be able to write pseudocode and design flowcharts using loops to solve practical problems efficiently.

## Learning Objectives
- Understand the purpose and types of iteration constructs.
- Write pseudocode using while, for, and do-while loops.
- Create flowcharts to visualize repetitive processes.
- Apply loops with operators and selection constructs to solve real-world problems.
- Identify and avoid common loop errors (e.g., infinite loops).

## Key Concepts
1. **What Are Iteration Constructs?**
   - Loops enable a program to execute a block of code repeatedly until a condition is met or for a specific number of times.
   - They reduce code redundancy and improve efficiency for tasks like counting, summing, or searching.
   - Types:
     - **While Loop**: Repeats while a condition is true.
     - **For Loop**: Repeats for a fixed number of iterations.
     - **Do-While Loop**: Executes at least once, then repeats while a condition is true.

2. **Components of Loops**
   - **Initialization**: Sets the starting value (e.g., `counter = 1`).
   - **Condition**: Determines whether the loop continues (e.g., `counter <= 10`).
   - **Body**: The code to be repeated (e.g., `OUTPUT counter`).
   - **Update**: Modifies the loop variable (e.g., `counter = counter + 1`).
   - Loops use relational (`>`, `<`, `==`) and logical (`AND`, `OR`) operators for conditions.

3. **Pseudocode Syntax**
   - **While Loop**:
     ```
     WHILE condition
         action(s)
     END WHILE
     ```
   - **For Loop**:
     ```
     FOR variable = start TO end [STEP increment]
         action(s)
     END FOR
     ```
   - **Do-While Loop**:
     ```
     DO
         action(s)
     WHILE condition
     END DO
     ```

4. **Flowchart Representation**
   - **Diamond**: Represents the loop condition (e.g., `counter <= 10?`).
   - **Rectangle**: Represents actions in the loop body.
   - **Arrows**: Show the flow, looping back to the condition if true.
   - Example: For a while loop, the flowchart loops back to the diamond if the condition is true; otherwise, it exits.

5. **Avoiding Infinite Loops**
   - An infinite loop occurs if the condition never becomes false (e.g., forgetting to update the loop variable).
   - Ensure the loop variable is updated to eventually fail the condition.

## Examples
1. **While Loop: Sum of Numbers 1 to 5**
   - **Problem**: Calculate the sum of numbers from 1 to 5.
   - **Pseudocode**:
     ```
     START
     SET sum = 0
     SET number = 1
     WHILE number <= 5
         sum = sum + number
         number = number + 1
     END WHILE
     OUTPUT "Sum: ", sum
     END
     ```
   - **Flowchart** (text-based):
     ```
     [Start] → [sum = 0, number = 1] → [number <= 5?] → Yes → [sum = sum + number] → [number = number + 1] → [Back to number <= 5?]
                                             ↓ No
                                        [Output "Sum: ", sum] → [End]
     ```
   - **Explanation**: The loop adds `number` to `sum` and increments `number` until `number > 5`. Result: `sum = 1 + 2 + 3 + 4 + 5 = 15`.

2. **For Loop: Print Even Numbers 2 to 10**
   - **Problem**: Output even numbers from 2 to 10.
   - **Pseudocode**:
     ```
     START
     FOR number = 2 TO 10 STEP 2
         OUTPUT number
     END FOR
     END
     ```
   - **Flowchart**:
     ```
     [Start] → [number = 2] → [number <= 10?] → Yes → [Output number] → [number = number + 2] → [Back to number <= 10?]
                                          ↓ No
                                       [End]
     ```
   - **Explanation**: The loop outputs `2, 4, 6, 8, 10` by incrementing `number` by 2 each iteration.

3. **Do-While Loop: Collect Positive Inputs**
   - **Problem**: Keep asking for a number until a positive number (> 0) is entered.
   - **Pseudocode**:
     ```
     START
     DO
         INPUT number
         IF number <= 0 THEN
             OUTPUT "Please enter a positive number"
         END IF
     WHILE number <= 0
     OUTPUT "Valid number: ", number
     END
     ```
   - **Flowchart**:
     ```
     [Start] → [Input number] → [number <= 0?] → Yes → [Output "Please enter a positive number"] → [Back to Input number]
                                          ↓ No
                                     [Output "Valid number: ", number] → [End]
     ```
   - **Explanation**: The loop runs at least once, prompting for input until `number > 0`.

4. **Combined Example: Count Passing Scores**
   - **Problem**: Input 5 student scores and count how many are passing (≥ 60).
   - **Pseudocode**:
     ```
     START
     SET passCount = 0
     FOR i = 1 TO 5
         INPUT score
         IF score >= 60 THEN
             passCount = passCount + 1
         END IF
     END FOR
     OUTPUT "Number of passing scores: ", passCount
     END
     ```
   - **Flowchart**:
     ```
     [Start] → [passCount = 0, i = 1] → [i <= 5?] → Yes → [Input score] → [score >= 60?] → Yes → [passCount = passCount + 1] → [i = i + 1] → [Back to i <= 5?]
                                             ↓ No                       ↓ No                     ↓
                                        [Output "Number of passing scores: ", passCount] → [End]
     ```
   - **Explanation**: Uses a for loop to process 5 scores and a selection construct to count passing ones.

## Classwork Activities
1. **Pseudocode Writing**:
   - **Task**: Write pseudocode to calculate the factorial of a number (e.g., 5! = 5 * 4 * 3 * 2 * 1).
     - Input: A positive integer `n`.
     - Use a while loop to compute `n!`.
   - **Expected Pseudocode**:
     ```
     START
     INPUT n
     SET factorial = 1
     SET counter = 1
     WHILE counter <= n
         factorial = factorial * counter
         counter = counter + 1
     END WHILE
     OUTPUT "Factorial of ", n, " is ", factorial
     END
     ```

2. **Flowchart Design**:
   - **Task**: Create a flowchart for a program that outputs the first 10 odd numbers (1, 3, 5, ..., 19).
     - Use a for loop with a step of 2.
   - **Expected Flowchart** (text-based):
     ```
     [Start] → [number = 1] → [number <= 19?] → Yes → [Output number] → [number = number + 2] → [Back to number <= 19?]
                                          ↓ No
                                       [End]
     ```

3. **Error Correction**:
   - **Task**: Fix errors in the following pseudocode:
     ```
     SET sum = 0
     WHILE sum <= 100
         INPUT value
         sum = sum + value
     OUTPUT sum
     END
     ```
   - **Issues**:
     - Missing `END WHILE`.
     - `OUTPUT` is misaligned (should be outside loop).
     - No `START/END`.
     - Potential infinite loop if `value` is always 0 or negative.
   - **Corrected Pseudocode**:
     ```
     START
     SET sum = 0
     WHILE sum <= 100
         INPUT value
         IF value > 0 THEN
             sum = sum + value
         END IF
     END WHILE
     OUTPUT "Total sum: ", sum
     END
     ```

4. **Group Activity: Real-World Scenario**:
   - **Task**: In pairs, design pseudocode and a flowchart for a program that simulates a ticket counter:
     - Input: Number of tickets to sell (positive integer).
     - Use a do-while loop to sell tickets one at a time until none remain, outputting "Ticket sold" each time.
     - Output: "All tickets sold" when done.
   - **Example Pseudocode**:
     ```
     START
     INPUT ticketCount
     DO
         IF ticketCount > 0 THEN
             OUTPUT "Ticket sold"
             ticketCount = ticketCount - 1
         END IF
     WHILE ticketCount > 0
     OUTPUT "All tickets sold"
     END
     ```
   - **Discussion**: Present solutions and discuss when to use do-while vs. while loops.

## Objective Questions (Multiple Choice)
Test your understanding of iteration constructs with the following questions:

1. What is the primary purpose of a loop in programming?
   - A) To make a single decision
   - B) To repeat a block of code
   - C) To store data
   - D) To perform arithmetic
   - **Answer**: B

2. Which loop executes its body at least once?
   - A) While
   - B) For
   - C) Do-While
   - D) None
   - **Answer**: C

3. What does this pseudocode output if run with no input changes?
   ```
   SET counter = 1
   WHILE counter <= 3
       OUTPUT counter
       counter = counter + 1
   END WHILE
   ```
   - A) 1 2 3
   - B) 1 2
   - C) 1
   - D) Infinite loop
   - **Answer**: A

4. In a for loop, what does the `STEP` keyword specify?
   - A) The loop condition
   - B) The increment or decrement value
   - C) The loop body
   - D) The initial value
   - **Answer**: B

5. What is wrong with this pseudocode?
   ```
   FOR i = 1 TO 5
       OUTPUT i
   END
   ```
   - A) Missing END FOR
   - B) No condition
   - C) No initialization
   - D) No output
   - **Answer**: A

6. What does this do-while loop do?
   ```
   DO
       INPUT number
   WHILE number < 0
   OUTPUT number
   ```
   - A) Outputs all numbers
   - B) Prompts until a non-negative number is entered
   - C) Causes an infinite loop
   - D) Outputs nothing
   - **Answer**: B

7. In a flowchart, where is the loop condition shown?
   - A) Rectangle
   - B) Diamond
   - C) Oval
   - D) Parallelogram
   - **Answer**: B

8. What is the output of this pseudocode?
   ```
   SET sum = 0
   FOR i = 1 TO 4
       sum = sum + i
   END FOR
   OUTPUT sum
   ```
   - A) 10
   - B) 4
   - C) 1
   - D) 0
   - **Answer**: A (Explanation: `sum = 1 + 2 + 3 + 4 = 10`)

9. What causes an infinite loop?
   - A) A condition that never becomes false
   - B) Using a for loop
   - C) Correct initialization
   - D) Outputting a value
   - **Answer**: A

10. Which loop is best for iterating a fixed number of times?
    - A) While
    - B) Do-While
    - C) For
    - D) All are equally suitable
    - **Answer**: C

## Homework
1. **Pseudocode Practice**:
   - Write pseudocode to find the sum of all even numbers from 1 to 20 using a for loop.
2. **Flowchart Creation**:
   - Design a flowchart for a program that keeps asking for a password until the correct one ("secret") is entered, using a do-while loop.
3. **Real-World Application**:
   - Describe a scenario where loops are used (e.g., processing customer orders). Write a short paragraph and pseudocode for it.
4. **Debugging Challenge**:
   - Fix this pseudocode:
     ```
     SET counter = 1
     WHILE counter < 5
         OUTPUT counter
     END WHILE
     ```
     - Issues: No update to `counter`, causing an infinite loop; no `START/END`.
     - Provide the corrected version.

## Additional Notes
- **Teaching Tips**:
  - **Duration**: 3 class periods (4.5 hours).
    - **Period 1**: While and for loops, Examples 1 and 2, Activity 1.
    - **Period 2**: Do-while loops, Example 3, Activities 2 and 3.
    - **Period 3**: Combined example, Activity 4, review, quiz.
  - **Visual Aids**: Draw flowcharts live to show loop flow, emphasizing the return path for repetition.
  - **Engagement**: Use relatable scenarios (e.g., ticket sales, score counting) to make loops relevant.
  - **Differentiation**:
    - Beginners: Focus on while and for loops before do-while.
    - Advanced: Introduce nested loops (e.g., printing a multiplication table) or combine with arrays (preview Session 8).
- **Resources**:
  - Flowchart tools: Draw.io, Lucidchart, or paper templates.
  - Text editor for pseudocode: Notepad++, Visual Studio Code.
- **Assessment**:
  - Use objective questions for a quiz or homework.
  - Grade classwork for correct loop structure, condition logic, and flowchart accuracy.
- **Extension**:
  - Implement a pseudocode example in Python:
    ```python
    sum = 0
    for i in range(1, 6):  # 1 to 5
        sum += i
    print("Sum:", sum)
    ```
- **Connections**:
  - Builds on Session 4 (Selection Constructs) and Session 5 (Operators) for conditions and expressions.
  - Prepares for Session 7 (Structured Programming) by introducing repetitive control structures.