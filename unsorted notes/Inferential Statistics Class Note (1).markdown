# Class Note: Inferential Statistics for Decision-Making

**Subject**: Introduction to Inferential Statistics  
**Target Audience**: Beginners with basic Excel knowledge  
**Objective**: Students will learn **hypothesis testing**, **F-test**, **correlation**, and **covariance**, **and** apply these tools in Excel to make data-driven business decisions.  
**Duration**: 2 hours  
**Materials Needed**: Laptops with Excel, sample dataset (provided)  

---

## Introduction: What is Inferential Statistics?

**Inferential statistics** enables conclusions about a large group (a **population**) using a smaller sample. For example, a retailer might survey 100 customers to predict buying habits across thousands.  

- **Why it’s useful**: Saves time and resources by analyzing samples.  
- **How it helps decisions**: Provides evidence for decisions like launching products, optimizing campaigns, or improving processes.  

---

## Sample Dataset: Coffee Shop Sales

We’ll use a dataset from a coffee shop testing two marketing campaigns: **New Campaign** (social media ads) vs. **Standard Campaign** (flyers). The goal is to analyze customer spending and visits to decide which campaign is better.

### Dataset Description
- **Columns**:  
  - **Customer ID**: Unique identifier.  
  - **Campaign**: “New” or “Standard”.  
  - **Spending**: Weekly spending ($).  
  - **Visit Frequency**: Weekly visits.  
- **Sample Size**: 10 customers per campaign (20 total).  

### Dataset
| Customer ID | Campaign | Spending | Visit Frequency |
|-------------|----------|----------|-----------------|
| 1           | New      | 50       | 4               |
| 2           | New      | 55       | 5               |
| 3           | New      | 52       | 4.5             |
| 4           | New      | 60       | 6               |
| 5           | New      | 48       | 4               |
| 6           | New      | 58       | 5.5             |
| 7           | New      | 45       | 3.5             |
| 8           | New      | 53       | 5               |
| 9           | New      | 49       | 4               |
| 10          | New      | 62       | 6               |
| 11          | Standard | 40       | 3               |
| 12          | Standard | 42       | 3.5             |
| 13          | Standard | 45       | 4               |
| 14          | Standard | 41       | 3               |
| 15          | Standard | 43       | 3.5             |
| 16          | Standard | 39       | 2.5             |
| 17          | Standard | 46       | 4               |
| 18          | Standard | 38       | 2               |
| 19          | Standard | 42       | 3               |
| 20          | Standard | 47       | 4               |

**Setup in Excel**:  
1. Open Excel and create a new spreadsheet.  
2. Enter headers in row 1: “Customer ID” (A1), “Campaign” (B1), “Spending” (C1), “Visit Frequency” (D1).  
3. Enter the data in rows 2–21.  
4. Save as “Coffee_Shop_Data.xlsx”.  

---

## Concept 1: Hypothesis Testing

### What It Is
Hypothesis testing checks if a difference between groups is significant. We’ll test if the **New Campaign** increases spending compared to the **Standard Campaign**.  
- **Null Hypothesis (H₀)**: Average spending is the same for both campaigns.  
- **Alternative Hypothesis (H₁)**: New Campaign has higher spending.  

### Why It Matters
Confirms if a campaign’s effect is real, guiding investment decisions.

### Excel Steps
1. **Organize Data**:  
   - Column F: “New Spending” (F1), enter 50, 55, 52, 60, 48, 58, 45, 53, 49, 62 (F2:F11).  
   - Column G: “Standard Spending” (G1), enter 40, 42, 45, 41, 43, 39, 46, 38, 42, 47 (G2:G11).  
2. **Enable Data Analysis ToolPak**:  
   - Go to **File > Options > Add-ins**, select “Analysis ToolPak”, click “Go”, enable it.  
3. **Run t-test**:  
   - Go to **Data > Data Analysis > t-Test: Two-Sample Assuming Equal Variances**.  
   - Set “Variable 1 Range” to F2:F11, “Variable 2 Range” to G2:G11, “Hypothesized Mean Difference” to 0, check “Labels”, output to I1.  
   - Click “OK”.  
4. **Interpret**:  
   - Check “P(T<=t) one-tail”. If p < 0.05, reject H₀.  
   - **Expected result**: p ≈ 0.0001, New Campaign likely increases spending.

### Classwork
1. Run the t-test in Excel. Record the p-value and mean spending for each campaign.  
2. Decide: Should the coffee shop adopt the New Campaign? Justify using the p-value.  
3. Modify the dataset: Change the highest New Campaign spending (62) to 40. Rerun the t-test. Does the decision change? Why?  
4. Calculate the average spending manually using `=AVERAGE(F2:F11)` and `=AVERAGE(G2:G11)`. Compare with t-test output.  

**Expected Outcome**: Students confirm the New Campaign’s effectiveness and learn how data changes affect results.

### Business Question & Solution
**Question**: A retailer tests two checkout systems (A and B) to compare average wait times. How would hypothesis testing decide which system is faster? What does a p-value of 0.03 mean?  

**Solution**:  
- **Approach**: Use a t-test to compare mean wait times. H₀: Mean wait times are equal; H₁: System A is faster (one-tailed). Collect wait time data for both systems (e.g., 10 customers each). Run the t-test in Excel.  
- **p-value = 0.03**: Since p < 0.05, reject H₀, suggesting System A is significantly faster.  
- **Decision**: Adopt System A to improve customer experience and reduce queues, potentially increasing sales.  

---

## Concept 2: F-test

### What It Is
The **F-test** compares variances (data spread) of two groups. We’ll test if spending variance differs between campaigns. Lower variance indicates more predictable spending.

### Why It Matters
Consistency> Consistent spending helps budget planning and forecasting.

### Excel Steps
1. **Use Data**: F2:F11 (New Spending), G2:G11 (Standard Spending).  
2. **Run F-test**:  
   - Go to **Data > Data Analysis > F-Test Two-Sample for Variances**.  
   - Set “Variable 1 Range” to F2:F11, “Variable 2 Range” to G2:G11, check “Labels”, output to K1.  
   - Click “OK”.  
3. **Interpret**:  
   - If p-value < 0.05, variances differ.  
   - **Expected result**: p ≈ 0.4, similar variances.

### Classwork
1. Run the F-test. Record the F-statistic and p-value. Are variances significantly different?  
2. Calculate variances manually: `=VAR.S(F2:F11)` and `=VAR.S(G2:G11)`. Compare with F-test output.  
3. If the New Campaign’s variance was half the Standard’s, would you recommend it even if means were similar? Justify.  
4. Add an outlier to New Spending (e.g., change 62 to 100). Rerun the F-test. How does the p-value change?  

**Expected Outcome**: Students understand variance and its impact on reliability.

### Business Question & Solution
**Question**: A factory tests two machines for part production. Machine A’s parts vary widely in size; Machine B’s are consistent. How would an F-test decide which to use? Why might consistency matter?  

**Solution**:  
- **Approach**: Use an F-test to compare variances in part sizes. H₀: Variances are equal; H₁: Variances differ. Collect size data (e.g., 10 parts per machine). Run the F-test in Excel.  
- **Interpretation**: If p < 0.05 (e.g., p = 0.02), Machine B’s lower variance is significant.  
- **Decision**: Choose Machine B for consistent quality, reducing defects and customer complaints, even if average sizes are similar. Consistency ensures predictable production and cost savings.  

---

## Concept 3: Correlation

### What It Is
**Correlation** measures how strongly two variables move together, using the correlation coefficient (**r**, -1 to 1). We’ll check if **Visit Frequency** and **Spending** are correlated.  
- **r ≈ 1**: More visits, more spending.  
- **r ≈ 0**: No relationship.  

### Why It Matters
Identifies drivers of revenue, like visits increasing sales.

### Excel Steps
1. **Prepare Data**: Use C2:C21 (Spending), D2:D21 (Visit Frequency).  
2. **Calculate**: In I13, enter `=CORREL(C2:C21,D2:D21)`.  
3. **Interpret**:  
   - **Expected result**: r ≈ 0.92, strong positive correlation.

### Classwork
1. Calculate the correlation. Record **r**. Is it positive or negative?  
2. Create a scatter plot (**Insert > Scatter**) of Spending vs. Visit Frequency. Does it visually confirm the correlation?  
3. Change one Visit Frequency (e.g., 6 to 2). Rerun the correlation. How does **r** change?  
4. If r = 0.92, propose one business action (e.g., loyalty program). Justify.  

**Expected Outcome**: Students link visits to spending and propose strategies.

### Business Question & Solution
**Question**: A gym finds a correlation of 0.8 between workout frequency and membership renewals. How could this guide strategy? What if r = -0.2?  

**Solution**:  
- **r = 0.8**:  
  - **Insight**: Frequent workouts strongly predict renewals.  
  - **Strategy**: Offer incentives (e.g., free classes) to increase workout frequency, boosting retention.  
  - **Decision**: Invest in programs that encourage regular visits, like challenges or rewards.  
- **r = -0.2**:  
  - **Insight**: Weak negative correlation; frequent workouts slightly reduce renewals.  
  - **Strategy**: Investigate why (e.g., overtraining, poor experience). Focus on improving member satisfaction instead.  
  - **Decision**: Survey frequent members to address issues, avoiding wasted effort on frequency alone.  

---

## Concept 4: Covariance

### What It Is
**Covariance** shows if two variables move together (positive) or oppositely (negative). We’ll calculate covariance between **Spending** and **Visit Frequency**.

### Why It Matters
Confirms relationships, predicting how visit changes affect spending.

### Excel Steps
1. **Run Covariance**:  
   - Go to **Data > Data Analysis > Covariance**.  
   - Set “Input Range” to C2:D21, check “Labels in first row”, output to M1.  
   - Click “OK”.  
2. **Interpret**:  
   - Find Spending-Visit Frequency covariance