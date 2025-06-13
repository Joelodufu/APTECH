# Node.js Express Authentication with MongoDB: Class Note

This guide provides a step-by-step approach to building a secure authentication system using Node.js, Express, MongoDB (Mongoose), and best practices. We'll use environment variables with `.env`, organize code into controllers and routes, and wrap controller functions with an async handler to manage errors effectively.

---

## Learning Objectives
- Understand user authentication (register, login, protected routes).
- Set up a Node.js Express server with MongoDB and Mongoose.
- Implement secure password hashing with `bcrypt`.
- Generate and verify JSON Web Tokens (JWT) for authentication.
- Use environment variables with `.env` for configuration.
- Organize code with separate controllers and routes.
- Handle asynchronous errors using `express-async-handler`.

---

## Prerequisites
- Basic knowledge of JavaScript, Node.js, and Express.
- MongoDB installed locally or a MongoDB Atlas account.
- Node.js and npm installed.
- Code editor (e.g., VS Code).

---

## Step 1: Project Setup
1. **Initialize a Node.js Project**:
   - Create a project folder (e.g., `auth-app`) and initialize:
     ```bash
     mkdir auth-app
     cd auth-app
     npm init -y
     ```
2. **Install Dependencies**:
   - Install required packages:
     ```bash
     npm install express mongoose bcryptjs jsonwebtoken dotenv express-async-handler
     npm install --save-dev nodemon
     ```
3. **Set Up Project Structure**:
   - Create the following folder structure:
     ```
     auth-app/
     ├── controllers/
     │   └── userController.js
     ├── routes/
     │   └── userRoutes.js
     ├── models/
     │   └── userModel.js
     ├── middleware/
     │   └── authMiddleware.js
     ├── config/
     │   └── db.js
     ├── .env
     ├── server.js
     └── package.json
     ```
4. **Configure `package.json`**:
   - Add a start script to `package.json`:
     ```json
     "scripts": {
       "start": "node server.js",
       "dev": "nodemon server.js"
     }
     ```

---

## Step 2: Environment Variables Setup
1. **Create `.env` File**:
   - In the root folder, create a `.env` file with the following:
     ```
     PORT=5000
     MONGO_URI=mongodb://localhost:27017/authdb
     JWT_SECRET=your_jwt_secret_key
     ```
   - Replace `MONGO_URI` with your MongoDB connection string (local or Atlas).
   - Use a strong, random `JWT_SECRET` (e.g., generated via `crypto.randomBytes(64).toString('hex')`).
2. **Load Environment Variables**:
   - In `server.js`, load the `.env` variables using `dotenv`:
     ```javascript
     require('dotenv').config();
     ```

---

## Step 3: Connect to MongoDB
1. **Create Database Connection**:
   - In `config/db.js`, set up MongoDB connection with Mongoose:
     ```javascript
     const mongoose = require('mongoose');

     const connectDB = async () => {
       try {
         const conn = await mongoose.connect(process.env.MONGO_URI, {
           useNewUrlParser: true,
           useUnifiedTopology: true,
         });
         console.log(`MongoDB Connected: ${conn.connection.host}`);
       } catch (error) {
         console.error(`Error: ${error.message}`);
         process.exit(1);
       }
     };

     module.exports = connectDB;
     ```

---

## Step 4: Create User Model
1. **Define User Schema**:
   - In `models/userModel.js`, create a Mongoose schema for users:
     ```javascript
     const mongoose = require('mongoose');
     const bcrypt = require('bcryptjs');

     const userSchema = mongoose.Schema(
       {
         name: {
           type: String,
           required: [true, 'Please add a name'],
         },
         email: {
           type: String,
           required: [true, 'Please add an email'],
           unique: true,
           match: [/.+\@.+\..+/, 'Please add a valid email'],
         },
         password: {
           type: String,
           required: [true, 'Please add a password'],
           minlength: 6,
         },
       },
       { timestamps: true }
     );

     // Hash password before saving
     userSchema.pre('save', async function (next) {
       if (!this.isModified('password')) {
         next();
       }
       const salt = await bcrypt.genSalt(10);
       this.password = await bcrypt.hash(this.password, salt);
     });

     // Method to compare password
     userSchema.methods.matchPassword = async function (enteredPassword) {
       return await bcrypt.compare(enteredPassword, this.password);
     };

     module.exports = mongoose.model('User', userSchema);
     ```

---

## Step 5: Create Controllers
1. **Set Up Async Handler**:
   - Controllers will use `express-async-handler` to handle async errors without try-catch blocks.
2. **Create User Controller**:
   - In `controllers/userController.js`, define authentication logic:
     ```javascript
     const asyncHandler = require('express-async-handler');
     const bcrypt = require('bcryptjs');
     const jwt = require('jsonwebtoken');
     const User = require('../models/userModel');

     // @desc    Register a new user
     // @route   POST /api/users/register
     // @access  Public
     const registerUser = asyncHandler(async (req, res) => {
       const { name, email, password } = req.body;

       if (!name || !email || !password) {
         res.status(400);
         throw new Error('Please include all fields');
       }

       // Check if user exists
       const userExists = await User.findOne({ email });
       if (userExists) {
         res.status(400);
         throw new Error('User already exists');
       }

       // Create user
       const user = await User.create({ name, email, password });

       if (user) {
         res.status(201).json({
           _id: user._id,
           name: user.name,
           email: user.email,
           token: generateToken(user._id),
         });
       } else {
         res.status(400);
         throw new Error('Invalid user data');
       }
     });

     // @desc    Login a user
     // @route   POST /api/users/login
     // @access  Public
     const loginUser = asyncHandler(async (req, res) => {
       const { email, password } = req.body;

       const user = await User.findOne({ email });

       if (user && (await user.matchPassword(password))) {
         res.json({
           _id: user._id,
           name: user.name,
           email: user.email,
           token: generateToken(user._id),
         });
       } else {
         res.status(401);
         throw new Error('Invalid email or password');
       }
     });

     // @desc    Get current user
     // @route   GET /api/users/me
     // @access  Private
     const getMe = asyncHandler(async (req, res) => {
       res.status(200).json(req.user);
     });

     // Generate JWT
     const generateToken = (id) => {
       return jwt.sign({ id }, process.env.JWT_SECRET, {
         expiresIn: '30d',
       });
     };

     module.exports = {
       registerUser,
       loginUser,
       getMe,
     };
     ```

---

## Step 6: Create Authentication Middleware
1. **Protect Routes with JWT**:
   - In `middleware/authMiddleware.js`, create middleware to verify JWT:
     ```javascript
     const jwt = require('jsonwebtoken');
     const asyncHandler = require('express-async-handler');
     const User = require('../models/userModel');

     const protect = asyncHandler(async (req, res, next) => {
       let token;

       if (
         req.headers.authorization &&
         req.headers.authorization.startsWith('Bearer')
       ) {
         try {
           // Get token from header
           token = req.headers.authorization.split(' ')[1];

           // Verify token
           const decoded = jwt.verify(token, process.env.JWT_SECRET);

           // Get user from token
           req.user = await User.findById(decoded.id).select('-password');

           if (!req.user) {
             res.status(401);
             throw new Error('Not authorized, user not found');
           }

           next();
         } catch (error) {
           res.status(401);
           throw new Error('Not authorized, token failed');
         }
       } else {
         res.status(401);
         throw new Error('Not authorized, no token');
       }
     });

     module.exports = { protect };
     ```

---

## Step 7: Create Routes
1. **Define User Routes**:
   - In `routes/userRoutes.js`, set up routes and link to controllers:
     ```javascript
     const express = require('express');
     const router = express.Router();
     const { registerUser, loginUser, getMe } = require('../controllers/userController');
     const { protect } = require('../middleware/authMiddleware');

     router.post('/register', registerUser);
     router.post('/login', loginUser);
     router.get('/me', protect, getMe);

     module.exports = router;
     ```

---

## Step 8: Set Up Express Server
1. **Create Main Server File**:
   - In `server.js`, set up the Express server:
     ```javascript
     const express = require('express');
     const dotenv = require('dotenv').config();
     const connectDB = require('./config/db');

     // Connect to database
     connectDB();

     const app = express();

     // Middleware
     app.use(express.json());
     app.use(express.urlencoded({ extended: false }));

     // Routes
     app.use('/api/users', require('./routes/userRoutes'));

     const PORT = process.env.PORT || 5000;
     app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
     ```

---

## Step 9: Test the Application
1. **Start the Server**:
   - Run the server with:
     ```bash
     npm run dev
     ```
2. **Test Endpoints with Postman**:
   - **Register**: `POST http://localhost:5000/api/users/register`
     - Body: `{ "name": "John Doe", "email": "john@example.com", "password": "password123" }`
   - **Login**: `POST http://localhost:5000/api/users/login`
     - Body: `{ "email": "john@example.com", "password": "password123" }`
   - **Get Current User**: `GET http://localhost:5000/api/users/me`
     - Header: `Authorization: Bearer <token_from_login>`
3. **Verify**:
   - Ensure MongoDB is running.
   - Check for proper responses and errors.

---

## Best Practices Covered
- **Environment Variables**: Securely store sensitive data in `.env`.
- **Error Handling**: Use `express-async-handler` to manage async errors.
- **Password Security**: Hash passwords with `bcrypt`.
- **JWT Authentication**: Secure routes with JWT and middleware.
- **Code Organization**: Separate concerns with controllers, routes, models, and middleware.
- **Input Validation**: Basic validation in schema and controllers.
- **Mongoose Middleware**: Pre-save hooks for password hashing.

---

## Assignment
1. Add password confirmation during registration.
2. Implement a logout feature (client-side token removal).
3. Add input validation using `express-validator`.
4. Create a route to update user profile (protected).

---

## Additional Resources
- [Express Documentation](https://expressjs.com/)
- [Mongoose Documentation](https://mongoosejs.com/)
- [JWT Documentation](https://jwt.io/)
- [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)