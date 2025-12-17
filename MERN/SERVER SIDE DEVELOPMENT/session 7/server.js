// const fs = require("fs");
// const data = fs.readFileSync("./data.txt", "utf8");
// console.log(data);
// console.log("File read successfully");

// function fetchData(afterFetch) {
//   setTimeout(() => {
//     console.log("Data Fetched...");
//     afterFetch();
//   }, 2000);
// }
// function myAfterFetch(callback2) {
//     console.log("My After Fetch Function have been called");
//     callback2()
// }

// fetchData(myAfterFetch(() => {

// }));

// const fetchData = new Promise((resolve, reject) => {
//   setTimeout(() => {
//     const success = false;
//     success
//       ? resolve("Data Fetched Successfully")
//       : reject("Data Fetching Failed...");
//   }, 2000);
// });

// fetchData
//     .then((data) => console.log(data))
//     .catch((err) => console.log(err));

// const fs = require("fs").promises;
// fs.readFile("./data.txt", "utf8")
//   .then((data) => console.log(data))
//   .catch((err) => console.log(err));

function fetchData() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve("Data Recieved");
    }, 2000);
  });
}

async function processData() {
  console.log("Fatching Data...");
  const data = await fetchData();
  console.log(data);
  console.log("Data proccessed successfully!!");
}

processData();
