const fs = require("fs")
const formidable = require("formidable");

const MyFunc = {
  msg: "This is an example of using Local Module",
  addNum: function (a, b) {
    const result = a + b;
    console.log("The result is: ", a, "+", b, "=", result);
  },


  subNum: function (a, b) {
    const result = a - b;
    if (a > b) {
      console.log("The result is: ", a, "-", b, "=", result);
    } else {
        console.log("Cannot subtract");
        
    }
  },

  useFormidable: function (req, res) {
    const form = new formidable.IncomingForm();

    form.parse(req, (err, fields, files) => {
      if (err) {
        res.writeHead(500, { "Content-Type": "text/plain" });
        res.end("File upload failed!");
        return;
      }

      // Display file info
      const file = files.fileupload[0];
      res.writeHead(200, { "Content-Type": "text/html" });
      res.write(`<h3>File uploaded successfully!</h3>`);
      res.write(`<p>Original Filename: ${file.originalFilename}</p>`);
      res.write(`<p>Temporary Path: ${file.filepath}</p>`);
      res.end();
    });
  }


};

module.exports = MyFunc;
