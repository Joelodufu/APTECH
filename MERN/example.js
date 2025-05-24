const { log } = require("console");
const queryString = require("querystring");
const url = require("url");
const searchString =
  "https://www.google.com/search?name=joellee&age=45&height=23&race=african";


const extractedQuerry = searchString.split("?")[1];
console.log(extractedQuerry);

const userQuery = queryString.parse(extractedQuerry);
console.log(userQuery);
