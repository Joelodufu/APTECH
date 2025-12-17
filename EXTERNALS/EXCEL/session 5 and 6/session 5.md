
# 📘 **SESSION 5: Summarizing Data Using Functions**

---

## 🎯 **Learning Objectives**

By the end of this session, students will be able to:

1. Apply mathematical and trigonometric functions to manipulate and transform data in Excel.
2. Simplify repetitive or complex calculations using formula features.
3. Understand data aggregation concepts and use Excel functions to summarize data.
4. Utilize database functions (DSUM, DMAX, DCOUNT, DAVERAGE) for structured data analysis.

---

## 💡 **Session Overview**

In data analysis, *summarization* is key. Raw data is often too large or complex to interpret directly — so analysts use **functions** to calculate totals, averages, maximums, or extract specific information.

Excel provides a vast library of **functions** that make such analysis quick and repeatable.
In this session, we’ll move from simple mathematical operations to structured database-style summarization.

---

## 🔍 **Why This Session Matters**

Every organization — from small businesses to large corporations — relies on data to make decisions. Whether you’re computing monthly sales, analyzing employee performance, or measuring customer growth, summarizing your data correctly determines the quality of your insights.

Excel’s built-in **mathematical**, **aggregation**, and **database functions** allow analysts to process large datasets without writing code — a powerful, essential skill for any data analyst.

---

---

## 🧮 **1. Mathematical and Trigonometric Functions**

### 🧠 **Concept and Background**

Mathematical functions help you perform arithmetic operations (like addition, subtraction, averages), while trigonometric functions are common in engineering, architecture, and geometry for calculating angles and projections.

These are **deterministic functions** — they take numerical inputs and always return a specific output.

### 📘 **Common Mathematical Functions**

| Function     | Description                | Example           |
| ------------ | -------------------------- | ----------------- |
| SUM()        | Adds numbers               | `=SUM(A2:A6)`     |
| AVERAGE()    | Finds mean                 | `=AVERAGE(B2:B6)` |
| MAX(), MIN() | Finds highest/lowest       | `=MAX(C2:C6)`     |
| POWER()      | Raises to exponent         | `=POWER(A2, 2)`   |
| ROUND()      | Rounds to specified digits | `=ROUND(B2, 1)`   |

### 📘 **Common Trigonometric Functions**

| Function | Description              | Example             |
| -------- | ------------------------ | ------------------- |
| SIN()    | Returns sine of angle    | `=SIN(RADIANS(30))` |
| COS()    | Returns cosine of angle  | `=COS(RADIANS(60))` |
| TAN()    | Returns tangent of angle | `=TAN(RADIANS(45))` |

---

### 🧩 **Hands-On Practice (Sheet: “Math & Trig Functions”)**

1. Open the sheet **“Math & Trig Functions”** in your Excel workbook.
   You will find the columns **Value1** and **Value2**.

2. Perform:

   * `=A2+B2` – Addition
   * `=A2-B2` – Subtraction
   * `=A2*B2` – Multiplication
   * `=A2/B2` – Division
   * `=POWER(A2, 2)` – Square of Value1

3. In any blank cell:

   * `=SUM(B2:B6)` – Total of Value2
   * `=AVERAGE(B2:B6)` – Average of Value2
   * `=MAX(B2:B6)` and `=MIN(B2:B6)`

4. For trigonometric functions:

   * `=SIN(RADIANS(B2))`, `=COS(RADIANS(B3))`, etc.

---

### 💼 **Real-Life Scenario**

A civil engineer calculates the horizontal projection of a beam given its length and angle.
Using trigonometric functions, they can determine distances or heights without manual trigonometry.

---

### 🧪 **Exercise**

1. Add a column **“Squared Value”** using the `POWER()` function.
2. Compute the total, average, and count for all **Value1** entries.
3. Try rounding your results to 2 decimal places using `ROUND()`.

---

---

## 🧩 **2. Simplifying Calculations on Data**

### 📘 **Concept**

As data grows, formulas become repetitive. Excel allows you to simplify calculations using:

* **Named ranges** – assign a name to a cell/range.
* **Relative and absolute references** (`A1` vs `$A$1`).
* **AutoFill and Table references** for dynamic formulas.

### 🔍 **Why It Matters**

This ensures your formulas remain **readable, reusable, and less error-prone**, especially when managing hundreds of records.

---

### 🧩 **Practice**

1. Highlight `B2:C6` and name it **DataRange** (`Formulas → Define Name`).
2. Now use `=SUM(DataRange)` in any empty cell.
3. Demonstrate `$A$1` (fixed) vs `A1` (adjustable) references when copying formulas.

---

### 💼 **Real-Life Scenario**

An accountant automating expense reports for multiple months can reference the same named cell (e.g., “TaxRate”) across sheets — ensuring consistent calculations.

---

---

## 📊 **3. Understanding Data Aggregation**

### 📘 **Concept**

**Aggregation** means summarizing multiple data points into a single value — like total sales per region.
Excel provides `SUMIF`, `COUNTIF`, and `AVERAGEIF` to perform conditional aggregation.

---

### 🧩 **Hands-On Practice (Sheet: “Data Aggregation”)**

| Region | Salesperson | Sales | Month |
| ------ | ----------- | ----- | ----- |

1. **Total Sales by Region**

   ```excel
   =SUMIF(A2:A9, "North", C2:C9)
   ```

   → Total of all North sales.

2. **Sales by Salesperson**

   ```excel
   =SUMIFS(C2:C9, B2:B9, "John")
   ```

3. **Sales by Month**

   ```excel
   =SUMIF(D2:D9, "Jan", C2:C9)
   ```

4. **Average Sales per Region**

   ```excel
   =AVERAGEIF(A2:A9, "South", C2:C9)
   ```

---

### 💼 **Real-Life Scenario**

A sales manager uses these functions to identify high-performing regions and sales reps for quarterly bonuses.

---

### 🧪 **Exercise**

1. Find the total sales for each region.
2. Find which salesperson sold the most in February.
3. Calculate the average sales per month.

---

---

## 🗃️ **4. Summarizing Data with Database Functions**

### 📘 **Concept**

Database functions in Excel treat data like a **small database table** — with headers, fields, and criteria ranges.
They are powerful for conditional aggregation when multiple criteria are used.

| Function | Purpose             | Example                                    |
| -------- | ------------------- | ------------------------------------------ |
| DSUM     | Conditional total   | `=DSUM(A1:D9, "Salary", F1:F2)`            |
| DMAX     | Conditional maximum | `=DMAX(A1:D9, "Salary", F1:F2)`            |
| DCOUNT   | Conditional count   | `=DCOUNT(A1:D9, "YearsExperience", F1:F2)` |
| DAVERAGE | Conditional average | `=DAVERAGE(A1:D9, "Salary", F1:F2)`        |

---

### 🧩 **Hands-On Practice (Sheet: “Database Functions”)**

1. **Setup Criteria Table**
   In `F1:F2`:

   ```
   Dept
   HR
   ```
2. Use `=DSUM(A1:D9, "Salary", F1:F2)` to find total salary in HR.
3. Use `=DMAX(...)` to find max salary in Finance.
4. Use `=DCOUNT(...)` to count employees with more than 5 years.
5. Use `=DAVERAGE(...)` to get average salary for IT.

---

### 💼 **Real-Life Scenario**

An HR analyst uses database functions to summarize workforce salaries by department and experience level, creating reports for management reviews.

---

### 🧪 **Exercise**

1. Create a criteria table to find:

   * All employees in **Finance** with **Salary > 50,000**.
   * Average years of experience in **IT**.
2. Build a summary table:

   * Dept | Total Salary | Highest Salary | Avg Experience.

---

---

## 🧠 **Class Reflection**

* What are the advantages of using Excel functions vs manual calculations?
* Which function type do you find most intuitive?
* How do these formulas relate to what data analysts do in real workplaces?

---

## 🧩 **Assessment Challenge**

Using the provided sheets:

1. Identify which region achieved sales above ₦1,500.
2. Determine the department with the highest average salary.
3. Use **Conditional Formatting** to highlight cells where salary > ₦55,000.

---

## ✅ **End of Session Summary**

In this session, students learned how to:

* Use Excel’s built-in mathematical and trigonometric functions.
* Simplify and structure formulas for readability.
* Aggregate and summarize large datasets efficiently.
* Apply database-style functions for structured analysis.

---
