# Java Programming - I: Session 5 - Arrays and Strings

## Session Objectives
This session covers Session 5 from *Java Programming - The Complete Guide for Beginners*. By the end, you will:
- Understand and declare single-dimensional and multi-dimensional arrays.
- Initialize and instantiate arrays.
- Use loops to process arrays.
- Work with the `ArrayList` class and access its values.
- Explore the `String` and `StringBuilder` classes.
- Understand wrapper classes, autoboxing, and unboxing.

All coding will be done in Visual Studio Code (VS Code), building on the Java environment setup from Session 1.

## Sub-Session 1: Arrays
### Definition
An array is a fixed-size, ordered collection of elements of the same data type, stored in contiguous memory locations.

### Explanation
- Arrays store multiple values under a single variable name.
- Each element is accessed by an index (starting at 0).
- Syntax for declaration: `dataType[] arrayName;` or `dataType arrayName[];`
- Syntax for instantiation: `arrayName = new dataType[size];`
- Arrays can be single-dimensional (1D) or multi-dimensional (e.g., 2D for matrices).

### Examples
1. Single-dimensional array:
   ```java
   int[] numbers = new int[3]; // Declaration and instantiation
   numbers[0] = 10; // Initialization
   numbers[1] = 20;
   numbers[2] = 30;
   System.out.println(numbers[1]); // Output: 20
   ```
2. Array with initializer:
   ```java
   String[] names = {"Alice", "Bob", "Charlie"};
   System.out.println(names.length); // Output: 3
   ```

### Class Work
1. Declare and instantiate an `int` array `scores` of size 5.
2. Initialize `scores` with values 90, 85, 88, 92, 87.
3. Write a program to print the third element of `scores`.

## Sub-Session 2: Single-Dimensional Arrays
### Definition
A single-dimensional array is a linear collection of elements of the same type, accessed using a single index.

### Explanation
- Declaration: `dataType[] arrayName;`
- Instantiation: `arrayName = new dataType[size];`
- Initialization: Assign values to elements using indices or an initializer list.
- Common operations: Accessing elements, modifying elements, finding length (`arrayName.length`).

### Examples
1. Using a loop to process an array:
   ```java
   int[] values = {1, 2, 3, 4, 5};
   for (int i = 0; i < values.length; i++) {
       System.out.println(values[i]);
   }
   // Output: 1 2 3 4 5
   ```
2. Using enhanced for loop:
   ```java
   for (int value : values) {
       System.out.println(value);
   }
   ```

### Class Work
1. Create a `double` array `temperatures` with values 23.5, 24.0, 22.8, 25.1.
2. Write a program to print all elements using a `for` loop.
3. Modify the program to use an enhanced `for` loop.

## Sub-Session 3: Multi-Dimensional Arrays
### Definition
A multi-dimensional array is an array of arrays, typically used to represent tables or matrices, with multiple indices for access.

### Explanation
- Common form: 2D arrays (rows and columns).
- Declaration: `dataType[][] arrayName;`
- Instantiation: `arrayName = new dataType[rows][columns];`
- Initialization: Assign values to each element or use an initializer list.
- Access: `arrayName[row][column]`.

### Examples
1. 2D array:
   ```java
   int[][] matrix = {
       {1, 2, 3},
       {4, 5, 6}
   };
   System.out.println(matrix[1][2]); // Output: 6
   ```
2. Using nested loops:
   ```java
   for (int i = 0; i < matrix.length; i++) {
       for (int j = 0; j < matrix[i].length; j++) {
           System.out.print(matrix[i][j] + " ");
       }
       System.out.println();
   }
   // Output: 1 2 3
   //         4 5 6
   ```

### Class Work
1. Declare and instantiate a 2x3 `int` array `grid`.
2. Initialize `grid` with values {{10, 20, 30}, {40, 50, 60}}.
3. Write a program to print all elements of `grid` using nested loops.

## Sub-Session 4: Using Loops to Process Arrays
### Definition
Loops are used to iterate over array elements for tasks like reading, modifying, or processing data.

### Explanation
- **Traditional `for` Loop**: Uses an index to access elements, suitable for modification.
- **Enhanced `for` Loop**: Simplifies iteration for reading elements.
- **While/Do-While Loops**: Useful for conditional processing.
- Common tasks: Summing elements, finding min/max, searching.

### Examples
1. Sum of array elements:
   ```java
   int[] numbers = {10, 20, 30, 40};
   int sum = 0;
   for (int num : numbers) {
       sum += num;
   }
   System.out.println("Sum: " + sum); // Output: Sum: 100
   ```

### Class Work
1. Write a program to calculate the average of the `scores` array from Sub-Session 1.
2. Create a program to find the maximum value in the `temperatures` array from Sub-Session 2.
3. Use a `while` loop to print elements of a `String` array containing three names.

## Sub-Session 5: ArrayList
### Definition
`ArrayList` is a resizable, dynamic array in the `java.util` package that can grow or shrink as needed.

### Explanation
- Unlike arrays, `ArrayList` size is not fixed.
- Declaration: `ArrayList<DataType> list = new ArrayList<>();`
- Common methods:
  - `add(element)`: Adds an element.
  - `get(index)`: Retrieves an element.
  - `size()`: Returns the number of elements.
  - `remove(index)`: Removes an element.
- Requires importing `java.util.ArrayList`.

### Examples
1. Using ArrayList:
   ```java
   import java.util.ArrayList;
   public class Main {
       public static void main(String[] args) {
           ArrayList<String> names = new ArrayList<>();
           names.add("Alice");
           names.add("Bob");
           System.out.println(names.get(0)); // Output: Alice
           System.out.println("Size: " + names.size()); // Output: Size: 2
       }
   }
   ```

### Class Work
1. Create an `ArrayList<Integer>` and add the numbers 5, 10, 15.
2. Write a program to print all elements in the `ArrayList` using a `for` loop.
3. Remove the second element and print the updated `ArrayList`.

## Sub-Session 6: String and StringBuilder Classes
### Definition
- `String`: An immutable class for representing sequences of characters.
- `StringBuilder`: A mutable class for efficient string manipulation.

### Explanation
- **String**:
  - Created using quotes (e.g., `"Hello"`).
  - Immutable: Operations like concatenation create new strings.
  - Common methods: `length()`, `charAt()`, `substring()`, `toUpperCase()`.
- **StringBuilder**:
  - Mutable: Allows modification without creating new objects.
  - Common methods: `append()`, `insert()`, `delete()`, `toString()`.
  - More efficient for repeated modifications.

### Examples
1. String operations:
   ```java
   String text = "Hello, Java!";
   System.out.println(text.length()); // Output: 12
   System.out.println(text.toUpperCase()); // Output: HELLO, JAVA!
   ```
2. StringBuilder operations:
   ```java
   StringBuilder sb = new StringBuilder("Hello");
   sb.append(", World!");
   System.out.println(sb.toString()); // Output: Hello, World!
   ```

### Class Work
1. Create a `String` variable with your name and print its length.
2. Use `StringBuilder` to build a sentence by appending "Java" and "Programming".
3. Write a program to reverse a `String` using `StringBuilder`.

## Sub-Session 7: Wrapper Classes, Autoboxing, and Unboxing
### Definition
- **Wrapper Classes**: Classes that wrap primitive types (e.g., `Integer` for `int`, `Double` for `double`).
- **Autoboxing**: Automatic conversion from primitive to wrapper.
- **Unboxing**: Automatic conversion from wrapper to primitive.

### Explanation
- Wrapper classes (e.g., `Integer`, `Double`, `Character`) allow primitives to be used as objects.
- Found in `java.lang` package.
- Autoboxing: `Integer i = 10;` (converts `int` to `Integer`).
- Unboxing: `int j = i;` (converts `Integer` to `int`).

### Examples
1. Autoboxing and unboxing:
   ```java
   Integer num = 100; // Autoboxing
   int value = num; // Unboxing
   System.out.println(value); // Output: 100
   ```
2. Using wrapper class methods:
   ```java
   Integer i = 42;
   System.out.println(Integer.toBinaryString(i)); // Output: 101010
   ```

### Class Work
1. Create an `Integer` wrapper object with value 25 and unbox it to an `int`.
2. Write a program to convert an `int` to its binary string using `Integer.toBinaryString`.
3. Use `Double` wrapper to parse a string "3.14" to a `double` using `Double.parseDouble`.

## General Objective Questions
1. What is an array in Java?
   - a) A dynamic collection of objects
   - b) A fixed-size collection of elements of the same type
   - c) A mutable string
   - d) A wrapper class
   **Answer**: b) A fixed-size collection of elements of the same type

2. How do you access the second element of an array `arr`?
   - a) `arr[1]`
   - b) `arr[2]`
   - c) `arr.get(1)`
   - d) `arr[0]`
   **Answer**: a) `arr[1]`

3. What is the main difference between `String` and `StringBuilder`?
   - a) `String` is mutable; `StringBuilder` is immutable
   - b) `String` is immutable; `StringBuilder` is mutable
   - c) `String` is a primitive; `StringBuilder` is a class
   - d) `StringBuilder` cannot be modified
   **Answer**: b) `String` is immutable; `StringBuilder` is mutable

4. What is autoboxing?
   - a) Converting a wrapper class to a primitive
   - b) Converting a primitive to a wrapper class
   - c) Declaring an array
   - d) Creating a StringBuilder
   **Answer**: b) Converting a primitive to a wrapper class

5. What does the `ArrayList` method `size()` return?
   - a) The capacity of the list
   - b) The number of elements in the list
   - c) The index of the last element
   - d) The type of elements
   **Answer**: b) The number of elements in the list

## Practical Questions
1. Write a program in VS Code that:
   - Creates an `int` array of 5 exam scores.
   - Uses a `for` loop to calculate and print the average score.
   - Example output: `Average Score: 88.5`

2. Create a program that:
   - Defines a 3x2 `double` array for temperatures over three days.
   - Uses nested loops to print all temperatures in a tabular format.
   - Example output:
     ```
     Day 1: 23.5 24.0
     Day 2: 22.8 23.1
     Day 3: 24.5 25.0
     ```

3. Write a program that:
   - Creates an `ArrayList<String>` with three city names.
   - Adds a fourth city, removes the second, and prints all cities using an enhanced `for` loop.

4. Create a program that:
   - Uses `StringBuilder` to build a greeting by appending your name and "Welcome to Java!".
   - Reverses the string and prints both versions.

## Instructions for Coding
- Open VS Code and create a new file (e.g., `Session5Practice.java`).
- Write and test your code using **Run Java** (right-click) or the terminal:
  ```bash
  javac Session5Practice.java
  java Session5Practice
  ```
- Use the debugger (`F5`) to step through code for troubleshooting.
- Save your work for review in OnlineVarsity lab assignments.

## Next Steps
- Review Session 5 in *Java Programming - The Complete Guide for Beginners*.
- Prepare for Session 6, covering "Try It Yourself" questions for Sessions 4–5.
- Access OnlineVarsity for eBooks, practice tests, and lab assignments.

## Additional Resources
- *Head First Java* by Kathy Sierra & Bert Bates.
- *Java: A Beginner's Guide* by Herbert Schildt.
- Oracle Java Tutorials: [https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html) and [https://docs.oracle.com/javase/tutorial/java/data/strings.html](https://docs.oracle.com/javase/tutorial/java/data/strings.html).
- VS Code Java Guide: [https://code.visualstudio.com/docs/languages/java](https://code.visualstudio.com/docs/languages/java).