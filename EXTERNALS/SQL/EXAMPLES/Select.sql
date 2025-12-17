USE schooldb;
SELECT Age, FirstName, LastName 
FROM students;

SELECT * 
FROM courses;

SELECT 
CourseName AS Course, 
Teacher AS Lecturer
FROM courses;


SELECT FirstName, Age, Age+1 AS 'Age Next Year'
FROM students;

SELECT DISTINCT FirstName
FROM students;

SELECT CONCAT(FirstName, " ", LastName)
FROM students;

SELECT *
FROM students
WHERE Gender="Male";

