# Class Notes: Session 8 - Professional GitHub Workflows and Project Management

## Overview
Session 8 serves as an advanced capstone for the Distributed Version Control module, focusing on professional GitHub workflows and project management practices. This session builds on Sessions 1–6, covering advanced collaboration techniques, GitHub project management tools, and best practices for maintaining repositories in team environments. Workshop activities reinforce skills from previous sessions (branching, merging, remote operations, GitHub Pages) and introduce new tools like GitHub Projects and Dependabot for streamlined workflows.

## Advanced Collaboration Workflows
Professional teams use GitHub to manage complex projects with multiple contributors. Key workflows include branch protection, code reviews, and automated dependency management.

- **Branch Protection Rules**:
  - Restrict who can push to critical branches (e.g., `main`).
  - Require pull request reviews before merging.
  - Enforce status checks (e.g., passing tests via GitHub Actions).
  - Setup: Repository Settings > Branches > Add Rule.

- **Code Reviews in Pull Requests**:
  - Team members review code changes, suggest improvements, and approve merges.
  - Use comments and suggestions in GitHub’s pull request interface.

- **Dependabot**:
  - Automates dependency updates by creating pull requests for outdated packages.
  - Enable in Repository Settings > Security > Dependabot.

- **Example (Branch Protection)**:
  Set up a branch protection rule for `main`:
  - Go to Settings > Branches > Add branch protection rule.
  - Select `main`, enable “Require pull request reviews before merging” and “Require status checks to pass.”
  - Save the rule.

- **Example (Dependabot)**:
  Create a `dependabot.yml` file in `.github/`:
  ```yaml
  version: 2
  updates:
    - package-ecosystem: "npm"
      directory: "/"
      schedule:
        interval: "weekly"
  ```
  Commit and push to enable Dependabot.

- **Use Case**:
  A development team uses branch protection to ensure only reviewed code is merged into `main` and Dependabot to keep dependencies updated, reducing security risks.

- **Scenario**:
  A software company sets up branch protection for their production branch, requiring two approvals and passing tests, ensuring high-quality releases.

- **Source**: *Version Control with Git* by Jon Loeliger and Matthew McCullough.

## GitHub Project Management
GitHub Projects and Issues provide tools to organize tasks, track progress, and manage team workflows using Kanban-style boards or tables.

- **GitHub Issues**:
  - Track bugs, feature requests, or tasks.
  - Assign labels (e.g., “bug,” “enhancement”), milestones, and assignees.
  - Link to pull requests for traceability.

- **GitHub Projects**:
  - Create Kanban boards or tables to visualize workflows.
  - Add issues, pull requests, or notes to columns (e.g., To Do, In Progress, Done).
  - Setup: Repository > Projects > New Project.

- **Example**:
  Create a GitHub Project:
  - Go to Repository > Projects > New Project.
  - Name it “Sprint 1,” create columns: “To Do,” “In Progress,” “Done.”
  - Add an issue: “Implement login page” to “To Do,” assign it to a developer.

- **Use Case**:
  A team uses GitHub Projects to manage a sprint, tracking tasks from planning to completion, and links issues to pull requests for transparency.

- **Scenario**:
  A project manager creates a GitHub Project board to track tasks for a website redesign, assigning issues to developers and monitoring progress.

- **Source**: *Building Tools with GitHub* by Rosemie Callewaert and Johan Revilla.

## Review of Key Concepts (Sessions 1–6)
This section recaps critical topics to reinforce learning.

- **Session 1: Getting Started with Git**:
  - Necessity for version control: Collaboration, history, recovery.
  - Commands: `git init`, `git add`, `git commit`, `git status`.
  - Example: Initialize a repository and commit a file.

- **Session 2: Working with Git**:
  - Create/clone repositories: `git init`, `git clone`.
  - Configuration: `git config --global user.name`.
  - Staging/committing: `git add`, `git commit -m`.

- **Session 3: Git Branching**:
  - Branching/merging: `git checkout -b`, `git merge`.
  - Manage branches: `git branch -m`, `git branch -d`.
  - Example: Create and merge a feature branch.

- **Session 4: Different Approaches to Git**:
  - Remote branches: `git push origin <branch>`.
  - Pulling: `git pull origin <branch>`.
  - Example: Push a branch and resolve merge conflicts.

- **Session 5: GitHub as a Project Repository**:
  - Git vs. GitHub: Local vs. cloud collaboration.
  - Operations: Create repositories, branch, commit via web/GUI.
  - Example: Use GitHub Desktop to commit changes.

- **Session 6: More on GitHub and GitHub Pages**:
  - Forking, cloning, GitHub Pages for static sites.
  - Types: User (`username.github.io`), project sites.
  - Example: Set up a GitHub Pages site.

## Workshop Activities
These activities integrate concepts from Sessions 3 and 4 (branching, merging, remote operations) with advanced workflows.

### Activity 1: Setting Up Branch Protection
- **Objective**: Configure branch protection for a repository.
- **Steps**:
  1. Create a repository `team-workflow`.
  2. Go to Settings > Branches > Add branch protection rule.
  3. Protect `main`, enable “Require pull request reviews” and “Require status checks.”
  4. Create a branch `feature-test`, push changes, and attempt to push directly to `main` (should fail).
  5. Create a pull request to merge `feature-test` into `main`.

- **Scenario**:
  A team lead sets up branch protection to ensure only reviewed and tested code is merged into the production branch.

### Activity 2: Managing a Project with GitHub Projects
- **Objective**: Create a GitHub Project to manage tasks.
- **Steps**:
  1. In a repository, go to Projects > New Project.
  2. Name it “Website Redesign,” create columns: “To Do,” “In Progress,” “Done.”
  3. Create issues: “Add navigation bar” and “Fix footer styling.”
  4. Assign issues to team members and move them to appropriate columns.
  5. Link a pull request to an issue and update the project board.

- **Scenario**:
  A project manager organizes a sprint using a GitHub Project, assigning tasks and tracking progress as developers complete them.

### Activity 3: Automating Dependency Updates
- **Objective**: Enable Dependabot for a repository.
- **Steps**:
  1. Create a repository with a `package.json` file (e.g., Node.js project).
  2. Add `.github/dependabot.yml`:
     ```yaml
     version: 2
     updates:
       - package-ecosystem: "npm"
         directory: "/"
         schedule:
           interval: "daily"
     ```
  3. Commit and push.
  4. Check Dependabot pull requests in the repository’s Pull Requests tab.

- **Scenario**:
  A team enables Dependabot to automatically update dependencies, reducing vulnerabilities in their project.

## Classwork
1. **Branch Protection**:
   - Create a repository `protected-repo`.
   - Set up branch protection for `main` with pull request reviews.
   - Create a branch `feature-update`, add a file `update.txt`, and attempt to merge via a pull request.

2. **GitHub Project**:
   - Create a GitHub Project named “App Development.”
   - Add issues for two tasks, assign them, and move them across “To Do,” “In Progress,” and “Done” as you simulate progress.
   - Link a pull request to one issue.

3. **Dependabot Setup**:
   - Create a repository with a `package.json`.
   - Enable Dependabot with a `dependabot.yml` file.
   - Verify Dependabot creates pull requests for dependency updates.

## Session Test
1. **Multiple Choice**:
   - What is the purpose of branch protection rules in GitHub?
     - A) To allow direct pushes to any branch
     - B) To restrict changes and enforce reviews
     - C) To delete branches automatically
     - D) To host static websites
     - **Answer**: B

2. **Short Answer**:
   - Explain how GitHub Projects can improve team collaboration and task management.

3. **Practical**:
   - Create a repository, set up branch protection for `main`, create a branch `feature-modal`, add a file `modal.js`, commit, push, and create a pull request.

4. **True/False**:
   - Dependabot can automatically update dependencies in a repository. (True)

5. **Scenario-Based**:
   - Describe how a team can use branch protection, GitHub Projects, and Dependabot to manage a software project, including creating a feature branch, tracking tasks, and maintaining dependencies.