# **JavaScript Control Flow**

**Control Flow** determines **how your code executes** — the order in which statements run in a program.

By default, JavaScript executes code **from top to bottom**, **left to right**.
However, using **control flow statements**, we can make decisions and repeat actions based on conditions.

---

## **1. Conditional Statements**

Conditional statements let the program **make decisions** based on certain conditions (true/false values).

---

### **1.1 `if` Statement**

Used to run a block of code **only if** a condition is true.

```js
let age = 18;

if (age >= 18) {
  console.log("You are an adult.");
}
```

✅ **Explanation:**
If the condition inside parentheses `()` is **true**, the code inside `{}` runs.
If it’s **false**, JavaScript skips it.

---

### **1.2 `if...else` Statement**

Used when there are **two possible outcomes**.

```js
let age = 16;

if (age >= 18) {
  console.log("You can vote.");
} else {
  console.log("You are too young to vote.");
}
```

✅ **Explanation:**

- If condition is true → `if` block runs
- Else → `else` block runs

---

### **1.3 `if...else if...else` Statement**

Used for **multiple conditions**.

```js
let score = 75;

if (score >= 90) {
  console.log("Excellent");
} else if (score >= 70) {
  console.log("Good");
} else if (score >= 50) {
  console.log("Fair");
} else {
  console.log("Fail");
}
```

✅ **Explanation:**

- Checks conditions **in order**.
- As soon as one is true, the others are ignored.

---

### **1.4 `switch` Statement**

Used when checking **one variable against multiple possible values**.

```js
let day = 3;

switch (day) {
  case 1:
    console.log("Monday");
    break;
  case 2:
    console.log("Tuesday");
    break;
  case 3:
    console.log("Wednesday");
    break;
  default:
    console.log("Invalid day");
}
```

✅ **Notes:**

- Each `case` represents a possible value.
- Use `break` to stop the switch after a match.
- `default` runs if no case matches.

---

## **2. Loops (Repetition Statements)**

Loops allow you to **repeat a block of code** multiple times, either for a specific count or while a condition is true.

---

### **2.1 `for` Loop**

Runs code a specific number of times.

```js
for (let i = 0; i < 5; i++) {
  console.log("Count:", i);
}
```

✅ **Explanation:**

- `let i = 0` → start
- `i < 5` → condition
- `i++` → increment after each loop
- Stops when condition becomes false.

---

### **2.2 `while` Loop**

Runs code **while** a condition is true.

```js
let i = 0;
while (i < 5) {
  console.log(i);
  i++;
}
```

✅ **Notes:**

- Checks the condition **before** running the loop.
- If condition is false at the start, it won’t run at all.

---

### **2.3 `do...while` Loop**

Similar to `while`, but **runs at least once**, even if condition is false.

```js
let i = 0;
do {
  console.log(i);
  i++;
} while (i < 5);
```

✅ **Notes:**

- Condition is checked **after** executing the code block.

---

### **2.4 `for...of` Loop**

Used to loop through **arrays or iterable objects**.

```js
let fruits = ["apple", "banana", "cherry"];

for (let fruit of fruits) {
  console.log(fruit);
}
```

✅ **Notes:**

- Loops through **values** in an array.

---

### **2.5 `for...in` Loop**

Used to loop through **object properties**.

```js
let person = { name: "Ismail", age: 30 };

for (let key in person) {
  console.log(key, person[key]);
}
```

✅ **Notes:**

- Loops through **keys (property names)** of an object.

---

## **3. Jump Statements**

Used to control the flow inside loops.

---

### **3.1 `break` Statement**

Stops the loop entirely.

```js
for (let i = 1; i <= 5; i++) {
  if (i === 3) break;
  console.log(i);
}
// Output: 1, 2
```

---

### **3.2 `continue` Statement**

Skips the current iteration and moves to the next.

```js
for (let i = 1; i <= 5; i++) {
  if (i === 3) continue;
  console.log(i);
}
// Output: 1, 2, 4, 5
```

---

## **4. Summary Table**

| Type             | Statement                    | Purpose               | Example                                |
| ---------------- | ---------------------------- | --------------------- | -------------------------------------- |
| **Condition**    | `if` / `else` / `switch`     | Make decisions        | Run different code based on conditions |
| **Loop**         | `for`, `while`, `do...while` | Repeat code           | Run code multiple times                |
| **Loop Control** | `break`, `continue`          | Manage loop execution | Stop or skip iteration                 |

---

## **5. Example: Combined Control Flow**

```js
let students = ["John", "Mary", "Ismail", "Tunde"];

for (let student of students) {
  if (student === "Ismail") {
    console.log("Admin found!");
    break;
  }
  console.log("Checking:", student);
}
```

---
