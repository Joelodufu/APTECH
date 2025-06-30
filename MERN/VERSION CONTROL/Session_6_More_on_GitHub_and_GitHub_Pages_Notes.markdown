# Class Notes: Session 6 - More on GitHub and Overview of GitHub Pages

## Overview
Session 6 focuses on advanced GitHub features and introduces GitHub Pages for hosting static websites. It builds on the collaborative workflows from Sessions 3 and 4 (branching, merging, and remote operations) through practical workshop activities. This session covers GitHub pricing plans, forking, cloning, and GitHub Pages, emphasizing hands-on applications for collaboration and web hosting.

## GitHub Pricing Plans
GitHub offers multiple pricing plans to cater to different user needs, from individual developers to large organizations.

- **Free Plan**: Includes unlimited public/private repositories, basic collaboration tools, and limited GitHub Actions minutes.
- **Pro Plan**: Provides advanced code review tools and additional features for individual developers.
- **Team Plan**: Offers team collaboration features, including user management and branch protection rules.
- **Enterprise Plan**: Includes advanced security, compliance, and support for large organizations.
- **Note**: For detailed pricing, visit [x.ai/grok](https://x.ai/grok) or [help.x.com/en/using-x/x-premium](https://help.x.com/en/using-x/x-premium).

- **Use Case**:
  A freelancer uses the Free Plan for personal projects, while a software company subscribes to the Team Plan for secure team collaboration.

- **Scenario**:
  An open-source project leverages the Free Plan to host a public repository, attracting global contributors without additional costs.

- **Source**: *Version Control with Git* by Jon Loeliger and Matthew McCullough.

## Forking and Other Operations in GitHub
Forking creates a personal copy of a repository under your GitHub account, allowing you to modify it independently and contribute back via pull requests. Other operations enhance collaboration and repository management.

- **Forking Steps**:
  1. Navigate to a repository (e.g., `octocat/Spoon-Knife`).
  2. Click “Fork” in the top-right corner.
  3. Select your account and customize the repository name (optional).
  4. Click “Create fork.”

- **Other Operations**:
  - **Pull Requests**: Propose changes from a forked or branched repository for review and merging.
  - **Code Review**: Comment on pull requests to ensure quality before merging.
  - **Merging**: Combine changes from a pull request into the target branch.
  - **Issues and Projects**: Track tasks and organize workflows.

- **Example**:
  A developer forks a repository, adds a feature, and submits a pull request:
  ```bash
  git clone https://github.com/username/Spoon-Knife.git
  cd Spoon-Knife
  git checkout -b add-feature
  echo "New feature" > feature.txt
  git add feature.txt
  git commit -m "Added new feature"
  git push origin add-feature
  ```
  Then, they create a pull request on GitHub to propose the change.

- **Use Case**:
  An open-source contributor forks a project, implements a bug fix, and submits a pull request to contribute to the original repository.

- **Scenario**:
  A student forks a professor’s repository, adds a new script, and submits a pull request for grading, incorporating feedback via GitHub’s code review tools.

- **Source**: *Building Tools with GitHub* by Rosemie Callewaert and Johan Revilla.

## Cloning a Repository
Cloning creates a local copy of a remote repository, including all files, branches, and commit history, enabling local development and collaboration.

- **Steps to Clone**:
  1. Go to the repository on GitHub.
  2. Click “Code” and copy the HTTPS/SSH URL.
  3. Run: `git clone <repository-URL> [local-folder-name]`.
  4. Alternatively, use GitHub Desktop: File > Clone Repository > Paste URL.

- **Example**:
  A developer clones a repository:
  ```bash
  git clone https://github.com/username/my-app.git
  cd my-app
  git status
  ```

- **Use Case**:
  A team member clones a project repository to contribute new features locally, then pushes changes back to GitHub.

- **Scenario**:
  A developer clones a team’s repository to work on a feature branch, ensuring they have the latest codebase before starting.

- **Source**: *The Ultimate Beginners Guide Git* by Adney Ainley.

## Introduction to GitHub Pages
GitHub Pages is a feature that allows users to host static websites directly from a GitHub repository, ideal for portfolios, documentation, or blogs.

- **Key Features**:
  - Free hosting for static HTML, CSS, and JavaScript files.
  - Supports custom domains with automatic HTTPS.
  - Easy setup via repository settings.
  - Automatic deployment on pushes to designated branches (e.g., `main` or `gh-pages`).

- **Use Case**:
  A developer hosts a personal portfolio website on GitHub Pages to showcase projects to potential employers.

- **Scenario**:
  A student creates a GitHub Pages site to host their class project’s documentation, making it accessible to instructors and peers.

- **Source**: *Version Control with Git* by Jon Loeliger and Matthew McCullough.

## Types of GitHub Pages Sites
GitHub Pages supports three types of sites, each serving different purposes:
1. **User Site**: Hosted at `username.github.io`, used for personal or portfolio websites.
2. **Organization Site**: Hosted at `organization.github.io`, for organizational web presence.
3. **Project Site**: Hosted at `username.github.io/repository-name`, tied to a specific repository for project-specific content.

- **Example**:
  A developer creates a user site at `johnsmith.github.io` for their portfolio and a project site at `johnsmith.github.io/blog-app` for a blog application’s documentation.

- **Scenario**:
  A company hosts its product documentation at `company.github.io/docs` as a project site, while maintaining a main site at `company.github.io`.

- **Source**: *Git* by Ryan Hodson.

## Guidelines for Using GitHub Pages
To effectively use GitHub Pages, follow these guidelines:
- **Content**: Use static files (HTML, CSS, JavaScript). Server-side code (e.g., PHP) is not supported.
- **Repository Setup**:
  - For user/organization sites, create a repository named `username.github.io`.
  - For project sites, enable GitHub Pages in the repository’s settings.
- **Publishing**:
  - Push files to the `main` branch or a `gh-pages` branch.
  - Select the publishing source in Settings > Pages.
- **Custom Domains**: Configure DNS settings in the repository’s Pages settings for custom domains.
- **Limitations**:
  - Storage limit: 1GB per repository.
  - File size limit: 100MB per file.
  - No server-side processing; use external services for dynamic content.

- **Example**:
  A developer creates a user site:
  ```bash
  git clone https://github.com/username/username.github.io.git
  cd username.github.io
  echo "<h1>My Portfolio</h1>" > index.html
  git add index.html
  git commit -m "Added portfolio homepage"
  git push origin main
  ```
  The site is live at `https://username.github.io`.

- **Scenario**:
  A team sets up a project site for their app’s documentation, ensuring all files are static and within size limits, and enables GitHub Pages in the repository settings.

- **Source**: *Building Tools with GitHub* by Rosemie Callewaert and Johan Revilla.

## Workshop Activities (Sessions 3 & 4 Integration)
The following activities incorporate remote branching and pulling from Sessions 3 and 4 to reinforce collaborative workflows in GitHub.

### Activity 1: Forking and Contributing
- **Objective**: Fork a repository, make changes, and submit a pull request.
- **Steps**:
  1. Fork a public repository (e.g., `octocat/Spoon-Knife`).
  2. Clone the forked repository: `git clone https://github.com/username/Spoon-Knife.git`.
  3. Create a branch: `git checkout -b add-welcome`.
  4. Add a file `welcome.txt` with content: “Welcome to the project!”
  5. Commit and push: `git commit -m "Added welcome message"; git push origin add-welcome`.
  6. Create a pull request on GitHub to the original repository.

- **Scenario**:
  A contributor forks an open-source project, adds a documentation file, and submits a pull request for inclusion in the main project.

### Activity 2: Cloning and Branching
- **Objective**: Clone a repository, create a branch, and push changes to GitHub.
- **Steps**:
  1. Clone a repository: `git clone https://github.com/username/team-project.git`.
  2. Create a branch: `git checkout -b feature-navigation`.
  3. Add a file `nav.css` with CSS styles.
  4. Commit and push: `git commit -m "Added navigation styles"; git push origin feature-navigation`.
  5. Verify the branch on GitHub.

- **Scenario**:
  A developer clones a team repository, creates a branch for a new feature, and pushes it for team review.

### Activity 3: Setting Up a GitHub Pages Site
- **Objective**: Create and publish a simple GitHub Pages site.
- **Steps**:
  1. Create a repository named `username.github.io`.
  2. Clone the repository locally.
  3. Add an `index.html` file:
     ```html
     <!DOCTYPE html>
     <html>
     <head><title>My Site</title></head>
     <body><h1>Welcome to My GitHub Pages Site</h1></body>
     </html>
     ```
  4. Commit and push: `git commit -m "Initial site setup"; git push origin main`.
  5. Enable GitHub Pages in Settings > Pages, selecting `main` as the source.
  6. Verify the site at `https://username.github.io`.

- **Scenario**:
  A student creates a GitHub Pages site to host their project portfolio, ensuring all files are static and properly configured.

## Classwork
1. **Fork and Contribute**:
   - Fork a public repository (e.g., `octocat/Spoon-Knife`).
   - Clone the forked repository.
   - Create a branch `add-info`, add a file `info.txt`, commit, and push.
   - Create a pull request to the original repository.

2. **Clone and Branch**:
   - Clone a repository (e.g., `https://github.com/username/team-project`).
   - Create a branch `feature-button`, add a file `button.css`, commit, and push.
   - Verify the branch on GitHub.

3. **Create a GitHub Pages Site**:
   - Create a repository named `username.github.io`.
   - Add an `index.html` file with a simple webpage.
   - Commit, push, and enable GitHub Pages to make the site live.

## Session Test
1. **Multiple Choice**:
   - What is the purpose of forking a repository on GitHub?
     - A) To delete the original repository
     - B) To create a personal copy for modifications
     - C) To merge branches automatically
     - D) To host a dynamic website
     - **Answer**: B

2. **Short Answer**:
   - Explain how GitHub Pages differs from traditional web hosting in terms of content and limitations.

3. **Practical**:
   - Fork a repository, clone it, create a branch `add-readme`, update `README.md`, commit, push, and create a pull request.

4. **True/False**:
   - GitHub Pages can host server-side scripts like PHP. (False)

5. **Scenario-Based**:
   - Describe how a team can use GitHub to fork a repository, collaborate on a feature branch, push changes, and set up a project site using GitHub Pages.