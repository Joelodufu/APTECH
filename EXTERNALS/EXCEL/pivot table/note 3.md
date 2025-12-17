This module builds directly on what we covered in Module 2 (layout, sorting, and formatting) and dives into the _analytical heart_ of Pivot Tables — **data summarization, calculations, and custom metrics**.

---

# 📘 PIVOT TABLE TRAINING COURSE

**Module 3: Aggregations and Calculations in Pivot Tables**
_Dataset:_ Sample – Superstore (Kaggle)
_Software:_ Microsoft Excel (or Google Sheets)

---

## 🎯 CLASS OBJECTIVES

By the end of this module, learners should be able to:

1. Use built-in **aggregation functions** (Sum, Count, Average, Max, Min, etc.) in Pivot Tables.
2. Show Pivot Table values as **percentages**, **rankings**, and **differences**.
3. Understand **“Show Values As”** options like % of Row Total, % of Column Total, and Running Totals.
4. Create **Calculated Fields and Calculated Items** (e.g., Profit Margin, Sales per Order).
5. Interpret data using **aggregated and derived metrics** for business insights.
6. Apply these concepts in **real-life business reporting** and **scenario analysis**.

---

## 🧩 WHY THIS MODULE IS IMPORTANT

Pivot Tables don’t just summarize data — they can analyze performance trends, compute profitability, and reveal efficiency metrics that would otherwise require complex formulas.
This module transforms a Pivot Table from a _data summary tool_ into a _business intelligence dashboard._

**In the real world:**

- A sales manager calculates _profit margin per region_.
- A finance analyst shows _sales growth compared to last quarter._
- A marketer identifies _top 10% performing products_ by revenue share.

---

## 🧱 TOPICS OVERVIEW

1. Built-in aggregation functions
2. “Show Values As” (percentage, difference, rank, running total)
3. Calculated fields and items
4. Combining calculations for business insights
5. Applied example: Profit Margin & Share of Sales
6. Classwork: Hands-on calculation reports

---

## 🧩 1. AGGREGATION FUNCTIONS IN VALUES AREA

When you drag a numeric field into the **Values** area, Excel defaults to **Sum**.
You can change it to other aggregation types via:

**Right-click → Summarize Values By → Choose Function**

| Function           | Description                                       | Example                      |
| ------------------ | ------------------------------------------------- | ---------------------------- |
| **Sum**            | Adds up all values.                               | Total Sales per Region       |
| **Count**          | Counts number of entries.                         | Number of Orders             |
| **Average**        | Computes mean value.                              | Average Discount per Segment |
| **Max / Min**      | Shows highest or lowest value.                    | Highest Profit in a Region   |
| **Product**        | Multiplies all values (rare).                     | –                            |
| **Distinct Count** | Counts unique entries (available in newer Excel). | Number of Unique Customers   |

---

### Example 1 — Total & Average Sales by Region

**Steps**

1. Insert a Pivot Table.
2. Drag _Region_ → Rows, _Sales_ → Values (shows Sum by default).
3. Drag _Sales_ again → Values → Change to _Average_.
4. Rename as “Average Sales.”

**Result Example:**

| Region  | Total Sales | Average Sales |
| ------- | ----------: | ------------: |
| Central |     501,239 |           457 |
| East    |     678,781 |           482 |
| South   |     391,721 |           505 |
| West    |     725,457 |           523 |

**Business Insight:**
The West region not only has the highest total sales but also the highest average sale per transaction — meaning higher-value customers or larger orders.

---

## 🧩 2. "SHOW VALUES AS" OPTIONS

Excel can express the same numbers in _different analytical perspectives._

**Right-click on a value → Show Values As → Choose Option**

| Option                                             | Meaning                          | Example                               |
| -------------------------------------------------- | -------------------------------- | ------------------------------------- |
| **% of Grand Total**                               | Value ÷ Overall Total × 100      | Each Region’s % of total sales        |
| **% of Row Total**                                 | Value ÷ Row Total × 100          | Each Category’s share within Region   |
| **% of Column Total**                              | Value ÷ Column Total × 100       | Each Region’s share for each Category |
| **% Difference From**                              | Compares against a base value    | Sales difference vs. previous Region  |
| **Running Total In**                               | Adds up cumulatively across rows | Year-to-date or region-to-date total  |
| **Rank Smallest to Largest / Largest to Smallest** | Ranks values                     | Rank of regions by sales              |

---

### Example 2 — Sales as % of Grand Total

**Steps**

1. Region → Rows; Sales → Values.
2. Right-click Sales → _Show Values As → % of Grand Total_.

**Result Example:**

| Region  | % of Total Sales |
| ------- | ---------------: |
| West    |            32.1% |
| East    |            30.1% |
| Central |            23.2% |
| South   |            14.6% |

**Insight:**
West contributes nearly one-third of company-wide sales.

---

### Example 3 — % of Row Total

**Objective:** See what share each _Category_ contributes within a _Region_.

1. Region → Rows; Category → Columns; Sales → Values.
2. Show Values As → % of Row Total.

Now each row adds up to 100%, showing composition by product category per region.

**Real-Life Use:**
Managers can quickly see whether a region is technology-driven or office-supply-heavy.

---

### Example 4 — Running Total

To show _cumulative sales_ across Regions or Months:

1. Order Date (grouped by Month) → Rows.
2. Sales → Values.
3. Show Values As → Running Total In → Base Field = Month.

**Insight:**
You can visualize how sales accumulate throughout the year.

---

## 🧩 3. CALCULATED FIELDS AND CALCULATED ITEMS

Pivot Tables can perform new calculations beyond the raw dataset.

---

### 🔹 CALCULATED FIELD

A formula that uses existing fields.

**Path:**
`PivotTable Analyze → Fields, Items & Sets → Calculated Field`

**Example 5 — Profit Margin**
Formula:

```
= Profit / Sales
```

**Steps**

1. Insert Pivot → Region → Rows, Profit → Values, Sales → Values.
2. Go to `PivotTable Analyze → Fields, Items & Sets → Calculated Field`.
3. Name: _Profit Margin_, Formula: `=Profit/Sales`.
4. Format result as _Percentage (2 decimals)_.

**Result Example:**

| Region  |   Sales |  Profit | Profit Margin |
| ------- | ------: | ------: | ------------: |
| Central | 501,239 |  66,700 |        13.31% |
| East    | 678,781 |  91,470 |        13.48% |
| South   | 391,721 |  45,560 |        11.63% |
| West    | 725,457 | 110,890 |        15.28% |

**Business Insight:**
The West has the best profitability despite similar sales — perhaps due to better pricing or lower discounts.

---

### 🔹 CALCULATED ITEM

A formula between _items_ within a single field.

**Example 6 — Furniture & Technology Combo Sales**
Formula:

```
= 'Furniture' + 'Technology'
```

**Steps**

1. Category → Rows; Sales → Values.
2. Create Calculated Item → Name: _Furn+Tech_, Formula as above.

**Result:**
New virtual category combining sales of Furniture and Technology.

**Use Case:**
Useful for combining or comparing categories without editing the source data.

---

## 🧩 4. COMBINING CALCULATIONS FOR BUSINESS INSIGHTS

| Report Type          | Combination Example             | Insight                                        |
| -------------------- | ------------------------------- | ---------------------------------------------- |
| Profit Analysis      | Profit Margin + Rank by Profit  | Rank top-performing regions.                   |
| Category Composition | % of Row Total + Sum of Sales   | Show product mix per region.                   |
| Time Trend           | Running Total + % Difference    | Show growth over time.                         |
| Order Efficiency     | Average Sales + Count of Orders | Identify regions with fewer but larger orders. |

---

## 🧮 APPLIED EXAMPLE (Instructor-Led)

### Objective:

Build a pivot showing **Sales, Profit, and Profit Margin by Region and Category** with percentage contributions.

**Steps**

1. Insert Pivot Table.
2. Rows → Region; Columns → Category.
3. Values → Sales, Profit.
4. Add Calculated Field → `Profit Margin = Profit / Sales`.
5. Add another _Sales_ value field → Show Values As → % of Grand Total.
6. Format Profit Margin as % and Sales as currency.

**Result Example:**

| Region  |      Furniture | Office Supplies |     Technology | Total Profit Margin |
| ------- | -------------: | --------------: | -------------: | ------------------: |
| West    | $220,870 (32%) |  $197,212 (28%) | $307,376 (40%) |              15.28% |
| East    | $193,707 (29%) |  $204,120 (30%) | $280,953 (41%) |              13.48% |
| Central | $145,221 (29%) |  $165,550 (33%) | $190,468 (38%) |              13.31% |
| South   | $105,913 (27%) |  $145,398 (37%) | $140,410 (36%) |              11.63% |

**Interpretation:**

- Technology dominates sales share in all regions.
- West performs best in profitability.
- South lags behind in both volume and efficiency.

---

## ✍️ CLASSWORK (Student Practice)

### Task 1 — Calculate Average Profit by Segment

Create a pivot showing:

- Rows: Segment
- Values: Profit (Summarize by Average)
- Format as currency
- Rank segments by average profit (Show Values As → Rank Largest to Smallest)

**Question:** Which segment yields the highest average profit?

---

### Task 2 — Profit Margin by Category

Create a pivot:

- Rows: Category
- Values: Profit, Sales
- Add Calculated Field → `Profit Margin = Profit/Sales`
- Format as percentage
- Sort descending by Profit Margin

**Question:** Which category has the best margin?

---

### Task 3 — Running Total by Month

Create a pivot:

- Rows: Order Date (grouped by Month)
- Values: Sales
- Show Values As → Running Total in Month
- Add line chart to visualize cumulative trend.

**Question:** What is the month with the highest cumulative growth rate?

---

## 🧠 DISCUSSION QUESTIONS

1. How do “Show Values As” options change how we interpret raw data?
2. What’s the difference between a _Calculated Field_ and _Calculated Item_?
3. Why might % of Grand Total be more useful than raw numbers in some reports?

---

## 💡 KEY TAKEAWAYS

| Concept                   | Summary                                                       |
| ------------------------- | ------------------------------------------------------------- |
| **Aggregation Functions** | Summarize data using Sum, Count, Average, etc.                |
| **Show Values As**        | Express results as % totals, ranks, or running sums.          |
| **Calculated Fields**     | Create new metrics like Profit Margin.                        |
| **Calculated Items**      | Combine or compare data items dynamically.                    |
| **Insights**              | Calculations turn static tables into actionable intelligence. |

---

## 🧾 HOMEWORK

Create a pivot showing:

- **Profit Margin by Segment and Region**
- Add **Sales % of Grand Total**
- Format appropriately
- Highlight top 2 regions by margin with conditional formatting
  Save worksheet as: _Module3_Calculations.xlsx_

---

## 📈 PREVIEW OF NEXT MODULE

**Module 4: Grouping, Filtering & Drilling Down**

You’ll learn how to:

- Group data by **date**, **range**, or **category**.
- Use **Report Filters**, **Slicers**, and **Timelines** for dynamic dashboards.
- Drill down into Pivot data to uncover transaction-level details.
- Combine grouping and filtering to create interactive, management-friendly reports.

---
