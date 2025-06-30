# Foundations of AI and Machine Learning - Module 5 Class Notes

## Session 1: Introduction to Reinforcement Learning
### Sub-session 1.1: Core Concepts
- **Teacher Entry:** "Let’s explore learning through rewards. Welcome to the Core Concepts of Reinforcement Learning!"
- **Reinforcement Learning (RL):** Learns by maximizing rewards through actions.
  - **Explanation:** Agent interacts with an environment, optimizing based on feedback.
  - **Analogy:** Training a pet with treats, or a pilot with safe landings.
  - **Relevance to Present:** Powers ALVINN for autonomous driving.
- **Packages:**
  - **Gym:** Provides simulated environments (e.g., CartPole) for RL training.
- **Class Work Sub-sub-session 1.1.1: Class Work - Install RL Tools**
  - **Activity:** Install Gym in VS Code.
  - **Resources:** VS Code, terminal.
  - **Step-by-Step Guide:**
    1. Open terminal in VS Code.
    2. Type `pip install gym` and press Enter; wait for “Successfully installed.”
    3. Open or create `Setup.ipynb`, add a cell, type `import gym`, run with Shift+Enter, expect no errors.
  - **Analogy:** Setting up a training ground.

### Sub-session 1.2: Key Components
- **Teacher Entry:** "With basics set, let’s break down RL parts. Welcome to Key Components!"
- **Agent:** Decision-maker.
  - **Explanation:** Takes actions.
  - **Analogy:** Chess player.
- **Environment:** Context for actions.
  - **Explanation:** Provides rewards.
  - **Analogy:** Chessboard.
- **Reward:** Feedback signal.
  - **Explanation:** Guides learning.
  - **Analogy:** Score in a game.
- **Class Work Sub-sub-session 1.2.1: Class Work - Define Components**
  - **Activity:** Define and example each component.
  - **Resources:** Notebook.
  - **Step-by-Step Guide:**
    1. Open notebook.
    2. Write definitions (e.g., “Agent: Decision-maker”).
    3. Add examples (e.g., “Agent: Robot”).
    4. Share with a partner.
  - **Analogy:** Describing game pieces.

### Sub-session 1.3: Activity - Setup Environment
- **Teacher Entry:** "Let’s get hands-on with an RL environment. Welcome to the Activity - Setup Environment!"
- **Class Work Sub-sub-session 1.3.1: Class Work - Run a Gym Environment**
  - **Activity:** Test the CartPole-v1 environment in VS Code.
  - **Resources:** VS Code, `RLSetup.ipynb`.
  - **Step-by-Step Guide:**
    1. In VS Code, create `RLSetup.ipynb`, select Python kernel.
    2. In a new cell, type `import gym; env = gym.make('CartPole-v1'); observation = env.reset(); print(observation)` and run with Shift+Enter (e.g., [-0.04, 0.02, 0.01, -0.03]).
    3. In a new cell, type `env.close()` and run to close.
    4. Save the notebook.
  - **Expected Output:** Initial observation.

## Session 2: RL Algorithms
### Sub-session 2.1: Q-Learning
- **Teacher Entry:** "Let’s learn an RL algorithm. Welcome to Q-Learning!"
- **Q-Learning:** Updates action values based on rewards using CartPole-v1.
  - **Explanation:** Uses a Q-table for decisions.
  - **Analogy:** Memorizing best moves in chess.
  - **Significance:** Early RL in ALVINN.
- **Class Work Sub-sub-session 2.1.1: Class Work - Implement Q-Learning**
  - **Activity:** Write a basic Q-learning script in VS Code.
  - **Resources:** `RLSetup.ipynb`, Gym.
  - **Step-by-Step Guide:**
    1. Open `RLSetup.ipynb` in VS Code.
    2. Add a new cell, type `import numpy as np; Q = np.zeros((16, 2)); for _ in range(1000): observation, _, done, _ = env.step(env.action_space.sample()); if done: observation = env.reset()` and run.
    3. Save.
  - **Expected Output:** Initialized Q-table (no explicit output, setup complete).

### Sub-session 2.2: Policy Gradient
- **Teacher Entry:** "Expanding RL, let’s try policy gradient. Welcome to Policy Gradient!"
- **Policy Gradient:** Optimizes policy directly.
  - **Explanation:** Uses gradients for action selection.
  - **Analogy:** Adjusting a robot’s walk.
  - **Relevance to Present:** Used in modern robotics.
- **Class Work Sub-sub-session 2.2.1: Class Work - Explore Policy Gradient**
  - **Activity:** Run a policy gradient example in VS Code.
  - **Resources:** `PolicyGradient.ipynb`, link to code, Gym.
  - **Step-by-Step Guide:**
    1. Download policy gradient code from the link (e.g., basic TensorFlow implementation).
    2. In VS Code, create `PolicyGradient.ipynb`, paste the code, select Python kernel, run cells, observe agent behavior in CartPole-v1.
    3. Save the notebook.
  - **Expected Output:** Agent movement (visual or score output).

## Session 3: Applications
### Sub-session 3.1: Real-World Uses
- **Teacher Entry:** "With algorithms ready, let’s see RL in action. Welcome to Real-World Uses!"
- **Robotics:** Controls movements (ALVINN).
  - **Explanation:** Optimizes actions.
  - **Analogy:** Teaching a dance.
- **Game Playing:** Beats humans (e.g., AlphaGo).
  - **Explanation:** Masters strategies.
  - **Analogy:** Chess mastery.
- **Class Work Sub-sub-session 3.1.1: Class Work - Research Application**
  - **Activity:** Research one use.
  - **Resources:** Internet.
  - **Step-by-Step Guide:**
    1. Search “RL applications” online.
    2. Choose one (e.g., robotics).
    3. Note use and tech (e.g., “Controls robots with Q-learning”).
    4. Write summary.
    5. Share with a partner.
  - **Analogy:** Studying a new sport.

## Session 4: Reflection
### Sub-session 4.1: Personal Insights
- **Teacher Entry:** "After exploring RL, let’s reflect. Welcome to Personal Insights!"
- **Class Work Sub-sub-session 4.1.1: Class Work - Reflect and Share**
  - **Activity:** Write and discuss a reflection.
  - **Resources:** Paper or doc.
  - **Step-by-Step Guide:**
    1. Take paper or open a doc.
    2. Write 3-5 sentences (e.g., “RL taught me rewards”).
    3. Add an analogy (e.g., “Like training a pet”).
    4. Pair with a classmate.
    5. Read and discuss for 5 minutes.
  - **Analogy:** Journaling after a game.