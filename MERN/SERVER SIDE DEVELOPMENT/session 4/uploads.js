//import the requred modules
const http = require("http"); // core http module to create server
const formidable = require("formidable"); // for parsing incoming file data
const fs = require("fs"); //modules or file op[erations]
const path = require("path"); // for handling path safely

//CREATING OUR SIMPLE HTTP SERVER
http
  .createServer((req, res) => {
    //check if the incoming request is a post request
    if (req.url === "/upload" && req.method.toLowerCase() === "post") {
      //ensure if the upload directory exists, else we create one
      if (!fs.existsSync("./uploads")) fs.mkdirSync("./uploads");

      //create a formidable incomoing instance
      const form = new formidable.IncomingForm();

      //lets specify where incoming file will be temporarilly stored
      form.uploadDir = "./uploads";

      //ensure keeping the file original extension
      form.keepExtensions = true;

      // parse the incoming request containing the form data
      form.parse(req, (err, fields, files) => {
        //if there is error during parsing (e.g invalid form), send a 500 error
        if (err) {
          res.writeHead(500, { "Content-Type": "text/plain" });
          res.end("Upload Error: " + err.message);
        }

        //retrieve the uploaded file
        //formidable may return an array or a single file
        const file = Array.isArray(files.fileupload)
          ? files.fileupload[0]
          : files.fileupload;
        const name = fields.name;
        const email = fields.email;

        //if file is not recieved we send 400 error
        if (!file) {
          res.writeHead(400, { "Content-Type": "text/plain" });
          res.end("No File uploaded");
          return;
        }

        //The temporal file path (auto-gen by formidable)
        const oldPath = file.filepath;

        // the new upload file path, where we will move the uploaded file to
        const newPath = path.join(form.uploadDir, file.originalFilename);

        //lets move the file from the temporal path to the final destination

        fs.rename(oldPath, newPath, (err) => {
          // If there’s an error during moving, respond with an error message
          if (err) {
            res.writeHead(500, { "Content-Type": "text/plain" });
            res.end("File move failed" + err.message);
            return;
          }

          //send success message to user
          res.writeHead(200, { "Content-Type": "text/html" });
          res.write("<h3>File uplloaded and moved succesfully</h3>");
          res.write(`<p>Saved as:${file.originalFilename} </p>`);
          res.write(`<p>User:${name} </p>`);
          res.write(`<p>Emal:${email} </p>`);
          res.end();
        });
      });
    } else {
      // If the route is not /upload (e.g., GET request to home page)
      // serve a simple HTML upload form
      res.writeHead(200, { "Content-Type": "text/html" });
      res.write(
        `
      <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="fileupload"><br><br>
        <input type="email" name="email"><br><br>
        <input type="phone" name="phone"><br><br>
        <input type="submit" value="Upload File">
      </form>
          `
      );
      res.end();
    }
  })
  .listen(3000);
console.log("Server listening at port 3000");
