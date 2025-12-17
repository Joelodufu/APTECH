# **Class Note: Building a Simple Express.js Server with Controllers, Routes, and Error Handling**

## **🎯 Objective**

By the end of this lesson, students will:

- Understand the structure of an Express.js application using **MVC pattern (Model-View-Controller)**.
- Be able to separate **routes**, **controllers**, and **server logic**.
- Implement **error handling middleware** in Express.

---

## **🧠 Concepts Recap**

### **1. Express.js Overview**

- **Express.js** is a lightweight and flexible Node.js web framework used to build APIs and web applications quickly.
- It helps you handle **HTTP requests**, define **routes**, and manage **middleware**.

---

## **🧩 Project Structure**

We'll structure our project cleanly:

```
express-app/
│
├── controllers/
│   └── userController.js
│
├── routes/
│   └── userRoutes.js
│
├── middlewares/
│   └── errorHandler.js
│
├── server.js
│
└── package.json
```

---

## **🚀 Step 1: Initialize Project and Install Dependencies**

Run these commands in your terminal:

```bash
mkdir express-app
cd express-app
npm init -y
npm install express
```

---

## **🧱 Step 2: Create the Server Entry File (`server.js`)**

This file starts the server and connects routes.

```js
// server.js
const express = require("express");
const userRoutes = require("./routes/userRoutes");
const errorHandler = require("./middlewares/errorHandler");

const app = express();

// Middleware to parse JSON data
app.use(express.json());

// Route Middleware
app.use("/api/users", userRoutes);

// Home route
app.get("/", (req, res) => {
  res.send("Welcome to the Express.js API!");
});

// Error Handling Middleware (always last)
app.use(errorHandler);

// Start server
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
```

---

## **👨‍💻 Step 3: Create the Controller (`controllers/userController.js`)**

Controllers handle **business logic** — what happens when a route is called.

```js
// controllers/userController.js

// Simulated in-memory user data
let users = [
  { id: 1, name: "Joel" },
  { id: 2, name: "Grace" },
];

// GET /api/users
const getUsers = (req, res) => {
  res.status(200).json(users);
};

// POST /api/users
const createUser = (req, res, next) => {
  try {
    const { name } = req.body;

    if (!name) {
      // Throw custom error if name is missing
      const error = new Error("Name field is required");
      error.status = 400;
      throw error;
    }

    const newUser = { id: users.length + 1, name };
    users.push(newUser);
    res.status(201).json(newUser);
  } catch (error) {
    next(error); // Pass to error handler middleware
  }
};

module.exports = { getUsers, createUser };
```

---

## **🧭 Step 4: Create the Routes (`routes/userRoutes.js`)**

Routes define **API endpoints** and connect them to **controllers**.

```js
// routes/userRoutes.js
const express = require("express");
const router = express.Router();
const { getUsers, createUser } = require("../controllers/userController");

// Define routes
router.get("/", getUsers);
router.post("/", createUser);

module.exports = router;
```

---

## **⚙️ Step 5: Create Error Handling Middleware (`middlewares/errorHandler.js`)**

Middleware that catches and formats all errors in one place.

```js
// middlewares/errorHandler.js
const errorHandler = (err, req, res, next) => {
  console.error("Error:", err.message);
  res.status(err.status || 500).json({
    success: false,
    message: err.message || "Server Error",
  });
};

module.exports = errorHandler;
```

---

## **🧪 Step 6: Test the API**

Use **Postman**, **Insomnia**, or **curl** to test the routes.

### ✅ GET Request:

**URL:** `http://localhost:5000/api/users`
**Response:**

```json
[
  { "id": 1, "name": "Joel" },
  { "id": 2, "name": "Grace" }
]
```

### ✅ POST Request:

**URL:** `http://localhost:5000/api/users`
**Body:**

```json
{ "name": "Faith" }
```

**Response:**

```json
{ "id": 3, "name": "Faith" }
```

### ❌ Invalid POST (No name field)

**Response:**

```json
{
  "success": false,
  "message": "Name field is required"
}
```

---

## **📘 Classwork / Practice Exercise**

**Task:**
Build a small **product API** using the same pattern.
Structure:

- Controller: `productController.js`
- Routes: `productRoutes.js`
- Fields: `id`, `name`, `price`

Implement:

- `GET /api/products` → Get all products
- `POST /api/products` → Add a new product
- Include **error handling** for missing fields

---

## **💡 Key Takeaways**

| Concept                       | Description                                                                                      |
| ----------------------------- | ------------------------------------------------------------------------------------------------ |
| **Controller**                | Contains business logic for handling requests.                                                   |
| **Routes**                    | Maps URL paths to controller functions.                                                          |
| **Middleware**                | Functions that process requests before they reach the controller or after (like error handling). |
| **Error Handling Middleware** | Centralized way to catch and respond to errors.                                                  |
| **Separation of Concerns**    | Keeps code organized and maintainable.                                                           |

---
