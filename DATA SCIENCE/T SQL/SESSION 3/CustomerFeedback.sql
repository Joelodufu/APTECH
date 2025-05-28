/* tsqllint-disable error invalid-syntax */
/* tsqllint-disable error set-nocount */

-- USE AdventureWorkS2022;
-- CREATE TABLE CustomerFeedback(
--     FeedbackID INT PRIMARY KEY ,
--     CustomerID INT NOT NULL FOREIGN KEY REFERENCES Sales.Customer(CustomerID),
--     FeedbackDate DATE NOT NULL,
--     Comments NVARCHAR(500),
--     Rating INT CHECK (Rating BETWEEN 1 AND 5)
-- );



-- DATA MODIFICATION

SELECT * FROM CustomerFeedback;

-- INSERT INTO CustomerFeedback(
--     FeedbackID,
--     CustomerID,
--     FeedbackDate,
--     Comments,
--     Rating
-- )
--  VALUES (1, 3, '2025-05-27', 'I really liked your service', 5),
--   (2, 3, '2025-05-27', 'I really liked your service', 5),
--   (3, 3, '2025-05-27', 'Fair Service', 3),
--   (4, 5, '2025-05-27', 'Not The Best', 4)

SELECT * FROM CustomerFeedback;
-- SELECT * FROM CustomerFeedback WHERE FeedbackID = 2;

-- UPDATING ROWS
-- UPDATE CustomerFeedback
-- SET Comments ='Poor Customer Service, I dont like you!' WHERE FeedbackID= 1;

-- DELETE FROM CustomerFeedback
-- WHERE CustomerID = 5;