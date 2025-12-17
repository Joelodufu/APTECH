```php
<?php
// Check if form was submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Collect input safely
    $username = htmlspecialchars($_POST['username']);
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Text Input Example</title>
</head>
<body>
    <h2>Enter Your Name</h2>

    <!-- The form submits to the same file -->
    <form method="POST" action="">
        <input type="text" name="username" placeholder="Type your name here" required>
        <button type="submit">Submit</button>
    </form>

    <?php
    // Display result if form was submitted
    if (!empty($username)) {
        echo "<p>Hello, $username! 👋</p>";
    }
    ?>
</body>
</html>

```
