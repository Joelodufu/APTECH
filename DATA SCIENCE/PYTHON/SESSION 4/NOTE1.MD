# **Section 4 — Functions, Modules, and Packages**

## **Learning Objectives**

By the end of this session, students should be able to:

1. Describe and use **recursive functions** in Python.
2. Explain and apply **lambda functions** with `filter()`, `map()`, and `reduce()`.
3. Describe, create, and use **modules**.
4. Identify how to define and import **packages**.

---

## **4.1 Recursive Functions**
![alt text](1.png)
### **Concept & Literature**

A **recursive function** is a function that calls itself directly or indirectly until a base condition is met. It helps solve problems that can be broken into smaller subproblems of the same type (e.g., factorial, Fibonacci, series summation).

**Syntax:**

```python
def function_name(parameters):
    if condition:
        return value
    else:
        return expression + function_name(modified_parameters)
```

### **Why It’s Important**

Recursion simplifies code for problems with repetitive structures and enhances understanding of function call stacks and memory flow.

### **Real-Life Scenario**

Consider a series calculation like in the image below:

🖼 _Figure: Recursive SeriesSum Function Execution Tree_
![alt text](<SERIES OF SUM.png>)

This image depicts how recursive calls break down a power series calculation step by step:

```python
def SeriesSum(a, n):
    if n == 0:
        return 0
    else:
        return pow(a, n) + SeriesSum(a, n-1)
```

For `SeriesSum(4,6)`:

```
4^6 + 4^5 + 4^4 + 4^3 + 4^2 + 4^1 = 5460
```

### **Class Work**

1. Write a recursive function to calculate factorial of any number.
2. Modify the function to count recursive calls.

---

## **4.2 Lambda Function**

### **Concept & Literature**

A **lambda function** is a small, anonymous function defined with the `lambda` keyword.
It can take multiple arguments but contains only one expression.

**Syntax:**

```python
lambda arguments : expression
```

### **Why It’s Important**

- Helps write cleaner, concise code.
- Useful when passing simple functions as arguments to higher-order functions.

### **Example**

```python
square = lambda x: x ** 2
print(square(5))  # Output: 25
```

---

### **4.2.1 Lambda with Filter Function**

**Concept:**
`filter()` selects items from a sequence based on a condition.

**Example:**

```python
numbers = [1, 2, 3, 4, 5, 6]
even_nums = list(filter(lambda x: x % 2 == 0, numbers))
print(even_nums)
```

**Output:** `[2, 4, 6]`

---

### **4.2.2 Lambda with Map Function**

**Concept:**
`map()` applies a function to all items in a sequence.

**Example:**

```python
nums = [1, 2, 3, 4, 5]
squares = list(map(lambda x: x**2, nums))
print(squares)
```

**Output:** `[1, 4, 9, 16, 25]`

---

### **4.2.3 Lambda with Reduce Function**

**Concept:**
`reduce()` (from `functools` module) applies a rolling computation to pairs of items.

**Example:**

```python
from functools import reduce
nums = [1, 2, 3, 4, 5]
product = reduce(lambda x, y: x * y, nums)
print(product)
```

**Output:** `120`

---

## **4.3 Overview of Modules**

### **Concept & Literature**

A **module** is a file containing Python code (functions, classes, variables).
It helps **organize** and **reuse** code.

### **Types of Modules**

1. **Built-in modules** (e.g., `math`, `os`, `random`)
2. **User-defined modules** — created by programmers.

---

### **4.3.1 Built-in Module**

#### **Importing Multiple Modules**

```python
import math, random
print(math.sqrt(16))
print(random.randint(1,10))
```

#### **Renaming a Module**

```python
import math as m
print(m.pi)
```

---

### **4.3.2 User-defined Module**

Create a file named `myModule.py`:

```python
def greet(name):
    return f"Hello, {name}!"
```

Then import it:

```python
import myModule
print(myModule.greet("Lee"))
```

#### **Variables in a Module**

```python
# myModule.py
course = "Python Programming"
```

#### **Reloading a Module**

```python
import importlib
import myModule
importlib.reload(myModule)
```

---

### **4.3.3 Dir() Function**

`dir()` lists names defined in a module.

```python
import math
print(dir(math))
```

---

## **4.4 Packages**

### **Concept & Literature**

A **package** is a directory containing multiple Python modules, recognized by the presence of an `__init__.py` file.

### **Why It’s Important**

Packages support **modular development**, **code reuse**, and **namespace management**.

---

### **4.4.1 Creating a Package**

🖼 _Figure: Structure of a Package “Calpackage”_

**Package Directory Structure:**

```
Calpackage/
│
├── __init__.py
├── Largethree.py
│     ├── maximum_two()
│     └── maximum_three()
└── EvenOdd.py
      ├── even_num()
      └── odd_num()
```

**Example Implementation:**

`Largethree.py`

```python
def maximum_two(a, b):
    return a if a > b else b

def maximum_three(a, b, c):
    return maximum_two(a, maximum_two(b, c))
```

`EvenOdd.py`

```python
def even_num(x):
    return x % 2 == 0

def odd_num(x):
    return x % 2 != 0
```

`__init__.py`

```python
# Makes this folder a package
```

---

### **4.4.2 Importing Modules from a Package**

```python
from Calpackage import Largethree, EvenOdd

print(Largethree.maximum_three(10, 20, 5))
print(EvenOdd.even_num(12))
```

**Output:**

```
20
True
```

---

## **4.5 Summary**

- Recursive functions call themselves repeatedly until a condition is met.
- Lambda functions provide a compact way to write small functions.
- Modules are reusable Python files that organize code logically.
- Packages are directories that group related modules, recognized by an `__init__.py` file.

---

## **4.6 Review Questions and Class Tasks**

### **Short Questions**

1. What is recursion?
2. Write one difference between a module and a package.
3. What is the purpose of the `__init__.py` file?
4. What does `dir()` do in Python?
5. Explain the syntax of a lambda function.

---

### **Hands-On Exercises**

1. **Recursion Practice:** Write a recursive function to calculate Fibonacci numbers.
2. **Lambda Practice:** Use lambda and `map()` to double all numbers in a list.
3. **Module Creation:**

   - Create a module named `mathUtils.py` with functions for square and cube.
   - Import and use it in another script.

4. **Package Practice:**

   - Build a package called `MyCalc` containing modules `Arithmetic.py` and `Geometry.py`.
   - Import the modules and test their functions.

5. **Challenge:** Modify the `SeriesSum` function to display the number of recursive calls made.

---

**End of Section 4**
