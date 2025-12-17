# 📘 Class Note: Operators in T-SQL

## 🔹 1. Introduction

Operators in T-SQL are **symbols or keywords** that perform operations on one or more expressions. They are used for:

* Calculations
* Comparisons
* Filtering data
* Combining results

---

## 🔹 2. Categories of Operators

1. **Arithmetic Operators**

   * `+` (Addition)
   * `-` (Subtraction)
   * `*` (Multiplication)
   * `/` (Division)
   * `%` (Modulo)

2. **Comparison Operators**

   * `=`, `!=`, `<>`, `<`, `>`, `<=`, `>=`

3. **Logical Operators**

   * `AND`, `OR`, `NOT`

4. **Bitwise Operators**

   * `&` (AND), `|` (OR), `^` (XOR), `~` (NOT)

5. **Assignment Operator**

   * `=` (in `SET` or `UPDATE`)

6. **String Operators**

   * `+` (concatenation)
   * `LIKE` (pattern matching)

7. **Set Operators**

   * `UNION`, `UNION ALL`, `INTERSECT`, `EXCEPT`

8. **Special Operators**

   * `IN`, `BETWEEN`, `IS NULL`, `EXISTS`

---

## 🔹 3. Examples

### ✅ Basic (Arithmetic + Comparison)

```sql
-- Arithmetic
SELECT 15 + 5 AS Addition, 15 - 5 AS Subtraction, 
       15 * 5 AS Multiplication, 15 / 5 AS Division;

-- Comparison
SELECT * FROM Employees WHERE Salary > 50000;
```

### ✅ Intermediate (Logical + String)

```sql
-- Logical
SELECT * FROM Employees 
WHERE Department = 'IT' AND Salary > 60000;

-- String Concatenation
SELECT FirstName + ' ' + LastName AS FullName 
FROM Employees;
```

### ✅ Advanced (Set + Bitwise + Special)

```sql
-- Set Operator
SELECT Name FROM Students
UNION
SELECT Name FROM Teachers;

-- Bitwise
SELECT 5 & 3 AS BitwiseAND, 5 | 3 AS BitwiseOR, 5 ^ 3 AS BitwiseXOR;

-- Special Operator
SELECT * FROM Orders 
WHERE OrderDate BETWEEN '2023-01-01' AND '2023-12-31';
```

---

## 🔹 4. Classwork with Solutions

### 🟢 Basic

**Q1.** Write a query to calculate the total price of 10 items, each costing 250.

```sql
SELECT 10 * 250 AS TotalPrice;
-- Result: 2500
```

**Q2.** Retrieve all employees who earn less than 40,000.

```sql
SELECT * FROM Employees 
WHERE Salary < 40000;
```

---

### 🟡 Intermediate

**Q1.** Display employees whose department is “Finance” **or** salary is above 70,000.

```sql
SELECT * FROM Employees 
WHERE Department = 'Finance' OR Salary > 70000;
```

**Q2.** Concatenate first name and last name into a single column called `EmployeeName`.

```sql
SELECT FirstName + ' ' + LastName AS EmployeeName 
FROM Employees;
```

---

### 🔴 Advanced

**Q1.** Use `UNION` to combine two tables: `Customers` and `Suppliers`, showing only distinct names.

```sql
SELECT CustomerName AS Name FROM Customers
UNION
SELECT SupplierName AS Name FROM Suppliers;
```

**Q2.** Find all orders where `Quantity` is **between 50 and 100**.

```sql
SELECT * FROM Orders 
WHERE Quantity BETWEEN 50 AND 100;
```

**Q3.** Perform a bitwise `AND` operation on `12 & 5`.

```sql
SELECT 12 & 5 AS BitwiseAND;
-- Binary: 12 (1100), 5 (0101) → 0100 = 4
-- Result: 4
```

---

## 🔹 5. Real-Life Use Cases

* **Payroll Systems** → Arithmetic operators for salary computation.
* **HR Filtering** → Comparison + Logical operators to shortlist candidates.
* **Merging Reports** → Set operators (`UNION`, `INTERSECT`) to unify branch data.
* **Fraud Detection** → Bitwise operators for encoded transaction flags.

---
