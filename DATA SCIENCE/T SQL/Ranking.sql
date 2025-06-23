USE AdventureWorks2022;
SELECT BusinessEntityID, SalesYTD, ROW_NUMBER() 
OVER (ORDER BY SalesYTD DESC) AS SalesRank
FROM Sales.SalesPerson;