# 📘 SQL CLASS NOTE – MODULE 9: 'IN'

---

## 1. Introduction

The **'IN' operator** is used to filter data by checking if a value matches **any value in a list**.

- It is a **shorter alternative** to writing multiple 'OR' conditions.
- Can be used with **numbers, text, or subqueries**.

👉 Instead of:

```sql
WHERE GradeLevel = 'Grade 9' OR GradeLevel = 'Grade 10' OR GradeLevel = 'Grade 11'
```

We can simply write:

```sql
WHERE GradeLevel IN ('Grade 9', 'Grade 10', 'Grade 11')
```

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
WHERE column_name IN (value1, value2, ...);
```

- You can also use 'NOT IN' to exclude values.

---

## 3. Practical Examples with 'SchoolDB'

### Example 1: Students in Grade 9 or Grade 10

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE GradeLevel IN ('Grade 9', 'Grade 10');
```

---

### Example 2: Students not in Grade 11 or Grade 12

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE GradeLevel NOT IN ('Grade 11', 'Grade 12');
```

---

### Example 3: Courses taught by specific teachers

```sql
SELECT CourseName, Teacher
FROM Courses
WHERE Teacher IN ('Dr. Wilson', 'Mrs. Smith');
```

---

### Example 4: Students with specific ages

```sql
SELECT FirstName, LastName, Age
FROM Students
WHERE Age IN (14, 15, 16);
```

---

### Example 5: Using 'IN' with a subquery – students enrolled in courses

```sql
SELECT FirstName, LastName
FROM Students
WHERE StudentID IN (
SELECT StudentID
FROM Enrollments
WHERE CourseID = 101
);
```

📌 Finds all students who are enrolled in **CourseID 101**.

---

## 4. Why Use 'IN'?

- Makes queries **shorter and cleaner**.
- Easy to read when filtering for multiple values.
- Works with both **lists of values** and **subqueries**.

---

## 5. Real-Life Use Cases

- **Schools**: Get students in specific grades.
- **Banks**: Show transactions of type _Deposit_ or _Transfer_.
- **Hospitals**: List patients with specific diagnoses.
- **E-commerce**: Show products in selected categories.

---

## 6. Classwork (Practice) ✅

👉 Try these queries on **SchoolDB**:

1. Display all students in **Grade 9, Grade 10, or Grade 11**.
2. Show all students not in **Grade 12**.
3. List all courses taught by **Dr. Wilson**, **Mrs. Smith**, or **Mr. Johnson**.
4. Find all students whose age is **13, 15, or 17**.
5. Show all enrollments where 'CourseID' is in (101, 102, 103).
6. Use 'NOT IN' to show students who are **not female**.
7. Use a subquery with 'IN' to show all students who have at least one enrollment record.

---

## 7. Challenge Question 💡

👉 Write a query that shows the 'FullName', 'Age', and 'GradeLevel' of students:

- Whose 'GradeLevel' is in **(Grade 10, Grade 11, Grade 12)**
- AND whose 'Age' is in **(15, 16, 17, 18)**

---

✅ That’s the **expanded Module 9: IN**.

Perfect 👍 Let’s solve the **Module 9 Classwork + Challenge** step by step with SQL queries.

---

# ✅ Solutions to Module 9: 'IN'

---

### 1. Display all students in **Grade 9, Grade 10, or Grade 11**.

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE GradeLevel IN ('Grade 9', 'Grade 10', 'Grade 11');
```

---

### 2. Show all students not in **Grade 12**.

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE GradeLevel NOT IN ('Grade 12');
```

---

### 3. List all courses taught by **Dr. Wilson**, **Mrs. Smith**, or **Mr. Johnson**.

```sql
SELECT CourseName, Teacher
FROM Courses
WHERE Teacher IN ('Dr. Wilson', 'Mrs. Smith', 'Mr. Johnson');
```

---

### 4. Find all students whose age is **13, 15, or 17**.

```sql
SELECT FirstName, LastName, Age
FROM Students
WHERE Age IN (13, 15, 17);
```

---

### 5. Show all enrollments where 'CourseID' is in (101, 102, 103).

```sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
WHERE CourseID IN (101, 102, 103);
```

---

### 6. Use 'NOT IN' to show students who are **not female**.

```sql
SELECT FirstName, LastName, Gender
FROM Students
WHERE Gender NOT IN ('Female');
```

---

### 7. Use a subquery with 'IN' to show all students who have at least one enrollment record.

```sql
SELECT FirstName, LastName, GradeLevel
FROM Students
WHERE StudentID IN (
SELECT DISTINCT StudentID
FROM Enrollments
);
```

---

# 💡 Challenge Question

👉 Show the 'FullName', 'Age', and 'GradeLevel' of students:

- Whose 'GradeLevel' is in **(Grade 10, Grade 11, Grade 12)**
- AND whose 'Age' is in **(15, 16, 17, 18)**

```sql
SELECT CONCAT(FirstName, ' ', LastName) AS FullName,
Age,
GradeLevel
FROM Students
WHERE GradeLevel IN ('Grade 10', 'Grade 11', 'Grade 12')
AND Age IN (15, 16, 17, 18);
```

📌 This combines two 'IN' conditions to filter students by both grade and age.

---

✅ That completes **Module 9: IN**.

👉 Should I now continue with **Module 10: LIKE** (pattern matching) in the same detailed style?
