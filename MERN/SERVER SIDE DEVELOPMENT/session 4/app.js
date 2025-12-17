var nodemailer = require("nodemailer")

var emailClient = nodemailer.createTransport({
  service: "gmail",
  auth: {
    user: "joelodufu@gmail.com",
    pass: "xbfg onff biev wsve"
  }
});

var emailContent = {
    from: "joelodufu@gmail.com",
    to: "emeraldcodelines@gmail.com",
    subject: "Node JS Testing",
    text:"This is a test email from nodejs"
}

emailClient.sendMail(emailContent, (error, info) => {
    if (error) {
        console.log("Error: "+error);
    } else {
        console.log("Email Sent: "+info.response);
    }
})