const http = require("http");
const formidable = require("formidable");
const fs = require("fs");
const myFunc = require("./localModule")

http
  .createServer((req, res) => {
    if (req.url === "/upload" && req.method.toLowerCase() === "post") {
      myFunc.useFormidable(req, res)
    } else {
      // HTML upload form
      res.writeHead(200, { "Content-Type": "text/html" });
      res.write(`
      <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="fileupload"><br><br>
        <input type="submit" value="Upload File">
      </form>
    `);
      res.end();
    }
  })
  .listen(8080);

console.log("Server running at http://localhost:8080");
