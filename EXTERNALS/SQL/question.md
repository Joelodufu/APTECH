### **EXAMPLE**

Create a **stored procedure** that:

1. Enrolls a student into a course
2. Uses a **transaction** to ensure data integrity
3. Performs a **subquery** to check if the student already registered to avoid duplicates
4. Uses **JOIN** to return full details of the student with the course enrolled

---

### **Stored Procedure Example**

```sql
DELIMITER //

CREATE PROCEDURE EnrollStudent(
    IN p_StudentID INT,
    IN p_CourseID INT
)
BEGIN
    DECLARE student_exists INT;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        -- Rollback if any error occurs
        ROLLBACK;
        SELECT 'Enrollment Failed. Transaction Rolled Back.' AS Message;
    END;

    START TRANSACTION;
    -- Subquery checks if student already enrolled
    SELECT COUNT(*) INTO student_exists
    FROM Enrollments
    WHERE StudentID = p_StudentID AND CourseID = p_CourseID;

    IF student_exists > 0 THEN
        ROLLBACK;
        SELECT 'Student already enrolled in this course.' AS Message;
    ELSE
        -- Insert new enrollment
        INSERT INTO Enrollments (CourseID, StudentID, EnrollmentDate)
        VALUES (p_CourseID, p_StudentID, NOW());
        COMMIT;

        -- Join to return details
        SELECT
            s.StudentID,
            CONCAT(s.FirstName, ' ', s.LastName) AS StudentName,
            s.GradeLevel,
            c.CourseName,
            c.Teacher,
            e.EnrollmentDate
        FROM Students s
        JOIN Enrollments e ON s.StudentID = e.StudentID
        JOIN Courses c ON c.CourseID = e.CourseID
        WHERE e.StudentID = p_StudentID AND e.CourseID = p_CourseID;
    END IF;
END //
DELIMITER ;
```

---

### How to Call the Procedure

```sql
CALL EnrollStudent(3, 2);
```

---

## 📝 Questions Based on This Example

---

### **Q1. Stored Procedure Task**

Write a stored procedure named **GetStudentCourses(StudentID)** that returns:

- Student full name
- All courses the student is enrolled in
- The teacher of each course

Use **JOIN** to fetch details from all three tables.

---

### **Q2. Transaction Task**

Using the **EnrollStudent procedure**, explain what happens if:

1. A student tries to register for the same course twice?
2. The system crashes halfway during the insert operation?

(Describe why transaction management is important here.)

---

### **Q3. Subquery + Join Task**

Write a SQL query to list **students who are enrolled in more than one course**, including:

- Student full name
- Number of courses enrolled
- Highest grade level among such students

Hint: Use **subquery with GROUP BY + HAVING**, then JOIN with Students.
