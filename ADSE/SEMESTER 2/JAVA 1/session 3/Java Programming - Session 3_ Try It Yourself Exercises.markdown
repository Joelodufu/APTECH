# Java Programming - I: Session 3 - Try It Yourself Exercises

## Session Objectives
This session focuses on reinforcing the concepts from Sessions 1 and 2 through practical "Try It Yourself" exercises from *Java Programming - The Complete Guide for Beginners*. By the end, you will:
- Apply knowledge of Java’s programming paradigms and platform setup.
- Practice variable declaration, data types, and operator usage.
- Implement decision-making constructs (if, switch-case) and loops (while, do-while, for).
- Solve hands-on coding problems to solidify understanding.
- Debug and run programs in Visual Studio Code (VS Code).

This session assumes you have set up your Java environment in VS Code (JDK 20, Java Extension Pack) as covered in Session 1.

## Sub-Session 1: Introduction to Java
### Definition
Java is a platform-independent, object-oriented programming language that supports structured and object-oriented paradigms, executed via the Java Virtual Machine (JVM).

### Explanation
- **Structured Programming**: Uses sequential code with control structures (e.g., loops, conditionals).
- **Object-Oriented Programming (OOP)**: Organizes code into classes and objects, supporting encapsulation, inheritance, polymorphism, and abstraction.
- **Java Platform**: Includes JVM (executes bytecode), JRE (runtime libraries), and JDK (development tools).
- **Java Editions**: Java SE (desktop), Java EE (enterprise), Java ME (mobile), JavaFX (GUIs).
- **Java SE Evolution**: From JDK 1.0 (1996) to JDK 20 (2023) with features like lambda expressions and virtual threads.

### Examples
1. Verify JDK installation:
   ```bash
   java -version
   javac -version
   ```
   Output:
   ```
   java version "20.0.1" 2023-04-18
   javac 20.0.1
   ```
2. Simple Java program:
   ```java
   public class HelloJava {
       public static void main(String[] args) {
           System.out.println("Welcome to Java Programming!");
       }
   }
   ```

### Class Work
1. Write a program that prints "Java is platform-independent!" to the console.
2. In VS Code, create a new Java file and run it to display your name and the course title.
3. Verify your JDK setup by running `java -version` and `javac -version` in the VS Code terminal.

## Sub-Session 2: Variables and Data Types
### Definition
Variables are named memory locations that store data of specific types (primitive or reference). Data types define the kind and size of data a variable can hold.

### Explanation
- **Variables**: Declared with a data type and name; initialized with a value.
  - Syntax: `dataType variableName = value;`
  - Naming: CamelCase, no keywords, meaningful names.
- **Primitive Types**: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`.
- **Reference Types**: Objects like `String`, arrays.
- **Escape Sequences**: Special characters (e.g., `\n`, `\t`) for string formatting.
- **Format Specifiers**: Used in `printf` (e.g., `%d`, `%f`, `%s`).

### Examples
1. Variable declaration and formatting:
   ```java
   int age = 22;
   double height = 5.8;
   String name = "Bob";
   System.out.printf("Name: %s\nAge: %d\nHeight: %.1f\n", name, age, height);
   ```
   Output:
   ```
   Name: Bob
   Age: 22
   Height: 5.8
   ```
2. Escape sequence:
   ```java
   System.out.println("Java\tProgramming");
   ```
   Output: `Java    Programming`

### Class Work
1. Declare an `int` variable `quantity` (value 50) and a `String` variable `item` (value "Books").
2. Use `printf` to print: `Item: Books, Quantity: 50`.
3. Write a program that uses `\n` to print your name and age on separate lines.

## Sub-Session 3: Operators
### Definition
Operators are symbols that perform operations on variables/values, such as arithmetic, relational, logical, or assignment operations.

### Explanation
- **Arithmetic**: `+`, `-`, `*`, `/`, `%`, `++`, `--`.
- **Relational**: `==`, `!=`, `>`, `<`, `>=`, `<=`.
- **Logical**: `&&`, `||`, `!`.
- **Assignment**: `=`, `+=`, `-=`, `*=`, `/=`, `%=`.
- **Ternary**: `condition ? valueIfTrue : valueIfFalse`.

### Examples
1. Arithmetic and Assignment:
   ```java
   int x = 10, y = 3;
   System.out.println("Sum: " + (x + y)); // Sum: 13
   x *= 2; // x = x * 2
   System.out.println("x: " + x); // x: 20
   ```
2. Ternary:
   ```java
   int a = 5, b = 8;
   int min = (a < b) ? a : b;
   System.out.println("Min: " + min); // Min: 5
   ```

### Class Work
1. Write a program to calculate the area of a rectangle (length = 10, width = 5) using `*`.
2. Use a relational operator to check if a number is greater than 100.
3. Create a program that uses the ternary operator to determine if a number is positive or negative.

## Sub-Session 4: Type Casting
### Definition
Type casting converts a value from one data type to another, either implicitly (automatic) or explicitly (manual).

### Explanation
- **Implicit Casting**: Smaller type to larger type (e.g., `int` to `double`).
- **Explicit Casting**: Larger type to smaller type (e.g., `double` to `int`), may lose data.
  - Syntax: `(targetType) value`

### Examples
1. Implicit:
   ```java
   int num = 50;
   double d = num; // d = 50.0
   System.out.println(d);
   ```
2. Explicit:
   ```java
   double price = 99.99;
   int intPrice = (int) price; // intPrice = 99
   System.out.println(intPrice);
   ```

### Class Work
1. Convert an `int` (75) to a `double` and print it.
2. Convert a `double` (123.456) to an `int` and print the result.
3. Write a program that demonstrates both implicit and explicit casting for two variables.

## Sub-Session 5: Decision-Making Constructs
### Definition
Decision-making constructs (`if`, `switch-case`) execute code based on conditions.

### Explanation
- **If Statement**: Executes if a condition is true; includes `if`, `if-else`, `if-else-if`.
- **Switch-Case**: Executes a block based on a variable’s value; uses `break` and `default`.
- **Comparison**:
  - `if`: For complex conditions.
  - `switch`: For discrete values (e.g., `int`, `String`).

### Examples
1. If-Else-If:
   ```java
   int marks = 85;
   if (marks >= 90) {
       System.out.println("Grade: A");
   } else if (marks >= 80) {
       System.out.println("Grade: B");
   } else {
       System.out.println("Grade: C");
   }
   ```
2. Switch-Case:
   ```java
   int month = 3;
   switch (month) {
       case 1: System.out.println("January"); break;
       case 2: System.out.println("February"); break;
       case 3: System.out.println("March"); break;
       default: System.out.println("Invalid month");
   }
   ```

### Class Work
1. Write an `if-else` program to check if a number is divisible by 3.
2. Create a `switch-case` program to print a grade (A, B, C) based on a score range.
3. Write a program to classify a temperature (e.g., < 0 = Freezing, 0–20 = Cold, >20 = Warm).

## Sub-Session 6: Loops
### Definition
Loops (`while`, `do-while`, `for`) execute a block of code repeatedly based on a condition.

### Explanation
- **While**: Runs while condition is true.
- **Do-While**: Runs at least once, then checks condition.
- **For**: Ideal for fixed iterations; includes initialization, condition, update.
- **Nested Loops**: Loops within loops.
- **Jump Statements**:
  - `break`: Exits loop/switch.
  - `continue`: Skips current iteration.

### Examples
1. For Loop:
   ```java
   for (int i = 1; i <= 4; i++) {
       System.out.println(i);
   }
   // Output: 1 2 3 4
   ```
2. Do-While with Continue:
   ```java
   int i = 0;
   do {
       i++;
       if (i == 2) continue;
       System.out.println(i);
   } while (i < 4);
   // Output: 1 3 4
   ```

### Class Work
1. Write a `while` loop to print numbers 1 to 5.
2. Create a `for` loop to print odd numbers from 1 to 9.
3. Write a nested loop to print a 2x3 grid of numbers (e.g., `Row 1, Col 1`).

## General Objective Questions
1. What is the role of the Java Virtual Machine (JVM)?
   - a) Compiles Java code
   - b) Executes bytecode
   - c) Manages memory
   - d) Both b and c
   **Answer**: d) Both b and c

2. Which of the following is a valid variable name?
   - a) `2count`
   - b) `my_variable`
   - c) `int`
   - d) `class`
   **Answer**: b) `my_variable`

3. What does the `%f` format specifier do in `printf`?
   - a) Prints an integer
   - b) Prints a floating-point number
   - c) Prints a string
   - d) Prints a character
   **Answer**: b) Prints a floating-point number

4. Which loop guarantees at least one execution?
   - a) `while`
   - b) `for`
   - c) `do-while`
   - d) Nested loop
   **Answer**: c) `do-while`

5. What does the `break` statement do in a loop?
   - a) Skips the current iteration
   - b) Exits the loop
   - c) Restarts the loop
   - d) Pauses execution
   **Answer**: b) Exits the loop

## Practical Questions
1. Write a program in VS Code that:
   - Declares a `double` variable `price` and a `String` variable `product`.
   - Uses `printf` with escape sequences to print product and price on separate lines.
   - Example output: `Product: Laptop\nPrice: 999.99`

2. Create a program that:
   - Uses a `for` loop to print the first 5 multiples of 3.
   - Uses `break` to exit the loop if the multiple exceeds 12.

3. Write a program that:
   - Takes an `int` input (1–5) and uses `switch-case` to print a corresponding weekday (1 = Monday, etc.).
   - Includes a `default` case for invalid inputs.

4. Create a program that:
   - Uses a `while` loop to sum numbers from 1 to 10.
   - Prints the sum using `printf`.

## Instructions for Coding
- Open VS Code and create a new file (e.g., `Session3Practice.java`).
- Write and test your code using **Run Java** (right-click) or the terminal:
  ```bash
  javac Session3Practice.java
  java Session3Practice
  ```
- Use the debugger (`F5`) to step through code for troubleshooting.
- Save your work for review in OnlineVarsity lab assignments.

## Next Steps
- Complete the "Try It Yourself" questions from Sessions 1–3 in *Java Programming - The Complete Guide for Beginners*.
- Prepare for Session 4, covering classes, objects, and methods.
- Access OnlineVarsity for eBooks, practice tests, and lab assignments.

## Additional Resources
- *Head First Java* by Kathy Sierra & Bert Bates.
- *Java: A Beginner's Guide* by Herbert Schildt.
- Oracle Java Tutorials: [https://docs.oracle.com/javase/tutorial/java/nutsandbolts/](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/).
- VS Code Java Guide: [https://code.visualstudio.com/docs/languages/java](https://code.visualstudio.com/docs/languages/java).