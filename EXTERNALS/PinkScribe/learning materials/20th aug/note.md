
# Learning Material for Session 2: PinkScribe Web App Development
**Date:** Wednesday, August 20, 2025  
**Time:** 5:00 PM - 6:30 PM WAT  
**Session Focus:** PHP Form Processing and JavaScript Basics  
**Prepared By:** [Your Name/Mentor Name]  
**Objective:** Build on Session 1 by teaching PHP form processing and introducing JavaScript basics, enabling the student to handle form submissions and add simple interactions for the PinkScribe project.

---

## Session Agenda (1.5 Hours)
- **Review Bottlenecks (15 min):** Address issues from Session 1's Class Work 1 and Project Task 1 (e.g., XAMPP setup errors, form submission bugs).
- **Teach & Initiate Next Step (60 min):** PHP form processing and JavaScript basics.
- **Assign & Discuss (15 min):** Class work and project tasks.

---

### 1. Review Bottlenecks (15 min)
- **Quick Check-In:** Since the session starts at 5:00 PM and it’s now 4:25 PM, use the first 15 minutes to:
  - Review the student's `hello.php` from Class Work 1 (e.g., did the form echo the name?).
  - Check the `index.php` upload form from Project Task 1 (e.g., does "File received!" appear on submission?).
  - Address common issues: XAMPP not running, PHP errors, or browser display problems.
- **Action:** Share screens or review logs to debug; note unresolved issues for follow-up.

---

### 2. Teach & Initiate Next Step (60 min)

#### Learning Concepts
This session advances the PinkScribe project by teaching PHP form processing and introducing JavaScript for basic interactions, aligning with the PRD's goals of strengthening PHP skills and learning front-end basics.

##### 2.1 PHP Form Processing
- **What is Form Processing?**
  - PHP handles data submitted via HTML forms (e.g., audio file uploads for PinkScribe).
  - Uses `$_POST` or `$_FILES` to access form data.
- **Key Concepts:**
  - Check if the form is submitted with `if ($_SERVER["REQUEST_METHOD"] == "POST")`.
  - Access form fields: `$_POST["field_name"]` for text, `$_FILES["field_name"]` for files.
- **Demo Example:**
  - Enhance `index.php` from Session 1:
    ```php
    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $file = $_FILES["audioFile"];
        $fileName = $file["name"];
        echo "Received file: " . htmlspecialchars($fileName);
    }
    ?>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>PinkScribe</title>
    </head>
    <body>
        <h1>PinkScribe 💖</h1>
        <form method="POST" action="index.php" enctype="multipart/form-data">
            <input type="file" name="audioFile">
            <input type="submit" value="Transcribe">
        </form>
        <?php if (isset($fileName)) echo "<p>Received file: $fileName</p>"; ?>
    </body>
    </html>
    ```
  - Test by uploading a file; it should display the file name.

##### 2.2 Introduction to JavaScript
- **What is JavaScript?**
  - A client-side language for adding interactivity (e.g., form feedback in PinkScribe).
- **Key Concepts:**
  - Use `document.getElementById` to access HTML elements.
  - Add event listeners (e.g., `onclick`) for actions.
- **Demo Example:**
  - Add JS to `index.php` for a simple alert on button click:
    ```html
    <script>
        document.querySelector('input[type="submit"]').onclick = function() {
            alert("Transcribing...");
        };
    </script>
    ```
  - Test by clicking "Transcribe" to see the alert.

##### Hands-On Demo
- Show how to update `index.php` with PHP to display the uploaded file name.
- Demonstrate adding JS to trigger an alert, linking it to the PRD's goal of small JS interactions.

---

### 3. Assign & Discuss (15 min)

#### Class Work
- **Task:** Create a PHP form with JavaScript interaction.
  - Include a text input for a user's name and a submit button.
  - Use PHP to display "Hello, [name]!" on submission.
  - Add JavaScript to show an alert ("Submitting...") when the button is clicked.
  - Steps:
    1. Create a new file `greet.php` in the `PinkScribe` folder.
    2. Build an HTML form with a text input (`<input type="text" name="name">`) and submit button.
    3. Add PHP to process the form and echo the greeting.
    4. Include JS to trigger the alert on button click.
  - Test in your browser and log any issues.
  - **Time:** 1-2 hours post-session.

#### Project Task
- **Task:** Enhance the PinkScribe upload form with PHP and JavaScript.
  - Steps:
    1. Update `index.php` to display the uploaded file name using PHP (as in the demo).
    2. Add JavaScript to show an alert ("Transcribing...") when the "Transcribe" button is clicked.
    3. Test with a sample audio file (MP3/WAV) and ensure both PHP and JS work.
  - Log the code changes, test results, and any errors encountered.
  - **Time:** 3-5 hours post-session.

#### Resources
- **Tutorials:** W3Schools PHP Forms ([https://www.w3schools.com/php/php_forms.asp](https://www.w3schools.com/php/php_forms.asp)) and JavaScript Intro ([https://www.w3schools.com/js/](https://www.w3schools.com/js/)).
- **Support:** Email [teacher email] or chat for mid-week help.

---

### 4. Logbook Guidance
- **Entry for Today:** 
  - Notes on PHP form processing and JS basics.
  - Code snippets from `greet.php` or `index.php` updates.
  - Challenges faced (e.g., JS not triggering) and time spent.
- **Tip:** Log daily to track progress toward PRD goals.

---

### Next Session
- **Date:** Monday, August 25, 2025, 5:00 PM - 6:30 PM WAT
- **Focus:** Review Class Work 2 & Project Task 2, teach PHP file uploads and validation.

---

**Note:** This material builds on Session 1, aligning with the PRD's Week 1 goal of setting up the project and introducing PHP/JS for future file handling and interactions. Happy coding! 💖
```

---

### Instructions for Use
- **Download:** Save this content as `Session2_2025-08-20.md`.
- **Share:** Distribute to the student and teacher via email or a shared platform (e.g., Google Drive, GitHub).
- **Live Adjustment:** Since it's 4:25 PM and the session starts at 5:00 PM, use the remaining time to prepare (e.g., test the demo code). Begin with the 15-minute review at 5:00 PM, addressing any Session 1 issues, then proceed with the 60-minute teaching segment. Adjust timing to end at 6:30 PM.