const express = require("express");
const app = express();

app.get("/", (req, res) => {
  console.log(req.ip);
  res.status(200).json({
    ip: req.ip,
    ips: req.ips,
    method: req.method,
    header: req.headers,
  });
});

app.listen(3000, () => {
  console.log("conneced .....");
});
