# 🧩 **Module 3: Promises and Async/Await**

---

## 🎯 **Module Objective**

By the end of thiss module, students should be able to:

- Understand what **Promises** are and how they solve callback issues.
- Learn how **Async/Await** improves readability in asynchronous code.
- Differentiate between **Promise states**.
- Write and chain Promises effectively.
- Handle errors properly in async code.

---

## 🔑 **Keywords and Definitions**

| **Keyword**        | **Definition**                                                                            |
| ------------------ | ----------------------------------------------------------------------------------------- |
| **Promise**        | An object representing the eventual completion (or failure) of an asynchronous operation. |
| **Pending**        | The initial state of a Promise before it has been fulfilled or rejected.                  |
| **Fulfilled**      | The state of a Promise when the operation is completed successfully.                      |
| **Rejected**       | The state of a Promise when the operation fails.                                          |
| **then()**         | A method used to handle the successful result of a Promise.                               |
| **catch()**        | A method used to handle errors or rejected Promises.                                      |
| **finally()**      | Executes code after the Promise settles (fulfilled or rejected).                          |
| **Async Function** | A function that always returns a Promise, allowing `await` inside it.                     |
| **Await**          | Pauses the execution of an async function until the Promise resolves or rejects.          |

---

## 🧠 **1. Understanding Promises**

### 📘 **Explanation:**

Promises were introduced in **ES6 (2015)** to make asynchronous code easier to manage and avoid **callback hell** (too many nested callbacks).

A **Promise** acts like a container for a future value — something that might not be available yet, but will be resolved later.

---

### ⚙️ **Example 1: Creating a Promise**

```js
const myPromise = new Promise((resolve, reject) => {
  let success = true;

  if (success) {
    resolve("Task completed successfully!");
  } else {
    reject("Something went wrong!");
  }
});

myPromise
  .then((message) => console.log(message))
  .catch((error) => console.error(error))
  .finally(() => console.log("Promise Settled"));
```

✅ **Output:**

```
Task completed successfully!
Promise Settled
```

🧠 **Explanation:**

- The `resolve()` function marks the Promise as **fulfilled**.
- The `reject()` function marks it as **rejected**.
- `.then()` handles success.
- `.catch()` handles failure.
- `.finally()` runs no matter what happens.

---

### ⚙️ **Example 2: Simulating Async Operation**

```js
function fetchData() {
  return new Promise((resolve, reject) => {
    console.log("Fetching data...");
    setTimeout(() => {
      const success = true;
      if (success) resolve("Data loaded successfully!");
      else reject("Failed to load data!");
    }, 2000);
  });
}

fetchData()
  .then((result) => console.log(result))
  .catch((error) => console.log(error))
  .finally(() => console.log("Operation completed"));
```

✅ **Output:**

```
Fetching data...
Data loaded successfully!
Operation completed
```

🧩 **Explanation:**
This mimics real-life operations like network requests — handled asynchronously using Promises.

---

## 🔁 **2. Chaining Promises**

### 📘 **Explanation:**

Promise chaining allows you to run **multiple asynchronous tasks** one after another.

### ⚙️ **Example 3: Promise Chaining**

```js
function stepOne() {
  return Promise.resolve("Step 1 completed");
}

function stepTwo() {
  return Promise.resolve("Step 2 completed");
}

function stepThree() {
  return Promise.resolve("Step 3 completed");
}

stepOne()
  .then((res) => {
    console.log(res);
    return stepTwo();
  })
  .then((res) => {
    console.log(res);
    return stepThree();
  })
  .then((res) => console.log(res))
  .catch((err) => console.log("Error:", err))
  .finally(() => console.log("All steps done!"));
```

✅ **Output:**

```
Step 1 completed
Step 2 completed
Step 3 completed
All steps done!
```

🧠 **Explanation:**
Each `.then()` returns a new Promise — making it easier to execute tasks **in sequence** without nesting callbacks.

---

## ⚡ **3. Introduction to Async / Await**

### 📘 **Explanation:**

`async` and `await` were introduced in **ES8 (2017)** to simplify working with Promises.
They make asynchronous code look and behave like **synchronous code**, improving readability.

---

### ⚙️ **Example 4: Async/Await Syntax**

```js
async function getData() {
  console.log("Start fetching...");

  let data = await new Promise((resolve) => {
    setTimeout(() => resolve("Data received!"), 2000);
  });

  console.log(data);
  console.log("Process complete!");
}

getData();
```

✅ **Output:**

```
Start fetching...
Data received!
Process complete!
```

🧩 **Explanation:**

- `await` pauses execution until the Promise resolves.
- The rest of the function runs **after** the async operation completes.
- It’s syntactic sugar over Promises — cleaner and more readable.

---

### ⚙️ **Example 5: Error Handling in Async/Await**

```js
async function fetchUser() {
  try {
    let response = await new Promise((resolve, reject) => {
      setTimeout(() => reject("Network Error!"), 1500);
    });
    console.log(response);
  } catch (error) {
    console.error("Error caught:", error);
  } finally {
    console.log("Operation finished.");
  }
}

fetchUser();
```

✅ **Output:**

```
Error caught: Network Error!
Operation finished.
```

🧠 **Explanation:**
Using `try...catch` with `await` makes handling asynchronous errors **cleaner** and **more predictable**.

---

## 🧪 **4. Hands-On Practicals**

### 💻 **Practical 1: Converting Callback to Promise**

**Task:** Rewrite the callback version below using a Promise.

**Original Code:**

```js
function downloadFile(callback) {
  console.log("Downloading file...");
  setTimeout(() => {
    callback("Download complete!");
  }, 2000);
}

downloadFile((message) => console.log(message));
```

✅ **Expected Output:**

```
Downloading file...
Download complete!
```

**Now use a Promise instead of a callback.**

---

### 💻 **Practical 2: Combine Async/Await with Try-Catch**

Write an async function that:

1. Logs `"Connecting to server..."`.
2. Waits 2 seconds.
3. Logs `"Connection successful!"`.
4. Uses a try-catch block to handle any errors.

✅ **Expected Output (success):**

```
Connecting to server...
Connection successful!
```

✅ **Expected Output (error):**

```
Connecting to server...
Error: Connection failed!
```

> 🧩 _Hint:_ Use `setTimeout` and Promises inside an `async` function.

---

## 🧮 **5. Classwork / Exercises**

### ✍️ **Exercise 1:**

Create a Promise that simulates:

1. Checking user credentials.
2. If credentials are correct, resolve with `"Login successful"`.
3. Otherwise, reject with `"Invalid credentials"`.
4. Handle both results using `.then()` and `.catch()`.

---

### ✍️ **Exercise 2:**

Rewrite the login program from Exercise 1 using **async/await** syntax.

---

### ✍️ **Exercise 3 (Bonus):**

Chain three Promises that represent:

1. Connecting to a database.
2. Fetching user data.
3. Displaying the result.
   Use `.then()` chaining and then refactor it with `async/await`.

---

## 📚 **6. Summary**

| **Concept**                      | **Meaning**                                       |
| -------------------------------- | ------------------------------------------------- |
| **Promise**                      | Represents a future value — successful or failed. |
| **then() / catch() / finally()** | Handle success, error, and completion.            |
| **Async / Await**                | Makes asynchronous code look synchronous.         |
| **try...catch**                  | Used with `await` to handle errors.               |
| **Chaining Promises**            | Running multiple async tasks in sequence.         |

---

## 🏁 **Module 3 Recap**

In this module, we learned:

- The purpose and structure of **Promises**.
- How to chain Promises for sequential tasks.
- How **Async/Await** improves readability.
- Proper error handling with `try...catch`.
- Practical applications converting callbacks to Promises.

---
