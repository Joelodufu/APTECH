# Class Notes: Intelligent Data Management with SQL Server

## Session 1: RDBMS Concepts

### Overview
This session introduces the fundamental concepts of databases and Relational Database Management Systems (RDBMS), exploring data management approaches, database models, and the role of tables and entities in SQL Server.

### Key Concepts
- **Data and Database**: Data is raw information, and a database is an organized collection of data for easy access, management, and updates.
- **Data Management Approaches**:
  - **File-based Systems**: Store data in discrete files, prone to redundancy, inconsistency, and limited query flexibility.
  - **Database Systems**: Centralized, reducing redundancy, ensuring consistency, and enabling secure, shared access.
- **DBMS vs. RDBMS**:
  - DBMS: A set of programs to manage data in files.
  - RDBMS: Manages relational databases with tables, relationships, and SQL for querying.
- **Database Models**:
  - Flat File: Single table, simple but prone to redundancy.
  - Hierarchical: Tree-like structure, parent-child relationships.
  - Network: Allows multiple parent-child links, uses set theory.
  - Relational: Tables with rows (tuples) and columns (attributes), linked by common keys.

### Example: Understanding Tables and Relationships
Consider a school database with two tables: `Students` and `Marks`.

| Roll Number | Student Name |
|-------------|--------------|
| 1           | Sam Reiner   |
| 2           | John Parkinson|

| Roll Number | Marks Obtained |
|-------------|----------------|
| 1           | 34             |
| 2           | 87             |

To find students scoring above 50:
1. Query the `Marks` table for `Marks Obtained > 50`.
2. Match `Roll Number` with the `Students` table to get names.

**SQL Query:**
```sql
SELECT s.Roll Number, s.Student Name, m.Marks Obtained
FROM Students s
JOIN Marks m ON s.Roll Number = m.Roll Number
WHERE m.Marks Obtained > 50;
```

**Result:**
| Roll Number | Student Name   | Marks Obtained |
|-------------|----------------|----------------|
| 2           | John Parkinson | 87             |

### Classwork
1. Create a table `Employees` with columns: `EmpID` (int), `FirstName` (varchar), `LastName` (varchar), `Phone` (varchar).
2. Insert 3 sample records into the `Employees` table.
3. Write a query to retrieve all employees' names and phone numbers.

### Test
1. What is the main difference between a DBMS and an RDBMS?
   - A) DBMS uses SQL, RDBMS does not
   - B) DBMS stores data in files, RDBMS uses tables
   - C) DBMS is relational, RDBMS is not
   - D) RDBMS is a subset of DBMS
2. In a relational model, a row is called a:
   - A) Attribute
   - B) Tuple
   - C) Relation
   - D) Domain
3. List two disadvantages of file-based systems.

**Answers:**
1. B
2. B
3. (e.g., Data redundancy and inconsistency, Difficulty handling unanticipated queries)

---

## Session 3: Introduction to SQL Server 2019

### Overview
This session introduces SQL Server 2019, its features, and its role as an enterprise-level RDBMS for data management, OLTP, data warehousing, and cloud integration.

### Key Concepts
- **SQL Server Overview**: A Microsoft RDBMS for managing and analyzing data, supporting OLTP, data warehousing, and e-commerce.
- **New Features in 2019**:
  - Big Data Clusters: Integrate SQL Server, Spark, and HDFS on Kubernetes.
  - PolyBase: Query external data sources (Hadoop, Oracle, etc.).
  - Query Store: Tracks query performance and plans.
  - Stretch Database: Migrates data to Azure for cost-effective storage.
  - In-Memory Enhancements: Boosts performance for critical workloads.

### Example: Creating a Database
Create a simple database and table in SQL Server Management Studio (SSMS).

**SQL Query:**
```sql
CREATE DATABASE SchoolDB;
GO
USE SchoolDB;
GO
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Grade INT
);
GO
INSERT INTO Students (StudentID, FirstName, LastName, Grade)
VALUES (1, 'Sam', 'Reiner', 85),
       (2, 'John', 'Parkinson', 92);
GO
SELECT * FROM Students;
```

**Result:**
| StudentID | FirstName | LastName   | Grade |
|-----------|-----------|------------|-------|
| 1         | Sam       | Reiner     | 85    |
| 2         | John      | Parkinson  | 92    |

### Classwork
1. Create a database named `CompanyDB`.
2. Create a table `Departments` with columns: `DeptID` (int, primary key), `DeptName` (varchar), `Location` (varchar).
3. Insert 2 sample records into `Departments`.
4. Query all records from the `Departments` table.

### Test
1. SQL Server 2019 supports querying data from:
   - A) Hadoop
   - B) Oracle
   - C) MongoDB
   - D) All of these
2. What feature allows migration of data to Azure for cost-effective storage?
   - A) PolyBase
   - B) Query Store
   - C) Stretch Database
   - D) Big Data Clusters
3. Name two new features introduced in SQL Server 2019.

**Answers:**
1. D
2. C
3. (e.g., Big Data Clusters, PolyBase)

---

## Session 16: Enhancements in SQL Server 2019

### Overview
This session covers SQL Server 2019 enhancements, focusing on Big Data Clusters and JSON data handling for modern data management.

### Key Concepts
- **Big Data Clusters**:
  - Deploy SQL Server, Spark, and HDFS on Kubernetes.
  - Use cases: Query external data, store big data in HDFS, support AI and ML tasks.
- **JSON in SQL Server**:
  - Store and exchange unstructured data.
  - Functions: `ISJSON`, `JSON_VALUE`, `JSON_QUERY`, `JSON_MODIFY`, `OPENJSON`, `FOR JSON`.

### Example: Working with JSON Data
Convert JSON data to a tabular format using `OPENJSON`.

**SQL Query:**
```sql
DECLARE @json NVARCHAR(MAX);
SET @json = N'[
    {"Order": {"Number": "S043659", "Date": "2011-05-31T00:00:00"}, "AccountNumber": "AW29825", "Item": {"Price": 2024.9940, "Quantity": 1}},
    {"Order": {"Number": "S043661", "Date": "2011-06-01T00:00:00"}, "AccountNumber": "AW73565", "Item": {"Price": 2024.9940, "Quantity": 3}}
]';
SELECT *
FROM OPENJSON(@json)
WITH (
    OrderNumber NVARCHAR(50) '$.Order.Number',
    OrderDate DATETIME2 '$.Order.Date',
    AccountNumber NVARCHAR(50) '$.AccountNumber',
    Price FLOAT '$.Item.Price',
    Quantity INT '$.Item.Quantity'
);
```

**Result:**
| OrderNumber | OrderDate           | AccountNumber | Price    | Quantity |
|-------------|---------------------|---------------|----------|----------|
| S043659     | 2011-05-31 00:00:00 | AW29825       | 2024.9940| 1        |
| S043661     | 2011-06-01 00:00:00 | AW73565       | 2024.9940| 3        |

### Classwork
1. Declare a JSON variable with 2 employee records (e.g., name, skills array).
2. Use `OPENJSON` to convert the JSON to a table with columns: `Name`, `Skill`.
3. Use `FOR JSON PATH` to format a `SELECT` query result from the `Students` table as JSON.

### Test
1. Which function extracts a scalar value from a JSON string?
   - A) JSON_QUERY
   - B) JSON_VALUE
   - C) ISJSON
   - D) JSON_MODIFY
2. Big Data Clusters include:
   - A) SQL Server
   - B) Spark
   - C) HDFS
   - D) All of these
3. Name two uses of SQL Server Big Data Clusters.

**Answers:**
1. B
2. D
3. (e.g., Query external data sources, Store big data in HDFS)

---

## Session 17: PolyBase, Query Store, and Stretch Database

### Overview
This session explores advanced SQL Server features: PolyBase for external data queries, Query Store for performance analysis, and Stretch Database for cloud migration.

### Key Concepts
- **PolyBase**:
  - Queries external data (Hadoop, Azure Blob Storage, Oracle, etc.) using T-SQL.
  - Scenarios: Import/export data, integrate with BI tools.
- **Query Store**:
  - Captures query plans and runtime stats for performance troubleshooting.
  - Enable with `ALTER DATABASE SET QUERY_STORE = ON`.
- **Stretch Database**:
  - Migrates data to Azure for cost-effective storage.
  - Query cloud data transparently.

### Example: Configuring an External Table with PolyBase
Set up an external table to query car sensor data in Hadoop.

**SQL Query:**
```sql
-- Create master key
CREATE MASTER KEY ENCRYPTION BY PASSWORD = 'Password123!';

-- Create database scoped credential
CREATE DATABASE SCOPED CREDENTIAL HadoopUser1
WITH IDENTITY = 'hadoop_user', SECRET = 'hadoop_password';

-- Create external data source
CREATE EXTERNAL DATA SOURCE MyHadoopCluster WITH (
    TYPE = HADOOP,
    LOCATION = 'hdfs://10.xxx.xx.xxx:xxxx',
    RESOURCE_MANAGER_LOCATION = '10.xxx.xx.xxx:xxxx',
    CREDENTIAL = HadoopUser1
);

-- Create external file format
CREATE EXTERNAL FILE FORMAT TextFileFormat WITH (
    FORMAT_TYPE = DELIMITEDTEXT,
    FORMAT_OPTIONS (FIELD_TERMINATOR = '|', USE_TYPE_DEFAULT = TRUE)
);

-- Create external table
CREATE EXTERNAL TABLE [dbo].[CarSensor_Data] (
    SensorKey INT NOT NULL,
    CustomerKey INT NOT NULL,
    GeographyKey INT NULL,
    Speed FLOAT NOT NULL,
    YearMeasured INT NOT NULL
)
WITH (
    LOCATION = '/Demo/',
    DATA_SOURCE = MyHadoopCluster,
    FILE_FORMAT = TextFileFormat
);
```

### Classwork
1. Enable Query Store on a database named `SchoolDB` using T-SQL.
2. Create a sample table `Orders` and enable Stretch Database for it.
3. Write a query to select all records from the `CarSensor_Data` external table.

### Test
1. Which feature integrates SQL Server with Hadoop?
   - A) Stretch Database
   - B) Query Store
   - C) PolyBase
   - D) Big Data Clusters
2. Stretch Database requires enabling on:
   - A) Server instance
   - B) Database
   - C) Table
   - D) All of these
3. Name two limitations of Stretch Database.

**Answers:**
1. C
2. D
3. (e.g., No UPDATE/DELETE on migrated rows, No support for FILESTREAM)