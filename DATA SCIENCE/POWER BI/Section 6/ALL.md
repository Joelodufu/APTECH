# **The ALL Function in Power BI DAX**

---

## **1 Concept**

The **ALL function** removes filters from a column or table.
It’s often used for:

- **Ignoring filters** (e.g., slicers or visual-level filters).
- **Calculating percentages of total**.
- **Rankings and comparisons**.

**Syntax:**

```DAX
ALL ( [<tableNameOrColumnName>] )
```

---

## **2 Variants of ALL**

- **ALL(table)** → removes filters from the entire table.
- **ALL(column)** → removes filters from a specific column.
- **ALLEXCEPT(table, column1, …)** → removes filters on all columns _except_ those specified.
- **ALLSELECTED(column/table)** → respects selections in visuals but removes row-level filters.

---

## **3 Practical Examples with `AdvancedDAX_SalesData.csv`**

### **Example 1: % of Total Sales (Ignoring Filters)**

```DAX
% of Total Sales :=
DIVIDE(
    SUM(Sales[SalesAmount]),
    CALCULATE(SUM(Sales[SalesAmount]), ALL(Sales))
)
```

- Each row shows its **sales contribution vs total sales**, regardless of slicers.

---

### **Example 2: Rank Products by Sales**

```DAX
Product Sales Rank :=
RANKX(
    ALL(Sales[Product]),
    SUM(Sales[SalesAmount]),
    ,
    DESC
)
```

- Ranks all products globally, not just within filtered selections.

---

### **Example 3: Category % Contribution**

```DAX
Category % of Total :=
DIVIDE(
    SUM(Sales[SalesAmount]),
    CALCULATE(SUM(Sales[SalesAmount]), ALL(Sales[Category]))
)
```

- Each category’s sales as a % of **all categories**.

---

### **Example 4: Preserve Category While Ignoring Product Filter**

```DAX
Category Total Sales :=
CALCULATE(
    SUM(Sales[SalesAmount]),
    ALLEXCEPT(Sales, Sales[Category])
)
```

- Keeps the **Category context** but ignores slicers/filters on `Product`.

---

### **Example 5: ALLSELECTED with Visual Context**

```DAX
% of Selected Total Sales :=
DIVIDE(
    SUM(Sales[SalesAmount]),
    CALCULATE(SUM(Sales[SalesAmount]), ALLSELECTED(Sales))
)
```

- Shows % of total sales relative to the **currently selected visual scope**.

---

## **4 Exercises (Hands-On)**

1. Create a measure that calculates **total profit ignoring all filters**.
2. Create a measure that calculates **rank of each Category by sales**.
3. Create a measure that calculates **% of total sales for Accessories**, ignoring slicers.
4. Create a measure that calculates **Category total sales while keeping the Category filter active**.
5. Create a measure that calculates **% of selected sales** (like Example 5).

---

## **5 Exercise Answers (Trainer’s Guide)**

1. **Total Profit (Ignore Filters)**

```DAX
Total Profit (Ignore Filters) :=
CALCULATE(
    SUM(Sales[Profit]),
    ALL(Sales)
)
```

2. **Category Sales Rank**

```DAX
Category Sales Rank :=
RANKX(
    ALL(Sales[Category]),
    SUM(Sales[SalesAmount]),
    ,
    DESC
)
```

3. **Accessories % of Total Sales**

```DAX
Accessories % of Total :=
DIVIDE(
    CALCULATE(SUM(Sales[SalesAmount]), Sales[Category] = "Accessories"),
    CALCULATE(SUM(Sales[SalesAmount]), ALL(Sales))
)
```

4. **Category Total Sales (Preserve Category)**

```DAX
Category Total Sales :=
CALCULATE(
    SUM(Sales[SalesAmount]),
    ALLEXCEPT(Sales, Sales[Category])
)
```

5. **% of Selected Sales**

```DAX
% of Selected Sales :=
DIVIDE(
    SUM(Sales[SalesAmount]),
    CALCULATE(SUM(Sales[SalesAmount]), ALLSELECTED(Sales))
)
```

---

## **6 Key Takeaways**

- **ALL** removes filters, useful for **totals, percentages, and rankings**.
- **ALLEXCEPT** is great for **subtotals by category**.
- **ALLSELECTED** helps in **visuals where user selections matter**.
- Often combined with **CALCULATE** and **RANKX** for advanced analytics.

---

⚡ Tip for teaching:

- Use a **bar chart by Category** and add both `% of Total Sales` and `% of Selected Sales` → learners will see the difference between **ALL** vs **ALLSELECTED** in action.

---
