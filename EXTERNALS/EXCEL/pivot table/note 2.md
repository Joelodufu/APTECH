# 📘 PIVOT TABLES TRAINING COURSE

**Module 2: Pivot Table Layout and Customization**
_Dataset:_ Sample – Superstore (Kaggle)
_Software:_ Microsoft Excel (or Google Sheets)

---

## 🎯 CLASS OBJECTIVES

At the end of this module, students will be able to:

1. Modify and rearrange fields in a Pivot Table to change perspectives.
2. Apply various Pivot Table layouts (Compact, Outline, and Tabular).
3. Show or hide subtotals and grand totals.
4. Sort and filter Pivot Table results effectively.
5. Format numeric data properly (currency, percentages, etc.).
6. Enhance readability using conditional formatting.
7. Design Pivot Tables that look professional and presentation-ready.

---

## 🧩 WHY THIS MODULE MATTERS

A well-built Pivot Table is only as good as how clearly it communicates insights.
In real business reports:

- Managers want _clean summaries_, not cluttered data dumps.
- Analysts want _quick sort/filter capabilities_.
- Presenters want _professional layouts_ that can be printed or copied into PowerPoint.

This module helps you transform a raw pivot into a polished, interactive report.

---

## 🧮 RECAP FROM MODULE 1

In the last class, we created basic pivot tables such as:

- **Sales by Region**
- **Profit by Category**
- **Count of Orders by Region**

We learned how to drag fields into Rows, Columns, Values, and Filters.
Now we’ll improve those tables’ **appearance, organization, and usability**.

---

## 🧱 TOPICS OVERVIEW

1. Rearranging and swapping fields
2. Choosing layout formats (Compact, Outline, Tabular)
3. Managing subtotals and grand totals
4. Sorting and filtering results
5. Formatting values (currency, decimals, percentages)
6. Applying conditional formatting
7. Adding report titles and custom names
8. Professional report design

---

## 🧩 1. Rearranging and Swapping Fields

### Example 1 — Sales by _Category_ and _Region_

**Steps**

1. Insert a new Pivot Table.
2. Drag:

   - _Category_ → Rows
   - _Region_ → Columns
   - _Sales_ → Values

3. Observe the layout — each category shows sales across all regions.

Now, **swap the positions**:

- Drag _Category_ to Columns and _Region_ to Rows.

👉 Instantly, the view changes — now it’s “Sales by Region and Category.”

**Real-life analogy:**
Swapping fields is like looking at your data from another angle — region-first or category-first.

---

## 🧩 2. Layout Formats (Compact, Outline, Tabular)

Go to:
`PivotTable Analyze → Design → Report Layout`

| Layout                     | Description                                                  | When to Use                           |
| -------------------------- | ------------------------------------------------------------ | ------------------------------------- |
| **Compact Form (Default)** | Combines fields in one column with indentation.              | Quick summaries, saves space.         |
| **Outline Form**           | Each field in a separate column.                             | Clear hierarchy (good for reports).   |
| **Tabular Form**           | Similar to Outline, but shows field headers for each column. | Best for exporting and data analysis. |

### Example 2 — Switch Layouts

Using “Sales by Region and Category,” test each layout:

- Compact → Outline → Tabular
  Observe how data alignment and readability change.

### Tip:

For professional reporting, **Tabular Form** is often preferred (easy to read, copy, or print).

---

## 🧩 3. Subtotals and Grand Totals

### Steps

1. Click any cell in your Pivot Table.
2. Go to `Design → Subtotals` → Choose:

   - “Do Not Show Subtotals”
   - “Show All Subtotals at Bottom”

3. For Grand Totals:

   - `Design → Grand Totals → On for Rows and Columns / Off`

**Example 3 — Disable Subtotals**

- Use “Sales by Category and Sub-Category.”
- Disable subtotals for Category to make data less cluttered.

**Business Use Case:**
When presenting _detailed category breakdowns_, hiding subtotals prevents double-counting and simplifies visuals.

---

## 🧩 4. Sorting and Filtering Pivot Tables

### Sorting

Right-click any value → Sort → Largest to Smallest (or vice versa).

**Example 4 — Top Performing Regions**

- Pivot: Region → Rows, Sales → Values.
- Sort descending by Sales to see top regions.

### Filtering

- Drag a field (e.g., “Segment”) to the **Filters** area.
- Select only “Consumer” or “Corporate.”

### Real-Life Application:

Marketing may filter sales reports by _Customer Segment_ to plan targeted campaigns.

---

## 🧩 5. Formatting Numbers and Values

### Steps

1. Right-click any numeric value → _Number Format_ → Choose:

   - **Currency** (for Sales, Profit)
   - **Number (2 decimals)** (for Quantity)
   - **Percentage** (for calculated metrics)

2. Avoid using “Cell Format” — use _Value Field Settings → Number Format_ for consistent results.

**Tip:** Use `$#,##0.00` to make financial reports neat and professional.

---

## 🧩 6. Conditional Formatting (Data Highlights)

### Example 5 — Profit Hotspots

1. Pivot: Region → Rows; Category → Columns; Profit → Values.
2. Select profit values.
3. Go to `Home → Conditional Formatting → Data Bars / Color Scales`.

   - Green for high profit, red for low profit.

**Result:**
Instant heat map of profitability across regions and categories.

**Real-life Application:**
A regional manager can instantly identify low-profit areas.

---

## 🧩 7. Renaming Fields and Adding Titles

### Example 6

- Rename “Sum of Sales” to **Total Sales ($)**
  → _Value Field Settings → Custom Name_
- Add a report title above the Pivot Table:
  e.g., “Regional Sales Summary — 2025 Q1”

**Tip:** Titles make reports self-explanatory when exported or printed.

---

## 🧩 8. Report Design & Professional Presentation

Explore `Design` tab options:

- **PivotTable Style Options:**

  - Banded Rows / Columns for readability.
  - Header Row highlighted.

- **PivotTable Styles gallery:**
  Choose a clean, professional template (light gray, blue, or white).

**Optional:**
Insert company logo above report → align center → print preview.

---

## 🧮 APPLIED EXAMPLE (Instructor-led)

### Objective

Create a well-formatted pivot showing:

- _Total Sales_ by _Region_ and _Category_
- Sorted descending by total
- Formatted as currency
- Clean layout (Tabular, no subtotals)
- With conditional formatting to highlight top profits

**Steps**

1. Insert Pivot → Rows: Region → Columns: Category → Values: Sales.
2. Layout: _Tabular Form_.
3. Subtotals: _None_.
4. Number Format: _Currency (0 decimals)_.
5. Sort: Descending by Grand Total.
6. Apply Conditional Formatting: _Data Bars (Blue)_.
7. Add Title: “Total Sales by Region and Category”.

**Result Table Example:**

| Region  | Furniture | Office Supplies | Technology | Grand Total |
| ------- | --------: | --------------: | ---------: | ----------: |
| West    |   220,870 |         197,212 |    307,376 | **725,457** |
| East    |   193,707 |         204,120 |    280,953 | **678,781** |
| Central |   145,221 |         165,550 |    190,468 | **501,239** |
| South   |   105,913 |         145,398 |    140,410 | **391,721** |

---

## ✍️ CLASSWORK (Student Practice)

### Task 1 — Clean & Format a Pivot

Create a pivot showing **Profit by Category and Region**, and:

- Apply **Outline Form**
- Disable subtotals
- Format numbers in currency
- Sort descending by Total Profit

**Question:** Which category shows the highest total profit overall?

---

### Task 2 — Filtering & Highlighting

Using the same pivot:

- Add _Segment_ to Filters
- Filter only _Corporate_ customers
- Apply **Conditional Formatting (Color Scale)** to Profit cells
- Observe profit performance across regions

**Question:** Which region’s Corporate customers yield the highest profit?

---

### Task 3 — Visual Formatting

Using “Sales by Category and Sub-Category,” apply:

- **Tabular Form**
- Banded rows
- Custom name for Value field → “Total Sales ($)”
- Add a report title above the pivot
- Save worksheet as: _Module2_LayoutDesign_

---

## 🧠 DISCUSSION QUESTIONS

1. Why might managers prefer Outline or Tabular layouts for presentation?
2. How does conditional formatting add business value to pivot reports?
3. What best practices help make pivot reports universally readable?

---

## 💡 KEY TAKEAWAYS

| Feature                      | Use                                                 |
| ---------------------------- | --------------------------------------------------- |
| **Compact Form**             | Save space, default layout.                         |
| **Outline / Tabular Form**   | Clear hierarchy, printable reports.                 |
| **Subtotals & Grand Totals** | Summarize categories concisely.                     |
| **Sorting/Filtering**        | Focus on top performers or subsets.                 |
| **Formatting**               | Improves clarity, readability, and professionalism. |
| **Conditional Formatting**   | Adds visual insights (heat maps).                   |

---

## 🧾 HOMEWORK

Create a pivot showing:

- **Sales by Region and Segment**
- Format as currency
- Sort descending by Region total
- Apply light green data bars
- Save as _Homework_Module2.xlsx_

---

## 📈 PREVIEW OF NEXT MODULE

**Module 3: Aggregations and Calculations**
You’ll learn how to:

- Use different aggregation functions (Sum, Count, Average, Max, Min).
- Show values as % of total, % difference, and running totals.
- Create Calculated Fields (e.g., Profit Margin = Profit / Sales).
- Add meaningful metrics beyond the base dataset.

---
