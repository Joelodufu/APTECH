//import packages
const http = require("http");
const cors = require("cors"); //add this line

// define the cors rules
const corsMiddleWare = cors();

// define your cors middlware

function runMiddleWare(req, res, middleWare) {
  return new Promise((resolve, reject) => {
    middleWare(req, res, (result) => {
      if (result instanceof Error) return reject(result);
      resolve(result);
    });
  });
}

// CREATING SERVER WITH HTTP PACKAGE
const server = http.createServer(async (req, res) => {
  
  await runMiddleWare(req, res, corsMiddleWare);
  res.setHeader("content-type", "application/json");
  //   res.end(
  //     JSON.stringify({
  //       name: "Samuel",
  //       age: 10,
  //       isAdmin: true,
  //     })
  //   );

  if (req.url == "/home") {
    res.statusCode = 200;
    res.end(
      JSON.stringify({
        message: "Welcome to home Page",
        hostname: req.url.toLowerCase,
      })
    );
  } else if (req.url == "/students") {
    res.statusCode = 200;
    res.end(
      JSON.stringify([
        { id: 1, name: "Johnson" },
        { id: 2, name: "Machine" },
        { id: 3, name: "Basit" },
        { id: 4, name: "Joseph" },
        { id: 4, name: "Joseph" },
        { id: 4, name: "Joseph" },
        { id: 4, name: "Joseph" },
        { id: 4, name: "Joseph" },
        { id: 4, name: "Joseph" },
      ])
    );
  } else if (req.url === "/info") {
    res.statusCode = 200;
    res.end(
      JSON.stringify({
        message: "Welcom to Info Page",
        info: "This information means nothing, is just to keep you busy for..",
      })
    );
  } else {
    res.statusCode = 404;
    res.end(
      JSON.stringify({
        error: "Route not found",
      })
    );
  }
});

//opening portal for the server to be reached
server.listen(3000, () => {
  console.log("Server Is Working");
});
