# Multiple-Choice Questions for Sessions 3 to 6

## Session 3: Flowcharts and Pseudocodes
1. What is the primary purpose of pseudocode?
   - A) To execute a program directly
   - B) To describe an algorithm in human-readable form
   - C) To create a flowchart
   - D) To debug hardware issues
   - **Answer**: B
   - **Explanation**: Pseudocode is a high-level, plain-language description of an algorithm, designed to be readable by humans, not executed by computers.

2. Which flowchart symbol represents a decision point?
   - A) Rectangle
   - B) Oval
   - C) Diamond
   - D) Parallelogram
   - **Answer**: C
   - **Explanation**: The diamond symbol in a flowchart indicates a decision, such as a yes/no question, splitting the flow into multiple paths.

3. In pseudocode, what does the keyword `INPUT` do?
   - A) Displays a result
   - B) Accepts data from the user
   - C) Ends the program
   - D) Performs a calculation
   - **Answer**: B
   - **Explanation**: `INPUT` prompts the user to provide data, which is stored in variables (e.g., `INPUT age`).

4. Which flowchart symbol is used for the start or end of a program?
   - A) Oval
   - B) Rectangle
   - C) Diamond
   - D) Arrow
   - **Answer**: A
   - **Explanation**: The oval symbol marks the beginning (`Start`) or end (`End`) of a flowchart.

5. What is the output of this pseudocode?
   ```
   START
   INPUT number
   OUTPUT number * 2
   END
   ```
   If `number = 5`:
   - A) 5
   - B) 10
   - C) 2
   - D) No output
   - **Answer**: B
   - **Explanation**: The pseudocode doubles the input (`5 * 2 = 10`) and outputs the result.

6. In a flowchart, what does a parallelogram represent?
   - A) A process step
   - B) Input or output
   - C) A decision
   - D) A loop
   - **Answer**: B
   - **Explanation**: A parallelogram is used for input (e.g., user data) or output (e.g., displaying results).

7. What is wrong with this pseudocode?
   ```
   INPUT age
   OUTPUT age
   ```
   - A) Missing arithmetic operation
   - B) Missing START and END
   - C) Incorrect keyword
   - D) No variables
   - **Answer**: B
   - **Explanation**: Pseudocode typically includes `START` and `END` to define the program’s boundaries.

8. Which pseudocode keyword marks the end of an algorithm?
   - A) BEGIN
   - B) STOP
   - C) END
   - D) OUTPUT
   - **Answer**: C
   - **Explanation**: `END` signifies the conclusion of the pseudocode algorithm.

9. In a flowchart, what connects different symbols to show the process flow?
   - A) Circles
   - B) Arrows
   - C) Squares
   - D) Lines
   - **Answer**: B
   - **Explanation**: Arrows indicate the direction of flow between flowchart symbols.

10. What does this flowchart do? (Text-based description: Start → Input x → Output x + 1 → End)
    - A) Subtracts 1 from the input
    - B) Outputs the input as is
    - C) Adds 1 to the input and outputs it
    - D) Multiplies the input by 1
    - **Answer**: C
    - **Explanation**: The flowchart takes an input `x`, adds 1, and outputs the result (e.g., if `x = 3`, outputs `4`).

## Session 4: Selection Constructs
1. What is the purpose of a selection construct?
   - A) To repeat code multiple times
   - B) To make decisions based on conditions
   - C) To store data
   - D) To perform calculations
   - **Answer**: B
   - **Explanation**: Selection constructs (e.g., if-then-else) allow programs to choose actions based on conditions.

2. Which pseudocode structure is used for a simple decision?
   - A) IF-THEN
   - B) FOR
   - C) WHILE
   - D) DO-WHILE
   - **Answer**: A
   - **Explanation**: `IF-THEN` executes a block if a condition is true, suitable for simple decisions.

3. What does this pseudocode output if `score = 75`?
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
   - **Answer**: A
   - **Explanation**: Since `75 >= 60`, the condition is true, outputting "Pass".

4. Which operator checks for equality in a condition?
   - A) >
   - B) ==
   - C) <
   - D) ≠
   - **Answer**: B
   - **Explanation**: `==` compares two values for equality in selection constructs.

5. What is a nested IF statement?
   - A) An IF statement inside another IF statement
   - B) A loop inside an IF statement
   - C) An IF statement with no ELSE
   - D) Multiple IF statements in sequence
   - **Answer**: A
   - **Explanation**: A nested IF is an IF statement within another, used for complex decisions.

6. What does this pseudocode output if `age = 16`, `hasPermit = "Yes"`?
   ```
   IF age >= 16 AND hasPermit == "Yes" THEN
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
   - **Explanation**: Both conditions (`age >= 16` and `hasPermit == "Yes"`) are true, so it outputs "Can drive".

7. Which logical operator requires at least one condition to be true?
   - A) AND
   - B) OR
   - C) NOT
   - D) NONE
   - **Answer**: B
   - **Explanation**: `OR` is true if either or both conditions are true.

8. What is wrong with this pseudocode?
   ```
   IF temperature > 30 THEN
       OUTPUT "Hot"
   ELSE temperature <= 15
       OUTPUT "Cold"
   END IF
   ```
   - A) Missing END
   - B) ELSE should not have a condition
   - C) Incorrect operator
   - D) No OUTPUT
   - **Answer**: B
   - **Explanation**: `ELSE` cannot have a condition; use `ELSE IF` for additional conditions.

9. What does the `NOT` operator do?
   - A) Combines two conditions
   - B) Negates a condition’s truth value
   - C) Checks for equality
   - D) Multiplies values
   - **Answer**: B
   - **Explanation**: `NOT` reverses a condition (e.g., `NOT (age < 18)` is true if `age >= 18`).

10. What does this pseudocode do if `grade = 85`?
    ```
    IF grade >= 90 THEN
        OUTPUT "A"
    ELSE IF grade >= 80 THEN
        OUTPUT "B"
    ELSE
        OUTPUT "C"
    END IF
    ```
    - A) Outputs A
    - B) Outputs B
    - C) Outputs C
    - D) No output
    - **Answer**: B
    - **Explanation**: Since `85 >= 80` but `85 < 90`, the `ELSE IF` condition is true, outputting "B".

## Session 5: Operators
1. What does the `%` operator do?
   - A) Multiplies two numbers
   - B) Returns the remainder after division
   - C) Adds two numbers
   - D) Compares equality
   - **Answer**: B
   - **Explanation**: The modulo operator `%` returns the remainder (e.g., `7 % 3 = 1`).

2. Which operator checks if a value is greater than or equal to another?
   - A) <
   - B) >=
   - C) ==
   - D) ≠
   - **Answer**: B
   - **Explanation**: `>=` compares if the left value is greater than or equal to the right.

3. What is the result of `6 + 4 * 2`?
   - A) 20
   - B) 14
   - C) 16
   - D) 10
   - **Answer**: B
   - **Explanation**: `*` has higher precedence, so `4 * 2 = 8`, then `6 + 8 = 14`.

4. What does this pseudocode output if `age = 14`, `hasParent = "Yes"`?
   ```
   IF age >= 15 OR hasParent == "Yes" THEN
       OUTPUT "Allowed"
   ELSE
       OUTPUT "Not allowed"
   END IF
   ```
   - A) Allowed
   - B) Not allowed
   - C) No output
   - D) Error
   - **Answer**: A
   - **Explanation**: The `OR` condition is true since `hasParent == "Yes"`, outputting "Allowed".

5. What is the purpose of the `+=` operator?
   - A) Compares two values
   - B) Adds a value and assigns the result
   - C) Subtracts a value
   - D) Negates a condition
   - **Answer**: B
   - **Explanation**: `+=` adds a value to a variable and updates it (e.g., `x += 5` is `x = x + 5`).

6. Which logical operator requires both conditions to be true?
   - A) OR
   - B) AND
   - C) NOT
   - D) NONE
   - **Answer**: B
   - **Explanation**: `AND` is true only if both conditions are true.

7. What is wrong with this pseudocode?
   ```
   INPUT price
   discount = price * 0.2
   price =- discount
   OUTPUT price
   ```
   - A) Incorrect operator (`=-` instead of `-=`)
   - B) Missing condition
   - C) No loop
   - D) No START/END
   - **Answer**: A
   - **Explanation**: The operator `=-` is incorrect; `-=` subtracts and assigns.

8. What does the `/` operator do?
   - A) Returns the remainder
   - B) Divides two numbers
   - C) Multiplies two numbers
   - D) Checks inequality
   - **Answer**: B
   - **Explanation**: `/` performs division (e.g., `10 / 2 = 5`).

9. What is the output of this pseudocode if `balance = 200`, `deposit = 50`?
   ```
   balance += deposit
   OUTPUT balance
   ```
   - A) 200
   - B) 250
   - C) 150
   - D) 50
   - **Answer**: B
   - **Explanation**: `balance += 50` adds 50 to 200, so `balance = 250`.

10. What is the result of `NOT (score < 60)` if `score = 70`?
    - A) True
    - B) False
    - C) 60
    - D) Error
    - **Answer**: A
    - **Explanation**: `score < 60` is false (since `70 < 60` is false), so `NOT false = true`.

## Session 6: Iteration Constructs
1. What is the purpose of an iteration construct?
   - A) To make a single decision
   - B) To repeat a block of code
   - C) To store data
   - D) To end a program
   - **Answer**: B
   - **Explanation**: Loops (iteration constructs) repeat code until a condition is met or for a set number of times.

2. Which loop checks its condition after executing the body at least once?
   - A) While
   - B) For
   - C) Do-While
   - D) None
   - **Answer**: C
   - **Explanation**: Do-while loops execute the body first, then check the condition.

3. What does this pseudocode output?
   ```
   SET counter = 1
   WHILE