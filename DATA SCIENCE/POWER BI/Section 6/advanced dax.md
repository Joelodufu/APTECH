Perfect 👍. Thanks for sharing the learning objectives and the sample dataset (`Switchdata.xlsx`). Here’s how we can approach **Advanced DAX in Power BI**, step by step, using your objectives and dataset.

---

## 📘 Session Plan (based on your Learning Objectives)

### 1. **Define Complex DAX functions**

- **DAX (Data Analysis Expressions)** is the formula language in Power BI, Power Pivot, and SSAS Tabular models.
- Complex DAX means going beyond basic aggregations (SUM, AVERAGE) and building calculations that combine **filters, conditions, iterations, and context transitions**.

---

### 2. **Explain Conditional and Logical operations**

- DAX provides:

  - `IF(condition, result_if_true, result_if_false)`
  - `AND(condition1, condition2)`
  - `OR(condition1, condition2)`
  - `NOT(condition)`

📌 Example:

```DAX
Sales Category =
IF(Sales[Amount] > 5000, "High", "Low")
```

---

### 3. **Elaborate SWITCH function**

- `SWITCH` is used for multiple conditions (like `CASE` in SQL).

📌 Example with your dataset:

```DAX
Performance =
SWITCH(
    TRUE(),
    Sales[Amount] >= 10000, "Excellent",
    Sales[Amount] >= 5000, "Good",
    Sales[Amount] >= 2000, "Average",
    "Poor"
)
```

This avoids nested `IF`.

---

### 4. **Classify common text functions**

- `LEFT`, `RIGHT`, `MID`, `CONCATENATE`, `UPPER`, `LOWER`, `SEARCH`, `REPLACE`, etc.

📌 Example:

```DAX
Customer Initials = LEFT(Sales[CustomerName],1) & RIGHT(Sales[CustomerName],1)
```

---

### 5. **Describe basic date and time functions**

- `TODAY()`, `NOW()`, `YEAR()`, `MONTH()`, `WEEKDAY()`, `DATEDIFF()`.

📌 Example:

```DAX
Days Taken = DATEDIFF(Sales[OrderDate], Sales[DeliveryDate], DAY)
```

---

### 6. **Describe CALCULATE function**

- `CALCULATE` changes the filter context.
- It is the **most powerful function in DAX**.

📌 Example:

```DAX
Total Sales Last Year =
CALCULATE(
    SUM(Sales[Amount]),
    YEAR(Sales[OrderDate]) = YEAR(TODAY())-1
)
```

---

### 7. **Describe ALL function**

- Removes filters from a column or table.
  📌 Example:

```DAX
% of Total Sales =
DIVIDE(
    SUM(Sales[Amount]),
    CALCULATE(SUM(Sales[Amount]), ALL(Sales))
)
```

---

### 8. **Describe Iterator functions**

- Iterators work row by row: `SUMX`, `AVERAGEX`, `FILTER`, etc.
  📌 Example:

```DAX
Profit Margin =
SUMX(
    Sales,
    Sales[Amount] - Sales[Cost]
) / SUM(Sales[Amount])
```

---
****