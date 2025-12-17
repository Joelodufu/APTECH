# Comprehensive Course on the Stack Widget in Flutter

## Course Overview

This course is designed for beginner to intermediate Flutter developers who want to master the `Stack` widget, a powerful layout widget in Flutter used to overlay multiple children in a layered arrangement. The `Stack` widget is ideal for creating complex UIs, such as overlapping images, badges, or layered designs. This course covers its properties, use cases, and best practices through hands-on exercises and projects.

**Course Goals:**

- Understand the `Stack` widget’s core properties and functionality.
- Learn to position and align children within a stack.
- Build practical UI components using `Stack` in real-world scenarios.
- Combine `Stack` with other widgets for sophisticated layouts.

**Prerequisites:**

- Basic knowledge of Flutter and Dart.
- Flutter SDK installed (version 3.0+ recommended).
- A code editor like VS Code or Android Studio.

**Duration:** 4-6 hours, divided into 7 modules.
**Format:** Each module includes explanations, code examples, exercises, and quizzes. Use the provided code in a new Flutter project to test.

Create a basic Flutter app for exercises:

```dart
import 'package:flutter/material.dart';

void main() {
runApp(const MyApp());
}

class MyApp extends StatelessWidget {
const MyApp({super.key});

@override
Widget build(BuildContext context) {
return MaterialApp(
home: Scaffold(
appBar: AppBar(title: const Text('Stack Widget Course')),
body: const Center(
child: Stack(
// Your Stack experiments here
),
),
),
);
}
}
```

---

## Module 1: Introduction to the Stack Widget

### What is Stack?

`Stack` is a multi-child widget that arranges its children in a layered order, allowing them to overlap. It’s ideal for designs requiring elements to stack on top of each other, like badges, layered images, or floating buttons.

### Key Features

- Layers children in z-order (last child on top).
- Supports positioned and non-positioned children.
- Controls alignment and clipping of children.
- Constructor:

```dart
Stack({
  Key? key,
  AlignmentGeometry alignment = AlignmentDirectional.topStart,
  TextDirection? textDirection,
  StackFit fit = StackFit.loose,
  Clip clipBehavior = Clip.hardEdge,
  List<Widget> children = const <Widget>[],
})
```

### Basic Example

A simple stack with overlapping containers:

```dart
Stack(
  children: [
    Container(
      width: 200,
      height: 200,
      color: Colors.blue,
    ),
    Container(
      width: 150,
      height: 150,
      color: Colors.red,
    ),
  ],
)
```

### Exercise 1.1

Create a `Stack` with three overlapping 100x100 containers, colored blue, red, and green (green on top). Run and screenshot the result.

### Quiz 1

1. In what order are `Stack` children rendered? (Answer: Last child on top)
2. What is the default `alignment`? (Answer: AlignmentDirectional.topStart)

---

## Module 2: Alignment and StackFit

### Alignment

Controls the positioning of non-positioned children within the stack.
Options: `topLeft`, `topCenter`, `center`, etc.
Example (Center Alignment):

```dart
Stack(
  alignment: Alignment.center,
  children: [
    Container(width: 200, height: 200, color: Colors.blue),
    Container(width: 100, height: 100, color: Colors.red),
  ],
)
```

### StackFit

Determines how non-positioned children are sized.
Options: `loose` (default, children use their own size), `expand` (children fill stack), `passthrough`.
Example (Expand):

```dart
Stack(
  fit: StackFit.expand,
  children: [
    Container(color: Colors.blue),
    Container(width: 100, height: 100, color: Colors.red),
  ],
)
```

### Exercise 2.1

Create a `Stack` with two containers (200x200 and 100x100) aligned to the bottom-right.

### Exercise 2.2

Build a `Stack` with `StackFit.expand` and two containers, one filling the stack and one smaller.

### Quiz 2

1. What does `StackFit.loose` do? (Answer: Allows children to use their own size)
2. How does `alignment` affect positioned children? (Answer: It doesn’t, only non-positioned)

---

## Module 3: Positioned Widget

### Positioned

Controls the exact position of a child within the stack using `top`, `bottom`, `left`, `right`.
Example:

```dart
Stack(
  children: [
    Container(width: 200, height: 200, color: Colors.blue),
    Positioned(
      top: 20,
      left: 20,
      child: Container(width: 100, height: 100, color: Colors.red),
    ),
  ],
)
```

### Positioned.fill

Forces a child to fill the stack’s bounds.
Example:

```dart
Stack(
  children: [
    Container(color: Colors.blue),
    Positioned.fill(
      child: Container(color: Colors.red.withOpacity(0.5)),
    ),
  ],
)
```

### Exercise 3.1

Create a `Stack` with a 200x200 blue container and a 50x50 red container positioned 30 pixels from the top-left.

### Exercise 3.2

Build a `Stack` with a `Positioned.fill` child overlaying a semi-transparent green layer.

### Quiz 3

1. What properties does `Positioned` use? (Answer: top, bottom, left, right, width, height)
2. Can a non-positioned child be placed precisely? (Answer: No, use Positioned)

---

## Module 4: Clip Behavior and TextDirection

### Clip Behavior

Controls how overflowing content is clipped.
Options: `none`, `hardEdge`, `antiAlias`, `antiAliasWithSaveLayer`.
Example:

```dart
Stack(
  clipBehavior: Clip.antiAlias,
  children: [
    Container(width: 200, height: 200, color: Colors.blue),
    Positioned(
      top: -20,
      left: -20,
      child: Container(width: 100, height: 100, color: Colors.red),
    ),
  ],
)
```

### TextDirection

Affects alignment for non-positioned children in languages with right-to-left (RTL) text.
Example (RTL):

```dart
Stack(
  textDirection: TextDirection.rtl,
  alignment: AlignmentDirectional.topStart,
  children: [
    Container(width: 200, height: 200, color: Colors.blue),
    Container(width: 100, height: 100, color: Colors.red),
  ],
)
```

### Exercise 4.1

Create a `Stack` with a container overflowing the stack, clipped with `Clip.antiAlias`.

### Exercise 4.2

Build a `Stack` with `TextDirection.rtl` and two non-positioned containers.

### Quiz 4

1. What does `Clip.hardEdge` do? (Answer: Clips content sharply without anti-aliasing)
2. When is `textDirection` relevant? (Answer: For RTL layouts or directional alignment)

---

## Module 5: Combining Stack with Other Widgets

### With Containers

Use `Container` for styled layers.
Example:

```dart
Stack(
  children: [
    Container(
      width: 200,
      height: 200,
      decoration: const BoxDecoration(
        gradient: LinearGradient(colors: [Colors.blue, Colors.purple]),
      ),
    ),
    Positioned(
      bottom: 10,
      right: 10,
      child: Container(
        padding: const EdgeInsets.all(8),
        color: Colors.white,
        child: const Text('Badge'),
      ),
    ),
  ],
)
```

### With Row/Column

Nest `Row` or `Column` for complex layouts.
Example:

```dart
Stack(
  children: [
    Container(width: 200, height: 200, color: Colors.blue),
    Positioned(
      bottom: 20,
      left: 20,
      child: Column(
        children: [
          Container(width: 100, height: 40, color: Colors.red),
          Container(width: 100, height: 40, color: Colors.yellow),
        ],
      ),
    ),
  ],
)
```

### Exercise 5.1

Create a `Stack` with a gradient background container and a positioned text badge.

### Exercise 5.2

Build a `Stack` with a `Row` of two small containers positioned at the top-right.

### Quiz 5

1. Can you nest a `Column` in a `Stack`? (Answer: Yes)
2. What widget is required for precise positioning in a `Stack`? (Answer: Positioned)

---

## Module 6: Practical Projects

### Project 1: Profile Avatar with Badge

Build a profile image with an online status badge.
<xaiArtifact artifact_id="06907961-f263-4b43-ad14-1f0521572ff2" artifact_version_id="f88de824-6f11-4e32-899a-ccc05e7ae4fd" title="avatar_badge.dart" contentType="text/x-dart">
import 'package:flutter/material.dart';

class AvatarWithBadge extends StatelessWidget {
const AvatarWithBadge({super.key});

@override
Widget build(BuildContext context) {
return Stack(
alignment: Alignment.center,
children: [
Container(
width: 120,
height: 120,
decoration: BoxDecoration(
shape: BoxShape.circle,
image: const DecorationImage(
image: NetworkImage('https://example.com/avatar.jpg'),
fit: BoxFit.cover,
),
border: Border.all(color: Colors.white, width: 4),
boxShadow: const [BoxShadow(color: Colors.black45, blurRadius: 5)],
),
),
Positioned(
bottom: 0,
right: 0,
child: Container(
width: 30,
height: 30,
decoration: const BoxDecoration(
shape: BoxShape.circle,
color: Colors.green,
border: Border.fromBorderSide(BorderSide(color: Colors.white, width: 2)),
),
),
),
],
);
}
}
</xaiArtifact>
Usage: Replace `Stack` in `main.dart` with `AvatarWithBadge`.

### Project 2: Card with Overlay Button

Create a card with a floating action button overlay.
<xaiArtifact artifact_id="c5c0c9dd-09ca-4df7-8510-65e64a17f2f0" artifact_version_id="6bef5c78-0d70-4cdc-a66a-b7b9d59e29bb" title="card_with_button.dart" contentType="text/x-dart">
import 'package:flutter/material.dart';

class CardWithButton extends StatelessWidget {
const CardWithButton({super.key});

@override
Widget build(BuildContext context) {
return Stack(
clipBehavior: Clip.none,
children: [
Container(
width: 250,
height: 150,
decoration: BoxDecoration(
gradient: const LinearGradient(colors: [Colors.blue, Colors.purple]),
borderRadius: BorderRadius.circular(10),
boxShadow: const [BoxShadow(color: Colors.black45, blurRadius: 5)],
),
child: const Center(
child: Text('Featured Card', style: TextStyle(color: Colors.white, fontSize: 20)),
),
),
Positioned(
right: -20,
top: -20,
child: FloatingActionButton(
onPressed: () {},
child: const Icon(Icons.add),
),
),
],
);
}
}
</xaiArtifact>
Usage: Replace `Stack` in `main.dart` with `CardWithButton`.

### Exercise 6.1

Extend Project 1 to add a text label inside the badge.

### Exercise 6.2

Modify Project 2 to position the button at the bottom-left with a different icon.

---

## Module 7: Review, Quizzes, and Next Steps

### Final Quiz

1. Name three `StackFit` values. (Answer: loose, expand, passthrough)
2. What widget is used for precise positioning in a `Stack`? (Answer: Positioned)
3. How does `clipBehavior` affect a `Stack`? (Answer: Controls overflow clipping)
4. True/False: Non-positioned children are affected by `alignment`. (Answer: True)
5. What’s the purpose of `Positioned.fill`? (Answer: Forces child to fill stack bounds)

### Best Practices

- Use `Stack` for overlapping layouts; prefer `Row` or `Column` for linear arrangements.
- Combine with `Positioned` for precise control.
- Avoid excessive layering to optimize performance.
- Test layouts on different screen sizes for responsiveness.
- Use `clipBehavior` wisely to manage overflow.

### Next Steps

- Explore related widgets: `Row`, `Column`, `IndexedStack`.
- Build a full app UI with `Stack` (e.g., dashboard, image gallery).
- Check Flutter docs: https://api.flutter.dev/flutter/widgets/Stack-class.html
- Practice on DartPad or create a portfolio app with layered layouts.

Congratulations on completing the course! Use the `Stack` widget to craft dynamic, overlapping layouts in your Flutter apps. Experiment further or share your projects for feedback.
