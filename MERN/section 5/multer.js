const multer = require("multer");
const express = require("express");
const { log } = require("node:console");

const app = express();
const uploadd = multer({ dest: "uploads/" });

app.post("/upload", uploadd.single("file"), (req, res) => {
  res.send("FIle Uploaded successfully");
});

app.listen(3000, () => {
  console.log("Listening at port 3000");
});
