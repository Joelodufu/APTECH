

---

# 🔁 WHILE Loop – 3 Complexity Levels in T-SQL

---

## ✅ **LEVEL 1 – Basic WHILE Loop**

### 🎯 Goal: Print numbers from 1 to 5

```sql
DECLARE @Counter INT = 1

WHILE @Counter <= 5
BEGIN
    PRINT 'Counter value: ' + CAST(@Counter AS NVARCHAR)
    SET @Counter = @Counter + 1
END
```

📘 *Introductory logic to understand WHILE loop syntax and incrementation.*

---

## ✅ **LEVEL 2 – Intermediate WHILE Loop**

### 🎯 Goal: Print the first 5 email addresses from `Person.EmailAddress`

```sql
DECLARE @Counter INT = 1
DECLARE @Max INT = 5
DECLARE @Email NVARCHAR(50)

DECLARE email_cursor CURSOR FOR
    SELECT TOP (@Max) EmailAddress
    FROM Person.EmailAddress
    ORDER BY BusinessEntityID

OPEN email_cursor
FETCH NEXT FROM email_cursor INTO @Email

WHILE @Counter <= @Max AND @@FETCH_STATUS = 0
BEGIN
    PRINT 'Email ' + CAST(@Counter AS NVARCHAR) + ': ' + @Email
    SET @Counter = @Counter + 1
    FETCH NEXT FROM email_cursor INTO @Email
END

CLOSE email_cursor
DEALLOCATE email_cursor
```

📘 *Combines `WHILE` with a cursor. Emphasizes cursor iteration control using `@@FETCH_STATUS`.*

---

## ✅ **LEVEL 3 – Advanced WHILE Loop**

### 🎯 Goal: Calculate total sales for the first 10 orders, one by one, and stop if total exceeds \$10,000

```sql
DECLARE @OrderID INT
DECLARE @Total MONEY = 0
DECLARE @RunningTotal MONEY = 0
DECLARE @Counter INT = 1
DECLARE @Max INT = 10

DECLARE order_cursor CURSOR FOR
    SELECT TOP (@Max) SalesOrderID, TotalDue
    FROM Sales.SalesOrderHeader
    ORDER BY SalesOrderID

OPEN order_cursor
FETCH NEXT FROM order_cursor INTO @OrderID, @Total

WHILE @@FETCH_STATUS = 0
BEGIN
    SET @RunningTotal += @Total
    PRINT 'Order ' + CAST(@OrderID AS NVARCHAR) + ' Total: $' + CAST(@Total AS NVARCHAR)
    PRINT 'Running Total: $' + CAST(@RunningTotal AS NVARCHAR)

    IF @RunningTotal > 10000
    BEGIN
        PRINT 'Stopping loop: Total sales exceeded $10,000'
        BREAK
    END

    SET @Counter += 1
    FETCH NEXT FROM order_cursor INTO @OrderID, @Total
END

CLOSE order_cursor
DEALLOCATE order_cursor
```

📘 *Demonstrates WHILE with `BREAK`, accumulation logic, and business rules.*

---

## 🧠 Summary

| Level | Focus                               | Concepts Used                       |
| ----- | ----------------------------------- | ----------------------------------- |
| 1     | Counter & loop                      | `WHILE`, `PRINT`, `SET`             |
| 2     | Data row iteration                  | `WHILE`, `CURSOR`, `@@FETCH_STATUS` |
| 3     | Business logic with break condition | `WHILE`, `CURSOR`, `BREAK`, totals  |

---