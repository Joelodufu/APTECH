
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET ANSI_NULLS ON;
SET QUOTED_IDENTIFIER ON;
SET NOCOUNT ON;
/* tsqllint-disable error select-star */
/* tsqllint-disable error schema-qualify */

CREATE INDEX IDX_Users_Email ON dbo.Users(Email);
CREATE INDEX IDX_Courses_Title ON dbo.Courses(Title);
CREATE INDEX IDX_Modules_Name ON dbo.Modules(Name);
CREATE INDEX IDX_Enrollments_UserID ON dbo.Enrollments(UserID);
CREATE INDEX IDX_Assessments_CourseID ON dbo.Assessments(CourseID);