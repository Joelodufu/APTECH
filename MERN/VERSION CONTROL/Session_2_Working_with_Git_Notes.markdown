# Class Notes: Session 2 - Working with Git

## Getting a Git Repository
A Git repository is a storage space where project files and their version history are stored. There are two primary ways to get a Git repository:
- **Initialize a New Repository**: Create a new repository from scratch in a local directory.
- **Clone an Existing Repository**: Copy an existing repository from a remote source (e.g., GitHub) to your local machine.

- **Steps to Initialize a New Repository**:
  1. Navigate to the project folder: `cd my-project`.
  2. Run `git init` to create a new repository (creates a `.git` folder).
  3. Add initial files and commit them.

- **Example**:
  A developer initializes a new repository:
  ```bash
  mkdir my-app
  cd my-app
  git init
  echo "# My App" > README.md
  git add README.md
  git commit -m "Initial commit"
  ```

- **Use Case**:
  A startup begins a new project and initializes a Git repository to track the development of their application from the ground up.

- **Scenario**:
  A student starts a personal coding project by creating a new Git repository to manage their code, ensuring they can track changes and revert mistakes.

- **Source**: *Version Control with Git* by Jon Loeliger and Matthew McCullough.

## Setting Up the Project Folder
The project folder is the root directory of your Git repository, containing all project files and the `.git` subdirectory, which stores the repository’s metadata and history.

- **Steps to Set Up**:
  1. Create a project folder: `mkdir project-name`.
  2. Navigate to the folder: `cd project-name`.
  3. Initialize Git: `git init`.
  4. Add project files (e.g., source code, documentation).
  5. Configure a `.gitignore` file to exclude unnecessary files (e.g., `node_modules/`, `.env`).

- **Example**:
  A developer sets up a project folder for a Python application:
  ```bash
  mkdir python-app
  cd python-app
  git init
  touch main.py .gitignore
  echo "venv/" > .gitignore
  git add .
  git commit -m "Set up initial project structure"
  ```

- **Use Case**:
  A team sets up a project folder for a web application, including a `.gitignore` to exclude temporary files, ensuring only relevant files are tracked.

- **Scenario**:
  A developer creates a project folder for a blog site, initializes a Git repository, and adds a `.gitignore` to exclude build artifacts.

- **Source**: *Git* by Ryan Hodson.

## Git Configuration
Git configuration customizes how Git behaves for a user, repository, or system. It includes settings like user identity, default editor, and aliases for commands.

- **Configuration Commands**:
  - Set user name: `git config --global user.name "Your Name"`.
  - Set user email: `git config --global user.email "your.email@example.com"`.
  - Set default editor: `git config --global core.editor "nano"`.
  - Create alias: `git config --global alias.st status` (e.g., `git st` runs `git status`).

- **Example**:
  A developer configures Git with their details and an alias:
  ```bash
  git config --global user.name "John Smith"
  git config --global user.email "john.smith@example.com"
  git config --global alias.co checkout
  git config --list
  ```

- **Use Case**:
  A new team member configures Git to ensure their commits are properly attributed and sets aliases to streamline their workflow.

- **Scenario**:
  A student configures Git to use Visual Studio Code as the default editor for commit messages, improving their productivity.

- **Source**: *The Ultimate Beginners Guide Git* by Adney Ainley.

## Levels of Configuration
Git supports three levels of configuration, each overriding the one above it:
1. **System Level** (`--system`): Applies to all users on the machine, stored in `/etc/gitconfig`.
   - Example: `git config --system core.editor "vim"`.
2. **Global Level** (`--global`): Applies to all repositories for the current user, stored in `~/.gitconfig`.
   - Example: `git config --global user.name "Jane Doe"`.
3. **Local Level** (`--local`): Applies to a specific repository, stored in `.git/config`.
   - Example: `git config --local user.email "project.email@example.com"`.

- **Example**:
  A developer sets a global email but overrides it for a specific project:
  ```bash
  git config --global user.email "personal@example.com"
  cd my-project
  git config --local user.email "work@example.com"
  git config --list
  ```

- **Use Case**:
  A freelancer uses different email addresses for personal and client projects by setting global and local configurations.

- **Scenario**:
  An organization sets a system-wide configuration for all developers to use a specific merge tool, while individuals customize their global settings.

- **Source**: *Version Control with Git* by Jon Loeliger and Matthew McCullough.

## Git Clone
Cloning creates a local copy of a remote repository, including all files, branches, and commit history.

- **Steps to Clone**:
  1. Obtain the repository URL (e.g., from GitHub).
  2. Run: `git clone <repository-URL> [local-folder-name]`.
  3. Navigate to the cloned folder: `cd local-folder-name`.

- **Example**:
  A developer clones a repository:
  ```bash
  git clone https://github.com/username/sample-repo.git
  cd sample-repo
  git status
  ```

- **Use Case**:
  A team member clones a company’s repository to start contributing to an existing project without needing to set it up from scratch.

- **Scenario**:
  A student clones a professor’s repository containing lab assignments, makes changes locally, and commits them for submission.

- **Source**: *Building Tools with GitHub* by Rosemie Callewaert and Johan Revilla.

## Staging Files
Staging is the process of selecting changes to include in the next commit. The staging area (index) acts as a buffer between the working directory and the repository.

- **Commands**:
  - Stage a file: `git add <file>`.
  - Stage all changes: `git add .`.
  - Unstage a file: `git restore --staged <file>`.

- **Example**:
  A developer stages changes to a file:
  ```bash
  echo "print('Hello')" > script.py
  git add script.py
  git status
  ```
  Output shows `script.py` as staged for commit.

- **Use Case**:
  A developer stages only specific changes to a file to create a focused commit, leaving other modifications for a later commit.

- **Scenario**:
  A team member modifies multiple files but stages only the completed ones for a commit, keeping work-in-progress changes unstaged.

- **Source**: *Version Control with Git* by Jon Loeliger and Matthew McCullough.

## Committing Files
Committing saves staged changes to the repository as a permanent snapshot with a unique SHA-1 hash and a commit message.

- **Commands**:
  - Commit staged changes: `git commit -m "Commit message"`.
  - Commit all modified files (skip staging): `git commit -a -m "Commit message"`.
  - Amend the last commit: `git commit --amend`.

- **Example**:
  A developer commits staged changes:
  ```bash
  git add index.html
  git commit -m "Updated homepage layout"
  git log --oneline
  ```

- **Use Case**:
  A developer commits incremental changes to a feature, documenting each