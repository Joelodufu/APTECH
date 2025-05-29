/* tsqllint-disable error select-star */
/* tsqllint-disable error data-compression */
SET ANSI_NULLS ON;
SET QUOTED_IDENTIFIER ON;
SET NOCOUNT ON;
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

USE AdventureWorks2022;

-- SELECT * FROM Production.Product;

-- BATCH 1 

-- DECLARE @MinPrice DECIMAL(10,2)=500.00;
-- SELECT ProductID, Name, ListPrice, (ListPrice*1.10) AS IncreasedPrice 
-- FROM Production.Product
-- WHERE ListPrice>@MinPrice;
-- GO

-- -- --BATCH 2
-- SET @MinPrice= 1000.00 ;
-- SELECT ProductID, Name, ListPrice, (ListPrice*1.10)As IncreasedPrice
-- FROM Production.Product
-- WHERE ListPrice>@MinPrice;

-- DECLARE @StockLevel INT =200;
-- SELECT ProductID, Name, SafetyStockLevel
-- FROM Production.Product
-- WHERE SafetyStockLevel>=@StockLevel;
-- GO

-- DECLARE @StockLevel INT =400;
-- SELECT ProductID, Name, SafetyStockLevel
-- FROM Production.Product
-- WHERE SafetyStockLevel>=@StockLevel;

-- E X A M P L E  3
--Batch 1: Filter Price for high-value black products

-- DECLARE @MaxPrice DECIMAL (10, 2) = 1000.00;
-- DECLARE @Color NVARCHAR(15) = 'Black';

-- --Calculate Discount Price For High Value Black Products WHERE THE DISCOUNT IS 10%

-- SELECT ProductID, Name, ListPrice, (ListPrice*0.90) AS DiscountedPrice, (ListPrice*0.10) AS DiscountPrice
-- FROM Production.Product
-- WHERE ListPrice <=@MaxPrice  AND Color = @Color;
-- GO

-- DECLARE @MaxPrice DECIMAL (10, 2) = 1000.00;
-- DECLARE @Color NVARCHAR(15) = 'Red';

-- --Calculate Discount Price For High Value Black Products WHERE THE DISCOUNT IS 10%

-- SELECT ProductID, Name, ListPrice, (ListPrice*0.90) AS DiscountedPrice, (ListPrice*0.10) AS DiscountPrice
-- FROM Production.Product
-- WHERE ListPrice <=@MaxPrice  AND Color = @Color;
-- GO



-- U N I O  N   A L L
--BATCH 1
DECLARE @Color1 NVARCHAR (15)='Red';
SELECT ProductID, Name, Color
FROM Production.Product
WHERE Color =@Color1;
GO 

--BATCH 2
DECLARE @Color1 NVARCHAR (15)='Red';
DECLARE @Color2 NVARCHAR(15)='Blue';
SELECT ProductID, Name, Color
FROM Production.Product
WHERE Color = @Color1
UNION ALL
SELECT ProductID, Name, Color
FROM Production.Product
WHERE Color =@Color2;