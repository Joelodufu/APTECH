# 🧮 **Module 2: Applying Data Validation Rules**

## 🎯 **Objective**

To understand how to use **Excel’s Data Validation feature** to restrict and guide data entry using built-in rules and formula-based validation.

---

## 🧠 **Learning Outcomes**

By the end of this module, learners will be able to:

- Use built-in validation rules for numbers, text, and lists.
- Create custom validation formulas.
- Use **ISBLANK()**, **ISNUMBER()**, and **ISTEXT()** functions in validation rules.
- Apply data validation with lookup functions.
- Provide error alerts and user messages.

---

## 🧩 **Recap from Module 1**

We already created the dataset in the sheet **Student_Data** with columns like _Student ID, Full Name, Gender, Age, Score, Department,_ and _Remarks._
We will now apply validation rules to control what can be typed in each column.

---

## 🧰 **Hands-On Exercise 1: Data Validation for Numbers**

### 🎯 Goal:

Ensure that the **Age** and **Score** columns accept only numbers within specific limits.

### Step-by-Step:

1. Select cells **D2:D11** (the _Age_ column).
2. Go to **Data → Data Validation → Data Validation.**
3. In the **Allow** dropdown, select **Whole number.**
4. In the **Data** dropdown, choose **between.**
5. Enter **Minimum = 15**, **Maximum = 30.**
6. Click **OK.**

✅ **Result:** Only ages between 15 and 30 can be entered.

---

### For the **Score** column:

1. Select **E2:E11.**
2. Go to **Data → Data Validation.**
3. Set:

   - **Allow:** Whole number
   - **Data:** between
   - **Minimum:** 0
   - **Maximum:** 100

4. Click **OK.**

✅ **Result:** Users can only type scores from 0 to 100.

---

## 🧰 **Hands-On Exercise 2: Data Validation for Text (Lists)**

### 🎯 Goal:

Restrict entries in **Gender** and **Department** columns to specific values.

### Step-by-Step:

#### For Gender:

1. Select **C2:C11.**
2. Go to **Data → Data Validation.**
3. In **Allow**, choose **List.**
4. In the **Source** box, type:

   ```
   M,F
   ```

5. Click **OK.**

✅ **Result:** Only “M” or “F” can be entered, with a dropdown list.

---

#### For Department:

1. Select **F2:F11.**
2. Go to **Data → Data Validation → Allow: List.**
3. In **Source**, type:

   ```
   Accounting, Engineering, Marketing, Computer Sci
   ```

4. Click **OK.**

✅ **Result:** Users can only select one of the listed departments.

---

## 🧰 **Hands-On Exercise 3: Custom Data Validation Rules**

### 🎯 Goal:

Prevent blank names and ensure Student IDs follow the format “STU###”.

### Step-by-Step:

#### A. **Prevent Blank Full Names**

1. Select **B2:B11.**
2. Go to **Data → Data Validation → Allow: Custom.**
3. In **Formula**, type:

   ```excel
   =NOT(ISBLANK(B2))
   ```

4. Go to **Error Alert** tab → Type: _Stop_
   Message: “Full Name cannot be blank.”
5. Click **OK.**

✅ **Result:** Users cannot leave the Full Name empty.

---

#### B. **Enforce Student ID Format**

1. Select **A2:A11.**
2. Go to **Data → Data Validation → Allow: Custom.**
3. Enter the formula:

   ```excel
   =AND(LEFT(A2,3)="STU",ISNUMBER(VALUE(MID(A2,4,3))))
   ```

4. Error message:
   _“Student ID must begin with ‘STU’ followed by numbers, e.g., STU001.”_
5. Click **OK.**

✅ **Result:** IDs must follow the pattern STU### (e.g., STU005).

---

## 🧰 **Hands-On Exercise 4: Using IS Functions in Validation**

| Function       | Description                  | Example         |
| -------------- | ---------------------------- | --------------- |
| **ISBLANK()**  | Checks if a cell is empty    | `=ISBLANK(A1)`  |
| **ISNUMBER()** | Checks if a value is numeric | `=ISNUMBER(B1)` |
| **ISTEXT()**   | Checks if a value is text    | `=ISTEXT(C1)`   |

---

### Example Application:

#### Ensure Score column contains only numbers

1. Select **E2:E11.**
2. Go to **Data → Data Validation → Allow: Custom.**
3. Formula:

   ```excel
   =ISNUMBER(E2)
   ```

4. Click **OK.**

✅ **Result:** Only numbers are accepted in the Score column.

---

#### Ensure Name column contains only text

1. Select **B2:B11.**
2. Data Validation → Custom.
3. Formula:

   ```excel
   =ISTEXT(B2)
   ```

4. Error message: “Only text allowed for names.”
5. Click **OK.**

✅ **Result:** Numeric entries will be rejected.

---

## 🧰 **Hands-On Exercise 5: Lookup Functions with Data Validation**

### 🎯 Goal:

Create a **Department Code** column where each code must exist in a lookup table.

### Step-by-Step:

1. On a new sheet, rename it **Dept_Lookup.**
2. Create a small table:

| A         | B            |
| --------- | ------------ |
| Dept Code | Department   |
| ACC       | Accounting   |
| ENG       | Engineering  |
| MKT       | Marketing    |
| CSC       | Computer Sci |

3. Go back to **Student_Data.**
4. In column **H (Dept Code)**, select H2:H11.
5. Go to **Data → Data Validation → Allow: List.**
6. In **Source**, refer to the list on the lookup sheet:

   ```excel
   =Dept_Lookup!$A$2:$A$5
   ```

7. Click **OK.**

✅ **Result:** Only codes from the lookup table can be chosen.

---

## 💡 **Teacher’s Tip**

Use **Input Messages** in Data Validation to guide users.
Example:

> “Enter a number between 0 and 100.”
> This appears when users select a validated cell.

---

## 🧠 **Knowledge Check**

1. What is the difference between “List” and “Custom” data validation?
2. What happens when a user enters invalid data?
3. How can **ISNUMBER()** improve data integrity?

---

## 🧩 **End of Module 2 Task**

**Assignment:**

1. Apply validation to your Student_Data file.
2. Add error alerts and input messages.
3. Add a new column for **Department Code** and validate it using a lookup list.
4. Save your file as **Excel_Practical_Module2.xlsx.**

---
