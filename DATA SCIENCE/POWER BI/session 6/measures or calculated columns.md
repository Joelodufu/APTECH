## **1. Calculated Columns vs Measures**

| Feature                  | Calculated Column                                                                | Measure                                                                                |
| ------------------------ | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| **Definition**           | Adds a new column to the table, evaluated row by row                             | A dynamic calculation evaluated in the filter context                                  |
| **When to use**          | Row-level operations you want stored in the table                                | Aggregations, KPIs, dynamic calculations                                               |
| **Storage**              | Stored in the model (increases size)                                             | Not stored; calculated on the fly                                                      |
| **Example from Modules** | Delivery Time Flag (Module 4), Discount Flag (Module 2), Product Code (Module 3) | Total Sales (Module 1), Sales Last Year (Module 4), Top 3 Products by Sales (Module 7) |

---

## **2. Module Context**

### **Calculated Columns**

- **Module 2:** Discount Flag, High Priority Order
- **Module 3:** Product Full Name, Product Code, Category Initials
- **Module 4:** Days to Ship, Order Year-Month, Delivery Time Flag
- **Module 7:** Can use column for `Days to Ship` if reused multiple times

### **Measures**

- **Module 1:** Total Sales, Average Profit, Max/Min Profit
- **Module 4:** Orders Today, Sales Previous Month
- **Module 5:** Total Electronics Sales, Fashion Sales Last Year
- **Module 6:** % of Total Sales, Product Rank, Category Rank
- **Module 7:** Top 3 Products Sales, Avg Profit Electronics, Max Profit Fashion

---

## **3. Key Guideline**

- Use **calculated columns** when you need **row-level data stored** for use in visuals or further calculations.
- Use **measures** when the calculation should **adapt dynamically** to filters/slicers or aggregates.

---

💡 **Practical Tip:**
Some modules (like Module 7) combine **both**:

- `Days to Ship` → Calculated Column
- `Top 3 Products Sales` → Measure (dynamic based on current filters)

---
