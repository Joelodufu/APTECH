# Lesson 2 — **Customer-Centric Drill Through**

---

## Learning Objectives

By the end of Lesson 2, students will be able to:

* Build a **Customer Overview** summary page (total purchases per customer, loyalty tiers).
* Create a **Customer Details Drill-through** page with purchase history and complaints history.
* Understand how drill-through preserves slicer filters (e.g., year/month).
* Practice troubleshooting why drill-through might not appear.

---

## Prerequisites & Materials

* Completed Lesson 1 with the dataset loaded (`PowerBI_DrillThrough_Dataset.xlsx`).
* Relationships already in place (Customers ↔ SalesTransactions, Complaints ↔ SalesTransactions).
* Measures from Lesson 1 already created (`Total Sales`, `Total Quantity`, `Distinct Customers`, etc.).

---

# Step-by-Step Class Script

---

### Part A — Create the **Customer Overview** page

1. **Add a new page** and rename it `Customer Overview`.
2. **Visuals to add**:

   * **Table or Matrix**:

     * Columns: `Customers[Name]`, `Customers[City]`, `Customers[LoyaltyTier]`.
     * Values: `[Total Sales]`, `[Total Quantity]`.
     * Sort by `[Total Sales]` descending.
   * **Donut Chart**:

     * Legend: `Customers[LoyaltyTier]`.
     * Values: `[Total Sales]`.
     * This shows sales contribution by loyalty tier (Gold, Silver, etc.).
   * **Bar Chart**:

     * Axis: `Customers[City]`.
     * Values: `[Total Sales]`.
     * Optional: highlight regional distribution of customers.
3. **Slicers**:

   * Add `Calendar[Year]` and `Calendar[MonthName]`.
   * Explain that filters selected here should carry over when drilling into the customer detail page.

💡 *Teaching moment:* This page acts as a **hub** to spot top customers and explore their individual records.

---

### Part B — Create the **Customer Details Drill-through** page

1. **Add a new page** and rename it `Customer Details`.
2. **Add Drill-through field**:

   * In the Filters pane (on this page), drag `Customers[CustomerID]` (or `Customers[Name]`).
   * This activates drill-through for customer context.
3. **Add visuals**:

   * **Card**: Show `Customers[Name]`.

     * Use `SELECTEDVALUE(Customers[Name])` in a measure for dynamic labeling.
   * **Table: Purchase History**

     * Columns: `SalesTransactions[Date]`, `Products[ProductName]`, `[Total Quantity]`, `[SalesAmount]`, `PaymentMethod`.
     * Sort by Date descending.
   * **Table: Complaints History**

     * Columns: `Complaints[IssueType]`, `Complaints[ResolutionTime (days)]`, `Complaints[Status]`.
     * This links customers to their product issues.
   * **Card (Loyalty Tier)**: Show `Customers[LoyaltyTier]` dynamically.
   * **Card (Lifetime Sales)**: Measure `[Total Sales]` filtered by selected customer.
4. **Add a Back Button**: Insert → Button → Back. Position at the top left.
5. **Dynamic Page Title** (Optional, recommended):

   * Measure:

     ```dax
     Customer Page Title = 
     "Customer Details — " & SELECTEDVALUE(Customers[Name], "No Customer Selected")
     ```
   * Use it in a text box title via “fx → Format by → Field value”.

---

### Part C — Demo: Drill Through in Action

1. On **Customer Overview** page, right-click any row in the table (e.g., John Smith).
2. Select **Drill through → Customer Details**.
3. Verify:

   * Customer name card updates to “John Smith”.
   * Purchase history shows only John Smith’s transactions.
   * Complaints history shows only his complaints (if any).
   * Loyalty Tier card shows his tier (e.g., Gold).
4. Click **Back** button to return to overview.

---

### Part D — Exercises for Students

#### **Exercise 1 (Basic)**

* Drill through to a customer. Confirm that `[Total Sales]` on Customer Details equals the same row’s `[Total Sales]` in Customer Overview.

#### **Exercise 2 (Purchase History)**

* Add a line chart of **Customer’s Total Sales Over Time** (axis = `Calendar[Date]`, values = `[Total Sales]`).
* Check that it changes when drilling into different customers.

#### **Exercise 3 (Filter Context)**

* Apply a slicer filter (e.g., Year = 2025).
* Drill into a customer and confirm that only transactions from 2025 appear.

#### **Exercise 4 (Complaints Focus)**

* Drill into customers with complaints (check Complaints table first).
* Verify that their complaints appear on the Customer Details page.

---

### Part E — Troubleshooting Notes

* **Drill-through option missing**:

  * Ensure `CustomerID` or `CustomerName` was added to the drill-through filters.
  * Source visual must contain the same field used for drill-through (e.g., `Customers[Name]`).
* **Wrong customer details shown**:

  * Make sure you clicked on a specific row/point (not an aggregated total).
* **Complaints not appearing**:

  * Check the relationship between Complaints and SalesTransactions.
  * Ensure Complaints uses the same `CustomerID` or TransactionID correctly linked.

---

### Assessment (Quick Quiz)

1. What field must be added to the Drill-through filters to create a Customer Details page?
   *Answer: Customers[CustomerID] or Customers[Name].*

2. How do you ensure filters (like Year) are carried into the drill-through page?
   *Answer: Drill-through keeps all filter context by default unless explicitly disabled.*

3. Why might a drill-through not appear on a Donut Chart by LoyaltyTier?
   *Answer: Because the drill-through field is CustomerID/Name, not LoyaltyTier.*

---

### Teacher Demo Script (Live)

* *“Now we want to move from customers as totals… into customers as individuals.”*
* *“I’ll right-click Mary Johnson → Drill through → Customer Details. Notice how her purchase history and complaints are now visible.”*
* *“When I switch the Year slicer to 2024, the drill-through respects that context.”*

---

✅ **End of Lesson 2**: Students now have both a **Product Drill-through page** (Lesson 1) and a **Customer Drill-through page** (Lesson 2).

---