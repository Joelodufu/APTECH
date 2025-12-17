# Lesson 1 — **Basic Drill Through** 


## Learning objectives

By the end of Lesson 1 students will be able to:

* Import the sample Excel dataset and prepare the model for reporting.
* Build a Sales Summary page (by product and region).
* Create a *Product Details* drill-through page and register drill-through fields.
* Use right-click drill through to navigate from summary → details and use a Back button to return.
* Verify filters are passed correctly and troubleshoot common problems.

---

## Prerequisites & materials

* Power BI Desktop (latest installed).
* The Excel workbook you downloaded: **PowerBI_DrillThrough_Dataset.xlsx**.
* Basic familiarity with Power BI visuals and the model view.

---

# Step-by-step class script

### Part A — Prepare the file & data model

1. **Open Power BI Desktop → Get Data → Excel**.

   * Browse and load `PowerBI_DrillThrough_Dataset.xlsx`. Select all sheets and click **Load** (or **Transform Data** if you want to clean first).

2. **In Power Query (optional but recommended)**:

   * Ensure `SalesTransactions[Date]` is typed as **Date** (Change Type → Date).
   * Ensure numeric columns (`Quantity`, `UnitPrice`, `Discount`, `SalesAmount`) are numeric.
   * Close & Apply.

3. **Create a Date (calendar) table** (required for time-series visuals):

   * Modeling → New table, paste this DAX:

   ```dax
   Calendar =
   ADDCOLUMNS(
     CALENDAR(MIN('SalesTransactions'[Date]), MAX('SalesTransactions'[Date])),
     "Year", YEAR([Date]),
     "MonthNumber", MONTH([Date]),
     "MonthName", FORMAT([Date],"MMMM"),
     "YearMonth", FORMAT([Date],"YYYY-MM")
   )
   ```

   * Mark as Date table: Table tools → Mark as Date table → select `Calendar[Date]`.

4. **Check relationships** (Model view):

   * `SalesTransactions[CustomerID]` → `Customers[CustomerID]` (one-to-many: Customers → SalesTransactions).
   * `SalesTransactions[ProductID]` → `Products[ProductID]`.
   * `SalesTransactions[StoreID]` → `Stores[StoreID]`.
   * `Complaints[TransactionID]` → `SalesTransactions[TransactionID]` (or Complaints[ProductID] → Products if you prefer).
     Tip: cross-filter direction = single (default) is usually correct for this model.

---

### Part B — Create useful measures (copy these into Modeling → New measure)

Create a handful of measures students can use immediately:

```dax
Total Sales = SUM('SalesTransactions'[SalesAmount])

Calculated Sales = 
SUMX(
  'SalesTransactions',
  'SalesTransactions'[Quantity] * 'SalesTransactions'[UnitPrice] - 'SalesTransactions'[Discount]
)

Total Quantity = SUM('SalesTransactions'[Quantity])

Distinct Customers = DISTINCTCOUNT('SalesTransactions'[CustomerID])

Average Order Value = DIVIDE([Total Sales], DISTINCTCOUNT('SalesTransactions'[TransactionID]), 0)

Selected Product Name = SELECTEDVALUE('Products'[ProductName], "All products")
```

(Explain the difference between `Total Sales` and `Calculated Sales` — good teachable moment about trusting source columns vs. recalculation.)

---

### Part C — Build the **Sales Summary** page (the source page)

1. **Rename the page** to `Sales Summary`.
2. **Add visuals**:

   * **Bar chart:** *Sales by Product*

     * Axis: `Products[ProductName]`
     * Values: `[Total Sales]`
     * Sort: Descending by `[Total Sales]`
     * Tooltip: add `Total Quantity`, `Distinct Customers`.
   * **Stacked bar (or column) chart:** *Sales by Category*

     * Axis: `Products[Category]`
     * Values: `[Total Sales]`
   * **Bar chart:** *Sales by Region*

     * Axis: `Stores[Region]`
     * Values: `[Total Sales]`
   * **Slicer(s)**: `Calendar[Year]` and `Calendar[MonthName]` (or a Date range slicer using `Calendar[Date]`).
3. **Formatting**: enable data labels for top charts; set thousands separators via measure formatting; sort and resize visuals for neat layout.
4. **Important teaching note:** To enable drill-through to the product page, the source visual must contain the same field you registered on the drill-through page (for example `Products[ProductName]` or `Products[ProductID]`). So make sure the *Sales by Product* visual uses `ProductName` (or includes it inside a table visual).

---

### Part D — Create the **Product Details (Drill-through)** page

1. **Add new page** and rename to `Product Details`.
2. **Set up Drill-through filters**:

   * In the right pane (Filters on this page), find **“Add drill-through fields here”**.
   * Drag `Products[ProductName]` (or `Products[ProductID]`) into that area.

     * Power BI will show a drill-through icon on the page and display a short instruction text on the canvas.
   * Optional: also drag `Products[Category]` if you want drill-through available by category as well.
3. **Add visuals for the product context**:

   * **Card**: place `[Selected Product Name]` or a card with the measure `Selected Product Name` so it displays the drilled product.
   * **Line chart**: Sales trend over time

     * Axis: `Calendar[Date]`
     * Values: `[Total Sales]` (ensure `Calendar` is related to `SalesTransactions`)
   * **Table or matrix**: Top customers for this product

     * Columns: `Customers[Name]`, `[Total Sales]`, `Total Quantity`
     * Sort by `[Total Sales]` descending; optionally use Top N filter set to 5.
   * **Table**: Complaints for this product

     * Use fields from `Complaints` such as `IssueType`, `ResolutionTime (days)`, `Status`, `CustomerID` (or join to customer name).
4. **Add a Back button**:

   * Insert → Buttons → **Back**. Place it in the top-left or header area. This provides an easy way for the user to return to the previous page.
5. **Polish**: add a dynamic title using a measure:

   * Create measure:

     ```dax
     Product Page Title = "Product Details — " & SELECTEDVALUE('Products'[ProductName], "All products")
     ```
   * In the title formatting of the main visual (e.g., a card or the page title text box) use **fx** → Format by: **Field value** → select `Product Page Title`. This makes the title show the current product name automatically.

---

### Part E — Demo & test drill-through (live in front of class)

1. On **Sales Summary** page, **right-click** a product bar in the *Sales by Product* bar chart (make sure you click at the product level).
2. Context menu → **Drill through** → choose `Product Details` (it will show the product name in the submenu).
3. You will navigate to `Product Details` page; verify:

   * The visuals reflect only the selected product (cards show its name & totals).
   * Complaints table shows only complaints for that product.
4. Click the **Back** button to return to `Sales Summary`.
5. Repeat demo with different products. Show that if you try to right-click a visual that does *not* contain `ProductName` (e.g., Category chart only), Power BI may not show drill-through to product page — explain why.

---

## Exercises for students (increasing difficulty)

1. **Exercise 1 (Basic)**: Create the *Sales by Product* bar chart and perform a drill-through to confirm the `Product Details` page shows the correct product totals.

   * **Check**: The `Total Sales` shown on Product Details equals the sum of `SalesAmount` for the selected product.

2. **Exercise 2**: Add a **Top 5 customers** table to `Product Details` (Customers[Name] and `[Total Sales]`). Sort and show only top 5 using a visual-level Top N filter.

3. **Exercise 3 (Filter behavior)**: Apply the `Calendar[Year]` slicer to the Summary page; drill through to a product and show that the year filter is preserved on the drill-through page (explain when filters carry over and when they don’t).

4. **Bonus**: Add drill-through capability by `Products[Category]` as well (so users can drill from category visuals to the product page showing all products in that category).

---

## Troubleshooting (common issues + fixes)

* **Drill through option not appearing**

  * Ensure the **source visual contains the drill-through field** (e.g., `ProductName`) — drill-through uses the value context from the source visual.
  * Check relationships: the drill-through field must be the same field used in the model or directly related.
* **Product Details shows “All products”**

  * Verify you right-clicked a visual element that contains a single product context (not an aggregated category with no product), or use a table visual that contains ProductName.
* **Dates not showing correctly in trend**

  * Ensure `Calendar[Date]` is marked as the date table and that relationships are established with `SalesTransactions[Date]`.
* **Numbers not matching expected sums**

  * Check whether `SalesAmount` is already net of discount. If you want to recalc from fields, use the `Calculated Sales` measure.

---

## Assessment (short quiz you can ask students)

1. How do you register a field for drill-through on a page?
   *Answer: Drag the field into the “Add drill-through fields here” area in Filters on this page.*
2. Why might drill-through not appear for a visual that shows “Sales by Category”?
   *Answer: Because the visual lacks the drill-through field (Product), so Power BI cannot pass product context.*
3. How do you create a dynamic page title showing the drilled product name?
   *Answer: Use `SELECTEDVALUE(Products[ProductName])` in a measure and bind it to the visual title via the fx → Format by field value option.*

---

## Teacher tips & demo script (quick lines)

* *“I’ll create the Sales by Product bar — notice it contains `ProductName`. That’s how Power BI knows what value to pass.”*
* *“Right-click a product → Drill through → Product Details. Watch the charts change — only data for that product remains.”*
* When a student gets stuck, ask them: *“Does your source visual include the same field that you added to the drill-through filters?”*

---

## Suggested next steps after this lesson

* Add a **Customer Details** drill-through page (same technique).
* Teach **button-driven drill-through** (Insert → Button → Action → Drill through target), and the **Keep all filters** option for buttons.
* Show **cross-report drill-through** (advanced topic).

---
