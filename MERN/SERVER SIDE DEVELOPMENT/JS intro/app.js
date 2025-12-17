// //STRING DATA TYPE
// let name = "Benjamin";
// let message = "Welcome to class";
// let greeting = `${message}, ${name}! Let's learn JavaScript.`; //Template Literal
// console.log(greeting);

// //NUMBER DATA TYPE
// let age = 25;
// let accountBalance = 1500.75;
// let temp = -5;
// let maximumAge = Number.MAX_VALUE;
// let personalReport= `I am ${age} years old and my account balance is NGN${accountBalance}.  The weather today is ${temp}C.`;
// console.log(personalReport);

// let value1 = "2"
// let value2 = 2

// console.log(value1 == value2); //true (loose equality)
// console.log(value1 === value2); //false (strict equality)

// let age1 = 10;
// let age2 = age1; //copy by value
// age2 = 20;
// console.log(age1);

// let person1 = {name: "John", age: 30};
// let person2 = person1; //copy by reference
// person2.age = 40;
// console.log(person1.age); //40

//CONTROL OF FLOWS
// console.log("Control of Flows");
// student = {
//   name: "Machine Duece",
//   age: 18,
//   isEnrolled: true,
//   score: 85,
// };

// if (student.isEnrolled) {
//   console.log(`${student.name} is enrolled in the class.`);
//   //allow student inside
//   console.log(`${student.name} is allowed to go to class.`);
//   // allow student to take test
//   console.log(`${student.name} is allowed to take test`);

//   // allow student to write exam
//   console.log(`${student.name} is allowed to write exam.`);
// } else {
//   console.log(`${student.name} is not enrolled in the class.`);
// }

// //score grading
// student = {
//   name: "Machine Duece",
//   age: 18,
//   isEnrolled: true,
//   score: 85,
// };

// score = student.score;
// if (score >= 70) {
//   console.log(`${student.name} scored an A.`);
// } else if (score >= 60) {
//   console.log(`${student.name} scored a B.`);
// } else if (score >= 50) {
//   console.log(`${student.name} scored a C.`);
// } else {
//   console.log(`${student.name} scored a D.`);
// }

//FOR LOOP

// console.log("For Loop");
// for (let i = 1; true; i++) {
//   console.log(`Iteration number: ${i}`);
//   if (i == 1000) {
//     break;
//   }
// }

// //WHILE LOOP
// console.log("While Loop");
// let age = 2;
// while (true) {
//   console.log(`You are ${age} years old.`);
//   age++;
//   if (age === 18) {
//     console.log("You are old enough to vote.");
//   }
//   if (age === 100) {
//     console.log("You are too old to vote.");
//   }
//   if (age === 200) {
//     console.log("You can go and meet your ancestors");
//     break;
//   }
// }

//do while loop
//check password entry
console.log("Do While Loop");
let password = "";
do {
  password = prompt("Enter your password:");
} while (password !== "12345");
console.log("Password accepted.");