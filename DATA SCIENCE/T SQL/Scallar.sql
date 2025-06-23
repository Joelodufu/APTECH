USE AdventureWorks2022;
SELECT SalesOrderID, OrderDate, 
CONVERT(varchar, OrderDate, 107) 
AS FormatedDate
FROM AdventureWorks2022.Sales.SalesOrderHeader;