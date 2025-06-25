USE AdventureWorks2022;
DECLARE @PersonID INT = 5;
DECLARE @Title NVARCHAR (10);

SELECT @Title = Title
FROM Person.Person
WHERE BusinessEntityID = @PersonID;

IF @Title = 'Mr.'
	PRINT 'HELLO SIR!';
ELSE IF @Title = 'Ms.'
	PRINT 'Hello Ma`am';
ELSE IF @Title IS NULL
	PRINT 'No Title Found for this person';