const EventEmiter = require("events");
const event = new EventEmiter();
let isLightOn = false;

event.on("clap", () => {
 isLightOn=!isLightOn
  isLightOn ? console.log("Rooom Is Bright") : console.log("Room Is Dark");
});
event.emit("clap");
event.emit("clap");
event.emit("clap");
event.emit("clap");
event.emit("clap");
event.emit("clap");
