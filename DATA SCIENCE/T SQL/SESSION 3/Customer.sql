
-- CREATE TABLE CustomerFeedback (
--     FeedbackID INT PRIMARY KEY,
--     CustomerID INT FOREIGN KEY REFERENCES Sales.Customer(CustomerID),
--     FeedbackDate DATE NOT NULL DEFAULT GETDATE(),
--     FeedbackText NVARCHAR(500) NOT NULL,
--     Rating INT CHECK (Rating BETWEEN 1 AND 5)
-- );

INSERT INTO dbo.CustomerFeedback (FeedbackID, CustomerID, FeedbackDate, FeedbackText, Rating)
VALUES
(1, 1, '2023-10-01', 'Great service and fast delivery!', 5),
(2, 2, '2023-10-02', 'Product quality was not as expected.', 2),
(3, 3, '2023-10-03', 'Excellent customer support!', 4),
(4, 4, '2023-10-04', 'Very satisfied with my purchase.', 5),
(5, 5, '2023-10-05', 'Delivery was delayed but the product is good.', 3);