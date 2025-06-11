# Class Note: Structured Programming (Session 7)

## Overview
Structured programming is a methodology that promotes writing clear, organized, and maintainable code using well-defined control structures and modular design. It relies on **sequence**, **selection**, and **iteration** to create programs that are easy to understand and modify. This session explores principles like modularity, top-down design, and the use of procedures, implemented in pseudocode and flowcharts. By the end of this class, you will be able to design modular algorithms, write structured pseudocode, and create flowcharts for efficient, readable programs.

## Learning Objectives
- Understand the core principles of structured programming.
- Apply sequence, selection, and iteration control structures in program design.
- Create modular programs using procedures in pseudocode.
- Use top-down design to decompose complex problems into simpler modules.
- Develop flowcharts and pseudocode for structured solutions to practical problems.

## Key Concepts
1. **What Is Structured Programming?**
   - A programming approach that organizes code into logical, modular units to enhance clarity, reduce errors, and improve maintainability.
   - Uses three control structures:
     - **Sequence**: Statements executed in order.
     - **Selection**: Decision-making with if-then-else (Session 4).
     - **Iteration**: Repetition with loops (Session 6).
   - Avoids unstructured practices like "goto" statements, which lead to complex, error-prone code.

2. **Core Principles**
   - **Modularity**: Breaking a program into smaller, reusable modules (procedures) that perform specific tasks.
   - **Top-Down Design**: Starting with a high-level problem and refining it into detailed subproblems and modules.
   - **Single Entry, Single Exit**: Each module or control structure has one entry point and one exit point.
   - **Clarity and Readability**: Using meaningful variable names, consistent indentation, and comments for documentation.

3. **Procedures in Pseudocode**
   - A **procedure** is a named block of code that encapsulates a task and can be called with parameters.
   - Syntax:
     ```
     PROCEDURE name(parameter1, parameter2, ...)
         action(s)
         [RETURN value]
     END PROCEDURE
     ```
   - Example: A procedure to calculate a discount can be reused across multiple programs.

4. **Top-Down Design Process**
   - **Step 1**: Identify the main problem (e.g., "Process a movie ticket purchase").
   - **Step 2**: Divide it into subproblems (e.g., calculate ticket cost, apply discount, print receipt).
   - **Step 3**: Create modules (procedures) for each subproblem.
   - **Step 4**: Refine modules with pseudocode or flowcharts.

5. **Flowchart Representation**
   - **Rectangles**: Represent actions or procedure calls.
   - **Diamonds**: Represent decisions (selection).
   - **Arrows with Loops**: Represent iteration.
   - **Subprocess Symbol** (optional): A rectangle with double vertical lines for procedure calls.
   - Example: A main flowchart calls procedure sub-flowcharts for modularity.

## Examples
1. **Sequence: Calculate Electricity Bill**
   - **Problem**: Compute an electricity bill based on units consumed (rate = $0.15/unit).
   - **Pseudocode**:
     ```
     START
     INPUT units
     cost = units * 0.15
     OUTPUT "Electricity bill: $", cost
     END
     ```
   - **Flowchart** (text-based):
     ```
     [Start] → [Input units] → [cost = units * 0.15] → [Output "Electricity bill: $", cost] → [End]
     ```
   - **Explanation**: Demonstrates sequence with linear execution of steps.

2. **Modularity with Procedures: Movie Ticket Pricing**
   - **Problem**: Calculate the total cost of movie tickets with procedures for ticket cost and discount.
   - **Pseudocode**:
     ```
     PROCEDURE CalculateTicketCost(age)
         IF age <= 12 THEN
             SET price = 5
         ELSE IF age >= 65 THEN
             SET price = 7
         ELSE
             SET price = 10
         END IF
         RETURN price
     END PROCEDURE

     PROCEDURE ApplyDiscount(total)
         IF total > 50 THEN
             SET discount = total * 0.1
         ELSE
             SET discount = 0
         END IF
         RETURN discount
     END PROCEDURE

     START
     INPUT age, quantity
     SET ticketPrice = CalculateTicketCost(age)
     SET total = ticketPrice * quantity
     SET discount = ApplyDiscount(total)
     SET finalTotal = total - discount
     OUTPUT "Total before discount: $", total
     OUTPUT "Discount: $", discount
     OUTPUT "Final total: $", finalTotal
     END
     ```
   - **Flowchart** (main, text-based):
     ```
     [Start] → [Input age, quantity] → [Call CalculateTicketCost] → [total = ticketPrice * quantity] → [Call ApplyDiscount] → [finalTotal = total - discount] → [Output total, discount, finalTotal] → [End]
     ```
   - **Explanation**: Procedures separate ticket pricing and discount logic, enhancing modularity.

3. **Top-Down Design: Library Fine Calculator**
   - **Problem**: Calculate library fines based on overdue days for multiple books.
   - **Top-Down Design**:
     - Main: Input book details, calculate total fine, output report.
     - Modules:
       - InputBookDetails: Collect book name and overdue days.
       - CalculateFine: Compute fine for one book ($1/day).
       - OutputReport: Display total fine.
   - **Pseudocode**:
     ```
     PROCEDURE InputBookDetails
         INPUT bookName, overdueDays
         RETURN bookName, overdueDays
     END PROCEDURE

     PROCEDURE CalculateFine(overdueDays)
         SET fine = overdueDays * 1
         RETURN fine
     END PROCEDURE

     PROCEDURE OutputReport(totalFine)
         OUTPUT "Total fine: $", totalFine
     END PROCEDURE

     START
     SET totalFine = 0
     FOR i = 1 TO 3
         SET bookName, overdueDays = InputBookDetails
         SET fine = CalculateFine(overdueDays)
         totalFine = totalFine + fine
         OUTPUT bookName, " fine: $", fine
     END FOR
     OutputReport(totalFine)
     END
     ```
   - **Flowchart** (main, text-based):
     ```
     [Start] → [totalFine = 0, i = 1] → [i <= 3?] → Yes → [Call InputBookDetails] → [Call CalculateFine] → [totalFine = totalFine + fine] → [Output bookName, fine] → [i = i + 1] → [Back to i <= 3?]
                                             ↓ No
                                        [Call OutputReport] → [End]
     ```
   - **Explanation**: Top-down design organizes the program into input, calculation, and output modules.

4. **Combining Control Structures: Temperature Monitor**
   - **Problem**: Monitor daily temperatures, alerting if any exceed 30°C, using a procedure for alerts.
   - **Pseudocode**:
     ```
     PROCEDURE TemperatureAlert(temperature)
         IF temperature > 30 THEN
             OUTPUT "High temperature alert: ", temperature, "°C"
         END IF
     END PROCEDURE

     START
     FOR day = 1 TO 7
         INPUT temperature
         TemperatureAlert(temperature)
     END FOR
     END
     ```
   - **Flowchart** (main, text-based):
     ```
     [Start] → [day = 1] → [day <= 7?] → Yes → [Input temperature] → [Call TemperatureAlert] → [day = day + 1] → [Back to day <= 7?]
                                       ↓ No
                                    [End]
     ```
     - **TemperatureAlert Flowchart**:
       ```
       [Start TemperatureAlert] → [temperature > 30?] → Yes → [Output alert] → [End TemperatureAlert]
                                            ↓ No
                                         [End TemperatureAlert]
       ```
   - **Explanation**: Combines iteration (for loop), selection (if-then), and modularity (procedure).

## Classwork Activities
1. **Pseudocode Writing**:
   - **Task**: Write pseudocode for a program with a procedure to calculate the perimeter of a rectangle.
     - Main: Input length and width, call the procedure, output the result.
     - Procedure: Compute perimeter (2 * (length + width)).
   - **Expected Pseudocode**:
     ```
     PROCEDURE CalculatePerimeter(length, width)
         SET perimeter = 2 * (length + width)
         RETURN perimeter
     END PROCEDURE

     START
     INPUT length, width
     SET perimeter = CalculatePerimeter(length, width)
     OUTPUT "Perimeter: ", perimeter
     END
     ```

2. **Flowchart Design**:
   - **Task**: Create a flowchart for a program that processes customer orders.
     - Main: Input order amounts until a negative amount is entered, call a procedure to calculate total.
     - Procedure: Sum order amounts.
   - **Expected Flowchart** (main, text-based):
     ```
     [Start] → [total = 0] → [Input amount] → [amount >= 0?] → Yes → [total = total + amount] → [Back to Input amount]
                                            ↓ No
                                       [Output "Total: $", total] → [End]
     ```

3. **Error Correction**:
   - **Task**: Fix errors in this pseudocode:
     ```
     PROCEDURE calculateBonus(sales)
         bonus = sales * 0.05
         RETURN
     END
     INPUT sales
     OUTPUT calculateBonus(sales)
     ```
   - **Issues**:
     - `RETURN` missing `bonus`.
     - Missing `END PROCEDURE`.
     - No `START/END`.
     - `OUTPUT` needs assignment of procedure result.
   - **Corrected Pseudocode**:
     ```
     PROCEDURE CalculateBonus(sales)
         SET bonus = sales * 0.05
         RETURN bonus
     END PROCEDURE

     START
     INPUT sales
     SET bonus = CalculateBonus(sales)
     OUTPUT "Bonus: $", bonus
     END
     ```

4. **Group Activity: Real-World Scenario**:
   - **Task**: In pairs, design pseudocode and a flowchart for a program that manages a car rental system:
     - Main: Input rental days and car type (economy, luxury), call procedures to calculate base cost and insurance.
     - Procedures:
       - CalculateBaseCost: $30/day for economy, $50/day for luxury.
       - CalculateInsurance: 10% of base cost.
     - Output: Base cost, insurance, total.
   - **Example Pseudocode**:
     ```
     PROCEDURE CalculateBaseCost(days, carType)
         IF carType == "economy" THEN
             SET cost = days * 30
         ELSE
             SET cost = days * 50
         END IF
         RETURN cost
     END PROCEDURE

     PROCEDURE CalculateInsurance(baseCost)
         SET insurance = baseCost * 0.1
         RETURN insurance
     END PROCEDURE

     START
     INPUT days, carType
     SET baseCost = CalculateBaseCost(days, carType)
     SET insurance = CalculateInsurance(baseCost)
     SET total = baseCost + insurance
     OUTPUT "Base cost: $", baseCost
     OUTPUT "Insurance: $", insurance
     OUTPUT "Total: $", total
     END
     ```
   - **Discussion**: Share solutions and discuss how modularity simplifies maintenance.

## Objective Questions (Multiple Choice)
Test your understanding of structured programming with the following questions:

1. What does structured programming emphasize?
   - A) Complex code with goto statements
   - B) Clear, modular, and maintainable code
   - C) Avoiding control structures
   - D) Writing code without procedures
   - **Answer**: B

2. Which control structure executes statements in order?
   - A) Selection
   - B) Iteration
   - C) Sequence
   - D) Modularity
   - **Answer**: C

3. What is the benefit of modularity?
   - A) Increases code complexity
   - B) Makes code reusable and easier to maintain
   - C) Eliminates the need for loops
   - D) Requires more goto statements
   - **Answer**: B

4. In top-down design, what comes after defining the main problem?
   - A) Write final code
   - B) Divide into subproblems
   - C) Execute the program
   - D) Debug errors
   - **Answer**: B

5. What does this procedure do?
   ```
   PROCEDURE CalculateTax(amount)
       SET tax = amount * 0.07
       RETURN tax
   END PROCEDURE
   ```
   - A) Calculates 7% tax
   - B) Doubles the amount
   - C) Subtracts 7 from the amount
   - D) Divides the amount by 7
   - **Answer**: A

6. What is wrong with this pseudocode?
   ```
   PROCEDURE CalculateAverage(score1, score2)
       average = (score1 + score2) / 2
       RETURN average
   START
       INPUT score1, score2
       OUTPUT CalculateAverage
   END
   ```
   - A) Missing END PROCEDURE
   - B) Incorrect procedure call
   - C) No loop
   - D) No selection
   - **Answer**: B

7. In a flowchart, what symbol is used for a procedure call?
   - A) Diamond
   - B) Rectangle
   - C) Oval
   - D) Parallelogram
   - **Answer**: B

8. What is the output of this pseudocode if length = 4, width = 3?
   ```
   PROCEDURE CalculateArea(length, width)
       SET area = length * width
       RETURN area
   END PROCEDURE
   START
       INPUT length, width
       SET area = CalculateArea(length, width)
       OUTPUT area
   END
   ```
   - A) 12
   - B) 7
   - C) 24
   - D) 0
   - **Answer**: A

9. What does the single entry, single exit principle ensure?
   - A) Multiple entry points for modules
   - B) One entry and one exit per module
   - C) No returns in procedures
   - D) Complex loop structures
   - **Answer**: B

10. Why avoid goto statements in structured programming?
    - A) They simplify code
    - B) They make code harder to follow
    - C) They are required for modularity
    - D) They improve readability
    - **Answer**: B

## Homework
1. **Pseudocode Practice**:
   - Write pseudocode for a program with a procedure to calculate the volume of a cube (side³).
     - Main: Input side length, call the procedure, output the result.
2. **Flowchart Creation**:
   - Design a flowchart for a program that processes student attendance:
     - Main: Input attendance status (present/absent) for 5 students, call a procedure to count present students.
     - Procedure: Count and return number of present students.
3. **Real-World Application**:
   - Describe a scenario where structured programming is used (e.g., managing a bookstore inventory). Write a short paragraph and pseudocode with at least one procedure.
4. **Debugging Challenge**:
   - Fix this pseudocode:
     ```
     PROCEDURE CalculateInterest(principal, rate)
         interest = principal * rate
         RETURN
     START
         INPUT principal, rate
         OUTPUT CalculateInterest(principal, rate)
     END
     ```
     - Issues: `RETURN` missing `interest`, missing `END PROCEDURE`, incorrect `OUTPUT`.
     - Provide the corrected version.

## Additional Notes
- **Teaching Tips**:
  - **Duration**: 2–3 class periods (3–4.5 hours).
    - **Period 1**: Sequence, modularity, Examples 1 and 2, Activity 1.
    - **Period 2**: Top-down design, Examples 3 and 4, Activities 2 and 3.
    - **Period 3 (optional)**: Activity 4, review, quiz.
  - **Visual Aids**: Illustrate top-down design with a diagram (e.g., breaking down a movie ticket system).
  - **Engagement**: Use relatable scenarios (e.g., library fines, car rentals).
  - **Differentiation**:
    - Beginners: Focus on simple procedures with sequence.
    - Advanced: Introduce parameter passing or nested procedures.
- **Resources**:
  - Flowchart tools: Draw.io, Lucidchart, or paper templates.
  - Text editor for pseudocode: Notepad++, Visual Studio Code.
- **Assessment**:
  - Use objective questions for a quiz or homework.
  - Grade classwork for correct procedure syntax, modularity, and flowchart logic.
- **Extension**:
  - Implement a pseudocode example in Python:
    ```python
    def calculate_ticket_cost(age):
        if age <= 12:
            return 5
        elif age >= 65:
            return 7
        else:
            return 10

    age = int(input("Enter age: "))
    quantity = int(input("Enter quantity: "))
    ticket_price = calculate_ticket_cost(age)
    total = ticket_price * quantity
    print("Total: $", total)
    ```
- **Connections**:
  - Builds on Sessions 4–6 for control structures.
  - Prepares for Session 8 (Arrays) by establishing modular design.