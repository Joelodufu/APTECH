Perfect timing 🔥 — let’s now move to **Exercise 4: Querying and Managing ChatGPT Data with DAX** using our **main Sales dataset** (`PowerBI_AI_SalesDataset.csv`) and optionally the **extended Customer/Product tables** from Exercise 3.

This exercise is where students **transform the raw dataset into insights** using **DAX measures, calculated columns, and KPIs**.

---

# **Exercise 4: Querying and Managing ChatGPT Data with DAX**

### **Objective**

Students will learn how to:

* Create **calculated columns** and **measures** using DAX.
* Query the ChatGPT-generated dataset inside Power BI.
* Build KPIs and insights (e.g., revenue, profit, customer trends).

---

### **Step 1: Prepare the Dataset**

1. Load **PowerBI_AI_SalesDataset.csv** into Power BI.
2. If available, also load **Customers.csv** and **Products.csv** (from Exercise 3).
3. Create a relationship:

   * Sales[CustomerName] → Customers[CustomerName]
   * Sales[ProductName] → Products[ProductName]

---

### **Step 2: Create Calculated Columns**

Add columns in the **Sales table**:

```DAX
TotalSales = Sales[Quantity] * Sales[UnitPrice]
Profit = Sales[TotalSales] * 0.3   // Assume 30% margin
```

📌 *These make the dataset richer for analysis.*

---

### **Step 3: Create DAX Measures**

Go to **Modeling → New Measure** and create:

1. **Total Revenue**

   ```DAX
   TotalRevenue = SUM(Sales[TotalSales])
   ```

2. **Average Transaction Value**

   ```DAX
   AvgTransaction = AVERAGE(Sales[TotalSales])
   ```

3. **High Value Orders (> $1000)**

   ```DAX
   HighValueOrders = 
   CALCULATE(
       COUNT(Sales[TransactionID]),
       Sales[TotalSales] > 1000
   )
   ```

4. **Average Satisfaction by Region**

   ```DAX
   AvgSatisfaction = AVERAGE(Sales[SatisfactionScore])
   ```

---

### **Step 4: KPI Cards**

1. Insert **KPI Card visuals** for:

   * TotalRevenue
   * AvgTransaction
   * HighValueOrders
   * AvgSatisfaction

📌 *This gives a quick snapshot of sales health.*

---

### **Step 5: Use DAX with ChatGPT-Generated Tables (from Exercise 3)**

If you generated **Customers.csv**:

* Example Measure → *Average Age of Customers per Region*

  ```DAX
  AvgCustomerAge = AVERAGE(Customers[Age])
  ```

* Example Measure → *Sales per Loyalty Level*

  ```DAX
  SalesByLoyalty = 
  SUMX(
      RELATEDTABLE(Sales),
      Sales[TotalSales]
  )
  ```

---

### **Step 6: Visualizations for DAX Measures**

1. Create a **Clustered Column Chart**: TotalRevenue by Region.
2. Create a **Line Chart**: TotalRevenue by TransactionDate (monthly trend).
3. Create a **Table**: CustomerName, LoyaltyLevel, TotalSales.

---

### **Hands-On Task**

1. Create calculated columns for `TotalSales` and `Profit`.
2. Build 4 KPI Cards: TotalRevenue, AvgTransaction, HighValueOrders, AvgSatisfaction.
3. Create a chart showing **Profit by ProductCategory**.
4. (Optional if Customers table exists) → Create a chart showing **Revenue by LoyaltyLevel**.

---

### **Expected Learning Outcome**

By the end of this exercise, students will:
✅ Write **DAX formulas** for calculated columns & measures.
✅ Query ChatGPT-generated datasets using DAX.
✅ Create KPI dashboards with financial & customer metrics.
✅ Understand how DAX enables **data exploration & business insights**.

---

👉 Do you want me to **bundle the DAX formulas into a student “formula sheet”** (like a handout with reusable snippets) so they can reference them during class instead of typing from scratch?
