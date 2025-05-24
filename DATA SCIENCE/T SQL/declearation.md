# 📘 **SQL & T-SQL Cheat Sheet (Categorized)**

---

## 📂 1. **Data Retrieval (Querying)**

| **Keyword**    | **Purpose**                            | **Example**                              |
| -------------- | -------------------------------------- | ---------------------------------------- |
| `SELECT`       | Retrieve columns                       | `SELECT Name FROM Users;`                |
| `FROM`         | Specify source table                   | `FROM Products`                          |
| `WHERE`        | Filter rows                            | `WHERE Age > 18`                         |
| `ORDER BY`     | Sort results                           | `ORDER BY Name ASC`                      |
| `DISTINCT`     | Remove duplicates                      | `SELECT DISTINCT Country FROM Users;`    |
| `TOP`          | Limit number of results (T-SQL)        | `SELECT TOP 10 * FROM Sales;`            |
| `LIMIT`        | Limit results (Not supported in T-SQL) | ❌ Use `TOP` instead                     |
| `OFFSET-FETCH` | Pagination (T-SQL 2012+)               | `OFFSET 10 ROWS FETCH NEXT 5 ROWS ONLY;` |

---

## 🧮 2. **Filtering and Conditions**

| **Keyword**      | **Purpose**                | **Example**                             |
| ---------------- | -------------------------- | --------------------------------------- |
| `AND / OR / NOT` | Combine logical conditions | `WHERE Age > 18 AND Country = 'US'`     |
| `IN`             | Match any in a list        | `WHERE City IN ('Lagos', 'Abuja')`      |
| `BETWEEN`        | Filter in a range          | `WHERE Salary BETWEEN 50000 AND 100000` |
| `LIKE`           | Pattern matching           | `WHERE Name LIKE 'J%'`                  |
| `IS NULL`        | Check for null             | `WHERE Email IS NULL`                   |

---

## 🧑‍🤝‍🧑 3. **Joining and Combining Tables**

| **Keyword**           | **Purpose**                         | **Example**                                        |
| --------------------- | ----------------------------------- | -------------------------------------------------- |
| `JOIN` / `INNER JOIN` | Match rows in both tables           | `JOIN Orders ON Users.ID = Orders.UserID`          |
| `LEFT JOIN`           | Include unmatched from left table   | `LEFT JOIN Orders ON Users.ID = Orders.UserID`     |
| `RIGHT JOIN`          | Include unmatched from right table  | `RIGHT JOIN Orders ...`                            |
| `FULL JOIN`           | All matches from both sides         | `FULL JOIN Orders ...`                             |
| `UNION`               | Combine results (remove duplicates) | `SELECT Name FROM A UNION SELECT Name FROM B;`     |
| `UNION ALL`           | Combine all results                 | `SELECT Name FROM A UNION ALL SELECT Name FROM B;` |

---

## 🔢 4. **Grouping and Aggregation**

| **Keyword**       | **Purpose**               | **Example**           |
| ----------------- | ------------------------- | --------------------- |
| `GROUP BY`        | Aggregate by fields       | `GROUP BY Department` |
| `HAVING`          | Filter aggregated results | `HAVING COUNT(*) > 5` |
| `COUNT()`         | Count rows                | `COUNT(*)`            |
| `SUM()`           | Total values              | `SUM(Salary)`         |
| `AVG()`           | Average                   | `AVG(Score)`          |
| `MAX()` / `MIN()` | Highest / Lowest values   | `MAX(Price)`          |

---

## 🛠 5. **Data Modification**

| **Keyword**      | **Purpose**          | **Example**                                |
| ---------------- | -------------------- | ------------------------------------------ |
| `INSERT INTO`    | Add data to a table  | `INSERT INTO Users(Name) VALUES ('Joel');` |
| `UPDATE`         | Modify existing data | `UPDATE Users SET Age = 25 WHERE ID = 1;`  |
| `DELETE`         | Remove specific rows | `DELETE FROM Users WHERE ID = 1;`          |
| `TRUNCATE TABLE` | Delete all rows fast | `TRUNCATE TABLE Logs;`                     |

---

## 🧱 6. **Table & Schema Definition**

| **Keyword**    | **Purpose**               | **Example**                                          |
| -------------- | ------------------------- | ---------------------------------------------------- |
| `CREATE TABLE` | Define new table          | `CREATE TABLE Products (ID INT, Name NVARCHAR(50));` |
| `ALTER TABLE`  | Modify existing table     | `ALTER TABLE Products ADD Price MONEY;`              |
| `DROP TABLE`   | Delete table              | `DROP TABLE Products;`                               |
| `CREATE INDEX` | Improve query performance | `CREATE INDEX ix_name ON Users(Name);`               |

---

## 🧠 7. **Control Flow (T-SQL only)**

| **T-SQL Keyword** | **Purpose**              | **Example**                                       |
| ----------------- | ------------------------ | ------------------------------------------------- |
| `DECLARE`         | Create a variable        | `DECLARE @Name NVARCHAR(50);`                     |
| `SET`             | Assign value to variable | `SET @Name = 'Joel';`                             |
| `IF...ELSE`       | Conditional logic        | `IF @x > 10 BEGIN ... END ELSE BEGIN ... END`     |
| `WHILE`           | Loop                     | `WHILE @x < 10 BEGIN SET @x = @x + 1 END`         |
| `BEGIN...END`     | Code block               | `BEGIN SELECT 1; END`                             |
| `TRY...CATCH`     | Error handling           | `BEGIN TRY ... END TRY BEGIN CATCH ... END CATCH` |
| `PRINT`           | Debug message            | `PRINT 'Step completed';`                         |
| `RETURN`          | Exit procedure/function  | `RETURN;`                                         |
| `RAISERROR`       | Throw custom error       | `RAISERROR('Invalid input', 16, 1);`              |

---

## 📦 8. **Procedures, Functions, Execution**

| **Keyword**        | **Purpose**             | **Example**                                                |
| ------------------ | ----------------------- | ---------------------------------------------------------- |
| `CREATE PROCEDURE` | Define stored procedure | `CREATE PROCEDURE usp_GetUsers AS SELECT * FROM Users;`    |
| `EXEC`             | Run procedure           | `EXEC usp_GetUsers;`                                       |
| `CREATE FUNCTION`  | Define function         | `CREATE FUNCTION GetTotal(@x INT, @y INT) RETURNS INT ...` |

---

## 🔁 9. **Utility / Environment**

| **Keyword** | **Purpose**      | **Example**               |
| ----------- | ---------------- | ------------------------- |
| `USE`       | Select database  | `USE AdventureWorks2022;` |
| `GO`        | Batch separator  | `SELECT 1; GO SELECT 2;`  |
| `COMMENT`   | Add inline notes | `-- This is a comment`    |

---

## ✅ Summary Mnemonic (for recall):

**"CRUD + JOIN + GROUP + FLOW + DEFINE"**
(CRUD: Create, Read, Update, Delete)

---

Would you like a downloadable **PDF or Notion version** of this cheat sheet?
