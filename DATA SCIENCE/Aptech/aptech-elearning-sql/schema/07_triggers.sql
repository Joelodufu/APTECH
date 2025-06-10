-- This file defines triggers for automatic actions in the Aptech e-learning platform.

-- Trigger to update enrollment status when a course is completed
CREATE TRIGGER trg_UpdateEnrollmentStatus
ON dbo.Enrollments
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    IF EXISTS (SELECT * FROM inserted WHERE CourseStatus = 'Completed')
    BEGIN
        UPDATE dbo.Enrollments
        SET Status = 'Completed'
        WHERE EnrollmentID IN (SELECT EnrollmentID FROM inserted);
    END
END;

-- Trigger to log changes to the Users table
CREATE TRIGGER trg_LogUserChanges
ON dbo.Users
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @Action NVARCHAR(10);
    IF EXISTS (SELECT * FROM inserted) AND EXISTS (SELECT * FROM deleted)
        SET @Action = 'UPDATE';
    ELSE IF EXISTS (SELECT * FROM inserted)
        SET @Action = 'INSERT';
    ELSE
        SET @Action = 'DELETE';

    INSERT INTO dbo.UserChangeLog (UserID, Action, ChangeDate)
    SELECT 
        CASE 
            WHEN @Action = 'DELETE' THEN d.UserID 
            ELSE i.UserID 
        END,
        @Action,
        GETDATE()
    FROM inserted i
    FULL OUTER JOIN deleted d ON i.UserID = d.UserID;
END;