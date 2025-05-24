---

## 📚 Class: Sending Emails with Gmail using Nodemailer and Express.js

---

### **Lesson Overview:**

By the end of this class, students will:

* Understand what Nodemailer is.
* Set up an Express.js server.
* Use Gmail SMTP to send emails using Nodemailer.
* Handle errors and success responses.

---

### **🧰 Prerequisites:**

* Node.js installed.
* Basic knowledge of JavaScript and Express.
* Gmail account.
* Allow "Less secure app access" or use Gmail App Passwords (if 2FA is enabled).

---

### **🪜 Step-by-Step Process**

---

### **1. Initialize Your Project**

```bash
mkdir email-sender
cd email-sender
npm init -y
npm install express nodemailer dotenv
```

---

### **2. Create Project Structure**

```
email-sender/
├── node_modules/
├── .env
├── index.js
└── package.json
```

---

### **3. Create `.env` File**

Put your Gmail credentials here. Use an **App Password** if 2FA is enabled.

```env
EMAIL_USER=yourgmail@gmail.com
EMAIL_PASS=yourapppassword
```

---

### **4. Create `index.js` File**

```js
const express = require("express");
const nodemailer = require("nodemailer");
require("dotenv").config();

const app = express();
app.use(express.json());

// Route to send email
app.post("/send-email", async (req, res) => {
  const { to, subject, text } = req.body;

  // Create a transporter
  let transporter = nodemailer.createTransport({
    service: "gmail",
    auth: {
      user: process.env.EMAIL_USER,
      pass: process.env.EMAIL_PASS,
    },
  });

  // Email options
  const mailOptions = {
    from: `"My App" <${process.env.EMAIL_USER}>`,
    to,
    subject,
    text,
  };

  try {
    const info = await transporter.sendMail(mailOptions);
    res.status(200).json({ message: "Email sent!", info });
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: "Failed to send email", error });
  }
});

// Start server
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
```

---

### **5. Test the API**

Use **Postman** or **curl**:

```bash
curl -X POST http://localhost:3000/send-email \
  -H "Content-Type: application/json" \
  -d '{
    "to": "recipient@example.com",
    "subject": "Test Email",
    "text": "Hello, this is a test email from Node.js!"
}'
```

---

### **6. Gmail Configuration Notes**

* Enable **2-Step Verification** on your Gmail account.
* Create an **App Password** and use that as `EMAIL_PASS`.

  * Go to [https://myaccount.google.com/apppasswords](https://myaccount.google.com/apppasswords)

---

### **📘 Bonus: Send HTML Emails**

```js
const mailOptions = {
  from: `"My App" <${process.env.EMAIL_USER}>`,
  to,
  subject,
  html: `<h1>Welcome!</h1><p>This is a test email.</p>`,
};
```

---

### **✅ Assignment (Optional)**

* Build a frontend with HTML form to submit name, email, and message to your `/send-email` endpoint.
* Extend functionality to send attachments or send to multiple recipients.

---

