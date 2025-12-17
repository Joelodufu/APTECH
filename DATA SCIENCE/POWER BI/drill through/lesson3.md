# Lesson 3 — **Store Performance Drill Through**

## Learning Objectives

By the end of Lesson 3, students will be able to:

- Create a **Regional Sales Overview** page (sales by region, top-performing stores).
- Build a **Store Details Drill-through** page with store manager info, product mix, and complaints.
- Understand how drill-through supports organizational performance analysis.
- Troubleshoot store-level drill-through behavior.

---

## Prerequisites & Materials

- Use the richer dataset: **PowerBI_DrillThrough_Dataset_v2.xlsx** (with multiple stores and transactions).
- Relationships in place: `SalesTransactions → Stores`, `SalesTransactions → Products`, `SalesTransactions → Customers`, `Complaints → SalesTransactions`.
- Measures already created (`Total Sales`, `Total Quantity`, `Distinct Customers`, etc.).

---

# Step-by-Step Class Script

---

### Part A — Build the **Regional Sales Overview Page**

1. **Add a new page** → rename to `Regional Overview`.
2. **Visuals to add**:

   - **Map or Filled Map**:

     - Location: `Stores[Region]`.
     - Values: `[Total Sales]`.
     - Optional: Bubble size = `[Total Quantity]`.

   - **Bar Chart (Top Stores)**:

     - Axis: `Stores[StoreName]`.
     - Values: `[Total Sales]`.
     - Sort descending by `[Total Sales]`.

   - **Donut Chart (Sales by Store Size)**:

     - Legend: `Stores[SizeCategory]`.
     - Values: `[Total Sales]`.

   - **Card**: `[Total Sales]` across all stores.
   - **Slicers**: `Calendar[Year]` and `Calendar[MonthName]`.

3. **Teaching point**: This dashboard shows the **macro view** of store performance. But to really understand what drives success/failure, we need to drill into each store.

---

### Part B — Create the **Store Details Drill-through Page**

1. **Add a new page** → rename to `Store Details`.
2. **Drill-through setup**:

   - In the Filters pane (“Add drill-through fields here”), drag **`Stores[StoreID]`** (or `StoreName`).
   - This enables drill-through to the store-level page.

3. **Visuals to add**:

   - **Card (Store Name)**: Display selected store name.

     - Use a dynamic measure:

       ```dax
       Selected Store Name = SELECTEDVALUE(Stores[StoreName], "All Stores")
       ```

   - **Card (Store Manager)**:

     ```dax
     Selected Store Manager = SELECTEDVALUE(Stores[Manager], "Unknown")
     ```

   - **Bar Chart (Product Mix in Store)**:

     - Axis: `Products[Category]` or `Products[ProductName]`.
     - Values: `[Total Sales]`.

   - **Table (Complaints for Store)**:

     - Columns: `Complaints[IssueType]`, `Complaints[Status]`, `Complaints[ResolutionTime (days)]`.

   - **Line Chart (Store Sales Over Time)**:

     - Axis: `Calendar[Date]`.
     - Values: `[Total Sales]`.

4. **Back Button**: Insert → Button → Back.
5. **Optional Dynamic Title**:

   ```dax
   Store Page Title =
   "Store Performance — " & SELECTEDVALUE(Stores[StoreName], "No Store Selected")
   ```

   Add as a text box title (format by → Field value).

---

### Part C — Demo: Drill-through Flow

1. On `Regional Overview` page, right-click **CityMall Abuja** (or another store) from the bar chart.
2. Select **Drill through → Store Details**.
3. Verify on the `Store Details` page:

   - Store name and manager appear in cards.
   - Product mix shows sales breakdown of that store only.
   - Complaints table shows only complaints linked to that store.
   - Sales over time trend reflects only that store’s transactions.

4. Click **Back** to return.
5. Show the same for another store (e.g., `MegaMart Lagos`) and compare differences.

---

### Part D — Exercises for Students

#### **Exercise 1 (Basic)**

- Drill through to `MegaMart Lagos`.
- Confirm that `Total Sales` matches the store’s bar in `Regional Overview`.

#### **Exercise 2 (Product Mix)**

- On the `Store Details` page, sort the product mix chart by `[Total Sales]`.
- Identify the top-selling product in `CityMall Abuja`.

#### **Exercise 3 (Complaints Focus)**

- Drill through into `Port Harcourt Plaza`.
- Analyze which issue type is most common in complaints.

#### **Exercise 4 (Slicer Carryover)**

- On `Regional Overview`, filter `Year = 2025`.
- Drill through into a store and verify that the complaint records and sales trend only show 2025 data.

---

### Part E — Troubleshooting Notes

- **Drill-through option missing**:

  - Check that `StoreID` or `StoreName` was added to the drill-through filters.
  - Source visual must contain the store field.

- **Manager not showing**:

  - Ensure you used `Stores[Manager]` with `SELECTEDVALUE`.

- **No complaints visible**:

  - Store may not have complaints in the dataset (explain real-world scenario).

---

### Assessment (Quick Quiz)

1. Which field must you add to drill-through filters to enable a Store Details page?
   _Answer: `Stores[StoreID]` or `Stores[StoreName]`._

2. What’s the advantage of using `SELECTEDVALUE(Stores[Manager])` instead of placing the field directly on the page?
   _Answer: It allows dynamic, single-value display and avoids showing “Multiple values” if more than one is selected._

3. How does drill-through help regional managers in real life?
   _Answer: It allows them to zoom from regional KPIs into specific store performance and issues quickly._

---

### Teacher Demo Script (Live)

- _“We’ve looked at customers and products. Now let’s think from the business side: the stores themselves.”_
- _“Here’s the sales map. Lagos is booming — let’s right-click → Drill through → Store Details.”_
- _“Notice how the manager’s name, top products, and complaints all change depending on the store.”_
- _“Drill-through helps regional managers focus on **where the problems are**.”_

---

✅ **End of Lesson 3**: Students can now perform **Store Performance Drill-through** and connect operational issues (complaints, managers, product mix) with overall KPIs.

---
