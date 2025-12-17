## Variables and Data Types
Features for declaring and managing variables and data types in Dart.

Features: var, final, const, int, double, String, bool, List, Map, Set, dynamic, Object, null

| Feature | Uses | Example | Practical Uses in Flutter |
|---------|------|---------|---------------------------|
| var | Infers type for variable declaration. | `var title = 'My App';` | Declaring widget properties like text. |
| final | Declares a variable that can be set once. | `final color = Colors.blue;` | Immutable widget configurations. |
| const | Declares compile-time constant. | `const maxItems = 10;` | Defining constant UI values like sizes. |
| int | Integer data type. | `int count = 5;` | Counters for lists or animations. |
| double | Floating-point data type. | `double price = 19.99;` | Prices or animation durations. |
| String | Text data type. | `String name = 'Flutter';` | Text widget content or API responses. |
| bool | Boolean (true/false) type. | `bool isVisible = true;` | Toggling widget visibility. |
| List | Ordered collection of items. | `List<String> items = ['A', 'B'];` | Populating ListView or DropdownButton. |
| Map | Key-value pair collection. | `Map<String, int> scores = {'Alice': 100};` | Storing form data or API payloads. |
| Set | Unordered collection of unique items. | `Set<String> tags = {'new', 'sale'};` | Unique categories in filters. |
| dynamic | Any type, bypassing type checking. | `dynamic value = 'Text';` | Handling unknown JSON types. |
| Object | Base type for all non-null objects. | `Object data = 42;` | Generic data in flexible APIs. |
| null | Represents absence of value. | `String? name = null;` | Nullable fields in forms or states. |

## Functions and Methods
Features for defining reusable code blocks in Dart.

Features: function declaration, arrow function, named parameters, optional parameters, async/await, Future

| Feature | Uses | Example | Practical Uses in Flutter |
|---------|------|---------|---------------------------|
| function declaration | Defines a reusable function. | `void showMessage(String msg) { print(msg); }` | Handling button click logic. |
| arrow function | Concise single-expression function. | `int add(int a, int b) => a + b;` | Short event handlers or calculations. |
| named parameters | Parameters passed by name. | `void buildWidget({required String title}) {}` | Configuring widgets with clarity. |
| optional parameters | Parameters with default or null values. | `void setPadding([double pad = 0]) {}` | Flexible widget styling. |
| async/await | Handles asynchronous operations. | `Future<String> fetchData() async { return await apiCall(); }` | Fetching data for network-bound UI. |
| Future | Represents a value available later. | `Future.delayed(Duration(seconds: 1), () => 'Done');` | Delayed animations or API calls. |

## Control Flow
Features for controlling program execution.

Features: if, else, switch, for, forEach, while, do-while, break, continue, try-catch

| Feature | Uses | Example | Practical Uses in Flutter |
|---------|------|---------|---------------------------|
| if | Conditional execution. | `if (isLoggedIn) { showDashboard(); }` | Showing widgets based on user state. |
| else | Alternative execution path. | `if (isEmpty) {} else { displayItems(); }` | Handling empty list states. |
| switch | Multi-way branching. | `switch (status) { case 'active': showActive(); break; }` | Handling UI states like tabs. |
| for | Loops with counter. | `for (var i = 0; i < 5; i++) { print(i); }` | Building repeated widgets in lists. |
| forEach | Iterates over collections. | `items.forEach((item) => print(item));` | Updating UI for each list item. |
| while | Loops while condition is true. | `while (loading) { updateProgress(); }` | Polling for async data. |
| do-while | Loops at least once. | `do { fetchMore(); } while (hasMore);` | Loading paginated data. |
| break | Exits loop or switch. | `for (var i = 0; i < 5; i++) { if (i == 3) break; }` | Stopping list processing early. |
| continue | Skips current loop iteration. | `for (var i = 0; i < 5; i++) { if (i == 2) continue; }` | Skipping invalid list items. |
| try-catch | Handles exceptions. | `try { await fetchData(); } catch (e) { showError(e); }` | Handling network errors in UI. |

## Classes and Object-Oriented Programming
Features for defining and working with objects in Dart/Flutter.

Features: class, constructor, named constructor, this, extends, implements, abstract, factory, getters/setters

| Feature | Uses | Example | Practical Uses in Flutter |
|---------|------|---------|---------------------------|
| class | Defines a blueprint for objects. | `class User { String name; }` | Modeling data like user profiles. |
| constructor | Initializes objects. | `User(this.name);` | Setting up widget state. |
| named constructor | Alternative constructor with specific logic. | `User.guest() : name = 'Guest';` | Creating default or guest users. |
| this | Refers to current instance. | `User(this.name);` | Simplifying constructor assignments. |
| extends | Inherits from a parent class. | `class Admin extends User {}` | Reusing widget or model logic. |
| implements | Implements an interface. | `class MyWidget implements StatelessWidget {}` | Ensuring widget contract compliance. |
| abstract | Defines a class that can’t be instantiated. | `abstract class Shape { void draw(); }` | Defining widget base classes. |
| factory | Returns instance from constructor. | `factory User.fromJson(Map json) { return User(json['name']); }` | Parsing JSON to objects. |
| getters/setters | Controls property access. | `String get fullName => '$name';` | Computed properties in models. |

## Collections and Iterables
Features for working with collections in Dart.

Features: List, Map, Set, add, remove, map, where, reduce, forEach (already covered)

| Feature | Uses | Example | Practical Uses in Flutter |
|---------|------|---------|---------------------------|
| List | Ordered collection. | `List<int> numbers = [1, 2, 3];` | Populating ListView or GridView. |
| Map | Key-value pairs. | `Map<String, String> user = {'name': 'Alice'};` | Storing form data or settings. |
| Set | Unique items collection. | `Set<String> tags = {'new', 'sale'};` | Filtering unique categories. |
| add | Adds item to List/Set. | `numbers.add(4);` | Adding items to dynamic lists. |
| remove | Removes item from List/Set. | `numbers.remove(1);` | Removing items from UI lists. |
| map | Transforms collection elements. | `numbers.map((n) => n * 2).toList();` | Transforming data for display. |
| where | Filters collection by condition. | `numbers.where((n) => n > 1).toList();` | Filtering items in search results. |
| reduce | Combines elements to single value. | `numbers.reduce((a, b) => a + b);` | Calculating totals in carts. |

## Null Safety
Features for handling null values safely in Dart.

Features: ?, !, ??, late

| Feature | Uses | Example | Practical Uses in Flutter |
|---------|------|---------|---------------------------|
| ? | Declares nullable type. | `String? name;` | Optional fields in forms. |
| ! | Asserts non-null value. | `String value = name!;` | Accessing nullable values confidently. |
| ?? | Provides default for null. | `String display = name ?? 'Unknown';` | Default text in Text widgets. |
| late | Delays initialization. | `late String title;` | Initializing widget properties later. |

## Flutter-Specific Widgets and Features
Dart features and classes commonly used in Flutter for building UI.

Features: Widget, StatelessWidget, StatefulWidget, build, setState, Navigator, FutureBuilder, StreamBuilder

| Feature | Uses | Example | Practical Uses in Flutter |
|---------|------|---------|---------------------------|
| Widget | Base class for UI elements. | `class MyWidget extends StatelessWidget {}` | Building reusable UI components. |
| StatelessWidget | Widget with immutable state. | `class MyText extends StatelessWidget { Widget build(BuildContext context) { return Text('Hello'); } }` | Static UI like labels or icons. |
| StatefulWidget | Widget with mutable state. | `class Counter extends StatefulWidget {}` | Dynamic UI like counters or forms. |
| build | Defines widget’s UI. | `Widget build(BuildContext context) { return Text('Hi'); }` | Rendering UI for widgets. |
| setState | Updates state and rebuilds UI. | `setState(() { count++; });` | Updating counters or toggles. |
| Navigator | Manages screen navigation. | `Navigator.push(context, MaterialPageRoute(builder: (context) => NextScreen()));` | Switching between app screens. |
| FutureBuilder | Builds UI based on Future. | `FutureBuilder(future: fetchData(), builder: (context, snapshot) => Text(snapshot.data ?? ''));` | Displaying async data like API results. |
| StreamBuilder | Builds UI based on Stream. | `StreamBuilder(stream: stream, builder: (context, snapshot) => Text(snapshot.data ?? ''));` | Real-time updates like chat messages. |

## Asynchrony and Concurrency
Features for handling asynchronous operations in Dart/Flutter.

Features: async, await, Future, Stream, async*

| Feature | Uses | Example | Practical Uses in Flutter |
|---------|------|---------|---------------------------|
| async | Marks function as asynchronous. | `Future<void> loadData() async {}` | Fetching data for UI updates. |
| await | Waits for Future to complete. | `var data = await fetchData();` | Waiting for API responses. |
| Future | Represents a future value. | `Future<String> fetchData() => Future.value('Data');` | Handling API or file operations. |
| Stream | Represents a sequence of async events. | `Stream<int> countStream() async* { yield 1; }` | Real-time data like notifications. |
| async* | Defines a stream generator. | `Stream<int> numbers() async* { yield 1; yield 2; }` | Streaming live data to UI. |

## Libraries and Packages
Common Dart/Flutter libraries for extended functionality.

Features: dart:core, flutter:material, flutter:cupertino, http, provider

| Feature | Uses | Example | Practical Uses in Flutter |
|---------|------|---------|---------------------------|
| dart:core | Core Dart library (List, Map, etc.). | `import 'dart:core'; List<int> nums = [1, 2];` | Using built-in types everywhere. |
| flutter:material | Material Design widgets. | `import 'package:flutter/material.dart'; MaterialApp()` | Building Android-style apps. |
| flutter:cupertino | iOS-style widgets. | `import 'package:flutter/cupertino.dart'; CupertinoApp()` | Building iOS-style apps. |
| http | Makes HTTP requests. | `import 'package:http/http.dart'; get(Uri.parse('api'));` | Fetching data from REST APIs. |
| provider | State management solution. | `import 'package:provider/provider.dart'; Provider.of<MyModel>(context);` | Managing app state like user data. |