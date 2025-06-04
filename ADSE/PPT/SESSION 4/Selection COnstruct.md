# Class Note: Selection Constructs

## Overview
Selection constructs are fundamental programming concepts that allow a program to make decisions based on conditions. They enable different paths of execution depending on user input or data, making programs dynamic and responsive. This session covers **if-then**, **if-then-else**, and **nested if** statements, along with the use of relational and logical operators to form conditions. By the end of this class, you will be able to write pseudocode and design flowcharts using selection constructs to solve practical problems.

## Learning Objectives
- Understand the purpose and **structure** of selection constructs.
- Write pseudocode using if-**then**, if-then-else, and nested if statements.
- Create flowcharts to visualize decision-making processes.
- Apply relational and logical operators to form conditions.
- Solve real-world problems using selection constructs.

## Key Concepts
1. **What Are Selection Constructs?**
   - Selection constructs allow a program to choose between different actions based on whether a condition is true or false.
   - They are used to implement decision-making in algorithms, such as determining eligibility, assigning grades, or applying discounts.
   - Types:
     - **If-Then**: Executes a block of code if a condition is true.
     - **If-Then-Else**: Executes one block if the condition is true, another if false.
     - **Nested If**: Places one if statement inside another for complex decisions.

2. **Components of Selection Constructs**
   - **Condition**: A logical expression that evaluates to true or false (e.g., `score >= 60`).
   - **Relational Operators**: Used to compare values:
     - `>` (greater than), `<` (less than), `>=` (greater than or equal to), `<=` (less than or equal to), `==` (equal to), `≠` (not equal to).
   - **Logical Operators**: Combine conditions:
     - `AND` (both conditions must be true), `OR` (at least one condition true), `NOT` (negates a condition).
   - **Action**: The code executed when a condition is met (e.g., outputting a message).

3. **Pseudocode Syntax**
   - **If-Then**:
     ```
     IF condition THEN
         action
     END IF
     ```
   - **If-Then-Else**:
     ```
     IF condition THEN
         action1
     ELSE
         action2
     END IF
     ```
   - **Nested If**:
     ```
     IF condition1 THEN
         IF condition2 THEN
             action1
         ELSE
             action2
         END IF
     ELSE
         action3
     END IF
     ```

4. **Flowchart Representation**
   - Selection constructs are visualized using:
     - **Diamond**: Represents a decision point (condition) with Yes/No paths.
     - **Rectangle**: Represents actions (e.g., output or assignment).
     - **Arrows**: Show the flow between steps.
   - Example: For `IF age >= 18 THEN OUTPUT "Adult" ELSE OUTPUT "Minor" END IF`:
     - Diamond: `age >= 18?` → Yes: Rectangle (`Output "Adult"`) → End.
     - No: Rectangle (`Output "Minor"`) → End.

## Examples
1. **If-Then: Check if Temperature is High**
   - **Problem**: Output a warning if the temperature exceeds 30°C.
   - **Pseudocode**:
     ```
     START
     INPUT temperature
     IF temperature > 30 THEN
         OUTPUT "High temperature warning!"
     END IF
     END
     ```
   - **Flowchart** (text-based description):
     ```
     [Start] → [Input temperature] → [temperature > 30?] → Yes → [Output "High temperature warning!"] → [End]
                                          ↓ No
                                       [End]
     ```
   - **Explanation**: If the condition `temperature > 30` is true, the warning is displayed; otherwise, the program ends.

2. **If-Then-Else: Determine Even or Odd Number**
   - **Problem**: Check if a number is even or odd and output the result.
   - **Pseudocode**:
     ```
     START
     INPUT number
     IF number MOD 2 == 0 THEN
         OUTPUT "Number is Even"
     ELSE
         OUTPUT "Number is Odd"
     END IF
     END
     ```
   - **Flowchart**:
     ```
     [Start] → [Input number] → [number % 2 == 0?] → Yes → [Output "Number is Even"] → [End]
                                       ↓ No
                                  [Output "Number is Odd"] → [End]
     ```
   - **Explanation**: The modulo operator (`MOD`) checks if the number is divisible by 2. If true, it’s even; otherwise, it’s odd.

3. **Nested If: Assign Grades with Honors**
   - **Problem**: Assign a pass/fail grade based on a score (≥ 60 to pass) and check for honors (≥ 85).
   - **Pseudocode**:
     ```
     START
     INPUT score
     IF score >= 60 THEN
         IF score >= 85 THEN
             OUTPUT "Pass with Honors"
         ELSE
             OUTPUT "Pass"
         END IF
     ELSE
         OUTPUT "Fail"
     END IF
     END
     ```
   - **Flowchart**:
     ```
     [Start] → [Input score] → [score >= 60?] → Yes → [score >= 85?] → Yes → [Output "Pass with Honors"] → [End]
                                       ↓ No                     ↓ No
                                  [Output "Fail"] → [End]  [Output "Pass"] → [End]
     ```
   - **Explanation**: The outer condition checks if the score is passing; the inner condition checks for honors.

4. **Logical Operators: Movie Theater Entry**
   - **Problem**: Allow entry to a movie if the person is ≥ 18 or accompanied by an adult.
   - **Pseudocode**:
     ```
     START
     INPUT age, hasAdult
     IF age >= 18 OR hasAdult == "Yes" THEN
         OUTPUT "Entry allowed"
     ELSE
         OUTPUT "Entry denied"
     END IF
     END
     ```
   - **Flowchart**:
     ```
     [Start] → [Input age, hasAdult] → [age >= 18 OR hasAdult == "Yes"?] → Yes → [Output "Entry allowed"] → [End]
                                                  ↓ No
                                             [Output "Entry denied"] → [End]
     ```
   - **Explanation**: The `OR` operator allows entry if either condition is true.

## Classwork Activities
1. **Pseudocode Writing**:
   - **Task**: Write pseudocode to determine if a customer qualifies for a discount:
     - Senior discount: age ≥ 65.
     - Student discount: age 13–22.
     - No discount: otherwise.
   - **Expected Output** (example for age = 20):
     ```
     START
     INPUT age
     IF age >= 65 THEN
         OUTPUT "Senior discount"
     ELSE IF age >= 13 AND age <= 22 THEN
         OUTPUT "Student discount"
     ELSE
         OUTPUT "No discount"
     END IF
     END
     ```

2. **Flowchart Design**:
   - **Task**: Create a flowchart for a program that checks if a user can vote:
     - Eligible if age ≥ 18 and citizen = "Yes".
     - Output "Eligible to vote" or "Not eligible".
   - **Expected Flowchart** (text-based):
     ```
     [Start] → [Input age, citizen] → [age >= 18 AND citizen == "Yes"?] → Yes → [Output "Eligible to vote"] → [End]
                                                ↓ No
                                           [Output "Not eligible"] → [End]
     ```

3. **Error Correction**:
   - **Task**: Identify and fix errors in the following pseudocode:
     ```
     INPUT temperature
     IF temperature > 25 THEN
         OUTPUT "Warm"
     ELSE temperature < 15
         OUTPUT "Cold"
     END
     ```
   - **Issues**:
     - Missing `THEN` after `ELSE temperature < 15`.
     - `ELSE` should not have a condition; use `ELSE IF` for additional conditions.
     - Missing `END IF`.
   - **Corrected Pseudocode**:
     ```
     START
     INPUT temperature
     IF temperature > 25 THEN
         OUTPUT "Warm"
     ELSE IF temperature < 15 THEN
         OUTPUT "Cold"
     ELSE
         OUTPUT "Moderate"
     END IF
     END
     ```

4. **Group Activity: Real-World Scenario**:
   - **Task**: In pairs, design pseudocode and a flowchart for a program that determines parking fees:
     - Free parking: Employee (isEmployee = "Yes").
     - $5 parking: Non-employee, parked ≤ 2 hours.
     - $10 parking: Non-employee, parked > 2 hours.
   - **Example Pseudocode**:
     ```
     START
     INPUT isEmployee, hoursParked
     IF isEmployee == "Yes" THEN
         OUTPUT "Free parking"
     ELSE
         IF hoursParked <= 2 THEN
             OUTPUT "Pay $5"
         ELSE
             OUTPUT "Pay $10"
         END IF
     END IF
     END
     ```
   - **Discussion**: Present your solution to the class and compare approaches.

## Objective Questions (Multiple Choice)
Test your understanding of selection constructs with the following questions:

1. What is the purpose of a selection construct in programming?
   - A) To repeat a block of code
   - B) To make decisions based on conditions
   - C) To store data in memory
   - D) To perform arithmetic operations
   - **Answer**: B

2. Which symbol represents a decision in a flowchart?
   - A) Rectangle
   - B) Oval
   - C) Diamond
   - D) Parallelogram
   - **Answer**: C

3. What does the following pseudocode output if score = 50?
   ```
   IF score >= 60 THEN
       OUTPUT "Pass"
   ELSE
       OUTPUT "Fail"
   END IF
   ```
   - A) Pass
   - B) Fail
   - C) No output
   - D) Error
   - **Answer**: B

4. Which operator checks if two values are equal?
   - A) >
   - B) ==
   - C) ≠
   - D) <
   - **Answer**: B

5. In a nested IF statement, what happens if the outer condition is false?
   - A) Inner conditions are still evaluated
   - B) The program terminates
   - C) Only the ELSE block of the outer IF is executed
   - D) An error occurs
   - **Answer**: C

6. What is the output of this pseudocode for age = 16, hasLicense = "Yes"?
   ```
   IF age >= 16 AND hasLicense == "Yes" THEN
       OUTPUT "Can drive"
   ELSE
       OUTPUT "Cannot drive"
   END IF
   ```
   - A) Can drive
   - B) Cannot drive
   - C) No output
   - D) Error
   - **Answer**: A

7. Which logical operator requires at least one condition to be true?
   - A) AND
   - B) OR
   - C) NOT
   - D) NONE
   - **Answer**: B

8. What is wrong with this pseudocode?
   ```
   IF score > 70 THEN
       OUTPUT "Good"
   ELSE score < 60
       OUTPUT "Poor"
   END IF
   ```
   - A) Missing END
   - B) ELSE should not have a condition
   - C) Incorrect operator
   - D) No START
   - **Answer**: B

9. What does the NOT operator do in a condition?
   - A) Combines two conditions
   - B) Negates the condition’s truth value
   - C) Checks for equality
   - D) Performs division
   - **Answer**: B

10. Which flowchart path matches this pseudocode?
    ```
    IF temperature <= 0 THEN
        OUTPUT "Freezing"
    ELSE
        OUTPUT "Not freezing"
    END IF
    ```
    - A) Input temperature → [temperature <= 0?] → Yes: Output "Freezing" → End; No: Output "Not freezing" → End
    - B) Input temperature → Output "Freezing" → [temperature <= 0?] → End
    - C) Input temperature → [temperature > 0?] → Yes: Output "Freezing" → End
    - D) Input temperature → Output "Not freezing" → End
    - **Answer**: A

## Homework
1. **Pseudocode Practice**:
   - Write pseudocode to determine a movie ticket price:
     - $5 for children (age ≤ 12).
     - $8 for seniors (age ≥ 65).
     - $10 for adults (otherwise).
2. **Flowchart Creation**:
   - Design a flowchart for a program that checks if a student qualifies for a scholarship:
     - Eligible if GPA ≥ 3.5 and income < $50,000.
     - Output "Eligible" or "Not eligible".
3. **Real-World Application**:
   - Identify a real-world scenario where selection constructs are used (e.g., online shopping discounts). Write a short paragraph and create pseudocode for it.
4. **Debugging Challenge**:
   - Fix the following pseudocode:
     ```
     INPUT age
     IF age > 18 THEN
         OUTPUT "Adult"
     ELSE IF age > 13
         OUTPUT "Teen"
     ELSE
         OUTPUT "Child"
     END
     ```
     - Issues: Missing `THEN` in `ELSE IF`, missing `END IF`, no `START/END`.
     - Provide the corrected version.

## Additional Notes
- **Teaching Tips**:
  - **Duration**: Plan for 2–3 class periods (3–4.5 hours) to cover theory, examples, and activities.
  - **Visual Aids**: Use a whiteboard or digital tool (e.g., Draw.io) to draw flowcharts live, showing how conditions split into Yes/No paths.
  - **Engagement**: Relate examples to students’ experiences (e.g., movie tickets, grades) to make concepts relatable.
  - **Differentiation**:
    - For beginners, focus on simple if-then and if-then-else statements before introducing nested ifs.
    - For advanced students, challenge them with complex conditions using multiple logical operators (e.g., `IF age >= 18 AND (hasLicense == "Yes" OR hasPermit == "Yes") THEN`).
- **Resources**:
  - Provide flowchart templates or access to online tools like Lucidchart or Draw.io.
  - Use a text editor (e.g., Notepad++) for pseudocode practice to simulate coding.
- **Assessment**:
  - Use the objective questions as a quiz or homework to evaluate understanding.
  - Grade classwork and homework based on correct use of conditions, logical operators, and flowchart symbols.
- **Extension**:
  - Introduce a simple programming language (e.g., Python) to implement a pseudocode example, such as:
    ```python
    score = int(input("Enter score: "))
    if score >= 60:
        if score >= 85:
            print("Pass with Honors")
        else:
            print("Pass")
    else:
        print("Fail")
    ```