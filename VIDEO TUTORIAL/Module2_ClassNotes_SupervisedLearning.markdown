# Foundations of AI and Machine Learning - Module 2 Class Notes

## Session 1: Understanding Supervised Learning
### Sub-session 1.1: Core Concepts of Supervised Learning
- **Teacher Entry:** "Having explored AI foundations, let’s dive into how machines learn with guidance. Welcome to the Core Concepts of Supervised Learning!"
- **Supervised Learning:** A machine learning approach using labeled data to train models for prediction or classification.
  - **Explanation:** Models learn from input-output pairs (e.g., emails labeled as spam/not spam) to generalize.
  - **Analogy:** A student with a graded workbook, or a chef refining a dish with taste feedback.
  - **Relevance to Present:** Powers ChatGPT (OpenAI) and Grok (xAI) for text tasks.
- **Class Work Sub-sub-session 1.1.1: Class Work - Install ML Libraries**
  - **Activity:** Install Pandas and Scikit-learn for supervised learning.
  - **Resources:** Guide, terminal.
  - **Step-by-Step Guide:**
    1. Open terminal.
    2. Type `pip install pandas` and press Enter; wait for “Successfully installed.”
    3. Type `pip install scikit-learn` and press Enter; wait for “Successfully installed.”
    4. Open Jupyter with `jupyter notebook`.
    5. Create a new notebook, type `import pandas as pd; import sklearn`, run with `Shift + Enter`, expect no errors.
  - **Analogy:** Equipping a kitchen with cooking tools.

### Sub-session 1.2: Tasks and Examples
- **Teacher Entry:** "With concepts clear, let’s see what supervised learning can achieve. Welcome to Tasks and Examples!"
- **Classification:** Predicts categories (e.g., spam detection in ELIZA, Gemini).
  - **Explanation:** Assigns labels based on training data.
  - **Analogy:** Sorting mail into bins, or identifying fruit types.
- **Regression:** Predicts continuous values (e.g., house prices in Meta AI).
  - **Explanation:** Estimates numbers from features.
  - **Analogy:** Guessing a fish’s weight, or predicting car speed.
- **Class Work Sub-sub-session 1.2.1: Class Work - Identify Task Types**
  - **Activity:** Categorize tasks as classification or regression.
  - **Resources:** Task list handout.
  - **Step-by-Step Guide:**
    1. Get the task list (e.g., email sorting, house price).
    2. Pair up with a classmate.
    3. Discuss each task’s type (category or number).
    4. Write answers (e.g., “Email: Classification”).
    5. Compare with teacher’s key.
  - **Analogy:** Solving a sorting puzzle.

### Sub-session 1.3: Activity - Quiz
- **Teacher Entry:** "Let’s test our understanding of these tasks. Welcome to the Activity - Quiz!"
- **Class Work Sub-sub-session 1.3.1: Class Work - Take the Quiz**
  - **Activity:** Complete a 10-question quiz on classification vs. regression.
  - **Resources:** Quiz handout, answer sheet.
  - **Step-by-Step Guide:**
    1. Collect handout and sheet from the teacher.
    2. Work individually.
    3. Answer questions (e.g., “Grade prediction: regression”).
    4. Finish in 10 minutes, submit.
    5. Review with the teacher.
  - **Analogy:** A quick recipe test.

## Session 2: Model Building
### Sub-session 2.1: Linear Regression
- **Teacher Entry:** "With tasks in mind, let’s build our first model. Welcome to Linear Regression!"
- **Linear Regression:** Fits a line to predict numerical values.
  - **Explanation:** Uses least squares to model relationships.
  - **Analogy:** Drawing a trend line on a graph.
  - **Relevance to Present:** Used in Meta AI for pricing.
- **Class Work Sub-sub-session 2.1.1: Class Work - Write Linear Regression Code**
  - **Activity:** Create and run a linear regression script.
  - **Resources:** `house_data.csv`, Jupyter Notebook.
  - **Step-by-Step Guide:**
    1. Open Jupyter with `jupyter notebook`.
    2. Click “New” > “Python 3.”
    3. Type `import pandas as pd; from sklearn.linear_model import LinearRegression` and press `Shift + Enter`.
    4. Download `house_data.csv`, save it.
    5. Type `data = pd.read_csv('house_data.csv'); X = data[['size']]; y = data['price']` and press `Shift + Enter`.
    6. Type `model = LinearRegression(); model.fit(X, y); predictions = model.predict(X); print(predictions)` and press `Shift + Enter` (e.g., [150000, 200000]).
    7. Save as `LinearRegression.ipynb`.
  - **Expected Output:** Price predictions.

### Sub-session 2.2: Classification with Logistic Regression
- **Teacher Entry:** "Expanding our skills, let’s tackle classification. Welcome to Classification with Logistic Regression!"
- **Logistic Regression:** Predicts categories using a probability curve.
  - **Explanation:** Models binary outcomes (e.g., yes/no).
  - **Analogy:** Weighing odds in a coin flip.
  - **Significance:** Powers spam filters in Gemini.
- **Class Work Sub-sub-session 2.2.1: Class Work - Write Logistic Regression Code**
  - **Activity:** Create and run a logistic regression script.
  - **Resources:** `spam_data.csv`, Jupyter Notebook.
  - **Step-by-Step Guide:**
    1. Download `spam_data.csv` from the link.
    2. Open Jupyter, create a new notebook.
    3. Type `import pandas as pd; from sklearn.linear_model import LogisticRegression` and press `Shift + Enter`.
    4. Type `data = pd.read_csv('spam_data.csv'); X = data[['word_count']]; y = data['spam']` and press `Shift + Enter`.
    5. Type `model = LogisticRegression(); model.fit(X, y); predictions = model.predict(X); print(predictions)` and press `Shift + Enter` (e.g., [0, 1, 0]).
    6. Save as `LogisticRegression.ipynb`.
  - **Expected Output:** Spam predictions (0/1).

## Session 3: Evaluation and Improvement
### Sub-session 3.1: Metrics
- **Teacher Entry:** "To refine our models, let’s measure their success. Welcome to Metrics!"
- **Accuracy:** Percentage of correct predictions.
  - **Explanation:** Assesses overall performance.
  - **Analogy:** Quiz score.
- **Mean Squared Error (MSE):** Average squared error for regression.
  - **Explanation:** Measures prediction deviation.
  - **Analogy:** Distance of missed darts.
- **Class Work Sub-sub-session 3.1.1: Class Work - Calculate Metrics**
  - **Activity:** Compute accuracy and MSE manually.
  - **Resources:** Sample data, calculator.
  - **Step-by-Step Guide:**
    1. Get data (e.g., Predicted: [100, 200], Actual: [110, 190]; Predicted: [0, 1], Actual: [0, 1]).
    2. Group of 3.
    3. For MSE: Difference (10, -10), square (100, 100), sum (200), divide by 2 (100).
    4. For Accuracy: Correct (2/2=100%).
    5. Record and discuss.
  - **Analogy:** Scoring a game.

### Sub-session 3.2: Overfitting and Underfitting
- **Teacher Entry:** "Understanding pitfalls, let’s address model fit. Welcome to Overfitting and Underfitting!"
- **Overfitting:** Too much detail, seen in ALVINN.
  - **Explanation:** Poor generalization.
  - **Analogy:** Memorizing a test.
- **Underfitting:** Too simple, affects Meta AI.
  - **Explanation:** Misses patterns.
  - **Analogy:** Blunt tool.
- **Class Work Sub-sub-session 3.2.1: Class Work - Analyze Fit Issues**
  - **Activity:** Identify fit issues in graphs.
  - **Resources:** Graph examples.
  - **Step-by-Step Guide:**
    1. Collect graphs from the teacher.
    2. Pair up.
    3. Note overfitting (e.g., wild curves) on one graph.
    4. Note underfitting (e.g., straight line) on another.
    5. Suggest fixes, record.
  - **Analogy:** Diagnosing a car.

## Session 4: Reflection
### Sub-session 4.1: Personal Insights
- **Teacher Entry:** "After building models, let’s reflect. Welcome to Personal Insights!"
- **Class Work Sub-sub-session 4.1.1: Class Work - Reflect and Share**
  - **Activity:** Write and discuss a reflection.
  - **Resources:** Paper or doc.
  - **Step-by-Step Guide:**
    1. Take paper or open a doc.
    2. Write 3-5 sentences (e.g., “Regression taught me trends”).
    3. Add an analogy (e.g., “Like a ruler”).
    4. Pair with a classmate.
    5. Read and discuss for 5 minutes.
  - **Analogy:** Journaling after cooking.