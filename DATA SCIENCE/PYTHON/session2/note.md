# Session 2 – Programming Language Constructs

## Objectives
- Explain the data types in Python, including Numeric, String, Sequence, Mapping, Boolean, and Set data types.
- Describe the working of operators, including Arithmetic, Assignment, Comparison, Logical, Membership, Identity, and Bitwise operators.
- Explain the working of the control flow statements (`if`, `elif`, `else`).

## Key Topics

### 1. Data Types in Python
- **Numeric Types**:
  - `int`: Represents whole numbers (e.g., `5`, `-10`).
  - `float`: Represents decimal numbers (e.g., `3.14`, `-0.001`).
  - `complex`: Represents complex numbers with real and imaginary parts (e.g., `3 + 4j`).
  - Check type with `type(5)` returns `<class 'int'>`.
- **String Type**:
  - `str`: Represents text data enclosed in single (`'`) or double (`"`) quotes (e.g., `"Hello"`, `'Python'`).
  - Immutable; supports concatenation (`"Hello" + "World"` → `"HelloWorld"`) and indexing (e.g., `"Hello"[0]` → `'H'`).
- **Sequence Types**:
  - `list`: Ordered, mutable collection (e.g., `[1, 2, 3]`, can change elements).
  - `tuple`: Ordered, immutable collection (e.g., `(1, 2, 3)`).
  - `range`: Sequence of numbers (e.g., `range(5)` generates 0 to 4).
- **Mapping Type**:
  - `dict`: Collection of key-value pairs (e.g., `{"name": "Alice", "age": 25}`).
  - Keys must be immutable; values can be any type.
- **Boolean Type**:
  - `bool`: Represents `True` or `False`, used for logical operations.
  - Example: `5 > 3` returns `True`.
- **Set Types**:
  - `set`: Unordered collection of unique elements (e.g., `{1, 2, 3}`).
  - `frozenset`: Immutable version of set.
  - Useful for operations like union (`|`), intersection (`&`).

### 2. Working of Operators
- **Arithmetic Operators**:
  - Perform mathematical operations: `+` (addition), `-` (subtraction), `*` (multiplication), `/` (division), `//` (floor division), `%` (modulus), `**` (exponentiation).
  - Example: `5 + 3` → `8`, `10 // 3` → `3`.
- **Assignment Operators**:
  - Assign values: `=` (e.g., `x = 5`).
  - Compound: `+=` (e.g., `x += 2` → `x = x + 2`), `-=`, `*=`, `/=`, etc.
- **Comparison Operators**:
  - Compare values: `==` (equal), `!=` (not equal), `>` (greater than), `<` (less than), `>=`, `<=`.
  - Example: `5 == 5` → `True`, `6 > 3` → `True`.
- **Logical Operators**:
  - Combine conditions: `and` (both true), `or` (either true), `not` (negation).
  - Example: `True and False` → `False`, `not True` → `False`.
- **Membership Operators**:
  - Check presence: `in` (e.g., `3 in [1, 2, 3]` → `True`), `not in`.
- **Identity Operators**:
  - Compare object identity: `is` (same object), `is not`.
  - Example: `x = [1, 2]; y = x; x is y` → `True` (same memory location).
- **Bitwise Operators**:
  - Operate on binary: `&` (AND), `|` (OR), `^` (XOR), `~` (NOT), `<<` (left shift), `>>` (right shift).
  - Example: `5 & 3` (binary `101 & 011` → `001` → `1`).

### 3. Working of Control Flow Statements
- **If Statement**:
  - Executes a block if a condition is `True`.
  - Syntax: `if condition: <block>`.
  - Example: `if x > 0: print("Positive")`.
- **Elif Statement**:
  - Checks additional conditions if previous `if`/`elif` fails.
  - Syntax: `elif condition: <block>`.
  - Example: `elif x < 0: print("Negative")`.
- **Else Statement**:
  - Executes if no conditions are `True`.
  - Syntax: `else: <block>`.
  - Example: `else: print("Zero")`.
- **Combined Example**:
  ```python
  x = 10
  if x > 0:
      print("Positive")
  elif x == 0:
      print("Zero")
  else:
      print("Negative")
  ```
  **Output**: `Positive`.
- **Key Notes**:
  - Conditions use boolean logic; indentation defines blocks.
  - Can nest statements for complex logic.
  - Example: `if x > 0: if x % 2 == 0: print("Even positive")`.

## Hands-on: Write a Notebook to Generate Fibonacci Numbers
- Create a Jupyter Notebook named `fibonacci_generator.ipynb`.
- Use control flow and operators to generate Fibonacci numbers.
- Solution Code:
  ```python
  # Fibonacci Generator
  n = int(input("Enter number of Fibonacci numbers: "))
  if n <= 0:
      print("Please enter a positive number.")
  else:
      fib = [0, 1]
      while len(fib) < n:
          fib.append(fib[-1] + fib[-2])
      print(f"The first {n} Fibonacci numbers are: {fib[:n]}")
  ```
- **Explanation**:
  - `if` checks for valid input.
  - `while` loop uses `+` operator to compute Fibonacci numbers.
  - List `append()` builds the sequence.