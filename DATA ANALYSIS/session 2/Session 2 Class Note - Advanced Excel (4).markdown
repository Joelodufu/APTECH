# Session 2: Data Validation and Conditional Formatting in Excel

**Objective**: By the end of this session, students will be able to:
- Apply built-in data validation functions for numbers and text to ensure data integrity.
- Create customized data validation rules using formulas for specific requirements.
- Use `ISBLANK()`, `ISNUMBER()`, and `ISTEXT()` functions in data validation to enforce data types.
- Implement lookup functions with data validation to create dynamic dropdowns.
- Apply built-in conditional formatting rules to highlight cells or ranges based on conditions.
- Create customized conditional formatting rules using formulas for advanced visualization.
- Import and export XML data in Excel for system integration.
- Build a professional data analytics portfolio on GitHub, Maven Analytics, and LinkedIn, showcasing all Session 2 skills for final exams and career preparation.

**Duration**: 2 hours  
**Reference**: Data Analysis with MS Excel (Sessions 2 and 3)  
**Context**: This session covers all topics from Sessions 2 and 3 of the *Data Analysis with MS Excel* book, as specified in the OV-1501 curriculum, ensuring readiness for final exams. It builds on Session 1 (customizing Excel, add-ins, templates, charts) and prepares students for future Power BI, Python, and SQL integration in their data analytics portfolios. All examples, exercises, and portfolio tasks are designed to reinforce exam-relevant skills and demonstrate professional capabilities.

---

## Step-by-Step Explained Examples

### 1. Built-in Data Validation for Numbers and Text
**Concept**: Data validation restricts cell inputs to specific types (e.g., numbers, text, dates) to maintain data accuracy.

**Example 1: Validate Whole Numbers for Product Quantities**
1. **Prepare Worksheet**:
   - Open a new workbook, name Sheet1 “Inventory”.
   - Enter A1: **"Stock Quantity"**.
   - Select A2:A15.
2. **Apply Validation**:
   - Go to **Data** > **Data Validation** > **Data Validation**.
   - Set:
     - **Allow**: Whole number.
     - **Data**: Between.
     - **Minimum**: 5, **Maximum**: 500.
   - In **Input Message**, set:
     - **Title**: "Quantity Input".
     - **Input message**: "Enter a quantity between 5 and 500 units."
   - In **Error Alert**, set:
     - **Style**: Stop.
     - **Title**: "Invalid Quantity".
     - **Error message**: "Quantity must be a whole number between 5 and 500."
   - Click **OK**.
3. **Test**:
   - Enter 100 in A2 (valid), 3 in A3 (error), 501 in A4 (error).
4. **Sample Data Table**:
   | Stock Quantity |
   |----------------|
   | 100            |
   | 250            |
   | 400            |
5. **Expected Output**: Cells A2:A15 only accept whole numbers 5–500; errors trigger a pop-up with the specified message.
6. **Save**: Save as "Inventory_Management.xlsx".

**Example 2: Validate Text Length for Supplier Names**
1. **Prepare Worksheet**:
   - In Sheet1, enter B1: **"Supplier Name"**.
   - Select B2:B15.
2. **Apply Validation**:
   - Go to **Data** > **Data Validation**.
   - Set:
     - **Allow**: Text length.
     - **Data**: Less than or equal to.
     - **Length**: 40.
   - In **Error Alert**, set:
     - **Title**: "Invalid Name".
     - **Error message**: "Supplier name must be 40 characters or less."
   - Click **OK**.
3. **Test**:
   - Enter "Acme Supplies" in B2 (valid), a 41-character string in B3 (error).
4. **Sample Data Table**:
   | Supplier Name      |
   |--------------------|
   | Acme Supplies      |
   | Global Traders     |
   | Sunrise Distributors |
5. **Expected Output**: Cells B2:B15 only accept text up to 40 characters.
6. **Save**: Update "Inventory_Management.xlsx".

**Why it matters**: Built-in validation ensures consistent data entry, preventing errors in analysis and reporting.

---

### 2. Customized Rules for Data Validation
**Concept**: Custom validation uses formulas to enforce complex or project-specific data entry rules.

**Example 1: Validate Product Codes Starting with "ITEM"**
1. **Prepare Worksheet**:
   - In Sheet1, enter C1: **"Product Code"**.
   - Select C2:C15.
2. **Apply Validation**:
   - Go to **Data** > **Data Validation**.
   - Set:
     - **Allow**: Custom.
     - **Formula**: `=AND(LEFT(C2,4)="ITEM",LEN(C2)=8)`.
   - In **Error Alert**, set:
     - **Title**: "Invalid Code".
     - **Error message**: "Product Code must start with 'ITEM' and be 8 characters long."
   - Click **OK**.
3. **Test**:
   - Enter "ITEM1234" in C2 (valid), "ITEM123" in C3 (error), "PROD1234" in C4 (error).
4. **Sample Data Table**:
   | Product Code |
   |--------------|
   | ITEM1234     |
   | ITEM5678     |
   | ITEM9012     |
5. **Expected Output**: Only codes like "ITEM1234" are accepted; others trigger an error.
6. **Save**: Update "Inventory_Management.xlsx".

**Example 2: Validate Email Addresses with "@" and ".org"**
1. **Prepare Worksheet**:
   - In Sheet1, enter D1: **"Contact Email"**.
   - Select D2:D15.
2. **Apply Validation**:
   - Set **Allow**: Custom.
   - **Formula**: `=AND(ISNUMBER(SEARCH("@",D2)),ISNUMBER(SEARCH(".org",D2)))`.
   - **Error Alert**: "Email must contain '@' and end with '.org'."
   - Click **OK**.
3. **Test**:
   - Enter "contact@nonprofit.org" in D2 (valid), "contact@nonprofit.com" in D3 (error).
4. **Sample Data Table**:
   | Contact Email           |
   |-------------------------|
   | contact@nonprofit.org   |
   | admin@charity.org       |
   | support@foundation.org  |
5. **Expected Output**: Only emails ending in ".org" are accepted.

**Why it matters**: Custom rules allow tailored data validation to meet specific business needs.

---

### 3. Using ISBLANK(), ISNUMBER(), ISTEXT() with Data Validation
**Concept**: These functions enforce specific data types or conditions in validation rules.

**Example 1: Validate Numeric Costs with ISNUMBER()**
1. **Prepare Worksheet**:
   - In Sheet1, enter E1: **"Unit Cost ($)"**.
   - Select E2:E15.
2. **Apply Validation**:
   - Set **Allow**: Custom.
   - **Formula**: `=ISNUMBER(E2)`.
   - **Error Alert**: "Unit Cost must be a numeric value."
   - Click **OK**.
3. **Test**:
   - Enter 19.99 in E2 (valid), "Nineteen" in E3 (error).
4. **Sample Data Table**:
   | Unit Cost ($) |
   |---------------|
   | 19.99         |
   | 45.00         |
   | 99.50         |
5. **Expected Output**: Only numbers are accepted.

**Example 2: Ensure Non-Blank Notes with ISBLANK()**
1. **Prepare Worksheet**:
   - In Sheet1, enter F1: **"Order Notes"**.
   - Select F2:F15.
2. **Apply Validation**:
   - Set **Allow**: Custom.
   - **Formula**: `=NOT(ISBLANK(F2))`.
   - **Error Alert**: "Order Notes cannot be blank."
   - Click **OK**.
3. **Test**:
   - Enter "Priority order" in F2 (valid), leave F3 blank (error).
4. **Sample Data Table**:
   | Order Notes        |
   |--------------------|
   | Priority order     |
   | Standard delivery  |
   | Customer request   |

**Example 3: Validate Text Categories with ISTEXT()**
1. **Prepare Worksheet**:
   - In Sheet1, enter G1: **"Category"**.
   - Select G2:G15.
2. **Apply Validation**:
   - Set **Allow**: Custom.
   - **Formula**: `=ISTEXT(G2)`.
   - **Error Alert**: "Category must be text."
   - Click **OK**.
3. **Test**:
   - Enter "Electronics" in G2 (valid), 123 in G3 (error).
4. **Sample Data Table**:
   | Category      |
   |---------------|
   | Electronics   |
   | Furniture     |
   | Stationery    |

**Why it matters**: These functions ensure data type consistency, critical for accurate calculations and reporting.

---

### 4. Lookup Functions with Data Validation
**Concept**: Dropdown lists paired with lookup functions (e.g., `VLOOKUP`) create dynamic, error-free data entry systems.

**Example 1: Product Dropdown with Price Lookup**
1. **Prepare Data**:
   - In Sheet2, enter:
     | A1: Product   | B1: Price ($) |
     |---------------|---------------|
     | Monitor       | 150.00        |
     | Keyboard      | 40.00         |
     | Mouse         | 20.00         |
   - In Sheet1, enter H1: **"Product"**, I1: **"Price ($)"**.
   - Select H2:H15.
2. **Create Dropdown**:
   - Go to **Data** > **Data Validation**.
   - Set **Allow**: List, **Source**: `=Sheet2!$A$2:$A$4`.
   - Click **OK**.
3. **Add VLOOKUP**:
   - In I2, enter: `=VLOOKUP(H2, Sheet2!$A$2:$B$4, 2, FALSE)`.
   - Copy down to I15.
4. **Test**:
   - Select "Monitor" in H2; I2 should display 150.00.
5. **Sample Data Table**:
   | Product  | Price ($) |
   |----------|-----------|
   | Monitor  | 150.00    |
   | Mouse    | 20.00     |
   | Keyboard | 40.00     |
6. **Expected Output**: Dropdown lists products; selecting one auto-fills the price.

**Example 2: Department Dropdown with Budget Lookup**
1. **Prepare Data**:
   - In Sheet2, add:
     | C1: Department | D1: Budget ($) |
     |----------------|----------------|
     | Sales          | 10000          |
     | Marketing      | 8000           |
     | IT             | 12000          |
   - In Sheet1, enter J1: **"Department"**, K1: **"Budget ($)"**.
   - Select J2:J15.
2. **Create Dropdown**:
   - Set **Allow**: List, **Source**: `=Sheet2!$C$2:$C$4`.
   - Click **OK**.
3. **Add VLOOKUP**:
   - In K2, enter: `=VLOOKUP(J2, Sheet2!$C$2:$D$4, 2, FALSE)`.
   - Copy down.
4. **Test**:
   - Select "Sales" in J2; K2 should display 10000.
5. **Sample Data Table**:
   | Department | Budget ($) |
   |------------|------------|
   | Sales      | 10000      |
   | IT         | 12000      |
   | Marketing  | 8000       |

**Why it matters**: Dynamic dropdowns with lookups streamline data entry and reduce errors.

---

### 5. Built-in Conditional Formatting Rules
**Concept**: Built-in rules highlight cells based on predefined conditions (e.g., greater than, top/bottom).

**Example 1: Highlight High Inventory Quantities**
1. **Prepare Data**:
   - Use the Stock Quantity column (A2:A15) from Example 1.
2. **Apply Rule**:
   - Select A2:A15.
   - Go to **Home** > **Conditional Formatting** > **Highlight Cells Rules** > **Greater Than**.
   - Enter 300, choose **Green Fill with Dark Green Text**.
   - Click **OK**.
3. **Expected Output**:
   - Quantities like 400 are green.
4. **Sample Data Table**:
   | Stock Quantity | (Green if >300) |
   |----------------|-----------------|
   | 100            |                 |
   | 400            | Green           |
   | 250            |                 |

**Example 2: Highlight Top 2 Budgets**
1. **Prepare Data**:
   - Use the Budget column (K2:K15) from Example 2.
2. **Apply Rule**:
   - Select K2:K15.
   - Go to **Home** > **Conditional Formatting** > **Top/Bottom Rules** > **Top 10 Items**.
   - Set to "Top 2", choose **Blue Fill**.
   - Click **OK**.
3. **Expected Output**:
   - Budgets 10000 and 12000 are blue.

**Why it matters**: Built-in rules quickly visualize key data trends.

---

### 6. Customized Conditional Formatting Rules
**Concept**: Custom rules use formulas for advanced, project-specific highlighting.

**Example 1: Highlight Low Stock Levels**
1. **Prepare Data**:
   - In Sheet2, add E1: **"Reorder Level"**, E2:E5: 50, 10, 5, 75.
2. **Apply Rule**:
   - Select E2:E5.
   - Go to **Home** > **Conditional Formatting** > **New Rule** > **Use a formula**.
   - Enter: `=E2<15`.
   - Set format: **Red Fill with Dark Red Text**.
   - Click **OK**.
3. **Expected Output**:
   - Values 10 and 5 are red.
4. **Sample Data Table**:
   | Reorder Level | (Red if <15) |
   |---------------|--------------|
   | 50            |              |
   | 10            | Red          |
   | 5             | Red          |

**Example 2: Highlight Pending Orders**
1. **Prepare Data**:
   - In Sheet1, enter L1: **"Order Status"**, L2:L5: "Pending", "Complete", "Pending", "Shipped".
2. **Apply Rule**:
   - Select L2:L5.
   - Go to **Home** > **Conditional Formatting** > **New Rule** > **Use a formula**.
   - Enter: `=L2="Pending"`.
   - Set format: **Yellow Fill**.
   - Click **OK**.
3. **Expected Output**:
   - "Pending" cells are yellow.

**Why it matters**: Custom rules enable precise visualization for business needs.

---

### 7. Importing and Exporting XML Data
**Concept**: Excel supports XML import/export for integration with external systems.

**Example 1: Import and Modify Inventory XML**
1. **Prepare XML File**:
   - Create "inventory.xml":
     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <Inventory>
         <Item>
             <Name>Printer</Name>
             <Price>100</Price>
         </Item>
         <Item>
             <Name>Scanner</Name>
             <Price>80</Price>
         </Item>
         <Item>
             <Name>Router</Name>
             <Price>50</Price>
         </Item>
     </Inventory>
     ```
   - Save locally.
2. **Import XML**:
   - In a new workbook, go to **Data** > **Get Data** > **From File** > **From XML**.
   - Select "inventory.xml", load into a table.
3. **Modify Data**:
   - Change "Printer" price to 120.
4. **Export XML**:
   - Go to **File** > **Save As**, choose **XML Data (*.xml)**, name it "updated_inventory.xml".
5. **Verify**:
   - Open "updated_inventory.xml" to confirm price change.
6. **Sample Data Table** (Imported):
   | Name    | Price |
   |---------|-------|
   | Printer | 120   |
   | Scanner | 80    |
   | Router  | 50    |
7. **Save**: Save as "XML_Inventory.xlsx".

**Example 2: Export Order Data as XML**
1. **Prepare Data**:
   - In Sheet1, create:
     | M1: Order ID | N1: Total ($) |
     |--------------|---------------|
     | INV001       | 500           |
     | INV002       | 750           |
2. **Export as XML**:
   - Go to **File** > **Save As**, choose **XML Data (*.xml)**, name it "orders.xml".
   - Expected XML output:
     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <Orders>
         <Order>
             <OrderID>INV001</OrderID>
             <Total>500</Total>
         </Order>
         <Order>
             <OrderID>INV002</OrderID>
             <Total>750</Total>
         </Order>
     </Orders>
     ```
3. **Save**: Update "XML_Inventory.xlsx".

**Why it matters**: XML handling enables seamless data exchange with databases and systems.

---

## Classwork: Hands-On Practice
**Objective**: Master all Session 2 and 3 topics through practical exercises for exam preparation.

1. **Built-in Data Validation (Numbers)** (10 minutes):
   - Create a worksheet with A1: **"Sales Volume"**.
   - Apply validation to A2:A12 for whole numbers between 100 and 1000.
   - Set input message: "Enter sales volume between 100 and 1000 units."
   - Set error message: "Sales volume must be 100–1000."
   - Test: 500 (valid), 50 (error).
   - Sample data: 500, 750, 900.

2. **Built-in Data Validation (Text)** (10 minutes):
   - Label B1: **"Client Name"**.
   - Apply validation to B2:B12 for text length ≤25.
   - Set error message: "Client name must be 25 characters or less."
   - Test: "Tech Solutions" (valid), 26-character string (error).
   - Sample data: Tech Solutions, Global Inc, Star Enterprises.

3. **Custom Data Validation** (15 minutes):
   - Label C1: **"Purchase Order"**.
   - Apply custom validation to C2:C12 for codes starting with "PO" and 6 characters (use `=AND(LEFT(C2,2)="PO",LEN(C2)=6)`).
   - Set error message: "Purchase Order must start with 'PO' and be 6 characters."
   - Test: "PO1234" (valid), "P1234" (error).
   - Sample data: PO1234, PO5678, PO9012.

4. **Validation with ISBLANK(), ISNUMBER(), ISTEXT()** (15 minutes):
   - Label D1: **"Revenue ($)"**, E1: **"Priority"**.
   - For D2:D12, apply `=ISNUMBER(D2)`; error: "Revenue must be numeric."
   - For E2:E12, apply `=AND(ISTEXT(E2),NOT(ISBLANK(E2)))`; error: "Priority must be non-blank text."
   - Test: 1000 in D2 (valid), "High" in E2 (valid).
   - Sample data: 1000, High; 2500, Medium.

5. **Lookup with Data Validation** (15 minutes):
   - In Sheet2, create:
     | A1: Item   | B1: Cost ($) |
     |------------|--------------|
     | Laptop     | 800          |
     | Tablet     | 300          |
     | Phone      | 500          |
   - In Sheet1, label F1: **"Item"**, G1: **"Cost ($)"**.
   - Apply dropdown in F2:F12 using Items.
   - Use `VLOOKUP` in G2 to retrieve costs.
   - Test: Select "Laptop" (shows 800).
   - Sample data: Laptop, 800; Phone, 500.

6. **Built-in Conditional Formatting** (10 minutes):
   - In the Revenue column (D2:D12), highlight values >2000 in green.
   - Test: 2500 is green.
   - Sample data: 1500, 2500, 3000.

7. **Custom Conditional Formatting** (10 minutes):
   - In Sheet2, add C1: **"Stock"**, C2:C6: 100, 20, 5, 150, 30.
   - Apply custom rule to C2:C6 for values <25 in red (use `=C2<25`).
   - Test: 20 and 5 are red.

8. **XML Import/Export** (15 minutes):
   - Create an XML file "items.xml" with 3 products (name, price).
   - Import into Excel, change one price, export as "updated_items.xml".
   - Save as "XML_Practice.xlsx".
   - Sample XML:
     ```xml
     <Items>
         <Item><Name>Camera</Name><Price>200</Price></Item>
         <Item><Name>Lens</Name><Price>150</Price></Item>
         <Item><Name>Tripod</Name><Price>50</Price></Item>
     </Items>
     ```

**Submission**: Save all files in a folder named "Session2_Work_[YourName]".

---

## Test: Assessment
**Objective**: Evaluate mastery of all Session 2 and 3 topics for final exam preparation.  
**Duration**: 20 minutes  
**Instructions**: Complete the tasks in Excel and submit as "Session2_Test_[YourName].xlsx".

1. **Built-in Data Validation (Numbers)** (3 points):
   - Label A1: **"Discount (%)"**.
   - Apply validation to A2:A10 for decimals between 0 and 50.
   - Set error message: "Discount must be 0–50%."

2. **Built-in Data Validation (Text)** (3 points):
   - Label B1: **"Location"**.
   - Apply validation to B2:B10 for text length ≤30.
   - Set error message: "Location must be 30 characters or less."

3. **Custom Data Validation** (4 points):
   - Label C1: **"Transaction ID"**.
   - Apply custom validation to C2:C10 for IDs starting with "TXN" and 7 characters (use `=AND(LEFT(C2,3)="TXN",LEN(C2)=7)`).
   - Set error message: "Transaction ID must start with 'TXN' and be 7 characters."

4. **Validation with Functions** (4 points):
   - Label D1: **"Feedback"**, E1: **"Score"**.
   - For D2:D10, apply `=NOT(ISBLANK(D2))`; error: "Feedback cannot be blank."
   - For E2:E10, apply `=ISNUMBER(E2)`; error: "Score must be numeric."

5. **Lookup with Data Validation** (4 points):
   - In Sheet2, create:
     | A1: Branch | B1: Target ($) |
     |------------|----------------|
     | North      | 6000           |
     | South      | 8000           |
     | East       | 7000           |
   - In Sheet1, apply dropdown in F2:F10 for branches, use `VLOOKUP` in G2 for targets.

6. **Built-in Conditional Formatting** (3 points):
   - In the Target column (G2:G10), highlight values >7500 in blue.

7. **Custom Conditional Formatting** (4 points):
   - In the Discount column (A2:A10), apply a custom rule for values <10 in red (use `=A2<10`).

**Grading Criteria**:
- Correctness: 15 points.
- Formatting and clarity: 5 points.
- Timely submission: 5 points.

---

## Portfolio-Building Task: Enhancing Your Data Analytics Portfolio
**Objective**: Create a comprehensive Excel project showcasing all Session 2 and 3 topics, hosted on **GitHub**, **Maven Analytics**, and **LinkedIn**, to prepare for final exams and demonstrate skills for data analytics roles.  
**Instructions**:  
1. **Update GitHub Repository** (15 minutes):  
   - In your existing “Data-Analytics-Portfolio-[YourName]” repository (created in Session 1), create a folder named “Session2_Excel”.  
   - Update the README.md in the “Excel” section with a subsection: “Session 2: Data Validation and Conditional Formatting”.

2. **Create an Excel Portfolio Artifact** (40 minutes):  
   - In a new Excel workbook named “Portfolio_Session2_[YourName].xlsx”, create the following sheets:  
     - **Sheet 1: Inventory Tracking System**  
       - Create a table with the following columns:
         | A1: Item ID | B1: Item Name | C1: Category | D1: Quantity | E1: Unit Price ($) | F1: Order Status | G1: Notes |
         |-------------|---------------|-------------|--------------|--------------------|------------------|-----------|
         | ITM001      | Monitor       | Electronics | 50           | 150.00             | Pending          | Urgent    |
         | ITM002      | Keyboard      | Electronics | 100          | 40.00              | Complete         | Standard  |
         | ITM003      | Chair         | Furniture   | 25           | 80.00              | Pending          | Bulk      |
       - Apply data validation:  
         - **Item ID (A2:A20)**: Custom, `=AND(LEFT(A2,3)="ITM",LEN(A2)=6)`; error: "Item ID must start with 'ITM' and be 6 characters."  
         - **Item Name (B2:B20)**: Text length ≤30; error: "Item name must be 30 characters or less."  
         - **Category (C2:C20)**: Dropdown from Sheet2 (A2:A4: Electronics, Furniture, Stationery).  
         - **Quantity (D2:D20)**: Whole numbers 10–500; error: "Quantity must be 10–500."  
         - **Unit Price (E2:E20)**: Custom, `=ISNUMBER(E2)`; error: "Unit Price must be numeric."  
         - **Order Status (F2:F20)**: Custom, `=ISTEXT(F2)`; error: "Order Status must be text."  
         - **Notes (G2:G20)**: Custom, `=NOT(ISBLANK(G2))`; error: "Notes cannot be blank."  
       - In Sheet2, create:
         | A1: Category   | B1: Item       | C1: Unit Price ($) |
         |----------------|----------------|--------------------|
         | Electronics    | Monitor        | 150.00             |
         | Electronics    | Keyboard       | 40.00              |
         | Furniture      | Chair          | 80.00              |
       - In Sheet1, E2:E20, use `VLOOKUP`: `=VLOOKUP(B2, Sheet2!$B$2:$C$4, 2, FALSE)`.  
       - Below the table, write: “This inventory tracking system ensures data accuracy through robust validation and dynamic pricing using VLOOKUP, critical for efficient inventory management.”  
     - **Sheet 2: Conditional Formatting and Visualization**  
       - Copy the table from Sheet 1.  
       - Apply built-in conditional formatting:  
         - Quantity (D2:D20): Values >150 in green.  
         - Unit Price (E2:E20): Top 2 values in blue.  
       - Apply custom conditional formatting:  
         - Quantity (D2:D20): Values <30 in red (use `=D2<30`).  
         - Order Status (F2:F20): “Pending” in yellow (use `=F2="Pending"`).  
       - Create a **Bar Chart** showing Quantity by Item ID.  
       - Customize with:
         - Title: “Inventory Quantities by Item”.
         - Axis titles: “Item ID” (horizontal), “Quantity” (vertical).
         - Data labels showing quantities.
       - Below the chart, write a 2–3 sentence analysis: “The chart shows ITM002 (Keyboard) has the highest stock at 100 units, highlighted in green for high quantity. Low stock items like ITM003 (Chair) are flagged in red, indicating reorder needs.”  
     - **Sheet 3: XML Integration**  
       - Create an XML file named “inventory.xml” with the following content:
         ```xml
         <?xml version="1.0" encoding="UTF-8"?>
         <Inventory>
             <Item>
                 <ID>ITM001</ID>
                 <Price>150</Price>
             </Item>
             <Item>
                 <ID>ITM002</ID>
                 <Price>40</Price>
             </Item>
         </Inventory>
         ```
       - Import “inventory.xml” into Excel, modify ITM001’s price to 160, and export as “updated_inventory.xml”.  
       - Paste a screenshot of the imported table in the sheet.  
       - Below the screenshot, write: “This demonstrates XML import and export capabilities, enabling seamless data integration with external inventory systems.”  
     - **Sheet 4: Reflection**  
       - Write a paragraph (5–6 sentences): “Session 2 equipped me with data validation and conditional formatting skills to ensure accurate and visually insightful data management, essential for professional analytics. These skills build on Session 1’s charting and customization, enabling me to create robust inventory systems. The portfolio project showcases my ability to handle complex datasets with precision. I am prepared to integrate Power BI for interactive dashboards, Python for automation, and SQL for querying in future sessions. This portfolio reflects my exam readiness and career potential in data analytics.”  

3. **Upload to GitHub** (15 minutes):  
   - In the “Session2_Excel” folder, upload “Portfolio_Session2_[YourName].xlsx” and “updated_inventory.xml”.  
   - Update the README.md in the “Excel” section with:  
     - Heading: “Advanced Excel: Session 2 Project”.  
     - Description: “This project demonstrates advanced Excel skills in data validation, conditional formatting, and XML integration. The inventory tracking system ensures data accuracy, visualizes stock trends, and supports external data exchange, showcasing professional data analytics capabilities.”  
     - Screenshots of the bar chart and the validation table from Sheet 1.  
     - Links to download the Excel file and XML file.  

4. **Update Maven Analytics Portfolio** (15 minutes):  
   - Log in to your Maven Analytics account at [mavenanalytics.io](https://mavenanalytics.io).  
   - Create a new portfolio project titled “Advanced Excel: Inventory Tracking System”.  
   - Upload screenshots of the bar chart, validation table, and XML table from your Excel workbook.  
   - Add a description: “This Session 2 project from OV-1501 showcases data validation to ensure accurate inventory data, conditional formatting to highlight stock trends, and XML integration for data exchange, demonstrating foundational data analytics skills.”  
   - Save the project and copy the portfolio link.  

5. **Share on LinkedIn** (10 minutes):  
   - Write a LinkedIn post: “Advancing my data analytics journey with Advanced Excel! I’ve built an inventory tracking system featuring data validation, conditional formatting, and XML integration. Explore my portfolio on GitHub: [Insert GitHub repository link] and Maven Analytics: [Insert Maven portfolio link]. Excited to incorporate Power BI, Python, and SQL in upcoming projects! #DataAnalytics #Excel #Portfolio”  
   - Attach a screenshot of the bar chart from Sheet 2.  

**Submission**:  
- Submit the GitHub repository URL, Maven Analytics portfolio link, and LinkedIn post link to the instructor.  
- Save “Portfolio_Session2_[YourName].xlsx” and “updated_inventory.xml” in your portfolio folder for future reference.  

**Why it matters**:  
- **GitHub**: Provides a scalable, tech-recognized platform to host Excel projects, with room for future Power BI, Python, and SQL work, appealing to technical recruiters.  
- **Maven Analytics**: Tailored for data analytics, this platform enhances credibility within the analytics community and allows students to showcase visualizations.  
- **LinkedIn**: Increases visibility to employers and builds a professional narrative, linking to detailed portfolio assets.  
- This project covers all Session 2 and 3 topics, ensuring students are prepared for final exams and equipped to demonstrate practical skills to potential online employers.

---

**Resources**:  
- **eBook**: Data Analysis with MS Excel (Sessions 2 and 3).  
- **OnlineVarsity**: Access Learner’s Guide, Glossary, and Practice 4 Me for additional exercises.  
- **References**: Data Analysis with Microsoft Excel by Kenneth N. Berk.  
- **Platforms**:  
  - GitHub: [github.com](https://github.com)  
  - Maven Analytics: [mavenanalytics.io](https://mavenanalytics.io)  
  - LinkedIn: [linkedin.com](https://linkedin.com)

**Next Steps**:  
- Review Try It Yourself questions from Sessions 2 and 3 in the Data Analysis with MS Excel book.  
- Prepare for Session 3, which focuses on practical exercises to reinforce these skills, and continue building your portfolio across GitHub, Maven Analytics, and LinkedIn.