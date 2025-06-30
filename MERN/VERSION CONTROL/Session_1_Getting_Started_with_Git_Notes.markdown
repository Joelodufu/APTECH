# Class Notes: Session 1 - Getting Started with Git

## Necessity for Version Control
Version control systems (VCS) track changes to files, enabling multiple contributors to collaborate on a project without overwriting each other’s work. They provide a history of changes, allow reverting to previous versions, and support parallel development through branching.

- **Why Version Control is Necessary**:
  - **Collaboration**: Enables multiple developers to work on the same project simultaneously.
  - **History Tracking**: Records all changes, allowing users to review or revert to earlier versions.
  - **Backup and Recovery**: Protects against data loss by maintaining a history of changes.
  - **Branching and Merging**: Supports parallel development for features or bug fixes without affecting the main codebase.
  - **Auditability**: Tracks who made what changes and when, useful for debugging and accountability.

- **Use Case**:
  A team developing a web application uses version control to manage code contributions, ensuring that changes by different developers don’t conflict and can be reviewed before integration.

- **Scenario**:
  A software company working on a mobile app loses a critical file due to accidental deletion. With version control, they restore the file from a previous commit, avoiding significant rework.

- **Source**: *Version Control with Git* by Jon Loeliger and Matthew McCullough.

## Introduction to Git
Git is a distributed version control system designed for speed, efficiency, and reliability. Unlike centralized VCS (e.g., SVN), every Git user has a full copy of the repository, including its history, allowing offline work and decentralized collaboration.

- **Key Features**:
  - **Distributed Architecture**: Each developer has a complete local repository, enabling offline operations.
  - **Fast Performance**: Optimized for quick commits, branching, and merging.
  - **Strong Branching Model**: Supports lightweight branches for experimentation and feature development.
  - **Data Integrity**: Uses cryptographic hashing (SHA-1) to ensure data consistency.

- **Use Case**:
  A solo developer uses Git to manage a personal project, creating branches for new features and reverting mistakes without relying on a central server.

- **Scenario**:
  A freelance developer works on a client project while traveling, using Git to commit changes offline and sync them later when connected to the internet.

- **Source**: *Git* by Ryan Hodson.

## Git Basics
Git operates by tracking changes to files in a repository through a series of commits. Key concepts include:
- **Repository**: A directory containing project files and a `.git` folder with version history.
- **Commit**: A snapshot of changes with a unique SHA-1 hash, message, and metadata (author, date).
- **Working Directory**: The current state of files on your local machine.
- **Staging Area (Index)**: A buffer where changes are prepared before committing.
- **HEAD**: A pointer to the current branch or commit you’re working on.

- **Basic Workflow**:
  1. Modify files in the working directory.
  2. Stage changes using `git add`.
  3. Commit staged changes using `git commit`.

- **Example**:
  A developer creates a file `index.html`, stages it with `git add index.html`, and commits it with `git commit -m "Initial homepage"`.

- **Scenario**:
  A student working on a class project adds a new Python script to their repository, stages it, and commits it to save their progress.

- **Source**: *The Ultimate Beginners Guide Git* by Adney Ainley.

## Command-Line Program
Git is primarily a command-line tool, though GUI clients (e.g., GitHub Desktop) exist. The command-line interface (CLI) provides full control over Git operations and is widely used for its flexibility.

- **Common Commands**:
  - `git init`: Initializes a new Git repository.
  - `git add <file>`: Stages a file for commit.
  - `git commit -m "message"`: Commits staged changes with a message.
  - `git status`: Shows the current state of the working directory and staging area.
  - `git log`: Displays the commit history.

- **Example**:
  A developer runs the following commands:
  ```bash
  git init
  touch README.md
  git add README.md
  git commit -m "Initial commit with README"
  git status
  ```
  Output of `git status` shows a clean working directory.

- **Scenario**:
  A team member uses the command line to initialize a new repository for a group project, adds initial files, and checks the status to ensure all changes are committed.

- **Source**: *Version Control with Git* by Jon Loeliger and Matthew McCullough.

## Setting Up Git
Before using Git, it must be installed and configured with user information to attribute commits correctly.

- **Installation** (Windows/Mac/Linux):
  1. Download Git from [git-scm.com](https://git-scm.com).
  2. Run the installer and follow the prompts.
  3. Verify installation: `git --version`.

- **Configuration**:
  - Set user name: `git config --global user.name "Your Name"`.
  - Set user email: `git config --global user.email "your.email@example.com"`.
  - Set default editor (optional): `git config --global core.editor "nano"`.
  - View configuration: `git config --list`.

- **Example**:
  A developer sets up Git on their new laptop:
  ```bash
  git config --global user.name "Jane Doe"
  git config --global user.email "jane.doe@example.com"
  git config --list
  ```

- **Scenario**:
  A new employee configures Git on their work computer to contribute to the company’s repository, ensuring their commits are correctly attributed.

- **Source**: *Building Tools with GitHub* by Rosemie Callewaert and Johan Revilla.

## Classwork
1. **Install and Configure Git**:
   - Install Git on your machine and verify the installation with `git --version`.
   - Configure your name and email using `git config --global`.

2. **Create a Repository**:
   - Initialize a new Git repository in a folder named `my-project`.
   - Create a file `notes.txt` with some content.
   - Stage and commit the file with the message “Added initial notes.”

3. **Explore Git Commands**:
   - Run `git status` to check the working directory.
   - Run `git log` to view the commit history.

## Session Test
1. **Multiple Choice**:
   - What is the primary purpose of version control?
     - A) To write code faster
     - B) To track changes and collaborate on projects
     - C) To host websites
     - D) To compile code
     - **Answer**: B

2. **Short Answer**:
   - Explain why Git is considered a distributed version control system and provide an example of how this benefits a developer.

3. **Practical**:
   - Initialize a new Git repository, create a file `test.txt` with the content “Hello, Git!”, stage it, and commit it with an appropriate message.

4. **True/False**:
   - Git requires an internet connection to commit changes locally. (False)

5. **Scenario-Based**:
   - Describe how a team of two developers can use Git to collaborate on a project without a central server, including the steps they would take to share changes.