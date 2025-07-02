# Class Notes: Session 7 - Advanced GitHub Workflows and Review

## Overview
Session 7 serves as a capstone for the Distributed Version Control module, focusing on advanced GitHub workflows and a comprehensive review of concepts from Sessions 1–6. This session emphasizes practical applications of Git and GitHub in collaborative environments, including advanced features like GitHub Actions, rebasing, and managing conflicts in team settings. Workshop activities reinforce skills from previous sessions, such as branching, merging, remote operations, and GitHub Pages, preparing students for real-world software development scenarios.

## Advanced GitHub Workflows
GitHub offers advanced tools to streamline collaboration and automate workflows, enhancing productivity in team projects.

- **GitHub Actions**:
  - A CI/CD platform for automating workflows (e.g., testing, building, deploying).
  - Workflows are defined in YAML files stored in `.github/workflows/`.
  - Example: Automatically run tests on every push to a branch.

- **Rebasing**:
  - An alternative to merging that rewrites commit history to create a linear timeline.
  - Command: `git rebase <branch>` (e.g., rebase `feature` onto `main`).
  - Useful for cleaner history but requires caution to avoid overwriting shared commits.

- **Managing Merge Conflicts**:
  - Conflicts occur when Git cannot automatically merge changes.
  - Resolve manually by editing conflicting files, staging, and committing.

- **Example (GitHub Actions)**:
  Create a workflow to lint code on push:
  ```yaml
  name: Lint Code
  on: [push]
  jobs:
    lint:
      runs-on: ubuntu-latest
      steps:
        - uses: actions/checkout@v3
        - name: Set up Python
          uses: actions/setup-python@v4
          with:
            python-version: '3.9'
        - run: pip install flake8
        - run: flake8 .
  ```
  Save as `.github/workflows/lint.yml`, commit, and push.

- **Example (Rebasing)**:
  Rebase a feature branch onto `main`:
  ```bash
  git checkout feature-login
  git rebase main
  # Resolve conflicts if any, then continue
  git rebase --continue
  git push --force
  ```

- **Use Case**:
  A team uses GitHub Actions to automate testing and deployment, ensuring code quality, and rebases feature branches for a cleaner commit history before merging.

- **Scenario**:
  A development team sets up a GitHub Action to run unit tests on every pull request, catching errors early, and uses rebasing to maintain a streamlined project history.

- **Source**: *Version Control with Git* by Jon Loeliger and Matthew McCullough.

## Review of Key Concepts (Sessions 1–6)
This section recaps critical topics from previous sessions to reinforce learning.

- **Session 1: Getting Started with Git**:
  - Necessity for version control: Collaboration, history tracking, and recovery.
  - Git basics: Repositories, commits, staging area, HEAD.
  - Commands: `git init`, `git add`, `git commit`, `git status`, `git log`.
  - Example: Initialize a repository and commit a `README.md`.

- **Session 2: Working with Git**:
  - Creating/cloning repositories: `git init`, `git clone`.
  - Configuration: `git config --global user.name "Name"`.
  - Staging and committing: `git add .`, `git commit -m "Message"`.
  - Example: Clone a repository, stage a file, and commit changes.

- **Session 3: Git Branching**:
  - Branching and merging: `git checkout -b <branch>`, `git merge`.
  - Managing branches: Create, rename (`git branch -m`), delete (`git branch -d`).
  - Example: Create a branch, merge it into `main`, and delete it.

- **Session 4: Different Approaches to Git**:
  - Remote branches: `git push origin <branch>`, `git branch -r`.
  - Pulling: `git pull origin <branch>` (fetch + merge).
  - Example: Push a feature branch and pull updates from `main`.

- **Session 5: GitHub as a Project Repository**:
  - GitHub vs. Git: Git is local, GitHub is a cloud platform.
  - Operations: Create repositories, branch, commit via web/GUI.
  - Example: Create a repository and commit via GitHub Desktop.

- **Session 6: More on GitHub and GitHub Pages**:
  - Forking, cloning, and GitHub Pages for static site hosting.
  - Types: User (`username.github.io`), project (`username.github.io/repo`).
  - Example: Set up a GitHub Pages site with `index.html`.

## Workshop Activities
These activities integrate concepts from Sessions 3 and 4 (branching, merging, remote operations) with advanced GitHub workflows.

### Activity 1: Collaborative Workflow with Pull Requests
- **Objective**: Practice forking, branching, and submitting pull requests.
- **Steps**:
  1. Fork a public repository (e.g., `octocat/Spoon-Knife`).
  2. Clone the forked repository: `git clone https://github.com/username/Spoon-Knife.git`.
  3. Create a branch: `git checkout -b enhance-readme`.
  4. Update `README.md`, commit: `git commit -m "Enhanced README with project details"`.
  5. Push to remote: `git push origin enhance-readme`.
  6. Create a pull request on GitHub to the original repository.

- **Scenario**:
  A contributor forks an open-source project, improves documentation, and submits a pull request for review, simulating real-world collaboration.

### Activity 2: Resolving Merge Conflicts
- **Objective**: Handle merge conflicts in a collaborative setting.
- **Steps**:
  1. Clone a repository with multiple contributors (e.g., a team project).
  2. Create a branch: `git checkout -b update-config`.
  3. Edit a file (e.g., `config.json`) and commit.
  4. Pull from `main`: `git pull origin main`.
  5. Resolve conflicts manually, stage, and commit: `git add config.json; git commit`.
  6. Push the branch: `git push origin update-config`.

- **Scenario**:
  Two developers edit the same file, causing a conflict. One resolves it by merging changes and pushes the updated branch for review.

### Activity 3: Setting Up GitHub Actions
- **Objective**: Create a simple CI workflow for a repository.
- **Steps**:
  1. Create a repository or use an existing one.
  2. Add a file `.github/workflows/test.yml`:
     ```yaml
     name: Run Tests
     on: [push]
     jobs:
       test:
         runs-on: ubuntu-latest
         steps:
           - uses: actions/checkout@v3
           - name: Set up Node.js
             uses: actions/setup-node@v3
             with:
               node-version: '16'
           - run: npm install
           - run: npm test
     ```
  3. Commit and push the file.
  4. Check the “Actions” tab on GitHub to verify the workflow runs.

- **Scenario**:
  A team sets up a GitHub Action to run automated tests on every push, ensuring code quality before merging pull requests.

## Classwork
1. **Fork and Pull Request**:
   - Fork a public repository (e.g., `octocat/Spoon-Knife`).
   - Clone it, create a branch `add-feature`, add a file `feature.js`, commit, and push.
   - Create a pull request to the original repository.

2. **Resolve a Merge Conflict**:
   - Clone a team repository, create a branch `update-text`, edit a file (e.g., `index.html`).
   - Pull from `main` to simulate a conflict, resolve it, and push the branch.

3. **Set Up GitHub Pages with Actions**:
   - Create a repository `username.github.io`.
   - Add an `index.html` file and enable GitHub Pages.
   - Add a GitHub Actions workflow to lint HTML files on push.

## Session Test
1. **Multiple Choice**:
   - What is the purpose of GitHub Actions?
     - A) To host static websites
     - B) To automate workflows like testing and deployment
     - C) To fork repositories
     - D) To delete remote branches
     - **Answer**: B

2. **Short Answer**:
   - Explain the difference between `git merge` and `git rebase` when integrating changes from one branch to another.

3. **Practical**:
   - Fork a repository, create a branch `add-docs`, add a `docs.md` file, commit, push, and create a pull request. Then, set up a simple GitHub Pages site in the forked repository.

4. **True/False**:
   - Rebasing rewrites commit history and should be used cautiously on shared branches. (True)

5. **Scenario-Based**:
   - Describe how a team can use GitHub Actions to automate testing, resolve merge conflicts in a feature branch, and host a project site on GitHub Pages.