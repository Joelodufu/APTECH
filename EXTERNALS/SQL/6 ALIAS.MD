# 📘 SQL CLASS NOTE – MODULE 6: 'ALIAS (AS)'

---

## 1. Introduction

An **alias** is a temporary name given to a **column** or a **table** in SQL.

- Makes results easier to read.
- Shortens long table/column names.
- Useful when performing calculations or joins.

👉 Think of it like giving someone a **nickname** so they’re easier to call.

---

## 2. Syntax

### Column Alias

```sql
SELECT column_name AS alias_name
FROM table_name;
```

### Table Alias

```sql
SELECT t.column_name
FROM table_name AS t;
```

- 'AS' is optional in most SQL engines.
- The alias lasts only for the duration of the query.

---

## 3. Practical Examples with 'SchoolDB'

### Example 1: Column alias – full name of student

```sql
SELECT CONCAT(FirstName, ' ', LastName) AS FullName
FROM Students;
```

---

### Example 2: Column alias – shorten column name

```sql
SELECT GradeLevel AS Grade, Age AS StudentAge
FROM Students;
```

---

### Example 3: Table alias – shorter name for Students

```sql
SELECT s.FirstName, s.LastName, s.GradeLevel
FROM Students AS s;
```

---

### Example 4: Table alias in a join

```sql
SELECT s.FirstName, s.LastName, c.CourseName
FROM Students AS s
JOIN Enrollments AS e ON s.StudentID = e.StudentID
JOIN Courses AS c ON e.CourseID = c.CourseID;
```

📌 Aliases 's', 'e', and 'c' make the query **shorter and cleaner**.

---

### Example 5: Alias in calculations

```sql
SELECT FirstName, LastName, (Age \* 12) AS AgeInMonths
FROM Students;
```

---

## 4. Why Use Aliases?

- For **readability**: Makes results look like real-world reports.
- For **simplicity**: Shorter table names = easier to type.
- For **calculated fields**: Rename computed columns.
- For **joins**: Prevents confusion when multiple tables share the same column names.

---

## 5. Real-Life Use Cases

- **Schools**: Show 'FullName' instead of splitting first and last name.
- **Banks**: Show 'AccountBalance AS Balance'.
- **Hospitals**: Show 'Patients.Name AS PatientName'.
- **E-commerce**: Display 'Products.Price \* Quantity AS TotalCost'.

---

## 6. Classwork (Practice) ✅

👉 Try these queries on **SchoolDB**:

1. Show all students with a column alias 'FullName'.
2. Display students with 'Age' as 'StudentAge'.
3. Show courses with 'CourseName' as 'Subject'.
4. Use table alias 's' for Students and display their 'FirstName' and 'GradeLevel'.
5. List students with their age in months ('Age \* 12') as 'AgeInMonths'.
6. Use table aliases to show each student’s 'FullName' and the 'CourseName' they are enrolled in.
7. Show all unique grade levels but alias the column as 'ClassLevel'.

---

## 7. Challenge Question 💡

👉 Write a query that:

- Joins **Students**, **Enrollments**, and **Courses**
- Shows the student’s 'FullName' (aliased), course 'CourseName' (aliased as Subject), and enrollment date (aliased as 'EnrolledOn').

---

✅ That’s the **expanded Module 6: ALIAS (AS)**.

Perfect 👍 Let’s solve the **Module 6 Classwork + Challenge** step by step.

---

# ✅ Solutions to Module 6: 'ALIAS (AS)'

---

### 1. Show all students with a column alias 'FullName'.

```sql
SELECT CONCAT(FirstName, ' ', LastName) AS FullName
FROM Students;
```

---

### 2. Display students with 'Age' as 'StudentAge'.

```sql
SELECT FirstName, LastName, Age AS StudentAge
FROM Students;
```

---

### 3. Show courses with 'CourseName' as 'Subject'.

```sql
SELECT CourseName AS Subject, Teacher
FROM Courses;
```

---

### 4. Use table alias 's' for Students and display their 'FirstName' and 'GradeLevel'.

```sql
SELECT s.FirstName, s.GradeLevel
FROM Students AS s;
```

---

### 5. List students with their age in months ('Age \* 12') as 'AgeInMonths'.

```sql
SELECT FirstName, LastName, (Age \* 12) AS AgeInMonths
FROM Students;
```

---

### 6. Use table aliases to show each student’s 'FullName' and the 'CourseName' they are enrolled in.

```sql
SELECT CONCAT(s.FirstName, ' ', s.LastName) AS FullName,
c.CourseName AS Subject
FROM Students AS s
JOIN Enrollments AS e ON s.StudentID = e.StudentID
JOIN Courses AS c ON e.CourseID = c.CourseID;
```

---

### 7. Show all unique grade levels but alias the column as 'ClassLevel'.

```sql
SELECT DISTINCT GradeLevel AS ClassLevel
FROM Students;
```

---

# 💡 Challenge Question

👉 Query that joins **Students**, **Enrollments**, and **Courses**, showing:

- Student’s 'FullName' (aliased)
- Course 'CourseName' (aliased as 'Subject')
- Enrollment date (aliased as 'EnrolledOn')

```sql
SELECT CONCAT(s.FirstName, ' ', s.LastName) AS FullName,
c.CourseName AS Subject,
e.EnrollmentDate AS EnrolledOn
FROM Students AS s
JOIN Enrollments AS e ON s.StudentID = e.StudentID
JOIN Courses AS c ON e.CourseID = c.CourseID
ORDER BY EnrolledOn ASC;
```

📌 This produces a **clean, report-like output** with readable column names.

---

✅ That wraps up **Module 6: ALIAS**.

👉 Should I move on to **Module 7: LIMIT** next, in the same detailed style (explanations, examples, classwork, and challenge)?
