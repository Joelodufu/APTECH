const http = require("http");

const server = http.createServer((req, res) => {
  res.writeHead(200, { "content-type": "text/plain" });
  res.end('{ Name: "Joel", Class: "ADSE" }');
});

try {
  server.listen(3001, () => console.log("Server Open on Port 3001"));
} catch (error) {
  console.log(error);
}
