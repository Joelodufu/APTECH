# Java Programming - I: Session 4 - Classes, Objects, and Methods

## Session Objectives
This session covers Session 4 from *Java Programming - The Complete Guide for Beginners*. By the end, you will:
- Understand the process of creating classes in Java.
- Learn how to instantiate objects and use instance variables and methods.
- Explore constructors and their role in object initialization.
- Understand memory management in Java.
- Use object initializers and access specifiers.
- Apply the concept of method overloading.
- Understand the use of the `this` keyword.

All coding will be done in Visual Studio Code (VS Code), building on the Java environment setup from Session 1.

## Sub-Session 1: Classes in Java
### Definition
A class is a blueprint or template for creating objects, defining their properties (fields) and behaviors (methods).

### Explanation
- Classes encapsulate data and behavior, supporting object-oriented programming (OOP) principles.
- Syntax:
  ```java
  class ClassName {
      // Fields (variables)
      // Methods
  }
  ```
- A class is declared using the `class` keyword, followed by a name (convention: PascalCase, e.g., `StudentRecord`).
- Classes can contain instance variables (data) and methods (functions).

### Examples
1. Basic class definition:
   ```java
   class Car {
       String model; // Instance variable
       int speed;
       
       void drive() { // Instance method
           System.out.println(model + " is driving at " + speed + " mph.");
       }
   }
   ```

### Class Work
1. Create a class named `Book` with fields `title` (String) and `pages` (int).
2. Add a method `displayInfo` to print the book’s title and number of pages.
3. Write a main class to test the `Book` class by creating an instance and calling `displayInfo`.

## Sub-Session 2: Objects in Java
### Definition
An object is an instance of a class, created to represent a specific entity with state (fields) and behavior (methods).

### Explanation
- Objects are created using the `new` keyword, which allocates memory and calls a constructor.
- Syntax: `ClassName objectName = new ClassName();`
- Each object has its own copy of instance variables.

### Examples
1. Creating and using an object:
   ```java
   public class Main {
       public static void main(String[] args) {
           Car car1 = new Car(); // Instantiation
           car1.model = "Toyota";
           car1.speed = 60;
           car1.drive(); // Output: Toyota is driving at 60 mph.
       }
   }
   ```

### Class Work
1. Create an instance of the `Book` class from Sub-Session 1.
2. Set the `title` to "Java Basics" and `pages` to 300.
3. Call the `displayInfo` method to print the book’s details.

## Sub-Session 3: Instance Variables and Methods
### Definition
- **Instance Variables**: Variables defined in a class, unique to each object.
- **Instance Methods**: Methods that operate on an object’s instance variables, invoked via an object.

### Explanation
- Instance variables store an object’s state (e.g., `model` in `Car`).
- Instance methods define behaviors and can access/modify instance variables.
- Accessed using the dot operator (e.g., `objectName.variable`).

### Examples
1. Instance variables and methods:
   ```java
   class Student {
       String name;
       int age;
       
       void introduce() {
           System.out.println("I am " + name + ", age " + age);
       }
   }
   public class Main {
       public static void main(String[] args) {
           Student s1 = new Student();
           s1.name = "Alice";
           s1.age = 20;
           s1.introduce(); // Output: I am Alice, age 20
       }
   }
   ```

### Class Work
1. Add an instance variable `author` to the `Book` class.
2. Create a method `showAuthor` to print the author’s name.
3. Test the method by creating a `Book` object and setting the author to "John Doe".

## Sub-Session 4: Constructors
### Definition
A constructor is a special method used to initialize objects, called automatically when an object is created using `new`.

### Explanation
- Constructors have the same name as the class and no return type.
- Types:
  - **Default Constructor**: Provided by Java if none is defined (no parameters).
  - **Parameterized Constructor**: Takes parameters to initialize fields.
- Syntax:
  ```java
  class ClassName {
      ClassName() { // Default constructor
          // Initialization code
      }
      ClassName(parameters) { // Parameterized constructor
          // Initialization code
      }
  }
  ```

### Examples
1. Default and parameterized constructors:
   ```java
   class Rectangle {
       int length, width;
       
       Rectangle() { // Default
           length = 0;
           width = 0;
       }
       
       Rectangle(int l, int w) { // Parameterized
           length = l;
           width = w;
       }
       
       int area() {
           return length * width;
       }
   }
   public class Main {
       public static void main(String[] args) {
           Rectangle r1 = new Rectangle(); // Default
           Rectangle r2 = new Rectangle(5, 3); // Parameterized
           System.out.println("Area: " + r2.area()); // Output: Area: 15
       }
   }
   ```

### Class Work
1. Add a parameterized constructor to the `Book` class to initialize `title` and `pages`.
2. Create a `Book` object using the constructor with values "OOP Concepts" and 250.
3. Print the book’s details using `displayInfo`.

## Sub-Session 5: Memory Management
### Definition
Memory management in Java refers to the automatic allocation and deallocation of memory for objects, handled by the Java Virtual Machine (JVM).

### Explanation
- **Heap Memory**: Stores objects created with `new`.
- **Garbage Collection**: JVM automatically reclaims memory from objects no longer referenced.
- **Stack Memory**: Stores local variables and method call information.
- Objects are created on the heap, and references are stored in the stack.

### Examples
1. Object creation and garbage collection:
   ```java
   public class Main {
       public static void main(String[] args) {
           Car car1 = new Car(); // Object on heap
           car1 = null; // Eligible for garbage collection
           System.gc(); // Suggests garbage collection (not guaranteed)
       }
   }
   ```

### Class Work
1. Create two `Book` objects and set one to `null`.
2. Write a program to demonstrate object creation and suggest garbage collection.
3. Discuss in class: What happens to an object when its reference is set to `null`?

## Sub-Session 6: Object Initializers
### Definition
Object initializers are techniques to set initial values for an object’s fields, either through constructors or instance initializer blocks.

### Explanation
- **Constructors**: Preferred for initializing fields (as above).
- **Instance Initializer Blocks**: Code blocks `{}` within a class, executed when an object is created.
- Syntax:
  ```java
  class ClassName {
      { // Instance initializer block
          // Initialization code
      }
  }
  ```

### Examples
1. Instance initializer block:
   ```java
   class Laptop {
       String brand;
       { // Initializer block
           brand = "Generic";
       }
       Laptop() {
           System.out.println("Brand: " + brand);
       }
   }
   public class Main {
       public static void main(String[] args) {
           Laptop laptop = new Laptop(); // Output: Brand: Generic
       }
   }
   ```

### Class Work
1. Add an instance initializer block to the `Book` class to set `pages` to 100.
2. Create a `Book` object and verify the default pages value.
3. Modify the initializer to set `title` to "Untitled" and test it.

## Sub-Session 7: Access Specifiers
### Definition
Access specifiers control the visibility and accessibility of class members (fields, methods, constructors).

### Explanation
- Types:
  - `public`: Accessible from everywhere.
  - `protected`: Accessible within the same package and subclasses.
  - `default` (no specifier): Accessible within the same package.
  - `private`: Accessible only within the same class.
- Used to enforce encapsulation and data hiding.

### Examples
1. Access specifiers in action:
   ```java
   class Employee {
       public String name;
       private int salary;
       protected int id;
       String department; // Default access
       
       public void setSalary(int s) {
           salary = s;
       }
       public int getSalary() {
           return salary;
       }
   }
   public class Main {
       public static void main(String[] args) {
           Employee emp = new Employee();
           emp.name = "John"; // Public: OK
           // emp.salary = 50000; // Error: private
           emp.setSalary(50000); // OK via public method
           System.out.println("Salary: " + emp.getSalary());
       }
   }
   ```

### Class Work
1. Add a `private` field `price` to the `Book` class with public getter/setter methods.
2. Create a `Book` object, set the price using the setter, and print it using the getter.
3. Discuss: Why is `private` used for the `price` field?

## Sub-Session 8: Method Overloading
### Definition
Method overloading allows multiple methods with the same name but different parameter lists (number, type, or order) in the same class.

### Explanation
- Methods must differ in parameter list; return type alone is not enough.
- Enhances code readability and reusability.
- Java resolves the correct method based on the arguments provided.

### Examples
1. Overloaded methods:
   ```java
   class Calculator {
       int add(int a, int b) {
           return a + b;
       }
       double add(double a, double b) {
           return a + b;
       }
       int add(int a, int b, int c) {
           return a + b + c;
       }
   }
   public class Main {
       public static void main(String[] args) {
           Calculator calc = new Calculator();
           System.out.println(calc.add(2, 3)); // 5
           System.out.println(calc.add(2.5, 3.5)); // 6.0
           System.out.println(calc.add(1, 2, 3)); // 6
       }
   }
   ```

### Class Work
1. Add an overloaded method `displayInfo` to the `Book` class that takes an additional `author` parameter.
2. Test both versions of `displayInfo` with different `Book` objects.
3. Write a program with an overloaded method to calculate the square of an `int` and a `double`.

## Sub-Session 9: The `this` Keyword
### Definition
The `this` keyword refers to the current object, used to access instance variables or methods and to call constructors within the same class.

### Explanation
- Resolves ambiguity when local variables/parameters have the same name as instance variables.
- Used in constructors to call another constructor (`this()`).
- Syntax: `this.variable` or `this.method()`.

### Examples
1. Using `this` for variables:
   ```java
   class Person {
       String name;
       int age;
       
       Person(String name, int age) {
           this.name = name; // Resolves ambiguity
           this.age = age;
       }
       void display() {
           System.out.println("Name: " + this.name + ", Age: " + this.age);
       }
   }
   public class Main {
       public static void main(String[] args) {
           Person p = new Person("Alice", 25);
           p.display(); // Output: Name: Alice, Age: 25
       }
   }
   ```

### Class Work
1. Modify the `Book` class’s parameterized constructor to use `this` for `title` and `pages`.
2. Create a method in `Book` using `this` to call `displayInfo`.
3. Test the constructor and method with a `Book` object.

## General Objective Questions
1. What is the purpose of a class in Java?
   - a) To execute code
   - b) To define a blueprint for objects
   - c) To manage memory
   - d) To handle exceptions
   **Answer**: b) To define a blueprint for objects

2. How is an object created in Java?
   - a) Using the `class` keyword
   - b) Using the `new` keyword
   - c) Using the `this` keyword
   - d) Using the `static` keyword
   **Answer**: b) Using the `new` keyword

3. Which access specifier restricts access to only within the same class?
   - a) `public`
   - b) `protected`
   - c) `private`
   - d) `default`
   **Answer**: c) `private`

4. What is method overloading?
   - a) Defining multiple methods with different names
   - b) Defining multiple methods with the same name but different parameters
   - c) Changing a method’s return type
   - d) Calling a method recursively
   **Answer**: b) Defining multiple methods with the same name but different parameters

5. What does the `this` keyword refer to?
   - a) A static variable
   - b) The current class
   - c) The current object
   - d) The superclass
   **Answer**: c) The current object

## Practical Questions
1. Write a program in VS Code that:
   - Defines a `Student` class with `name` (String) and `rollNo` (int) fields.
   - Includes a parameterized constructor and a method to print student details.
   - Creates two `Student` objects and prints their details.

2. Create a program that:
   - Defines a `Circle` class with a `private` field `radius` (double).
   - Includes public getter/setter methods and an overloaded method to calculate area (using `radius` or a parameter).
   - Tests the class with different radii.

3. Write a program that:
   - Defines a `Product` class with fields `name` (String) and `price` (double).
   - Uses an instance initializer block to set a default `name` of "Unknown".
   - Tests the class by creating objects with and without a constructor.

4. Create a program that:
   - Defines a `Box` class with `length`, `width`, and `height` (int).
   - Uses `this` in a constructor to initialize fields and call another constructor.
   - Calculates and prints the volume of a box.

## Instructions for Coding
- Open VS Code and create a new file (e.g., `Session4Practice.java`).
- Write and test your code using **Run Java** (right-click) or the terminal:
  ```bash
  javac Session4Practice.java
  java Session4Practice
  ```
- Use the debugger (`F5`) to step through code for troubleshooting.
- Save your work for review in OnlineVarsity lab assignments.

## Next Steps
- Review Session 4 in *Java Programming - The Complete Guide for Beginners*.
- Prepare for Session 5, covering arrays and strings.
- Access OnlineVarsity for eBooks, practice tests, and lab assignments.

## Additional Resources
- *Head First Java* by Kathy Sierra & Bert Bates.
- *Java: A Beginner's Guide* by Herbert Schildt.
- Oracle Java Tutorials: [https://docs.oracle.com/javase/tutorial/java/javaOO/](https://docs.oracle.com/javase/tutorial/java/javaOO/).
- VS Code Java Guide: [https://code.visualstudio.com/docs/languages/java](https://code.visualstudio.com/docs/languages/java).