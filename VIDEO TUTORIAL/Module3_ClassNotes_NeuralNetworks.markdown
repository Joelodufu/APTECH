# Foundations of AI and Machine Learning - Module 3 Class Notes

## Session 1: Introduction to Neural Networks
### Sub-session 1.1: Basics of Neural Networks
- **Teacher Entry:** "Moving beyond basic models, let’s explore brain-inspired learning. Welcome to the Basics of Neural Networks!"
- **Neural Network:** A model mimicking human neurons for complex tasks.
  - **Explanation:** Layers of nodes process data, adjusting weights.
  - **Analogy:** A team of messengers passing notes, or a layered cake.
  - **Relevance to Present:** Core to ChatGPT and Gemini.
- **Class Work Sub-sub-session 1.1.1: Class Work - Install TensorFlow**
  - **Activity:** Install TensorFlow for neural networks.
  - **Resources:** Guide, terminal.
  - **Step-by-Step Guide:**
    1. Open terminal.
    2. Type `pip install tensorflow` and press Enter; wait for “Successfully installed.”
    3. Open Jupyter with `jupyter notebook`.
    4. Create a new notebook, type `import tensorflow as tf; print(tf.__version__)` and press `Shift + Enter` (e.g., 2.15).
  - **Analogy:** Adding advanced kitchen gadgets.

### Sub-session 1.2: Structure and Layers
- **Teacher Entry:** "With basics set, let’s build the network structure. Welcome to Structure and Layers!"
- **Input Layer:** Receives data.
  - **Explanation:** Initial data entry point.
  - **Analogy:** Kitchen intake.
- **Hidden Layers:** Process data.
  - **Explanation:** Where learning occurs.
  - **Analogy:** Cooking steps.
- **Output Layer:** Produces results.
  - **Explanation:** Final prediction.
  - **Analogy:** Serving the dish.
- **Class Work Sub-sub-session 1.2.1: Class Work - Sketch Network**
  - **Activity:** Draw a simple neural network.
  - **Resources:** Paper, pencil.
  - **Step-by-Step Guide:**
    1. Take paper and pencil.
    2. Draw an input layer with 2 nodes (e.g., size, price).
    3. Add a hidden layer with 3 nodes.
    4. Draw an output layer with 1 node (e.g., prediction).
    5. Label layers, share with a partner.
  - **Analogy:** Designing a recipe flow.

### Sub-session 1.3: Activation Functions
- **Teacher Entry:** "To make networks dynamic, let’s add activation functions. Welcome to Activation Functions!"
- **Sigmoid:** Maps outputs to 0-1.
  - **Explanation:** Introduces nonlinearity.
  - **Analogy:** Adjusting heat levels.
- **ReLU:** Sets negatives to zero.
  - **Explanation:** Speeds up learning.
  - **Analogy:** Cutting off excess dough.
- **Class Work Sub-sub-session 1.3.1: Class Work - Match Functions**
  - **Activity:** Match functions to uses.
  - **Resources:** Handout.
  - **Step-by-Step Guide:**
    1. Get handout with functions and uses.
    2. Pair up.
    3. Match (e.g., Sigmoid to binary classification).
    4. Write answers.
    5. Discuss with teacher.
  - **Analogy:** Pairing tools with tasks.

## Session 2: Deep Learning Fundamentals
### Sub-session 2.1: What is Deep Learning?
- **Teacher Entry:** "Expanding networks, let’s dive into deep learning. Welcome to What is Deep Learning!"
- **Deep Learning:** Neural networks with many layers.
  - **Explanation:** Handles complex data like images.
  - **Analogy:** A multi-story building.
  - **Relevance to Present:** Drives Meta AI image recognition.
- **Class Work Sub-sub-session 2.1.1: Class Work - Run a Simple Model**
  - **Activity:** Build a basic neural network.
  - **Resources:** Jupyter Notebook.
  - **Step-by-Step Guide:**
    1. Open Jupyter, create a new notebook.
    2. Type `import tensorflow as tf; model = tf.keras.Sequential([tf.keras.layers.Dense(1, input_shape=[1])])` and press `Shift + Enter`.
    3. Type `model.compile(optimizer='sgd', loss='mse'); print(model.summary())` and press `Shift + Enter` (e.g., layer details).
    4. Save as `SimpleNN.ipynb`.
  - **Expected Output:** Model summary.

### Sub-session 2.2: Training Deep Networks
- **Teacher Entry:** "With structure ready, let’s train our deep networks. Welcome to Training Deep Networks!"
- **Backpropagation:** Adjusts weights using error gradients.
  - **Explanation:** Minimizes loss.
  - **Analogy:** Tuning a guitar string.
- **Epochs:** Training iterations.
  - **Explanation:** Multiple passes over data.
  - **Analogy:** Reheating a dish to perfect it.
- **Class Work Sub-sub-session 2.2.1: Class Work - Train a Model**
  - **Activity:** Train the model with data.
  - **Resources:** Notebook.
  - **Step-by-Step Guide:**
    1. Open `SimpleNN.ipynb`.
    2. Add `import numpy as np; X = np.array([1.0, 2.0, 3.0]); y = np.array([2.0, 4.0, 6.0])` and press `Shift + Enter`.
    3. Add `model.fit(X, y, epochs=500, verbose=0); print(model.predict([4.0]))` and press `Shift + Enter` (e.g., ~8.0).
    4. Save updates.
  - **Expected Output:** Prediction (e.g., 8.0).

## Session 3: Applications and Tools
### Sub-session 3.1: Real-World Applications
- **Teacher Entry:** "With training done, let’s see deep learning in action. Welcome to Real-World Applications!"
- **Image Recognition:** Identifies objects (Meta AI).
  - **Explanation:** Uses convolutional layers.
  - **Analogy:** Spotting faces in a crowd.
- **Natural Language Processing:** Powers ChatGPT.
  - **Explanation:** Processes text with recurrent layers.
  - **Analogy:** Understanding a story.
- **Class Work Sub-sub-session 3.1.1: Class Work - Research Application**
  - **Activity:** Research one application.
  - **Resources:** Internet.
  - **Step-by-Step Guide:**
    1. Search “deep learning applications” online.
    2. Choose one (e.g., image recognition).
    3. Note its use and tech (e.g., “Identifies faces with CNNs”).
    4. Write a summary.
    5. Share with a partner.
  - **Analogy:** Studying a new recipe.

## Session 4: Reflection
### Sub-session 4.1: Personal Insights
- **Teacher Entry:** "After exploring networks, let’s reflect. Welcome to Personal Insights!"
- **Class Work Sub-sub-session 4.1.1: Class Work - Reflect and Share**
  - **Activity:** Write and discuss a reflection.
  - **Resources:** Paper or doc.
  - **Step-by-Step Guide:**
    1. Take paper or open a doc.
    2. Write 3-5 sentences (e.g., “Neural networks showed me layering”).
    3. Add an analogy (e.g., “Like a cake”).
    4. Pair with a classmate.
    5. Read and discuss for 5 minutes.
  - **Analogy:** Journaling after baking.