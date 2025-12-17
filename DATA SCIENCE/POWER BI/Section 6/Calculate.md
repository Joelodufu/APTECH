# **The CALCULATE Function in Power BI DAX**

---

## **1 Concept**

The **CALCULATE** function is the most powerful and important DAX function.
It:

1. **Evaluates an expression** (like SUM, AVERAGE, COUNT).
2. **Modifies or overrides the filter context** with new filters.

**Syntax:**

```DAX
CALCULATE(<expression>, <filter1>, <filter2>, ...)
```

---

## **2 Why CALCULATE is Important**

- It allows **context transition** → from row context (like iterators) to filter context.
- Enables **conditional aggregations**.
- Core for **time intelligence** functions (`DATEADD`, `SAMEPERIODLASTYEAR`, etc.).
- Can combine with `FILTER()` for complex scenarios.

---

## **3 Practical Examples with `AdvancedDAX_SalesData.csv`**

### **Example 1: Total Electronics Sales**

```DAX
Total Electronics Sales :=
CALCULATE(
    SUM(Sales[SalesAmount]),
    Sales[Category] = "Electronics"
)
```

- Returns only the sales amount where `Category = Electronics`.

---

### **Example 2: Fashion Sales Last Year**

```DAX
Fashion Sales LY :=
CALCULATE(
    SUM(Sales[SalesAmount]),
    Sales[Category] = "Fashion",
    SAMEPERIODLASTYEAR(Sales[OrderDate])
)
```

- Applies **two filters**: Category = Fashion + Last Year.

---

### **Example 3: High Value Orders (> 5000)**

```DAX
High Value Orders Sales :=
CALCULATE(
    SUM(Sales[SalesAmount]),
    Sales[SalesAmount] > 5000
)
```

- Only includes transactions where sales exceed 5000.

---

### **Example 4: Profit from Discounted Sales**

```DAX
Profit from Discounted Sales :=
CALCULATE(
    SUM(Sales[Profit]),
    Sales[Discount] > 0
)
```

- Filters only sales where discount was applied.

---

### **Example 5: Using FILTER() inside CALCULATE**

```DAX
Top 3 Product Sales :=
CALCULATE(
    SUM(Sales[SalesAmount]),
    FILTER(
        Sales,
        RANKX(ALL(Sales[Product]), SUM(Sales[SalesAmount]), , DESC) <= 3
    )
)
```

- Combines CALCULATE with FILTER to find sales for **top 3 ranked products**.

---

## **4 Exercises (Hands-On)**

1. Create a measure to calculate **total profit for Electronics** only.
2. Create a measure to calculate **total sales for Accessories in 2024**.
3. Create a measure that calculates **sales for transactions with quantity ≥ 3**.
4. Create a measure that calculates **profit from non-discounted orders**.
5. Create a measure that calculates **sales for the top 2 categories by total sales**.

---

## **5 Exercise Answers (Trainer’s Guide)**

1. **Electronics Profit**

```DAX
Electronics Profit :=
CALCULATE(
    SUM(Sales[Profit]),
    Sales[Category] = "Electronics"
)
```

2. **Accessories Sales 2024**

```DAX
Accessories Sales 2024 :=
CALCULATE(
    SUM(Sales[SalesAmount]),
    Sales[Category] = "Accessories",
    YEAR(Sales[OrderDate]) = 2024
)
```

3. **Sales for Quantity ≥ 3**

```DAX
Sales Quantity 3+ :=
CALCULATE(
    SUM(Sales[SalesAmount]),
    Sales[Quantity] >= 3
)
```

4. **Profit from Non-Discounted Orders**

```DAX
Profit No Discount :=
CALCULATE(
    SUM(Sales[Profit]),
    Sales[Discount] = 0
)
```

5. **Sales for Top 2 Categories**

```DAX
Top 2 Categories Sales :=
CALCULATE(
    SUM(Sales[SalesAmount]),
    FILTER(
        ALL(Sales[Category]),
        RANKX(ALL(Sales[Category]), SUM(Sales[SalesAmount]), , DESC) <= 2
    )
)
```

---

## **6 Key Takeaways**

- **CALCULATE** is the **only function that can change filter context**.
- It works best with **measures** (not columns).
- Often combined with **FILTER**, **ALL**, and **time intelligence**.
- Mastering CALCULATE = mastering advanced DA

---
