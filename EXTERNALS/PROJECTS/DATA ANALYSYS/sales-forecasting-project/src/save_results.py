import pandas as pd

def save_predictions(y_test, y_pred, output_filepath):
    """Save the actual vs predicted sales into a CSV file."""
    # Create a DataFrame to store actual vs predicted sales
    results = pd.DataFrame({
        'Actual Sales': y_test,
        'Predicted Sales': y_pred
    })
    
    # Save the results to a CSV file
    results.to_csv(output_filepath, index=False)
    print(f"Predictions saved to {output_filepath}")

def save_evaluation_metrics(mse, mae, r2, output_filepath):
    """Save the evaluation metrics into a CSV file."""
    metrics = pd.DataFrame({
        'Mean Squared Error': [mse],
        'Mean Absolute Error': [mae],
        'R-squared': [r2]
    })
    
    # Save the metrics to a CSV file
    metrics.to_csv(output_filepath, index=False)
    print(f"Evaluation metrics saved to {output_filepath}")

def main():
    """Main function to save predictions and evaluation results."""
    # Example evaluation metrics and predictions (from the model's evaluation)
    mse = 100.5
    mae = 7.5
    r2 = 0.85
    
    # Example actual and predicted sales (replace with your actual data)
    y_test = [50, 60, 70, 80, 90]
    y_pred = [52, 59, 68, 81, 92]
    
    # Save the predictions and evaluation metrics
    save_predictions(y_test, y_pred, 'outputs/forecasts/predictions.csv')
    save_evaluation_metrics(mse, mae, r2, 'outputs/forecasts/evaluation.csv')

if __name__ == "__main__":
    main()
