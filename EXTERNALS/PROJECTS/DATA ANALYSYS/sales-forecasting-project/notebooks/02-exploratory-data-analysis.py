
# 02 - Exploratory Data Analysis (EDA)

## Step 1: Import Libraries

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns


## Step 2: Load the Cleaned Dataset

# Load the cleaned dataset
df = pd.read_csv('data/cleaned_sales_data.csv')
df.head()


## Step 3: Check for Missing Data

# Check for any remaining missing values
missing_data = df.isnull().sum()
print(f"Missing Data:{missing_data}")


## Step 4: Data Overview

# Get an overview of the data
df.describe()


## Step 5: Sales Distribution

# Plot the distribution of sales data
plt.figure(figsize=(10, 6))
sns.histplot(df['Sales'], kde=True, color='blue')
plt.title('Distribution of Sales')
plt.xlabel('Sales')
plt.ylabel('Frequency')
plt.show()


## Step 6: Sales by Store

# Visualize sales by store
plt.figure(figsize=(10, 6))
sns.boxplot(x='Store', y='Sales', data=df)
plt.title('Sales Distribution by Store')
plt.show()


## Step 7: Sales by Product

# Visualize sales by product
plt.figure(figsize=(10, 6))
sns.boxplot(x='Product', y='Sales', data=df)
plt.title('Sales Distribution by Product')
plt.show()


## Step 8: Sales Trends Over Time

# Visualizing sales trends over time
plt.figure(figsize=(12, 6))
sns.lineplot(x='Date', y='Sales', data=df, color='green')
plt.title('Sales Trends Over Time')
plt.xlabel('Date')
plt.ylabel('Sales')
plt.show()


## Step 9: Sales by Day of the Week

# Visualize sales by Day of the Week
plt.figure(figsize=(10, 6))
sns.boxplot(x='DayOfWeek', y='Sales', data=df)
plt.title('Sales Distribution by Day of the Week')
plt.show()


## Step 10: Correlation Matrix

# Plot a correlation matrix to understand relationships between variables
plt.figure(figsize=(10, 6))
correlation_matrix = df[['Sales', 'Month', 'DayOfWeek', 'Holiday']].corr()
sns.heatmap(correlation_matrix, annot=True, cmap='coolwarm', fmt='.2f')
plt.title('Correlation Matrix')
plt.show()


