# 📘 SQL CLASS NOTE – MODULE 3: 'WHERE'

---

## 1. Introduction

The **'WHERE' clause** is used to **filter records**.
It allows you to set conditions so that SQL only returns rows that meet your criteria.

- Without 'WHERE', you get **everything**.
- With 'WHERE', you get **only what you need**.

👉 Think of 'WHERE' as a **filter**:

- "Show me only Grade 10 students."
- "Show me all courses taught by Dr. Wilson."
- "Show me enrollments after January 2025."

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

- 'condition' → a logical test (true/false).
- If the row meets the condition, it appears in the results.

---

## 3. Operators You Can Use in 'WHERE'

| Operator      | Description           | Example                                                   |
| ------------- | --------------------- | --------------------------------------------------------- |
| '='           | Equals                | 'WHERE Gender = 'Male''                                   |
| '!=' or '<>'  | Not equal             | 'WHERE Age <> 16'                                         |
| '>'           | Greater than          | 'WHERE Age > 16'                                          |
| '<'           | Less than             | 'WHERE Age < 18'                                          |
| '>='          | Greater or equal      | 'WHERE Age >= 17'                                         |
| '<='          | Less or equal         | 'WHERE Age <= 15'                                         |
| 'AND'         | Both conditions true  | 'WHERE Age > 15 AND Gender = 'Female''                    |
| 'OR'          | At least one true     | 'WHERE GradeLevel = 'Grade 9' OR GradeLevel = 'Grade 10'' |
| 'BETWEEN'     | Range                 | 'WHERE Age BETWEEN 15 AND 17'                             |
| 'IN'          | Match multiple values | 'WHERE GradeLevel IN ('Grade 10','Grade 11')'             |
| 'LIKE'        | Pattern matching      | 'WHERE FirstName LIKE 'J%''                               |
| 'IS NULL'     | Empty values          | 'WHERE LastName IS NULL'                                  |
| 'IS NOT NULL' | Not empty             | 'WHERE LastName IS NOT NULL'                              |

---

## 4. Practical Examples with 'SchoolDB'

### Example 1: Select all female students

```sql
SELECT FirstName, LastName, Gender
FROM Students
WHERE Gender = 'Female';
```

---

### Example 2: Select students younger than 16

```sql
SELECT FirstName, Age
FROM Students
WHERE Age < 16;
```

---

### Example 3: Select students in Grade 10 or Grade 11

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE GradeLevel IN ('Grade 10', 'Grade 11');
```

---

### Example 4: Select enrollments in 2025 only

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
WHERE YEAR(EnrollmentDate) = 2025;
```

---

### Example 5: Pattern matching with 'LIKE'

```sql
SELECT FirstName, LastName
FROM Students
WHERE FirstName LIKE 'J%';
```

- Finds names starting with **J** (e.g., John, James).

---

### Example 6: Using multiple conditions

```sql
SELECT FirstName, Age, Gender
FROM Students
WHERE Age > 15 AND Gender = 'Male';
```

- Male students older than 15.

---

### Example 7: Range with 'BETWEEN'

```sql
SELECT FirstName, Age
FROM Students
WHERE Age BETWEEN 15 AND 17;
```

- Students aged 15, 16, or 17.

---

## 5. Why is 'WHERE' Important?

- Helps retrieve **only relevant data**.
- Saves **time** and **resources** by not fetching unnecessary rows.
- Essential for **reporting** and **analytics**.

---

## 6. Real-Life Use Cases

- Schools: Find students in a particular grade.
- Banking: Find all transactions above ₦50,000.
- Hospitals: Retrieve patients admitted after a certain date.
- E-commerce: Show products below a certain price.

---

## 7. Classwork (Practice) ✅

👉 Try these queries on **SchoolDB**:

1. Get all students who are **16 years old**.
2. Show all students in **Grade 9**.
3. Find all students whose names start with **“M”**.
4. List all enrollments that happened **before 2025-01-15**.
5. Show students who are **female** and **older than 16**.
6. Find all courses taught by **Dr. Wilson**.
7. Get all students whose 'GradeLevel' is **Grade 11** or **Grade 12**.

---

## 8. Challenge Question 💡

👉 Write a query to display the **FullName**, 'Age', and 'GradeLevel' of all students:

- Who are **between 15 and 17 years old**
- **AND** are in either **Grade 10 or Grade 11**

---

✅ That’s the **expanded Module 3: 'WHERE'**.

Perfect 👍 Let’s solve the **Module 3 Classwork + Challenge** step by step using 'SchoolDB'.

---

# ✅ Solutions to Module 3: 'WHERE'

---

### 1. Get all students who are **16 years old**.

```sql
SELECT FirstName, LastName, Age
FROM Students
WHERE Age = 16;
```

---

### 2. Show all students in **Grade 9**.

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE GradeLevel = 'Grade 9';
```

---

### 3. Find all students whose names start with **“M”**.

```sql
SELECT FirstName, LastName
FROM Students
WHERE FirstName LIKE 'M%';
```

📌 '%' means “any characters after M.”

---

### 4. List all enrollments that happened **before 2025-01-15**.

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
WHERE EnrollmentDate < '2025-01-15';
```

---

### 5. Show students who are **female** and **older than 16**.

```sql
SELECT FirstName, LastName, Age, Gender
FROM Students
WHERE Gender = 'Female' AND Age > 16;
```

---

### 6. Find all courses taught by **Dr. Wilson**.

```sql
SELECT CourseName, Teacher
FROM Courses
WHERE Teacher = 'Dr. Wilson';
```

---

### 7. Get all students whose 'GradeLevel' is **Grade 11** or **Grade 12**.

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE GradeLevel IN ('Grade 11', 'Grade 12');
```

---

# 💡 Challenge Question

👉 Display the **FullName**, 'Age', and 'GradeLevel' of all students:

- Who are **between 15 and 17 years old**
- **AND** are in either **Grade 10 or Grade 11**

```sql
SELECT CONCAT(FirstName, ' ', LastName) AS FullName,
Age,
GradeLevel
FROM Students
WHERE Age BETWEEN 15 AND 17
AND GradeLevel IN ('Grade 10', 'Grade 11');
```

✅ This combines multiple filters to give a **targeted result**.

---

✨ Now we’ve wrapped up **'WHERE'** with practice and challenge solved.

👉 Should I move on to **Module 4: 'ORDER BY'** (sorting results) in the same detailed, practical style?
