const EventEmitter = require("events");

//creating a new instance of event emmitter
const eventEmitter = new EventEmitter();

//register a new listener
eventEmitter.on("greet", () => {
    console.log("Hello from the greetings event. it is good morning");
})


//trigger event
eventEmitter.emit("greet")