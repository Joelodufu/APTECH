# Class Notes for Session 3 (SQL–TL3): Transact-SQL with Expanded Focus on DDL and DML

## Module
Data Management with SQL Server  
**Session Title**: SQL–TL3  
**Source**: SQL Server–The Definitive Guide, Session 4  
**Duration**: 2 hours  
**Objective**: By the end of this session, students will be able to:
- Understand Transact-SQL (T-SQL) and its role in SQL Server, with a deep focus on DDL (`CREATE`, `ALTER`, `DROP`) and DML statements.
- Categorize and apply T-SQL statements, emphasizing DDL and DML.
- Describe T-SQL data types, language elements, sets, predicate logic, and the logical order of SELECT statements.
- Write and execute T-SQL queries in SSMS using the AdventureWorks 2022 database.

---

## Sub-Session 1: Introduction to Transact-SQL

### Definition
Transact-SQL (T-SQL) is Microsoft’s proprietary extension to SQL, used for interacting with SQL Server databases. It includes standard SQL for querying and managing data, plus advanced features like procedural programming, error handling, and functions.

### Explanation
- **Purpose**: T-SQL enables creating, querying, modifying, and managing databases.
- **Components**: Includes DDL (defining structures), DML (manipulating data), DCL (controlling access), and procedural constructs (e.g., stored procedures).
- **Execution**: Run via SSMS, command-line tools, or application code.

### Example
```sql
USE AdventureWorks2022;
SELECT FirstName, LastName
FROM Person.Person
WHERE Title = 'Ms.';
```
This query retrieves names of individuals with the title "Ms." from the `Person.Person` table.

### Class Work
1. **Discussion**: Students discuss how T-SQL’s procedural capabilities (e.g., variables, loops) extend standard SQL, using an example from AdventureWorks.
2. **Lab Exercise**: Write a T-SQL query to retrieve the top 5 records from `Production.Product`. Save as `IntroTSQL.sql` and execute in SSMS.

---

## Sub-Session 2: Categories of Transact-SQL Statements with Expanded Focus on DDL and DML

### Definition
T-SQL statements are categorized into:
- **Data Definition Language (DDL)**: Defines or modifies database structures (e.g., tables, schemas).
- **Data Manipulation Language (DML)**: Manipulates data within tables (e.g., query, insert, update).
- **Data Control Language (DCL)**: Manages permissions (e.g., `GRANT`, `REVOKE`).

### Expanded Focus on DDL: CREATE, ALTER, DROP

#### CREATE
- **Definition**: Creates new database objects like tables, views, or schemas.
- **Syntax**:
  ```sql
  CREATE TABLE TableName (
      Column1 DataType [Constraints],
      Column2 DataType [Constraints],
      ...
  );
  ```
- **Key Features**:
  - Defines columns, data types, and constraints (e.g., `PRIMARY KEY`, `FOREIGN KEY`, `NOT NULL`).
  - Supports creating indexes, triggers, or stored procedures.
  - Ensures objects are uniquely named within a schema.
- **Use Cases**: Creating tables for new data, such as customer records or logs.
- **Best Practices**:
  - Use meaningful column names and appropriate data types.
  - Include constraints to enforce data integrity (e.g., `CHECK` for valid ranges).
  - Specify schemas to avoid naming conflicts (e.g., `dbo.TableName`).

**Example**:
```sql
USE AdventureWorks2022;
CREATE TABLE CustomerFeedback (
    FeedbackID INT PRIMARY KEY,
    CustomerID INT NOT NULL FOREIGN KEY REFERENCES Sales.Customer(CustomerID),
    FeedbackDate DATE NOT NULL,
    Comments NVARCHAR(500),
    Rating INT CHECK (Rating BETWEEN 1 AND 5)
);
```
This creates a table to store customer feedback, linked to the `Sales.Customer` table, with constraints for data integrity.

#### ALTER
- **Definition**: Modifies existing database objects, such as adding, modifying, or dropping columns or constraints.
- **Syntax**:
  ```sql
  ALTER TABLE TableName
  ADD ColumnName DataType [Constraints] |
  ALTER COLUMN ColumnName DataType [Constraints] |
  DROP COLUMN ColumnName;
  ```
- **Key Features**:
  - Adds new columns or constraints (e.g., `ADD` for new fields).
  - Modifies column properties (e.g., changing data type or constraints).
  - Drops columns or constraints (with caution to avoid data loss).
- **Use Cases**: Updating a table to include new fields (e.g., adding a `Status` column) or changing data types for better storage.
- **Best Practices**:
  - Verify data