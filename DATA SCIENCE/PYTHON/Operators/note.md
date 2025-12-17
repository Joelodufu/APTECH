# 🐍 **Python Class Note: Operators**

## 🎯 **Objective:**

By the end of this class, you should be able to:

- Understand what operators are in Python
- Identify different categories of operators
- Apply them correctly in expressions and programs

---

## 🧩 **1. What Are Operators?**

**Definition:**
Operators are **symbols** or **keywords** used to perform operations on variables and values.

For example:

```python
x = 10
y = 5
print(x + y)   # Output: 15
```

Here, `+` is an **operator** that adds `x` and `y`.

---

## 🧮 **2. Types of Operators in Python**

Python operators are grouped into **seven main categories**:

| Category             | Description                         | Examples                                        |                         |
| -------------------- | ----------------------------------- | ----------------------------------------------- | ----------------------- |
| Arithmetic Operators | Perform mathematical operations     | `+`, `-`, `*`, `/`, `%`, `//`, `**`             |                         |
| Comparison Operators | Compare two values                  | `==`, `!=`, `>`, `<`, `>=`, `<=`                |                         |
| Assignment Operators | Assign values to variables          | `=`, `+=`, `-=`, `*=`, `/=`, `//=`, `**=`, `%=` |                         |
| Logical Operators    | Combine conditional statements      | `and`, `or`, `not`                              |                         |
| Bitwise Operators    | Perform bit-level operations        | `&`, `                                          | `, `^`, `~`, `<<`, `>>` |
| Membership Operators | Test for membership in a sequence   | `in`, `not in`                                  |                         |
| Identity Operators   | Compare memory locations of objects | `is`, `is not`                                  |                         |

---

## ➕ **3. Arithmetic Operators**

| Operator | Description         | Example   | Output     |
| -------- | ------------------- | --------- | ---------- |
| `+`      | Addition            | `10 + 5`  | `15`       |
| `-`      | Subtraction         | `10 - 5`  | `5`        |
| `*`      | Multiplication      | `10 * 5`  | `50`       |
| `/`      | Division (float)    | `10 / 3`  | `3.333...` |
| `//`     | Floor Division      | `10 // 3` | `3`        |
| `%`      | Modulus (Remainder) | `10 % 3`  | `1`        |
| `**`     | Exponentiation      | `2 ** 3`  | `8`        |

### 🧠 Example:

```python
a, b = 10, 3
print(a + b, a - b, a * b, a / b, a // b, a % b, a ** b)
```

### 🧩 Class Exercise:

Write a program to calculate the area and perimeter of a rectangle using arithmetic operators.

---

## ⚖️ **4. Comparison Operators**

These operators compare **two values** and return a **Boolean** (`True` or `False`).

| Operator | Description              | Example   | Output  |
| -------- | ------------------------ | --------- | ------- |
| `==`     | Equal to                 | `5 == 5`  | `True`  |
| `!=`     | Not equal to             | `5 != 3`  | `True`  |
| `>`      | Greater than             | `10 > 2`  | `True`  |
| `<`      | Less than                | `10 < 2`  | `False` |
| `>=`     | Greater than or equal to | `5 >= 5`  | `True`  |
| `<=`     | Less than or equal to    | `5 <= 10` | `True`  |

### 🧠 Example:

```python
x, y = 7, 10
print(x > y)
print(x == y)
print(x != y)
```

### 🧩 Class Exercise:

Write a Python script to check if a person is eligible to vote (age ≥ 18).

---

## 🪄 **5. Assignment Operators**

Used to **assign values** to variables, often in combination with arithmetic operations.

| Operator | Example   | Equivalent To |
| -------- | --------- | ------------- |
| `=`      | `x = 5`   | `x = 5`       |
| `+=`     | `x += 3`  | `x = x + 3`   |
| `-=`     | `x -= 2`  | `x = x - 2`   |
| `*=`     | `x *= 2`  | `x = x * 2`   |
| `/=`     | `x /= 2`  | `x = x / 2`   |
| `%=`     | `x %= 3`  | `x = x % 3`   |
| `**=`    | `x **= 2` | `x = x ** 2`  |
| `//=`    | `x //= 3` | `x = x // 3`  |

### 🧠 Example:

```python
x = 5
x += 2
print(x)   # Output: 7
```

### 🧩 Class Exercise:

Write a program that takes an integer and doubles it using an assignment operator.

---

## 🧠 **6. Logical Operators**

Used to combine multiple **conditions**.

| Operator | Description                          | Example                | Result  |
| -------- | ------------------------------------ | ---------------------- | ------- |
| `and`    | Returns True if both are true        | `(5 > 2) and (10 > 5)` | `True`  |
| `or`     | Returns True if at least one is true | `(5 > 2) or (10 < 5)`  | `True`  |
| `not`    | Reverses the result                  | `not(5 > 2)`           | `False` |

### 🧠 Example:

```python
age = 20
has_id = True
print(age >= 18 and has_id)
```

### 🧩 Class Exercise:

Write a program to check if a number is **between 10 and 50** (inclusive).

---

## ⚙️ **7. Bitwise Operators**

Operate on numbers at the **binary level** (0s and 1s).

| Operator | Description | Example  | Result (Decimal) |     |     |
| -------- | ----------- | -------- | ---------------- | --- | --- |
| `&`      | AND         | `5 & 3`  | `1`              |     |     |
| `        | `           | OR       | `5               | 3`  | `7` |
| `^`      | XOR         | `5 ^ 3`  | `6`              |     |     |
| `~`      | NOT         | `~5`     | `-6`             |     |     |
| `<<`     | Left shift  | `5 << 1` | `10`             |     |     |
| `>>`     | Right shift | `5 >> 1` | `2`              |     |     |

### 🧠 Example:

```python
x = 5
y = 3
print(x & y, x | y, x ^ y)
```

### 🧩 Class Exercise:

Print the binary representation of 12 and 6, then compute `12 & 6`, `12 | 6`, and `12 ^ 6`.

---

## 🔍 **8. Membership Operators**

Used to check whether a **value exists** in a sequence (like list, tuple, string, etc.).

| Operator | Description                      | Example              | Result |
| -------- | -------------------------------- | -------------------- | ------ |
| `in`     | Returns True if value is present | `'a' in 'apple'`     | `True` |
| `not in` | Returns True if value is absent  | `'b' not in 'apple'` | `True` |

### 🧠 Example:

```python
fruits = ['apple', 'banana', 'cherry']
print('apple' in fruits)
print('grape' not in fruits)
```

### 🧩 Class Exercise:

Write a program that checks if a user’s input exists in a predefined list of usernames.

---

## 🪞 **9. Identity Operators**

Used to check whether **two variables refer to the same object** in memory.

| Operator | Description                             | Example      | Result  |
| -------- | --------------------------------------- | ------------ | ------- |
| `is`     | True if both refer to the same object   | `a is b`     | Depends |
| `is not` | True if they refer to different objects | `a is not b` | Depends |

### 🧠 Example:

```python
a = [1, 2, 3]
b = a
c = [1, 2, 3]

print(a is b)     # True
print(a is c)     # False
print(a == c)     # True (values are equal)
```

### 🧩 Class Exercise:

Write a program that compares two lists using both `==` and `is` to show the difference.

---

## 🧾 **10. Summary Table**

| Category   | Example      | Description                     |                   |
| ---------- | ------------ | ------------------------------- | ----------------- |
| Arithmetic | `+ - * /`    | Mathematical calculations       |                   |
| Comparison | `== != > <`  | Compare values                  |                   |
| Assignment | `= += -=`    | Assign values                   |                   |
| Logical    | `and or not` | Combine conditions              |                   |
| Bitwise    | `&           | ^ << >>`                        | Binary operations |
| Membership | `in, not in` | Test for presence in a sequence |                   |
| Identity   | `is, is not` | Compare memory references       |                   |

---

## 🧩 Final Class Activity

Write a program that:

1. Takes two numbers as input
2. Compares them
3. Performs all arithmetic operations
4. Checks if the numbers are in a list `[5, 10, 15, 20]`
5. Prints all the results

---
