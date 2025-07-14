# Session 5: DAX Fundamentals

## Objectives
- Explain the role of Data Analysis Expressions (DAX) in Power BI.
- Demonstrate creating calculated columns and measures using DAX with the AdventureWorks 2022 database.
- Illustrate common DAX functions for basic calculations and aggregations.
- Apply DAX to translate business logic into formulas for data analysis.
- Use a custom dataset to practice DAX calculations for practical understanding.

## Definition of Terms
- **DAX (Data Analysis Expressions)**: A formula language in Power BI for creating calculations, measures, and queries to enhance data models.
- **Calculated Column**: A column added to a table in Power BI, computed row-by-row using a DAX formula, stored in the data model.
- **Measure**: A dynamic calculation in DAX that aggregates data (e.g., sum, average) and is evaluated based on report context, not stored in the table.
- **Aggregation Functions**: DAX functions like SUM, AVERAGE, COUNT, and MAX that summarize data across rows.
- **Table Function**: DAX functions that manipulate or return tables (e.g., FILTER, ALL) for use in calculations.
- **Context**: The environment in which a DAX formula is evaluated, including **Row Context** (for calculated columns) and **Filter Context** (for measures based on report filters).

## Sample Dataset
Below is a custom dataset to demonstrate DAX concepts, complementing the AdventureWorks 2022 database. It simplifies sales data for creating calculated columns and measures.

### SalesData Table
| OrderID | ProductName | Category | Quantity | UnitPrice | SaleDate   |
|---------|-------------|----------|----------|-----------|------------|
| O001    | Laptop      | Electronics | 2      | 1000.00   | 2023-07-01 |
| O002    | Mouse       | Accessories | 5      | 20.00     | 2023-07-02 |
| O003    | Keyboard    | Accessories | 3      | 30.00     | 2023-07-03 |
| O004    | Laptop      | Electronics | 1      | 1000.00   | 2023-07-04 |

### Instructions to Use the Dataset
1. Save the `SalesData` table as a CSV file (e.g., `SalesData.csv`).
2. Import it into Power BI using "Get Data" > "Text/CSV" for the exercises below.

## Explanations

### What is DAX?
DAX is a powerful formula language in Power BI used to create custom calculations, measures, and queries. It enables users to perform complex data analysis by defining calculations that extend the capabilities of the data model. DAX is essential for translating business logic (e.g., calculating total sales or year-over-year growth) into actionable insights, especially with datasets like AdventureWorks 2022.

### Calculated Columns vs. Measures
- **Calculated Columns**: Computed row-by-row and stored in the data model. Used for static calculations (e.g., total order value per row). Example: `TotalValue = SalesData[Quantity] * SalesData[UnitPrice]`.
- **Measures**: Dynamic calculations evaluated based on report context (e.g., filters, slicers). Used for aggregations (e.g., total sales across all rows). Example: `TotalSales = SUM(SalesData[Quantity] * SalesData[UnitPrice])`.
- **Key Difference**: Calculated columns consume memory as they are stored, while measures are calculated on-the-fly, making them efficient for aggregations.

### Common DAX Functions
- **Aggregation Functions**: SUM, AVERAGE, COUNT, MIN, MAX (e.g., `SUM(SalesOrderDetail[LineTotal])`).
- **Logical Functions**: IF, AND, OR (e.g., `IF(SalesData[Quantity] > 3, "High", "Low")`).
- **Text Functions**: CONCATENATE, UPPER, LOWER (e.g., `UPPER(SalesData[ProductName])`).
- **Date Functions**: YEAR, MONTH, DATEADD (e.g., `YEAR(SalesData[SaleDate])`).
- **Table Functions**: FILTER, ALL, RELATED (e.g., `FILTER(SalesOrderDetail, SalesOrderDetail[UnitPrice] > 100)`).

### Context in DAX
- **Row Context**: Automatically created in calculated columns, where the formula applies to each row (e.g., multiplying Quantity and UnitPrice per row).
- **Filter Context**: Created by report elements like slicers, filters, or visuals, affecting measures (e.g., total sales filtered by a specific year).
Understanding context is critical for accurate DAX calculations.

## Examples

### Example 1: Creating a Calculated Column in SalesData
1. Import `SalesData.csv` into Power BI.
2. In Data View, select the SalesData table and click "New Column."
3. Enter: `TotalOrderValue = SalesData[Quantity] * SalesData[UnitPrice]`.
4. Verify the new column shows values like 2000.00 for O001 (2 * 1000.00).

### Example 2: Creating a Measure in SalesData
1. In Report View, select the SalesData table and click "New Measure."
2. Enter: `TotalSales = SUM(SalesData[Quantity] * SalesData[UnitPrice])`.
3. Create a card visual to display TotalSales (e.g., 2150.00 for all rows).
4. Apply a Category filter (e.g., Electronics) to see the measure adjust dynamically.

### Example 3: Using DAX with AdventureWorks 2022
1. Import Sales.SalesOrderDetail and Production.Product from AdventureWorks 2022.
2. Create a calculated column: `ExtendedPrice = Sales.SalesOrderDetail[OrderQty] * Sales.SalesOrderDetail[UnitPrice]`.
3. Create a measure: `TotalRevenue = SUM(Sales.SalesOrderDetail[ExtendedPrice])`.
4. Create a table visual showing ProductName and TotalRevenue.

### Example 4: Logical DAX Function
1. In SalesData, create a calculated column: `QuantityCategory = IF(SalesData[Quantity] > 3, "High", "Low")`.
2. Verify that O002 (Quantity = 5) shows "High" and O001 (Quantity = 2) shows "Low."

## Classwork
1. **Task 1: Calculated Column in SalesData**
   - Import `SalesData.csv` into Power BI.
   - Create a calculated column `TotalOrderValue = SalesData[Quantity] * SalesData[UnitPrice]`.
   - Create a table visual showing OrderID, ProductName, and TotalOrderValue.
2. **Task 2: Measure in SalesData**
   - Create a measure `TotalCategorySales = SUM(SalesData[Quantity] * SalesData[UnitPrice])`.
   - Create a bar chart showing TotalCategorySales by Category.
   - Document the measure’s value with and without a Category filter.
3. **Task 3: DAX with AdventureWorks**
   - Import Sales.SalesOrderDetail from AdventureWorks 2022.
   - Create a calculated column `LineTotalWithTax = Sales.SalesOrderDetail[OrderQty] * Sales.SalesOrderDetail[UnitPrice] * 1.1` (assuming 10% tax).
   - Create a measure `TotalSalesWithTax = SUM(Sales.SalesOrderDetail[LineTotalWithTax])`.
   - Create a card visual showing TotalSalesWithTax.
4. **Task 4: Logical DAX Function**
   - In SalesData, create a calculated column `SaleYear = YEAR(SalesData[SaleDate])`.
   - Create a table visual showing ProductName and SaleYear.

## Scenarios
1. **Scenario 1: Retail Sales Analysis**
   - A retail company uses `SalesData.csv` to analyze sales performance. Create a calculated column `TotalOrderValue = SalesData[Quantity] * SalesData[UnitPrice]` and a measure `TotalSales = SUM(SalesData[Quantity] * SalesData[UnitPrice])`. Build a table visual showing ProductName and TotalOrderValue, and a card showing TotalSales. Document the steps and insights.
2. **Scenario 2: AdventureWorks Revenue Tracking**
   - A manager needs to track revenue with tax using AdventureWorks 2022’s Sales.SalesOrderDetail. Create a calculated column `Revenue = Sales.SalesOrderDetail[OrderQty] * Sales.SalesOrderDetail[UnitPrice]` and a measure `TotalRevenue = SUM(Sales.SalesOrderDetail[Revenue])`. Create a bar chart showing TotalRevenue by ProductID. Describe the DAX formulas and results.
3. **Scenario 3: Sales Categorization**
   - Using `SalesData.csv`, create a calculated column `OrderSize = IF(SalesData[Quantity] > 2, "Large", "Small")`. Build a table visual showing ProductName, Quantity, and OrderSize. Document the steps and analyze how OrderSize impacts sales insights.

## Class Test
1. What is the primary purpose of DAX in Power BI?  
   A) Importing data  
   B) Creating visualizations  
   C) Performing custom calculations  
   D) Sharing reports  
   **Answer**: C

2. What is the difference between a calculated column and a measure?  
   A) Calculated columns are dynamic; measures are stored  
   B) Calculated columns are stored; measures are dynamic  
   C) Both are stored in the data model  
   D) Both are evaluated on-the-fly  
   **Answer**: B

3. Which DAX function calculates the sum of a column?  
   A) COUNT  
   B) SUM  
   C) AVERAGE  
   D) MAX  
   **Answer**: B

4. What is Filter Context in DAX?  
   A) The environment for calculated columns  
   B) The report filters affecting measures  
   C) The data import process  
   D) The table relationships  
   **Answer**: B

5. **Practical Task**:  
   - Import `SalesData.csv` into Power BI.  
   - Create a calculated column `TotalOrderValue = SalesData[Quantity] * SalesData[UnitPrice]`.  
   - Create a measure `TotalElectronicsSales = CALCULATE(SUM(SalesData[Quantity] * SalesData[UnitPrice]), SalesData[Category] = "Electronics")`.  
   - Create a table visual showing ProductName and TotalOrderValue, and a card showing TotalElectronicsSales.  
   - Submit a screenshot of the visuals and list the DAX formulas used.