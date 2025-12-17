# 📘 SQL CLASS NOTE – MODULE 10: 'LIKE'

---

## 1. Introduction

The **'LIKE' operator** is used in SQL to **search for a pattern in a column’s value**.
It is mostly used with **text columns** (e.g., names, grades, courses).

👉 'LIKE' works with **wildcards**:

- '%' → Matches **zero, one, or many characters**
- '\_' → Matches **exactly one character**

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
WHERE column_name LIKE 'pattern';
```

---

## 3. Wildcard Patterns

| Pattern      | Meaning              | Example              |
| ------------ | -------------------- | -------------------- |
| ''A%''       | Starts with A        | "Alice", "Andrew"    |
| ''%son''     | Ends with "son"      | "Jackson", "Emerson" |
| ''%an%''     | Contains "an"        | "Hannah", "Jonathan" |
| ''\_a%''     | Second letter is "a" | "Mary", "David"      |
| ''\_\_\_\_'' | Exactly 4 letters    | "John", "Mark"       |

---

## 4. Practical Examples with 'SchoolDB'

### Example 1: Find students whose first name starts with "A"

```sql
SELECT FirstName, LastName
FROM Students
WHERE FirstName LIKE 'A%';
```

---

### Example 2: Find students whose last name ends with "son"

```sql
SELECT FirstName, LastName
FROM Students
WHERE LastName LIKE '%son';
```

---

### Example 3: Find courses that contain "Math"

```sql
SELECT CourseName, CourseCode
FROM Courses
WHERE CourseName LIKE '%Math%';
```

---

### Example 4: Find students whose first name has "a" as the second letter

```sql
SELECT FirstName, LastName
FROM Students
WHERE FirstName LIKE '\_a%';
```

---

### Example 5: Find all students with exactly 5-letter first names

```sql
SELECT FirstName, LastName
FROM Students
WHERE FirstName LIKE '**\_**';
```

---

## 5. Why Use 'LIKE'?

- Useful for **searching text** when you don’t know the exact spelling.
- Works well for **search filters** in applications.
- Helps in **data cleaning** (finding patterns, e.g., wrong emails).

---

## 6. Real-Life Use Cases

- **Schools**: Find students whose names start with “J”.
- **E-commerce**: Search products containing the word “Phone”.
- **Hospitals**: Find patients with diagnoses containing “Flu”.
- **HR Systems**: Search employees with emails ending in “@gmail.com”.

---

## 7. Classwork (Practice) ✅

👉 Try these queries:

1. Find all students whose **first names start with J**.
2. Show all students whose **last names end with “n”**.
3. Display all courses that **contain the word “Science”**.
4. Find students whose **first names contain “an”**.
5. Show all students whose **first names have exactly 4 letters**.
6. Find students whose **last name starts with “O” and ends with “a”**.
7. Find all students whose **email contains “school.com”**.

---

## 8. Challenge Question 💡

👉 Write a query to find the 'FullName', 'Age', and 'GradeLevel' of students:

- Whose **first name starts with “M”**
- AND whose **last name contains “son”**

---

✅ That’s the **expanded Module 10: LIKE**.

Perfect 👍 Let’s solve the **Module 10 Classwork + Challenge** step by step with SQL queries.

---

# ✅ Solutions to Module 10: 'LIKE'

---

### 1. Find all students whose **first names start with J**.

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE FirstName LIKE 'J%';
```

---

### 2. Show all students whose **last names end with “n”**.

```sql
SELECT FirstName, LastName
FROM Students
WHERE LastName LIKE '%n';
```

---

### 3. Display all courses that **contain the word “Science”**.

```sql
SELECT CourseName, CourseCode, Teacher
FROM Courses
WHERE CourseName LIKE '%Science%';
```

---

### 4. Find students whose **first names contain “an”**.

```sql
SELECT FirstName, LastName
FROM Students
WHERE FirstName LIKE '%an%';
```

---

### 5. Show all students whose **first names have exactly 4 letters**.

```sql
SELECT FirstName, LastName
FROM Students
WHERE FirstName LIKE '\_\_\_\_';
```

---

### 6. Find students whose **last name starts with “O” and ends with “a”**.

```sql
SELECT FirstName, LastName
FROM Students
WHERE LastName LIKE 'O%a';
```

---

### 7. Find all students whose **email contains “school.com”**.

```sql
SELECT FirstName, LastName, Email
FROM Students
WHERE Email LIKE '%school.com%';
```

---

# 💡 Challenge Question

👉 Find the 'FullName', 'Age', and 'GradeLevel' of students:

- Whose **first name starts with “M”**
- AND whose **last name contains “son”**

```sql
SELECT CONCAT(FirstName, ' ', LastName) AS FullName,
Age,
GradeLevel
FROM Students
WHERE FirstName LIKE 'M%'
AND LastName LIKE '%son%';
```

📌 This query combines **two LIKE conditions** for pattern matching.

---

✅ That completes **Module 10: LIKE**.

👉 Should I now continue with **Module 11: ORDER BY** in the same expanded, practical style?
