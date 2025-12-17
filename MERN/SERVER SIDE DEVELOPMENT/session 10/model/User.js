const mongoose = require("mongoose");
const Schema = mongoose.Schema;
const passportLocalMongoose = require("passport-local-mongoose").default;

var User = new Schema({
  userName: { type: String },
  password: { type: String },
});
User.plugin(passportLocalMongoose);
module.exports = mongoose.model("User", User);
