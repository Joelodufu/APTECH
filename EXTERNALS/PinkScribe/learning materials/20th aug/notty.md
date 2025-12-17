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