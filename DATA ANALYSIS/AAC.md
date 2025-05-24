### Class Note: Session 7 – Data Analysis Using Statistical Functions for Hospital Patient Records

**Date:** June 9, 2025  
**Course:** Introduction to Data Analysis  
**Instructor:** Joel Odufu  
**Topic:** Driving Business Decisions with Statistical Analysis of Hospital Data  

---

#### Introduction
Welcome to **Session 7** of the Introduction to Data Analysis course, focusing on **statistical functions and tools** in Excel to analyze a hospital patient records dataset from a Nigerian hospital (e.g., in Lagos). Building on our macros, Pivot Charts, and DAX modules, this session equips you to extract actionable insights for business decisions in healthcare. Each tool will be applied to optimize hospital operations, improve patient satisfaction, and manage resources effectively. Objectives:  
1. **Apply statistical tools** to summarize and visualize patient data (e.g., wait times, satisfaction scores).  
2. **Validate assumptions** about hospital performance using inferential statistics.  
3. **Optimize operations** with tools like Goal Seek and Solver to support decision-making.  

We’ll use a **Hospital Patient Records Dataset** (Excel), with Nigerian use cases (e.g., school performance, retail) to broaden applicability. By the end, you’ll leverage statistical analysis to drive data-driven decisions, enhancing efficiency and patient care in Nigerian hospitals and other sectors.

**Why Statistical Functions for Business Decisions?**  
- **Importance**: Statistical tools quantify trends, relationships, and optimal solutions, enabling informed decisions.  
- **Usage**: Moving Average forecasts patient demand, Correlation identifies satisfaction drivers, and Solver optimizes staff allocation.  
- **Necessity**: Nigerian hospitals face resource constraints and high patient volumes, requiring data-driven strategies to improve care and efficiency.  
- **Theoretical Background**:  
  - **Descriptive Statistics**: Summarize data (e.g., Histogram, Frequency).  
  - **Inferential Statistics**: Test hypotheses (e.g., F-test, Hypothesis Test).  
  - **Optimization**: Solve constrained problems (e.g., Solver).  
  - Tools are implemented via Excel’s **Analysis ToolPak** and built-in features.  

---

#### Sample Dataset
**Dataset: Hospital Patient Records (Excel)**  
- **Source**: “Hospital_Records.xlsx,” worksheet “Visits.”  
- **Sample Data**:

| Visit ID | Date       | Department | Wait Time (min) | Patients Seen | Satisfaction Score | Staff Hours |
|----------|------------|------------|-----------------|---------------|-------------------|-------------|
| V001     | 01/04/2025 | Emergency  | 30              | 5             | 4                 | 10          |
| V002     | 01/04/2025 | Outpatient | 45              | 8             | 3                 | 12          |
| V003     | 02/04/2025 | Emergency  | 25              | 4             | 5                 | 9           |
| V004     | 02/04/2025 | Outpatient | 50              | 7             | 2                 | 11          |
| V005     | 03/04/2025 | Emergency  | 35              | 6             | 4                 | 10          |
| V006     | 03/04/2025 | Outpatient | 40              | 9             | 3                 | 13          |
| V007     | 04/04/2025 | Emergency  | 20              | 5             | 5                 | 8           |
| V008     | 04/04/2025 | Outpatient | 55              | 6             | 2                 | 12          |
| V009     | 05/04/2025 | Emergency  | 28              | 4             | 4                 | 9           |
| V010     | 05/04/2025 | Outpatient | 60              | 8             | 1                 | 14          |

- **Notes**: Wait Time in minutes, Satisfaction Score (1–5), Staff Hours per shift. Data is clean, stored in C:\Aptech\Data.  
- **Preparation**:  
  - Save “Hospital_Records.xlsx” in C:\Aptech\Data.  
  - Enable Analysis ToolPak: File > Options > Add-ins > Analysis ToolPak > Go > Check > OK.  
  - Enable Solver: File > Options > Add-ins > Solver Add-in > Go > Check > OK.  

---

#### Section 1: Descriptive Statistics (Moving Average, Frequency Distribution, Histogram)

These tools summarize patient data, aiding demand forecasting and resource planning.

##### **Moving Average for a Given Time Period**  
- **Purpose**: Smooths daily Wait Times to predict patient flow trends.  
- **Business Insight**: Helps hospital managers forecast busy periods, adjusting staff schedules to reduce wait times and improve patient satisfaction.  
- **Example Question**: “What’s the 3-day moving average of Wait Time (min)?”  
- **How to Do It**:  
  1. Sort “Visits” by Date (A2:D11).  
  2. Go to **Data** > **Data Analysis** > **Moving Average**.  
  3. Set:  
     - Input Range: D2:D11 (Wait Time).  
     - Interval: 3.  
     - Output Range: E2.  
  4. Click **OK**.  
- **Expected Result** (E4:E11):  
  ```
  | Date       | Wait Time (min) | Moving Average |
  |------------|-----------------|----------------|
  | 01/04/2025 | 30              |                |
  | 01/04/2025 | 45              |                |
  | 02/04/2025 | 25              | 33.33          |
  | 02/04/2025 | 50              | 40.00          |
  | ...        | ...             | ...            |
  ```
  - **Business Decision**: A rising moving average (e.g., ~40 min) signals increasing wait times, prompting managers to add staff during peak days (e.g., 03/04/2025).  
- **Use Case (Retail Sales)**: Smooth daily sales to plan inventory restocking.  
- **Troubleshooting**: Ensure data is sorted by Date; verify Wait Time is numeric.

##### **Frequency Distribution for Observations**  
- **Purpose**: Groups Wait Times into ranges to identify common delays.  
- **Business Insight**: Reveals typical wait time ranges, enabling targeted improvements (e.g., streamlining processes for frequent delays).  
- **Example Question**: “How are Wait Times (min) distributed?”  
- **How to Do It**:  
  1. Create bins in F1:F5: 20, 30, 40, 50, 60.  
  2. Go to **Data** > **Data Analysis** > **Histogram**.  
  3. Set:  
     - Input Range: D2:D11 (Wait Time).  
     - Bin Range: F1:F5.  
     - Output Range: G1.  
  4. Click **OK**.  
- **Expected Result** (G1:H5):  
  ```
  | Bin | Frequency |
  |-----|-----------|
  | 20  | 1         |
  | 30  | 3         |
  | 40  | 2         |
  | 50  | 2         |
  | 60  | 2         |
  ```
  - **Business Decision**: High frequency at 30–40 min suggests most patients face moderate delays; managers can prioritize staff training or triage improvements for this range.  
- **Use Case (School Grades)**: Distribute student grades to identify common performance levels.  
- **Troubleshooting**: Ensure bins are ascending; check Wait Time is numeric.

##### **Histogram**  
- **Purpose**: Visualizes Wait Time distribution for quick insights.  
- **Business Insight**: Provides a visual of delay patterns, helping administrators communicate resource needs to stakeholders (e.g., board members).  
- **Example Question**: “How can we visualize Wait Time distribution?”  
- **How to Do It**:  
  1. Use bins (F1:F5).  
  2. Go to **Data** > **Data Analysis** > **Histogram**.  
  3. Set:  
     - Input Range: D2:D11.  
     - Bin Range: F1:F5.  
     - Check **Chart Output**.  
     - Output Range: H1.  
  4. Click **OK**.  
- **Expected Result** (H1):  
  - Table as above, plus a histogram chart (bars: 20: 1, 30: 3, 40: 2, 50: 2, 60: 2).  
  - **Visual Description**: Bars peak at 30 min, showing most common wait times.  
  - **Business Decision**: The chart highlights a 30-min peak, prompting investments in faster diagnostics to reduce delays, improving patient satisfaction.  
- **Use Case (Retail Inventory)**: Visualize stock levels to plan restocking.  
- **Troubleshooting**: Ensure **Chart Output** is checked; resize chart for clarity.

---

#### Section 2: Inferential Statistics (Hypothesis Test, F-test, Correlation, Covariance)

These tools validate assumptions and identify relationships, guiding strategic decisions.

##### **Hypothesis Test for a Sample Mean**  
- **Purpose**: Tests if the mean Wait Time matches a target (e.g., hospital goal).  
- **Business Insight**: Confirms if current wait times meet service standards, informing whether process improvements are needed.  
- **Example Question**: “Is the mean Wait Time (min) significantly different from 30 minutes?”  
- **How to Do It**:  
  1. Go to **Data** > **Data Analysis** > **t-Test: One-Sample**.  
  2. Set:  
     - Input Range: D2:D11 (Wait Time).  
     - Hypothesized Mean: 30.  
     - Output Range: I1.  
  3. Click **OK**.  
- **Expected Result** (I1):  
  ```
  | t-Test: One-Sample |
  |--------------------|
  | Mean: 38.3         |
  | t Stat: 2.12       |
  | P(T<=t) two-tail: 0.06 |
  ```
  - **Business Decision**: p-value (0.06) > 0.05, suggesting no significant difference from 30 min, but the mean (38.3) is higher, indicating a need for minor process tweaks to meet the 30-min goal.  
- **Use Case (Retail Sales)**: Test if mean daily sales match a target.  
- **Troubleshooting**: Ensure numeric data; exclude headers from input range.

##### **F-test (Two-Sample for Variances)**  
- **Purpose**: Compares variances between departments (e.g., Emergency vs. Outpatient Wait Times).  
- **Business Insight**: Identifies if wait time consistency differs, guiding resource allocation to stabilize service.  
- **Example Question**: “Do Emergency and Outpatient Wait Times have equal variances?”  
- **How to Do It**:  
  1. Filter data: Emergency (D2, D3, D5, D7, D9: 30, 25, 35, 20, 28), Outpatient (D4, D6, D8, D10: 45, 50, 55, 60).  
  2. Copy to J1:J5 (Emergency) and K1:K4 (Outpatient).  
  3. Go to **Data** > **Data Analysis** > **F-Test Two-Sample for Variances**.  
  4. Set:  
     - Variable 1 Range: J1:J5.  
     - Variable 2 Range: K1:K4.  
     - Output Range: L1.  
  5. Click **OK**.  
- **Expected Result** (L1):  
  ```
  | F-Test Two-Sample |
  |-------------------|
  | F: 0.85           |
  | P(F<=f) one-tail: 0.42 |
  ```
  - **Business Decision**: p-value (0.42) > 0.05, indicating similar variances; both departments have consistent wait times, so resources can be allocated evenly.  
- **Use Case (School Attendance)**: Compare attendance variance between classes.  
- **Troubleshooting**: Ensure equal or similar sample sizes; copy filtered data to avoid errors.

##### **Correlation**  
- **Purpose**: Measures relationships between variables (e.g., Wait Time and Satisfaction Score).  
- **Business Insight**: Identifies factors impacting patient satisfaction, prioritizing improvements (e.g., reducing wait times).  
- **Example Question**: “How correlated are Wait Time and Satisfaction Score?”  
- **How to Do It**:  
  1. Go to **Data** > **Data Analysis** > **Correlation**.  
  2. Set:  
     - Input Range: D2:F11 (Wait Time, Patients Seen, Satisfaction).  
     - Output Range: M1.  
  3. Click **OK**.  
- **Expected Result** (M1):  
  ```
  |               | Wait Time | Patients Seen | Satisfaction |
  |---------------|-----------|---------------|--------------|
  | Wait Time     | 1         | 0.65          | -0.88        |
  | Patients Seen | 0.65      | 1             | -0.55        |
  | Satisfaction  | -0.88     | -0.55         | 1            |
  ```
  - **Business Decision**: Strong negative correlation (-0.88) between Wait Time and Satisfaction suggests reducing wait times will significantly boost satisfaction, prioritizing triage or staff additions.  
- **Use Case (Retail)**: Correlate sales and customer ratings.  
- **Troubleshooting**: Ensure numeric data; exclude text columns.

##### **Covariance**  
- **Purpose**: Quantifies how variables change together (e.g., Wait Time and Staff Hours).  
- **Business Insight**: Helps assess if staffing levels align with wait times, informing scheduling adjustments.  
- **Example Question**: “What’s the covariance between Wait Time and Staff Hours?”  
- **How to Do It**:  
  1. Go to **Data** > **Data Analysis** > **Covariance**.  
  2. Set:  
     - Input Range: D2:G11 (Wait Time, Staff Hours).  
     - Output Range: N1.  
  3. Click **OK**.  
- **Expected Result** (N1):  
  ```
  |           | Wait Time | Staff Hours |
  |-----------|-----------|-------------|
  | Wait Time | 165.84    |             |
  | Staff Hours | 15.22   | 3.84        |
  ```
  - **Business Decision**: Positive covariance (15.22) indicates longer wait times with more staff hours, suggesting inefficiencies; managers can review staff productivity or shift allocations.  
- **Use Case (School)**: Covariance between student grades and study hours.  
- **Troubleshooting**: Ensure numeric columns; check input range.

---

#### Section 3: Analyzing Data Using Functions and Sampling

These tools provide quick summaries and random samples for operational insights.

##### **Analyzing Data Using Functions**  
- **Purpose**: Calculates statistics (e.g., mean, median) for Wait Times or Satisfaction.  
- **Business Insight**: Summarizes performance metrics to set benchmarks or monitor service quality.  
- **Example Question**: “What’s the average and median Satisfaction Score?”  
- **How to Do It**:  
  1. In O1, enter `=AVERAGE(F2:F11)`.  
  2. In O2, enter `=MEDIAN(F2:F11)`.  
- **Expected Result**:  
  ```
  | O1: Average | 3.3 |
  | O2: Median  | 3   |
  ```
  - **Business Decision**: Average (3.3) and median (3) indicate moderate satisfaction; managers can target a 4.0 average by addressing wait time issues (from Correlation).  
- **Use Case (Retail)**: Calculate mean and median sales for pricing strategies.  
- **Troubleshooting**: Ensure no blanks or text in range.

##### **Sampling**  
- **Purpose**: Selects random records for audits or focused analysis.  
- **Business Insight**: Enables quality checks (e.g., reviewing patient feedback)