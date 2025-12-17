# Dart Language Features Guide

This guide organizes key Dart language features, starting with classes of data (primitive and reference types) and incorporating operators, followed by other essential features. Each category lists relevant Dart features (keywords, constructs, or functions), with a table detailing the feature, its uses, an example, and practical applications. The focus is on core Dart features for general-purpose programming, excluding Flutter-specific elements, based on Dart 3.x documentation for clarity and relevance.

## Classes of Data: Primitive Types
Primitive types in Dart are basic data types that hold simple values directly, not references to objects. Dart is object-oriented, so even primitives are objects under the hood, but they behave as simple values.

Features: int, double, bool, String, null

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| int | Integer values (64-bit on most platforms). | `int score = 100;` | Counters, indices, or IDs in algorithms. |
| double | Floating-point numbers. | `double price = 19.99;` | Financial calculations or measurements. |
| bool | Boolean values (true/false). | `bool isActive = true;` | Conditional flags for logic or validation. |
| String | Sequence of UTF-16 characters. | `String name = "Dart";` | Text processing for logs or user input. |
| null | Represents absence of value (with null safety). | `String? value = null;` | Optional or uninitialized variables. |

## Classes of Data: Reference Types
Reference types are objects that store references to data in memory, including collections, user-defined classes, and other complex types. These are mutable or immutable based on their implementation.

Features: List, Map, Set, Object?, dynamic, user-defined class

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| List | Ordered collection of items. | `List<int> numbers = [1, 2, 3];` | Storing sequences like task lists. |
| Map | Key-value pair collection. | `Map<String, int> scores = {'Alice': 90};` | Storing structured data like configs. |
| Set | Unordered collection of unique items. | `Set<String> tags = {'new', 'sale'};` | Deduplicating data like categories. |
| Object? | Base type for all objects, nullable. | `Object? data = 42;` | Generic type for flexible APIs. |
| dynamic | Bypasses static type checking. | `dynamic value = "text";` | Handling JSON or mixed-type data. |
| user-defined class | Custom object blueprint. | `class Person { String name; Person(this.name); }` | Modeling entities like users or products. |

## Operators
Dart operators for arithmetic, comparison, logical, and other operations.

Features: +, -, *, /, %, ==, !=, <, >, <=, >=, &&, ||, !, ??, is, as, ~/ (integer division), ++, --

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| + | Addition or string concatenation. | `int sum = 5 + 3; String text = "Hello" + " World";` | Calculating totals or building strings. |
| - | Subtraction. | `int diff = 5 - 3;` | Computing differences like balances. |
| * | Multiplication. | `int product = 5 * 3;` | Scaling values in computations. |
| / | Division (returns double). | `double result = 10 / 3;` | Calculating averages or ratios. |
| % | Modulus (remainder). | `int remainder = 10 % 3;` | Checking divisibility or cycling. |
| == | Equality check. | `if (x == y)` | Comparing values like user IDs. |
| != | Inequality check. | `if (x != y)` | Ensuring distinct values. |
| <, >, <=, >= | Comparison operators. | `if (x < 10)` | Filtering data like age or price. |
| && | Logical AND. | `if (x > 0 && y > 0)` | Combining conditions in validation. |
| || | Logical OR. | `if (x == 0 || y == 0)` | Fallback logic in checks. |
| ! | Logical NOT. | `if (!isValid)` | Inverting boolean conditions. |
| ?? | Null-coalescing (default if null). | `String display = name ?? "Unknown";` | Providing defaults for null values. |
| is | Type checking. | `if (value is String)` | Validating types in mixed data. |
| as | Type casting. | `var str = value as String;` | Converting types safely. |
| ~/ | Integer division (returns int). | `int quotient = 10 ~/ 3;` | Floor division for counters. |
| ++ | Increments by 1. | `x++;` | Loop counters or increments. |
| -- | Decrements by 1. | `x--;` | Decreasing counters in loops. |

## Control Flow
Features for controlling program execution.

Features: if, else, switch, for, for-in, while, do-while, break, continue, assert

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| if | Conditional execution. | `if (score > 50) { print("Pass"); }` | Validating conditions like input checks. |
| else | Alternative execution path. | `if (isEmpty) {} else { print("Not empty"); }` | Handling default cases. |
| switch | Multi-way branching. | `switch (grade) { case 'A': print("Excellent"); break; }` | Processing multiple states. |
| for | Loops with counter. | `for (var i = 0; i < 5; i++) { print(i); }` | Iterating over arrays or ranges. |
| for-in | Iterates over iterables. | `for (var item in list) { print(item); }` | Processing list or set elements. |
| while | Loops while condition is true. | `while (retries > 0) { retries--; }` | Polling or retry logic. |
| do-while | Loops at least once. | `do { print(x--); } while (x > 0);` | Ensuring one iteration for tasks. |
| break | Exits loop or switch. | `for (var i = 0; i < 5; i++) { if (i == 3) break; }` | Early loop termination. |
| continue | Skips current loop iteration. | `for (var i = 0; i < 5; i++) { if (i == 2) continue; }` | Skipping invalid items. |
| assert | Checks condition during debugging. | `assert(x >= 0, "Must be non-negative");` | Validating invariants in code. |

## Functions
Features for defining reusable code blocks.

Features: function declaration, arrow function, named parameters, optional parameters, lambda (closure), Function type

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| function declaration | Defines named function. | `int add(int a, int b) { return a + b; }` | Reusable logic like calculations. |
| arrow function | Concise single-expression function. | `int square(int x) => x * x;` | Short utility functions. |
| named parameters | Parameters passed by name. | `void greet({required String name}) => print("Hi, $name");` | Clear API for function calls. |
| optional parameters | Parameters with default/null values. | `void log([String? msg]) => print(msg ?? "Log");` | Flexible function inputs. |
| lambda (closure) | Anonymous function capturing scope. | `var add = (int x, int y) => x + y;` | Callbacks in async operations. |
| Function type | Type for function references. | `Function callback = (int x) => print(x);` | Passing functions as arguments. |

## Collections and Iterables
Features for working with collections.

Features: List.add, List.remove, Map.putIfAbsent, Set.add, List.map, List.where, fold, forEach

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| List.add | Adds item to list. | `numbers.add(4);` | Appending data to dynamic lists. |
| List.remove | Removes first matching item. | `numbers.remove(2);` | Deleting items from lists. |
| Map.putIfAbsent | Adds key-value pair if key absent. | `scores.putIfAbsent("Bob", () => 80);` | Default values in configs. |
| Set.add | Adds item to set. | `tags.add("new");` | Adding unique elements. |
| List.map | Transforms elements to new iterable. | `numbers.map((n) => n * 2).toList();` | Transforming data for processing. |
| List.where | Filters elements by condition. | `numbers.where((n) => n > 0).toList();` | Filtering valid records. |
| fold | Reduces iterable to single value. | `numbers.fold(0, (sum, n) => sum + n);` | Summing values like totals. |
| forEach | Applies function to each element. | `numbers.forEach((n) => print(n));` | Logging or processing items. |

## Object-Oriented Programming
Features for defining and working with classes and objects.

Features: class, constructor, named constructor, this, extends, implements, abstract, factory, getter/setter

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| class | Defines object blueprint. | `class Person { String name; }` | Modeling entities like users. |
| constructor | Initializes objects. | `Person(this.name);` | Setting up object state. |
| named constructor | Alternative constructor logic. | `Person.guest() : name = "Guest";` | Default or special instances. |
| this | Refers to current instance. | `this.name = name;` | Assigning constructor arguments. |
| extends | Inherits from parent class. | `class Employee extends Person {}` | Reusing code in hierarchies. |
| implements | Implements interface methods. | `class Logger implements Printable { void print() {} }` | Ensuring method contracts. |
| abstract | Defines non-instantiable class. | `abstract class Shape { void draw(); }` | Base classes for models. |
| factory | Returns instance from constructor. | `factory Person.fromJson(Map json) { return Person(json['name']); }` | Parsing data to objects. |
| getter/setter | Controls property access. | `String get fullName => name;` | Computed properties in models. |

## Null Safety
Features for safe handling of null values.

Features: ?, !, ??, late, required

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| ? | Declares nullable type. | `String? name;` | Optional data fields. |
| ! | Asserts non-null value. | `String value = name!;` | Accessing nullable values safely. |
| ?? | Provides default for null. | `String display = name ?? "Unknown";` | Default values for missing data. |
| late | Delays initialization. | `late String title;` | Initializing variables at runtime. |
| required | Marks named parameter as mandatory. | `void setData({required String id}) {}` | Enforcing required arguments. |

## Asynchrony
Features for handling asynchronous operations.

Features: async, await, Future, Stream, async*, yield

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| async | Marks function as asynchronous. | `Future<int> fetch() async { return 42; }` | Async data fetching. |
| await | Waits for Future completion. | `int result = await fetch();` | Sequential async processing. |
| Future | Represents future value. | `Future.delayed(Duration(seconds: 1), () => 42);` | Delayed tasks or API calls. |
| Stream | Sequence of async events. | `Stream<int> count() async* { yield 1; yield 2; }` | Real-time data like logs. |
| async* | Defines stream generator. | `Stream<int> numbers() async* { yield 1; }` | Streaming data sequences. |
| yield | Emits value in stream. | `yield 3;` | Producing stream values. |

## Standard Libraries
Common Dart libraries for extended functionality.

Features: dart:core, dart:math, dart:io, dart:convert, dart:async

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| dart:core | Core types and functions (List, Map). | `List<int> nums = [1, 2];` | Basic data structures. |
| dart:math | Mathematical functions and constants. | `import 'dart:math'; double root = sqrt(16);` | Calculations in algorithms. |
| dart:io | File and network I/O. | `import 'dart:io'; File('data.txt').readAsString();` | Reading/writing files. |
| dart:convert | Data encoding/decoding (JSON, UTF-8). | `import 'dart:convert'; jsonDecode('{"key": "value"}');` | Parsing API responses. |
| dart:async | Async programming utilities. | `import 'dart:async'; Timer(Duration(seconds: 1), () {});` | Scheduling tasks or timeouts. |

## Exception Handling
Features for managing errors and exceptions.

Features: try, catch, on, finally, throw

| Feature | Uses | Example | Practical Uses |
|---------|------|---------|----------------|
| try | Monitors block for exceptions. | `try { int x = 1 ~/ 0; }` | Wrapping risky operations. |
| catch | Handles exceptions with stack trace. | `catch (e, s) { print(e); }` | Logging errors. |
| on | Handles specific exception types. | `on FormatException catch (e) { print("Invalid format"); }` | Type-specific error handling. |
| finally | Runs regardless of exception. | `finally { print("Cleanup"); }` | Releasing resources. |
| throw | Throws an exception. | `throw Exception("Invalid input");` | Custom error signaling. |