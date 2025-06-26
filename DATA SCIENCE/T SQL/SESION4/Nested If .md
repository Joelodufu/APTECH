
---

## ✅ **LEVEL 1 – Basic Nested IF**

### 🎯 Goal: Check if an employee exists and whether they are salaried.

```sql
DECLARE @EmployeeID INT = 1
DECLARE @IsSalaried BIT

IF EXISTS (
    SELECT 1 FROM HumanResources.Employee WHERE BusinessEntityID = @EmployeeID
)
BEGIN
    SELECT @IsSalaried = SalariedFlag
    FROM HumanResources.Employee
    WHERE BusinessEntityID = @EmployeeID

    IF @IsSalaried = 1
        PRINT 'Employee exists and is salaried.'
    ELSE
        PRINT 'Employee exists but is hourly paid.'
END
```

📘 *Nested `IF` used inside `IF EXISTS` to verify and act only if the employee exists.*

---

## ✅ **LEVEL 2 – Intermediate Nested IF**

### 🎯 Goal: Check if a person has a title, and then evaluate the specific title.

```sql
DECLARE @PersonID INT = 1
DECLARE @Title NVARCHAR(8)

SELECT @Title = Title
FROM Person.Person
WHERE BusinessEntityID = @PersonID

IF @Title IS NOT NULL
BEGIN
    IF @Title = 'Mr.'
        PRINT 'Hello Sir!'
    ELSE IF @Title = 'Ms.' OR @Title = 'Mrs.'
        PRINT 'Hello Ma’am!'
    ELSE
        PRINT 'Hello, titled person!'
END
```

📘 *First checks for presence of a title, then drills down into specifics.*

---

## ✅ **LEVEL 3 – Advanced Nested IF**

### 🎯 Goal: Determine how old a sales order is, then check if it was above \$1,000.

```sql
DECLARE @SalesOrderID INT = 43659
DECLARE @OrderDate DATE
DECLARE @DaysOld INT
DECLARE @TotalDue MONEY

SELECT @OrderDate = OrderDate, @TotalDue = TotalDue
FROM Sales.SalesOrderHeader
WHERE SalesOrderID = @SalesOrderID

SET @DaysOld = DATEDIFF(DAY, @OrderDate, GETDATE())

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
```

📘 *Nested logic combines **date** and **amount** checks in stages.*

---

## 🧑‍🏫 ** Tip:**


* Replace `PRINT` with `SELECT` for debugging.
* Add more layers, e.g., check if customer is VIP.
* Add an outer `IF` to check if the data even exists.

