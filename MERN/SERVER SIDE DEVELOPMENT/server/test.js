const fs = require("fs")

const existence = fs.existsSync("./server.js")

console.log(fs.mkdirSync("./mycontacts"))

console.log(existence);
