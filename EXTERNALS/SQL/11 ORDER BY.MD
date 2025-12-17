# 📘 SQL CLASS NOTE – MODULE 11: 'ORDER BY'

---

## 1. Introduction

The **'ORDER BY'** clause is used to **sort query results** based on one or more columns.

- By default, sorting is **ascending (ASC)** (from small → large, A → Z).
- You can also sort in **descending (DESC)** (from large → small, Z → A).

👉 Example:

'''sql
SELECT \* FROM Students
ORDER BY Age ASC; -- youngest first
'''

'''sql
SELECT \* FROM Students
ORDER BY Age DESC; -- oldest first
'''

---

## 2. Syntax

'''sql
SELECT column1, column2, ...
FROM table_name
ORDER BY column1 [ASC|DESC], column2 [ASC|DESC];
'''

- 'ASC' = Ascending (default).
- 'DESC' = Descending.
- You can order by **multiple columns**.

---

## 3. Practical Examples with 'SchoolDB'

### Example 1: List students ordered by Age (youngest → oldest)

'''sql
SELECT FirstName, LastName, Age
FROM Students
ORDER BY Age ASC;
'''

---

### Example 2: List students ordered by Age (oldest → youngest)

'''sql
SELECT FirstName, LastName, Age
FROM Students
ORDER BY Age DESC;
'''

---

### Example 3: Order courses alphabetically by CourseName

'''sql
SELECT CourseName, CourseCode
FROM Courses
ORDER BY CourseName ASC;
'''

---

### Example 4: Order students first by GradeLevel, then by Age (both ascending)

'''sql
SELECT FirstName, LastName, GradeLevel, Age
FROM Students
ORDER BY GradeLevel ASC, Age ASC;
'''

---

### Example 5: Order enrollments by date (latest first)

'''sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
ORDER BY EnrollmentDate DESC;
'''

---

### Example 6: Order students by LastName alphabetically

'''sql
SELECT FirstName, LastName
FROM Students
ORDER BY LastName ASC;
'''

---

### Example 7: Order courses by Teacher name (descending)

'''sql
SELECT CourseName, Teacher
FROM Courses
ORDER BY Teacher DESC;
'''

---

## 4. Why Use 'ORDER BY'?

- Makes results **more readable**.
- Useful in reports (e.g., top students, latest enrollments).
- Helps to **rank or prioritize** data.

---

## 5. Real-Life Use Cases

- **Schools**: Get oldest students in a class.
- **E-commerce**: Sort products by price (low → high).
- **Banks**: Show transactions from latest to oldest.
- **Hospitals**: Sort patients alphabetically by name.

---

## 6. Classwork (Practice) ✅

👉 Try these queries:

1. Display all students ordered by **FirstName** alphabetically.
2. Show students ordered by **GradeLevel (ASC)** and then by **Age (DESC)**.
3. List courses ordered by **CourseCode (ascending)**.
4. Show enrollments ordered by **EnrollmentDate (oldest first)**.
5. Display students ordered by **Age (DESC)**.
6. Order students by **LastName (A–Z)**.
7. Order students by **Gender first**, then by **FirstName**.

---

## 7. Challenge Question 💡

👉 Write a query to display the 'FullName', 'Age', and 'GradeLevel' of students, ordered by:

1. **GradeLevel (ASC)**
2. **Age (DESC)**
3. **FirstName (ASC)**

---

✅ That’s the **expanded Module 11: ORDER BY**.

Perfect 👍 Let’s solve the **Module 11 Classwork + Challenge** step by step with SQL queries.

---

# ✅ Solutions to Module 11: 'ORDER BY'

---

### 1. Display all students ordered by **FirstName** alphabetically.

'''sql
SELECT FirstName, LastName, GradeLevel
FROM Students
ORDER BY FirstName ASC;
'''

---

### 2. Show students ordered by **GradeLevel (ASC)** and then by **Age (DESC)**.

'''sql
SELECT FirstName, LastName, GradeLevel, Age
FROM Students
ORDER BY GradeLevel ASC, Age DESC;
'''

---

### 3. List courses ordered by **CourseCode (ascending)**.

'''sql
SELECT CourseName, CourseCode, Teacher
FROM Courses
ORDER BY CourseCode ASC;
'''

---

### 4. Show enrollments ordered by **EnrollmentDate (oldest first)**.

'''sql
SELECT StudentID, CourseID, EnrollmentDate
FROM Enrollments
ORDER BY EnrollmentDate ASC;
'''

---

### 5. Display students ordered by **Age (DESC)**.

'''sql
SELECT FirstName, LastName, Age
FROM Students
ORDER BY Age DESC;
'''

---

### 6. Order students by **LastName (A–Z)**.

'''sql
SELECT FirstName, LastName, GradeLevel
FROM Students
ORDER BY LastName ASC;
'''

---

### 7. Order students by **Gender first**, then by **FirstName**.

'''sql
SELECT FirstName, LastName, Gender
FROM Students
ORDER BY Gender ASC, FirstName ASC;
'''

---

# 💡 Challenge Question

👉 Display the 'FullName', 'Age', and 'GradeLevel' of students, ordered by:

1. **GradeLevel (ASC)**
2. **Age (DESC)**
3. **FirstName (ASC)**

'''sql
SELECT CONCAT(FirstName, ' ', LastName) AS FullName,
Age,
GradeLevel
FROM Students
ORDER BY GradeLevel ASC, Age DESC, FirstName ASC;
'''

📌 This ensures:

- Students are grouped by GradeLevel,
- Within each grade, oldest students appear first,
- If two students are the same age, they are sorted alphabetically by FirstName.

---

✅ That completes **Module 11: ORDER BY**.

👉 Do you want me to now continue with **Module 12: Aggregate Functions (COUNT, SUM, AVG, MIN, MAX)** in the same expanded, practical style?
