# GitHub Class Note for Developers

A concise guide for developers to host projects on GitHub, create and update repositories, and explore use cases.

## Prerequisites
Before starting, ensure you have:
- **Git**: Version control system. Download from [git-scm.com](https://git-scm.com/) and install.
- **Git Bash** (Windows): Terminal for Git commands, included with Git installation.
- **Visual Studio Code**: Code editor. Download from [code.visualstudio.com](https://code.visualstudio.com/).
- **GitHub Account**: Sign up at [github.com](https://github.com/).

## Step-by-Step Guide

### 1. Install Required Tools
- **Git**: Run `git --version` in terminal to verify installation.
- **VS Code**: Open VS Code and install the "GitHub Pull Requests and Issues" extension.
- **Git Bash** (Windows): Use as your terminal for Git commands.

### 2. Authenticate GitHub in Terminal
1. Generate a Personal Access Token (PAT):
   - Go to GitHub > Settings > Developer settings > Personal access tokens > Tokens (classic).
   - Create a token with `repo` scope. Copy it.
2. Configure Git with your credentials:
   ```bash
   git config --global user.name "Your Name"
   git config --global user.email "your.email@example.com"
   ```
3. Authenticate with GitHub:
   - When prompted for a password during Git operations, use your PAT.

### 3. Create a New Repository
1. On GitHub:
   - Click **New** on [github.com](https://github.com/).
   - Name your repository (e.g., `my-project`).
   - Optionally add a description, choose public/private, and initialize with a README.
   - Click **Create repository**.
2. Copy the repository URL (e.g., `https://github.com/username/my-project.git`).

### 4. Set Up Local Repository
1. Create a project folder:
   ```bash
   mkdir my-project
   cd my-project
   ```
2. Initialize Git:
   ```bash
   git init
   ```
3. Link to GitHub:
   ```bash
   git remote add origin https://github.com/username/my-project.git
   ```

### 5. Add and Commit Code
1. Create a file (e.g., in VS Code):
   ```bash
   echo "# My Project" > README.md
   ```
2. Stage and commit:
   ```bash
   git add .
   git commit -m "Initial commit"
   ```

### 6. Push to GitHub
1. Push to the main branch:
   ```bash
   git push -u origin main
   ```
   - Enter your GitHub username and PAT when prompted.

### 7. Update Repository
1. Make changes (e.g., edit `README.md` in VS Code).
2. Stage and commit:
   ```bash
   git add .
   git commit -m "Update README"
   ```
3. Push changes:
   ```bash
   git push origin main
   ```

## Common Use Cases
- **Code Hosting**: Share and showcase projects (e.g., portfolio, open-source contributions).
- **Collaboration**: Invite team members to contribute via pull requests.
- **Version Control**: Track changes and revert if needed.
- **CI/CD**: Integrate with tools like GitHub Actions for automated testing/deployment.

## Exercise: Build and Push a Simple Project
1. Create a GitHub repository named `test-project`.
2. Locally, create a folder `test-project` and initialize Git.
3. Add a file `index.html` with:
   ```html
   <!DOCTYPE html>
   <html>
   <body>
     <h1>Hello, GitHub!</h1>
   </body>
   </html>
   ```
4. Commit and push to GitHub.
5. Verify the file appears on GitHub.

**Goal**: Master repository creation, local setup, committing, and pushing.