## Variables and Data Types
Features for declaring and managing variables and data types in Java.

Features: byte, short, int, long, float, double, char, boolean, String, final, null

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| byte | 8-bit integer (-128 to 127). | `byte b = 100;` | Storing small numbers like age or flags. |
| short | 16-bit integer (-32,768 to 32,767). | `short s = 1000;` | Handling moderate-sized numbers like counters. |
| int | 32-bit integer. | `int i = 50000;` | General-purpose integer for calculations. |
| long | 64-bit integer. | `long l = 1000000L;` | Large numbers like timestamps or IDs. |
| float | 32-bit floating-point. | `float f = 3.14f;` | Approximate decimals for graphics. |
| double | 64-bit floating-point. | `double d = 3.14159;` | Precise decimals for scientific calculations. |
| char | 16-bit Unicode character. | `char c = 'A';` | Storing single characters like initials. |
| boolean | True/false values. | `boolean isActive = true;` | Conditional logic like user status. |
| String | Immutable sequence of characters. | `String str = "Hello";` | Text handling in user input or output. |
| final | Declares a constant variable. | `final int MAX = 100;` | Defining immutable constants like limits. |
| null | Represents no value. | `String str = null;` | Initializing objects or clearing references. |

## Operators
Features for performing operations on variables.

Features: arithmetic (+, -, *, /, %), assignment (=), comparison (==, !=, <, >, <=, >=), logical (&&, ||, !), increment/decrement (++, --), ternary (?:)

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| + (arithmetic) | Adds numbers or concatenates strings. | `int sum = 5 + 3;` | Calculating totals in apps. |
| - (arithmetic) | Subtracts numbers. | `int diff = 5 - 3;` | Computing differences like discounts. |
| * (arithmetic) | Multiplies numbers. | `int prod = 5 * 3;` | Scaling values in algorithms. |
| / (arithmetic) | Divides numbers. | `double div = 10.0 / 3;` | Calculating averages or ratios. |
| % (arithmetic) | Returns remainder of division. | `int mod = 10 % 3;` | Checking even/odd or cycling indices. |
| = (assignment) | Assigns value to variable. | `int x = 5;` | Storing user input or results. |
| == (comparison) | Checks equality. | `if (x == y)` | Validating form inputs. |
| != (comparison) | Checks inequality. | `if (x != y)` | Ensuring distinct values. |
| <, >, <=, >= | Compares values. | `if (x < 10)` | Filtering data like age checks. |
| && (logical) | Logical AND. | `if (x > 0 && y > 0)` | Combining conditions in validation. |
| || (logical) | Logical OR. | `if (x == 0 || y == 0)` | Fallback logic in controls. |
| ! (logical) | Logical NOT. | `if (!isValid)` | Inverting conditions. |
| ++ | Increments by 1. | `x++;` | Loop counters or step increments. |
| -- | Decrements by 1. | `x--;` | Decreasing counters in timers. |
| ?: (ternary) | Conditional expression. | `String result = x > 0 ? "Positive" : "Negative";` | Concise conditionals in UI. |

## Control Flow
Features for controlling program execution.

Features: if, else, switch, for, while, do-while, break, continue, return

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| if | Executes block if condition is true. | `if (x > 0) { System.out.println("Positive"); }` | Validating user input. |
| else | Executes block if condition is false. | `if (x > 0) {} else { System.out.println("Non-positive"); }` | Handling alternative cases. |
| switch | Multi-way branching based on value. | `switch (day) { case 1: System.out.println("Monday"); break; }` | Menu options or state handling. |
| for | Loops with counter. | `for (int i = 0; i < 5; i++) { System.out.println(i); }` | Iterating over arrays or lists. |
| while | Loops while condition is true. | `while (x > 0) { x--; }` | Processing until condition changes. |
| do-while | Loops at least once. | `do { x--; } while (x > 0);` | Ensuring one iteration in menus. |
| break | Exits loop or switch. | `for (int i = 0; i < 5; i++) { if (i == 3) break; }` | Early loop termination. |
| continue | Skips current loop iteration. | `for (int i = 0; i < 5; i++) { if (i == 2) continue; }` | Skipping invalid data in loops. |
| return | Exits method with value. | `return x * 2;` | Returning results from calculations. |

## Classes and Objects
Features for object-oriented programming in Java.

Features: class, new, this, constructor, method, instance variable, static, extends, super

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| class | Defines a blueprint for objects. | `class Person { String name; }` | Modeling entities like users or products. |
| new | Creates a new object instance. | `Person p = new Person();` | Instantiating objects like database connections. |
| this | Refers to current object. | `this.name = name;` | Disambiguating instance variables in constructors. |
| constructor | Initializes new objects. | `Person(String name) { this.name = name; }` | Setting initial object state. |
| method | Defines behavior for a class. | `void greet() { System.out.println("Hi"); }` | Encapsulating logic like calculations. |
| instance variable | Stores object-specific data. | `class Person { String name; }` | Storing attributes like user details. |
| static | Defines class-level members. | `static int count = 0;` | Tracking shared data like object counts. |
| extends | Inherits from a parent class. | `class Student extends Person {}` | Reusing code in hierarchies like vehicles. |
| super | Accesses parent class members. | `super(name);` | Calling parent constructors or methods. |

## Access Modifiers
Features for controlling access to class members.

Features: public, private, protected, default (package-private)

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| public | Accessible from everywhere. | `public int x;` | Exposing methods like APIs. |
| private | Accessible only within class. | `private String name;` | Encapsulating sensitive data like passwords. |
| protected | Accessible in same package and subclasses. | `protected int id;` | Sharing data with subclasses. |
| default | Accessible within same package if no modifier. | `int count;` | Package-level utilities. |

## Exception Handling
Features for managing errors.

Features: try, catch, finally, throw, throws

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| try | Defines block to monitor for exceptions. | `try { int x = 1 / 0; }` | Wrapping risky operations like file I/O. |
| catch | Handles specific exceptions. | `catch (ArithmeticException e) { System.out.println("Error"); }` | Handling division by zero or null pointers. |
| finally | Executes code regardless of exception. | `finally { System.out.println("Done"); }` | Closing resources like database connections. |
| throw | Throws an exception manually. | `throw new IllegalArgumentException("Invalid");` | Custom error handling in methods. |
| throws | Declares exceptions a method may throw. | `void readFile() throws IOException` | Specifying file operation risks. |

## Standard Library Basics
Commonly used classes and methods from Java’s standard library.

Features: ArrayList, StringBuilder, Math, System.out.println, Scanner

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| ArrayList | Dynamic array for storing elements. | `ArrayList<Integer> list = new ArrayList<>(); list.add(1);` | Managing dynamic lists like user inputs. |
| StringBuilder | Mutable string for efficient concatenation. | `StringBuilder sb = new StringBuilder("Hello"); sb.append(" World");` | Building strings in loops. |
| Math | Provides mathematical functions. | `double pi = Math.PI; int max = Math.max(5, 10);` | Calculations like rounding or trigonometry. |
| System.out.println | Prints to console. | `System.out.println("Hello");` | Debugging or logging output. |
| Scanner | Reads input from sources like console. | `Scanner sc = new Scanner(System.in); int n = sc.nextInt();` | Reading user input in CLI apps. |

## Loops and Iteration
Features for iterating over data.

Features: for, enhanced for (for-each), while, do-while (already covered in Control Flow)

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| for | Loops with counter. | `for (int i = 0; i < 5; i++) { System.out.println(i); }` | Iterating arrays or ranges. |
| enhanced for | Iterates over arrays/collections. | `for (int x : array) { System.out.println(x); }` | Processing lists like student records. |

## Methods and Overloading
Features for defining and reusing methods.

Features: method declaration, return type, void, method overloading

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| method declaration | Defines reusable code block. | `int add(int a, int b) { return a + b; }` | Encapsulating logic like calculations. |
| return type | Specifies method’s output type. | `double getArea() { return 3.14 * r * r; }` | Returning computed values. |
| void | Indicates no return value. | `void print() { System.out.println("Hi"); }` | Performing actions like logging. |
| method overloading | Multiple methods with same name, different parameters. | `int add(int a, int b); double add(double a, double b);` | Flexible APIs for different input types. |