USE schooldb;

SELECT FirstName, LastName, Gender
FROM students
WHERE Gender = "Female";

SELECT FirstName, LastName, Age
FROM students
WHERE Age<16;

SELECT *
FROM students
WHERE GradeLevel IN ('Grade 10', 'Grade 11');

-- SELECT THOSE STUDENTS HAVING THE AGE 15, 17 & 19

SELECT *
FROM Enrollments
WHERE YEAR(EnrollmentDate)=2025;



SELECT *
FROM students
WHERE LastName LIKE '%z' OR FirstName LIKE 'S%';



SELECT *
FROM students
WHERE Age BETWEEN 15 AND 17;

SELECT *
FROM students
WHERE 
Age BETWEEN 15 and 17 
AND GradeLevel IN ('Grade 10', 'Grade 11')