CREATE DATABASE jdbc_demo;
USE jdbc_demo;

-- create a table called student
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT,
    gender VARCHAR(10)
)