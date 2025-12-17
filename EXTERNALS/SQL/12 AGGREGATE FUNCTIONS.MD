
# 📘 SQL CLASS NOTE – MODULE 12: Aggregate Functions ('COUNT', 'SUM', 'AVG', 'MIN', 'MAX')

---

## 1. Introduction

**Aggregate functions** are special SQL functions that perform **calculations on multiple rows** and return a **single summary value**.

They are often used with 'GROUP BY' to analyze data.

---

## 2. Common Aggregate Functions

| Function  | Purpose              | Example                                 |
| --------- | -------------------- | --------------------------------------- |
| ``COUNT()`` | Counts rows          | Count how many students are in Grade 10 |
| ``SUM()``   | Adds values          | Total number of students’ ages combined |
| ``AVG()``   | Finds average        | Average student age                     |
| ``MIN()``   | Finds smallest value | Youngest student                        |
| ``MAX()``   | Finds largest value  | Oldest student                          |

---

## 3. Syntax

```sql
SELECT AGGREGATE_FUNCTION(column_name)
FROM table_name
WHERE condition;
```

👉 Example:

```sql
SELECT COUNT(\*) AS TotalStudents
FROM Students;
```

---

## 4. Practical Examples with 'SchoolDB'

### Example 1: Count total number of students

```sql
SELECT COUNT(\*) AS TotalStudents
FROM Students;
```

---

### Example 2: Count number of female students

```sql
SELECT COUNT(\*) AS FemaleStudents
FROM Students
WHERE Gender = 'Female';
```

---

### Example 3: Find the youngest and oldest student

```sql
SELECT MIN(Age) AS Youngest, MAX(Age) AS Oldest
FROM Students;
```

---

### Example 4: Find the average student age

```sql
SELECT AVG(Age) AS AverageAge
FROM Students;
```

---

### Example 5: Count how many courses are available

```sql
SELECT COUNT(\*) AS TotalCourses
FROM Courses;
```

---

### Example 6: Find the earliest and latest enrollment dates

```sql
SELECT MIN(EnrollmentDate) AS FirstEnrollment,
MAX(EnrollmentDate) AS LastEnrollment
FROM Enrollments;
```

---

### Example 7: Count number of students per grade

```sql
SELECT GradeLevel, COUNT(\*) AS StudentCount
FROM Students
GROUP BY GradeLevel;
```

---

### Example 8: Find average age of students per grade

```sql
SELECT GradeLevel, AVG(Age) AS AvgAge
FROM Students
GROUP BY GradeLevel;
```

---

## 5. Why Use Aggregate Functions?

- Helps in **summarizing large datasets**.
- Useful for **reports and analytics**.
- Works with 'GROUP BY' for category-based analysis.

---

## 6. Real-Life Use Cases

- **Schools**: Average age of students per grade.
- **Banks**: Total amount of deposits.
- **Hospitals**: Number of patients per ward.
- **E-commerce**: Highest, lowest, and average product price.

---

## 7. Classwork (Practice) ✅

👉 Try these queries:

1. Count the total number of students.
2. Find the number of male and female students.
3. Display the youngest and oldest student’s age.
4. Find the average age of all students.
5. Count how many students are in each GradeLevel.
6. Find the average age of students in **Grade 12**.
7. Find the earliest and latest enrollment dates.

---

## 8. Challenge Question 💡

👉 Write a query to show:

- Each 'GradeLevel'
- The **total number of students** in it
- The **youngest age**, **oldest age**, and **average age**

---

✅ That’s the **expanded Module 12: Aggregate Functions**.
Perfect 👍 Let’s solve the **Module 12 Classwork + Challenge** step by step with SQL queries.

---

# ✅ Solutions to Module 12: Aggregate Functions

---

### 1. Count the total number of students.

```sql
SELECT COUNT(\*) AS TotalStudents
FROM Students;
```

---

### 2. Find the number of male and female students.

```sql
SELECT Gender, COUNT(\*) AS Total
FROM Students
GROUP BY Gender;
```

---

### 3. Display the youngest and oldest student’s age.

```sql
SELECT MIN(Age) AS YoungestAge,
MAX(Age) AS OldestAge
FROM Students;
```

---

### 4. Find the average age of all students.

```sql
SELECT AVG(Age) AS AverageAge
FROM Students;
```

---

### 5. Count how many students are in each GradeLevel.

```sql
SELECT GradeLevel, COUNT(\*) AS StudentCount
FROM Students
GROUP BY GradeLevel;
```

---

### 6. Find the average age of students in **Grade 12**.

```sql
SELECT AVG(Age) AS AvgAge_Grade12
FROM Students
WHERE GradeLevel = 'Grade 12';
```

---

### 7. Find the earliest and latest enrollment dates.

```sql
SELECT MIN(EnrollmentDate) AS FirstEnrollment,
MAX(EnrollmentDate) AS LastEnrollment
FROM Enrollments;
```

---

# 💡 Challenge Question

👉 Show each 'GradeLevel' with:

- The **total number of students** in it
- The **youngest age**, **oldest age**, and **average age**

```sql
SELECT GradeLevel,
COUNT(\*) AS TotalStudents,
MIN(Age) AS YoungestAge,
MAX(Age) AS OldestAge,
AVG(Age) AS AverageAge
FROM Students
GROUP BY GradeLevel
ORDER BY GradeLevel ASC;
```

📌 This groups students by 'GradeLevel' and applies **multiple aggregate functions** at once.

---
