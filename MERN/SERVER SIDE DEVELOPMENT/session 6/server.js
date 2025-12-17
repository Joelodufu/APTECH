const var_express = require("express");
const var_app = var_express();

// creating a body parser instance
const var_paser = require("body-parser");

var_app.use(var_paser.json());
var_app.use(var_paser.urlencoded({ extended: false }));

var_app.get("/", (req, res) => {
  res.sendFile(__dirname + "/StudentResult.html");
});

var_app.post("/results", (req, res) => {
  res.status(200).json([
    { name: "Basit", course: "MERN" },
    { name: "Aishat", course: "MERN" },
    { name: "Emmanuel", course: "MERN" },
    { name: "Benedict", course: "MERN" },
  ]);
});

//configur the web server to listen to port 3000
const PORT = 3000;
var_app.listen(PORT, () => {
  console.log(
    `My Express app is running on the port: http://localhost:${PORT}`
  );
});
