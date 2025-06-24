USE AdventureWorks2022;

--SIMPLE EXPRESSION
SELECT SalesOrderID, 
TotalDue*1.15 AS TotalDuePlusTax
FROM Sales.SalesOrderHeader;

