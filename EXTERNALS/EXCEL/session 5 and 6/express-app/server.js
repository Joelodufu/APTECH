//importing packages
const express = require("express");
const errorHandler = require("./middlewares/errorHandler");
const userRoutes = require("./routes/user.routes");

//creating instace of the express framework
const app = express();
//use express to acept and send json files
app.use(express.json());
// user route middleware
app.get("/api/users", userRoutes);
app.get("/", (req, res) => {
  res.send("Welcome to my Express API");
});
app.use(errorHandler);

//define our port
const PORT = process.env.PORT || 3000;

//START THE SERVER WITH THE PORT

app.listen(PORT, () => {
  console.log(`Server Started on Port: ${PORT}`);
});
