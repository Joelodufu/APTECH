### Class Note: Session 7 – Optimization with Goal Seek and Solver for Retail Shop Sales

**Date:** June 9, 2025  
**Course:** Introduction to Data Analysis  
**Instructor:** Joel Odufu  
**Topic:** Driving Retail Business Decisions with Goal Seek and Solver  

---

#### Introduction
Welcome to a focused segment of **Session 7** in the Introduction to Data Analysis course, emphasizing **Goal Seek** and **Solver** to optimize business operations using a retail shop sales dataset from a Nigerian shop (e.g., an electronics and clothing store in Abuja). Building on our statistical functions, macros, and Pivot Charts, this session equips you to tackle pricing, inventory, and profitability challenges in retail. **Goal Seek** and **Solver** are Excel’s optimization tools that adjust variables to meet targets or maximize outcomes, critical for thriving in Nigeria’s competitive retail market. Objectives:  
1. **Use Goal Seek** to find input values for specific sales targets (e.g., target revenue).  
2. **Apply Solver** to optimize complex scenarios under constraints (e.g., maximizing profit with limited stock).  
3. **Drive business decisions** by interpreting results to boost profitability and efficiency.  

We’ll use a **Retail Shop Sales Dataset** (Excel), with Nigerian use cases (e.g., project bids, school budgeting) to broaden applicability. By the end, you’ll leverage these tools to make data-driven decisions, enhancing success in Nigerian retail and other sectors.

**Why Goal Seek and Solver for Retail Decisions?**  
- **Importance**: These tools solve operational problems by finding optimal inputs or balancing constraints, ensuring efficient resource use.  
- **Usage**: Goal Seek sets prices to hit revenue goals; Solver optimizes stock to maximize profit.  
- **Necessity**: Nigerian retail shops face tight margins, fluctuating demand, and inventory challenges, requiring optimization to stay profitable.  
- **Theoretical Background**:  
  - **Goal Seek**: Iteratively adjusts one variable to achieve a target output (e.g., units sold for a revenue goal).  
  - **Solver**: Uses linear or nonlinear programming to optimize an objective (e.g., profit) under multiple constraints (e.g., stock limits).  

---

#### Sample Dataset
**Dataset: Retail Shop Sales (Excel)**  
- **Source**: “Retail_Sales.xlsx,” worksheet “Sales.”  
- **Sample Data**:

| Transaction ID | Date       | Product     | Price (NGN) | Units Sold | Revenue (NGN) | Cost per Unit (NGN) |
|----------------|------------|-------------|-------------|------------|---------------|---------------------|
| T001           | 01/04/2025 | Smartphone  | 50000       | 3          | 150000        | 40000               |
| T002           | 01/04/2025 | T-Shirt     | 5000        | 10         | 50000         | 3000                |
| T003           | 02/04/2025 | Smartphone  | 50000       | 2          | 100000        | 40000               |
| T004           | 02/04/2025 | Jeans       | 8000        | 5          | 40000         | 5000                |
| T005           | 03/04/2025 | Smartwatch  | 30000       | 4          | 120000        | 25000               |
| T006           | 03/04/2025 | T-Shirt     | 5000        | 8          | 40000         | 3000                |
| T007           | 04/04/2025 | Smartphone  | 50000       | 3          | 150000        | 40000               |
| T008           | 04/04/2025 | Jeans       | 8000        | 6          | 48000         | 5000                |
| T009           | 05/04/2025 | Smartwatch  | 30000       | 2          | 60000         | 25000               |
| T010           | 05/04/2025 | T-Shirt     | 5000        | 12         | 60000         | 3000                |

- **Notes**: Price and Revenue in NGN, Units Sold as integers, Cost per Unit reflects wholesale price. Data is clean, stored in C:\Aptech\Data.  
- **Preparation**:  
  - Save “Retail_Sales.xlsx” in C:\Aptech\Data.  
  - Enable Solver: File > Options > Add-ins > Solver Add-in > Go > Check > OK.  

---

#### Section 1: Goal Seek

##### **What is Goal Seek?**  
Goal Seek is an Excel tool that adjusts one input variable (e.g., Units Sold) to achieve a desired output (e.g., Revenue) by iteratively testing values. It’s like a “what-if” calculator for single-variable problems, ideal for setting precise targets in retail, such as hitting a daily sales goal.

##### **How Does It Help Make Better Business Decisions?**  
- **Pricing and Sales Targets**: Determines how many units to sell or what price to set to meet revenue goals, ensuring profitability.  
- **Inventory Planning**: Helps estimate stock needs for specific sales targets, avoiding overstocking or stockouts.  
- **Example**: A shop manager can find the exact number of smartphones to sell to cover daily operating costs, optimizing sales strategies.  

##### **What If We Don’t Use Goal Seek?**  
- **Risks**: Manual trial-and-error leads to inaccurate sales targets, risking lost revenue or excess inventory.  
- **Consequences**: Without Goal Seek, a shop might overstock smartphones (tying up capital) or understock T-Shirts (missing sales), reducing profits and customer satisfaction.  

##### **Example Question**  
“How many Smartphones (Price = 50,000 NGN) must be sold in Transaction T001 to achieve a Revenue of 200,000 NGN?”  

##### **How to Do It**  
1. **Set Up the Formula**:  
   - In F2, ensure `=D2*E2` (Revenue = Price * Units Sold; for T001: 50000*3=150000 NGN).  

2. **Access Goal Seek**:  
   - Go to **Data** > **What-If Analysis** > **Goal Seek**.  

3. **Configure Goal Seek**:  
   - Set Cell: F2 (Revenue).  
   - To Value: 200000 (target Revenue).  
   - By Changing Cell: E2 (Units Sold).  
   - Click **OK**.  

4. **Expected Result**:  
   - E2 changes to 4 (Units Sold).  
   - F2 shows 200000 NGN (Revenue).  
   - **Business Decision**: Selling 4 Smartphones on 01/04/2025 achieves the 200,000 NGN revenue target, covering daily costs (e.g., rent, salaries). The manager can focus marketing efforts on smartphones, offering promotions to boost sales, or ensure 4 units are in stock.  

##### **Use Case (Project Bids)**  
- **Scenario**: Determine the bid price for a construction project to achieve a target profit, where Profit = Bid Price - Costs.  
- **Decision**: Set competitive bid prices to win contracts while ensuring profitability.  
- **Without Goal Seek**: Guessing bid prices risks underbidding (losses) or overbidding (losing contracts).  

##### **Use Case (School Budgeting)**  
- **Scenario**: Find tutoring hours needed to achieve a target student pass rate, where Pass Rate = 3 * Hours.  
- **Decision**: Allocate hours to meet academic goals within budget constraints.  
- **Without Goal Seek**: Manual estimates may overbudget hours (wasting funds) or underbudget (hurting performance).  

##### **Troubleshooting**:  
- **Formula Error**: Ensure F2 depends on E2 (e.g., `=D2*E2`).  
- **No Solution**: Verify the target (200000) is achievable; reduce if Price * Units cannot reach it.  
- **Locked Cells**: Ensure E2 is not protected (Right-click > Format Cells > Protection > Uncheck Locked).  

---

#### Section 2: Solver

##### **What is Solver?**  
Solver is an Excel add-in that optimizes an objective (e.g., maximize Profit, minimize Costs) by adjusting multiple variables under constraints (e.g., stock limits, budget). Unlike Goal Seek’s single-variable focus, Solver handles complex scenarios with multiple conditions, using mathematical programming to find the best solution.

##### **How Does It Help Make Better Business Decisions?**  
- **Profit Maximization**: Optimizes pricing and inventory to maximize revenue while respecting stock or budget limits.  
- **Resource Allocation**: Balances product quantities to meet demand without overstocking, reducing waste.  
- **Example**: A shop can determine the optimal mix of Smartphones and T-Shirts to sell, maximizing profit while staying within inventory constraints.  

##### **What If We Don’t Use Solver?**  
- **Risks**: Manual planning leads to suboptimal decisions, such as overstocking low-margin products or understocking high-demand items.  
- **Consequences**: Without Solver, a shop might stock too many T-Shirts (low profit margins) and too few Smartphones (high margins), missing profit opportunities, or exceed budget, straining cash flow.  

##### **Example Question**  
“How can we maximize daily Profit for Smartphones and T-Shirts on 01/04/2025, with total Units Sold ≤ 15 and total Cost ≤ 200,000 NGN?”  

##### **How to Do It**  
1. **Set Up the Model**:  
   - In H1, enter 3 (Smartphone Units Sold).  
   - In H2, enter 10 (T-Shirt Units Sold).  
   - In H3, enter `=(H1*(50000-40000))+(H2*(5000-3000))` (Profit = (Smartphone Price - Cost) * Units + (T-Shirt Price - Cost) * Units; 10000*3 + 2000*10 = 50000 NGN).  
   - In H4, enter `=H1+H2` (Total Units Sold; 3+10=13).  
   - In H5, enter `=(H1*40000)+(H2*3000)` (Total Cost; 40000*3 + 3000*10 = 150000 NGN).  

2. **Access Solver**:  
   - Go to **Data** > **Solver**.  
   - Ensure Solver is enabled (see Preparation).  

3. **Configure Solver**:  
   - Objective: H3 (Maximize Profit).  
   - By Changing: H1, H2 (Smartphone and T-Shirt Units Sold).  
   - Constraints:  
     - H1 >= 0, H2 >= 0 (Non-negative units).  
     - H4 <= 15 (Total Units Sold limit, due to shelf space).  
     - H5 <= 200000 (Total Cost limit, due to budget).  
   - Solver Method: Simplex LP (suitable for linear models).  
   - Click **Solve**.  

4. **Expected Result**:  
   - H1 = 5 (Smartphone Units Sold).  
   - H2 = 0 (T-Shirt Units Sold).  
   - H3 = 50000 NGN (Profit; 10000*5 + 2000*0).  
   - H4 = 5 (Total Units).  
   - H5 = 200000 NGN (Total Cost; 40000*5).  
   - **Business Decision**: Selling 5 Smartphones and 0 T-Shirts on 01/04/2025 maximizes profit (50,000 NGN) within constraints, as Smartphones have higher margins (10,000 NGN vs. 2,000 NGN). The manager can prioritize Smartphone stock, adjust marketing to focus on electronics, and avoid overstocking low-margin T-Shirts, optimizing inventory and cash flow.  

##### **Use Case (Project Bids)**  
- **Scenario**: Maximize profit from multiple project bids (Profit = Bid Price - Costs) with total labor hours ≤ 500 and budget ≤ 10,000,000 NGN.  
- **Decision**: Select optimal bids to maximize returns while staying within resource limits.  
- **Without Solver**: Choosing bids manually risks low profits or exceeding labor capacity, delaying projects.  

##### **Use Case (School Budgeting)**  
- **Scenario**: Maximize student performance (Score = Hours * Impact) with tutoring hours ≤ 100 and budget ≤ 500,000 NGN.  
- **Decision**: Allocate hours to high-impact subjects, improving pass rates cost-effectively.  
- **Without Solver**: Random hour allocation may waste funds on low-impact areas, reducing academic outcomes.  

##### **Troubleshooting**:  
- **Solver Not Found**: Verify Solver add-in is enabled.  
- **No Solution**: Check constraints (e.g., H5 <= 200000 may be too restrictive); increase budget or units if needed.  
- **Incorrect Results**: Ensure H3 formula depends on H1, H2; use Simplex LP for linear models.  

---

#### Classwork Exercises
1. **Exercise 1: Goal Seek**  
   - **Question**: Find Units Sold for T002 (T-Shirt, Price = 5000 NGN) to achieve a Revenue of 75,000 NGN.  
   - **Task**: Use Goal Seek on F3 (`=D3*E3`), output at E3.  
   - **Expected Result**: E3 = 15 (Units Sold), F3 = 75000 NGN.  
   - **Business Decision**: Stock 15 T-Shirts to hit the revenue target, ensuring sufficient inventory and planning promotions to drive sales.  

2. **Exercise 2: Solver**  
   - **Question**: Maximize Profit for Smartwatch and Jeans on 03/04/2025 (Smartwatch: Price = 30000, Cost = 25000; Jeans: Price = 8000, Cost = 5000) with total Units Sold ≤ 10 and total Cost ≤ 100,000 NGN.  
   - **Task**: Set up model in I1 (Smartwatch Units = 4), I2 (Jeans Units = 5), I3 (`=(I1*(30000-25000))+(I2*(8000-5000))`), I4 (`=I1+I2`), I5 (`=(I1*25000)+(I2*5000)`), use Solver, output at I3.  
   - **Expected Result**: I1 = 0, I2 = 10, I3 = 30000 NGN (Profit), I4 = 10, I5 = 50000 NGN.  
   - **Business Decision**: Stock 10 Jeans and 0 Smartwatches to maximize profit (30,000 NGN), as Jeans have a higher relative margin in this scenario; focus inventory and marketing on clothing.  

3. **Exercise 3: Goal Seek (Use Case: Project Bids)**  
   - **Question**: Find the bid price for a project to achieve a profit of 2,000,000 NGN, where Profit = Bid Price - 5,000,000 (Costs).  
   - **Task**: Set up formula in J1 (`=K1-5000000`), K1 (Bid Price = 6000000), use Goal Seek, output at J1.  
   - **Expected Result**: K1 = 7000000 NGN, J1 = 2000000 NGN.  
   - **Business Decision**: Bid at 7,000,000 NGN to secure the profit target, ensuring competitiveness while covering costs.  

4. **Exercise 4: Solver (Use Case: School Budgeting)**  
   - **Question**: Maximize student performance (Score = 5*Math Hours + 3*English Hours) with total Hours ≤ 50 and Cost (10000*Math + 8000*English) ≤ 400,000 NGN.  
   - **Task**: Set up model in L1 (Math Hours = 20), L2 (English Hours = 20), L3 (`=5*L1+3*L2`), L4 (`=L1+L2`), L5 (`=10000*L1+8000*L2`), use Solver, output at L3.  
   - **Expected Result**: L1 = 40, L2 = 0, L3 = 200 (Score), L4 = 40, L5 = 400000 NGN.  
   - **Business Decision**: Allocate 40 Math hours to maximize performance, as Math has higher impact, optimizing budget use.  

---

#### Assessing Understanding (PPUQ)
**Assessment Dataset** (at A50 in “Sales”):  

| Student ID | Student Name | Course of Study | Task ID | Task Question | Accuracy (0–70) | Interpretation (0–20) | Efficiency (0–10) | PPUQ Score (0–100) | Submission Date |
|------------|--------------|-----------------|---------|---------------|-----------------|-----------------------|-------------------|--------------------|----------------|
| S001       | Ada Obi      | Data Analytics  | T1      | Goal Seek T002 | 68              | 19                    | 9                 | 96                 | 09/06/2025     |
| S002       | Bola Ade     | Business IT     | T2      | Solver Retail  | 60              | 15                    | 7                 | 82                 | 09/06/2025     |
| S003       | Chika Eze    | Data Analytics  | T3      | Goal Seek Bids | 70              | 20                    | 10                | 100                | 09/06/2025     |
| S004       | Dapo Ojo     | Software Dev    | T4      | Solver School  | 55              | 12                    | 6                 | 73                 | 09/06/2025     |
| S005       | Efe Igho     | Data Analytics  | T4      | Solver School  | 65              | 18                    | 8                 | 91                 | 09/06/2025     |

- **Pivot Tables**: Average PPUQ by Course (A60), Student (D60).  
- **Scoring**:  
  - **Accuracy** (70%): Correct formula setup, Goal Seek configuration, and Solver constraints.  
  - **Interpretation** (20%): Explain business decisions (e.g., “Selling 5 Smartphones maximizes profit by focusing on high-margin products”).  
  - **Efficiency** (10%): Simple formulas and minimal steps for setup.  

---

#### Conclusion
This session equips you to:  
- **Use Goal Seek** to set precise sales targets (e.g., units sold for revenue goals), ensuring profitability and inventory alignment.  
- **Apply Solver** to optimize complex retail scenarios (e.g., maximize profit within stock and budget limits), balancing resources and margins.  
- **Drive decisions** that enhance profitability and efficiency in Nigerian retail shops.  

Without **Goal Seek** and **Solver**, retailers risk inefficient pricing, overstocking, or missed profits, undermining competitiveness. These tools empower data-driven decisions, critical for success in retail, project bids, schools, and beyond. Practice them to master optimization.