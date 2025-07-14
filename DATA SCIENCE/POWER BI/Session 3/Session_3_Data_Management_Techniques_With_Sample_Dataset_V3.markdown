# Session 3: Data Management Techniques

## Objectives
- Apply advanced data extraction techniques using the AdventureWorks 2022 database and a custom dataset.
- Use data profiling tools in Power Query to assess data quality and identify issues.
- Demonstrate indexing, grouping, aggregating, and pivoting/unpivoting in Power Query for data organization.
- Perform data cleaning to correct duplicates, missing values, mixed case formatting, typos, incorrect data types, and inconsistent date formats.
- Execute data transformations, including unpivoting wide-format data, splitting columns, joining with lookup tables, and establishing relationships in Power BI.

## Definition of Terms
- **Data Extraction**: Importing data from sources like SQL Server databases, CSV files, or web APIs into Power BI for analysis.
- **Data Profiling**: Evaluating data quality, structure, and distribution using Power Query tools such as Column Quality, Column Distribution, and Column Profile.
- **Power Query Editor**: A Power BI interface for transforming and cleaning data, accessed via the "Transform Data" button.
- **Indexing**: Adding a unique sequential column to a dataset to facilitate tracking and sorting.
- **Grouping**: Aggregating data by common attributes (e.g., grouping sales by customer) for summarized insights.
- **Aggregating**: Summarizing data using functions like Sum, Count, or Average (e.g., total sales by product).
- **Pivoting/Unpivoting**: Pivoting creates new columns from unique values; unpivoting converts columns into rows for analysis.
- **Data Cleaning**: Correcting issues like duplicates, missing values, typos, or inconsistent formats to ensure data reliability.
- **DirectQuery**: A Power BI feature that queries data directly from the source without loading it into the data model, suitable for large datasets.

## Sample Dataset
Below is a custom dataset designed to demonstrate data cleaning and transformation tasks in Power BI. It includes two tables: `OrderDetails` for cleaning tasks and `CategoryLookup` for transformation tasks (joining and relationships).

### OrderDetails Table
This table simulates order data with issues like duplicates, missing values, mixed case formatting, typos, incorrect data types, and inconsistent date formats.

| TransactionID | ClientName     | SaleDate    | Product       | UnitsSold | SalePrice | CategoryID |
|---------------|----------------|-------------|---------------|-----------|-----------|------------|
| T1001         | Sarah CONNOR   | 2023-04-10  | Wirless Mouse | 5         | 25.99     | C1         |
| T1001         | SARAH CONNOR   | 2023/04/10  | Wirless Mouse | 5         | 25.99     | C1         |
| T1002         | john miller    | 10-Apr-2023 | Keybord       |           | 45.50     | C2         |
| T1003         | Emily Davis    | 2023-05-15  | Monitor       | 2         | 150.75    | C3         |
| T1004         | michael lee    | 05/20/2023  | Laptp         | 3         | Text      | C1         |
| T1005         | Lisa Brown     |             | Desktop PC    | 1         | 1200.00   |            |
| T1006         | Lisa Brown     | 2023-06-01  | Desktop PC    | 2         | 1200.00   | C2         |

**Issues in OrderDetails**:
- **Duplicates**: TransactionID T1001 is repeated.
- **Missing Values**: UnitsSold missing for T1002; SaleDate and CategoryID missing for T1005 and T1005/T1006, respectively.
- **Mixed Case Formatting**: ClientName has inconsistent casing (e.g., "Sarah CONNOR," "john miller").
- **Typos**: "Wirless Mouse" and "Keybord" in Product column.
- **Incorrect Data Types**: SalePrice for T1004 is text instead of decimal.
- **Inconsistent Date Formats**: SaleDate varies (e.g., "2023-04-10," "2023/04/10," "10-Apr-2023").

### CategoryLookup Table
This table provides category details for joining with OrderDetails.

| CategoryID | CategoryName | Supervisor   |
|------------|--------------|--------------|
| C1         | Accessories  | Jane Doe     |
| C2         | Peripherals  | Tom Wilson   |
| C3         | Displays     | Emma Clark   |

### Instructions to Use the Dataset
1. Save the `OrderDetails` and `CategoryLookup` tables as CSV files (e.g., `OrderDetails.csv` and `CategoryLookup.csv`).
2. Import both into Power BI using "Get Data" > "Text/CSV" for the exercises below.

## Explanations

### Data Extraction
Power BI supports extracting data from diverse sources, including SQL Server (e.g., AdventureWorks 2022), CSV files, and online services. For the custom dataset, you’ll import `OrderDetails.csv` and `CategoryLookup.csv` into Power Query Editor. DirectQuery is useful for large datasets like AdventureWorks 2022, allowing real-time queries without loading data into memory.

### Data Profiling Tools
Power Query’s profiling tools assess data quality:
- **Column Quality**: Identifies Valid, Error, and Empty values (e.g., detecting missing UnitsSold in OrderDetails).
- **Column Distribution**: Shows value frequency and uniqueness (e.g., distribution of CategoryID).
- **Column Profile**: Provides detailed statistics, such as min/max SalePrice or value counts.
These tools ensure datasets like AdventureWorks 2022 and OrderDetails are reliable for analysis.

### Data Cleaning Techniques
Cleaning addresses common data issues:
- **Duplicates**: Remove duplicate rows (e.g., TransactionID T1001 in OrderDetails).
- **Missing Values**: Replace or remove missing data (e.g., empty SaleDate in T1005).
- **Mixed Case Formatting**: Standardize text (e.g., "Sarah CONNOR" to "Sarah Connor").
- **Typos**: Correct misspellings (e.g., "Wirless Mouse" to "Wireless Mouse").
- **Incorrect Data Types**: Convert text to numeric types (e.g., SalePrice "Text" to Decimal).
- **Inconsistent Date Formats**: Standardize dates (e.g., "10-Apr-2023" to "2023-04-10").

### Data Transformation Techniques
Transformations reshape data for analysis:
- **Unpivoting**: Convert wide-format data (e.g., monthly sales columns) into long format.
- **Splitting Columns**: Separate combined data (e.g., split ClientName into FirstName and LastName).
- **Joining with Lookup Tables**: Merge datasets using keys (e.g., join OrderDetails with CategoryLookup on CategoryID).
- **Creating Relationships**: Link tables in Power BI’s Model View for integrated analysis.
- **Indexing/Grouping/Aggregating**: Add identifiers, group data, and summarize metrics (e.g., total sales by category).

## Examples

### Example 1: Cleaning Duplicates in OrderDetails
1. Import `OrderDetails.csv` into Power Query Editor via "Get Data" > "Text/CSV."
2. Select the TransactionID column, go to Home > Remove Duplicates.
3. Verify in Applied Steps Pane; row count should reduce from 7 to 6.
4. Apply and load the cleaned data.

### Example 2: Handling Missing Values and Typos
1. In Power Query Editor, select the UnitsSold column in OrderDetails.
2. Go to Home > Replace Values, replace empty cells with 0.
3. For Product, replace "Wirless Mouse" with "Wireless Mouse" and "Keybord" with "Keyboard" using Replace Values.
4. Apply changes and verify in Data Preview.

### Example 3: Standardizing Dates
1. In Power Query Editor, select the SaleDate column in OrderDetails.
2. Go to Transform > Date > Parse to standardize all dates to "YYYY-MM-DD" format.
3. Replace missing SaleDate values with "2023-01-01."
4. Apply and load the data.

### Example 4: Unpivoting Wide-Format Data
Assume a wide-format dataset with monthly sales (custom dataset for transformation):

| Product       | Jan_Sales | Feb_Sales | Mar_Sales |
|---------------|-----------|-----------|-----------|
| Wireless Mouse| 2000      | 2500      | 2300      |
| Keyboard      | 1500      | 1800      | 1600      |

1. Import this table into Power Query Editor as `MonthlySales.csv`.
2. Select Jan_Sales, Feb_Sales, and Mar_Sales columns, then go to Transform > Unpivot Columns.
3. Resulting table:

| Product       | Attribute  | Value |
|---------------|------------|-------|
| Wireless Mouse| Jan_Sales  | 2000  |
| Wireless Mouse| Feb_Sales  | 2500  |
| Wireless Mouse| Mar_Sales  | 2300  |
| Keyboard      | Jan_Sales  | 1500  |
| Keyboard      | Feb_Sales  | 1800  |
| Keyboard      | Mar_Sales  | 1600  |

4. Rename Attribute to "Month" and Value to "SalesAmount," then apply.

### Example 5: Splitting Columns and Joining
1. In Power Query Editor, select the ClientName column in OrderDetails.
2. Go to Transform > Split Column > By Delimiter (space) to create FirstName and LastName.
3. Merge OrderDetails with CategoryLookup on CategoryID using Home > Merge Queries (Left Outer join).
4. Expand CategoryName and Supervisor columns, then apply.

## Classwork
1. **Task 1: Import and Profile OrderDetails**
   - Import `OrderDetails.csv` into Power Query Editor.
   - Enable Column Quality and Column Distribution in the View tab.
   - Document columns with Empty or Error values and suggest corrections (e.g., replace missing values).
2. **Task 2: Clean OrderDetails**
   - Remove duplicates based on TransactionID.
   - Replace missing UnitsSold with 0 and missing CategoryID with "Unknown."
   - Standardize ClientName to Proper Case and fix typos in Product (e.g., "Laptp" to "Laptop").
3. **Task 3: Transform AdventureWorks Data**
   - Import Sales.SalesOrderHeader from AdventureWorks 2022.
   - Add an index column starting from 1, group by CustomerID, and aggregate TotalDue (Sum).
   - Create a table visual showing total sales per customer.
4. **Task 4: Unpivot Monthly Sales**
   - Import the `MonthlySales.csv` table (from Example 4).
   - Unpivot the monthly columns and rename to "Month" and "SalesAmount."
   - Create a bar chart showing sales by Product and Month.

## Scenarios
1. **Scenario 1: Retail Data Quality Assurance**
   - A retail company uses `OrderDetails.csv` but identifies data inconsistencies. Import the dataset, remove duplicates based on TransactionID, standardize SaleDate to "YYYY-MM-DD," and correct Product typos. Create a table visual showing TransactionID, Product, and UnitsSold. Document the steps and use Column Profile to verify data quality.
2. **Scenario 2: Sales Analysis with AdventureWorks**
   - A business analyst needs to summarize sales by territory from AdventureWorks 2022’s Sales.SalesOrderHeader table. Import the table, add an index column, group by TerritoryID to sum TotalDue, and pivot OrderDate years into columns (e.g., 2021, 2022). Create a bar chart showing sales by territory and year, and describe the insights.
3. **Scenario 3: Category-Based Sales Insights**
   - The company wants to enrich `OrderDetails.csv` with category details. Split ClientName into FirstName and LastName, merge with `CategoryLookup.csv` on CategoryID, and create a relationship in Model View. Build a table visual showing FirstName, Product, and CategoryName. Document the steps and insights.

## Class Test
1. What is the purpose of data profiling in Power Query?  
   A) Creating visualizations  
   B) Assessing data quality and structure  
   C) Publishing reports online  
   D) Writing DAX calculations  
   **Answer**: B

2. Which Power Query tool shows value frequency in a column?  
   A) Column Quality  
   B) Column Distribution  
   C) Applied Steps  
   D) Formula Bar  
   **Answer**: B

3. What does the "Split Column" transformation achieve?  
   A) Removes duplicate rows  
   B) Separates data into multiple columns  
   C) Groups data by attributes  
   D) Changes data types  
   **Answer**: B

4. Which technique standardizes inconsistent date formats in Power Query?  
   A) Replace Values  
   B) Parse Date  
   C) Remove Duplicates  
   D) Merge Queries  
   **Answer**: B

5. **Practical Task**:  
   - Import `OrderDetails.csv` into Power Query Editor.  
   - Remove duplicates based on TransactionID, replace missing SaleDate with "2023-01-01," and change SalePrice data type to Decimal Number.  
   - Merge with `CategoryLookup.csv` on CategoryID and expand CategoryName.  
   - Create a table visual showing TransactionID, ClientName, Product, and CategoryName.  
   - Submit a screenshot of the visual and list the transformation steps.