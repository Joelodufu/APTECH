const express = require("express"); // Imports Express framework
const dotenv = require("dotenv").config(); // Loads environment variables from .env file
const connectDB = require("./config/db"); // Imports database connection function
const bcrypt = require("bcryptjs");

const hashPassword = async (password) => {
  try {
    const salt = await bcrypt.genSalt(10);
    const hashedPassword = await bcrypt.hash(password, salt);
    return hashedPassword;
  } catch (error) {
    console.error("Error hashing password:", error);
    throw error;
  }
};

let hashedPassword = await hashPassword("aptehr123");

console.log("Hashed password:", hashedPassword);

// Connect to database
connectDB(); // Initiates MongoDB connection

const app = express(); // Creates an Express application instance

// Middleware
app.use(express.json()); // Parses incoming JSON requests
app.use(express.urlencoded({ extended: false })); // Parses URL-encoded data

// Routes
app.use("/api/users", require("./routes/userRoutes")); // Mounts user routes at /api/users

const PORT = process.env.PORT || 5000; // Sets port from .env or defaults to 5000
app.listen(PORT, () => console.log(`Server running on port ${PORT}`)); // Starts server and logs port
