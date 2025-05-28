/* tsqllint-disable error data-compression */
/* tsqllint-disable error semicolon-termination */
/* tsqllint-disable error select-star */
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET QUOTED_IDENTIFIER ON;
SET NOCOUNT ON;
SET ANSI_NULLS ON;
SET NOCOUNT ON;


USE AdventureWorks2022;
-- CREATE TABLE dbo.SalesLog(
--     LogID INT PRIMARY KEY,
--     SalesDate DATE NOT NULL,
--     Ammount DECIMAL (10, 2),
--     Description NVARCHAR(200)
-- );

-- INSERT INTO dbo.SalesLog(
--    LogID,
--    SalesDate, 
--    Ammount,
--    Description
-- ) 
-- VALUES 
-- (1, '2025-05-25', 1500.00, 'Akpu and Egusi'),
-- (2, '2025-05-26', 1510.00, 'Amala and White Soup'),
-- (3, '2025-05-27', 1590.00, 'Akpu and Okra'),
-- (4, '2025-05-28', 1700.00, 'Ebah and Egusi');
-- SELECT * FROM dbo.SalesLog;

-- ALTER TABLE dbo.SalesLog
-- ADD QuantitySold INT DEFAULT 1;
-- ALTER TABLE dbo.SalesLog
-- ALTER COLUMN Description NVARCHAR(1000);
-- ALTER TABLE dbo.SalesLog
-- DROP COLUMN QuantitySold;

-- SELECT * FROM dbo.SalesLog;

-- CREATE TABLE dbo.OrderTracking (
--     OrderID INT PRIMARY KEY,
--     OrderDescription NVARCHAR(500),
--     OrderDate DATE NOT NULL,
--     OrderPrice DECIMAL(10,2)
-- );

-- INSERT INTO dbo.OrderTracking(
--     OrderID, 
--     OrderDescription,
--     OrderDate,
--     OrderPrice
-- )
-- VALUES (9, 'Computers', '2025-12-25',443229.00),
-- (10, 'Mobile Phones', '2025-12-26',929384.94),
-- (11, 'Office Utilities', '2025-12-27',453224.40),
-- (12, 'Clothings', '2025-12-28',376493.98),
-- (13, 'Learning Materials', '2025-12-29',322983.00),
-- (14, 'Training Boots' ,'2025-12-30',674349.65),
-- (15, 'Building Operating Systems' ,'2025-12-31',67994.43),
-- (16, 'Developers for sales', '2026-1-1',4500000.98);

-- SELECT * FROM Production.Product;






-- CREATE TABLE dbo.EmployeeReviews(
--     ReviewID INT PRIMARY KEY,
--     EmployeeID INT NOT NULL,
--     ReviewDate DATE,
--     FeedBack NVARCHAR(500)
-- );


-- CREATE TABLE EmployeeReviews(
--     ReviewID INT PRIMARY KEY,
--     EmployeeID INT NOT NULL FOREIGN KEY REFERENCES HumanResources.Employee(BusinessEntityID),
--     ReviewDate DATE,
--     Feedback NVARCHAR(500)
-- );

-- ALTER TABLE EmployeeReviews
-- ADD Score INT DEFAULT 0;

SELECT * FROM dbo.EmployeeReviews;