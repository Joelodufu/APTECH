# Class Note: Session 1 - Introduction to Server-side Development

**Module**: Server-side Development with Node.js  
**Session**: NODEJS - TL1  
**Date**: [Insert Date]  
**Duration**: 2 Hours  

## Learning Objectives
By the end of this session, you will be able to:
- Outline the client-server architecture.
- Explain the significance of server-side programming.
- Describe a web server and its architecture.
- Understand Node.js, its features, and its installation process.

## 1. Client-Server Architecture
- **Definition**: A model where a **client** (e.g., a web browser) sends requests to a **server**, which processes them and returns responses.
- **Components**:
  - **Client**: Sends requests (e.g., your browser requesting a webpage).
  - **Server**: Processes requests and sends responses (e.g., a computer hosting a website).
  - **Network**: Connects client and server (e.g., the internet).
- **How It Works**:
  - Client sends a request (e.g., clicking a link).
  - Server processes it (e.g., fetches data from a database).
  - Server responds (e.g., sends HTML to display the webpage).
- **Example**: When you visit `www.google.com`, your browser (client) requests the search page, and Google’s server sends the page content.

## 2. Significance of Server-side Programming
- **What Is It?**: Writing code that runs on the server to handle requests, process data, and generate responses.
- **Why It Matters**:
  - **Dynamic Content**: Generates webpages based on user input or database data (e.g., showing your profile on a social media site).
  - **Security**: Handles sensitive operations (e.g., user authentication) on the server, away from the client.
  - **Scalability**: Servers can handle multiple client requests efficiently.
- **Examples**:
  - Processing form submissions (e.g., signing up for a website).
  - Fetching data from a database (e.g., displaying product listings).

## 3. Web Server and Its Architecture
- **What Is a Web Server?**: Software or hardware that receives, processes, and responds to client requests (usually HTTP/HTTPS).
- **Key Functions**:
  - Accepts HTTP requests.
  - Processes logic (e.g., runs scripts, queries databases).
  - Sends responses (e.g., HTML, JSON).
- **Architecture**:
  - **Request Handler**: Receives incoming requests.
  - **Application Logic**: Processes requests using server-side code.
  - **Storage Layer**: Interacts with databases or files.
  - **Response Generator**: Sends data back to the client.
- **Example**: Apache, Nginx, or a Node.js server handling requests for a website.

## 4. Introduction to Node.js
- **What Is Node.js?**:
  - A runtime environment that allows JavaScript to run on the server (outside the browser).
  - Built on Chrome’s V8 JavaScript engine.
- **Key Features**:
  - **Asynchronous and Non-blocking**: Handles multiple requests efficiently using an event-driven model.
  - **Single-threaded**: Uses a single thread with an event loop for concurrency.
  - **Cross-platform**: Runs on Windows, macOS, Linux.
  - **NPM (Node Package Manager)**: Access to thousands of libraries for added functionality.
  - **Lightweight and Fast**: Optimized for high-performance applications.
- **Use Cases**:
  - Building RESTful APIs (e.g., for mobile apps).
  - Real-time applications (e.g., chat apps).
  - Server-side web applications (e.g., e-commerce platforms).
- **Installation Process**:
  1. Visit `nodejs.org` and download the LTS (Long Term Support) version.
  2. Run the installer for your operating system (Windows, macOS, Linux).
  3. Verify installation:
     - Open a terminal and type `node -v` (checks Node.js version).
     - Type `npm -v` (checks NPM version).
  4. Optional: Use NVM (Node Version Manager) to manage multiple Node.js versions.
- **Example**: Create a simple Node.js script:
  ```javascript
  console.log("Hello, Node.js!");
  ```
  Save as `hello.js` and run with `node hello.js` in the terminal.

## Key Takeaways
- Client-server architecture enables communication between users and servers.
- Server-side programming powers dynamic, secure, and scalable web applications.
- Web servers process HTTP requests and deliver responses.
- Node.js is a powerful tool for server-side development, with features like asynchronous processing and a vast ecosystem via NPM.

## References
- *Server-side Development with NodeJS* book: Session 1 (SG, XP, TG).
- OnlineVarsity: Download the e-book, check the glossary, and try “Practice 4 Me” questions.
- Recommended: *Node.js Web Development* by David Herron (Chapter 1).

## Next Steps
- Complete the **Try It Yourself** questions from Session 1 (covered in Session 6).
- Explore the Node.js installation on your system and run a simple script.
- Review the client-server model with real-world examples (e.g., visiting a website).

**Note**: Submit any queries via OnlineVarsity’s “Ask to Learn” feature!