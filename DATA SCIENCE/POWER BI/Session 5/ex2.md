## 🔹 Step 1: Load the Dataset into Power BI

1. Open **Power BI Desktop**.
2. Go to **Home > Get Data > Excel**.
3. Select the file **Totalsales.xlsx** you uploaded.
4. Load the sheet (likely contains columns such as _Date_, _Sales_, etc.) into Power BI.

---

## 🔹 Step 2: Check Your Data Model

Make sure:

- There is a **Date column** in the dataset (if not, we will need a separate **Date Table**).
- The **Sales column** represents the total sales amounts.

---

## 🔹 Step 3: Create a Date Table

If not already in the dataset:

1. Go to **Modeling > New Table** and enter:

   ```DAX
   DateTable = CALENDAR(MIN(Totalsales[Date]), MAX(Totalsales[Date]))
   ```

2. Mark this table as a **Date Table**:

   - Select `DateTable`.
   - Go to **Modeling > Mark as Date Table > choose Date column**.

3. Create a **relationship**:

   - Connect `Totalsales[Date]` to `DateTable[Date]`.

---

## 🔹 Step 4: Create Measures

### 1. **Current Year-to-Date Sales**

```DAX
Total Sales YTD =
TOTALYTD(
    SUM(Totalsales[Sales]),
    'DateTable'[Date]
)
```

### 2. **Previous Year-to-Date Sales**

```DAX
Previous Year Sales YTD =
CALCULATE(
    [Total Sales YTD],
    SAMEPERIODLASTYEAR('DateTable'[Date])
)
```

### 3. **Year-over-Year Difference**

```DAX
Sales YoY Difference =
[Total Sales YTD] - [Previous Year Sales YTD]
```

### 4. **Year-over-Year Growth %**

```DAX
Sales YoY Growth % =
DIVIDE([Sales YoY Difference], [Previous Year Sales YTD], 0)
```

---

## 🔹 Step 5: Visualize in Power BI

1. Insert a **Table or Card Visual**.
2. Add:

   - `Total Sales YTD`
   - `Previous Year Sales YTD`
   - `Sales YoY Difference`
   - `Sales YoY Growth %`

3. Insert a **Line Chart**:

   - Axis → `DateTable[Date]`
   - Values → `Total Sales YTD` and `Previous Year Sales YTD`

This will give you a **side-by-side comparison** of sales for the current year vs previous year.

---
