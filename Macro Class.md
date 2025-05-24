# VBA Macros in Microsoft Excel - Complete Classnote

🧠 Overview
This classnote covers VBA Macros from beginner to advanced level in Microsoft Excel. It includes explanations, examples, and classwork.

📘 Table of Contents

* Basic Level

  * Introduction to VBA Macros
  * Recording Your First Macro
  * Understanding the VBA Editor
  * Classwork
* Intermediate Level

  * Writing Custom Macros
  * Control Structures
  * Working with Ranges
  * Debugging and Error Handling
  * Classwork
* Advanced Level

  * Working with Worksheets & Workbooks
  * User Forms & Input Boxes
  * Working with Events
  * Connecting to External Data
  * Classwork
* Best Practices
* Recommended Projects

---

## 🔰 Section 1: Basic Level

### Introduction to VBA Macros

* Macro: A set of recorded instructions to automate tasks in Excel.
* VBA: Visual Basic for Applications, the language used to write macros.

🎯 Why Use VBA?

* Automate repetitive tasks
* Improve productivity
* Ensure consistency

### Accessing the VBA Editor

* Press Alt + F11
* Use Developer Tab → Macros or Record Macro

### Recording Your First Macro

1. Developer → Record Macro
2. Name the macro (no spaces), assign a shortcut key (optional)
3. Perform Excel actions (e.g., type in a cell)
4. Stop Recording
5. Run it from Developer → Macros

### Example:

```vba
Sub HelloWorld()
    MsgBox "Hello, world!"
End Sub
```

---

### 🧪 Basic Classwork

1. Record a macro that:

   * Types your full name in cell B2
   * Makes the text bold and centers it
2. Write a simple macro that shows a message: “Welcome to VBA Class!”

🎒 Homework:
Create and run a macro that formats range A1\:C3 with yellow fill and black font.

---

## 🔷 Section 2: Intermediate Level

### Variables in VBA

```vba
Dim name As String
name = "Joel"
MsgBox name
```

### Control Structures

#### If...Then...Else

```vba
Sub CheckPass()
    Dim score As Integer
    score = InputBox("Enter your score:")
    If score >= 50 Then
        MsgBox "You passed!"
    Else
        MsgBox "You failed!"
    End If
End Sub
```

#### For Loop

```vba
Sub LoopExample()
    For i = 1 To 10
        Cells(i, 1).Value = i * 2
    Next i
End Sub
```

### Working with Ranges

```vba
Range("A1").Value = "Test"
Range("B1:B5").Interior.Color = vbGreen
```

### Debugging and Error Handling

```vba
On Error GoTo ErrorHandler
Dim x As Integer
x = 1 / 0
Exit Sub

ErrorHandler:
MsgBox "An error occurred!"
```

---

### 🧪 Intermediate Classwork

1. Ask the user for age and check voting eligibility.
2. Populate A1\:A10 with square of 1–10.
3. Format cells with values above 100 in red.

🎒 Homework:
Sum values in column B and show in a message box.

---

## 🔶 Section 3: Advanced Level

### Working with Worksheets & Workbooks

```vba
Sub CreateSheet()
    Worksheets.Add
    ActiveSheet.Name = "Report"
End Sub

Sub CopyData()
    Sheets("Sheet1").Range("A1:B10").Copy _
        Destination:=Sheets("Report").Range("A1")
End Sub
```

### User Forms & Input Boxes

```vba
Dim username As String
username = InputBox("Enter your username")
MsgBox "Welcome, " & username
```

🛠 To insert a UserForm:

* VBA Editor → Insert → UserForm
* Add Labels, TextBoxes, and Buttons

### Worksheet Events

```vba
Private Sub Worksheet_Change(ByVal Target As Range)
    If Target.Column = 1 Then
        MsgBox "You changed column A!"
    End If
End Sub
```

### Workbook Events

```vba
Private Sub Workbook_Open()
    MsgBox "Welcome to this workbook!"
End Sub
```

### Reading External Text File

```vba
Sub GetTextFile()
    Dim line As String
    Open "C:\Users\Joel\Desktop\data.txt" For Input As #1
    Do Until EOF(1)
        Line Input #1, line
        Debug.Print line
    Loop
    Close #1
End Sub
```

---

### 🧪 Advanced Classwork

1. Create a “Summary” sheet and copy A1\:B10 from Sheet1
2. Build a UserForm that collects Name and Email, and inserts into the next empty row
3. Create a macro that displays a message when a row is added

🎒 Homework:
Read numbers in column A and store even numbers in column B

---

✅ Best Practices

* Use Option Explicit for variable declaration
* Use meaningful variable names
* Comment your code using '
* Break code into reusable subs/functions
* Save before running new code

🧪 Recommended Projects

* Expense Tracker
* Auto Email Generator
* Monthly Sales Dashboard
* UserForm-Based Data Entry Tool

---

