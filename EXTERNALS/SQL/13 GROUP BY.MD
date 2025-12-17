Awesome 🚀 Let’s continue with **Module 13: GROUP BY**.

---

# 📘 SQL CLASS NOTE – MODULE 13: 'GROUP BY'

---

## 1. Introduction

The **'GROUP BY' clause** is used to **arrange rows into groups** based on one or more columns.
It is usually combined with **aggregate functions** ('COUNT', 'SUM', 'AVG', 'MIN', 'MAX').

👉 Without 'GROUP BY', aggregate functions summarize the **entire table**.
👉 With 'GROUP BY', they summarize **each group separately**.

---

## 2. Syntax

```sql
SELECT column1, AGG_FUNCTION(column2)
FROM table_name
WHERE condition
GROUP BY column1;
```

---

## 3. Practical Examples with 'SchoolDB'

### Example 1: Count students per grade

```sql
SELECT GradeLevel, COUNT(\*) AS StudentCount
FROM Students
GROUP BY GradeLevel;
```

---

### Example 2: Find average age of students per grade

```sql
SELECT GradeLevel, AVG(Age) AS AvgAge
FROM Students
GROUP BY GradeLevel;
```

---

### Example 3: Find number of students by gender

```sql
SELECT Gender, COUNT(\*) AS Total
FROM Students
GROUP BY Gender;
```

---

### Example 4: Find the youngest and oldest student per grade

```sql
SELECT GradeLevel, MIN(Age) AS Youngest, MAX(Age) AS Oldest
FROM Students
GROUP BY GradeLevel;
```

---

### Example 5: Count enrollments per course

```sql
SELECT CourseID, COUNT(\*) AS EnrollmentCount
FROM Enrollments
GROUP BY CourseID;
```

---

### Example 6: Find number of courses taught by each teacher

```sql
SELECT Teacher, COUNT(\*) AS CourseCount
FROM Courses
GROUP BY Teacher;
```

---

### Example 7: Find average student age per gender

```sql
SELECT Gender, AVG(Age) AS AvgAge
FROM Students
GROUP BY Gender;
```

---

## 4. Why Use 'GROUP BY'?

- Helps summarize **categories** of data.
- Works hand-in-hand with aggregate functions.
- Makes reports **more meaningful**.

---

## 5. Real-Life Use Cases

- **Schools**: Count students per grade.
- **Banks**: Sum transactions per account type.
- **Hospitals**: Number of patients per department.
- **E-commerce**: Sales total per category.

---

## 6. Classwork (Practice) ✅

👉 Try these queries:

1. Show the number of students in each **GradeLevel**.
2. Find the average age of students per **GradeLevel**.
3. Count the number of students grouped by **Gender**.
4. Show the minimum and maximum student ages per **GradeLevel**.
5. Count the number of enrollments per **CourseID**.
6. Show the number of courses taught by each **Teacher**.
7. Find the average student age grouped by **Gender**.

---

## 7. Challenge Question 💡

👉 Write a query to display:

- Each 'GradeLevel'
- Number of male students
- Number of female students

📌 (Hint: Use 'GROUP BY' with 'CASE WHEN' for gender count).

---

✅ That’s the **expanded Module 13: GROUP BY**.
Perfect 👍 Let’s solve the **Module 13 Classwork + Challenge** step by step with SQL queries.

---

# ✅ Solutions to Module 13: 'GROUP BY'

---

### 1. Show the number of students in each **GradeLevel**.

```sql
SELECT GradeLevel, COUNT(\*) AS StudentCount
FROM Students
GROUP BY GradeLevel;
```

---

### 2. Find the average age of students per **GradeLevel**.

```sql
SELECT GradeLevel, AVG(Age) AS AvgAge
FROM Students
GROUP BY GradeLevel;
```

---

### 3. Count the number of students grouped by **Gender**.

```sql
SELECT Gender, COUNT(\*) AS TotalStudents
FROM Students
GROUP BY Gender;
```

---

### 4. Show the minimum and maximum student ages per **GradeLevel**.

```sql
SELECT GradeLevel,
MIN(Age) AS YoungestAge,
MAX(Age) AS OldestAge
FROM Students
GROUP BY GradeLevel;
```

---

### 5. Count the number of enrollments per **CourseID**.

```sql
SELECT CourseID, COUNT(\*) AS EnrollmentCount
FROM Enrollments
GROUP BY CourseID;
```

---

### 6. Show the number of courses taught by each **Teacher**.

```sql
SELECT Teacher, COUNT(\*) AS CourseCount
FROM Courses
GROUP BY Teacher;
```

---

### 7. Find the average student age grouped by **Gender**.

```sql
SELECT Gender, AVG(Age) AS AvgAge
FROM Students
GROUP BY Gender;
```

---

# 💡 Challenge Question

👉 Display each 'GradeLevel' with:

- Number of **male students**
- Number of **female students**

```sql
SELECT GradeLevel,
SUM(CASE WHEN Gender = 'Male' THEN 1 ELSE 0 END) AS MaleStudents,
SUM(CASE WHEN Gender = 'Female' THEN 1 ELSE 0 END) AS FemaleStudents
FROM Students
GROUP BY GradeLevel
ORDER BY GradeLevel ASC;
```

📌 Here we used **'CASE WHEN' inside 'SUM()'** to count separately for Male and Female students.

---
****