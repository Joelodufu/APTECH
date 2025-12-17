# 🧩 **Server-Side Development with Node.js**

## **Session 3: Modules and Packages in Node.js**

---

### 🎯 **Session Objectives**

By the end of this class, learners should be able to:

1. Define what **modules** are in Node.js.
2. List and explain the **three types of modules** in Node.js.
3. Explain the significance of **packages** in Node.js development.
4. Describe the purpose of **web frameworks** and **utility functions** in Node.js.
5. Apply basic module import/export syntax in a simple Node.js program.

---

## 🧠 **1. Introduction / Mini Literature**

In modern software development, large applications are rarely written in a single file. Instead, they are **divided into small, reusable blocks of code** called **modules**.
This approach allows developers to work independently, debug easily, and maintain cleaner projects.

Node.js is built on this modular concept. In fact, almost everything in Node.js is a module — the **HTTP server**, **File system**, **Events**, and even the **console** you use.

The idea is simple:

> “Write once, use anywhere.”

You create small, reusable components and connect them together to build powerful applications.

---

## ⚙️ **2. What Are Modules in Node.js?**

A **module** is a reusable block of code that performs a specific function and can be imported into other files.

In Node.js, each file is treated as a separate module.
Modules can export variables, functions, or objects for others to use.

### 🔹 **Micro Example: Basic Module**

**greet.js**

```js
exports.sayHello = function (name) {
  return `Hello, ${name}!`;
};
```

**app.js**

```js
const greet = require("./greet");
console.log(greet.sayHello("Joel"));
```

**Output:**

```
Hello, Joel!
```

---

## 🔰 **3. Types of Modules in Node.js**

Node.js has **three main types of modules**:

---

### **A. Core (Built-in) Modules**

These are modules that come **pre-installed** with Node.js.
You don’t need to install them manually — just require and use.

| Module   | Description                      | Example           |
| -------- | -------------------------------- | ----------------- |
| `fs`     | File System – works with files   | read, write files |
| `http`   | Creates web servers              | serve web pages   |
| `path`   | Handles file paths               | join, normalize   |
| `os`     | Interacts with operating system  | get CPU info      |
| `events` | Handles event-driven programming | event listeners   |

**Example:**

```js
const os = require("os");
console.log("System Platform:", os.platform());
```

**Output:**

```
System Platform: win32
```

---

### **B. Local Modules**

These are **custom modules** you create yourself.
They help you organize your own code.

**Example:**
**math.js**

```js
exports.add = (a, b) => a + b;
exports.subtract = (a, b) => a - b;
```

**app.js**

```js
const math = require("./math");
console.log(math.add(3, 2)); // 5
console.log(math.subtract(7, 2)); // 5
```

---

### **C. Third-Party Modules (Packages)**

These are modules created by other developers and published on the **npm** registry.
You can install and use them in your projects.

**Example:**

```bash
npm install express
```

Then use it:

```js
const express = require("express");
const app = express();

app.get("/", (req, res) => res.send("Hello from Express!"));
app.listen(3000);
```

**Output:**

```
Server running at http://localhost:3000
```

---

## 📦 **4. What Are Packages in Node.js?**

A **package** is a collection of related modules bundled together for reuse.
When you install something from npm (like `express`, `mongoose`, or `nodemailer`), you are installing a package.

Each Node.js project has a **package.json** file that keeps track of all dependencies (packages you’ve installed).

**Example:**

```bash
npm init -y
```

Creates a `package.json` like this:

```json
{
  "name": "myapp",
  "version": "1.0.0",
  "dependencies": {
    "express": "^4.18.2"
  }
}
```

**Key Benefits of Packages:**

- Reuse existing solutions
- Save time
- Manage versions and dependencies
- Encourage modularity and teamwork

---

## 🌐 **5. Web Frameworks and Utility Functions**

### **A. Web Frameworks**

A **web framework** provides ready-made tools for creating web servers easily.

- Handles routing (decides what happens when users visit a URL)
- Manages requests and responses
- Simplifies connection with databases

**Example using Express:**

```js
const express = require("express");
const app = express();

app.get("/", (req, res) => res.send("Welcome to Node.js Framework!"));
app.listen(4000, () => console.log("Server running on port 4000"));
```

---

### **B. Utility Functions**

Utility functions are **built-in tools** that simplify common programming tasks.
They can come from Node.js modules like `path`, `util`, or `os`.

**Example:**

```js
const path = require("path");
const filePath = path.join("folder", "subfolder", "file.txt");
console.log(filePath);
```

**Output:**

```
folder/subfolder/file.txt
```

---

## 🧑‍💻 **Class Work**

1. Create a local module named **greet.js** that exports a function `sayHi(name)` returning a greeting message.
2. Import it into **app.js** and call it for three different names.
3. Use the **os** module to print your system’s architecture and hostname.
4. Install and use the **chalk** npm package to print colored text on the console.

---

## 💪 **Challenging Questions**

1. Explain the difference between **modules** and **packages** in Node.js.
2. Why is modular programming considered important in server-side development?
3. Mention and explain **three** built-in modules in Node.js with examples.
4. What problem does a **web framework** like Express.js solve for developers?
5. Suppose you are creating a Node.js project that sends emails. Which module(s) or package(s) will you use and why?

---

## 🧾 **Mini Test (Session Quiz)**

**Instruction:** Answer all questions briefly.

1. Define a module in Node.js.
2. State and explain the **three types of modules**.
3. What command is used to install packages from npm?
4. Create a local module that calculates the area of a rectangle.
5. Write a one-line code that uses the **path** module to get the file extension of `index.html`.
6. What file stores project dependencies in a Node.js application?
7. Name one web framework built on Node.js.

---

## 🏁 **Summary**

| Concept               | Key Point                                          |
| --------------------- | -------------------------------------------------- |
| **Modules**           | Reusable pieces of code in Node.js                 |
| **Types**             | Core (built-in), Local (custom), Third-party (npm) |
| **Packages**          | Bundles of related modules                         |
| **Web Framework**     | Simplifies creating web servers (e.g., Express)    |
| **Utility Functions** | Built-in tools for common programming tasks        |

---

## 💬 **Key Takeaway**

> “Node.js modules and packages promote reusability, scalability, and collaboration — the building blocks of efficient server-side development.”

---
