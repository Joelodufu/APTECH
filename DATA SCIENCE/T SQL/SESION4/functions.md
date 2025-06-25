# T-SQL Class Notes: Functions Classification (AdventureWorks2022 Database)

## Overview
Transact-SQL (T-SQL) in SQL Server 2022 offers various functions categorized by their purpose and output, crucial for data manipulation, summarization, and ranking. Using the AdventureWorks2022 database, we explore these functions with practical examples.

## Types of Functions

### Rowset Functions
Rowset functions return an object that can substitute a table reference. Examples include `OPENDATASOURCE`, `OPENQUERY`, `OPENROWSET`, and `OPENXML`. These are useful for accessing external data or linked servers.

**Example (AdventureWorks2022)**:
```sql
SELECT * FROM OPENROWSET('SQLNCLI', 'Server=AdventureWorksServer;Trusted_Connection=yes;', 'SELECT * FROM AdventureWorks2022.HumanResources.Employee');
```
**Scenario**: Imagine pulling employee data from a remote HR system into AdventureWorks2022 for a unified report.

### Aggregate Functions
Aggregate functions summarize large datasets. Examples include `SUM`, `MIN`, `MAX`, `AVG`, `COUNT`, and `COUNTBIG`. They are perfect for generating totals or averages across rows.

**Example (AdventureWorks2022)**:
```sql
SELECT SUM(SalesOrderID) AS TotalOrders, AVG(TotalDue) AS AvgOrderValue
FROM AdventureWorks2022.Sales.SalesOrderHeader;
```
**Scenario**: A sales manager uses this to assess the total number of orders and average order value for the year 2025 up to June 23.

### Ranking Functions
Ranking functions like `RANK`, `DENSE_RANK`, `NTILE`, and `ROW_NUMBER` simplify tasks such as assigning ranks or sequential numbers, enhancing data analysis.

**Example (AdventureWorks2022)**:
```sql
SELECT BusinessEntityID, SalesYTD, ROW_NUMBER() OVER (ORDER BY SalesYTD DESC) AS SalesRank
FROM AdventureWorks2022.Sales.SalesPerson;
```
**Scenario**: A company ranks salespeople based on year-to-date sales to identify top performers as of 12:32 PM WAT on June 23, 2025.

### Scalar Functions
Scalar functions take a single value as input and return a single value, useful for data transformation. Examples include `CONVERT`, `GETDATE`, `ROUND`, and `SUBSTRING`.

**Example (AdventureWorks2022)**:
```sql
SELECT BusinessEntityID, CONVERT(varchar, OrderDate, 107) AS FormattedDate
FROM AdventureWorks2022.Sales.SalesOrderHeader;
```
**Scenario**: Formatting order dates from the SalesOrderHeader table into a readable "Mon dd, yyyy" format for a customer report.

## Classwork

1. **Rowset Function Task**:
   Use `OPENQUERY` to fetch employee details from a linked server 'AdventureWorksLinked' with the query 'SELECT * FROM HumanResources.Employee'.

2. **Aggregate Function Task**:
   Calculate the total and average sales amount from `Sales.SalesOrderHeader` using `SUM` and `AVG`.

3. **Ranking Function Task**:
   Assign a rank to products in `Production.Product` based on `ListPrice` using `DENSE_RANK()`.

4. **Scalar Function Task**:
   Convert the `OrderDate` in `Sales.SalesOrderHeader` to a string in 'yyyy-mm-dd' format using `CONVERT`.

## Tests

### Test 1: Rowset Function
Write a query using `OPENROWSET` to retrieve the top 5 employees by hire date from `HumanResources.Employee`.

**Expected Output Example**:
```
BusinessEntityID: 1, HireDate: 2009-01-14
```

### Test 2: Aggregate Function Combination
Write a query to find the total, average, and maximum `TotalDue` from `Sales.SalesOrderHeader` for orders placed in 2025.

**Expected Output Example**:
```
TotalDue: 150000, AvgDue: 750, MaxDue: 5000
```

### Test 3: Ranking Function
Use `NTILE(4)` to divide salespeople in `Sales.SalesPerson` into 4 quartiles based on `SalesYTD`.

**Expected Output Example**:
```
BusinessEntityID: 274, SalesYTD: 5596976.14, Quartile: 1
```

### Test 4: Scalar Function
Extract the year from `OrderDate` in `Sales.SalesOrderHeader` using `YEAR` and concatenate it with ' Orders' using `+`.

**Expected Output Example**:
```
OrderYear: 2025 Orders
```

## Additional Notes
- Rowset functions are ideal for integrating external data, like merging AdventureWorks2022 with a supplier database.
- Aggregate functions help in financial reporting, e.g., quarterly sales summaries.
- Ranking functions assist in performance evaluations or inventory prioritization.
- Scalar functions enhance data presentation, such as formatting dates for invoices.

## Cheatsheet

| **Function Type**   | **Examples**                  | **Explanation**                                                                 |
|----------------------|-------------------------------|---------------------------------------------------------------------------------|
| **Rowset Functions** | `OPENDATASOURCE`, `OPENQUERY`, `OPENROWSET`, `OPENXML` | Return a table-like object for external data access, e.g., linking to HR systems. |
| **Aggregate Functions** | `SUM`, `MIN`, `MAX`, `AVG`, `COUNT`, `COUNTBIG` | Summarize data across rows, e.g., total sales or average order value in SalesOrderHeader. |
| **Ranking Functions** | `RANK`, `DENSE_RANK`, `NTILE`, `ROW_NUMBER` | Assign ranks or sequential numbers, e.g., ranking salespeople by SalesYTD.       |
| **Scalar Functions** | `CONVERT`, `GETDATE`, `ROUND`, `SUBSTRING` | Transform single values, e.g., formatting OrderDate or extracting substrings.    |