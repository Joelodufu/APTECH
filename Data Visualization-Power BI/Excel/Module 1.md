Perfect ✅ — dividing your Excel class into **5 modules** makes it structured and progressive.
Below is the breakdown of the modules, followed by a full **Module 1** class note with practical, step-by-step hands-on activities.

---

## 🧩 **Course Structure: Excel Practical – Data Validation & Conditional Formatting**

| Module       | Title                                            | Focus Area                                                                |
| :----------- | :----------------------------------------------- | :------------------------------------------------------------------------ |
| **Module 1** | Understanding and Preparing Base Data            | Getting familiar with Excel interface, organizing and cleaning datasets   |
| **Module 2** | Applying Data Validation Rules                   | Using built-in and formula-based data validation functions                |
| **Module 3** | Using Logical and Lookup Functions in Validation | Combining IS functions with MATCH and custom rules                        |
| **Module 4** | Applying Conditional Formatting                  | Using built-in and custom formatting formulas to visualize data           |
| **Module 5** | XML Data Exchange & Project Practice             | Importing/exporting XML and applying all learned skills in a mini project |

---

# 🧮 **Module 1: Understanding and Preparing Base Data**

## 🎯 **Objective**

To introduce students to data structure in Excel, teach them how to clean and organize data, and prepare a dataset that will be used throughout the training.

---

## 🧠 **Learning Outcomes**

By the end of this module, learners will be able to:

* Identify and label data correctly using headers.
* Understand different data types in Excel (text, number, date).
* Format data for readability.
* Detect and correct data entry errors.
* Prepare a dataset for future validation and formatting exercises.

---

## 🧩 **Practical Focus: Creating the Base Dataset**

We will use a dataset called **Student_Data** as our foundation for all subsequent modules.

### 🧾 **Dataset Fields**

| Column | Field Name     | Description               | Data Type |
| ------ | -------------- | ------------------------- | --------- |
| A      | **Student ID** | Unique student identifier | Text      |
| B      | **Full Name**  | Student’s full name       | Text      |
| C      | **Gender**     | M/F                       | Text      |
| D      | **Age**        | Student’s age             | Number    |
| E      | **Score**      | Exam score                | Number    |
| F      | **Department** | Student’s department      | Text      |
| G      | **Remarks**    | Space for remarks         | Text      |

---

## 🧰 **Hands-On Exercise 1: Creating the Dataset**

### Step 1 – Open Excel

1. Launch **Microsoft Excel**.
2. Create a **new workbook**.
3. Rename the first sheet as **Student_Data**.

---

### Step 2 – Enter Data Headers

In **Row 1**, type the following column headers:

| A1         | B1        | C1     | D1  | E1    | F1         | G1      |
| ---------- | --------- | ------ | --- | ----- | ---------- | ------- |
| Student ID | Full Name | Gender | Age | Score | Department | Remarks |

**Tip:**
Use **bold text** and apply a **background color** to the header row for easy identification.
(Shortcut: **Ctrl + B** for bold, **Alt + H + H** for fill color.)

---

### Step 3 – Enter Sample Data

Type the following entries under each column:

| Student ID | Full Name   | Gender | Age | Score | Department   |
| ---------- | ----------- | ------ | --- | ----- | ------------ |
| STU001     | Ada Johnson | F      | 19  | 75    | Accounting   |
| STU002     | Mike David  | M      | 21  | 48    | Engineering  |
| STU003     | Rose Daniel | F      | 18  | 90    | Computer Sci |
| STU004     | Tom Bright  | M      | 22  | 36    | Accounting   |
| STU005     | Faith Bako  | F      | 20  | 67    | Marketing    |
| STU006     | James Noma  | M      | 23  | 82    | Computer Sci |
| STU007     | Sarah Kolo  | F      | 19  | 59    | Marketing    |
| STU008     | Paul Musa   | M      | 18  | 40    | Engineering  |
| STU009     | Grace Obi   | F      | 21  | 95    | Computer Sci |
| STU010     | Henry Amos  | M      | 20  | 72    | Accounting   |

---

## 🧰 **Hands-On Exercise 2: Formatting for Clarity**

### Step 1 – Adjust Column Widths

* Select all columns (click the box between A and 1).
* Double-click the right edge of any column header to **AutoFit Column Width**.
  → This makes all columns adjust to the content width.

### Step 2 – Apply Header Styles

* Highlight row 1.
* Use **Fill Color (blue)**, **Font Color (white)**, and **Bold**.
* Center-align the text (**Ctrl + E**).

### Step 3 – Freeze Headers

* Go to **View → Freeze Panes → Freeze Top Row.**
  This keeps headers visible when scrolling.

---

## 🧰 **Hands-On Exercise 3: Cleaning and Checking Data**

### Step 1 – Identify Missing Data

* Select all data → Go to **Home → Find & Select → Go To Special → Blanks.**
* Any blank cell will be highlighted.
* Fill missing values if applicable.

### Step 2 – Check for Duplicates

* Select the table → Go to **Data → Remove Duplicates.**
* Confirm that each **Student ID** is unique.

### Step 3 – Sort Data

* Click inside the table → Go to **Data → Sort.**
* Sort by **Department** or **Score** to see students grouped logically.

---

## 💡 **Teacher’s Tip**

✅ Encourage students to notice data consistency:

* All **Student IDs** should start with “STU”.
* Names should use **Title Case** (e.g., “Ada Johnson”).
* Scores should not exceed **100** or drop below **0**.

---

## 🧠 **Knowledge Check**

**Question 1:** What is the difference between text and numeric data in Excel?
**Question 2:** Why should we remove duplicates before applying data validation?
**Question 3:** What is the purpose of freezing panes?

---

## 🧩 **End of Module 1 Task**

**Assignment:**

1. Create your own **Student_Data** table with 15 students.
2. Ensure consistent formatting and no blank entries.
3. Save your file as **Excel_Practical_Module1.xlsx**.

---