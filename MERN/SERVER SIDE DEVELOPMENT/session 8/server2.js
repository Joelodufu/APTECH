const express = require("express");
const fs = require("fs");
const path = require("path");
const ajv = require("ajv");
const PORT = 3000;

const app = express();

//Allow parsing from json request
app.use(express.json());

//load our validation rules/Json Schema
const schemaPath = path.join(__dirname, "productSchema.json");
const productSchema = JSON.parse(fs.readFileSync(schemaPath, "utf8"));

app.listen(PORT, () => {
  console.log(`Server Started on http://localhost:${PORT}`);
});
