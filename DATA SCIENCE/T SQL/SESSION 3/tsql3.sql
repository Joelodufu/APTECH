/* tsqllint-disable error data-compression */
/* tsqllint-disable error semicolon-termination */
/* tsqllint-disable error select-star */
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET QUOTED_IDENTIFIER ON;
SET NOCOUNT ON;
SET ANSI_NULLS ON;
SET NOCOUNT ON;

USE AdventureWorks2022;
-- SELECT Name FROM Production.Product
-- GROUP BY  Name HAVING AVG (ListPrice) >300 AND SUM(ListPrice) >10;


SELECT ProductID, Name FROM Production.Product
WHERE ProductSubcategoryID=1
EXCEPT
SELECT ProductID, Name 
FROM Production.Product
WHERE ProductSubcategoryID=3
