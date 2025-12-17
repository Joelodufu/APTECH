# 📘 SQL CLASS NOTE – MODULE 8: 'BETWEEN'

---

## 1. Introduction

The **'BETWEEN' operator** is used to filter results **within a given range**.

- Works with **numbers, dates, and text**.
- By default, 'BETWEEN' is **inclusive** → it includes the start and end values.

👉 Example:

- 'WHERE Age BETWEEN 15 AND 18' → gives ages 15, 16, 17, and 18.

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
WHERE column_name BETWEEN value1 AND value2;
```

- 'value1' = lower bound.
- 'value2' = upper bound.

You can also use 'NOT BETWEEN' to exclude ranges.

---

## 3. Practical Examples with 'SchoolDB'

### Example 1: Students aged between 15 and 18

```sql
SELECT FirstName, LastName, Age
FROM Students
WHERE Age BETWEEN 15 AND 18;
```

---

### Example 2: Students not aged between 10 and 14

```sql
SELECT FirstName, LastName, Age
FROM Students
WHERE Age NOT BETWEEN 10 AND 14;
```

---

### Example 3: Enrollments between two dates

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
WHERE EnrollmentDate BETWEEN '2025-01-10' AND '2025-01-20';
```

---

### Example 4: Students in grades between Grade 9 and Grade 11

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE GradeLevel BETWEEN 'Grade 9' AND 'Grade 11';
```

📌 Works because grades are stored as **text** and follow alphabetical order.

---

### Example 5: Courses with codes between 100 and 200

```sql
SELECT CourseName, CourseCode
FROM Courses
WHERE CourseCode BETWEEN 100 AND 200;
```

---

## 4. Why Use 'BETWEEN'?

- Simplifies queries with ranges.
- Easier than chaining multiple conditions with '>=' and '<='.
- Works on **dates**, which is very useful for time-based queries.

---

## 5. Real-Life Use Cases

- **Schools**: Get students with ages between 13 and 17.
- **Banks**: Find transactions between ₦10,000 and ₦50,000.
- **Hospitals**: Show patients admitted between two dates.
- **E-commerce**: List products priced between $100 and $500.

---

## 6. Classwork (Practice) ✅

👉 Try these queries on **SchoolDB**:

1. Display all students aged between 14 and 17.
2. Show all students not aged between 12 and 15.
3. Find enrollments that happened between **2025-01-12** and **2025-01-18**.
4. Show all courses with 'CourseCode' between 200 and 400.
5. Display all students whose grade level is between **Grade 10** and **Grade 12**.
6. Show all students whose first names fall alphabetically between **“J”** and **“S”**.
7. Display all enrollments where 'EnrollmentDate' is not between **2025-01-10** and **2025-01-15**.

---

## 7. Challenge Question 💡

👉 Write a query that shows the 'FullName', 'Age', and 'GradeLevel' of all **female students aged between 15 and 18**, who are also enrolled between **2025-01-12** and **2025-01-18**.

---

✅ That’s the **expanded Module 8: BETWEEN**.

Perfect 👍 Let’s solve the **Module 8 Classwork + Challenge** step by step.

---

# ✅ Solutions to Module 8: 'BETWEEN'

---

### 1. Display all students aged between 14 and 17.

```sql
SELECT FirstName, LastName, Age, GradeLevel
FROM Students
WHERE Age BETWEEN 14 AND 17;
```

---

### 2. Show all students not aged between 12 and 15.

```sql
SELECT FirstName, LastName, Age, GradeLevel
FROM Students
WHERE Age NOT BETWEEN 12 AND 15;
```

---

### 3. Find enrollments that happened between **2025-01-12** and **2025-01-18**.

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
WHERE EnrollmentDate BETWEEN '2025-01-12' AND '2025-01-18';
```

---

### 4. Show all courses with 'CourseCode' between 200 and 400.

```sql
SELECT CourseName, CourseCode, Teacher
FROM Courses
WHERE CourseCode BETWEEN 200 AND 400;
```

---

### 5. Display all students whose grade level is between **Grade 10** and **Grade 12**.

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE GradeLevel BETWEEN 'Grade 10' AND 'Grade 12';
```

---

### 6. Show all students whose first names fall alphabetically between **“J”** and **“S”**.

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE FirstName BETWEEN 'J' AND 'S';
```

📌 This uses alphabetical ordering.

---

### 7. Display all enrollments where 'EnrollmentDate' is not between **2025-01-10** and **2025-01-15**.

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
WHERE EnrollmentDate NOT BETWEEN '2025-01-10' AND '2025-01-15';
```

---

# 💡 Challenge Question

👉 Show the 'FullName', 'Age', and 'GradeLevel' of all **female students aged between 15 and 18**, who are also enrolled between **2025-01-12** and **2025-01-18**.

```sql
SELECT CONCAT(s.FirstName, ' ', s.LastName) AS FullName,
s.Age,
s.GradeLevel
FROM Students AS s
JOIN Enrollments AS e ON s.StudentID = e.StudentID
WHERE s.Gender = 'Female'
AND s.Age BETWEEN 15 AND 18
AND e.EnrollmentDate BETWEEN '2025-01-12' AND '2025-01-18';
```

📌 This combines:

- 'BETWEEN' for **age**
- 'BETWEEN' for **enrollment date**
- A filter for **female students**

---

✅ That wraps up **Module 8: BETWEEN**.

👉 Do you want me to continue with **Module 9: IN** in the same detailed style (definitions, examples, classwork, and challenge)?
