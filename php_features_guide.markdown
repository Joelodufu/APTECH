## Variables and Data Types
Features for declaring and managing variables and data types in PHP.

Features: $variable, int, float, string, bool, array, object, null, resource

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| $variable | Declares a variable with dynamic typing. | `$name = "John";` | Storing user input or session data. |
| int | Integer data type. | `$count = 42;` | Counters for loops or IDs. |
| float | Floating-point number. | `$price = 19.99;` | Prices or measurements in forms. |
| string | Text data type. | `$title = "Welcome";` | Displaying text in web pages. |
| bool | Boolean (true/false) type. | `$isActive = true;` | Toggling features or permissions. |
| array | Ordered or associative collection. | `$items = ['apple', 'banana'];` | Storing lists like menu items. |
| object | Instance of a class. | `$user = new stdClass; $user->name = "John";` | Representing structured data like users. |
| null | Represents no value. | `$data = null;` | Clearing variables or default states. |
| resource | Reference to external resource (e.g., file, database). | `$file = fopen("data.txt", "r");` | Handling files or database connections. |

## Control Structures
Features for controlling program flow.

Features: if, else, elseif, switch, for, foreach, while, do-while, break, continue

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| if | Conditional execution. | `if ($age > 18) { echo "Adult"; }` | Restricting access by age. |
| else | Alternative execution path. | `if ($loggedIn) {} else { echo "Please log in"; }` | Handling unauthenticated users. |
| elseif | Additional conditional check. | `if ($score > 80) {} elseif ($score > 50) { echo "Pass"; }` | Grading systems in forms. |
| switch | Multi-way branching. | `switch ($day) { case 1: echo "Monday"; break; }` | Handling form input options. |
| for | Loops with counter. | `for ($i = 0; $i < 5; $i++) { echo $i; }` | Generating table rows. |
| foreach | Iterates over arrays. | `foreach ($items as $item) { echo $item; }` | Displaying product lists. |
| while | Loops while condition is true. | `while ($count > 0) { $count--; }` | Processing queued tasks. |
| do-while | Loops at least once. | `do { echo $x--; } while ($x > 0);` | Ensuring one iteration for data fetch. |
| break | Exits loop or switch. | `for ($i = 0; $i < 5; $i++) { if ($i == 3) break; }` | Stopping loop on condition. |
| continue | Skips current loop iteration. | `for ($i = 0; $i < 5; $i++) { if ($i == 2) continue; }` | Skipping invalid data in loops. |

## Functions
Features for defining and using reusable code blocks.

Features: function, return, default parameters, anonymous function, arrow function (PHP 7.4+), variable function

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| function | Defines a reusable function. | `function add($a, $b) { return $a + $b; }` | Calculating totals in carts. |
| return | Exits function with a value. | `function getName() { return "John"; }` | Returning user data to templates. |
| default parameters | Sets default argument values. | `function greet($name = "Guest") { return "Hello, $name"; }` | Optional form inputs. |
| anonymous function | Unnamed function for callbacks. | `$greet = function($name) { echo "Hi, $name"; };` | Event handlers in frameworks. |
| arrow function | Concise anonymous function (PHP 7.4+). | `$add = fn($a, $b) => $a + $b;` | Short callbacks in array_map. |
| variable function | Calls function by its name stored in variable. | `$func = 'add'; $func(2, 3);` | Dynamic function calls in plugins. |

## Arrays
Features for working with arrays in PHP.

Features: array(), count, array_push, array_pop, array_merge, array_map, array_filter, foreach (already covered)

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| array() | Creates an array. | `$fruits = array('apple', 'banana');` | Storing lists like form options. |
| count | Returns number of elements. | `count($fruits);` | Checking list size for validation. |
| array_push | Adds elements to array end. | `array_push($fruits, 'orange');` | Adding items to a cart. |
| array_pop | Removes last element. | `array_pop($fruits);` | Removing last item in a queue. |
| array_merge | Combines arrays. | `$combined = array_merge($fruits, $veggies);` | Merging data from multiple sources. |
| array_map | Applies function to each element. | `array_map('strtoupper', $fruits);` | Transforming data for display. |
| array_filter | Filters elements by callback. | `array_filter($numbers, fn($n) => $n > 0);` | Filtering valid form submissions. |

## String Functions
Built-in functions for manipulating strings.

Features: strlen, strtoupper, strtolower, substr, str_replace, trim, explode, implode

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| strlen | Returns string length. | `strlen("Hello");` | Validating input length in forms. |
| strtoupper | Converts string to uppercase. | `strtoupper("hello");` | Formatting titles for display. |
| strtolower | Converts string to lowercase. | `strtolower("HELLO");` | Normalizing user input. |
| substr | Extracts part of a string. | `substr("Hello", 0, 3);` | Extracting prefixes like usernames. |
| str_replace | Replaces part of a string. | `str_replace("World", "PHP", "Hello World");` | Updating text in templates. |
| trim | Removes whitespace from both ends. | `trim("  Hello  ");` | Cleaning form inputs. |
| explode | Splits string into array by delimiter. | `explode(",", "a,b,c");` | Parsing CSV data. |
| implode | Joins array into string with delimiter. | `implode(",", ['a', 'b', 'c']);` | Creating CSV strings for export. |

## Object-Oriented Programming
Features for defining and working with classes and objects.

Features: class, new, $this, public/private/protected, extends, interface, abstract, static

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| class | Defines a blueprint for objects. | `class User { public $name; }` | Modeling entities like users. |
| new | Creates an object instance. | `$user = new User();` | Instantiating models for data. |
| $this | Refers to current object. | `$this->name = "John";` | Accessing instance properties. |
| public | Accessible everywhere. | `public $name;` | Exposing properties like user details. |
| private | Accessible only within class. | `private $password;` | Protecting sensitive data. |
| protected | Accessible in class and subclasses. | `protected $id;` | Sharing data with child classes. |
| extends | Inherits from parent class. | `class Admin extends User {}` | Reusing code in user hierarchies. |
| interface | Defines method contracts. | `interface Loggable { public function log(); }` | Ensuring class behavior in plugins. |
| abstract | Defines a class that can’t be instantiated. | `abstract class Model { abstract function save(); }` | Base classes for database models. |
| static | Class-level member. | `static $count = 0;` | Tracking shared data like user count. |

## Database Interaction
Features for interacting with databases (e.g., MySQL via PDO or mysqli).

Features: PDO, mysqli_connect, prepare, execute, query, fetch

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| PDO | Database access abstraction. | `$pdo = new PDO("mysql:host=localhost;dbname=test", "user", "pass");` | Connecting to databases securely. |
| mysqli_connect | Connects to MySQL database. | `$conn = mysqli_connect("localhost", "user", "pass", "test");` | Establishing database connections. |
| prepare | Prepares SQL statement for execution. | `$stmt = $pdo->prepare("SELECT * FROM users WHERE id = ?");` | Preventing SQL injection in queries. |
| execute | Executes prepared statement. | `$stmt->execute([1]);` | Running parameterized queries. |
| query | Executes direct SQL query. | `$result = $pdo->query("SELECT * FROM products");` | Fetching data for simple queries. |
| fetch | Retrieves query results. | `$row = $stmt->fetch(PDO::FETCH_ASSOC);` | Displaying database results in tables. |

## HTTP and Request Handling
Features for handling web requests and responses.

Features: $_GET, $_POST, $_SESSION, header, $_SERVER, filter_input

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| $_GET | Accesses URL query parameters. | `$id = $_GET['id'];` | Retrieving IDs from URLs. |
| $_POST | Accesses form POST data. | `$name = $_POST['name'];` | Processing form submissions. |
| $_SESSION | Stores session data. | `$_SESSION['user'] = 'John';` | Maintaining user login state. |
| header | Sets HTTP headers. | `header("Location: /home.php");` | Redirecting users after login. |
| $_SERVER | Accesses server and request info. | `$ip = $_SERVER['REMOTE_ADDR'];` | Logging user IP addresses. |
| filter_input | Sanitizes/validates input. | `$email = filter_input(INPUT_POST, 'email', FILTER_VALIDATE_EMAIL);` | Validating form inputs. |

## File Handling
Features for working with files and directories.

Features: file_get_contents, file_put_contents, fopen, fclose, fread, fwrite, unlink

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| file_get_contents | Reads file into string. | `$data = file_get_contents("config.txt");` | Loading configuration files. |
| file_put_contents | Writes string to file. | `file_put_contents("log.txt", "Error");` | Logging errors to a file. |
| fopen | Opens a file or URL. | `$file = fopen("data.txt", "r");` | Reading CSV files for import. |
| fclose | Closes an open file. | `fclose($file);` | Releasing file resources. |
| fread | Reads from an open file. | `$content = fread($file, filesize("data.txt"));` | Reading file contents for display. |
| fwrite | Writes to an open file. | `fwrite($file, "Hello");` | Writing user data to files. |
| unlink | Deletes a file. | `unlink("temp.txt");` | Removing temporary files. |

## Error and Exception Handling
Features for managing errors and exceptions.

Features: try-catch, throw, set_error_handler, error_reporting

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| try-catch | Handles exceptions. | `try { $db->query("INVALID"); } catch (Exception $e) { echo $e->getMessage(); }` | Handling database errors. |
| throw | Throws an exception. | `throw new Exception("Invalid input");` | Custom error messages in forms. |
| set_error_handler | Sets custom error handler. | `set_error_handler(function($errno, $errstr) { log($errstr); });` | Logging runtime errors. |
| error_reporting | Configures error reporting level. | `error_reporting(E_ALL);` | Debugging during development. |