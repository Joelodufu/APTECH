/* tsqllint-disable error set-ansi */
/* tsqllint-disable error set-quoted-identifier */
/* tsqllint-disable error set-ansi */
/* tsqllint-disable error set-quoted-identifier */
/* tsqllint-disable error set-ansi */
/* tsqllint-disable error data-compression */
/* tsqllint-disable error set-ansi */
-- CREATE DATABASE TechSchool;

USE TechSchool;

-- CREATE TABLE dbo.StudentCourseRegistration(
--     StudentID VARCHAR(10),
--     StudentName VARCHAR(50),
--     StudentContact VARCHAR(100),
--     Courses VARCHAR (200),
--     CourseTitles VARCHAR(200),
--     CourseCredits VARCHAR(50),
--     Instructors VARCHAR(100),
--     InstructorOffice VARCHAR(50),
--     Department VARCHAR(50),
--     RegistrationDate DATE
-- );


INSERT INTO dbo.StudentCourseRegistration
VALUES
('S005', 'Emmanuel Ibidun', '08039238342, 09034576734, johndoe@gmail.com','CS101, CS102, CS103', 'Intro to Computer Science, Data Structures, Algorithms','3, 4, 3', 'Duke Joseph, Tayo Aderemi, Joel Odufu', 'Room 101, Room 101, Room 102','ADSE', '2025-01-15'),
('S006', 'Oluwatumininu Solanke', '08039238342, 09034576734, johndoe@gmail.com', 'CS101, CS102, CS103', 'Intro to Computer Science, Data Structures, Algorithms', '3, 4, 3', 'Duke Joseph, Tayo Aderemi, Joel Odufu', 'Room 101, Room 102, Room 103', 'ADSE', '2024-01-15'),
('S007', 'Basir Isola', '08039238342, 09034576734, johndoe@gmail.com','CS101, CS102, CS103', 'Intro to Computer Science, Data Structures, Algorithms','3, 4, 3', 'Duke Joseph, Tayo Aderemi, Joel Odufu', 'Room 101, Room 102, Room 103','ADSE', '2024-01-15'),
('S008', 'Ugochukw Okorie', '08039238342, 09034576734, johndoe@gmail.com','CS101, CS102, CS104', 'Intro to Computer Science, Data Structures, Algorithms','3, 4, 3', 'Duke Joseph, Tayo Aderemi, Joel Odufu', 'Room 101, Room 102, Room 103','Data Science', '2024-01-15'),
('S009', 'Daniel Osayemi', '08039238342, 09034576734, johndoe@gmail.com','CS101, CS102, CS104', 'Intro to Computer Science, Data Structures, Algorithms','3, 4, 3', 'Duke Joseph, Tayo Aderemi, Joel Odufu', 'Room 101, Room 102, Room 103','ADSE', '2024-01-15');
