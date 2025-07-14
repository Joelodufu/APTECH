# Session 4: Building Data Models

## Objectives
- Explain the concept of data modeling and its importance in Power BI.
- Demonstrate normalization techniques to structure data efficiently.
- Illustrate the creation of star schema data models using the AdventureWorks 2022 database.
- Build relationships between tables to enable integrated analysis.
- Apply data modeling principles to a custom dataset for practical understanding.

## Definition of Terms
- **Data Modeling**: The process of structuring and organizing data tables to optimize analysis and reporting in Power BI.
- **Normalization**: A technique to eliminate data redundancy and ensure data integrity by organizing data into related tables with minimal duplication.
- **Star Schema**: A data modeling approach with a central fact table (containing transactional data) connected to dimension tables (containing descriptive data) via relationships.
- **Fact Table**: A table in a star schema that stores quantitative data (e.g., sales amounts, quantities) linked to dimension tables.
- **Dimension Table**: A table in a star schema that stores descriptive attributes (e.g., product names, customer details) related to the fact table.
- **Relationships**: Connections between tables based on common columns (e.g., keys) to enable integrated queries and visualizations.
- **Primary Key**: A unique identifier for each row in a table (e.g., ProductID in a Product table).
- **Foreign Key**: A column in one table that references the primary key of another table to establish a relationship.

## Sample Dataset
Below is a custom dataset designed to demonstrate data modeling concepts, including normalization and star schema design, complementing the AdventureWorks 2022 database.

### RawSalesData Table (Pre-Normalization)
This table simulates unnormalized sales data with redundant information.

| OrderID | CustomerName | CustomerCity | ProductName | ProductCategory | SaleDate   | Quantity | Price |
|---------|--------------|--------------|-------------|-----------------|------------|----------|-------|
| O001    | John Smith   | New York     | Laptop      | Electronics     | 2023-07-01 | 2        | 1200.00 |
| O002    | John Smith   | New York     | Mouse       | Accessories     | 2023-07-02 | 5        | 25.00   |
| O003    | Mary Jones   | London       | Keyboard    | Accessories     | 2023-07-03 | 3        | 45.00   |
| O004    | Mary Jones   | London       | Laptop      | Electronics     | 2023-07-04 | 1        | 1200.00 |

**Issues**: Redundant data (e.g., repeated CustomerName and CustomerCity), which normalization will address.

### Normalized Tables (Post-Normalization)
To demonstrate normalization, the `RawSalesData` table is split into a star schema with fact and dimension tables.

#### FactSales Table
| OrderID | CustomerID | ProductID | SaleDate   | Quantity | Price  |
|---------|------------|-----------|------------|----------|--------|
| O001    | C1         | P1        | 2023-07-01 | 2        | 1200.00 |
| O002    | C1         | P2        | 2023-07-02 | 5        | 25.00   |
| O003    | C2         | P3        | 2023-07-03 | 3        | 45.00   |
| O004    | C2         | P1        | 2023-07-04 | 1        | 1200.00 |

#### DimCustomer Table
| CustomerID | CustomerName | CustomerCity |
|------------|--------------|--------------|
| C1         | John Smith   | New York     |
| C2         | Mary Jones   | London       |

#### DimProduct Table
| ProductID | ProductName | ProductCategory |
|-----------|-------------|-----------------|
| P1        | Laptop      | Electronics     |
| P2        | Mouse       | Accessories     |
| P3        | Keyboard    | Accessories     |

### Instructions to Use the Dataset
1. Save the `FactSales`, `DimCustomer`, and `DimProduct` tables as CSV files (e.g., `FactSales.csv`, `DimCustomer.csv`, `DimProduct.csv`).
2. Import them into Power BI using "Get Data" > "Text/CSV" for the exercises below.

## Explanations

### What is Data Modeling?
Data modeling in Power BI involves structuring data tables to optimize performance, reduce redundancy, and enable efficient analysis. It defines how tables are related and organized to support interactive visualizations and calculations. A well-designed data model, such as a star schema, ensures scalability and simplifies queries for datasets like AdventureWorks 2022.

### Normalization
Normalization organizes data into multiple related tables to eliminate redundancy and maintain data integrity. It follows rules like:
- **First Normal Form (1NF)**: Ensure no repeating groups; each column contains atomic values.
- **Second Normal Form (2NF)**: Remove partial dependencies; non-key attributes depend on the entire primary key.
- **Third Normal Form (3NF)**: Eliminate transitive dependencies; non-key attributes depend only on the primary key.
For example, splitting `RawSalesData` into `FactSales`, `DimCustomer`, and `DimProduct` reduces redundancy (e.g., repeated customer names).

### Star Schema Design
A star schema consists of:
- **Fact Table**: Contains measurable data (e.g., sales quantities, prices) with foreign keys linking to dimension tables.
- **Dimension Tables**: Store descriptive data (e.g., customer or product details) with primary keys.
In AdventureWorks 2022, Sales.SalesOrderDetail (fact table) connects to Production.Product and Sales.SalesOrderHeader (dimension tables) via keys like ProductID and SalesOrderID.

### Building Relationships
Relationships link tables using primary and foreign keys in Power BI’s Model View. Types include:
- **One-to-Many**: Common in star schemas (e.g., one ProductID in Production.Product links to many rows in Sales.SalesOrderDetail).
- **Many-to-One**: The reverse of one-to-many (e.g., many sales orders link to one customer).
- **One-to-One**: Rare, used for unique mappings (e.g., one employee to one personnel record).
Relationships enable integrated analysis across tables, such as calculating total sales by product category.

## Examples

### Example 1: Normalizing RawSalesData
1. Import `RawSalesData.csv` into Power Query Editor.
2. Create `DimCustomer` by selecting CustomerName and CustomerCity, removing duplicates, and adding CustomerID (e.g., C1, C2).
3. Create `DimProduct` by selecting ProductName and ProductCategory, removing duplicates, and adding ProductID (e.g., P1, P2).
4. Create `FactSales` by merging with `DimCustomer` and `DimProduct` to replace names with IDs, keeping OrderID, CustomerID, ProductID, SaleDate, Quantity, and Price.
5. Load the normalized tables into Power BI and create relationships.

### Example 2: Building a Star Schema with AdventureWorks 2022
1. Import Sales.SalesOrderDetail (fact table), Production.Product, and Sales.SalesOrderHeader (dimension tables) from AdventureWorks 2022.
2. In Model View, create a one-to-many relationship from Production.Product (ProductID) to Sales.SalesOrderDetail (ProductID).
3. Create a one-to-many relationship from Sales.SalesOrderHeader (SalesOrderID) to Sales.SalesOrderDetail (SalesOrderID).
4. Verify relationships in Model View to ensure a star schema.

### Example 3: Creating Relationships with Custom Dataset
1. Import `FactSales.csv`, `DimCustomer.csv`, and `DimProduct.csv` into Power BI.
2. In Model View, create a one-to-many relationship from DimCustomer (CustomerID) to FactSales (CustomerID).
3. Create a one-to-many relationship from DimProduct (ProductID) to FactSales (ProductID).
4. Create a table visual showing CustomerName, ProductName, and Quantity to test the relationships.

## Classwork
1. **Task 1: Normalize RawSalesData**
   - Import `RawSalesData.csv` into Power Query Editor.
   - Create `DimCustomer` and `DimProduct` tables by removing duplicates and adding IDs.
   - Create `FactSales` with foreign keys and load all tables into Power BI.
2. **Task 2: Build Star Schema with AdventureWorks**
   - Import Sales.SalesOrderDetail, Production.Product, and Person.Person from AdventureWorks 2022.
   - Create one-to-many relationships using ProductID and BusinessEntityID.
   - Create a table visual showing ProductName and LineTotal.
3. **Task 3: Create Relationships with Custom Dataset**
   - Import `FactSales.csv`, `DimCustomer.csv`, and `DimProduct.csv`.
   - In Model View, create relationships between FactSales and the dimension tables.
   - Create a bar chart showing total Price by ProductCategory.
4. **Task 4: Data Profiling for Relationships**
   - Import Sales.SalesOrderHeader from AdventureWorks 2022.
   - Use Column Profile to check the uniqueness of SalesOrderID and CustomerID.
   - Document findings to confirm suitability for relationships.

## Scenarios
1. **Scenario 1: Retail Data Modeling**
   - A retail company uses `RawSalesData.csv` with redundant data. Normalize the dataset into fact and dimension tables, create relationships in Model View, and build a table visual showing CustomerName, ProductName, and Price. Document the normalization steps and verify relationships.
2. **Scenario 2: AdventureWorks Sales Analysis**
   - A manager needs to analyze sales by product and customer using AdventureWorks 2022. Import Sales.SalesOrderDetail, Production.Product, and Sales.Customer. Build a star schema with relationships on ProductID and CustomerID. Create a bar chart showing total LineTotal by ProductName and describe the data model.
3. **Scenario 3: Custom Dataset Analysis**
   - The company wants to analyze sales by city using `FactSales.csv`, `DimCustomer.csv`, and `DimProduct.csv`. Create relationships, then build a table visual showing CustomerCity, ProductCategory, and total Quantity. Document the steps and insights.

## Class Test
1. What is the primary goal of data modeling in Power BI?  
   A) Creating visualizations  
   B) Optimizing data structure for analysis  
   C) Importing data from sources  
   D) Sharing reports online  
   **Answer**: B

2. Which table in a star schema contains quantitative data?  
   A) Dimension Table  
   B) Fact Table  
   C) Lookup Table  
   D) Bridge Table  
   **Answer**: B

3. What does normalization aim to reduce?  
   A) Data accuracy  
   B) Data redundancy  
   C) Data relationships  
   D) Data types  
   **Answer**: B

4. Which relationship type is most common in a star schema?  
   A) One-to-One  
   B) One-to-Many  
   C) Many-to-Many  
   D) No Relationship  
   **Answer**: B

5. **Practical Task**:  
   - Import `FactSales.csv`, `DimCustomer.csv`, and `DimProduct.csv` into Power BI.  
   - Create one-to-many relationships from DimCustomer (CustomerID) and DimProduct (ProductID) to FactSales.  
   - Create a table visual showing CustomerName, ProductName, and Quantity.  
   - Submit a screenshot of the visual and list the steps taken to create the relationships.