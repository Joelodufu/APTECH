USE AdventureWorks2022;
SELECT 
YEAR( OrderDate)*10000+ 
MONTH(OrderDate)*100 + 
DAY(OrderDate) 
AS CustomerDateCode
FROM Sales.SalesOrderHeader;