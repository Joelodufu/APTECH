
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET ANSI_NULLS ON;
SET QUOTED_IDENTIFIER ON;
SET NOCOUNT ON;
/* tsqllint-disable error select-star */
/* tsqllint-disable error schema-qualify */

CREATE VIEW vw_ActiveCourses AS
SELECT c.CourseID, c.Name, c.Description
FROM dbo.Courses c
WHERE c.IsActive = 1;

CREATE VIEW vw_UserEnrollments AS
SELECT u.UserID, u.Username, c.CourseID, c.Name AS CourseName, e.EnrollmentDate
FROM dbo.Users u
JOIN dbo.Enrollments e ON u.UserID = e.UserID
JOIN dbo.Courses c ON e.CourseID = c.CourseID;

CREATE VIEW vw_AssessmentResults AS
SELECT u.UserID, u.Username, a.AssessmentID, a.Title, ar.Score
FROM dbo.Users u
JOIN dbo.AssessmentsResults ar ON u.UserID = ar.UserID
JOIN dbo.Assessments a ON ar.AssessmentID = a.AssessmentID;