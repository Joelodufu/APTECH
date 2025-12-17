

# 🧮 **Microsoft Excel Class Note**

## **Practical Workbook: Data Validation and Conditional Formatting**

---

## **Session 1: Base Data Overview (Student_Data Sheet)**

### 🎯 **Objective:**

To become familiar with the dataset that will be used throughout the lessons.

### 📋 **Dataset Description:**

The `Student_Data` sheet contains the following fields:

| Column | Field Name     | Description                                       |
| ------ | -------------- | ------------------------------------------------- |
| A      | **Student ID** | Unique identifier for each student (e.g., STU001) |
| B      | **Full Name**  | Student’s full name                               |
| C      | **Gender**     | M/F                                               |
| D      | **Age**        | Student’s age (integer)                           |
| E      | **Score**      | Test score (0–100)                                |
| F      | **Department** | The department the student belongs to             |
| G      | **Remarks**    | Empty column to record performance remarks        |

### 🧠 **Class Activity:**

1. Open the **Student_Data** sheet.
2. Observe the structure and types of data in each column.
3. Identify where validation or formatting would improve data quality.

---

## **Session 2 – Data Validation Using Functions**

### 🎯 **Objective:**

To ensure only correct and meaningful data is entered into the worksheet using built-in and custom validation functions.

---

### 🔹 **1. Built-in Data Validation Rules**

**Steps:**

1. Select the **Score** column.
2. Go to **Data → Data Validation**.
3. Choose:

   * **Allow:** Whole number
   * **Data:** between
   * **Minimum:** 0
   * **Maximum:** 100

✅ **Result:** Only scores between 0 and 100 will be accepted.

---

### 🔹 **2. Text and Number Validation Functions**

| Function       | Syntax          | Description                  | Use Case                       |
| -------------- | --------------- | ---------------------------- | ------------------------------ |
| **ISNUMBER()** | `=ISNUMBER(E2)` | Checks if a value is numeric | Ensure score is a number       |
| **ISTEXT()**   | `=ISTEXT(B2)`   | Checks if value is text      | Ensure names contain text only |
| **ISBLANK()**  | `=ISBLANK(A2)`  | Checks if a cell is empty    | Identify unfilled cells        |

**Custom Data Validation Example:**

* To **prevent blank IDs**, use:

  ```excel
  =NOT(ISBLANK(A2))
  ```
* To **allow only text** in Full Name:

  ```excel
  =ISTEXT(B2)
  ```

---

### 🔹 **3. Customized Validation Rules**

| Rule                       | Formula                            | Purpose                                         |
| -------------------------- | ---------------------------------- | ----------------------------------------------- |
| Validate Student ID Prefix | `=LEFT(A2,3)="STU"`                | Ensures all IDs start with “STU”                |
| Validate Department        | `=ISNUMBER(MATCH(F2,$L$2:$L$6,0))` | Ensures the department exists in reference list |
| Check Numeric Entry        | `=ISNUMBER(E2)`                    | Score must be numeric                           |
| Block Empty Cells          | `=NOT(ISBLANK(A2))`                | Prevent submission without student ID           |

---

### 🧠 **Class Activity:**

1. Apply validation rules to the **Student_Data** sheet.
2. Test by entering wrong values (e.g., text in Score, invalid ID).
3. Observe Excel’s validation error alerts.

---

## **Session 3 – Performing Conditional Formatting**

### 🎯 **Objective:**

To visually highlight important data patterns and identify specific conditions in your worksheet.

---

### 🔹 **1. Built-in Conditional Formatting Rules**

**Steps:**

1. Select the range of scores (E2:E11).
2. Go to **Home → Conditional Formatting → Highlight Cells Rules.**
3. Choose **Greater Than**, **Less Than**, or **Between** to define color-based rules.

**Example:**

* Highlight scores greater than **80** in green.
* Highlight scores below **40** in red.

---

### 🔹 **2. Customized Conditional Formatting with Formulas**

| Rule                             | Formula                       | Effect                             |
| -------------------------------- | ----------------------------- | ---------------------------------- |
| Highlight Fails (<40)            | `=E2<40`                      | Red fill                           |
| Highlight Average Scores (40–69) | `=AND(E2>=40,E2<=69)`         | Yellow fill                        |
| Highlight Excellent Scores (≥70) | `=E2>=70`                     | Green fill                         |
| Highlight Duplicate Names        | `=COUNTIF($B$2:$B$11,B2)>1`   | Marks repeated names               |
| Highlight Blank Remarks          | `=ISBLANK(G2)`                | Flags missing remarks              |
| Highlight Top Performers         | `=E2>=AVERAGE($E$2:$E$11)+10` | Distinguishes outstanding students |

**Steps to Apply a Custom Formula:**

1. Select the range (e.g., A2:G11).
2. Go to **Home → Conditional Formatting → New Rule → Use a formula to determine which cells to format.**
3. Enter formula and set format (color, bold, etc.).
4. Click **OK.**

---

### 🧠 **Class Activity:**

1. Apply conditional formatting rules to the **Student_Data** sheet.
2. Experiment with color scales and icon sets.
3. Observe how Excel dynamically changes formats as values change.

---

## **Session 4 – Importing and Exporting XML Data (XML Practice Sheet)**

### 🎯 **Objective:**

To learn how to use Excel’s XML tools to import or export structured data.

---

### 🔹 **1. What is XML?**

**Definition:**
XML (Extensible Markup Language) is a structured way to represent and exchange data between applications.

---

### 🔹 **2. Preparing Data for XML Export**

Use the **XML Practice** sheet, which includes:

* `StudentID`
* `FullName`
* `Department`
* `Score`

**Steps to Export:**

1. Go to **Developer → Export.**
2. Choose where to save the file (e.g., `Students.xml`).
3. Excel converts the table into XML format.

---

### 🔹 **3. Importing XML Data**

**Steps:**

1. Go to **Data → Get External Data → From Other Sources → From XML Data Import.**
2. Select an existing XML file.
3. Map the elements to the worksheet columns.
4. Excel imports the structured data.

---

### 💡 **Practical Tip:**

XML helps integrate Excel with other apps — for example, exporting student data from Excel to a school management system.

---

## **Session 5 – Summary**

| Concept                    | Description                          | Example Formula                    |
| -------------------------- | ------------------------------------ | ---------------------------------- |
| **ISBLANK()**              | Checks for empty cells               | `=ISBLANK(A2)`                     |
| **ISNUMBER()**             | Validates numeric values             | `=ISNUMBER(E2)`                    |
| **ISTEXT()**               | Validates text values                | `=ISTEXT(B2)`                      |
| **MATCH() + ISNUMBER()**   | Validates data against list          | `=ISNUMBER(MATCH(F2,$L$2:$L$6,0))` |
| **Conditional Formatting** | Highlights cells based on conditions | `=E2>AVERAGE($E$2:$E$11)`          |
| **XML Export/Import**      | Exchange structured data             | *Developer → Export / Import XML*  |

---

### 🧠 **Final Exercise:**

1. Create a student performance tracker.
2. Apply all the **validation** and **formatting** rules learned.
3. Add **remarks** automatically (e.g., “Pass” if ≥50, “Fail” if <50).
4. Export your final data as **XML**.

---