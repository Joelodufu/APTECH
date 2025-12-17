// const http = require("http");

// //creating a server
// const server = http.createServer((req, res) => {
//   res.statusCode = 200;
//   res.setHeader("Content-Type", "text/plain");
//   res.end(
//     "In the failed clutch of circumstances, i neither wince nor cry aloud.. "
//   );
// });

// server.listen(3000, "localhost", () => console.log("Listening to Port 3000"));

const url = require("url")
const myUrl =
    "https://www.jumia.com.ng/flash-sales/?size=XS--S&price=24768-26500#catalog-listing";
parsedUrl = url.parse(myUrl, true)

console.log(parsedUrl.host);
console.log(parsedUrl.pathname);
console.log(parsedUrl.query);
