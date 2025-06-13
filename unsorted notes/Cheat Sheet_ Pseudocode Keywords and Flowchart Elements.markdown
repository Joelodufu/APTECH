# Cheat Sheet: Pseudocode Keywords and Flowchart Elements

## Part 1: Pseudocode Keywords

Pseudocode is a high-level, human-readable description of an algorithm using plain language and structured syntax. It uses specific keywords to represent actions, decisions, and flow control. Below are common pseudocode keywords, their meanings, and examples.

| **Keyword**       | **Meaning**                                                                 | **Example**                                                                 |
|-------------------|-----------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| **START**         | Marks the beginning of the algorithm.                                       | `START`<br> Begins the program to calculate the sum of two numbers.         |
| **END**           | Marks the end of the algorithm.                                             | `END`<br> Concludes the program after outputting the result.                |
| **INPUT**         | Accepts data from the user or another source.                                | `INPUT number1, number2`<br> Prompts user to enter two numbers.             |
| **OUTPUT**        | Displays or returns a result to the user.                                    | `OUTPUT "Sum is ", sum`<br> Displays the sum of two numbers.                |
| **IF ... THEN**   | Executes a block of code if a condition is true.                            | `IF age >= 18 THEN`<br>`OUTPUT "Adult"`<br> Checks if a person is an adult. |
| **ELSE**          | Executes an alternative block if the IF condition is false.                 | `ELSE`<br>`OUTPUT "Minor"`<br> Outputs "Minor" if age < 18.                |
| **ELSE IF**       | Tests additional conditions if the initial IF condition is false.           | `ELSE IF score >= 60 THEN`<br>`OUTPUT "Pass"`<br> Checks for passing score. |
| **END IF**        | Marks the end of an IF block.                                               | `END IF`<br> Closes the IF-ELSE structure for age checking.                 |
| **SET** or **=**  | Assigns a value to a variable.                                              | `SET total = price * quantity`<br> Calculates total cost.                   |
| **AND**           | Logical operator requiring both conditions to be true.                      | `IF age >= 16 AND hasLicense = "Yes" THEN`<br> Checks driving eligibility.  |
| **OR**            | Logical operator requiring at least one condition to be true.               | `IF age >= 18 OR hasAdult = "Yes" THEN`<br> Allows movie entry.            |
| **NOT**           | Negates a condition.                                                       | `IF NOT (score < 60) THEN`<br> Checks if score is not failing.             |

### Additional Notes on Pseudocode
- **Syntax**: Pseudocode is flexible but should be clear and structured. Use indentation for blocks (e.g., under IF-THEN).
- **Variables**: Declare variables implicitly by using them (e.g., `sum = number1 + number2`).
- **Example Program** (Calculate Discount):
  ```
  START
  INPUT price, isStudent
  IF isStudent = "Yes" THEN
      SET discount = price * 0.1
      SET finalPrice = price - discount
      OUTPUT "Student discount applied: ", finalPrice
  ELSE
      OUTPUT "No discount, pay: ", price
  END IF
  END
  ```

## Part 2: Flowchart Elements

Flowcharts are visual representations of algorithms using standardized symbols to depict steps, decisions, and flow. Below are the common flowchart elements, their meanings, and examples.

| **Symbol**         | **Name**            | **Meaning**                                                                 | **Example**                                                                 |
|--------------------|---------------------|-----------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| **Oval**           | Start/End           | Marks the beginning or end of the algorithm.                                | **Start**: Begins a flowchart to check if a number is even.<br>**End**: Concludes after output. |
| **Rectangle**      | Process             | Represents a processing step or action (e.g., calculation, assignment).     | `sum = number1 + number2`<br> Calculates the sum of two numbers.            |
| **Diamond**        | Decision            | Represents a decision point with a condition (e.g., yes/no question).       | `Is number > 0?`<br> Decides if a number is positive (Yes/No paths).        |
| **Parallelogram**  | Input/Output        | Indicates input from the user or output to the user.                        | **Input**: `Enter number1, number2`<br>**Output**: `Display "Sum is ", sum` |
| **Arrow**          | Flow Line           | Shows the direction of the process flow, connecting symbols.                | Arrow from Input to Decision, guiding the sequence of steps.                |
| **Circle**         | Connector           | Connects parts of a flowchart across pages or sections (less common).       | Links a decision to another page for a large flowchart.                     |

### Example Flowchart: Check if a Number is Even or Odd
- **Description**: A flowchart to determine if a user-entered number is even or odd.
- **Visual Description** (text-based for clarity):
  ```
  [Start: Oval]
       ↓
  [Input number: Parallelogram]
       ↓
  [Is number % 2 == 0?: Diamond]
       ↓ Yes            ↓ No
  [Output "Even": Parallelogram]  [Output "Odd": Parallelogram]
       ↓                          ↓
  [End: Oval]                [End: Oval]
  ```
- **Explanation**:
  - **Start**: Initiates the process.
  - **Input**: User enters a number (e.g., 4).
  - **Decision**: Checks if number % 2 == 0 (e.g., 4 % 2 = 0, so Yes).
  - **Output**: Displays "Even" (or "Odd" if No).
  - **End**: Terminates the flowchart.

### Combined Example: Temperature Check
- **Problem**: Create a flowchart and pseudocode to classify temperature as "Hot" (> 30°C), "Comfortable" (15–30°C), or "Cold" (< 15°C).
- **Pseudocode**:
  ```
  START
  INPUT temperature
  IF temperature > 30 THEN
      OUTPUT "Hot"
  ELSE IF temperature >= 15 THEN
      OUTPUT "Comfortable"
  ELSE
      OUTPUT "Cold"
  END IF
  END
  ```
- **Flowchart** (text-based description):
  ```
  [Start: Oval]
       ↓
  [Input temperature: Parallelogram]
       ↓
  [temperature > 30?: Diamond]
       ↓ Yes            ↓ No
  [Output "Hot": Parallelogram]  [temperature >= 15?: Diamond]
       ↓                          ↓ Yes            ↓ No
  [End: Oval]               [Output "Comfortable": Parallelogram]  [Output "Cold": Parallelogram]
                                       ↓                          ↓
                                  [End: Oval]                [End: Oval]
  ```