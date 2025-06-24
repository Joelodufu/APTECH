/* tsqllint-disable error set-nocount */
SET ANSI_NULLS ON;SET QUOTED_IDENTIFIER ON;SET ANSI_NULLS ON;SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
/* tsqllint-disable error select-star */

USE AdventureWorks2022;

SELECT * FROM AdventureWorks2022.Sales.SalesOrderHeader WHERE OrderDate BETWEEN '2011-08-02' AND '2011-08-4';
GO
SELECT SUM(SalesOrderID) AS TotalOrders, AVG(TotalDue) AS AvrgOrderValue
FROM AdventureWorks2022.Sales.SalesOrderHeader
WHERE OrderDate BETWEEN '2011-08-02' AND '2011-08-4';
GO
SELECT MAX(SalesOrderID) AS MAXOrders, MIN(TotalDue) AS MINOrderValue
FROM AdventureWorks2022.Sales.SalesOrderHeader WHERE OrderDate BETWEEN '2011-08-02' AND '2011-08-4';
