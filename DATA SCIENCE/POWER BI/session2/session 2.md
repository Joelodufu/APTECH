# Session 2: Exploring Power Query

## Objectives
- Define Power Query and its role in Power BI.
- Demonstrate how to import data using Power Query with the AdventureWorks 2022 database.
- Explain data shaping and transformation techniques in Power Query.
- Outline how to use Power Query to meet analytical requirements.

## Definition of Terms
- **Power Query**: A data connection and transformation tool in Power BI and Excel that enables users to import, clean, and shape data from various sources.
- **Power Query Editor**: A graphical interface within Power BI for performing data transformations, such as filtering, renaming, and merging.
- **Applied Steps Pane**: A section in Power Query Editor that records and displays all transformation steps applied to a dataset.
- **M Language**: The query language used in Power Query for advanced and customized data transformations.
- **Data Source**: The origin of data (e.g., database, CSV file, web) that Power Query connects to for importing data.
- **DirectQuery**: A Power BI feature that queries data directly from the source without loading it into the data model.

## Explanations

### What is Power Query?
Power Query is a powerful Microsoft tool integrated into Power BI and Excel, designed to simplify data discovery, connection, and transformation. It allows users to import data from various sources, clean and reshape it, and prepare it for analysis. In Power BI, Power Query is accessed via the Power Query Editor, which provides a user-friendly interface for transforming data, with all actions recorded as repeatable steps.

### Power Query Capabilities
- **Data Connectivity**: Connects to diverse sources like SQL Server (e.g., AdventureWorks 2022), Excel, CSV, and web data.
- **Data Transformation**: Supports cleaning (e.g., removing duplicates), reshaping (e.g., pivoting), and formatting data.
- **Automation**: Records transformations as steps in the Applied Steps Pane, enabling reuse across datasets.
- **Advanced Transformations**: Uses M language for complex operations like conditional columns and custom calculations.
- **Scalability**: Handles large datasets efficiently, ensuring data is optimized for analysis.

### Power Query Interface
The Power Query Editor interface includes:
- **Query Pane**: Lists all queries (datasets) being processed.
- **Data Preview**: Displays a preview of the data for inspection and transformation.
- **Applied Steps Pane**: Tracks all transformation steps, allowing users to modify or reorder them.
- **Formula Bar**: Shows the M language code for advanced users to edit transformations manually.
- **Ribbon**: Provides tools for transformations like filtering, grouping, and merging.

### Importing Data with Power Query
To import data into Power Query:
1. In Power BI Desktop, click "Get Data" from the Home tab and select a source (e.g., SQL Server for AdventureWorks 2022).
2. Specify the server and database, then select tables (e.g., Sales.SalesOrderDetail).
3. Load the data into Power Query Editor for transformation or directly into the data model.

### Shaping Data with Power Query
Data shaping involves transforming raw data into a usable format. Common transformations include:
- **Filtering Rows**: Removing irrelevant data (e.g., filtering orders from a specific year).
- **Removing Duplicates**: Eliminating redundant records to ensure data accuracy.
- **Renaming Columns**: Making column names more descriptive for clarity.
- **Changing Data Types**: Ensuring columns have correct types (e.g., Date, Number) for analysis.
- **Merging/Appending Queries**: Combining multiple datasets for comprehensive analysis.

### Using Power Query to Fit Analytical Requirements
Power Query enables users to tailor data to specific business needs by:
- Standardizing formats (e.g., converting dates to a uniform format).
- Creating calculated columns (e.g., calculating total sales from quantity and price).
- Removing errors or null values to ensure data integrity.
- Grouping or aggregating data to summarize insights (e.g., total sales by region).

## Examples

### Example 1: Importing Data from AdventureWorks 2022
1. Open Power BI Desktop and click "Get Data" > "SQL Server."
2. Enter the server name and select the AdventureWorks2022 database.
3. Choose the Sales.SalesOrderDetail table and click "Load" to open it in Power Query Editor.
4. In Power Query Editor, preview the data, noting columns like OrderQty, UnitPrice, and ProductID.

### Example 2: Removing Duplicates
1. In Power Query Editor, select the Sales.SalesOrderDetail table.
2. Highlight the SalesOrderID column, go to the Home tab, and click "Remove Duplicates."
3. Check the Applied Steps Pane to confirm the step was recorded.
4. Apply and close to load the cleaned data into Power BI.

### Example 3: Filtering Rows
1. In Power Query Editor, select the Sales.SalesOrderHeader table from AdventureWorks 2022.
2. Click the filter dropdown on the OrderDate column and select dates from 2022 only.
3. Apply the filter and check the Applied Steps Pane.
4. Load the filtered data into Power BI for analysis.

## Classwork
1. **Task 1: Import Data**
   - Connect to the AdventureWorks 2022 database and import the Sales.SalesOrderHeader table into Power Query Editor.
   - List five columns visible in the Data Preview and their data types.
2. **Task 2: Remove Duplicates**
   - In Power Query Editor, select the Production.Product table.
   - Remove duplicates based on the ProductNumber column and document the number of rows before and after.
3. **Task 3: Filter and Rename**
   - Import the Sales.SalesOrderDetail table.
   - Filter rows where OrderQty > 5, then rename the UnitPrice column to "PricePerUnit."
   - Save the changes and load the data into Power BI.

## Scenarios
1. **Scenario 1: Sales Data Cleanup**
   - A retail manager needs to analyze sales orders from AdventureWorks 2022 but notices duplicate entries in the Sales.SalesOrderDetail table. Use Power Query to remove duplicates based on SalesOrderID and filter orders with LineTotal > $1000. Create a table visual showing the cleaned data and describe the transformation steps.
2. **Scenario 2: Regional Sales Analysis**
   - A business analyst wants to focus on sales from 2021 in the Sales.SalesOrderHeader table. Use Power Query to filter OrderDate to 2021 and rename the TerritoryID column to "RegionID." Load the data and create a bar chart showing total sales by region. Document the steps and insights gained.

## Class Test
1. What is Power Query primarily used for in Power BI?  
   A) Creating visualizations  
   B) Importing and manipulating data  
   C) Sharing reports  
   D) Writing DAX formulas  
   **Answer**: B

2. Which pane in Power Query Editor records transformation steps?  
   A) Query Pane  
   B) Data Preview  
   C) Applied Steps Pane  
   D) Formula Bar  
   **Answer**: C

3. What is the name of the query language used in Power Query?  
   A) SQL  
   B) Python  
   C) R  
   D) M Language  
   **Answer**: D

4. Which transformation removes redundant records in a dataset?  
   A) Filtering Rows  
   B) Removing Duplicates  
   C) Renaming Columns  
   D) Merging Queries  
   **Answer**: B

5. **Practical Task**:  
   - Import the Production.Product table from AdventureWorks 2022 into Power Query Editor.  
   - Filter rows where ListPrice > 500 and rename the Name column to "ProductName."  
   - Create a table visual in Power BI showing ProductID, ProductName, and ListPrice.  
   - Submit a screenshot of the visual and list the transformation steps taken.