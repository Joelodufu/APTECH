const asyncHandler = require("express-async-handler"); // Imports asyncHandler
const jwt = require("jsonwebtoken"); // Imports JWT
const User = require("../models/userModel"); // Imports User model

const registerUser = asyncHandler(async (req, res) => {
  // Handles user registration
  const { name, email, password } = req.body; // Destructures request body
  if (!name || !email || !password) {
    // Validates input
    res.status(400); // Sets 400 status
    throw new Error("Please include all fields"); // Throws error
  }
  const userExists = await User.findOne({ email }); // Checks for existing user
  if (userExists) {
    // If user exists
    res.status(400); // Sets 400 status
    throw new Error("User already exists"); // Throws error
  }
  const user = await User.create({ name, email, password }); // Creates user
  if (user) {
    // If creation successful
    const token = generateToken(user._id); // Generates token
    res.status(201).json({ _id: user._id, name, email, token }); // Sends response
  } else {
    // If creation failed
    res.status(400); // Sets 400 status
    throw new Error("Invalid user data"); // Throws error
  }
});

const loginUser = asyncHandler(async (req, res) => {
  // Handles user login
  const { email, password } = req.body; // Destructures request body
  const user = await User.findOne({ email }); // Finds user by email
  if (user && (await user.matchPassword(password))) {
    // Validates credentials
    const token = generateToken(user._id); // Generates token
    res.json({ _id: user._id, name: user.name, email, token }); // Sends response
  } else {
    // If invalid
    res.status(401); // Sets 401 status
    throw new Error("Invalid email or password"); // Throws error
  }
});

const getMe = asyncHandler(async (req, res) => {
  // Gets current user
  res.status(200).json(req.user); // Sends user data
});

const generateToken = (id) => {
  // Generates JWT
  return jwt.sign({ id }, process.env.JWT_SECRET, {
    // Signs token
    expiresIn: "30d", // Sets expiration
  });
};

module.exports = { registerUser, loginUser, getMe }; // Exports functions
