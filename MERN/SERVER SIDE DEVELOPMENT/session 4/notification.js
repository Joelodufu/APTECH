const EventEmitter = require("events")

//extend the Event emitter class
class NotifyEmitter extends EventEmitter { }

//create and instance of the extended class
const notifyEmitter = new NotifyEmitter()

//Register an event listener for sending notifications
notifyEmitter.on("sendNotification", (message) => {
    console.log(`Sending Notification: ${message}`);
    
})

//LET'S Mimic a trigger
setTimeout(() => {
    notifyEmitter.emit("sendNotification", "Meeting Reminder")
}, 2000);

setTimeout(() => {
    notifyEmitter.emit("sendNotification", "Reminder to call client")
}, 4000)

setTimeout(() => {
    notifyEmitter.emit("sendNotification", "Product Delivery Reminder");
}, 6000)