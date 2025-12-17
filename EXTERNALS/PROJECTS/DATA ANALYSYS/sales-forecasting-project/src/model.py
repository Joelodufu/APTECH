import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, mean_absolute_error, r2_score
from sklearn.model_selection import train_test_split
import pickle
import matplotlib.pyplot as plt

# Load the cleaned dataset
def load_cleaned_data(filepath):
    """Load the cleaned sales data from a CSV file."""
    return pd.read_csv(filepath)

# Split the data into training and testing sets
def split_data(df):
    """Split the data into features (X) and target (y) and perform train-test split."""
    # Features: Month, DayOfWeek, and Holiday
    X = df[['Month', 'DayOfWeek', 'Holiday']]
    # Target: Sales
    y = df['Sales']
    
    # Split the data into training (80%) and testing (20%) sets
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, shuffle=False)
    
    return X_train, X_test, y_train, y_test

# Build and train the model
def train_model(X_train, y_train):
    """Train the Linear Regression model on the training data."""
    model = LinearRegression()
    model.fit(X_train, y_train)  # Fit the model to the training datallkkhyyy[[y]]eewwqqwertyyyyttl;;lkkjjhhggfffdddssaaazzxvvbnnmm,,,....
    return model

# Evaluate the model
def evaluate_model(model, X_test, y_test):
    """Evaluate the trained model on the test data."""
    # Make predictions on the test data
    y_pred = model.predict(X_test)
    
    # Calculate evaluation metrics
    mse = mean_squared_error(y_test, y_pred)  # Mean Squared Error
    mae = mean_absolute_error(y_test, y_pred)  # Mean Absolute Error
    r2 = r2_score(y_test, y_pred)  # R-squared value
    
    # Print the evaluation metrics
    print(f'Mean Squared Error: {mse}')
    print(f'Mean Absolute Error: {mae}')
    print(f'R-squared: {r2}')
    
    return y_pred, y_test

# Save the trained model to a file
def save_model(model, filename):
    """Save the trained model to a file using pickle."""
    with open(filename, 'wb') as f:
        pickle.dump(model, f)
    print(f"Model saved to {filename}")

# Load the saved model from a file
def load_model(filename):
    """Load a previously saved model from a file."""
    with open(filename, 'rb') as f:
        model = pickle.load(f)
    return model

# Visualize the predictions vs actual sales
def visualize_predictions(y_test, y_pred):
    """Visualize the predicted vs actual sales."""
    plt.figure(figsize=(10, 6))
    plt.plot(y_test.index, y_test, label='Actual Sales', color='blue')
    plt.plot(y_test.index, y_pred, label='Predicted Sales', color='red', linestyle='--')
    plt.legend()
    plt.title('Sales Forecasting: Actual vs Predicted Sales')
    plt.xlabel('Date')
    plt.ylabel('Sales')
    plt.show()

def main():
    """Main function to run the entire model pipeline."""
    # Load the cleaned data
    df = load_cleaned_data('data/cleaned_sales_data.csv')  # Update with your dataset path
    
    # Split the data into training and testing sets
    X_train, X_test, y_train, y_test = split_data(df)
    
    # Train the model
    model = train_model(X_train, y_train)
    
    # Evaluate the model
    y_pred, y_test = evaluate_model(model, X_test, y_test)
    
    # Visualize the predictions vs actual sales
    visualize_predictions(y_test, y_pred)
    
    # Save the trained model
    save_model(model, 'outputs/models/sales_forecasting_model.pkl')

if __name__ == "__main__":
    main()
