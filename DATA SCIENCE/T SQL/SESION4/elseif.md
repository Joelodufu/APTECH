

## ✅ **LEVEL 1 – Basic ELSE IF**

### 🎯 Goal: Check if an employee is salaried or not.

```sql
DECLARE @EmployeeID INT = 1
DECLARE @IsSalaried BIT

SELECT @IsSalaried = SalariedFlag
FROM HumanResources.Employee
WHERE BusinessEntityID = @EmployeeID

IF @IsSalaried = 1
    PRINT 'Employee is salaried.'
ELSE IF @IsSalaried = 0
    PRINT 'Employee is hourly paid.'
```

📘 *Simple comparison using `ELSE IF` with a `BIT` value.*

---

## ✅ **LEVEL 2 – Intermediate ELSE IF**

### 🎯 Goal: Check a person's title (Mr., Ms., etc.) and print a message.

```sql
DECLARE @PersonID INT = 1
DECLARE @Title NVARCHAR(8)

SELECT @Title = Title
FROM Person.Person
WHERE BusinessEntityID = @PersonID

IF @Title = 'Mr.'
    PRINT 'Hello Sir!'
ELSE IF @Title = 'Ms.' OR @Title = 'Mrs.'
    PRINT 'Hello Ma’am!'
ELSE IF @Title IS NULL
    PRINT 'No title found for this person.'
```

📘 *Demonstrates string comparison with `ELSE IF` and handling NULLs.*

---

## ✅ **LEVEL 3 – Advanced ELSE IF with Date Logic**

### 🎯 Goal: Check how old a sales order is and print a message.

```sql
DECLARE @SalesOrderID INT = 43659
DECLARE @OrderDate DATE
DECLARE @DaysOld INT

SELECT @OrderDate = OrderDate
FROM Sales.SalesOrderHeader
WHERE SalesOrderID = @SalesOrderID

SET @DaysOld = DATEDIFF(DAY, @OrderDate, GETDATE())

IF @DaysOld <= 7
    PRINT 'Recent order (within the last week).'
ELSE IF @DaysOld <= 30
    PRINT 'This order is from this month.'
ELSE IF @DaysOld <= 365
    PRINT 'This order is from earlier this year.'
ELSE IF @DaysOld > 365
    PRINT 'This order is more than a year old.'
```

📘 *Uses `DATEDIFF` and multiple `ELSE IF` conditions with numeric ranges.*

---

### 🧑‍🏫 Teaching Tip:

For practice, you can ask students to:

* Change the IDs to test different records.
* Add `ELSE` blocks for handling missing records.
* Use `PRINT`, `SELECT`, or even `THROW` for invalid values.
