/* tsqllint-disable error invalid-syntax */
/* tsqllint-disable error select-star */
/* tsqllint-disable error schema-qualify */
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET ANSI_NULLS ON;
SET QUOTED_IDENTIFIER ON;
SET NOCOUNT ON;



USE AdventureWorks2022;
DECLARE @MinPrice DECIMAL(10, 2)=2000.00;

-- SELECT  Name, ListPrice
-- FROM Production.Product
-- WHERE ListPrice=@MinPrice;

-- SELECT Name, Weight , Color
-- FROM Production.Product
-- WHERE Weight IS NOT NULL;


SELECT * 
FROM Sales.Customer
WHERE EXISTS( SELECT 1 FROM Sales.SalesOrderHeader WHERE CustomerID=  Sales.SalesOrderHeader.CustomerID);