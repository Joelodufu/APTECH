In **T-SQL (Transact-SQL)**, a **predicate** is an expression that evaluates to **TRUE**, **FALSE**, or **UNKNOWN** and is typically used in:

* `WHERE` clauses
* `JOIN` conditions
* `HAVING` clauses
* `IF` statements
* `CASE` expressions

### 🔹 Common Types of Predicates in T-SQL

Here are examples of common predicates:

---

### 1. **Comparison Predicates**

Used to compare values.

```sql
SELECT * FROM Employees WHERE Salary > 50000;
-- Predicate: Salary > 50000
```

---

### 2. **BETWEEN Predicate**

Checks if a value falls within a range.

```sql
SELECT * FROM Orders WHERE OrderDate BETWEEN '2023-01-01' AND '2023-12-31';
```

---

### 3. **IN Predicate**

Checks if a value exists in a list.

```sql
SELECT * FROM Products WHERE CategoryID IN (1, 2, 3);
```

---

### 4. **LIKE Predicate**

Used for pattern matching.

```sql
SELECT * FROM Customers WHERE Name LIKE 'J%';
```

---

### 5. **IS NULL / IS NOT NULL**

Checks for null values.

```sql
SELECT * FROM Employees WHERE ManagerID IS NULL;
```

---

### 6. **EXISTS Predicate**

Checks for the existence of rows in a subquery.

```sql
SELECT * FROM Customers 
WHERE EXISTS (SELECT 1 FROM Orders WHERE Customers.CustomerID = Orders.CustomerID);
```

---

### 7. **ANY / ALL Predicates**

Compare a value to a set returned by a subquery.

```sql
SELECT * FROM Products 
WHERE Price > ALL (SELECT Price FROM Products WHERE CategoryID = 1);
```

---

### Summary

| Predicate Type | Example                                           |
| -------------- | ------------------------------------------------- |
| Comparison     | `Salary > 50000`                                  |
| BETWEEN        | `OrderDate BETWEEN '2023-01-01' AND '2023-12-31'` |
| IN             | `CategoryID IN (1, 2, 3)`                         |
| LIKE           | `Name LIKE 'J%'`                                  |
| IS NULL        | `ManagerID IS NULL`                               |
| EXISTS         | `EXISTS (SELECT 1 FROM Orders ...)`               |
| ANY / ALL      | `Price > ALL (...)`                               |

Predicates are essential for filtering and controlling logic flow in SQL queries.
