# **Class Note: Introduction to Express.js**

## **Course Title:** Node.js with Express

## **Module:** Introduction to Express.js

## **Duration:** 1–2 Hours

## **Prerequisite:** Basic understanding of Node.js and JavaScript

---

## **1. What is Express.js?**

**Express.js** is a **minimal and flexible web framework** for **Node.js** used to build **web applications and APIs**.
It simplifies the process of handling routes, requests, and responses in a Node.js server.

### **Why Express?**

Without Express, we use Node’s built-in `http` module, which can be **verbose and repetitive**.
Express provides:

- Easy routing
- Middleware support
- Cleaner and faster development
- Scalability and modularity

---

## **2. Installing Express.js**

Before installing, ensure Node.js and npm are installed.

### **Steps:**

1. **Create a project folder**

   ```bash
   mkdir express-intro
   cd express-intro
   ```

2. **Initialize npm**

   ```bash
   npm init -y
   ```

3. **Install Express**

   ```bash
   npm install express
   ```

---

## **3. Setting Up a Basic Express Server**

### **Code Example:**

```javascript
// Import Express
const express = require("express");

// Create an Express app
const app = express();

// Define a route
app.get("/", (req, res) => {
  res.send("Welcome to Express.js!");
});

// Start the server
const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
```

### **Explanation:**

| Line  | Description                                    |
| ----- | ---------------------------------------------- |
| 1     | Imports the Express module                     |
| 3     | Creates an instance of the Express application |
| 6     | Defines a GET route for the root URL `/`       |
| 7     | Sends a response “Welcome to Express.js!”      |
| 10–12 | Starts the server on port 3000                 |

---

## **4. Understanding Express Concepts**

### **a. Routes**

A **route** defines how an application responds to a client request to a particular endpoint (URL + HTTP method).

**Example:**

```javascript
app.get("/about", (req, res) => {
  res.send("This is the About page");
});

app.post("/login", (req, res) => {
  res.send("Login route");
});
```

---

### **b. Middleware**

Middleware functions are functions that have access to the **request** and **response** objects.
They can modify, process, or terminate requests before sending responses.

**Example:**

```javascript
app.use((req, res, next) => {
  console.log(`${req.method} request made to ${req.url}`);
  next(); // move to the next middleware or route
});
```

---

### **c. Request and Response Objects**

- `req` → represents the **incoming request** (contains query params, headers, body, etc.)
- `res` → represents the **outgoing response** (used to send data to the client)

**Example:**

```javascript
app.get("/user", (req, res) => {
  res.json({ name: "John Doe", age: 25 });
});
```

---

## **5. Serving Static Files**

Express makes it easy to serve static files (HTML, CSS, images, etc.) from a folder.

**Example:**

```javascript
app.use(express.static("public"));
```

If you have a file `public/index.html`, you can access it by visiting:

```
http://localhost:3000/index.html
```

---

## **6. Using Nodemon for Auto-Reload**

Nodemon automatically restarts the server whenever you make changes.

**Install Nodemon globally:**

```bash
npm install -g nodemon
```

**Run the server:**

```bash
nodemon index.js
```

---

## **7. Hands-on Practical**

### **Task:**

1. Create a new project folder `myexpressapp`.
2. Create three routes:

   - `/` → returns “Home Page”
   - `/contact` → returns “Contact Us”
   - `/services` → returns “Our Services”

3. Use middleware to log every request.
4. Run your app with Nodemon.

---

## **8. Common Express Methods**

| Method         | Description          | Example                   |
| -------------- | -------------------- | ------------------------- |
| `app.get()`    | Handle GET requests  | `app.get('/home', …)`     |
| `app.post()`   | Handle POST requests | `app.post('/login', …)`   |
| `app.put()`    | Update data          | `app.put('/update', …)`   |
| `app.delete()` | Delete data          | `app.delete('/user', …)`  |
| `app.use()`    | Mount middleware     | `app.use(express.json())` |

---

## **9. Why Express is Popular**

✅ Simple and easy to learn
✅ Large ecosystem of middleware
✅ Works seamlessly with databases
✅ Great for RESTful APIs
✅ Widely used in production apps

---

## **10. Classwork**

👉 **Create a small Express API** that:

- Has 3 endpoints: `/`, `/about`, and `/students`
- Returns JSON data for `/students`
- Logs each request using middleware

---

## **11. Summary**

| Concept       | Description                                  |
| ------------- | -------------------------------------------- |
| Express.js    | Web framework for Node.js                    |
| Middleware    | Function that runs before the route handler  |
| Route         | Defines how an app responds to a URL request |
| `req` & `res` | Handle incoming and outgoing data            |
| Nodemon       | Tool for auto-restarting the server          |

---

## **12. Assignment**

- Research and write short notes on:

  1. Express Router
  2. Error Handling in Express
  3. RESTful API Design Principles

---
