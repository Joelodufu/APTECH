const url = require("url");
const myUrl =
  "https://web.facebook.com/stories/664262658948591/?source=profile_highlight";
const passedUrl = url.parse(myUrl, true);

console.log(passedUrl.hostname.split(".")[1]);
