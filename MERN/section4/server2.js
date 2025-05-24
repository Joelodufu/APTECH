const http = require("http");

const server = http.createServer((req, res) => {
  res.writeHead(200, { "content-type": "text/plain" });
  res.end("Server Resource from port 3002");
});

try {
  server.listen(3002, () => console.log("Server Open on Port 3002"));
} catch (error) {
  console.log(error);
}
