# 📘 **Session 4 – Data Manipulation Using Functions**

### **Session Objectives**

By the end of this session, students will be able to:

1. Apply Excel functions to **rank, sort, filter, and transpose** data.
2. Use **conversion functions** to manipulate data types and formats.
3. Apply functions like **TEXT()**, **VALUE()**, **DOLLAR()**, **FIXED()**, and **DATEVALUE()** in real-life scenarios.

---

## **🔹 1. Overview of Data Manipulation**

Data manipulation means **transforming or restructuring data** to make it easier to analyze and interpret.

In Excel, you can manipulate data using **formulas, functions, and references** instead of manually editing data.

**Example Use Case:**
In the `Employee_Data` sheet, you might want to:

- Rank employees by performance,
- Filter only top performers,
- Or convert salary values into text for reporting.

---

## **🔹 2. Functions to Rank, Sort, Filter, and Transpose Data**

### **🧮 RANK() Function**

Used to assign a ranking position to numbers within a dataset.

**Syntax:**

```excel
=RANK(number, ref, [order])
```

- `number`: the cell to rank
- `ref`: the range of numbers
- `order`: 0 (descending) or 1 (ascending)

**Example:**
In `Employee_Data`, rank employees by performance:

```excel
=RANK(F2, $F$2:$F$21, 0)
```

This ranks the highest performance score as **1**.

---

### **🔄 SORT() Function (Excel 365 and later)**

Sorts data dynamically without changing the original dataset.

**Syntax:**

```excel
=SORT(array, [sort_index], [sort_order], [by_col])
```

**Example:**
Sort employees by salary (highest to lowest):

```excel
=SORT(A2:F21, 4, -1)
```

---

### **🔍 FILTER() Function**

Extracts data that meets specific criteria.

**Syntax:**

```excel
=FILTER(array, include, [if_empty])
```

**Example:**
Show only employees from the **Sales** department:

```excel
=FILTER(A2:F21, C2:C21="Sales")
```

---

### **🔁 TRANSPOSE() Function**

Converts rows to columns and columns to rows.

**Syntax:**

```excel
=TRANSPOSE(array)
```

**Example:**
Transpose product names from row to column in `Product_Data`:

```excel
=TRANSPOSE(B2:B16)
```

---

### 🧠 **Demonstration (Hands-on Practice)**

Using `Employee_Data`:

1. Rank employees by performance (create a new column “Rank”).
2. Sort the table dynamically by salary.
3. Filter the list to show only HR department employees.
4. Transpose department names to appear horizontally.

---

### 💡 **Real-life Applications**

| Function        | Application Example                                   |
| --------------- | ----------------------------------------------------- |
| **RANK()**      | Ranking exam scores or KPIs                           |
| **SORT()**      | Arranging products by sales                           |
| **FILTER()**    | Displaying active customers only                      |
| **TRANSPOSE()** | Converting vertical reports into horizontal summaries |

---

## **🔹 3. Conversion Functions**

Conversion functions change **data types or formats**—for example, turning numbers into formatted text or converting text dates into real date values.

---

### **🧩 TEXT() Function**

Converts a numeric value to text in a specific format.

**Syntax:**

```excel
=TEXT(value, format_text)
```

**Example:**
Format salary as currency:

```excel
=TEXT(D2, "$#,##0.00")
```

Result: `$45,000.00`

---

### **🔢 VALUE() Function**

Converts a text string representing a number into a numeric value.

**Syntax:**

```excel
=VALUE(text)
```

**Example:**
Convert “52000” (text) to a real number:

```excel
=VALUE("52000")
```

Useful when importing data from external sources where numbers come in as text.

---

### **💲 DOLLAR() Function**

Converts a number to text using currency formatting with a dollar sign (or localized equivalent).

**Syntax:**

```excel
=DOLLAR(number, [decimals])
```

**Example:**

```excel
=DOLLAR(45000, 2)
```

Result: `$45,000.00`

---

### **📏 FIXED() Function**

Rounds a number to a specified number of decimals and converts it to text.

**Syntax:**

```excel
=FIXED(number, [decimals], [no_commas])
```

**Example:**

```excel
=FIXED(12345.678, 2, FALSE)
```

Result: `12,345.68`

---

### **📅 DATEVALUE() Function**

Converts a date stored as text into a valid Excel date serial number.

**Syntax:**

```excel
=DATEVALUE(date_text)
```

**Example:**

```excel
=DATEVALUE("2024-05-20")
```

Result: `45435` (Excel serial for the date).
You can then format it back to date format.

---

### 🧠 **Demonstration (Hands-on)**

In `Employee_Data`:

1. Create a new column **Salary_Text** using:

   ```excel
   =TEXT(D2, "₦#,##0.00")
   ```

2. Convert any text salary value back to number using:

   ```excel
   =VALUE(E2)
   ```

3. Display salary in fixed decimal places:

   ```excel
   =FIXED(D2, 2)
   ```

---

## **🔹 4. Class Exercises**

### 🧩 **Basic Level**

1. In `Sales_Data`, rank all sales by **Total_Sales**.
2. Convert all _Unit_Price_ values to currency using the **DOLLAR()** function.

### ⚙️ **Intermediate Level**

1. In `Employee_Data`, filter only employees in the **IT** department with a salary above ₦60,000.
2. Use **TEXT()** to format the salary column as “₦#,##0.00”.

### 🚀 **Advanced Level**

1. In `Product_Data`, use **FILTER()** to show products with _Stock < Reorder_Level_.
2. Use **RANK()** and **SORT()** together to display the top 5 high-priced products.
3. Apply **DATEVALUE()** to convert import dates from text to date values for reporting.

---

## **🔹 5. Summary**

| Concept                                             | Description                                              |
| --------------------------------------------------- | -------------------------------------------------------- |
| **RANK(), SORT(), FILTER(), TRANSPOSE()**           | Used for rearranging, extracting, and restructuring data |
| **TEXT(), VALUE(), DOLLAR(), FIXED(), DATEVALUE()** | Used for data conversion and formatting                  |
| **Data Manipulation**                               | Makes datasets more readable and analysis-ready          |

---

## **🧾 Assignment**

Use your workbook to:

1. Create a **Top 5 Performers** table using **RANK() + FILTER()**.
2. Format salaries using **TEXT()** and display as currency.
3. Export your result as a new Excel sheet titled **"Manipulated_Data"**.

---
