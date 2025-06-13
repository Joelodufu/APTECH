# Java Programming - I: Session 1 - Introduction to Java

## Course Overview
Welcome to **Java Programming - I**! This course is designed to introduce you to the fundamentals of Java programming, a powerful and versatile object-oriented programming language widely used in industry for building robust applications. By the end of this course, you will be able to:
- Develop and declare Java classes.
- Create and manipulate variables and data types.
- Use operators, decision-making constructs, and loops.
- Work with arrays, strings, and packages.
- Understand inheritance, polymorphism, and error handling.
- Explore modern Java features, including the Date and Time API, functional programming, and JDK 20 enhancements.

This course spans 36 online hours across 18 sessions, with each session lasting 2 hours. You'll engage with theoretical concepts, hands-on coding, and "Try It Yourself" exercises from the *Java Programming - The Complete Guide for Beginners* book. Additional resources, including eBooks, practice tests, and lab assignments, are available on OnlineVarsity.

## Session 1 Objectives
In this introductory session, we will:
- Understand the structured and object-oriented programming paradigms.
- Explore the features of Java as an object-oriented programming (OOP) language.
- Learn about the Java platform and its components.
- Identify different editions of Java.
- Trace the evolution of Java Standard Edition (Java SE).
- Set up the Java Development Kit (JDK) and a development environment for coding.

## 1. Introduction to Programming Paradigms
### Structured Programming
- **Definition**: A programming approach that emphasizes a linear, step-by-step process using control structures like sequences, conditionals (if-then-else), and loops (while, for).
- **Characteristics**:
  - Code is organized into procedures or functions.
  - Focuses on breaking down tasks into smaller, manageable subroutines.
  - Example: Writing a program to calculate the sum of numbers using a loop.
- **Limitations**: Can become complex for large systems, lacking modularity and reusability.

### Object-Oriented Programming (OOP)
- **Definition**: A programming paradigm that organizes code into objects, which are instances of classes combining data (attributes) and behavior (methods).
- **Key Principles**:
  - **Encapsulation**: Bundling data and methods, restricting access to ensure data integrity.
  - **Inheritance**: Allowing a class to inherit properties and methods from another class.
  - **Polymorphism**: Enabling objects to be treated as instances of their parent class, with specific behavior defined by subclasses.
  - **Abstraction**: Hiding complex implementation details and exposing only necessary features.
- **Advantages**:
  - Modular and reusable code.
  - Easier to maintain and scale.
  - Example: Modeling a "Car" class with attributes (color, speed) and methods (drive, stop).

## 2. Features of Java as an OOP Language
Java is a robust, platform-independent, object-oriented programming language with the following features:
- **Simple**: Easy-to-learn syntax, similar to C/C++, with automatic memory management (garbage collection).
- **Object-Oriented**: Fully supports encapsulation, inheritance, polymorphism, and abstraction.
- **Platform-Independent**: Java programs are compiled into bytecode, which runs on any device with a Java Virtual Machine (JVM).
- **Secure**: Features like sandboxing and bytecode verification ensure safe execution.
- **Multithreaded**: Supports concurrent execution of multiple tasks.
- **Robust**: Strong type-checking and exception handling prevent errors.
- **Portable**: Write Once, Run Anywhere (WORA) due to JVM.
- **High Performance**: Just-In-Time (JIT) compilation optimizes bytecode execution.

## 3. Java Platform and Its Components
The Java platform consists of:
- **Java Virtual Machine (JVM)**: Executes Java bytecode, providing platform independence.
- **Java Runtime Environment (JRE)**: Includes JVM and libraries needed to run Java applications.
- **Java Development Kit (JDK)**: Includes JRE, compilers (javac), and tools (e.g., javadoc, jar) for developing Java applications.
- **Java APIs**: Pre-built libraries for tasks like file I/O, networking, and GUI development.

## 4. Editions of Java
Java comes in multiple editions tailored for different use cases:
- **Java SE (Standard Edition)**: Core Java platform for desktop and standalone applications.
- **Java EE (Enterprise Edition)**: For large-scale, distributed enterprise applications (e.g., web servers).
- **Java ME (Micro Edition)**: For resource-constrained devices like mobile phones and embedded systems.
- **JavaFX**: For building rich, cross-platform GUI applications.

## 5. Evolution of Java Standard Edition (Java SE)
Java SE has evolved significantly since its inception:
- **JDK 1.0 (1996)**: Initial release with basic features.
- **JDK 1.2 (1998)**: Introduced Swing, Collections Framework.
- **Java SE 5 (2004)**: Added generics, enums, annotations.
- **Java SE 8 (2014)**: Introduced Lambda expressions, Stream API.
- **Java SE 11 (2018)**: Long-term support (LTS) release with modular system (JPMS).
- **Java SE 17 (2021)**: LTS release with sealed classes, pattern matching.
- **Java SE 20 (2023)**: Introduced virtual threads, vector API, and more (covered in Session 17).

## 6. Setting Up the Java Development Environment
To start coding in Java, you need to set up the JDK and an Integrated Development Environment (IDE). Follow these steps:

### Step 1: Download and Install JDK
1. **Visit the Oracle JDK Website**:
   - Go to [https://www.oracle.com/java/technologies/javase-downloads.html](https://www.oracle.com/java/technologies/javase-downloads.html).
   - Download JDK 20 (or the latest version recommended for the course).
2. **Choose the Appropriate Installer**:
   - Select the installer for your operating system (Windows, macOS, Linux).
3. **Install JDK**:
   - Run the installer and follow the prompts.
   - Note the installation path (e.g., `C:\Program Files\Java\jdk-20` on Windows).
4. **Verify Installation**:
   - Open a terminal (Command Prompt on Windows, Terminal on macOS/Linux).
   - Run `java -version` and `javac -version` to confirm the JDK is installed correctly. You should see output like:
     ```
     java version "20.0.1" 2023-04-18
     javac 20.0.1
     ```

### Step 2: Set Up Environment Variables
To run Java commands from any directory, configure the `JAVA_HOME` and `PATH` environment variables.

#### On Windows:
1. **Set JAVA_HOME**:
   - Right-click "This PC" > Properties > Advanced system settings > Environment Variables.
   - Under "System Variables," click "New" and add:
     - Variable name: `JAVA_HOME`
     - Variable value: Path to JDK (e.g., `C:\Program Files\Java\jdk-20`).
2. **Update PATH**:
   - In "System Variables," find and edit `Path`.
   - Add a new entry: `%JAVA_HOME%\bin`.
3. **Verify**:
   - Open a new Command Prompt and run `java -version` and `javac -version`.

#### On macOS/Linux:
1. **Set JAVA_HOME**:
   - Open a terminal and edit the shell configuration file (e.g., `~/.bashrc`, `~/.zshrc`).
   - Add the line:
     ```bash
     export JAVA_HOME=$(/usr/libexec/java_home)
     ```
     Or specify the path manually, e.g., `export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-20.jdk/Contents/Home`.
2. **Update PATH**:
   - Add to the same file:
     ```bash
     export PATH=$JAVA_HOME/bin:$PATH
     ```
3. **Apply Changes**:
   - Run `source ~/.bashrc` (or `~/.zshrc`) to apply changes.
4. **Verify**:
   - Run `java -version` and `javac -version`.

### Step 3: Install an IDE
An IDE simplifies coding, debugging, and testing. Recommended IDEs:
- **IntelliJ IDEA Community Edition** (free, powerful, beginner-friendly).
- **Eclipse** (free, widely used).
- **VS Code** (with Java extensions).

#### Installing IntelliJ IDEA:
1. Download from [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/).
2. Install and launch IntelliJ IDEA.
3. Create a new Java project:
   - Select "New Project" > Java > Choose JDK 20.
   - Write a simple "Hello, World!" program to test the setup.

### Step 4: Write and Run Your First Java Program
1. Create a new Java file named `HelloWorld.java` in your IDE or a text editor.
2. Add the following code:
   ```java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello, World!");
       }
   }
   ```
3. **Compile and Run**:
   - In the terminal, navigate to the file’s directory and run:
     ```bash
     javac HelloWorld.java
     java HelloWorld
     ```
   - Output: `Hello, World!`
   - In an IDE, use the "Run" button to execute the program.

## 7. Getting Started with OnlineVarsity
- **Access**: Log in to OnlineVarsity to access course resources.
- **Resources**:
  - **eBook**: Download *Java Programming - The Complete Guide for Beginners* for offline reading.
  - **Practice 4 Me**: Test your understanding with quizzes.
  - **Work Assignments**: Complete hands-on lab assignments for faculty feedback.
  - **References**: Explore additional reading materials.

## 8. Next Steps
- Review Session 1 content in *Java Programming - The Complete Guide for Beginners*.
- Complete the "Try It Yourself" questions for Session 1 (covered in Session 3).
- Prepare for Session 2, which covers variables, data types, and operators.

## Additional Resources
- **Books**:
  - *Head First Java* by Kathy Sierra & Bert Bates.
  - *Java: A Beginner's Guide* by Herbert Schildt.
  - *Java for Dummies* by Barry A. Burd.
- **Online**: Oracle’s Java Tutorials ([https://docs.oracle.com/javase/tutorial/](https://docs.oracle.com/javase/tutorial/)).