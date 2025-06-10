
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET ANSI_NULLS ON;
SET QUOTED_IDENTIFIER ON;
SET NOCOUNT ON;
/* tsqllint-disable error select-star */
/* tsqllint-disable error schema-qualify */

USE AptechDatabase;

-- Establishing relationships between tables

-- Foreign key relationship between Users and Enrollments
ALTER TABLE dbo.Enrollments
ADD CONSTRAINT FK_Enrollments_Users
FOREIGN KEY (UserID) REFERENCES dbo.Users(UserID);

-- Foreign key relationship between Courses and Enrollments
ALTER TABLE dbo.Enrollments
ADD CONSTRAINT FK_Enrollments_Courses
FOREIGN KEY (CourseID) REFERENCES dbo.Courses(CourseID);

-- Foreign key relationship between Modules and Courses
ALTER TABLE dbo.Modules
ADD CONSTRAINT FK_Modules_Courses
FOREIGN KEY (CourseID) REFERENCES dbo.Courses(CourseID);

-- Foreign key relationship between Assessments and Enrollments
ALTER TABLE dbo.Assessments
ADD CONSTRAINT FK_Assessments_Enrollments
FOREIGN KEY (EnrollmentID) REFERENCES dbo.Enrollments(EnrollmentID);