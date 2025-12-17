# 📘 SQL CLASS NOTE – MODULE 7: 'LIMIT'

---

## 1. Introduction

The **'LIMIT' clause** is used to control **how many rows** are returned by a query.

- Without 'LIMIT': SQL returns **all matching rows**.
- With 'LIMIT': SQL returns **only a specified number of rows**.

👉 Think of it as telling SQL:

- “Don’t show me everything, just give me the first _X_ results.”

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
LIMIT number;
```

- 'number' = maximum rows to display.

You can also use 'OFFSET' with 'LIMIT':

```sql
SELECT column1, column2
FROM table_name
LIMIT number OFFSET start;
```

- 'OFFSET' = how many rows to skip before starting to display results.

---

## 3. Practical Examples with 'SchoolDB'

### Example 1: Show the first 5 students

```sql
SELECT FirstName, LastName, Age
FROM Students
LIMIT 5;
```

---

### Example 2: Show the first 10 enrollments

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
LIMIT 10;
```

---

### Example 3: Show only 3 unique grade levels

```sql
SELECT DISTINCT GradeLevel
FROM Students
LIMIT 3;
```

---

### Example 4: Use 'OFFSET' – skip the first 5 students, then show the next 5

```sql
SELECT FirstName, LastName, Age
FROM Students
LIMIT 5 OFFSET 5;
```

📌 Useful for **pagination** (breaking results into pages).

---

### Example 5: Show the 3 most recent enrollments (combine 'ORDER BY' + 'LIMIT')

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
ORDER BY EnrollmentDate DESC
LIMIT 3;
```

---

## 4. Why Use 'LIMIT'?

- Makes queries **faster** by returning fewer rows.
- Useful when testing queries (don’t want to see thousands of rows).
- Needed for **pagination** in apps (page 1 = first 10 rows, page 2 = next 10, etc.).

---

## 5. Real-Life Use Cases

- **Schools**: Show only the top 10 students in an exam ranking.
- **Banks**: Show a customer’s last 5 transactions.
- **Hospitals**: Display the latest 3 patient admissions.
- **E-commerce**: Show only the first 20 products in search results.

---

## 6. Classwork (Practice) ✅

👉 Try these queries on **SchoolDB**:

1. Display the first 7 students.
2. Show the first 5 courses.
3. Display only 3 unique teachers.
4. Show the first 10 enrollments ordered by 'EnrollmentDate ASC'.
5. Use 'OFFSET' to skip the first 10 students, then display the next 5.
6. Show the top 5 oldest students.
7. Show the latest 5 enrollments.

---

## 7. Challenge Question 💡

👉 Write a query to display the **top 3 youngest female students**, showing their 'FullName', 'Age', and 'GradeLevel'.

---

✅ That’s the **expanded Module 7: LIMIT**.

Perfect 👍 Let’s solve the **Module 7 Classwork + Challenge** step by step with real SQL queries.

---

# ✅ Solutions to Module 7: 'LIMIT'

---

### 1. Display the first 7 students.

```sql
SELECT FirstName, LastName, Age, GradeLevel
FROM Students
LIMIT 7;
```

---

### 2. Show the first 5 courses.

```sql
SELECT CourseName, CourseCode, Teacher
FROM Courses
LIMIT 5;
```

---

### 3. Display only 3 unique teachers.

```sql
SELECT DISTINCT Teacher
FROM Courses
LIMIT 3;
```

---

### 4. Show the first 10 enrollments ordered by 'EnrollmentDate ASC'.

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
ORDER BY EnrollmentDate ASC
LIMIT 10;
```

---

### 5. Use 'OFFSET' to skip the first 10 students, then display the next 5.

```sql
SELECT FirstName, LastName, Age
FROM Students
LIMIT 5 OFFSET 10;
```

---

### 6. Show the top 5 oldest students.

```sql
SELECT FirstName, LastName, Age
FROM Students
ORDER BY Age DESC
LIMIT 5;
```

---

### 7. Show the latest 5 enrollments.

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
ORDER BY EnrollmentDate DESC
LIMIT 5;
```

---

# 💡 Challenge Question

👉 Display the **top 3 youngest female students**, showing their 'FullName', 'Age', and 'GradeLevel'.

```sql
SELECT CONCAT(FirstName, ' ', LastName) AS FullName,
Age,
GradeLevel
FROM Students
WHERE Gender = 'Female'
ORDER BY Age ASC
LIMIT 3;
```

📌 This gives the **3 youngest female students** in the database.

---

✅ That completes **Module 7: LIMIT**.

👉 Should I move on to **Module 8: BETWEEN** in the same detailed style (definitions, examples, classwork, and challenge)?
