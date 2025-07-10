## **comprehensive class note** on **Transactions in T-SQL**,


* **Definitions of terms**
* **Explanations**
* **Use cases**
* **Examples**
* **Classwork exercises**

The class assumes use of **SQL Server Management Studio (SSMS)** with the **AdventureWorks2022** sample database installed.

---

## 🧾 Class Note: **Transactions in T-SQL (SQL Server)**

**Database:** AdventureWorks2022
**Tool:** SQL Server Management Studio (SSMS)

---

### 📌 I. **Definition of Key Terms**

| Term                  | Definition                                                                                                                       |
| --------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| **Transaction**       | A group of SQL statements that are executed as a single unit. If any statement fails, the entire transaction can be rolled back. |
| **ACID**              | Properties that ensure reliable transactions: Atomicity, Consistency, Isolation, Durability.                                     |
| **BEGIN TRANSACTION** | Starts a new transaction.                                                                                                        |
| **COMMIT**            | Saves all changes made during the transaction.                                                                                   |
| **ROLLBACK**          | Undoes all changes made during the transaction.                                                                                  |
| **SAVEPOINT**         | Marks a point within a transaction to roll back to.                                                                              |
| **@@TRANCOUNT**       | Returns the number of active transactions for the current session.                                                               |

---

### 🟢 Level 1: **Basic Concepts**

#### ✅ Explanation

* Transactions ensure that **multiple statements are completed successfully** or **none are applied**.
* They are useful when **modifying data** to ensure accuracy.

#### ✅ Use Case

* Transferring money between accounts: if debit fails, credit should not proceed.

#### ✅ Example

```sql
USE AdventureWorks2022;
GO

BEGIN TRANSACTION;

UPDATE Person.Person
SET FirstName = 'Jonathan'
WHERE BusinessEntityID = 1;

-- COMMIT saves the change
COMMIT;
```

#### 🧑🏾‍🏫 Classwork 1 (Basic)

**Task**: Update a record in `Person.Person` and commit it.

```sql
BEGIN TRANSACTION;

UPDATE Person.Person
SET LastName = 'Doe'
WHERE BusinessEntityID = 5;

COMMIT;
```

**Now change BusinessEntityID = 6, but use `ROLLBACK` instead of `COMMIT`.**

---

### 🟡 Level 2: **Intermediate Usage**

#### ✅ Explanation

* You can **test error scenarios** and **undo changes** using `ROLLBACK`.
* Use **@@TRANCOUNT** to check transaction depth.

#### ✅ Use Case

* Ensure that both product stock update and order insert succeed.

#### ✅ Example

```sql
BEGIN TRANSACTION;

UPDATE Production.Product
SET ListPrice = ListPrice + 10
WHERE ProductID = 709; -- Assume product exists

-- Simulate an error
DECLARE @x INT = 1/0;

COMMIT;
```

**This will fail and not commit.**

#### ✅ Improved Version with Error Handling:

```sql
BEGIN TRY
    BEGIN TRANSACTION;

    UPDATE Production.Product
    SET ListPrice = ListPrice + 10
    WHERE ProductID = 709;

    COMMIT;
END TRY
BEGIN CATCH
    ROLLBACK;
    PRINT 'Error occurred. Transaction rolled back.';
    PRINT ERROR_MESSAGE();
END CATCH;
```

#### 🧑🏾‍🏫 Classwork 2 (Intermediate)

**Task**: Write a transaction that inserts a record into `Sales.SalesOrderDetail` and updates a product’s quantity in `Production.ProductInventory`. Add error handling so that both operations rollback if any fails.

---

### 🔴 Level 3: **Advanced Transaction Control**

#### ✅ Explanation

* Use **SAVEPOINTs** to roll back part of a transaction.
* You can nest transactions, although only the **outer COMMIT** really finalizes it.
* Transactions can **lock rows/tables**, affecting concurrency.

#### ✅ Use Case

* Complex batch operations: partially rollback only the failed part.

#### ✅ Example: Using SAVEPOINT

```sql
BEGIN TRANSACTION;

UPDATE Production.Product
SET ListPrice = ListPrice + 50
WHERE ProductID = 870;

SAVE TRAN SavePoint1;

-- Simulate an issue
UPDATE Production.Product
SET ListPrice = NULL
WHERE ProductID = 9999; -- Assuming this fails or is invalid

-- Rollback only to SavePoint1
ROLLBACK TRAN SavePoint1;

COMMIT;
```

#### ✅ Example: Check Transaction Nesting

```sql
BEGIN TRANSACTION;
PRINT @@TRANCOUNT; -- 1

BEGIN TRANSACTION;
PRINT @@TRANCOUNT; -- 2

COMMIT; -- Reduces count
PRINT @@TRANCOUNT; -- 1

COMMIT;
```

#### 🧑🏾‍🏫 Classwork 3 (Advanced)

1. Write a transaction that:

   * Updates a product price
   * Inserts into `Sales.SpecialOffer`
   * Uses a SAVEPOINT before inserting
   * If the insert fails, rollback to the SAVEPOINT, and commit the update.

---

## 🧠 Summary

| Concept         | Description                                            |
| --------------- | ------------------------------------------------------ |
| **Atomicity**   | All operations in a transaction complete or none.      |
| **Consistency** | Transaction brings DB from one valid state to another. |
| **Isolation**   | Transactions don’t interfere with each other.          |
| **Durability**  | Once committed, changes persist even after crash.      |

---

## 🧪 Suggested Practice

### 🧩 Assignment

1. Create a stored procedure that performs an insert and update in one transaction.
2. Simulate a logical error and handle it using TRY...CATCH.
3. Create a log table and insert error messages into it when transactions fail.
