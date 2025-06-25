USE AdventureWorks2022;

DECLARE @SalesOrderID INT = 43660;
DECLARE @OrderDate DATE;
DECLARE @DayOld INT;

--SETTING THE ORDER DATE OF FROM THE ADVW TABLE
SELECT @OrderDate = OrderDate
FROM Sales.SalesOrderHeader
WHERE SalesOrderID = @SalesOrderID;

--GETTING DATE DIFFERENCE
SET @DayOld=  DATEDIFF(DAY,@OrderDate, '2011-05-31 00:00:00.000')

IF @DayOld <=7
	PRINT 'Recent Order withen the last Week';
ELSE IF @DayOld <= 30
	PRINT 'This Order is withen the This Month';
ELSE IF @DayOld<=365
	PRINT 'This Order is withen This Year';
ELSE IF @DayOld >365
	PRINT 'This Order is more than a year old';
GO
SELECT SalesOrderID, OrderDate FROM Sales.SalesOrderHeader;



