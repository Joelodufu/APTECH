# PYTHON FUNCTIONS – COMPREHENSIVE CLASS NOTE

## 1. Introduction to Functions

A **function** in Python is a reusable block of code that performs a specific task. Functions help make programs:

* Modular
* Reusable
* Readable
* Easy to debug and maintain

Instead of repeating the same code multiple times, you define it once in a function and call it whenever needed.

---

## 2. Why Functions Are Important

Functions help us to:

* Break large programs into smaller, manageable pieces
* Avoid code repetition (DRY – Don’t Repeat Yourself)
* Improve code clarity
* Enable teamwork (different people can work on different functions)

---

## 3. Types of Functions in Python

### 3.1 Built-in Functions

These are functions already provided by Python.

Examples:

* `print()` – displays output
* `input()` – collects user input
* `len()` – returns length of an object
* `type()` – checks data type
* `sum()` – adds items in a list

```python
print(len("Python"))
```

---

### 3.2 User-Defined Functions

These are functions created by the programmer using the `def` keyword.

---

## 4. Defining a Function

### Syntax:

```python
def function_name():
    # function body
```

### Example:

```python
def greet():
    print("Hello, welcome to Python!")
```

---

## 5. Calling a Function

To execute a function, you **call** it using its name followed by parentheses.

```python
greet()
```

---

## 6. Functions with Parameters

Parameters allow you to pass data into a function.

### Example:

```python
def greet(name):
    print("Hello", name)

greet("Lee")
```

---

## 7. Functions with Multiple Parameters

```python
def add(a, b):
    print(a + b)

add(3, 5)
```

---

## 8. Return Statement

The `return` keyword sends a value back to the caller.

### Example:

```python
def add(a, b):
    return a + b

result = add(10, 20)
print(result)
```

> A function can return **one value**, **multiple values**, or **no value**.

---

## 9. Difference Between `print()` and `return`

| print()          | return                |
| ---------------- | --------------------- |
| Displays output  | Sends value back      |
| Cannot be reused | Can be reused         |
| Ends in console  | Ends in program logic |

---

## 10. Default Parameters

You can assign default values to parameters.

```python
def greet(name="Student"):
    print("Hello", name)

greet()
greet("Ada")
```

---

## 11. Keyword Arguments

You can specify parameter names when calling a function.

```python
def student(name, age):
    print(name, age)

student(age=20, name="John")
```

---

## 12. Arbitrary Arguments (*args)

Used when the number of arguments is unknown.

```python
def add_numbers(*numbers):
    total = 0
    for num in numbers:
        total += num
    return total

print(add_numbers(1, 2, 3, 4))
```

---

## 13. Arbitrary Keyword Arguments (**kwargs)

Allows passing multiple named arguments.

```python
def student_info(**details):
    for key, value in details.items():
        print(key, value)

student_info(name="Lee", course="Python", level=1)
```

---

## 14. Lambda (Anonymous) Functions

A lambda function is a small, one-line function.

### Syntax:

```python
lambda arguments: expression
```

### Example:

```python
square = lambda x: x * x
print(square(5))
```

---

## 15. Scope of Variables

### 15.1 Local Variables

Declared inside a function and only accessible there.

```python
def test():
    x = 10
    print(x)
```

### 15.2 Global Variables

Declared outside all functions.

```python
x = 5

def show():
    print(x)
```

---

## 16. Global Keyword

Used to modify a global variable inside a function.

```python
x = 10

def change():
    global x
    x = 20
```

---

## 17. Nested Functions

A function defined inside another function.

```python
def outer():
    def inner():
        print("Inside inner function")
    inner()

outer()
```

---

## 18. Recursive Functions

A function that calls itself.

### Example: Factorial

```python
def factorial(n):
    if n == 1:
        return 1
    else:
        return n * factorial(n-1)

print(factorial(5))
```

---

## 19. Docstrings

Used to describe what a function does.

```python
def add(a, b):
    """This function returns the sum of two numbers"""
    return a + b
```

---

## 20. Best Practices for Functions

* Use meaningful function names
* Keep functions small and focused
* Avoid too many parameters
* Use comments and docstrings
* Follow PEP 8 naming conventions

---

## 21. Practice Exercises

1. Write a function that checks if a number is even or odd
2. Write a function that returns the maximum of three numbers
3. Write a function that calculates the area of a circle
4. Write a recursive function to calculate Fibonacci numbers

---

## 22. Summary

Functions are a core concept in Python that help organize code, improve reuse, and make programs easier to understand and maintain. Mastering functions is essential for moving into advanced topics like OOP, data analysis, web development, and AI.

---
