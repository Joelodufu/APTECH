import pandas as pd
import numpy as np

def load_data(filepath):
    """Load the dataset from a CSV file."""
    return pd.read_csv(filepath)

def clean_data(df):
    """Clean the dataset by handling missing values and duplicates."""
    # Check for missing values
    missing_data = df.isnull().sum()
    print(f"Missing Data:\n{missing_data}")
    
    # Fill missing sales data with the mean of the column (if any)
    df['Sales'] = df['Sales'].fillna(df['Sales'].mean())
    
    # Drop duplicate rows if any
    df = df.drop_duplicates()
    
    # Ensure correct date format
    df['Date'] = pd.to_datetime(df['Date'])
    
    return df

def feature_engineering(df):
    """Create new features such as Month, Day of the Week, and Holiday Flag."""
    # Extract month and day of the week from the date
    df['Month'] = df['Date'].dt.month
    df['DayOfWeek'] = df['Date'].dt.weekday
    
    # Add a column to indicate if the date is a holiday (for simplicity, let's mark weekends as holidays)
    df['Holiday'] = np.where(df['DayOfWeek'] >= 5, 1, 0)
    
    return df

def save_cleaned_data(df, output_filepath):
    """Save the cleaned and preprocessed data to a new CSV file."""
    df.to_csv(output_filepath, index=False)
    print(f"Cleaned data saved to {output_filepath}")

def main():
    """Main function to run all preprocessing steps."""
    # Load the dataset
    filepath = 'data/sales_data.csv'  # Change this to your dataset path
    df = load_data(filepath)
    
    # Clean the data
    df = clean_data(df)
    
    # Feature engineering
    df = feature_engineering(df)
    
    # Save the cleaned data
    save_cleaned_data(df, 'data/cleaned_sales_data.csv')

if __name__ == "__main__":
    main()
