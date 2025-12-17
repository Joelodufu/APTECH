### **Session 4: Built-in Modules in Node.js**

---

### **Objectives**:

By the end of this session, students should be able to:

1. Describe built-in modules in Node.js.
2. Understand how to use the **http** module to create an HTTP server.
3. Parse and work with URLs using the **url** module.
4. Handle asynchronous events using the **events** module.

---

### **Definition of Key Concepts**

#### **1. Built-in Modules in Node.js**

**Definition**:
Built-in modules in Node.js are core modules that come bundled with the Node.js installation. These modules provide essential functionality like HTTP handling, file system operations, and utilities to work with various data types.

* **Why are built-in modules important?**

  * They save time by providing pre-built solutions for common tasks.
  * They reduce the need to install external packages for basic functionality.

---

#### **2. The `http` Module: Creating an HTTP Server**

**Definition**:
The **`http`** module in Node.js allows you to create web servers and handle HTTP requests. It provides methods to send HTTP responses and process client requests.

##### **Micro Example**:

Here’s a simple example of creating an HTTP server that responds with "Hello, World!" when accessed:

```js
const http = require('http');

// Create a simple HTTP server
const server = http.createServer((req, res) => {
  res.statusCode = 200;  // HTTP status code for success
  res.setHeader('Content-Type', 'text/plain');  // Set the content type
  res.end('Hello, World!\n');  // Response body
});

// Server listens on port 3000
server.listen(3000, 'localhost', () => {
  console.log('Server running at http://localhost:3000/');
});
```

##### **Macro Example**:

**Real-Life Use Case**:
In a real-world scenario, the **`http`** module can be used to create REST APIs, where the server listens for GET, POST, PUT, and DELETE requests to handle different operations (e.g., data fetching, updating user profiles).

---

#### **3. The `url` Module: Parsing and Working with URLs**

**Definition**:
The **`url`** module in Node.js helps you parse URLs and extract different components such as the protocol, hostname, path, query parameters, etc.

##### **Micro Example**:

```js
const url = require('url');

const myUrl = 'http://example.com:8080/pathname/?query=test#hash';
const parsedUrl = url.parse(myUrl, true);

console.log(parsedUrl.host);  // Output: example.com:8080
console.log(parsedUrl.pathname);  // Output: /pathname/
console.log(parsedUrl.query);  // Output: { query: 'test' }
```

##### **Macro Example**:

**Real-Life Use Case**:
In web applications, the **`url`** module can be used to parse incoming request URLs, handle routing, and extract query parameters for use in API requests. For example, a URL like `http://example.com/search?query=nodejs` can be parsed to extract the query string (`nodejs`) for search functionality.

---

#### **4. The `events` Module: Handling Asynchronous Events**

**Definition**:
The **`events`** module in Node.js provides an event-driven architecture. It allows for the creation of **EventEmitter** objects that can handle asynchronous events, like user actions or system-generated events.

##### **Micro Example**:

```js
const EventEmitter = require('events');
const eventEmitter = new EventEmitter();

// Create an event listener
eventEmitter.on('greet', () => {
  console.log('Hello, Node.js!');
});

// Trigger the event
eventEmitter.emit('greet');  // Output: Hello, Node.js!
```

##### **Macro Example**:

**Real-Life Use Case**:
The **`events`** module is commonly used in applications like real-time chat systems, where events such as message sending or receiving are emitted and handled asynchronously. It allows the application to respond to these events without blocking other operations.

---

### **Real-Life Use Cases of Built-in Modules in Node.js**

1. **Web Applications**:
   Using the **`http`** and **`url`** modules, you can create APIs and handle incoming HTTP requests. For example, building a REST API that allows users to register, log in, or fetch their profiles.

2. **File Handling**:
   The **`fs`** module (not covered in this session but often used alongside the `http` module) helps read, write, and manage files. For example, storing user data in JSON files or uploading and downloading content.

3. **Real-Time Communication**:
   The **`events`** module can be used to handle real-time communication in applications, such as broadcasting notifications in chat apps or updating client data in real-time.

---

### **Common Interview Questions**

1. **What is the `http` module used for in Node.js?**

   * Answer: The `http` module is used to create HTTP servers and handle HTTP requests and responses.

2. **What is the difference between synchronous and asynchronous event handling in Node.js?**

   * Answer: Synchronous event handling blocks code execution until the event is processed, while asynchronous handling allows other code to run concurrently, improving performance.

3. **How does the `events` module help in managing asynchronous behavior in Node.js?**

   * Answer: The `events` module helps manage asynchronous events by providing an event-driven architecture, where events can be emitted and listeners handle them without blocking other operations.

4. **Explain the purpose of the `url` module in Node.js.**

   * Answer: The `url` module is used to parse and manipulate URLs, making it easier to work with request URLs, extract query parameters, and handle routing.

---

### **Class Work/Activity**

1. **Create a Web Server**:

   * Have students create a web server using the **`http`** module that listens on port 3000 and responds with "Welcome to Node.js!" when accessed.

2. **Parse a URL**:

   * Have students write a program that parses a given URL and extracts its components, such as the host, pathname, and query parameters.

3. **Event Handling**:

   * Students should create an event emitter that listens for a custom event (e.g., "orderPlaced") and logs a message whenever the event is emitted.

---

### **Test**

**Multiple Choice Questions (MCQs)**

1. **Which of the following modules is used to create an HTTP server in Node.js?**

   * a) `http`
   * b) `url`
   * c) `fs`
   * d) `events`

2. **What does the `url` module's `parse()` method do?**

   * a) Combines URLs into a single string
   * b) Breaks down a URL into its components
   * c) Sends a request to a URL
   * d) None of the above

3. **Which method from the `events` module is used to trigger an event?**

   * a) `emit()`
   * b) `on()`
   * c) `create()`
   * d) `trigger()`

4. **What is the primary use of the `http` module?**

   * a) Reading files
   * b) Parsing URLs
   * c) Creating web servers
   * d) Handling database connections

**Practical Test**:

* Write a Node.js script that creates a server, parses the URL, and emits a custom event when a request is received.

---

### **Conclusion**

In this session, we covered the core built-in modules in Node.js: **http**, **url**, and **events**. These modules are fundamental for building web servers, parsing URLs, and handling asynchronous events in real-time applications. The next session will delve into more advanced built-in modules, including file handling and the concept of local modules.

---
