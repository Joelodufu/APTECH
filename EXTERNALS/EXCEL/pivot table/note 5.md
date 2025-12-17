# 🧩 **Module 5: Grouping and Hierarchies in Pivot Tables**

---

## 🎯 **Class Objectives**

By the end of this module, students will be able to:

1. Understand the concept of grouping in Pivot Tables and when to use it.
2. Group **dates**, **numbers**, and **text (manual groups)** to make reports clearer.
3. Create **hierarchies** in Pivot Tables (e.g., Category → Sub-Category → Product).
4. Apply grouping for **comparative and trend analysis** (e.g., quarterly or yearly sales).
5. Learn how to manage, ungroup, and reorganize data levels efficiently.

---

## 🧠 **Concept Overview**

### What is Grouping in Pivot Tables?

Grouping means combining multiple data entries into **logical categories or intervals** to make summaries easier to analyze.

For example:

- Instead of viewing **daily sales**, group them by **Month or Quarter**.
- Instead of seeing all **individual product prices**, group them into **price ranges (₦0–₦50k, ₦50k–₦100k, etc.)**.
- Instead of listing all **customer segments**, group similar ones manually (e.g., “Corporate + Home Office” → “Business Clients”).

---

## 🧩 **Types of Grouping**

### 1️⃣ **Grouping by Dates**

Excel can automatically group dates into:

- **Days**
- **Months**
- **Quarters**
- **Years**

🧭 _Real-life Example:_
A supermarket manager wants to track total sales **per quarter and year** to see business trends.

**Steps:**

1. Select any **date field** (e.g., `Order Date`).
2. Drag it to the **Rows area** of the Pivot Table.
3. Right-click on one of the date cells → **Group**.
4. In the dialog box, select: `Months`, `Quarters`, and `Years`.
5. Click **OK**.

**Result:**
You now have a Pivot Table structured like this:

| Years | Quarters | Total Sales |
| ----- | -------- | ----------- |
| 2020  | Q1       | ₦540,000    |
|       | Q2       | ₦620,000    |
|       | Q3       | ₦690,000    |
|       | Q4       | ₦710,000    |
| 2021  | Q1       | ₦760,000    |

**Observation:** You can expand or collapse each year to see details.

---

### 2️⃣ **Grouping by Numbers**

Used when the field is numeric, such as **Sales**, **Quantity**, or **Profit**.

🧭 _Real-life Example:_
A sales analyst wants to group customers based on how much they spend:

- ₦0–₦50,000
- ₦50,001–₦100,000
- ₦100,001–₦150,000, etc.

**Steps:**

1. Drag `Sales` to the **Rows** area.
2. Right-click on any sales number → **Group**.
3. Set:

   - **Starting at:** 0
   - **Ending at:** 150,000
   - **By:** 50,000

4. Click **OK**.

**Result:**

| Sales Range     | Count of Orders |
| --------------- | --------------- |
| 0–50,000        | 320             |
| 50,001–100,000  | 210             |
| 100,001–150,000 | 75              |

This shows the **frequency of orders by sales amount range** — a valuable insight for pricing and customer segmentation.

---

### 3️⃣ **Grouping by Text (Manual Grouping)**

Used to combine text-based categories manually.

🧭 _Example:_
The company wants to compare **Technology vs Non-Technology** sales.

**Steps:**

1. In your Pivot Table, drag `Category` to the **Rows area**.
2. Select the items **Furniture** and **Office Supplies**.
3. Right-click → **Group**.
4. Rename the new group as `Non-Technology`.
5. Rename `Technology` as `Technology`.

**Result:**

| Group          | Total Sales |
| -------------- | ----------- |
| Non-Technology | ₦1,200,000  |
| Technology     | ₦830,000    |

Now you can compare broader business segments.

---

## 🧩 **Creating Hierarchies in Pivot Tables**

### What is a Hierarchy?

A **hierarchy** organizes fields in **levels of detail**.
It allows you to “drill down” or “roll up” data for multi-level insights.

🧭 _Example Hierarchy:_
**Region → State → City → Customer Name**

**Steps:**

1. Drag `Region` → Rows.
2. Then drag `State` → below Region.
3. Then drag `City` → below State.
4. Then drag `Sales` → Values.

Now you can expand/collapse each region to explore details down to city level.

**Example Output:**

| Region | State        | City        | Total Sales |
| ------ | ------------ | ----------- | ----------- |
| West   | California   | Los Angeles | ₦450,000    |
|        |              | San Diego   | ₦210,000    |
| East   | New York     | New York    | ₦320,000    |
|        | Pennsylvania | Pittsburgh  | ₦150,000    |

💡 _Tip:_ To make reports intuitive, use indentation levels and sorting for readability.

---

## ⚙️ **Ungrouping and Managing Groups**

To **ungroup**:

- Right-click on the grouped field → **Ungroup**.

To rename a group:

- Select the group name → Click inside the formula bar → Type the new name → Press **Enter**.

To collapse or expand hierarchy:

- Click the **+ or –** icons beside each group.

---

## 🧭 **Real-Life Scenarios**

| Industry  | Use Case                                    | Benefit                      |
| --------- | ------------------------------------------- | ---------------------------- |
| Retail    | Group sales by quarter and product category | Identify seasonal trends     |
| Education | Group students by score ranges              | Visualize grade distribution |
| HR        | Group employees by age or experience        | Analyze workforce structure  |
| Finance   | Group transactions by month and amount      | Detect patterns or anomalies |
| Logistics | Group deliveries by route and city          | Optimize delivery frequency  |

---

## 🧪 **Applied Example**

**Scenario:**
The store’s manager wants to analyze _quarterly sales by region_ to prepare for next year’s planning.

**Steps:**

1. Insert a Pivot Table using the `Orders` table.
2. Drag `Order Date` → Rows, then **group by Quarters and Years**.
3. Drag `Region` → Columns.
4. Drag `Sales` → Values.
5. Apply **Number Formatting (Currency)**.

**Result Table:**

| Year | Quarter | East     | West     | South   | Central  |
| ---- | ------- | -------- | -------- | ------- | -------- |
| 2020 | Q1      | ₦95,000  | ₦102,000 | ₦80,000 | ₦90,000  |
|      | Q2      | ₦105,000 | ₦115,000 | ₦89,000 | ₦96,000  |
| 2021 | Q1      | ₦98,000  | ₦125,000 | ₦92,000 | ₦110,000 |

**Observation:**
West region shows consistent growth — plan higher inventory allocation for that zone.

---

## 🧑🏽‍🏫 **Class Work**

**Task:**

1. Create a Pivot Table showing `Sales` grouped by **Customer Segment** and **Order Date (by Month)**.
2. Then, **group all months into Quarters**.
3. Add `Category` as a Column field to compare segment-wise sales by quarter.
4. Finally, use **manual grouping** to merge `Corporate` and `Home Office` into one group named “Business Clients.”

**Expected Skills:**
✅ Date grouping
✅ Manual text grouping
✅ Hierarchy creation
✅ Analysis interpretation

---

## 💡 **Key Takeaways**

- Grouping simplifies large datasets for better comparison and trend detection.
- Hierarchies help you navigate multiple levels of data.
- Manual groups are flexible — use them for strategic segment combinations.
- Always check grouped data for logical consistency (e.g., correct date range).

---
