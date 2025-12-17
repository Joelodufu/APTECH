## Data Query Language (DQL)
Features for retrieving data from databases.

Features: SELECT, DISTINCT, FROM, WHERE, ORDER BY, GROUP BY, HAVING, JOIN (INNER, LEFT, RIGHT, FULL), LIMIT/OFFSET

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| SELECT | Retrieves specific columns from a table. | `SELECT name, price FROM products;` | Fetching product details for a report. |
| DISTINCT | Removes duplicate rows from results. | `SELECT DISTINCT category FROM products;` | Listing unique product categories. |
| FROM | Specifies the table to query. | `SELECT * FROM sales;` | Accessing data from a specific table. |
| WHERE | Filters rows based on conditions. | `SELECT * FROM sales WHERE amount > 100;` | Filtering high-value sales. |
| ORDER BY | Sorts results by column(s). | `SELECT name FROM products ORDER BY price DESC;` | Sorting products by price for display. |
| GROUP BY | Groups rows for aggregate calculations. | `SELECT category, SUM(amount) FROM sales GROUP BY category;` | Summarizing sales by category. |
| HAVING | Filters grouped results. | `SELECT category, SUM(amount) FROM sales GROUP BY category HAVING SUM(amount) > 1000;` | Showing categories with high total sales. |
| JOIN (INNER) | Combines rows from two tables based on a condition. | `SELECT p.name, s.amount FROM products p INNER JOIN sales s ON p.id = s.product_id;` | Linking product names with sales data. |
| JOIN (LEFT) | Includes all rows from left table, matching rows from right. | `SELECT p.name, s.amount FROM products p LEFT JOIN sales s ON p.id = s.product_id;` | Including all products, even unsold ones. |
| JOIN (RIGHT) | Includes all rows from right table, matching rows from left. | `SELECT p.name, s.amount FROM products p RIGHT JOIN sales s ON p.id = s.product_id;` | Including all sales, even for missing products. |
| JOIN (FULL) | Includes all rows from both tables, with NULLs for non-matches. | `SELECT p.name, s.amount FROM products p FULL JOIN sales s ON p.id = s.product_id;` | Comprehensive product-sales analysis. |
| LIMIT/OFFSET | Restricts number of rows returned, skips rows with OFFSET. | `SELECT * FROM products LIMIT 10 OFFSET 20;` | Paginating results in a web app. |

## Data Definition Language (DDL)
Features for defining and modifying database structures.

Features: CREATE TABLE, ALTER TABLE, DROP TABLE, ADD COLUMN, DROP COLUMN, CREATE INDEX, DROP INDEX

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| CREATE TABLE | Defines a new table with columns and constraints. | `CREATE TABLE products (id INT PRIMARY KEY, name VARCHAR(50));` | Setting up a table for product data. |
| ALTER TABLE | Modifies an existing table structure. | `ALTER TABLE products ADD price DECIMAL(10,2);` | Adding a new column to store prices. |
| DROP TABLE | Deletes a table and its data. | `DROP TABLE products;` | Removing obsolete tables. |
| ADD COLUMN | Adds a new column to a table. | `ALTER TABLE products ADD category VARCHAR(30);` | Extending tables with new attributes. |
| DROP COLUMN | Removes a column from a table. | `ALTER TABLE products DROP COLUMN category;` | Cleaning up unused columns. |
| CREATE INDEX | Creates an index to improve query performance. | `CREATE INDEX idx_name ON products(name);` | Speeding up searches by product name. |
| DROP INDEX | Removes an index. | `DROP INDEX idx_name ON products;` | Removing outdated indexes to save space. |

## Data Manipulation Language (DML)
Features for inserting, updating, and deleting data.

Features: INSERT, UPDATE, DELETE, TRUNCATE

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| INSERT | Adds new rows to a table. | `INSERT INTO products (id, name, price) VALUES (1, 'Laptop', 999.99);` | Adding new products to inventory. |
| UPDATE | Modifies existing rows. | `UPDATE products SET price = 1099.99 WHERE id = 1;` | Updating product prices. |
| DELETE | Removes rows based on conditions. | `DELETE FROM products WHERE price < 10;` | Removing discontinued products. |
| TRUNCATE | Removes all rows from a table, keeping structure. | `TRUNCATE TABLE products;` | Clearing test data while retaining table schema. |

## Data Control Language (DCL)
Features for managing access and permissions.

Features: GRANT, REVOKE

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| GRANT | Assigns permissions to users/roles. | `GRANT SELECT, INSERT ON products TO user1;` | Allowing users to query or add data. |
| REVOKE | Removes permissions from users/roles. | `REVOKE INSERT ON products FROM user1;` | Restricting user access for security. |

## Transaction Control
Features for managing database transactions.

Features: COMMIT, ROLLBACK, SAVEPOINT

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| COMMIT | Saves all changes in a transaction. | `COMMIT;` | Finalizing a batch of data updates. |
| ROLLBACK | Undoes changes in a transaction. | `ROLLBACK;` | Reverting failed updates to maintain consistency. |
| SAVEPOINT | Sets a point to roll back to within a transaction. | `SAVEPOINT save1;` | Partial rollback for complex operations. |

## Aggregate Functions
Functions that compute summary values over a dataset.

Features: COUNT, SUM, AVG, MIN, MAX

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| COUNT | Counts rows or non-null values. | `SELECT COUNT(*) FROM sales;` | Total number of sales records. |
| SUM | Adds values in a column. | `SELECT SUM(amount) FROM sales;` | Calculating total sales revenue. |
| AVG | Computes average of a column. | `SELECT AVG(price) FROM products;` | Average product price in inventory. |
| MIN | Finds smallest value in a column. | `SELECT MIN(price) FROM products;` | Identifying lowest-priced product. |
| MAX | Finds largest value in a column. | `SELECT MAX(price) FROM products;` | Identifying highest-priced product. |

## String Functions
Functions for manipulating text data.

Features: CONCAT, UPPER, LOWER, SUBSTRING, LENGTH, TRIM, REPLACE

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| CONCAT | Combines multiple strings. | `SELECT CONCAT(first_name, ' ', last_name) FROM users;` | Creating full names for display. |
| UPPER | Converts string to uppercase. | `SELECT UPPER(name) FROM products;` | Standardizing product names. |
| LOWER | Converts string to lowercase. | `SELECT LOWER(name) FROM products;` | Normalizing text for comparisons. |
| SUBSTRING | Extracts part of a string. | `SELECT SUBSTRING(code FROM 1 FOR 3) FROM products;` | Extracting product code prefixes. |
| LENGTH | Returns string length. | `SELECT LENGTH(name) FROM products;` | Validating name lengths. |
| TRIM | Removes leading/trailing spaces. | `SELECT TRIM(name) FROM products;` | Cleaning user-entered data. |
| REPLACE | Replaces part of a string. | `SELECT REPLACE(name, 'Old', 'New') FROM products;` | Updating product names in bulk. |

## Date and Time Functions
Functions for handling date and time data.

Features: NOW, CURRENT_DATE, EXTRACT, DATEADD, DATEDIFF (Note: Some vary by database, e.g., DATEADD/DATEDIFF in SQL Server, INTERVAL in PostgreSQL)

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| NOW | Returns current date and time. | `SELECT NOW();` | Timestamping records. |
| CURRENT_DATE | Returns current date. | `SELECT CURRENT_DATE;` | Filtering today’s sales. |
| EXTRACT | Extracts part of a date (year, month, etc.). | `SELECT EXTRACT(YEAR FROM sale_date) FROM sales;` | Grouping sales by year. |
| DATEADD | Adds interval to a date (SQL Server). | `SELECT DATEADD(day, 7, sale_date) FROM sales;` | Calculating due dates. |
| DATEDIFF | Calculates difference between dates (SQL Server). | `SELECT DATEDIFF(day, start_date, end_date) FROM orders;` | Measuring order processing time. |

## Conditional Functions
Functions for logic-based operations.

Features: CASE, COALESCE, NULLIF

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| CASE | Conditional logic for values. | `SELECT CASE WHEN price > 100 THEN 'High' ELSE 'Low' END FROM products;` | Categorizing products by price. |
| COALESCE | Returns first non-null value. | `SELECT COALESCE(discount, 0) FROM sales;` | Defaulting missing discounts to 0. |
| NULLIF | Returns NULL if two values are equal. | `SELECT NULLIF(stock, 0) FROM products;` | Marking zero stock as NULL for reports. |

## Window Functions
Functions for calculations across a set of rows related to the current row.

Features: ROW_NUMBER, RANK, DENSE_RANK, SUM (OVER), AVG (OVER)

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| ROW_NUMBER | Assigns unique number to each row in partition. | `SELECT ROW_NUMBER() OVER (PARTITION BY category ORDER BY price) FROM products;` | Numbering products within categories. |
| RANK | Assigns rank with gaps for ties. | `SELECT RANK() OVER (ORDER BY amount DESC) FROM sales;` | Ranking sales by amount. |
| DENSE_RANK | Assigns rank without gaps for ties. | `SELECT DENSE_RANK() OVER (ORDER BY amount DESC) FROM sales;` | Dense ranking for leaderboard displays. |
| SUM (OVER) | Computes running or partitioned sum. | `SELECT SUM(amount) OVER (PARTITION BY category) FROM sales;` | Category-wise total sales. |
| AVG (OVER) | Computes running or partitioned average. | `SELECT AVG(price) OVER (PARTITION BY category) FROM products;` | Average price per category. |