// Import Neccesary packages
const express = require("express");
const mongoose = require("mongoose");
const passport = require("passport");
const bodyParser = require("body-parser");
const LocalStrategy = require("passport-local").Strategy;

//refferencing the Models
const User = require("./model/User");
const Book = require("./model/Book");

//creating instance of express and connecting to the database
const app = express();
mongoose.connect("mongodb://localhost:27017");

//set the view engine to use ejs
app.set("view engine", "ejs");

//allow body parser to get data from form input
app.use(bodyParser.urlencoded({ extended: true }));

// create a session for the app
app.use(
  require("express-session")({
    secret: "joellee",
    resave: false,
    saveUninitialized: false,
  })
);

//initialize passporst for authention purpose
app.use(passport.initialize());
app.use(passport.session());

// Declare our static folder
app.use(express.static(__dirname + "/public"));

//add the admin local strategy
passport.use(
  "admin-local",
  new LocalStrategy((username, password, done) => {
    if (username === "Admin" && password === "12345") {
      return done(null, { username: "Aptech" });
    }
    return done(null, false, {
      message: "Incorrect Admin username or password",
    });
  })
);

passport.serializeUser((user, done) => {
  done(null, user);
});

passport.deserializeUser((user, done) => {
  done(null, user);
});

// route for home page

app.get("/", (req, res) => {
  res.render("home");
});

// route for Register page
app.get("/register", (req, res) => {
  res.render("register");
});

//handling user signup
app.post("/register", async (req, res) => {
  const user = await User.create({
    username: req.body.username,
    password: req.body.password,
  });

  res.redirect("/");
});

// handling user login
app.get("/login", (req, res) => {
  res.render("login");
});

app.post("/login", async (req, res) => {
  try {
    //chech if user exist
    const user = await User.findOne({ username: req.body.username });

    if (user) {
      //as user exist, compaire the input password with the DB Passwod
      const passwordCorrect = req.body.password === user.password;
      if (passwordCorrect) {
        //search for the list of books available
        const books = await Book.find({});
        //use that list to generat the booklist using the BookList VIEWS
        res.render("booklist", { books: books });
      } else {
        res.render("error", { errorMessage: "Password Doesn't Match" });
      }
    } else {
      res.render("error", { errorMessage: "User not found" });
    }
  } catch (e) {
    res.render("error", { errorMessage: e.message });
  }
});

//Admin Login Route
app.get("/admin", (req, res) => {
  res.render("admin-login");
});

//post admin login

app.post("/admin-login", (req, res) => {
  //create passport authentication
  passport.authenticate("admin-local", {
    successRedirect: "/admin-dashboard",
    failureRedirect: "/admin-error",
  });
});

//Admin Error
app.get("/admin-error", (req, res) => {
  res.render("admin-error", {
    errorMessage: "Incorrect Admin Username or Password",
  });
});

//Admin Dashboard
app.get("/admin-dashboard", (req, res) => {
  //check if user is authenticated as admin
  if (req.isAuthenticated()) {
    //if authenticated as admin, then render the admin dashboard
    res.render("admin-dashboard");
  } else {
    //if not, rediret to admin login
    res.redirect("/admin");
  }
});

//admin adding books
app.post("admin-dashboard/add-book", (req, res) => {
  //check if the request is from an admin authenticated user
  if (req.isAuthenticated()) {
    const newBook = {
      Book_id: req.body.Book_id,
      Book_name: req.body.Book_name,
      Author_name: req.body.Author_name,
      Price: req.body.Price,
      Age_group: req.body.Age_group,
      Book_type: req.body.Book_type,
    };

    //with the new body passed book object let us create the instance in the database
    Book.create(newBook)
      .then((book) => {
        console.log("Book created succefully: ", book);
        res.redirect("/admin-dashboard");
      })
      .catch((e) => {
        console.log("Failed to add Book: ", e);
        res.status(500).json({ error: "Failed to add book" });
      });
  } else {
    res.redirect("/admin");
  }
});

// Hanling Logout
app.get("/logout", (req, res) => {
  req.logOut((err) => {
    if (err) {
      return next(err);
    }
    res.redirect("/");
  });
});

//middleware for checking if a request is loggedin
const isLogedIn = (req, res, next) => {
  if (req.isAuthenticated()) return next();
  res.redirect("/login")
}

// create the server and listen to it
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log("Server have started");
});
