### Class Note: Session 7 – Data Analysis Using Statistical Functions for Market Sales

**Date:** June 9, 2025  
**Course:** Introduction to Data Analysis  
**Instructor:** Joel Odufu  
**Topic:** Analyzing Market Sales with Statistical Functions in Excel  

---

#### Introduction
Welcome to **Session 7** of the Introduction to Data Analysis course, focusing on **statistical functions and tools** in Excel to analyze a market sales dataset from a Nigerian market (e.g., Alaba Market). Building on our macros, Pivot Charts, and DAX modules, this session equips you to quantify trends, distributions, relationships, and optimize business scenarios. Objectives:  
1. **Apply statistical functions** to summarize sales data (e.g., Moving Average, Frequency Distribution, Histogram).  
2. **Perform inferential statistics** (e.g., Hypothesis Test, F-test, Correlation) to validate assumptions and relationships.  
3. **Use optimization tools** (e.g., Goal Seek, Solver) to solve business problems.  

We’ll use a **Market Sales Dataset** (Excel), with Nigerian use cases (e.g., school performance, hospital records) to broaden applicability. By the end, you’ll leverage statistical tools to generate data-driven insights, enhancing analysis for Nigerian markets, schools, and organizations.

**Why Statistical Functions and Tools?**  
- **Importance**: Quantify trends, distributions, relationships, and optimize decisions, critical for business and institutional analysis.  
- **Usage**: Moving Average smooths sales trends, Hypothesis Testing validates claims, Solver optimizes pricing, and Histograms visualize distributions.  
- **Necessity**: Nigerian markets and institutions need robust analytics for pricing, inventory, and performance evaluation.  
- **Theoretical Background**:  
  - **Descriptive Statistics**: Summarize data (e.g., Moving Average, Frequency).  
  - **Inferential Statistics**: Draw conclusions (e.g., Hypothesis Test, F-test).  
  - **Optimization**: Solve constrained problems (e.g., Solver).  
  - Tools are implemented via Excel’s **Analysis ToolPak** and built-in features.  

---

#### Sample Dataset
**Dataset: Market Sales (Excel)**  
- **Source**: “Market_Sales.xlsx,” worksheet “Sales.”  
- **Sample Data**:

| Transaction ID | Date       | Vendor   | Product     | Sales (NGN) | Quantity | Customer Rating |
|----------------|------------|----------|-------------|-------------|----------|-----------------|
| T001           | 01/04/2025 | Vendor A | Electronics | 15000       | 2        | 4               |
| T002           | 01/04/2025 | Vendor B | Clothing    | 8000        | 3        | 3               |
| T003           | 02/04/2025 | Vendor A | Electronics | 20000       | 1        | 5               |
| T004           | 02/04/2025 | Vendor C | Food        | 5000        | 5        | 2               |
| T005           | 03/04/2025 | Vendor B | Clothing    | 12000       | 2        | 4               |
| T006           | 03/04/2025 | Vendor C | Food        | 7000        | 4        | 3               |
| T007           | 04/04/2025 | Vendor A | Electronics | 18000       | 2        | 5               |
| T008           | 04/04/2025 | Vendor B | Clothing    | 9000        | 3        | 4               |
| T009           | 05/04/2025 | Vendor C | Food        | 6000        | 6        | 2               |
| T010           | 05/04/2025 | Vendor A | Electronics | 22000       | 1        | 5               |

- **Notes**: Sales in NGN, Customer Rating (1–5). Data is clean, stored in C:\Aptech\Data.  
- **Preparation**:  
  - Save “Market_Sales.xlsx” in C:\Aptech\Data.  
  - Enable Analysis ToolPak: File > Options > Add-ins > Analysis ToolPak > Go > Check > OK.  
  - Enable Solver: File > Options > Add-ins > Solver Add-in > Go > Check > OK.  

---

#### Section 1: Descriptive Statistics (Moving Average, Frequency Distribution, Histogram)

These tools summarize sales trends and distributions.

##### **Moving Average for a Given Time Period**  
- **Purpose**: Smooths daily sales trends for forecasting.  
- **Example Question**: “What’s the 3-day moving average of Sales (NGN)?”  
- **How to Do It**:  
  1. Sort “Sales” by Date (A2:E11).  
  2. Go to **Data** > **Data Analysis** > **Moving Average**.  
  3. Set:  
     - Input Range: E2:E11 (Sales).  
     - Interval: 3.  
     - Output Range: F2.  
  4. Click **OK**.  
- **Expected Result** (F4:F11):  
  ```
  | Date       | Sales (NGN) | Moving Average |
  |------------|-------------|----------------|
  | 01/04/2025 | 15000       |                |
  | 01/04/2025 | 8000        |                |
  | 02/04/2025 | 20000       | 11000          |
  | 02/04/2025 | 5000        | 11000          |
  | 03/04/2025 | 12000       | 11000          |
  | ...        | ...         | ...            |
  ```
  - **Interpretation**: Averages ~11,000 NGN indicate stable sales.  
- **Use Case (School Attendance)**: Smooth daily student attendance.  
- **Troubleshooting**: Ensure data is sorted by Date; check numeric values in Sales.

##### **Frequency Distribution for Observations**  
- **Purpose**: Groups sales into ranges for pricing analysis.  
- **Example Question**: “How are Sales (NGN) distributed?”  
- **How to Do It**:  
  1. Create bins in G1:G5: 5000, 10000, 15000, 20000, 25000.  
  2. Go to **Data** > **Data Analysis** > **Histogram**.  
  3. Set:  
     - Input Range: E2:E11 (Sales).  
     - Bin Range: G1:G5.  
     - Output Range: H1.  
  4. Click **OK**.  
- **Expected Result** (H1:I5):  
  ```
  | Bin   | Frequency |
  |-------|-----------|
  | 5000  | 1         |
  | 10000 | 3         |
  | 15000 | 2         |
  | 20000 | 3         |
  | 25000 | 1         |
  ```
  - **Interpretation**: Most sales (3) are in the 15,000–20,000 range, suggesting a popular price point.  
- **Use Case (Hospital Visits)**: Distribute patient visits by wait time.  
- **Troubleshooting**: Verify bins are in ascending order; ensure Sales is numeric.

##### **Histogram**  
- **Purpose**: Visualizes sales distribution as a chart.  
- **Example Question**: “How can we visualize Sales (NGN) distribution?”  
- **How to Do It**:  
  1. Use the same bins (G1:G5).  
  2. Go to **Data** > **Data Analysis** > **Histogram**.  
  3. Set:  
     - Input Range: E2:E11.  
     - Bin Range: G1:G5.  
     - Check **Chart Output**.  
     - Output Range: I1.  
  4. Click **OK**.  
- **Expected Result** (I1):  
  - Table as above, plus a histogram chart (bars at 5000: 1, 10000: 3, 15000: 2, 20000: 3, 25000: 1).  
  - **Visual Description**: Bar heights reflect frequencies, peaking at 15,000–20,000.  
- **Use Case (School Grades)**: Visualize grade distributions.  
- **Troubleshooting**: Ensure **Chart Output** is checked; adjust chart size if needed.

---

#### Section 2: Inferential Statistics (Hypothesis Test, F-test, Correlation, Covariance)

These tools validate assumptions and measure relationships.

##### **Hypothesis Test for a Sample Mean**  
- **Purpose**: Tests if the mean sales match an expected value.  
- **Example Question**: “Is the mean Sales (NGN) significantly different from 12,000?”  
- **How to Do It**:  
  1. Go to **Data** > **Data Analysis** > **t-Test: One-Sample**.  
  2. Set:  
     - Input Range: E2:E11 (Sales).  
     - Hypothesized Mean: 12000.  
     - Output Range: J1.  
  3. Click **OK**.  
- **Expected Result** (J1):  
  ```
  | t-Test: One-Sample |
  |--------------------|
  | Mean: 12600        |
  | t Stat: 0.45       |
  | P(T<=t) two-tail: 0.66 |
  ```
  - **Interpretation**: p-value (0.66) > 0.05, so no significant difference from 12,000.  
- **Use Case (School Scores)**: Test if mean student score differs from 70.  
- **Troubleshooting**: Ensure Sales is numeric; check input range excludes headers.

##### **F-test (Two-Sample for Variances)**  
- **Purpose**: Compares variances between two groups (e.g., Electronics vs. Clothing sales).  
- **Example Question**: “Do Electronics and Clothing sales have equal variances?”  
- **How to Do It**:  
  1. Filter data for Electronics (E3, E7, E10: 20000, 18000, 22000) and Clothing (E2, E5, E8: 8000, 12000, 9000).  
  2. Go to **Data** > **Data Analysis** > **F-Test Two-Sample for Variances**.  
  3. Set:  
     - Variable 1 Range: Electronics (e.g., K1:K3).  
     - Variable 2 Range: Clothing (e.g., L1:L3).  
     - Output Range: M1.  
  4. Click **OK**.  
- **Expected Result** (M1):  
  ```
  | F-Test Two-Sample |
  |-------------------|
  | F: 1.25           |
  | P(F<=f) one-tail: 0.45 |
  ```
  - **Interpretation**: p-value (0.45) > 0.05, so variances are not significantly different.  
- **Use Case (Hospital Wait Times)**: Compare variance in wait times between departments.  
- **Troubleshooting**: Ensure equal sample sizes or adjust ranges; copy filtered data to new columns.

##### **Correlation**  
- **Purpose**: Measures the strength of relationships between variables (e.g., Sales and Customer Rating).  
- **Example Question**: “How correlated are Sales (NGN) and Customer Rating?”  
- **How to Do It**:  
  1. Go to **Data** > **Data Analysis** > **Correlation**.  
  2. Set:  
     - Input Range: E2:G11 (Sales, Quantity, Rating).  
     - Output Range: N1.  
  3. Click **OK**.  
- **Expected Result** (N1):  
  ```
  |           | Sales | Quantity | Rating |
  |-----------|-------|----------|--------|
  | Sales     | 1     | -0.75    | 0.82   |
  | Quantity  | -0.75 | 1        | -0.65  |
  | Rating    | 0.82  | -0.65    | 1      |
  ```
  - **Interpretation**: Sales-Rating correlation (0.82) is strong positive; higher ratings link to higher sales.  
- **Use Case (School Performance)**: Correlate grades and attendance.  
- **Troubleshooting**: Ensure numeric data; exclude text columns.

##### **Covariance**  
- **Purpose**: Measures how variables change together (e.g., Sales and Quantity).  
- **Example Question**: “What’s the covariance between Sales (NGN) and Quantity?”  
- **How to Do It**:  
  1. Go to **Data** > **Data Analysis** > **Covariance**.  
  2. Set:  
     - Input Range: E2:F11 (Sales, Quantity).  
     - Output Range: O1.  
  3. Click **OK**.  
- **Expected Result** (O1):  
  ```
  |           | Sales     | Quantity |
  |-----------|-----------|----------|
  | Sales     | 28711111  |          |
  | Quantity  | -7500     | 2.84     |
  ```
  - **Interpretation**: Negative covariance (-7500) suggests higher sales with lower quantities.  
- **Use Case (Hospital Records)**: Covariance between patient visits and staff hours.  
- **Troubleshooting**: Ensure input range includes only numeric columns.

---

#### Section 3: Analyzing Data Using Functions and Sampling

These tools provide quick summaries and random samples.

##### **Analyzing Data Using Functions**  
- **Purpose**: Calculate basic statistics (e.g., mean, median) for sales.  
- **Example Question**: “What’s the average and median Sales (NGN)?”  
- **How to Do It**:  
  1. In P1, enter `=AVERAGE(E2:E11)`.  
  2. In P2, enter `=MEDIAN(E2:E11)`.  
- **Expected Result**:  
  ```
  | P1: Average | 12600 |
  | P2: Median  | 10500 |
  ```
  - **Interpretation**: Average (12,600) is higher than median (10,500), indicating skewed sales.  
- **Use Case (School Grades)**: Calculate mean and median grades.  
- **Troubleshooting**: Ensure no text or blanks in range.

##### **Sampling**  
- **Purpose**: Select random data for analysis (e.g., audit sales).  
- **Example Question**: “What are 5 random Sales (NGN) values?”  
- **How to Do It**:  
  1. Go to **Data** > **Data Analysis** > **Sampling**.  
  2. Set:  
     - Input Range: E2:E11.  
     - Random, Number of Samples: 5.  
     - Output Range: Q1.  
  3. Click **OK**.  
- **Expected Result** (Q1:Q5):  
  ```
  | 15000 |
  | 8000  |
  | 20000 |
  | 7000  |
  | 12000 |
  ```
  - **Interpretation**: Random sample for auditing or testing.  
- **Use Case (Hospital Patients)**: Sample patient records for quality checks.  
- **Troubleshooting**: Ensure numeric data; adjust sample size if too large.

---

#### Section 4: Optimization Tools (Goal Seek, Solver)

These tools solve business problems by adjusting variables.

##### **Goal Seek**  
- **Purpose**: Find input values to achieve a target output (e.g., target sales).  
- **Example Question**: “What Quantity achieves 20,000 NGN total sales for T001 (Price = 7500 NGN)?”  
- **How to Do It**:  
  1. In R1, enter `=E2/F2` (Price = Sales/Quantity = 15000/2 = 7500).  
  2. In R2, enter `=R1*F2` (Sales = Price * Quantity).  
  3. Go to **Data** > **What-If Analysis** > **Goal Seek**.  
  4. Set:  
     - Set Cell: R2 (Sales).  
     - To Value: 20000.  
     - By Changing Cell: F2 (Quantity).  
  5. Click **OK**.  
- **Expected Result**:  
  - F2 changes to ~2.67 (Quantity).  
  - R2 shows 20,000 NGN.  
  - **Interpretation**: ~2.67 units achieve the target sales.  
- **Use Case (School Budget)**: Find hours needed for a target tutoring cost.  
- **Troubleshooting**: Ensure formula in R2 depends on F2; avoid locked cells.

##### **Solver**  
- **Purpose**: Optimize under constraints (e.g., maximize profit).  
- **Example Question**: “Maximize profit for Electronics (Price = 10,000 NGN, Cost = 6,000 NGN) with Quantity ≤ 5 and Sales ≤ 50,000 NGN.”  
- **How to Do It**:  
  1. In S1, enter 10000 (Price).  
  2. In S2, enter 6000 (Cost).  
  3. In S3, enter `=S1-S2` (Profit per unit = 4000).  
  4. In S4, enter 3 (Initial Quantity).  
  5. In S5, enter `=S3*S4` (Total Profit = 12000).  
  6. In S6, enter `=S1*S4` (Sales = 30000).  
  7. Go to **Data** > **Solver**.  
  8. Set:  
     - Objective: S5 (Maximize).  
     - By Changing: S4.  
     - Constraints:  
       - S4 <= 5 (Quantity limit).  
       - S6 <= 50000 (Sales limit).  
     - Solver Method: GRG Nonlinear.  
  9. Click **Solve**.  
- **Expected Result**:  
  - S4 changes to 5 (Quantity).  
  - S5 shows 20,000 (Profit).  
  - S6 shows 50,000 (Sales).  
  - **Interpretation**: Max profit is 20,000 NGN at 5 units.  
- **Use Case (Hospital Staffing)**: Optimize nurse hours under budget constraints.  
- **Troubleshooting**: Ensure Solver is enabled; check constraints are numeric.

---

#### Classwork Exercises
1. **Exercise 1: Moving Average**  
   - **Question**: Calculate 3-day moving average for Sales (NGN).  
   - **Task**: Output at T1.  
   - **Expected Result**: Averages ~11,000 NGN.  

2. **Exercise 2: Histogram**  
   - **Question**: Create a histogram for Sales (NGN) with bins 5000–25000.  
   - **Task**: Output at U1.  
   - **Expected Result**: Chart with peak at 15,000–20,000.  

3. **Exercise 3: Hypothesis Test**  
   - **Question**: Test if mean Sales = 12,000 NGN.  
   - **Task**: Output at V1.  
   - **Expected Result**: p-value > 0.05 (no significant difference).  

4. **Exercise 4: Correlation**  
   - **Question**: Correlate Sales and Quantity.  
   - **Task**: Output at W1.  
   - **Expected Result**: Correlation ~-0.75 (negative).  

5. **Exercise 5: Goal Seek**  
   - **Question**: Find Quantity for T002 to achieve 10,000 NGN Sales (Price = 2666.67 NGN).  
   - **Task**: Output at X1.  
   - **Expected Result**: Quantity ~3.75.  

6. **Exercise 6: Solver**  
   - **Question**: Maximize profit for Clothing (Price = 4000 NGN, Cost = 2000 NGN, Quantity ≤ 4, Sales ≤ 15,000 NGN).  
   - **Task**: Output at Y1.  
   - **Expected Result**: Quantity = 3.75, Profit = 7500 NGN.  

---

#### Assessing Understanding (PPUQ)
**Assessment Dataset** (at A50 in “Sales”):  

| Student ID | Student Name | Course of Study | Task ID | Task Question | Accuracy (0–70) | Interpretation (0–20) | Efficiency (0–10) | PPUQ Score (0–100) | Submission Date |
|------------|--------------|-----------------|---------|---------------|-----------------|-----------------------|-------------------|--------------------|----------------|
| S001       | Ada Obi      | Data Analytics  | T1      | Moving Average | 68              | 19                    | 9                 | 96                 | 09/06/2025     |
| S002       | Bola Ade     | Business IT     | T2      | Histogram      | 60              | 15                    | 7                 | 82                 | 09/06/2025     |
| S003       | Chika Eze    | Data Analytics  | T3      | Hypothesis Test | 70             | 20                    | 10                | 100                | 09/06/2025     |
| S004       | Dapo Ojo     | Software Dev    | T4      | Correlation    | 55              | 12                    | 6                 | 73                 | 09/06/2025     |
| S005       | Efe Igho     | Data Analytics  | T5      | Goal Seek      | 65              | 18                    | 8                 | 91                 | 09/06/2025     |

- **Pivot Tables**: Average PPUQ by Course (A60), Student (D60).  
- **Scoring**:  
  - **Accuracy** (70%): Correct tool setup and output.  
  - **Interpretation** (20%): Explain results (e.g., “High Sales-Rating correlation suggests quality drives sales”).  
  - **Efficiency** (10%): Minimal steps and clear outputs.  

---

#### Conclusion
This session equips you to:  
- **Summarize data** with Moving Average, Frequency, and Histograms.  
- **Validate assumptions** using Hypothesis Tests, F-tests, and Correlations.  
- **Optimize decisions** with Goal Seek and Solver.  

Statistical tools are vital for Nigerian analysts, enabling data-driven decisions in markets, schools, and hospitals. Practice these techniques to master analytical reporting.