
## ✅ Part 1: Lab Exercise — `LanguageElements.sql`

### **Task**:

Write a script that:

* Declares a **variable** for a sales threshold.
* Uses a **predicate** to filter orders above that threshold.
* Includes at least one **expression** (e.g., a calculation).

### ✅ Example Script:

```sql
-- LanguageElements.sql
USE AdventureWorks2022;
GO

-- Declare a variable
DECLARE @SalesThreshold MONEY = 10000.00;

-- Query with predicate and expression
SELECT 
    SalesOrderID,
    OrderDate,
    SubTotal,
    TaxAmt,
    Freight,
    SubTotal + TaxAmt + Freight AS TotalAmount -- Expression
FROM Sales.SalesOrderHeader
WHERE SubTotal > @SalesThreshold; -- Predicate
```

### ✅ Language Elements Identified in the Script:

* **Variable**: `@SalesThreshold`
* **Predicate**: `SubTotal > @SalesThreshold`
* **Expression**: `SubTotal + TaxAmt + Freight AS TotalAmount`

---

## ✅ Part 2: Activity — Identify Language Elements

Let’s say you're given this T-SQL script:

```sql
USE AdventureWorks2022;
GO

DECLARE @MinFreight MONEY = 50;

SELECT 
    SalesOrderID,
    Freight,
    SubTotal,
    SubTotal * 0.1 AS DiscountEstimate
FROM Sales.SalesOrderHeader
WHERE Freight >= @MinFreight;
```

### 🧠 Identify the Language Elements:

| Element Type   | Example from Script                  |
| -------------- | ------------------------------------ |
| **Variable**   | `@MinFreight`                        |
| **Predicate**  | `Freight >= @MinFreight`             |
| **Expression** | `SubTotal * 0.1 AS DiscountEstimate` |

---