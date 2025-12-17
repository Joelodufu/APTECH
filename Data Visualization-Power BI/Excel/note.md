# 🧮 **Microsoft Excel Class Notes**

## **Session 2 – Data Validation Using Functions**

### 🎯 **Objective:**

To understand how to use built-in and custom data validation rules in Excel to control the type of data entered in cells.

---

### 🔹 **1. What is Data Validation?**

**Definition:**
Data Validation in Excel is a feature that allows you to **control the type of data or the values** that users enter into a cell.

**Purpose:**

* Prevent wrong data entry.
* Improve accuracy and consistency.
* Guide users with helpful messages.

---

### 🔹 **2. Built-in Data Validation Functions for Numbers and Text**

Excel provides **built-in options** for validating:

* **Whole numbers** (e.g., only integers between 1 and 100)
* **Decimal numbers** (e.g., between 0.1 and 10.0)
* **Date and Time ranges**
* **Text length** (e.g., maximum 10 characters)
* **Lists** (drop-down options)

**Example:**

> To allow only numbers between 18 and 60:

1. Select the cell range.
2. Go to **Data → Data Validation**.
3. Choose **Whole number → between → 18 and 60**.

---

### 🔹 **3. Customized Rules for Data Validation**

You can use **formulas** in Data Validation for **custom rules**.

**Example 1 – Only uppercase text:**

```excel
=EXACT(A1,UPPER(A1))
```

**Example 2 – Allow text starting with "STU":**

```excel
=LEFT(A1,3)="STU"
```

**Example 3 – Only allow values greater than average:**

```excel
=A1>AVERAGE($A$1:$A$10)
```

---

### 🔹 **4. Data Validation Helper Functions**

#### 🧩 **ISBLANK()**

* **Definition:** Checks if a cell is empty.
* **Syntax:** `=ISBLANK(value)`
* **Returns:** `TRUE` if the cell is blank, otherwise `FALSE`.
* **Example:**
  `=ISBLANK(A1)` → TRUE if A1 is empty.

**Use Case in Data Validation:**
To prevent empty entries:

```excel
=NOT(ISBLANK(A1))
```

---

#### 🧩 **ISNUMBER()**

* **Definition:** Checks if a cell contains a number.
* **Syntax:** `=ISNUMBER(value)`
* **Returns:** `TRUE` if the cell contains a numeric value.
* **Example:**
  `=ISNUMBER(A1)` → TRUE if A1 is numeric.

**Use Case:**
Allow only numeric entries in a cell:

```excel
=ISNUMBER(A1)
```

---

#### 🧩 **ISTEXT()**

* **Definition:** Checks if a cell contains text.
* **Syntax:** `=ISTEXT(value)`
* **Returns:** `TRUE` if the value is text.
* **Example:**
  `=ISTEXT(A1)` → TRUE if A1 has text.

**Use Case:**
Allow only text entries:

```excel
=ISTEXT(A1)
```

---

### 🔹 **5. Lookup Functions with Data Validation**

You can combine **lookup functions** (like `VLOOKUP`, `XLOOKUP`, or `MATCH`) with data validation to ensure data matches existing records.

**Example:**
To validate that a student ID exists in a list:

```excel
=ISNUMBER(MATCH(A1,$B$2:$B$100,0))
```

✅ This rule only allows entries that match an existing value in range **B2:B100**.

---

## **Session 3 – Performing Conditional Formatting**

### 🎯 **Objective:**

To learn how to highlight important data patterns and trends using **Conditional Formatting** in Excel.

---

### 🔹 **1. What is Conditional Formatting?**

**Definition:**
Conditional Formatting automatically applies **formatting (color, icons, fonts)** to cells based on certain conditions or rules.

**Purpose:**

* Highlight key values (e.g., top scores)
* Identify duplicates or errors
* Visualize data trends quickly

---

### 🔹 **2. Built-in Rules to Highlight a Cell or a Range**

Excel provides several **predefined rules**, such as:

* **Highlight Cells Rules:** Greater Than, Less Than, Between, Equal To, Text That Contains.
* **Top/Bottom Rules:** Top 10 Items, Bottom 10%, Above/Below Average.
* **Data Bars:** Show data magnitude visually.
* **Color Scales:** Gradient based on values.
* **Icon Sets:** Indicators like arrows, stars, or flags.

**Example:**

> Highlight values greater than 80:

1. Select the range.
2. Go to **Home → Conditional Formatting → Highlight Cell Rules → Greater Than**.
3. Enter `80` and choose a color format.

---

### 🔹 **3. Customized Conditional Formatting Rules**

You can create **formulas** to define your own formatting rules.

**Example 1 – Highlight blank cells:**

```excel
=ISBLANK(A1)
```

**Example 2 – Highlight names starting with “A”:**

```excel
=LEFT(A1,1)="A"
```

**Example 3 – Highlight numbers greater than average:**

```excel
=A1>AVERAGE($A$1:$A$10)
```

**Example 4 – Highlight duplicates:**

```excel
=COUNTIF($A$1:$A$100,A1)>1
```

**Steps:**

1. Select range.
2. Go to **Home → Conditional Formatting → New Rule → Use a formula to determine which cells to format**.
3. Enter your formula and choose formatting style.

---

### 🔹 **4. Importing and Exporting XML Data**

**Definition:**
XML (Extensible Markup Language) allows Excel to **import and export structured data** between applications.

#### 📥 **Importing XML Data**

1. Go to **Data → Get External Data → From Other Sources → From XML Data Import**.
2. Select the `.xml` file.
3. Map elements to worksheet cells.

#### 📤 **Exporting XML Data**

1. Go to **Developer → Export**.
2. Choose destination folder and file name.
3. Excel exports the worksheet data into XML format.

**Use Case:**

* Exchange data between Excel and web applications.
* Maintain structured datasets (e.g., product lists, employee data).

---

### 💡 **Summary Table**

| Function / Feature     | Purpose                   | Example Formula                      |
| ---------------------- | ------------------------- | ------------------------------------ |
| ISBLANK()              | Checks if a cell is empty | `=ISBLANK(A1)`                       |
| ISNUMBER()             | Checks for numeric data   | `=ISNUMBER(A1)`                      |
| ISTEXT()               | Checks for text data      | `=ISTEXT(A1)`                        |
| MATCH() + ISNUMBER()   | Validate data from list   | `=ISNUMBER(MATCH(A1,$B$2:$B$100,0))` |
| Conditional Formatting | Highlight based on rule   | `=A1>AVERAGE($A$1:$A$10)`            |
| XML Import/Export      | Exchange structured data  | —                                    |

---

### 🧠 **Class Exercise**

1. Create a student score sheet.
2. Use **Data Validation** to ensure scores are between 0 and 100.
3. Use **Conditional Formatting** to:

   * Highlight scores below 40 in red.
   * Highlight scores ≥ 70 in green.
4. Export the sheet as XML.

---