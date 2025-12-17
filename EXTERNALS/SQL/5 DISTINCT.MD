# 📘 SQL CLASS NOTE – MODULE 5: 'DISTINCT'

---

## 1. Introduction

The **'DISTINCT' keyword** is used to remove duplicate values from the result of a query.

- Without 'DISTINCT': SQL shows **all rows**, including duplicates.
- With 'DISTINCT': SQL shows **only unique values**.

👉 Think of it as asking:

- _“Give me a list of all grade levels in the school.”_
- Without 'DISTINCT', you might see **Grade 10** repeated 50 times.
- With 'DISTINCT', you see **Grade 10** only once.

---

## 2. Syntax

```sql
SELECT DISTINCT column1, column2, ...
FROM table_name;
```

- Applies to the **entire row of selected columns**.
- If you use multiple columns, 'DISTINCT' ensures uniqueness across the **combination** of those columns.

---

## 3. Practical Examples with 'SchoolDB'

### Example 1: Get all unique grade levels

```sql
SELECT DISTINCT GradeLevel
FROM Students;
```

📌 Removes duplicates — each grade shows only once.

---

### Example 2: Get unique course teachers

```sql
SELECT DISTINCT Teacher
FROM Courses;
```

📌 If multiple courses are taught by the same teacher, they appear only once.

---

### Example 3: Unique combinations of GradeLevel and Gender

```sql
SELECT DISTINCT GradeLevel, Gender
FROM Students;
```

📌 Returns combinations like:

- Grade 9 – Male
- Grade 9 – Female
- Grade 10 – Male
- Grade 10 – Female

---

### Example 4: Unique student-course pairs from enrollments

```sql
SELECT DISTINCT StudentID, CourseID
FROM Enrollments;
```

📌 Ensures you don’t see duplicate enrollments of the same student in the same course.

---

### Example 5: Count distinct grade levels

```sql
SELECT COUNT(DISTINCT GradeLevel) AS UniqueGrades
FROM Students;
```

📌 Tells you how many different grade levels exist in the database.

---

## 4. Why Use 'DISTINCT'?

- To avoid **repetition** in reports.
- To summarize data efficiently.
- To get a **clear picture** of all possible values without duplicates.

---

## 5. Real-Life Use Cases

- **Schools**: Get a list of all unique grade levels or class sections.
- **Banks**: Find unique types of transactions (Deposit, Withdrawal, Transfer).
- **Hospitals**: Show all unique diagnoses.
- **E-commerce**: List unique product categories.

---

## 6. Classwork (Practice) ✅

👉 Try these queries on **SchoolDB**:

1. Get all unique grade levels from the **Students** table.
2. Show all unique teachers from the **Courses** table.
3. Get all unique genders from the **Students** table.
4. List unique combinations of 'GradeLevel' and 'Gender'.
5. Find the number of unique courses offered.
6. Show all distinct enrollment dates from the **Enrollments** table.
7. List all unique first names of students.

---

## 7. Challenge Question 💡

👉 Write a query to display all unique combinations of 'GradeLevel' and 'CourseID' from **Enrollments** — this will show which grade levels are enrolled in which courses (without duplication).

---

✅ That’s the **expanded Module 5: 'DISTINCT'**.

Perfect 👍 Let’s solve the **Module 5 Classwork + Challenge** step by step with real SQL queries.

---

# ✅ Solutions to Module 5: 'DISTINCT'

---

### 1. Get all unique grade levels from the **Students** table.

```sql
SELECT DISTINCT GradeLevel
FROM Students;
```

---

### 2. Show all unique teachers from the **Courses** table.

```sql
SELECT DISTINCT Teacher
FROM Courses;
```

---

### 3. Get all unique genders from the **Students** table.

```sql
SELECT DISTINCT Gender
FROM Students;
```

---

### 4. List unique combinations of 'GradeLevel' and 'Gender'.

```sql
SELECT DISTINCT GradeLevel, Gender
FROM Students;
```

---

### 5. Find the number of unique courses offered.

```sql
SELECT COUNT(DISTINCT CourseName) AS UniqueCourses
FROM Courses;
```

---

### 6. Show all distinct enrollment dates from the **Enrollments** table.

```sql
SELECT DISTINCT EnrollmentDate
FROM Enrollments;
```

---

### 7. List all unique first names of students.

```sql
SELECT DISTINCT FirstName
FROM Students;
```

---

# 💡 Challenge Question

👉 Display all unique combinations of 'GradeLevel' and 'CourseID' from **Enrollments**.

```sql
SELECT DISTINCT s.GradeLevel, e.CourseID
FROM Enrollments e
JOIN Students s ON e.StudentID = s.StudentID
ORDER BY s.GradeLevel ASC, e.CourseID ASC;
```

📌 This shows which grade levels are enrolled in which courses **without duplicates**.

---

✅ That completes **Module 5: DISTINCT**.

👉 Shall we continue with **Module 6: ALIAS ('AS')** in the same expanded style (definitions, examples, classwork, and challenge)?
