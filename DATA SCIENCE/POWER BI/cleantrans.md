

## 📘 OVERVIEW

Power BI provides a powerful tool called **Power Query Editor** for data cleaning and transformation. It is part of the ETL (Extract, Transform, Load) process that prepares your data for visualization and analysis.

---

## 🔍 DATA CLEANING PRINCIPLES IN POWER BI

### 🎯 Purpose:

Data cleaning ensures that the data is accurate, consistent, and usable. Dirty data leads to misleading visualizations and poor decision-making.

---

### 🧼 Common Data Cleaning Problems and How Power BI Helps

| **Problem**                      | **Example**                                  | **Power BI Solution**                                  |
| -------------------------------- | -------------------------------------------- | ------------------------------------------------------ |
| **Missing Values**               | Nulls or blanks in a column                  | Replace values, Fill up/down, Remove rows              |
| **Inconsistent Formatting**      | Dates in different formats, mixed text cases | Format using Transform tools                           |
| **Duplicate Records**            | Same row appearing more than once            | Remove duplicates                                      |
| **Trailing/Leading Spaces**      | `"  Abuja "` vs `"Abuja"`                    | Trim and Clean functions                               |
| **Typos and Misspellings**       | `"Ngeria"` vs `"Nigeria"`                    | Replace values manually or use fuzzy matching in merge |
| **Incorrect Data Types**         | Numbers stored as text                       | Change data type to number, date, etc.                 |
| **Extra or Unnecessary Columns** | System columns like `RecordID`, `CreatedBy`  | Remove columns                                         |
| **Embedded Headers**             | Headers inside rows                          | Use “Use First Row as Headers” or promote headers      |
| **Blank Rows**                   | Empty rows between data                      | Remove blank rows                                      |

---

## 🔄 DATA TRANSFORMATION PRINCIPLES IN POWER BI

### 🎯 Purpose:

Transformation reshapes data into the required structure for analysis. It includes splitting, merging, pivoting, aggregating, and more.

---

### 🔁 Common Data Transformation Needs and Solutions

| **Transformation Problem**              | **Description**                         | **Power BI Feature/Solution**                          |
| --------------------------------------- | --------------------------------------- | ------------------------------------------------------ |
| **Unpivoted Data**                      | Data in wide format                     | Use "Unpivot Columns"                                  |
| **Need to Aggregate**                   | Summarize sales by region               | Group By and Aggregate                                 |
| **Data in Multiple Tables**             | Need to join data from multiple sources | Merge Queries (Join), Append Queries (Union)           |
| **One Column, Many Values**             | "Name: John, Age: 30" in one cell       | Split Column by Delimiter                              |
| **Complex Calculations**                | Need custom columns                     | Add Column > Custom Column                             |
| **Irregular Date Structures**           | Financial year calendars, fiscal weeks  | Add columns or transform date logic                    |
| **Need for Lookup Tables**              | Replace codes with descriptions         | Merge Queries or create relationships                  |
| **Changing Column Headers Dynamically** | Column names change with each refresh   | Use dynamic M functions or custom logic                |
| **Creating Hierarchies**                | Region → Country → State                | Create relationships or use grouping in Power BI model |
| **Combining Files**                     | Folder with multiple Excel/CSV files    | Use “Folder” source and combine binaries               |

---

## 💡 TEACHING STRATEGY

### 🧱 FOUNDATION (BASIC)

* Explain Power BI's Power Query interface.
* Import a messy Excel or CSV file.
* Demonstrate trimming, replacing, and formatting.

**Classwork:**

* Clean a file with missing values and typos.

---

### ⚙️ INTERMEDIATE

* Teach joins with “Merge Queries”.
* Demonstrate “Unpivot Columns” and “Group By”.
* Transform a date column and split text.

**Classwork:**

* Combine two datasets (e.g., Sales and Region).
* Unpivot monthly sales columns into rows.

---

### 🧠 ADVANCED

* Use custom columns and conditional columns.
* Automate folder loading (e.g., daily reports).
* Handle dynamic headers using M code.
* Resolve mismatched schemas between files.

**Classwork:**

* Load multiple Excel files, unify them, and clean the combined data.

---

## 🔧 TOOLS TO HIGHLIGHT IN POWER QUERY

* **Transform Tab** (Data types, replace, format)
* **Add Column Tab** (Custom, index, conditional)
* **Home Tab** (Remove rows/columns, merge, append)
* **View Tab** (Query Dependencies, Advanced Editor)

---




# 🧑‍🏫 CLASS NOTE: Data Cleaning and Transformation in Power BI

**Title:** Mastering Data Cleaning & Transformation Using Power BI
**Tool:** Power BI Desktop
**File:** `PowerBI_Cleaning_and_Transformation_Examples.xlsx`

---

## 🎯 CLASS OBJECTIVES

By the end of this class, students should be able to:

* Identify and fix common data quality issues.
* Perform essential transformations for effective data modeling.
* Use Power Query Editor in Power BI for cleaning and reshaping data.
* Understand and use functions like remove duplicates, split, unpivot, merge, and more.

---

## 🗂️ CLASS STRUCTURE

* **Module 1:** Introduction to Power BI and Power Query
* **Module 2:** Data Cleaning (Using `DataCleaning` sheet)
* **Module 3:** Data Transformation (Using `DataTransformation` sheet)
* **Module 4:** Recap + Class Project + Q\&A

---

## 📘 MODULE 1: Introduction to Power BI and Power Query

### 📝 Step-by-Step:

1. **Open Power BI Desktop**
2. **Click on "Get Data" → Choose Excel → Load `PowerBI_Cleaning_and_Transformation_Examples.xlsx`**
3. **Select the sheet `DataCleaning` → Click "Transform Data"**
   This opens the **Power Query Editor** where cleaning and transformation are done.

---

## 🧽 MODULE 2: DATA CLEANING — Practical with `DataCleaning` Sheet

### 🔎 Issue 1: **Trailing/Leading Spaces**

* **Column:** `Name` and `Region`
* **Steps:**

  * Select the `Name` column → Home tab → *Transform* → Format → **Trim** and **Clean**
  * Do same for `Region`

---

### 🔎 Issue 2: **Inconsistent Capitalization**

* **Column:** `Region`
* **Steps:**

  * Select `Region` → Transform tab → Format → **Capitalize Each Word** or **Lowercase**

---

### 🔎 Issue 3: **Duplicate Records**

* **Column(s):** Entire Rows
* **Steps:**

  * Home tab → Remove Rows → **Remove Duplicates**
<!-- How does it recorgnize rows that are the same, is it by the similarities of all the column properties or selected properties? can it be updated and edited? -->
---

### 🔎 Issue 4: **Missing Values**

* **Column:** `Email`, `ID`, `Name`
* **Steps:**

  * Home tab → Keep Rows → **Remove Blank Rows**
  * Optional: Replace missing values → Transform → Replace Values → Replace `null` with "Unknown"

---

### 🔎 Issue 5: **Typos & Wrong Data**

* **Column:** `Name` (e.g., "Ngeria" → "Nigeria")
* **Steps:**

  * Right-click cell → Replace Values → "Ngeria" → "Nigeria"

---

### 🔎 Issue 6: **Wrong Data Types**

* **Column:** `Age`, `Salary`
* **Steps:**

  * Change column type from "Any" to "Whole Number" or "Decimal Number"
  * Use “Detect Data Type” for quick conversion

---

### 🔎 Issue 7: **Inconsistent Date Formats**

* **Column:** `JoinDate`
* **Steps:**

  * Change data type to Date
  * Use "Using Locale" if needed
How does it differenctiate between the month and day for formart entered: 2025/04/05 and 2025/05/04?
---

## 🧰 MODULE 3: DATA TRANSFORMATION — Practical with `DataTransformation` Sheet

### 🔄 Task 1: **Split Full Name into First and Last**

* **Column:** `FullName`
* **Steps:**

  * Select `FullName` → Transform → Split Column → By Delimiter → Choose `,`

---

### 🔄 Task 2: **Unpivot Monthly Sales Columns**

* **Columns:** `Jan Sales`, `Feb Sales`, `Mar Sales`
* **Steps:**

  * Select these three columns → Transform tab → **Unpivot Columns**
  * Rename new columns: `Month`, `Sales`

---

### 🔄 Task 3: **Standardize Region Codes**

* **Column:** `Region Code`
* **Steps:**

  * Prepare a lookup table (e.g., NG → Nigeria, GH → Ghana)
  * Use "Merge Queries" to join Region Code with lookup

---

### 🔄 Task 4: **Create Department Relationships**

* Use `DepartmentID` column to join with external Department table in your model later.
* For now, rename and format correctly.

---

### 🔄 Task 5: **Change Data Types**

* Ensure `EmployeeID`, `Sales`, `DepartmentID` are correct data types.

---

## 🎓 MODULE 4: CLASS PROJECT + RECAP

### 💡 Project Idea:

"Clean and Transform an HR Dataset"

* Students will perform trimming, replacing, splitting, merging, and unpivoting on a real dataset using Power Query.

---

## ✅ CLASSWORK AND ASSESSMENT

| Task                                    | Description                                                           |
| --------------------------------------- | --------------------------------------------------------------------- |
| 🧹 Clean `DataCleaning` sheet           | Trim spaces, remove duplicates, fix typos, and replace missing values |
| 🔄 Transform `DataTransformation` sheet | Split names, unpivot sales, join lookup table                         |
| 🧠 Bonus                                | Create a custom column that labels high vs low sales                  |

---


---

