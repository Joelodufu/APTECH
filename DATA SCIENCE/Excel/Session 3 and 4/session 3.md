## **📘 Session 3 – Performing Conditional Formatting**

### **Session Objectives**

By the end of this session, students will be able to:

1. Apply built-in conditional formatting rules to highlight data patterns.
2. Create and customize their own conditional formatting rules.
3. Import and export XML data for advanced data handling.

---

## **🔹 1. Understanding Conditional Formatting**

Conditional Formatting allows Excel to **automatically apply formatting** (like color, font, or icon sets) to cells that meet specific conditions or rules.

**Use Case Example:**
In our **Sales_Data** sheet, we can automatically highlight sales with _Total Sales_ above ₦10,000 or highlight _top 10 performers_.

---

## **🔹 2. Built-in Rules to Highlight a Cell or Range**

### **Built-in Conditional Formatting Options:**

Go to: **Home → Conditional Formatting → Highlight Cells Rules / Top/Bottom Rules / Data Bars / Color Scales / Icon Sets**

### **Common Built-in Rules**

| Rule Type                    | Description                                           | Example (Using Sales_Data)               |
| ---------------------------- | ----------------------------------------------------- | ---------------------------------------- |
| **Greater Than / Less Than** | Highlights cells greater or less than a value.        | Highlight _Total_Sales_ > ₦10,000        |
| **Equal To / Between**       | Highlights exact matches or ranges.                   | Highlight _Units_Sold_ between 20 and 30 |
| **Text That Contains**       | Highlights cells with certain text.                   | Highlight _Region_ that contains “South” |
| **Date Occurring**           | Highlights cells with dates matching certain periods. | Highlight _Date_ in “Last Month”         |
| **Duplicate Values**         | Highlights duplicates.                                | Highlight duplicate _SalesPerson_ names  |
| **Top/Bottom Rules**         | Highlights top or bottom numbers or percentages.      | Highlight top 10 _Total_Sales_           |

---

### 🧠 **Class Demonstration**

1. Open **Sales_Data** sheet.
2. Select the **Total_Sales** column.
3. Go to: `Home → Conditional Formatting → Highlight Cells Rules → Greater Than…`
4. Enter **10000** → Choose a fill color (e.g., Green).
5. Click OK.

Observe that all cells with sales > ₦10,000 are now highlighted automatically.

---

### 💡 **Real-life Application**

- In sales analysis: to instantly identify high-performing products.
- In finance: to track overdue payments or low balances.
- In HR: to highlight employees with performance scores above a target.

---

## **🔹 3. Customized Conditional Formatting Rules**

### **Creating Your Own Rule**

Steps:

1. Select data range → `Home → Conditional Formatting → New Rule`.
2. Choose **“Use a formula to determine which cells to format.”**
3. Enter a formula that returns TRUE/FALSE.

**Example 1:**
Highlight sales where region is “West” and total sales > ₦15,000

```excel
=AND($B2="West",$G2>15000)
```

Then choose a bold font and light blue fill.

**Example 2:**
Highlight employees in **Employee_Data** whose performance score ≥ 8:

```excel
=$F2>=8
```

---

### 🧪 **Practice Exercise**

#### **Basic:**

Highlight all salespersons with sales over ₦20,000.

#### **Intermediary:**

Highlight rows in _Sales_Data_ where Region = "East" **AND** Units_Sold > 25.

#### **Advanced:**

Use icon sets to represent performance levels in _Employee_Data_:

- Green icon for scores ≥ 8
- Yellow for scores between 5–7
- Red for scores < 5

---

## **🔹 4. Managing and Editing Rules**

To view or modify existing rules:

1. Select the range → `Home → Conditional Formatting → Manage Rules`.
2. Choose **“This Worksheet”** from the dropdown.
3. Edit, delete, or reorder rules.

**Tip:**
If multiple rules apply to the same range, Excel applies them **from top to bottom** (use the “Stop If True” option to prevent overlap).

---

## **🔹 5. Importing and Exporting XML Data**

XML (Extensible Markup Language) is used to store and transport structured data, often between systems.

### **Importing XML Data:**

1. Go to: `Developer → Import → Select XML File`.
2. Choose an XML file with matching schema (e.g., product or employee data).
3. Excel will map the XML elements into columns automatically.

**Example:**
Import employee data structured like:

```xml
<Employee>
  <Name>Mary</Name>
  <Department>HR</Department>
  <Salary>52000</Salary>
</Employee>
```

### **Exporting XML Data:**

1. Prepare your data table (like **Employee_Data**).
2. Go to: `Developer → Export → Choose XML file path.`
3. Excel exports structured data for integration with other systems.

**Use Case:**

- Export employee performance data to share with a web dashboard.
- Import product catalog updates from a company database.

---

## **🧩 Classwork Summary**

| Level            | Activity                                                                           |
| ---------------- | ---------------------------------------------------------------------------------- |
| **Basic**        | Apply conditional formatting to highlight sales > ₦10,000 in _Sales_Data_.         |
| **Intermediary** | Use a custom rule to highlight employees with performance ≥ 8.                     |
| **Advanced**     | Create a 3-color scale for _Total_Sales_ column and export _Employee_Data_ as XML. |

---

## **🧾 Summary**

- Conditional formatting visually emphasizes data trends.
- You can use both **built-in** and **custom rules**.
- XML import/export enhances **data interoperability** between Excel and databases or apps.

---
