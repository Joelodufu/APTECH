# **5.2 Python Error Handling – Comprehensive Class Notes**

Error handling allows a program to detect and respond to unexpected situations instead of crashing. Python uses a robust system called **exceptions** to manage errors gracefully.

---

## **5.2.1 Introduction to Exception Handling**

In Python, an **exception** occurs when the program encounters an error during execution.
Instead of terminating the program, we can use the `try–except` structure to catch and manage these errors.

### **Basic Structure**

```python
try:
    # Code that may cause an error
except:
    # Code executed when an error occurs
```

### **Why Use Exception Handling?**

- Prevent program crashes
- Provide meaningful error messages
- Ensure smooth user experience
- Allow alternative execution flow

### **Image Description (1 line)**

_"A shield protecting a Python script from crashing errors."_

---

## **5.2.2 Built-in Exceptions**

Python comes with many predefined exception types. These help identify the exact kind of error that occurred.

### **Common Built-in Exceptions**

| Exception Name      | Meaning                                |
| ------------------- | -------------------------------------- |
| `ZeroDivisionError` | Occurs when dividing by zero           |
| `ValueError`        | Invalid value passed to a function     |
| `TypeError`         | Wrong data type used                   |
| `NameError`         | Using an undefined variable            |
| `IndexError`        | Index out of range                     |
| `KeyError`          | Using a non-existing dictionary key    |
| `FileNotFoundError` | Requested file not found               |
| `ImportError`       | Module not found or cannot be imported |

### **Example**

```python
try:
    print(10 / 0)
except ZeroDivisionError:
    print("You cannot divide by zero!")
```

### **Image Description (1 line)**

_"Icons of different Python error types arranged like warning signs."_

---

## **5.2.3 Catching Multiple Exceptions**

Sometimes multiple kinds of errors can occur in a block of code. You can catch them individually or combine them.

### **Option 1: Separate except blocks**

```python
try:
    x = int("hello")
except ValueError:
    print("Invalid conversion!")
except TypeError:
    print("Type mismatch!")
```

### **Option 2: Combined tuple**

```python
try:
    result = 10 / int("x")
except (ValueError, ZeroDivisionError) as e:
    print("An error occurred:", e)
```

### **Why catch multiple exceptions?**

- Cleaner code
- Handle related errors together
- Avoid repetitive code

### **Image Description (1 line)**

_"A Python try-block branching into multiple paths for different exceptions."_

---

## **5.2.4 Using try with else Block**

The `else` block runs **only if no exception occurs** in the `try` block.

### **Syntax**

```python
try:
    # risked code
except:
    # error handling
else:
    # runs only if no exception occurred
```

### **Example**

```python
try:
    num = int(input("Enter a number: "))
except ValueError:
    print("Please enter a valid number!")
else:
    print("Thanks! You entered:", num)
```

### **Why use `else`?**

- Keep success-path code clean
- Avoid mixing happy-path logic with error-handling logic

### **Image Description (1 line)**

_"A green checkmark path labeled ELSE branching from a successful try block."_

---

## **5.2.5 Using try with finally Block**

The `finally` block **always executes**, whether an exception occurred or not.
It is best for cleanup operations.

### **Syntax**

```python
try:
    # risky code
except:
    # handle exception
finally:
    # executes no matter what
```

### **Use Cases**

- Closing files
- Releasing system resources
- Disconnecting from databases

### **Example**

```python
try:
    f = open("data.txt")
    print(f.read())
except FileNotFoundError:
    print("File not found!")
finally:
    print("Execution Completed!")
```

### **Image Description (1 line)**

_"A lock symbol showing cleanup happening regardless of errors."_

---

## **5.2.6 Raising Exceptions**

Python allows you to manually raise an exception using the `raise` keyword.

### **Why raise exceptions?**

- Enforce rules
- Validate inputs
- Stop execution when necessary

### **Example**

```python
age = -3
if age < 0:
    raise ValueError("Age cannot be negative!")
```

### **Raising with Custom Message**

```python
raise TypeError("Expected an integer value!")
```

### **Image Description (1 line)**

_"A Python developer pushing an error symbol upward, representing raising an exception."_

---

## **5.2.7 User-defined Exceptions**

You can create custom exceptions by inheriting from Python’s built-in `Exception` class.

### **Example: Creating a Custom Exception**

```python
class LowBalanceError(Exception):
    pass

balance = 200

if balance < 500:
    raise LowBalanceError("Your account balance is too low!")
```

### **Custom Exceptions Are Useful When:**

- Building large systems
- Enforcing business rules
- Providing clear, domain-specific error messages

### **Image Description (1 line)**

_"A custom error box labeled 'User Exception' being crafted by a programmer."_

---

# **Summary**

Python’s exception handling helps create robust programs by allowing developers to catch, manage, and even create their own exceptions. Using `try`, `except`, `else`, `finally`, and custom error classes ensures safe and predictable execution.

--
