/* tsqllint-disable error data-compression */
SET ANSI_NULLS ON;
SET QUOTED_IDENTIFIER ON;
SET NOCOUNT ON;
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

CREATE TABLE dbo.CustomerFeedback (
    FeedbackID INT PRIMARY KEY,
    CustomerID INT FOREIGN KEY REFERENCES Sales.Customer(CustomerID),
    FeedbackDate DATE NOT NULL,
    Comments NVARCHAR(500) NOT NULL,
    Rating INT CHECK (Rating BETWEEN 1 AND 5)
);

