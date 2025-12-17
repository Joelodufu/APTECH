## Aggregation Functions
Functions that compute scalar values like sums, averages, or counts over data.

Features: SUM, SUMX, AVERAGE, AVERAGEX, COUNT, COUNTX, MIN, MINX, MAX, MAXX, COUNTROWS

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| SUM | Adds all numbers in a column. | `SUM(Sales[Amount])` | Calculating total sales in a report. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| SUMX | Sums an expression evaluated for each row in a table. | `SUMX(Sales, Sales[Price] * Sales[Quantity])` | Total revenue from price and quantity. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| AVERAGE | Computes arithmetic mean of a column. | `AVERAGE(Sales[Amount])` | Average sales per transaction. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| AVERAGEX | Averages an expression evaluated per row. | `AVERAGEX(Sales, Sales[Price] * Sales[Quantity])` | Average revenue per sale. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| COUNT | Counts non-blank values in a column. | `COUNT(Sales[OrderID])` | Counting total orders. |[](https://www.geeksforgeeks.org/power-bi/power-bi-functions/)
| COUNTX | Counts rows where an expression is non-blank. | `COUNTX(Sales, Sales[Price] * Sales[Quantity])` | Counting rows with valid revenue. |[](https://www.geeksforgeeks.org/power-bi/power-bi-functions/)
| MIN | Returns smallest value in a column. | `MIN(Sales[Price])` | Finding lowest product price. |[](https://www.dev4side.com/en/blog/dax-power-bi)
| MINX | Returns smallest value of an expression per row. | `MINX(Sales, Sales[Price] * Sales[Discount])` | Minimum discounted price per sale. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)
| MAX | Returns largest value in a column. | `MAX(Sales[Price])` | Finding highest product price. |[](https://www.dev4side.com/en/blog/dax-power-bi)
| MAXX | Returns largest value of an expression per row. | `MAXX(Sales, Sales[Price] * Sales[Quantity])` | Maximum revenue per sale. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)
| COUNTROWS | Counts rows in a table. | `COUNTROWS(Sales)` | Total number of sales records. |[](https://www.dev4side.com/en/blog/dax-power-bi)

## Date and Time Functions
Functions for calculations involving dates and times, similar to Excel but based on SQL Server datetime types.

Features: DATE, DATEVALUE, TODAY, NOW, YEAR, MONTH, DAY, WEEKDAY, DATEDIFF, EOMONTH

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| DATE | Creates a date from year, month, day. | `DATE(2025, 8, 20)` | Generating specific dates for filters. |[](https://hevodata.com/learn/dax-functions/)
| DATEVALUE | Converts text to datetime. | `DATEVALUE("2025-08-20")` | Parsing date strings from imports. |[](https://hevodata.com/learn/dax-functions/)
| TODAY | Returns current date. | `TODAY()` | Filtering data for current day sales. |[](https://intellipaat.com/blog/dax-power-bi/)
| NOW | Returns current date and time. | `NOW()` | Timestamping report refreshes. |[](https://intellipaat.com/blog/dax-power-bi/)
| YEAR | Extracts year from a date. | `YEAR(Sales[Date])` | Grouping sales by year. |[](https://www.analyticsvidhya.com/blog/2024/07/dax-functions-in-power-bi/)
| MONTH | Extracts month from a date. | `MONTH(Sales[Date])` | Monthly sales reports. |[](https://www.analyticsvidhya.com/blog/2024/07/dax-functions-in-power-bi/)
| DAY | Extracts day from a date. | `DAY(Sales[Date])` | Daily sales analysis. |[](https://www.analyticsvidhya.com/blog/2024/07/dax-functions-in-power-bi/)
| WEEKDAY | Returns day of the week (1-7). | `WEEKDAY(Sales[Date], 1)` | Analyzing sales by weekday. |[](https://hevodata.com/learn/dax-functions/)
| DATEDIFF | Calculates difference between two dates. | `DATEDIFF(Sales[StartDate], Sales[EndDate], DAY)` | Measuring order processing time. |[](https://www.datacamp.com/tutorial/power-bi-dax-tutorial-for-beginners)
| EOMONTH | Returns last day of month. | `EOMONTH(Sales[Date], 0)` | Month-end sales summaries. |[](https://www.datacamp.com/tutorial/power-bi-dax-tutorial-for-beginners)

## Time Intelligence Functions
Functions for date-based calculations using built-in calendar knowledge.

Features: DATEADD, TOTALYTD, SAMEPERIODLASTYEAR, PREVIOUSMONTH, NEXTMONTH, ENDOFYEAR

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| DATEADD | Shifts dates by a specified interval. | `DATEADD(Sales[Date], -1, YEAR)` | Comparing sales with previous year. |[](https://www.analyticsvidhya.com/blog/2024/07/dax-functions-in-power-bi/)
| TOTALYTD | Calculates year-to-date value. | `TOTALYTD(SUM(Sales[Amount]), Sales[Date])` | Year-to-date sales tracking. |[](https://www.biconnector.com/blog/power-bi-dax-functions-explained-with-examples/)
| SAMEPERIODLASTYEAR | Returns data for same period last year. | `CALCULATE(SUM(Sales[Amount]), SAMEPERIODLASTYEAR(Sales[Date]))` | Year-over-year comparisons. |[](https://radacad.com/basics-of-dax-expression-in-power-bi/)
| PREVIOUSMONTH | Returns data for previous month. | `CALCULATE(SUM(Sales[Amount]), PREVIOUSMONTH(Sales[Date]))` | Month-over-month analysis. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)
| NEXTMONTH | Returns data for next month. | `CALCULATE(SUM(Sales[Amount]), NEXTMONTH(Sales[Date]))` | Forecasting next month’s sales. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)
| ENDOFYEAR | Returns last date of year. | `ENDOFYEAR(Sales[Date])` | Year-end financial reporting. |[](https://intellipaat.com/blog/dax-power-bi/)

## Filter Functions
Functions that manipulate filter and row contexts for dynamic calculations.

Features: CALCULATE, FILTER, ALL, ALLEXCEPT, REMOVEFILTERS, RELATED

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| CALCULATE | Modifies filter context for an expression. | `CALCULATE(SUM(Sales[Amount]), Sales[Region] = "West")` | Regional sales with specific filters. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| FILTER | Returns table filtered by condition. | `FILTER(Sales, Sales[Price] > 100)` | High-value sales analysis. |[](https://www.analyticsvidhya.com/blog/2024/07/dax-functions-in-power-bi/)
| ALL | Removes filters from a table/column. | `CALCULATE(SUM(Sales[Amount]), ALL(Sales))` | Total sales ignoring filters. |[](https://learn.microsoft.com/en-us/dax/all-function-dax)
| ALLEXCEPT | Removes filters except specified columns. | `CALCULATE(SUM(Sales[Amount]), ALLEXCEPT(Sales, Sales[Region]))` | Sales ignoring all but region filters. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| REMOVEFILTERS | Clears filters from tables/columns. | `CALCULATE(SUM(Sales[Amount]), REMOVEFILTERS(Sales[Category]))` | Sales without category filters. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| RELATED | Fetches value from related table. | `RELATED(Products[Category])` | Displaying product category in sales table. |[](https://www.analyticsvidhya.com/blog/2024/07/dax-functions-in-power-bi/)

## Logical Functions
Functions for conditional logic and evaluations.

Features: IF, AND, OR, NOT, SWITCH, ISBLANK

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| IF | Returns value based on condition. | `IF(Sales[Amount] > 1000, "High", "Low")` | Categorizing sales as high/low. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| AND | Checks if both conditions are true. | `AND(Sales[Amount] > 100, Sales[Quantity] > 10)` | Filtering high-value, high-quantity sales. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| OR | Checks if at least one condition is true. | `OR(Sales[Region] = "West", Sales[Region] = "East")` | Filtering multiple regions. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| NOT | Inverts a logical value. | `NOT(Sales[IsActive])` | Filtering inactive records. |[](https://www.datacamp.com/cheat-sheet/dax-cheat-sheet)
| SWITCH | Evaluates multiple conditions. | `SWITCH(Sales[Rating], 1, "Poor", 2, "Good", "Excellent")` | Assigning rating categories. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| ISBLANK | Checks if a value is blank. | `ISBLANK(Sales[Price])` | Identifying missing data in reports. |[](https://www.datacamp.com/tutorial/power-bi-dax-tutorial-for-beginners)

## Text Functions
Functions for manipulating text data.

Features: CONCATENATE, LEFT, RIGHT, MID, UPPER, LOWER, PROPER, REPLACE, SUBSTITUTE

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| CONCATENATE | Combines two text strings. | `CONCATENATE(Products[Name], " - ", Products[Category])` | Creating display names. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| LEFT | Extracts characters from start of text. | `LEFT(Products[Code], 3)` | Extracting product code prefixes. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| RIGHT | Extracts characters from end of text. | `RIGHT(Products[Code], 3)` | Extracting product code suffixes. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| MID | Extracts characters from middle of text. | `MID(Products[Code], 2, 3)` | Extracting specific code segments. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| UPPER | Converts text to uppercase. | `UPPER(Products[Name])` | Standardizing text for display. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| LOWER | Converts text to lowercase. | `LOWER(Products[Name])` | Normalizing text for comparisons. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| PROPER | Capitalizes first letter of each word. | `PROPER(Products[Name])` | Formatting names or titles. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| REPLACE | Replaces part of text by position. | `REPLACE(Products[Code], 1, 2, "XX")` | Updating specific text portions. |[](https://www.datacamp.com/tutorial/power-bi-dax-tutorial-for-beginners)
| SUBSTITUTE | Replaces specific text with new text. | `SUBSTITUTE(Products[Name], "Old", "New")` | Replacing keywords in text. |[](https://www.datacamp.com/tutorial/power-bi-dax-tutorial-for-beginners)

## Lookup Functions
Functions for retrieving data from related tables.

Features: LOOKUPVALUE, RELATED, RELATEDTABLE

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| LOOKUPVALUE | Fetches value from a table based on criteria. | `LOOKUPVALUE(Products[Name], Products[ID], Sales[ProductID])` | Retrieving product names for sales. |[](https://www.analyticsvidhya.com/blog/2024/07/dax-functions-in-power-bi/)
| RELATED | Fetches value from related table via relationship. | `RELATED(Products[Category])` | Adding category to sales reports. |[](https://www.analyticsvidhya.com/blog/2024/07/dax-functions-in-power-bi/)
| RELATEDTABLE | Returns related table filtered by context. | `RELATEDTABLE(Sales)` | Analyzing all sales for a product. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)

## Information Functions
Functions that provide metadata about data or context.

Features: ISERROR, ISBLANK, ISNUMBER, ISTEXT, ISLOGICAL, INFO.TABLES, INFO.COLUMNS

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| ISERROR | Checks if expression results in an error. | `ISERROR(DIVIDE(Sales[Amount], Sales[Quantity]))` | Handling division errors in measures. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)
| ISBLANK | Checks if value is blank. | `ISBLANK(Sales[Price])` | Identifying missing prices in data. |[](https://www.datacamp.com/tutorial/power-bi-dax-tutorial-for-beginners)
| ISNUMBER | Checks if value is numeric. | `ISNUMBER(Sales[Amount])` | Validating numeric data types. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)
| ISTEXT | Checks if value is text. | `ISTEXT(Products[Name])` | Ensuring text fields for formatting. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)
| ISLOGICAL | Checks if value is boolean. | `ISLOGICAL(Sales[IsActive])` | Validating boolean flags. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)
| INFO.TABLES | Returns metadata about model tables. | `INFO.TABLES()` | Documenting data model structure. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)
| INFO.COLUMNS | Returns metadata about model columns. | `INFO.COLUMNS()` | Analyzing column properties in models. |[](https://learn.microsoft.com/en-us/dax/dax-function-reference)

## Mathematical Functions
Functions for numerical calculations beyond aggregation.

Features: DIVIDE, ROUND, CEILING, FLOOR, ABS, SQRT

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| DIVIDE | Divides two numbers, handles division by zero. | `DIVIDE(Sales[Amount], Sales[Quantity], 0)` | Calculating sales per unit safely. |[](https://www.linkedin.com/pulse/22-powerful-dax-formulas-functions-beginners-deep-bi-samson)
| ROUND | Rounds a number to specified digits. | `ROUND(Sales[Price], 2)` | Formatting prices to two decimals. |[](https://www.geeksforgeeks.org/power-bi/power-bi-functions/)
| CEILING | Rounds up to nearest multiple. | `CEILING(Sales[Price], 1)` | Rounding prices up for pricing tiers. |[](https://www.geeksforgeeks.org/power-bi/power-bi-functions/)
| FLOOR | Rounds down to nearest multiple. | `FLOOR(Sales[Price], 1)` | Rounding prices down for discounts. |[](https://www.geeksforgeeks.org/power-bi/power-bi-functions/)
| ABS | Returns absolute value. | `ABS(Sales[Profit])` | Analyzing profit/loss without sign. |[](https://www.geeksforgeeks.org/power-bi/power-bi-functions/)
| SQRT | Calculates square root. | `SQRT(Sales[Quantity])` | Statistical analysis of quantities. |[](https://www.geeksforgeeks.org/power-bi/power-bi-functions/)

## Other Functions
Miscellaneous functions for unique tasks or advanced scenarios.

Features: RANKX, TOPN, CONCATENATEX, SUMMARIZECOLUMNS

| Function | Uses | Example | Practical Uses |
|----------|------|---------|----------------|
| RANKX | Ranks items based on an expression. | `RANKX(ALL(Products), SUM(Sales[Amount]))` | Ranking products by sales. |[](https://www.analyticsvidhya.com/blog/2024/07/dax-functions-in-power-bi/)
| TOPN | Returns top N rows based on expression. | `TOPN(5, Sales, Sales[Amount])` | Identifying top 5 sales performers. |[](https://www.pythian.com/blog/technical-track/top-10-power-bi-dax-functions-for-efficient-data-analysis)
| CONCATENATEX | Concatenates values with delimiter. | `CONCATENATEX(Products, Products[Name], ", ")` | Creating comma-separated product lists. |[](https://blog.dataddo.com/mastering-dax-functions-in-power-bi)
| SUMMARIZECOLUMNS | Creates summary table with aggregations. | `SUMMARIZECOLUMNS(Products[Category], "Total", SUM(Sales[Amount]))` | Summarizing sales by category. |[](https://blog.dataddo.com/mastering-dax-functions-in-power-bi)