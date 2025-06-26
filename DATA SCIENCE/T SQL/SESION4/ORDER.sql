DECLARE @SalesOrderID INT = 000
DECLARE @OrderDate DATE
DECLARE @DaysOld INT
DECLARE @TotalDue MONEY

SELECT @OrderDate = OrderDate, @TotalDue = TotalDue
FROM Sales.SalesOrderHeader
WHERE SalesOrderID = @SalesOrderID

SET @DaysOld = DATEDIFF(DAY, @OrderDate, GETDATE())

IF @OrderDate IS NOT NULL
-- WHEN ORDER DATE IS NOT NLL
    BEGIN
        IF @DaysOld <= 30
            BEGIN
                PRINT 'Order is recent (less than 30 days old).'
                IF @TotalDue > 1000
                    PRINT 'This is a high-value recent order.'
                ELSE
                    PRINT 'This is a normal recent order.'
            END
        ELSE
            BEGIN
                PRINT 'Order is older than 30 days.'

                IF @TotalDue > 1000
                    PRINT 'High-value order, but not recent.'
            END
    END
ELSE    
    SELECT 'There Is no Order With such ID'

