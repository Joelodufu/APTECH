### Class Note: Session 6 – Macros and Pivot Charts for School Performance Analysis

**Date:** June 2, 2025  
**Course:** Introduction to Data Analysis  
**Instructor:** Joel Odufu  
**Topic:** Automating and Visualizing School Performance Data with Macros and Pivot Charts  

---

#### Introduction
Welcome to **Session 6** of the Introduction to Data Analysis course, focusing on **Macros** (using VBA) and **Pivot Charts** to automate and visualize a school performance dataset. Building on our Pivot Table, Power Query, and DAX modules, this session equips you to automate repetitive tasks and create dynamic visualizations. Since VBA (Visual Basic for Applications) requires a basic understanding of programming, we’ll start with programming fundamentals to ensure you’re ready to write and understand macros. All VBA code includes **detailed comments** to explain each line, making it easier to follow and apply in classwork. Objectives:  
1. **Understand VBA programming basics** (variables, loops, conditionals) to write macros.  
2. **Create macros** to automate tasks (e.g., formatting Pivot Tables, generating school reports).  
3. **Build Pivot Charts** to visualize data (e.g., grades by class or teacher).  

We’ll use a **School Performance Dataset** (Excel), with Nigerian use cases (e.g., market sales, hospital records) to broaden applicability. By the end, you’ll write commented VBA macros, automate workflows, and produce interactive charts, enhancing data analysis for Nigerian schools and organizations.

**Why Macros and Pivot Charts?**  
- **Importance**: Macros automate repetitive tasks, saving time, while Pivot Charts provide dynamic visualizations for insights.  
- **Usage**: Macros format reports or process data, and Pivot Charts display trends (e.g., average grades by subject).  
- **Necessity**: Nigerian institutions like schools need efficient automation and clear visualizations to manage large datasets.  
- **Theoretical Background**:  
  - **Macros/VBA**: VBA is a programming language for Excel automation, using scripts stored in modules to manipulate worksheets, Pivot Tables, and more.  
  - **Pivot Charts**: Charts linked to Pivot Tables, using Excel’s charting engine to update dynamically with filters.  

---

#### Sample Dataset
**Dataset: School Performance (Excel)**  
- **Source**: “School_Performance.xlsx,” worksheet “Grades.”  
- **Sample Data**:

| Student ID | Class | Subject | Grade | Date Recorded | Gender | Teacher |
|------------|-------|---------|-------|---------------|--------|---------|
| S001       | JSS1  | Math    | 85    | 01/04/2025    | Male   | Mr. Ade |
| S002       | JSS1  | English | 78    | 01/04/2025    | Female | Ms. Bola |
| S003       | JSS2  | Math    | 92    | 02/04/2025    | Male   | Mr. Ade |
| S004       | JSS2  | English | 65    | 02/04/2025    | Female | Ms. Bola |
| S005       | SSS1  | Math    | 88    | 03/04/2025    | Male   | Mr. Chuka |
| S006       | SSS1  | English | 70    | 03/04/2025    | Female | Ms. Bola |
| S007       | JSS1  | Math    | 90    | 04/04/2025    | Male   | Mr. Ade |
| S008       | JSS2  | English | 82    | 04/04/2025    | Female | Ms. Bola |
| S009       | SSS1  | Math    | 95    | 05/04/2025    | Male   | Mr. Chuka |
| S010       | JSS1  | English | 75    | 05/04/2025    | Female | Ms. Bola |

- **Notes**: Grades are numeric (0–100). Data is clean, stored in C:\Aptech\Data.  
- **Preparation**: Save “School_Performance.xlsx” in C:\Aptech\Data. Ensure macros are enabled (File > Options > Trust Center > Macro Settings > Enable All Macros).  

---

#### Section 1: Understanding VBA Programming Basics for Macros

To write effective macros, you need a basic understanding of programming concepts in VBA, which we’ll cover before creating macros.

##### **Purpose**  
- **Why Programming Basics?** VBA uses variables, loops, and conditionals, similar to languages like C (covered in your ADSE course). Understanding these ensures you can write and debug macros.  
- **Theory**:  
  - **Variables**: Store data (e.g., worksheet names, numbers).  
  - **Loops**: Repeat actions (e.g., format multiple cells).  
  - **Conditionals**: Make decisions (e.g., apply formatting if a condition is met).  

##### **VBA Basics with Examples**  
1. **Variables**: Store data for manipulation.  
   ```vba
   Sub VariableExample()
       ' Declare a variable to store a worksheet
       Dim ws As Worksheet
       ' Assign the "Grades" worksheet to the variable
       Set ws = ThisWorkbook.Sheets("Grades")
       ' Display the worksheet name in a message box
       MsgBox "Working with sheet: " & ws.Name
   End Sub
   ```
   - **Explanation**: `Dim` declares a variable, `Set` assigns a worksheet, `MsgBox` shows output.  

2. **Loops**: Repeat tasks, like checking grades.  
   ```vba
   Sub LoopExample()
       ' Declare variables for row number and worksheet
       Dim i As Integer
       Dim ws As Worksheet
       ' Set worksheet to "Grades"
       Set ws = ThisWorkbook.Sheets("Grades")
       ' Loop through rows 2 to 11 (data rows)
       For i = 2 To 11
           ' Check if grade (column D) is above 80
           If ws.Cells(i, 4).Value > 80 Then
               ' Highlight cell in green
               ws.Cells(i, 4).Interior.Color = vbGreen
           End If
       Next i
   End Sub
   ```
   - **Explanation**: `For` loops through rows, `If` checks conditions, `Interior.Color` applies formatting.  

3. **Conditionals**: Control logic based on data.  
   ```vba
   Sub ConditionalExample()
       ' Declare variable for worksheet
       Dim ws As Worksheet
       ' Set worksheet to "Grades"
       Set ws = ThisWorkbook.Sheets("Grades")
       ' Check grade in cell D2
       If ws.Cells(2, 4).Value >= 90 Then
           ' Display "Excellent" if grade is 90 or above
           MsgBox "Excellent grade!"
       Else
           ' Display "Good" otherwise
           MsgBox "Good grade!"
       End If
   End Sub
   ```
   - **Explanation**: `If...Else` evaluates conditions, `MsgBox` shows results.  

##### **How to Access VBA Editor**  
1. Go to **Developer** > **Visual Basic** or press **Alt+F11**.  
2. In the VBA Editor, go to **Insert** > **Module** to create a new module.  
3. Write or paste VBA code in the module.  
4. Save the workbook as macro-enabled (.xlsm): File > Save As > Excel Macro-Enabled Workbook.  

##### **Why Programming Basics?**  
Grounds students in VBA’s logic, making macros easier to understand and write, especially for classwork.

---

#### Section 2: Working with Macros

Macros automate repetitive tasks in Excel using VBA, streamlining school data processing.

##### **Purpose**  
- **Why Macros?** Automate formatting, calculations, or report generation, saving time for Nigerian educators.  
- **Theory**: VBA scripts manipulate Excel objects (e.g., worksheets, Pivot Tables) and are stored in modules, triggered by buttons or shortcuts.  

##### **Example Question 1**  
“How can we automate formatting a Pivot Table for average grades by class?”

##### **How to Do It (Macro 1: FormatPivotTable)**  
1. **Enable Developer Tab**:  
   - Go to **File** > **Options** > **Customize Ribbon** > Check **Developer** > **OK**.  

2. **Open VBA Editor**:  
   - Go to **Developer** > **Visual Basic**.  
   - Insert > Module, name it “Module1.”  

3. **Write the Macro**:  
   ```vba
   Sub FormatPivotTable()
       ' Declare variable for the worksheet containing the Pivot Table
       Dim ws As Worksheet
       ' Set worksheet to "Results" where Pivot Table is located
       Set ws = ThisWorkbook.Sheets("Results")
       ' Declare variable for the Pivot Table
       Dim pt As PivotTable
       ' Set Pivot Table to the first one in the worksheet
       Set pt = ws.PivotTables(1)
       ' Apply formatting to the Pivot Table range
       With pt.TableRange1
           ' Make text bold
           .Font.Bold = True
           ' Add continuous borders
           .Borders.LineStyle = xlContinuous
           ' Set background color to yellow
           .Interior.Color = vbYellow
       End With
       ' Display confirmation message
       MsgBox "Pivot Table formatted successfully!"
   End Sub
   ```

4. **Run the Macro**:  
   - Go to **Developer** > **Macros** > Select “FormatPivotTable” > **Run**.  
   - Alternatively, insert a button: **Insert** > **Button** > Assign Macro > “FormatPivotTable.”  

5. **Expected Result**:  
   - The Pivot Table in the “Results” sheet (created later) is formatted with bold text, borders, and yellow fill.  
   - A message box confirms “Pivot Table formatted successfully!”  

##### **Example Question 2**  
“How can we generate a summary report of high-performing students (grades ≥ 85)?”

##### **How to Do It (Macro 2: GenerateHighPerformersReport)**  
1. **Open VBA Editor**: Insert > Module (or use Module1).  
2. **Write the Macro**:  
   ```vba
   Sub GenerateHighPerformersReport()
       ' Declare variables for source and report worksheets
       Dim wsSource As Worksheet, wsReport As Worksheet
       ' Declare variables for row counters
       Dim i As Long, reportRow As Long
       ' Set source worksheet to "Grades"
       Set wsSource = ThisWorkbook.Sheets("Grades")
       ' Create or clear "Report" worksheet
       On Error Resume Next
       Set wsReport = ThisWorkbook.Sheets("Report")
       If wsReport Is Nothing Then
           ' Add new worksheet if "Report" doesn't exist
           Set wsReport = ThisWorkbook.Sheets.Add
           wsReport.Name = "Report"
       Else
           ' Clear existing content in "Report"
           wsReport.Cells.Clear
       End If
       On Error GoTo 0
       ' Add headers to the report
       wsReport.Cells(1, 1).Value = "Student ID"
       wsReport.Cells(1, 2).Value = "Class"
       wsReport.Cells(1, 3).Value = "Subject"
       wsReport.Cells(1, 4).Value = "Grade"
       ' Initialize row counter for report
       reportRow = 2
       ' Loop through rows 2 to 11 in source data
       For i = 2 To 11
           ' Check if grade (column D) is 85 or higher
           If wsSource.Cells(i, 4).Value >= 85 Then
               ' Copy Student ID to report
               wsReport.Cells(reportRow, 1).Value = wsSource.Cells(i, 1).Value
               ' Copy Class to report
               wsReport.Cells(reportRow, 2).Value = wsSource.Cells(i, 2).Value
               ' Copy Subject to report
               wsReport.Cells(reportRow, 3).Value = wsSource.Cells(i, 3).Value
               ' Copy Grade to report
               wsReport.Cells(reportRow, 4).Value = wsSource.Cells(i, 4).Value
               ' Move to next report row
               reportRow = reportRow + 1
           End If
       Next i
       ' Auto-fit columns for readability
       wsReport.Columns("A:D").AutoFit
       ' Display completion message
       MsgBox "High performers report generated in 'Report' sheet!"
   End Sub
   ```

3. **Run the Macro**:  
   - Go to **Developer** > **Macros** > Select “GenerateHighPerformersReport” > **Run**.  

4. **Expected Result** (in “Report” sheet, A1:D6):  
   ```
   | Student ID | Class | Subject | Grade |
   |------------|-------|---------|-------|
   | S001       | JSS1  | Math    | 85    |
   | S003       | JSS2  | Math    | 92    |
   | S005       | SSS1  | Math    | 88    |
   | S007       | JSS1  | Math    | 90    |
   | S009       | SSS1  | Math    | 95    |
   ```
   - A message box confirms “High performers report generated in ‘Report’ sheet!”  

##### **Use Case (Market Sales)**  
- **Scenario**: Generate a report of sales above 15,000 NGN.  
- **Solution**: Modify the macro to loop through a sales dataset, copying high-value transactions to a report sheet.  

##### **Use Case (Hospital Records)**  
- **Scenario**: Automate formatting of patient visit summaries.  
- **Solution**: Write a macro to bold headers and color-code high-priority cases.  

##### **Troubleshooting**:  
- **Macro Not Running**: Ensure macros are enabled and the workbook is .xlsm.  
- **Error (e.g., Sheet Not Found)**: Verify sheet names (“Grades,” “Results”).  
- **Debugging**: Use **F8** in the VBA Editor to step through code, checking variable values.  

##### **Why Macros?**  
Automate repetitive tasks like formatting or reporting, critical for Nigerian analysts managing school or business data.

---

#### Section 3: Working with Pivot Charts

Pivot Charts visualize school performance data dynamically, linked to existing Pivot Tables.

##### **Purpose**  
- **Why Pivot Charts?** Display trends (e.g., average grades by class or teacher) that update with filters, enhancing insights.  
- **Theory**: Pivot Charts are tied to Pivot Tables, using Excel’s charting engine for interactive visualizations.  

##### **Example Question**  
“How can we visualize average grades by Class, with a filter for Subject?”

##### **How to Do It**  
1. **Create a Pivot Table**:  
   - Open “School_Performance.xlsx,” go to **Insert** > **PivotTable** > New Worksheet (name it “Results”).  
   - In PivotTable Fields:  
     - Drag **Class** to Rows.  
     - Drag **Grade** to Values (set to **Average**).  
     - Drag **Subject** to Filters.  

2. **Insert Pivot Chart**:  
   - Select the Pivot Table, go to **Insert** > **PivotChart** > **Clustered Column** > **OK**.  
   - Move chart to A15 in “Results.”  

3. **Customize the Chart**:  
   - Add a chart title: “Average Grades by Class.”  
   - Go to **Insert** > **Slicer**, select **Subject**, place at C15.  

4. **Expected Result** (A15 in “Results”):  
   - **Pivot Table** (A3:C6):  
     ```
     | Class | Average of Grade |
     |-------|------------------|
     | JSS1  | 82.0             |
     | JSS2  | 79.5             |
     | SSS1  | 84.5             |
     ```
   - **Pivot Chart**: Clustered column chart showing average grades (JSS1: 82, JSS2: 79.5, SSS1: 84.5).  
   - **Slicer**: Filters by Subject (e.g., Math: JSS1=88.3, JSS2=92, SSS1=91.5).  
   - **Visual Description**: Three columns (one per class), with heights reflecting averages, and a Subject slicer to toggle between Math and English.  

##### **Use Case (Market Sales)**  
- **Scenario**: Visualize average sales by vendor type.  
- **Solution**: Create a Pivot Chart with Vendor Type in Rows, Sales in Values (Average), and Product as a slicer.  

##### **Use Case (Hospital Records)**  
- **Scenario**: Chart patient visits by department.  
- **Solution**: Pivot Chart with Department in Rows, Visit Count in Values, and Date as a filter.  

##### **Troubleshooting**:  
- **Chart Not Updating**: Right-click Pivot Table > **Refresh**.  
- **Wrong Values**: Ensure **Grade** is set to Average, not Sum or Count.  
- **Slicer Not Working**: Verify **Subject** is in Filters, not Rows or Columns.  

##### **Why Pivot Charts?**  
Provide interactive visualizations for Nigerian educators, enabling quick insights into performance trends.

---

#### Classwork Exercises
1. **Exercise 1: Basic Macro**  
   - **Question**: Write a macro to color cells in the Grade column (D2:D11) red if below 70.  
   - **Task**: Create macro in Module1, run it, check “Grades” sheet.  
   - **Sample Code**:  
     ```vba
     Sub ColorLowGrades()
         ' Declare worksheet variable
         Dim ws As Worksheet
         ' Set worksheet to "Grades"
         Set ws = ThisWorkbook.Sheets("Grades")
         ' Declare row counter
         Dim i As Long
         ' Loop through rows 2 to 11
         For i = 2 To 11
             ' Check if grade is below 70
             If ws.Cells(i, 4).Value < 70 Then
                 ' Color cell red
                 ws.Cells(i, 4).Interior.Color = vbRed
             End If
         Next i
         ' Confirm completion
         MsgBox "Low grades colored red!"
     End Sub
     ```  
   - **Expected Result**: Cells D4 (65) and D6 (70) are red.  

2. **Exercise 2: Advanced Macro**  
   - **Question**: Create a macro to generate a report of female students’ grades in a new “FemaleReport” sheet.  
   - **Task**: Write macro, include comments, run it.  
   - **Expected Result** (in “FemaleReport”):  
     ```
     | Student ID | Class | Subject | Grade |
     |------------|-------|---------|-------|
     | S002       | JSS1  | English | 78    |
     | S004       | JSS2  | English | 65    |
     | S006       | SSS1  | English | 70    |
     | S008       | JSS2  | English | 82    |
     | S010       | JSS1  | English | 75    |
     ```

3. **Exercise 3: Pivot Chart**  
   - **Question**: Create a Pivot Chart for average grades by Teacher, with a Gender slicer.  
   - **Task**: Build Pivot Table and Chart in “Results” at A25.  
   - **Expected Result**:  
     - Clustered column chart (Mr. Ade: ~89, Ms. Bola: ~74, Mr. Chuka: ~91.5).  
     - Gender slicer filters data (e.g., Female: Ms. Bola=74).  

4. **Exercise 4: Use Case (Market Sales)**  
   - **Question**: Create a macro to highlight sales above 15,000 NGN and a Pivot Chart for average sales by product.  
   - **Sample Data** (Excel, “Sales”):  
     ```
     | Transaction ID | Product | Sales (NGN) |
     |----------------|---------|-------------|
     | T001           | Electronics | 15000 |
     | T002           | Clothing | 8000  |
     | T003           | Electronics | 20000 |
     ```
   - **Task**: Write macro, create Pivot Table/Chart at A30.  
   - **Expected Result**:  
     - Macro highlights Sales ≥ 15,000 in green.  
     - Chart shows averages (Electronics: 17,500, Clothing: 8,000).  

---

#### Assessing Understanding (PPUQ)
**Assessment Dataset** (at A50 in “Results”):  

| Student ID | Student Name | Course of Study | Task ID | Task Question | Accuracy (0–70) | Interpretation (0–20) | Efficiency (0–10) | PPUQ Score (0–100) | Submission Date |
|------------|--------------|-----------------|---------|---------------|-----------------|-----------------------|-------------------|--------------------|----------------|
| S001       | Ada Obi      | Data Analytics  | T1      | Color Low Grades | 68             | 19                    | 9                 | 96                 | 02/06/2025     |
| S002       | Bola Ade     | Business IT     | T1      | Color Low Grades | 60             | 15                    | 7                 | 82                 | 02/06/2025     |
| S003       | Chika Eze    | Data Analytics  | T2      | Female Report   | 70              | 20                    | 10                | 100                | 02/06/2025     |
| S004       | Dapo Ojo     | Software Dev    | T3      | Pivot Chart     | 55              | 12                    | 6                 | 73                 | 02/06/2025     |
| S005       | Efe Igho     | Data Analytics  | T3      | Pivot Chart     | 65              | 18                    | 8                 | 91                 | 02/06/2025     |

- **Pivot Tables**: Average PPUQ by Course (A60), Student (D60).  
- **Scoring**:  
  - **Accuracy** (70%): Correct VBA syntax, commented code, and Pivot Chart setup.  
  - **Interpretation** (20%): Explain results (e.g., “High grades for Mr. Chuka reflect effective teaching”).  
  - **Efficiency** (10%): Simple, reusable VBA code and chart design.  

---

#### Conclusion
This session equips you to:  
- **Write VBA macros** with programming basics (variables, loops, conditionals) and detailed comments for clarity.  
- **Automate tasks** like formatting Pivot Tables or generating reports, using commented code to guide classwork.  
- **Create Pivot Charts** for dynamic visualizations, enhancing school data analysis.  

Macros and Pivot Charts are vital for Nigerian analysts, streamlining workflows and visualizing trends in schools, markets, and hospitals. Practice these skills to master data-driven reporting.