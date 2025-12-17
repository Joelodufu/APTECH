# Lesson 4 — **Advanced Drill Through: Buttons & Cross-report**


## Learning Objectives

By the end of Lesson 4, students will be able to:

* Add and configure **drill-through buttons** in Power BI.
* Differentiate between **context-based drill-through** (right-click) and **button-based drill-through**.
* Set up and use **cross-report drill-through**.
* Apply drill-through to real-world user experience design.

---

## Prerequisites & Materials

* Use **PowerBI_DrillThrough_Dataset_v2.xlsx** (with stores, customers, products, complaints).
* Pages already built: `Product Details`, `Customer Details`, `Store Details`.
* Basic drill-through functionality working.
* (Optional) A second report file for demonstrating cross-report drill-through.

---

# Step-by-Step Class Script

---

### Part A — Introduction to Advanced Drill-through

1. Recap previous lessons:

   * Lesson 1: Drill into a product.
   * Lesson 2: Drill into a customer.
   * Lesson 3: Drill into a store.
2. Highlight limitations of **right-click drill-through**:

   * Some users may not know the feature exists.
   * It hides powerful insights behind a right-click menu.
3. Introduce **Drill-through buttons**:

   * Visible, user-friendly navigation.
   * Can be styled as “Go to Customer Details” or “View Store Report”.

---

### Part B — Add a Drill-through Button (Example: Customer Page)

1. Go to the **Regional Overview** page.
2. Insert → **Button → Drill-through**.
3. In the button’s **Action settings** (Format pane):

   * Action = Drill-through.
   * Destination = `Customer Details`.
4. Insert a card or table showing a customer (e.g., `Customers[Name]`).
5. Click a customer → the button lights up → click the button → navigates to `Customer Details`.
6. Add a text label: *“View Selected Customer Profile”*.

**Teaching point**: This makes drill-through discoverable and easy to use, especially for executives.

---

### Part C — Add Multiple Drill-through Buttons

1. On `Regional Overview`:

   * Add a **Store Drill-through button** → Destination = `Store Details`.
   * Add a **Product Drill-through button** → Destination = `Product Details`.
2. Arrange buttons in a menu-like layout (e.g., “Analyze Store” / “Analyze Product” / “Analyze Customer”).
3. Demo the behavior: Buttons only activate when a valid field is selected.

---

### Part D — Dynamic Titles on Drill-through Pages

1. On `Customer Details` page: Add a dynamic title with DAX:

   ```dax
   Page Title =
   "Customer Profile — " & SELECTEDVALUE(Customers[Name], "No Customer Selected")
   ```
2. Do the same for Store and Product pages.
3. Show students how **dynamic titles** make navigation clearer when using buttons.

---

### Part E — Cross-report Drill-through (Advanced)

1. **Concept**: Sometimes you want to jump from one report to another (e.g., from a corporate overview to a customer service report).
2. Requirements:

   * The **target report** must have drill-through page(s).
   * The **field names** used for drill-through must match across both reports.
3. Steps to set it up:

   * In Power BI Desktop → File → Options → **Current File → Report settings**.
   * Enable **Allow cross-report drill-through**.
   * In the target report (e.g., `Customer Details.pbix`), add drill-through fields (`CustomerID`).
   * Publish both reports to the same **Power BI Service workspace**.
   * In the source report, right-click on a customer → Drill through → navigate to target report.
4. Demo:

   * From a high-level “Sales Summary” report → drill into another report dedicated to “Customer Support Analysis.”

**Teaching point**: Cross-report drill-through is powerful for **modular report design** — separating finance, sales, and operations reports, but still connecting them.

---

### Part F — Exercises

#### **Exercise 1 (Button Basics)**

* Add a drill-through button on `Regional Overview` → link it to `Store Details`.
* Style the button with a custom label (“View Store Performance”).

#### **Exercise 2 (Button Menu)**

* Create a small panel with 3 drill-through buttons: Customer, Product, Store.
* Test with different visuals to activate buttons.

#### **Exercise 3 (Dynamic Title)**

* On `Product Details`, add a dynamic title: *“Product Performance — [Product Name]”*.

#### **Exercise 4 (Cross-report Drill-through)**

* (Optional, if Service access available): Set up cross-report drill-through between a **Sales Report** and a **Complaints Report**.

---

### Part G — Troubleshooting Notes

* **Button stays greyed out**: No valid context is selected (make sure a Customer/Store/Product is chosen).
* **Cross-report drill-through not working**:

  * Field names don’t match across reports.
  * Reports not published to same workspace.
  * Cross-report drill-through not enabled in Options.
* **Dynamic title shows “No value”**: Means no selection was passed in.

---

### Assessment (Quick Quiz)

1. Why might you prefer drill-through buttons over right-click drill-through?
   *Answer: More user-friendly and discoverable.*

2. What must be true for cross-report drill-through to work?
   *Answer: Field names must match in both reports and reports must be in the same workspace.*

3. How do you make a drill-through button show a specific selected customer’s name?
   *Answer: Use a dynamic title or measure with `SELECTEDVALUE(Customers[Name])`.*

---

### Teacher Demo Script (Live)

* *“Notice the drill-through button at the bottom — watch how it lights up when I select a customer.”*
* *“Instead of right-clicking, I just click the button, and boom — I’m in the Customer Details page.”*
* *“Now let’s step it up — I’ve got another report in Power BI Service. With cross-report drill-through, I can move from sales into customer complaints instantly.”*

---

✅ **End of Lesson 4**: Students now know how to use **drill-through buttons** and set up **cross-report drill-through**, giving them tools to design professional, user-friendly Power BI reports.

---
