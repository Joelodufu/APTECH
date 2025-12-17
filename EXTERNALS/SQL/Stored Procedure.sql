USE schooldb;

DELIMITER $$

CREATE PROCEDURE GetAllStudents()
BEGIN
    SELECT * FROM students;
END$$

DELIMITER ;
