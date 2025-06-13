# Assessment for Session 3 (SQL–TL3): Transact-SQL

## Module
Data Management with SQL Server  
**Session Title**: SQL–TL3  
**Source**: SQL Server–The Definitive Guide, Session 4  
**Duration**: Recommended 90–120 minutes  
**Objective**: To evaluate students’ understanding of Transact-SQL (T-SQL), with a focus on DDL (`CREATE`, `ALTER`, `DROP`), DML (`SELECT`, `INSERT`, `UPDATE`, `DELETE`), data types, language elements, sets, predicate logic, and the logical order of SELECT statements, using the AdventureWorks 2022 database.  
**Instructions**:  
- Answer all 100 objective questions (multiple-choice or true/false).  
- Questions marked with **[Compulsory]** are mandatory and must be answered correctly to demonstrate mastery of critical concepts.  
- Use SQL Server Management Studio (SSMS) and the AdventureWorks 2022 database to verify answers where applicable.  
- Each question carries 1 point, with a total of 100 points.

---

## Section 1: General Transact-SQL (10 Questions)
1. **What is Transact-SQL (T-SQL)?**  
   a) A graphical interface for SQL Server  
   b) Microsoft’s proprietary extension to SQL  
   c) A database backup tool  
   d) A programming language for web applications  
   **Answer**: b) Microsoft’s proprietary extension to SQL  

2. **Which of the following is a key feature of T-SQL?**  
   a) Hardware configuration  
   b) Procedural programming  
   c) File system management  
   d) Network protocol setup  
   **Answer**: b) Procedural programming  

3. **True or False: T-SQL supports Data Definition Language (DDL), Data Manipulation Language (DML), and Data Control Language (DCL).**  
   **Answer**: True  

4. **Which tool is primarily used to execute T-SQL queries in SQL Server 2022?**  
   a) Visual Studio Code  
   b) SQL Server Management Studio (SSMS)  
   c) Microsoft Access  
   d) Azure Portal  
   **Answer**: b) SQL Server Management Studio (SSMS)  

5. **What is the purpose of T-SQL in SQL Server?**  
   a) To manage server hardware  
   b) To interact with and manage databases  
   c) To design user interfaces  
   d) To configure network settings  
   **Answer**: b) To interact with and manage databases  

6. **True or False: T-SQL can only be executed through SSMS.**  
   **Answer**: False  

7. **Which of the following is NOT a category of T-SQL statements?**  
   a) Data Definition Language (DDL)  
   b) Data Manipulation Language (DML)  
   c) Data Control Language (DCL)  
   d) Data Visualization Language (DVL)  
   **Answer**: d) Data Visualization Language (DVL)  

8. **What does the `GO` keyword signify in a T-SQL script?**  
   a) Starts a transaction  
   b) Separates batches of statements  
   c) Grants permissions  
   d) Executes a stored procedure  
   **Answer**: b) Separates batches of statements  

9. **Which component of T-SQL allows for procedural programming?**  
   a) Variables and control-of-flow statements  
   b) Indexes  
   c) Constraints  
   d) Execution plans  
   **Answer**: a) Variables and control-of-flow statements  

10. **True or False: T-SQL is used exclusively for querying data and cannot define database structures.**  
    **Answer**: False  

---

## Section 2: Data Definition Language (DDL) – CREATE, ALTER, DROP (30 Questions)
### General DDL Questions
11. **Which T-SQL statement category is used to define or modify database structures?**  
    a) DML  
    b) DCL  
    c) DDL  
    d) TCL  
    **Answer**: c) DDL  

12. **True or False: DDL statements include `CREATE`, `ALTER`, and `DROP`.**  
    **Answer**: True  

13. **What is a common use of DDL statements?**  
    a) Querying data  
    b) Defining tables and schemas  
    c) Managing user permissions  
    d) Updating records  
    **Answer**: b) Defining tables and schemas  

14. **Which DDL statement is used to delete a database object?**  
    a) CREATE  
    b) ALTER  
    c) DROP  
    d) SELECT  
    **Answer**: c) DROP  

15. **True or False: DDL statements are automatically committed and cannot be rolled back.**  
    **Answer**: True  

### CREATE Questions
16. **[Compulsory] What does the `CREATE TABLE` statement do?**  
    a) Modifies an existing table  
    b) Deletes a table  
    c) Creates a new table with specified columns and constraints  
    d) Retrieves data from a table  
    **Answer**: c) Creates a new table with specified columns and constraints  

17. **Which constraint ensures unique values in a column?**  
    a) NOT NULL  
    b) PRIMARY KEY  
    c) CHECK  
    d) DEFAULT  
    **Answer**: b) PRIMARY KEY  

18. **What is the purpose of the `FOREIGN KEY` constraint in a `CREATE TABLE` statement?**  
    a) Ensures unique values  
    b) Links to another table’s primary key  
    c) Sets a default value  
    d) Limits values to a range  
    **Answer**: b) Links to another table’s primary key  

19. **Which T-SQL statement creates a table named `OrderHistory` in AdventureWorks 2022?**  
    a) CREATE TABLE OrderHistory (OrderID INT PRIMARY KEY, OrderDate DATE);  
    b) ALTER TABLE OrderHistory ADD OrderID INT;  
    c) DROP TABLE OrderHistory;  
    d) SELECT * FROM OrderHistory;  
    **Answer**: a) CREATE TABLE OrderHistory (OrderID INT PRIMARY KEY, OrderDate DATE);  

20. **True or False: A `CREATE TABLE` statement requires at least one column to be defined.**  
    **Answer**: True  

21. **What happens if you attempt to create a table that already exists?**  
    a) The table is overwritten  
    b) An error occurs  
    c) The statement is ignored  
    d) The table is renamed  
    **Answer**: b) An error occurs  

22. **Which clause in a `CREATE TABLE` statement enforces a condition on a column’s values?**  
    a) PRIMARY KEY  
    b) FOREIGN KEY  
    c) CHECK  
    d) NOT NULL  
    **Answer**: c) CHECK  

### ALTER Questions
23. **[Compulsory] What does the `ALTER TABLE` statement do?**  
    a) Deletes a table  
    b) Modifies a table’s structure  
    c) Inserts data into a table  
    d) Grants permissions  
    **Answer**: b) Modifies a table’s structure  

24. **Which T-SQL statement adds a new column to an existing table?**  
    a) ALTER TABLE ... DROP COLUMN  
    b) ALTER TABLE ... ADD  
    c) CREATE TABLE ... ADD  
    d) DROP TABLE ... ADD  
    **Answer**: b) ALTER TABLE ... ADD  

25. **What does the following T-SQL statement do?**  
    ```sql
    ALTER TABLE CustomerFeedback ADD Status NVARCHAR(20) DEFAULT 'Pending';
    ```  
    a) Deletes the Status column  
    b) Adds a Status column with a default value  
    c) Changes the data type of Status  
    d) Retrieves data from Status  
    **Answer**: b) Adds a Status column with a default value  

26. **True or False: You can use `ALTER TABLE` to change a column’s data type.**  
    **Answer**: True  

27. **What is a risk of using `ALTER TABLE` to drop a column?**  
    a) It creates a new column  
    b) It deletes data in that column permanently  
    c) It changes the column’s data type  
    d) It adds a constraint  
    **Answer**: b) It deletes data in that column permanently  

28. **Which T-SQL statement changes the data type of a column named `Comments` to `NVARCHAR(1000)`?**  
    a) ALTER TABLE CustomerFeedback ALTER COLUMN Comments NVARCHAR(1000);  
    b) CREATE TABLE CustomerFeedback (Comments NVARCHAR(1000));  
    c) DROP TABLE CustomerFeedback;  
    d) SELECT Comments FROM CustomerFeedback;  
    **Answer**: a) ALTER TABLE CustomerFeedback ALTER COLUMN Comments NVARCHAR(1000);  

29. **True or False: `ALTER TABLE` can be used to add a `FOREIGN KEY` constraint.**  
    **Answer**: True  

30. **What precaution should be taken before altering a table’s structure?**  
    a) Grant permissions  
    b) Backup the database  
    c) Delete all data  
    d) Create a new table  
    **Answer**: b) Backup the database  

### DROP Questions
31. **[Compulsory] What does the `DROP TABLE` statement do?**  
    a) Creates a new table  
    b) Deletes a table and its data  
    c) Modifies a table’s structure  
    d) Retrieves data from a table  
    **Answer**: b) Deletes a table and its data  

32. **Which clause prevents errors when dropping a non-existent table?**  
    a) IF EXISTS  
    b) WHERE EXISTS  
    c) ON DELETE  
    d) CHECK  
    **Answer**: a) IF EXISTS  

33. **What happens if you execute `DROP TABLE CustomerFeedback` and the table has a foreign key reference?**  
    a) The table is dropped automatically  
    b) An error occurs due to dependencies  
    c) The table is renamed  
    d) The foreign key is ignored  
    **Answer**: b) An error occurs due to dependencies  

34. **True or False: The `DROP TABLE` statement can be rolled back if executed within a transaction.**  
    **Answer**: True  

35. **What is the purpose of the following T-SQL statement?**  
    ```sql
    DROP TABLE IF EXISTS SalesLog;
    ```  
    a) Creates a SalesLog table  
    b) Deletes the SalesLog table if it exists  
    c) Modifies the SalesLog table  
    d) Retrieves data from SalesLog  
    **Answer**: b) Deletes the SalesLog table if it exists  

---

## Section 3: Data Manipulation Language (DML) – SELECT, INSERT, UPDATE, DELETE (30 Questions)
### General DML Questions
36. **Which T-SQL statement category is used to manipulate data within tables?**  
    a) DDL  
    b) DML  
    c) DCL  
    d) TCL  
    **Answer**: b) DML  

37. **True or False: DML statements include `SELECT`, `INSERT`, `UPDATE`, and `DELETE`.**  
    **Answer**: True  

38. **What is a key characteristic of DML statements?**  
    a) They define database structures  
    b) They operate on sets of data  
    c) They manage user permissions  
    d) They configure server settings  
    **Answer**: b) They operate on sets of data  

39. **Which DML statement is used to retrieve data from a table?**  
    a) INSERT  
    b) UPDATE  
    c) SELECT  
    d) DROP  
    **Answer**: c) SELECT  

40. **True or False: DML statements can be rolled back if executed within a transaction.**  
    **Answer**: True  

### SELECT Questions
41. **[Compulsory] What does the `SELECT` statement do in T-SQL?**  
    a) Adds new rows to a table  
    b) Retrieves data from a table  
    c) Deletes rows from a table  
    d) Modifies table structure  
    **Answer**: b) Retrieves data from a table  

42. **What does the following T-SQL query do in AdventureWorks 2022?**  
    ```sql
    SELECT TOP 5 ProductID, Name FROM Production.Product WHERE ListPrice > 500 ORDER BY ListPrice DESC;
    ```  
    a) Inserts 5 products  
    b) Retrieves 5 products sorted by price  
    c) Deletes 5 products  
    d) Updates 5 products  
    **Answer**: b) Retrieves 5 products sorted by price  

43. **Which clause in a `SELECT` statement sorts the result set?**  
    a) WHERE  
    b) ORDER BY  
    c) GROUP BY  
    d) HAVING  
    **Answer**: b) ORDER BY  

44. **True or False: The `TOP` clause limits the number of rows returned by a `SELECT` statement.**  
    **Answer**: True  

45. **What is the purpose of the `WHERE` clause in a `SELECT` statement?**  
    a) Groups rows  
    b) Filters rows based on conditions  
    c) Sorts rows  
    d) Defines columns  
    **Answer**: b) Filters rows based on conditions  

### INSERT Questions
46. **[Compulsory] What does the `INSERT` statement do in T-SQL?**  
    a) Retrieves data from a table  
    b) Adds new rows to a table  
    c) Modifies existing rows  
    d) Deletes rows from a table  
    **Answer**: b) Adds new rows to a table  

47. **What does the following T-SQL statement do?**  
    ```sql
    INSERT INTO CustomerFeedback (FeedbackID, CustomerID, FeedbackDate, Comments) VALUES (1, 11001, '2025-05-26', 'Great service!');
    ```  
    a) Retrieves a feedback record  
    b) Adds a new feedback record  
    c) Updates a feedback record  
    d) Deletes a feedback record  
    **Answer**: b) Adds a new feedback record  

48. **True or False: The `INSERT` statement requires values for all columns unless they have defaults or allow NULL.**  
    **Answer**: True  

49. **Which T-SQL statement inserts multiple rows into a table?**  
    a) INSERT INTO TableName VALUES (1, 'Value1'), (2, 'Value2');  
    b) SELECT * FROM TableName;  
    c) UPDATE TableName SET Column = 'Value';  
    d) DROP TABLE TableName;  
    **Answer**: a) INSERT INTO TableName VALUES (1, 'Value1'), (2, 'Value2');  

50. **What happens if an `INSERT` statement violates a `FOREIGN KEY` constraint?**  
    a) The statement is ignored  
    b) An error occurs  
    c) The foreign key is updated  
    d) The row is inserted without the foreign key  
    **Answer**: b) An error occurs  

### UPDATE Questions
51. **[Compulsory] What does the `UPDATE` statement do in T-SQL?**  
    a) Adds new rows to a table  
    b) Modifies existing rows in a table  
    c) Deletes rows from a table  
    d) Retrieves data from a table  
    **Answer**: b) Modifies existing rows in a table  

52. **What does the following T-SQL statement do?**  
    ```sql
    UPDATE CustomerFeedback SET Comments = 'Updated: Great service!' WHERE FeedbackID = 1;
    ```  
    a) Adds a new feedback record  
    b) Updates the Comments column for a specific record  
    c) Deletes a feedback record  
    d) Retrieves feedback records  
    **Answer**: b) Updates the Comments column for a specific record  

53. **What happens if an `UPDATE` statement is executed without a `WHERE` clause?**  
    a) Only one row is updated  
    b) All rows in the table are updated  
    c) The statement fails  
    d) No rows are updated  
    **Answer**: b) All rows in the table are updated  

54. **True or False: The `UPDATE` statement can modify multiple columns in a single statement.**  
    **Answer**: True  

55. **Which clause is essential to avoid updating all rows in a table?**  
    a) ORDER BY  
    b) WHERE  
    c) GROUP BY  
    d) HAVING  
    **Answer**: b) WHERE  

### DELETE Questions
56. **[Compulsory] What does the `DELETE` statement do in T-SQL?**  
    a) Retrieves data from a table  
    b) Adds new rows to a table  
    c) Removes rows from a table  
    d) Modifies table structure  
    **Answer**: c) Removes rows from a table  

57. **What does the following T-SQL statement do?**  
    ```sql
    DELETE FROM CustomerFeedback WHERE FeedbackDate < '2025-01-01';
    ```  
    a) Adds feedback records  
    b) Retrieves feedback records  
    c) Removes feedback records before 2025  
    d) Updates feedback records  
    **Answer**: c) Removes feedback records before 2025  

58. **True or False: Using a `WHERE` clause with `DELETE` is optional but recommended.**  
    **Answer**: True  

59. **What happens if a `DELETE` statement violates a `FOREIGN KEY` constraint?**  
    a) The statement is ignored  
    b) An error occurs  
    c) The foreign key is dropped  
    d) The row is deleted anyway  
    **Answer**: b) An error occurs  

60. **Which T-SQL statement deletes all rows from a table without dropping it?**  
    a) DROP TABLE TableName;  
    b) DELETE FROM TableName;  
    c) ALTER TABLE TableName DROP COLUMN;  
    d) TRUNCATE TABLE TableName;  
    **Answer**: b) DELETE FROM TableName;  

---

## Section 4: Data Types (15 Questions)
61. **Which T-SQL data type is best for storing whole numbers, such as IDs?**  
    a) NVARCHAR  
    b) INT  
    c) DECIMAL  
    d) DATE  
    **Answer**: b) INT  

62. **What is the difference between `VARCHAR` and `NVARCHAR`?**  
    a) `VARCHAR` supports Unicode; `NVARCHAR` does not  
    b) `NVARCHAR` supports Unicode; `VARCHAR` does not  
    c) `VARCHAR` is for dates; `NVARCHAR` is for numbers  
    d) Both are identical  
    **Answer**: b) `NVARCHAR` supports Unicode; `VARCHAR` does not  

63. **Which data type is used for precise decimal values, such as prices?**  
    a) FLOAT  
    b) DECIMAL  
    c) INT  
    d) VARCHAR  
    **Answer**: b) DECIMAL  

64. **True or False: The `DATE` data type stores both date and time information.**  
    **Answer**: False  

65. **Which data type is used for storing XML data in SQL Server?**  
    a) JSON  
    b) XML  
    c) NVARCHAR  
    d) BINARY  
    **Answer**: b) XML  

66. **What is the purpose of the `NOT NULL` constraint in a column definition?**  
    a) Ensures unique values  
    b) Requires a value for the column  
    c) Links to another table  
    d) Limits values to a range  
    **Answer**: b) Requires a value for the column  

67. **Which T-SQL data type is used in the `ListPrice` column of `Production.Product` in AdventureWorks 2022?**  
    a) INT  
    b) MONEY  
    c) DECIMAL  
    d) FLOAT  
    **Answer**: b) MONEY  

68. **True or False: The `DECIMAL(10,2)` data type can store values up to 10 digits with 2 decimal places.**  
    **Answer**: True  

69. **Which data type is best for storing a globally unique identifier (GUID)?**  
    a) UNIQUEIDENTIFIER  
    b) NVARCHAR  
    c) INT  
    d) BINARY  
    **Answer**: a) UNIQUEIDENTIFIER  

70. **What happens if you try to insert a string into an `INT` column?**  
    a) The string is automatically converted  
    b) An error occurs  
    c) The string is truncated  
    d) The insert is ignored  
    **Answer**: b) An error occurs  

71. **Which data type is suitable for storing a fixed-length string of 10 characters?**  
    a) CHAR(10)  
    b) VARCHAR(10)  
    c) NVARCHAR(10)  
    d) TEXT  
    **Answer**: a) CHAR(10)  

72. **True or False: The `DATETIME` data type is more precise than `DATE` for storing dates.**  
    **Answer**: True  

73. **Which data type would you use for a column storing product descriptions in multiple languages?**  
    a) VARCHAR  
    b) NVARCHAR  
    c) CHAR  
    d) BINARY  
    **Answer**: b) NVARCHAR  

74. **What is the maximum length of an `NVARCHAR` column without specifying a length?**  
    a) 255 characters  
    b) 4000 characters  
    c) 8000 characters  
    d) Unlimited  
    **Answer**: b) 4000 characters  

75. **Which data type is used for the `OrderDate` column in `Sales.SalesOrderHeader` in AdventureWorks 2022?**  
    a) DATE  
    b) DATETIME  
    c) TIME  
    d) NVARCHAR  
    **Answer**: b) DATETIME  

---

## Section 5: Language Elements, Sets, and Predicate Logic (15 Questions)
76. **Which T-SQL language element is used to store temporary data?**  
    a) Predicate  
    b) Variable  
    c) Expression  
    d) Comment  
    **Answer**: b) Variable  

77. **What does the following T-SQL code declare?**  
    ```sql
    DECLARE @MaxPrice DECIMAL(10,2) = 1000.00;
    ```  
    a) A table  
    b) A variable  
    c) A constraint  
    d) A predicate  
    **Answer**: b) A variable  

78. **True or False: The `--` symbol is used for single-line comments in T-SQL.**  
    **Answer**: True  

79. **Which T-SQL operator is used to combine conditions in a `WHERE` clause?**  
    a) +  
    b) AND  
    c) =  
    d) *  
    **Answer**: b) AND  

80. **What is a predicate in a T-SQL query?**  
    a) A calculation  
    b) A condition that evaluates to true/false  
    c) A variable declaration  
    d) A set operation  
    **Answer**: b) A condition that evaluates to true/false  

81. **Which T-SQL set operation combines rows from two queries, removing duplicates?**  
    a) INTERSECT  
    b) UNION  
    c) EXCEPT  
    d) JOIN  
    **Answer**: b) UNION  

82. **What does the following T-SQL query do in AdventureWorks 2022?**  
    ```sql
    SELECT ProductID, Name FROM Production.Product WHERE Color = 'Black' UNION SELECT ProductID, Name FROM Production.Product WHERE Color = 'Silver';
    ```  
    a) Retrieves black and silver products, removing duplicates  
    b) Retrieves only black products  
    c) Retrieves only silver products  
    d) Combines black and silver products with duplicates  
    **Answer**: a) Retrieves black and silver products, removing duplicates  

83. **True or False: The `INTERSECT` set operation returns only rows common to both queries.**  
    **Answer**: True  

84. **Which logical operator negates a condition in a T-SQL predicate?**  
    a) AND  
    b) OR  
    c) NOT  
    d) LIKE  
    **Answer**: c) NOT  

85. **What does the `LIKE` operator do in a T-SQL query?**  
    a) Performs exact matches  
    b) Performs pattern matching  
    c) Combines result sets  
    d) Groups rows  
    **Answer**: b) Performs pattern matching  

86. **Which T-SQL statement uses predicate logic to filter rows?**  
    a) CREATE TABLE  
    b) SELECT ... WHERE  
    c) ALTER TABLE  
    d) GRANT  
    **Answer**: b) SELECT ... WHERE  

87. **True or False: The `UNION ALL` operation includes duplicate rows, unlike `UNION`.**  
    **Answer**: True  

88. **What is an expression in T-SQL?**  
    a) A condition that evaluates to true/false  
    b) A combination of values, operators, and functions  
    c) A variable declaration  
    d) A table definition  
    **Answer**: b) A combination of values, operators, and functions  

89. **Which T-SQL statement uses a multi-line comment?**  
    a) -- Comment  
    b) /* Comment */  
    c) // Comment  
    d) # Comment  
    **Answer**: b) /* Comment */  

90. **What does the following T-SQL query do?**  
    ```sql
    SELECT ProductID, Name FROM Production.Product WHERE ListPrice > 500 AND Color = 'Red';
    ```  
    a) Retrieves products with ListPrice > 500 or Red color  
    b) Retrieves products with ListPrice > 500 and Red color  
    c) Updates products with ListPrice > 500  
    d) Deletes products with Red color  
    **Answer**: b) Retrieves products with ListPrice > 500 and Red color  

---

## Section 6: Logical Order of Operators in SELECT Statement (10 Questions)
91. **[Compulsory] What is the first step in the logical order of processing a T-SQL SELECT statement?**  
    a) SELECT  
    b) WHERE  
    c) FROM  
    d) ORDER BY  
    **Answer**: c) FROM  

92. **Which clause in a SELECT statement filters rows before grouping?**  
    a) HAVING  
    b) WHERE  
    c) ORDER BY  
    d) GROUP BY  
    **Answer**: b) WHERE  

93. **True or False: The `SELECT` clause is processed before the `FROM` clause in a T-SQL query.**  
    **Answer**: False  

94. **What is the purpose of the `GROUP BY` clause in a SELECT statement?**  
    a) Sorts the result set  
    b) Groups rows by specified columns  
    c) Filters individual rows  
    d) Defines output columns  
    **Answer**: b) Groups rows by specified columns  

95. **Which clause filters groups in a SELECT statement?**  
    a) WHERE  
    b) HAVING  
    c) ORDER BY  
    d) FROM  
    **Answer**: b) HAVING  

96. **[Compulsory] What is the final step in the logical order of a T-SQL SELECT statement?**  
    a) FROM  
    b) WHERE  
    c) SELECT  
    d) ORDER BY  
    **Answer**: d) ORDER BY  

97. **[Compulsory] What does the following T-SQL query do in AdventureWorks 2022?**  
    ```sql
    SELECT CustomerID, SUM(TotalDue) AS TotalSales FROM Sales.SalesOrderHeader WHERE OrderDate >= '2020-01-01' GROUP BY CustomerID HAVING SUM(TotalDue) > 5000 ORDER BY TotalSales DESC;
    ```  
    a) Retrieves customers with total sales > 5000, sorted by sales  
    b) Updates customer sales data  
    c) Deletes orders from 2020  
    d) Creates a new table  
    **Answer**: a) Retrieves customers with total sales > 5000, sorted by sales  

98. **True or False: The logical order of a SELECT statement differs from its written order.**  
    **Answer**: True  

99. **Which step in the logical order of a SELECT statement specifies the columns to return?**  
    a) FROM  
    b) WHERE  
    c) SELECT  
    d) GROUP BY  
    **Answer**: c) SELECT  

100. **What is the logical order of processing for a T-SQL SELECT statement?**  
     a) SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY  
     b) FROM, WHERE, GROUP BY, HAVING, SELECT, ORDER BY  
     c) WHERE, FROM, SELECT, GROUP BY, ORDER BY, HAVING  
     d) ORDER BY, SELECT, FROM, WHERE, GROUP BY, HAVING  
     **Answer**: b) FROM, WHERE, GROUP BY, HAVING, SELECT, ORDER BY  

---

## Implementation Notes
- **Purpose**: This assessment tests mastery of Session 3 concepts, with a focus on DDL and DML, ensuring students can apply T-SQL in practical scenarios using AdventureWorks 2022.
- **Compulsory Questions**: The 10 compulsory questions (Q16, Q23, Q31, Q41, Q46, Q51, Q56, Q91, Q96, Q97) cover critical DDL, DML, and SELECT statement concepts, ensuring foundational understanding.
- **Administration**: Use a learning management system, printed quiz, or OnlineVarsity’s Practice 4 Me feature. Allow students to verify answers in SSMS where applicable.
- **Scoring**: Each question is worth 1 point. A passing score (e.g., 40% as per the course evaluation strategy) requires at least 40 correct answers, with all compulsory questions correct.
- **Follow-Up**: Review answers in class, demonstrating key DDL/DML queries in SSMS. Provide feedback on compulsory questions to address gaps in understanding.
- **Resources**:
  - *SQL Server–The Definitive Guide* eBook (OnlineVarsity).
  - *Murach’s SQL Server 2022 for Developers* by Bryan Syverson.
  - *T-SQL Fundamentals, 4th Edition* by Itzik Ben-Gan.

Let me know if you need a different format (e.g., short-answer questions), additional questions, or assistance with other sessions!