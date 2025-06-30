# Foundations of AI and Machine Learning - Module 4 Class Notes

## Session 1: Introduction to Unsupervised Learning
### Sub-session 1.1: Core Concepts
- **Teacher Entry:** "Shifting gears, let’s explore learning without labels. Welcome to the Core Concepts of Unsupervised Learning!"
- **Unsupervised Learning:** Finds patterns in unlabeled data.
  - **Explanation:** Groups or reduces data without guidance.
  - **Analogy:** A child sorting toys, or a librarian organizing books.
  - **Relevance to Present:** Used in Meta AI for clustering.
- **Packages:**
  - **Scikit-learn:** Offers clustering (e.g., KMeans) and dimensionality reduction (e.g., PCA) tools.
  - **Matplotlib:** Visualizes data and clusters (optional for advanced tasks).
  - **Pandas:** Loads datasets like `sample_data.csv`.
- **Class Work Sub-sub-session 1.1.1: Class Work - Install Required Libraries and Prepare Dataset**
  - **Activity:** Install Scikit-learn, Matplotlib, and create `sample_data.csv` in VS Code.
  - **Resources:** VS Code, terminal, text editor.
  - **Step-by-Step Guide:**
    1. Open terminal in VS Code.
    2. Type `pip install scikit-learn` and press Enter; wait for “Successfully installed.”
    3. Type `pip install matplotlib` and press Enter; wait for “Successfully installed.”
    4. Create `sample_data.csv` with:  
       ```
       feature1,feature2
       1.0,2.0
       1.5,1.8
       2.0,2.2
       3.0,3.5
       3.2,3.7
       4.0,4.1
       5.0,5.2
       5.5,5.0
       6.0,6.0
       6.5,6.2
       ```
       Save in your project folder.
    5. Open or create `Setup.ipynb`, add a cell, type `import pandas as pd; import sklearn; import matplotlib; data = pd.read_csv('sample_data.csv'); print(data.head())`, run with Shift+Enter, expect first 5 rows.
  - **Analogy:** Adding art supplies and a canvas.

### Sub-session 1.2: Key Techniques
- **Teacher Entry:** "With concepts in place, let’s look at the techniques. Welcome to Key Techniques!"
- **Clustering:** Groups similar data points.
  - **Explanation:** Uses algorithms like k-means.
  - **Analogy:** Sorting laundry by color.
- **Dimensionality Reduction:** Simplifies data (e.g., PCA).
  - **Explanation:** Reduces features while retaining info.
  - **Analogy:** Summarizing a book.
- **Class Work Sub-sub-session 1.2.1: Class Work - List Techniques**
  - **Activity:** List uses for each technique.
  - **Resources:** Notebook.
  - **Step-by-Step Guide:**
    1. Open notebook.
    2. Write “Clustering: e.g., customer segmentation” and “Dimensionality Reduction: e.g., data visualization.”
    3. Share one use with a partner.
  - **Analogy:** Cataloging tools.

### Sub-session 1.3: Activity - Explore Data
- **Teacher Entry:** "Let’s get hands-on with data. Welcome to the Activity - Explore Data!"
- **Class Work Sub-sub-session 1.3.1: Class Work - Load and View Dataset**
  - **Activity:** Load and explore `sample_data.csv` in VS Code.
  - **Resources:** VS Code, `sample_data.csv`, `DataExplore.ipynb`.
  - **Step-by-Step Guide:**
    1. In VS Code, create `DataExplore.ipynb`, select Python kernel.
    2. In a new cell, type `import pandas as pd; data = pd.read_csv('sample_data.csv'); print(data.head())` and run with Shift+Enter (expect first 5 rows).
    3. In a new cell, type `print(data.describe())` and run (expect statistics).
    4. Save the notebook.
  - **Expected Output:** Data preview and stats.

## Session 2: Clustering Techniques
### Sub-session 2.1: K-Means Clustering
- **Teacher Entry:** "Let’s dive into grouping data. Welcome to K-Means Clustering!"
- **K-Means:** Assigns data to k clusters using `sample_data.csv`.
  - **Explanation:** Minimizes within-cluster variance.
  - **Analogy:** Dividing a garden into flower beds.
  - **Significance:** Used in Meta AI for market analysis.
- **Class Work Sub-sub-session 2.1.1: Class Work - Run K-Means**
  - **Activity:** Apply k-means to `sample_data.csv` in VS Code.
  - **Resources:** `DataExplore.ipynb`, `sample_data.csv`.
  - **Step-by-Step Guide:**
    1. Open `DataExplore.ipynb` in VS Code.
    2. Add a new cell, type `from sklearn.cluster import KMeans; X = data[['feature1', 'feature2']]; kmeans = KMeans(n_clusters=3); kmeans.fit(X); print(kmeans.labels_)` and run (e.g., [0, 0, 0, 1, 1, ...]).
    3. Save updates.
  - **Expected Output:** Cluster labels.

### Sub-session 2.2: Evaluation
- **Teacher Entry:** "With clusters formed, let’s evaluate them. Welcome to Evaluation!"
- **Silhouette Score:** Measures cluster quality.
  - **Explanation:** Higher score indicates better separation.
  - **Analogy:** Judging a neat garden layout.
- **Class Work Sub-sub-session 2.2.1: Class Work - Calculate Silhouette**
  - **Activity:** Compute silhouette score for `sample_data.csv` in VS Code.
  - **Resources:** `DataExplore.ipynb`, `sample_data.csv`.
  - **Step-by-Step Guide:**
    1. Add a new cell, type `from sklearn.metrics import silhouette_score; score = silhouette_score(X, kmeans.labels_); print(score)` and run (e.g., 0.5).
    2. Save.
  - **Expected Output:** Score (e.g., 0.5).

## Session 3: Dimensionality Reduction
### Sub-session 3.1: Principal Component Analysis (PCA)
- **Teacher Entry:** "To simplify data, let’s use PCA. Welcome to Principal Component Analysis!"
- **PCA:** Reduces dimensions while preserving variance using `sample_data.csv`.
  - **Explanation:** Transforms data into principal components.
  - **Analogy:** Condensing a story into key points.
  - **Relevance to Present:** Enhances Gemini data processing.
- **Class Work Sub-sub-session 3.1.1: Class Work - Apply PCA**
  - **Activity:** Reduce data dimensions of `sample_data.csv` in VS Code.
  - **Resources:** `DataExplore.ipynb`, `sample_data.csv`.
  - **Step-by-Step Guide:**
    1. Add a new cell, type `from sklearn.decomposition import PCA; pca = PCA(n_components=1); X_pca = pca.fit_transform(X); print(X_pca)` and run (e.g., array of reduced values).
    2. Save.
  - **Expected Output:** Reduced data.

## Session 4: Reflection
### Sub-session 4.1: Personal Insights
- **Teacher Entry:** "After exploring unsupervised learning, let’s reflect. Welcome to Personal Insights!"
- **Class Work Sub-sub-session 4.1.1: Class Work - Reflect and Share**
  - **Activity:** Write and discuss a reflection.
  - **Resources:** Paper or doc.
  - **Step-by-Step Guide:**
    1. Take paper or open a doc.
    2. Write 3-5 sentences (e.g., “Clustering showed me grouping”).
    3. Add an analogy (e.g., “Like sorting toys”).
    4. Pair with a classmate.
    5. Read and discuss for 5 minutes.
  - **Analogy:** Journaling after organizing.