# Class Note: Operators

## Overview
Operators are symbols or keywords that perform operations on data, such as calculations, comparisons, or logical evaluations. They are essential for manipulating values and making decisions in algorithms. This session covers **arithmetic**, **relational**, **logical**, and **assignment** operators, focusing on their use in pseudocode and flowcharts. By the end of this class, you will be able to apply operators to solve problems, write pseudocode with complex expressions, and design flowcharts that incorporate operator-based decisions.

## Learning Objectives
- Understand the types and purposes of operators in programming.
- Use arithmetic operators for calculations in pseudocode.
- Apply relational and logical operators to form conditions for decision-making.
- Use assignment operators to update variable values.
- Create flowcharts and pseudocode incorporating operators to solve practical problems.

## Key Concepts
1. **What Are Operators?**
   - Operators are special symbols or words that perform operations on one or more operands (e.g., numbers, variables).
   - They are used in expressions to compute values, compare data, or combine conditions.
   - Example: In `total = price * quantity`, `*` is an arithmetic operator, and `=` is an assignment operator.

2. **Types of Operators**
   - **Arithmetic Operators**: Perform mathematical calculations.
     - `+` (addition), `-` (subtraction), `*` (multiplication), `/` (division), `%` (modulo, remainder after division).
   - **Relational Operators**: Compare two values, returning true or false.
     - `>` (greater than), `<` (less than), `>=` (greater than or equal to), `<=` (less than or equal to), `==` (equal to), `≠` (not equal to).
   - **Logical Operators**: Combine or modify conditions.
     - `AND` (both conditions true), `OR` (at least one condition true), `NOT` (negates a condition).
   - **Assignment Operators**: Assign or update values in variables.
     - `=` (assign), `+=` (add and assign), `-=` (subtract and assign), `*=` (multiply and assign), `/=` (divide and assign).

3. **Operator Precedence**
   - Operators are evaluated in a specific order:
     1. Parentheses `()`
     2. Arithmetic: `*`, `/`, `%` (left to right), then `+`, `-` (left to right)
     3. Relational: `>`, `<`, `>=`, `<=`, `==`, `≠`
     4. Logical: `NOT`, `AND`, `OR`
   - Example: In `5 + 3 * 2`, `*` is evaluated first, so the result is `5 + 6 = 11`.

4. **Using Operators in Pseudocode**
   - Operators are used in assignments (e.g., `total = price * quantity`) and conditions (e.g., `IF score >= 60 AND score <= 100 THEN`).
   - Pseudocode combines operators with selection constructs (from Session 4) to create dynamic algorithms.

5. **Flowchart Representation**
   - Arithmetic and assignment operations appear in **rectangles** (process steps).
   - Relational and logical operators appear in **diamonds** (decision points).
   - Example: For `IF score >= 60 THEN`, the diamond contains `score >= 60?`.

## Examples
1. **Arithmetic Operators: Calculate Total Cost**
   - **Problem**: Calculate the total cost of items, including a 10% tax.
   - **Pseudocode**:
     ```
     START
     INPUT price, quantity
     subtotal = price * quantity
     tax = subtotal * 0.1
     total = subtotal + tax
     OUTPUT "Total cost: ", total
     END
     ```
   - **Flowchart** (text-based):
     ```
     [Start] → [Input price, quantity] → [subtotal = price * quantity] → [tax = subtotal * 0.1] → [total = subtotal + tax] → [Output "Total cost: ", total] → [End]
     ```
   - **Explanation**: Uses `*` for multiplication and `+` for addition to compute the total.

2. **Relational Operators: Check Passing Score**
   - **Problem**: Determine if a student passes based on a score (≥ 60).
   - **Pseudocode**:
     ```
     START
     INPUT score
     IF score >= 60 THEN
         OUTPUT "Pass"
     ELSE
         OUTPUT "Fail"
     END IF
     END
     ```
   - **Flowchart**:
     ```
     [Start] → [Input score] → [score >= 60?] → Yes → [Output "Pass"] → [End]
                                    ↓ No
                               [Output "Fail"] → [End]
     ```
   - **Explanation**: The relational operator `>=` compares `score` to 60.

3. **Logical Operators: Driving Eligibility**
   - **Problem**: Check if a person can drive (age ≥ 16 and has a license).
   - **Pseudocode**:
     ```
     START
     INPUT age, hasLicense
     IF age >= 16 AND hasLicense == "Yes" THEN
         OUTPUT "Eligible to drive"
     ELSE
         OUTPUT "Not eligible to drive"
     END IF
     END
     ```
   - **Flowchart**:
     ```
     [Start] → [Input age, hasLicense] → [age >= 16 AND hasLicense == "Yes"?] → Yes → [Output "Eligible to drive"] → [End]
                                                  ↓ No
                                             [Output "Not eligible to drive"] → [End]
     ```
   - **Explanation**: `AND` ensures both conditions are true for eligibility.

4. **Assignment Operators: Update Balance**
   - **Problem**: Update a bank balance after a deposit and a withdrawal.
   - **Pseudocode**:
     ```
     START
     INPUT initialBalance, deposit, withdrawal
     SET balance = initialBalance
     balance += deposit
     balance -= withdrawal
     OUTPUT "Final balance: ", balance
     END
     ```
   - **Flowchart**:
     ```
     [Start] → [Input initialBalance, deposit, withdrawal] → [balance = initialBalance] → [balance += deposit] → [balance -= withdrawal] → [Output "Final balance: ", balance] → [End]
     ```
   - **Explanation**: `+=` adds `deposit` to `balance`, and `-=` subtracts `withdrawal`.

## Classwork Activities
1. **Pseudocode Writing**:
   - **Task**: Write pseudocode to calculate a discounted price:
     - Input: Original price, discount percentage (e.g., 20 for 20%).
     - Calculate: Discount amount = price * (percentage / 100), final price = price - discount.
     - Output: Final price.
   - **Expected Pseudocode**:
     ```
     START
     INPUT price, discountPercentage
     discount = price * (discountPercentage / 100)
     finalPrice = price - discount
     OUTPUT "Final price: ", finalPrice
     END
     ```

2. **Flowchart Design**:
   - **Task**: Create a flowchart to determine if a number is positive, negative, or zero.
     - Use relational operators (`>`, `<`, `==`) in decision diamonds.
   - **Expected Flowchart** (text-based):
     ```
     [Start] → [Input number] → [number > 0?] → Yes → [Output "Positive"] → [End]
                                    ↓ No
                               [number == 0?] → Yes → [Output "Zero"] → [End]
                                    ↓ No
                               [Output "Negative"] → [End]
     ```

3. **Error Correction**:
   - **Task**: Identify and fix errors in the following pseudocode:
     ```
     INPUT score
     IF score > 80 AND < 100 THEN
         OUTPUT "Excellent"
     ELSE
         OUTPUT "Needs improvement"
     END IF
     ```
   - **Issues**:
     - Incorrect syntax for `AND` condition; should be `score > 80 AND score < 100`.
     - Missing `START` and `END`.
   - **Corrected Pseudocode**:
     ```
     START
     INPUT score
     IF score > 80 AND score < 100 THEN
         OUTPUT "Excellent"
     ELSE
         OUTPUT "Needs improvement"
     END IF
     END
     ```

4. **Group Activity: Real-World Scenario**:
   - **Task**: In pairs, design pseudocode and a flowchart for a program that calculates a delivery fee:
     - Free delivery: Order amount ≥ $50 or premium member (isPremium = "Yes").
     - $5 delivery: Otherwise.
     - Use logical operators (`OR`) and relational operators (`>=`).
   - **Example Pseudocode**:
     ```
     START
     INPUT orderAmount, isPremium
     IF orderAmount >= 50 OR isPremium == "Yes" THEN
         OUTPUT "Free delivery"
     ELSE
         OUTPUT "Delivery fee: $5"
     END IF
     END
     ```
   - **Discussion**: Present solutions and discuss operator precedence (e.g., how `OR` is evaluated).

## Objective Questions (Multiple Choice)
Test your understanding of operators with the following questions:

1. What does the `%` operator do?
   - A) Multiplies two numbers
   - B) Returns the remainder after division
   - C) Compares two values
   - D) Negates a condition
   - **Answer**: B

2. Which operator checks if two values are not equal?
   - A) ==
   - B) ≠
   - C) >
   - D) <=
   - **Answer**: B

3. What is the result of `10 + 5 * 2`?
   - A) 30
   - B) 20
   - C) 17
   - D) 15
   - **Answer**: B (Explanation: `*` has higher precedence, so `5 * 2 = 10`, then `10 + 10 = 20`)

4. What does the following pseudocode output if age = 15, hasPermit = "Yes"?
   ```
   IF age >= 16 OR hasPermit == "Yes" THEN
       OUTPUT "Can practice driving"
   ELSE
       OUTPUT "Cannot practice driving"
   END IF
   ```
   - A) Can practice driving
   - B) Cannot practice driving
   - C) No output
   - D) Error
   - **Answer**: A

5. What is the purpose of the `+=` operator?
   - A) Compares two values
   - B) Adds a value and assigns the result
   - C) Divides two numbers
   - D) Negates a condition
   - **Answer**: B

6. Which logical operator requires both conditions to be true?
   - A) OR
   - B) AND
   - C) NOT
   - D) NONE
   - **Answer**: B

7. What is wrong with this pseudocode?
   ```
   INPUT price
   discount = price * 0.2
   price =- discount
   OUTPUT price
   ```
   - A) Incorrect operator (`=-` instead of `-=`)
   - B) Missing logical operator
   - C) No condition
   - D) No START/END
   - **Answer**: A

8. In a flowchart, where are arithmetic operations typically shown?
   - A) Diamond
   - B) Rectangle
   - C) Oval
   - D) Parallelogram
   - **Answer**: B

9. What does the `NOT` operator do?
   - A) Combines two conditions
   - B) Negates a condition’s truth value
   - C) Multiplies a value
   - D) Assigns a value
   - **Answer**: B

10. What is the output of this pseudocode if balance = 100, withdrawal = 30?
    ```
    balance -= withdrawal
    OUTPUT balance
    ```
    - A) 130
    - B) 100
    - C) 70
    - D) 30
    - **Answer**: C

## Homework
1. **Pseudocode Practice**:
   - Write pseudocode to calculate the area of a triangle:
     - Input: Base, height.
     - Calculate: Area = (base * height) / 2.
     - Output: Area.
2. **Flowchart Creation**:
   - Design a flowchart to check if a year is a leap year:
     - Leap year if divisible by 4, but not by 100 unless also divisible by 400.
     - Use modulo (`%`) and logical operators (`AND`, `OR`).
3. **Real-World Application**:
   - Identify a scenario where operators are used (e.g., calculating taxes, checking eligibility). Write a short paragraph and pseudocode for it.
4. **Debugging Challenge**:
   - Fix the following pseudocode:
     ```
     INPUT num1, num2
     IF num1 > num2 THEN
         OUTPUT num1, " is greater"
     ELSE num2 > num1 THEN
         OUTPUT num2, " is greater"
     ELSE
         OUTPUT "Equal"
     END
     ```
     - Issues: Incorrect `ELSE` with condition, missing `END IF`, no `START/END`.
     - Provide the corrected version.

## Additional Notes
- **Teaching Tips**:
  - **Duration**: Plan for 2–3 class periods (3–4.5 hours).
    - **Period 1**: Cover arithmetic and assignment operators, Examples 1 and 4, Activity 1.
    - **Period 2**: Cover relational and logical operators, Examples 2 and 3, Activities 2 and 3.
    - **Period 3 (optional)**: Conduct Activity 4, review concepts, administer quiz.
  - **Visual Aids**: Use a whiteboard to demonstrate operator precedence (e.g., `5 + 3 * 2`) and draw flowcharts for decision-making.
  - **Engagement**: Use relatable scenarios (e.g., shopping discounts, bank transactions) to make operators relevant.
  - **Differentiation**:
    - For beginners, focus on simple arithmetic and relational operators before logical operators.
    - For advanced students, introduce complex expressions (e.g., `(score >= 70 AND score < 80) OR isExtraCredit == "Yes"`) or preview loops with operators.
- **Resources**:
  - Provide access to flowchart tools (e.g., Draw.io, Lucidchart) or paper templates.
  - Use a text editor for pseudocode practice to simulate coding.
- **Assessment**:
  - Use objective questions as a quiz or homework.
  - Evaluate classwork for correct operator use, logical flow, and flowchart accuracy.
- **Extension**:
  - Introduce a programming language (e.g., Python) to implement a pseudocode example:
    ```python
    price = float(input("Enter price: "))
    quantity = int(input("Enter quantity: "))
    subtotal = price * quantity
    tax = subtotal * 0.1
    total = subtotal + tax
    print("Total cost:", total)
    ```
- **Connection to Prior Sessions**:
  - Builds on Session 4 (Selection Constructs) by using relational and logical operators in conditions.
  - Prepares for Session 6 (Iteration Constructs) by introducing expressions used in loops.