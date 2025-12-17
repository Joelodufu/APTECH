# 📘 SQL CLASS NOTE – MODULE 14: 'HAVING'

---

## 1. Introduction

The **'HAVING' clause** is used to filter results **after grouping** with 'GROUP BY'.

- 'WHERE' filters rows **before grouping**.
- 'HAVING' filters groups **after aggregation**.

👉 Example difference:

```sql
-- WHERE filters rows
SELECT \*
FROM Students
WHERE Age > 15;

-- HAVING filters grouped results
SELECT GradeLevel, AVG(Age) AS AvgAge
FROM Students
GROUP BY GradeLevel
HAVING AVG(Age) > 15;
```

---

## 2. Syntax

```sql
SELECT column1, AGG_FUNCTION(column2)
FROM table_name
GROUP BY column1
HAVING condition;
```

---

## 3. Practical Examples with 'SchoolDB'

### Example 1: Show grades that have more than 5 students

```sql
SELECT GradeLevel, COUNT(_) AS StudentCount
FROM Students
GROUP BY GradeLevel
HAVING COUNT(_) > 5;
```

---

### Example 2: Show grades where average age is greater than 16

```sql
SELECT GradeLevel, AVG(Age) AS AvgAge
FROM Students
GROUP BY GradeLevel
HAVING AVG(Age) > 16;
```

---

### Example 3: Show courses with more than 3 enrollments

```sql
SELECT CourseID, COUNT(_) AS EnrollmentCount
FROM Enrollments
GROUP BY CourseID
HAVING COUNT(_) > 3;
```

---

### Example 4: Show teachers who teach more than 2 courses

```sql
SELECT Teacher, COUNT(_) AS CourseCount
FROM Courses
GROUP BY Teacher
HAVING COUNT(_) > 2;
```

---

### Example 5: Show genders with average age less than 15

```sql
SELECT Gender, AVG(Age) AS AvgAge
FROM Students
GROUP BY Gender
HAVING AVG(Age) < 15;
```

---

### Example 6: Combine 'WHERE' and 'HAVING'

👉 Count number of students in **Grade 10 and above**, but only show grades with more than 5 students.

```sql
SELECT GradeLevel, COUNT(_) AS StudentCount
FROM Students
WHERE GradeLevel >= 'Grade 10'
GROUP BY GradeLevel
HAVING COUNT(_) > 5;
```

---

## 4. Why Use 'HAVING'?

- To filter aggregated results.
- To apply conditions on **groups**, not individual rows.
- Works only with **aggregate functions** ('COUNT', 'AVG', 'MIN', 'MAX', 'SUM').

---

## 5. Real-Life Use Cases

- **Schools**: Show grades with average age above 16.
- **Banks**: Show account types with more than 1000 customers.
- **E-commerce**: Show products sold more than 500 times.
- **Hospitals**: Show departments with more than 50 patients.

---

## 6. Classwork (Practice) ✅

👉 Try these queries:

1. Show grades that have more than **10 students**.
2. Show grades where **average age** is above **15**.
3. Display teachers who teach **more than 1 course**.
4. Show courses with **at least 2 enrollments**.
5. Show grades where the **youngest student** is at least **14 years old**.
6. Find genders where the **total number of students** is more than 5.
7. Combine 'WHERE' and 'HAVING': Show grades above **Grade 9** that have **more than 7 students**.

---

## 7. Challenge Question 💡

👉 Write a query to display each 'GradeLevel' with:

- The number of students
- The average age

But only show grades that:

- Have **more than 8 students**
- And **average age greater than 15**

---

✅ That’s the **expanded Module 14: HAVING**.

Perfect 👍 Let’s solve the **Module 14 Classwork + Challenge** step by step with SQL queries.

---

# ✅ Solutions to Module 14: 'HAVING'

---

### 1. Show grades that have more than **10 students**.

```sql
SELECT GradeLevel, COUNT(_) AS StudentCount
FROM Students
GROUP BY GradeLevel
HAVING COUNT(_) > 10;
```

---

### 2. Show grades where **average age** is above **15**.

```sql
SELECT GradeLevel, AVG(Age) AS AvgAge
FROM Students
GROUP BY GradeLevel
HAVING AVG(Age) > 15;
```

---

### 3. Display teachers who teach **more than 1 course**.

```sql
SELECT Teacher, COUNT(_) AS CourseCount
FROM Courses
GROUP BY Teacher
HAVING COUNT(_) > 1;
```

---

### 4. Show courses with **at least 2 enrollments**.

```sql
SELECT CourseID, COUNT(_) AS EnrollmentCount
FROM Enrollments
GROUP BY CourseID
HAVING COUNT(_) >= 2;
```

---

### 5. Show grades where the **youngest student** is at least **14 years old**.

```sql
SELECT GradeLevel, MIN(Age) AS YoungestAge
FROM Students
GROUP BY GradeLevel
HAVING MIN(Age) >= 14;
```

---

### 6. Find genders where the **total number of students** is more than 5.

```sql
SELECT Gender, COUNT(_) AS TotalStudents
FROM Students
GROUP BY Gender
HAVING COUNT(_) > 5;
```

---

### 7. Combine 'WHERE' and 'HAVING':

👉 Show grades above **Grade 9** that have **more than 7 students**.

```sql
SELECT GradeLevel, COUNT(_) AS StudentCount
FROM Students
WHERE GradeLevel >= 'Grade 10'
GROUP BY GradeLevel
HAVING COUNT(_) > 7;
```

---

# 💡 Challenge Question

👉 Display each 'GradeLevel' with:

- The number of students
- The average age

But only show grades that:

- Have **more than 8 students**
- And **average age greater than 15**

```sql
SELECT GradeLevel,
COUNT(_) AS StudentCount,
AVG(Age) AS AverageAge
FROM Students
GROUP BY GradeLevel
HAVING COUNT(_) > 8
AND AVG(Age) > 15
ORDER BY GradeLevel ASC;
```

📌 This query applies **multiple conditions in HAVING** to filter groups.

---
