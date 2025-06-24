USE AdventureWorks2022;
DECLARE @EmployeeCount INT;
SET @EmployeeCount = (SELECT COUNT(*) FROM HumanResources.Employee);
SELECT @EmployeeCount AS TotalEmployee;
GO

DECLARE @NIN INT;
SET @NIN=295847284;
SELECT * FROM HumanResources.Employee
WHERE NationalIDNumber = @NIN;
GO

SELECT 
@@SERVERNAME AS ServerName, 
@@LANGUAGE AS MyLanguage,
@@MAX_CONNECTIONS AS MaxConnections,
@@DATEFIRST As Today
;