CREATE PROCEDURE dbo.AddUser
    @UserName NVARCHAR(100),
    @Email NVARCHAR(100),
    @Password NVARCHAR(100)
AS
BEGIN
    INSERT INTO dbo.Users (UserName, Email, Password)
    VALUES (@UserName, @Email, @Password);
END;

CREATE PROCEDURE dbo.EnrollInCourse
    @UserID INT,
    @CourseID INT
AS
BEGIN
    INSERT INTO dbo.Enrollments (UserID, CourseID, EnrollmentDate)
    VALUES (@UserID, @CourseID, GETDATE());
END;

CREATE PROCEDURE dbo.GetCourseDetails
    @CourseID INT
AS
BEGIN
    SELECT *
    FROM dbo.Courses
    WHERE CourseID = @CourseID;
END;

CREATE PROCEDURE dbo.UpdateUserEmail
    @UserID INT,
    @NewEmail NVARCHAR(100)
AS
BEGIN
    UPDATE dbo.Users
    SET Email = @NewEmail
    WHERE UserID = @UserID;
END;

CREATE PROCEDURE dbo.CompleteCourse
    @EnrollmentID INT
AS
BEGIN
    UPDATE dbo.Enrollments
    SET Status = 'Completed'
    WHERE EnrollmentID = @EnrollmentID;
END;