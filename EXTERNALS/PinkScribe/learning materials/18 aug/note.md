### Learning Material for Session 1: PinkScribe Web App Development
**Date:** Monday, August 18, 2025  
**Time:** 5:00 PM - 6:30 PM WAT  
**Session Focus:** Introduction to Web Development Basics and Project Setup  
**Prepared By:** [Your Name/Mentor Name]  
**Objective:** Kick off the PinkScribe project by setting up the development environment and learning foundational web development concepts using HTML and PHP.

---

#### Session Agenda (1.5 Hours)
- **Review Bottlenecks (15 min):** N/A (First session - no prior tasks)
- **Teach & Initiate Next Step (60 min):** Introduction to web development and project setup
- **Assign & Discuss (15 min):** Class work and project tasks

---

### 1. Teach & Initiate Next Step (60 min)

#### Learning Concepts
This session introduces the basics of web development and sets up the foundation for the PinkScribe project based on the provided Product Requirements Document (PRD).

##### 1.1 Introduction to Web Development
- **What is Web Development?**
  - Web development involves creating websites or web applications. It includes front-end (what users see) and back-end (server-side logic).
  - For PinkScribe, you'll combine HTML (structure), CSS (styling), a bit of JavaScript (interactions), and PHP (server-side processing).
- **Overview of PinkScribe (from PRD):**
  - A beginner-friendly web app where users upload audio files (MP3/WAV, max 10MB) and get instant text transcription.
  - Main purpose: Practice PHP while learning to integrate it with HTML, CSS, and JavaScript, and use a speech-to-text API.
  - Goals: Strengthen PHP skills, learn front-end basics, integrate APIs, and create a fun project.

##### 1.2 Setting Up the Development Environment
- **Tools Needed:**
  - **XAMPP:** A local server environment (Apache, MySQL, PHP). Download from [apachefriends.org](https://www.apachefriends.org/).
  - **Text Editor:** VS Code or any preferred editor.
  - **Browser:** Chrome or Firefox for testing.
- **Steps to Install XAMPP:**
  1. Download and install XAMPP.
  2. Start Apache and MySQL modules from the XAMPP Control Panel.
  3. Verify by opening `http://localhost` in your browser (should show XAMPP dashboard).
- **Project Folder Setup:**
  - Create a folder named `PinkScribe` inside `C:\xampp\htdocs\` (Windows) or `/opt/lampp/htdocs/` (Linux/Mac).
  - Inside `PinkScribe`, create `index.php` (main file) and a subfolder `uploads` for audio files.

##### 1.3 Basic HTML Structure
- **HTML Basics:**
  - HTML (HyperText Markup Language) defines the structure of web pages.
  - Key tags: `<html>`, `<head>`, `<body>`, `<form>`, `<input>`.
- **Demo Example:**
  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <title>PinkScribe</title>
  </head>
  <body>
      <h1>PinkScribe 💖</h1>
      <form method="POST" action="index.php">
          <input type="file" name="audioFile">
          <input type="submit" value="Transcribe">
      </form>
  </body>
  </html>
  ```
  - Save as `index.php` in the `PinkScribe` folder.
  - Open `http://localhost/PinkScribe` to see the form.

##### 1.4 Introduction to PHP
- **What is PHP?**
  - A server-side scripting language for dynamic web content.
  - Processes form data and interacts with APIs in PinkScribe.
- **Basic PHP Syntax:**
  - Use `<?php` to start and `?>` to end PHP code.
  - Example: Echo text with `echo "Hello, World!";`.
- **Demo with Form:**
  - Add PHP to `index.php` to handle the form:
    ```php
    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        echo "Form submitted!";
    }
    ?>
    ```
  - Test by submitting the form (should display "Form submitted!").

##### Hands-On Demo
- Walk through installing XAMPP, setting up the `PinkScribe` folder, and creating the basic `index.php` with HTML and PHP.
- Show how to access it via `http://localhost/PinkScribe`.

---

### 2. Assign & Discuss (15 min)

#### Class Work (1-2 Hours)
- **Task:** Create a simple HTML page with a form.
  - Include a text input for a user's name and a submit button.
  - Add a PHP script to process the form and display "Hello, [name]!" on the same page.
  - Steps:
    1. Create a new file `hello.php` in the `PinkScribe` folder.
    2. Use the HTML form structure from the demo, replacing the file input with a text input (`<input type="text" name="name">`).
    3. Add PHP to check if the form is submitted and echo the greeting.
  - Test in your browser and log any issues.

#### Project Task (3-5 Hours)
- **Task:** Set up the PinkScribe project and build the basic HTML upload form.
  - Steps:
    1. Ensure XAMPP is running and the `PinkScribe` folder is set up.
    2. Update `index.php` with the demo HTML form for audio upload (file input for MP3/WAV, "Choose File" and "Transcribe" buttons).
    3. Add a simple PHP echo to confirm form submission (e.g., "File received!").
  - Test by uploading a sample audio file and logging the setup process, including any errors.

#### Resources
- **Tutorials:** W3Schools HTML ([https://www.w3schools.com/html/](https://www.w3schools.com/html/)) and PHP ([https://www.w3schools.com/php/](https://www.w3schools.com/php/)).
- **XAMPP Guide:** [Apache Friends Documentation](https://www.apachefriends.org/docs/).
- **Support:** Email [teacher email] or chat for mid-week help.

---

### 3. Logbook Guidance
- **Entry for Today:** 
  - Notes on XAMPP installation and setup.
  - Code snippets from `index.php`.
  - Challenges faced (e.g., server errors) and time spent.
- **Tip:** Log daily to build a comprehensive record for the next 2 months.

---

### Next Session
- **Date:** Wednesday, August 20, 2025, 5:00 PM - 6:30 PM WAT
- **Focus:** Review Class Work 1 & Project Task 1, teach PHP form processing and JavaScript basics.

---

**Note:** This material aligns with the PRD's Week 1 task (set up PHP project folder & HTML form) and prepares you for hands-on development. Enjoy building PinkScribe! 💖