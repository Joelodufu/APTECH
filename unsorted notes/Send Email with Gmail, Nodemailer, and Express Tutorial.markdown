# Sending Emails with Gmail, Nodemailer, and Express: A Step-by-Step Class

This tutorial guides you through creating a Node.js application using Express and Nodemailer to send emails via Gmail. By the end, you'll have a functional app that sends emails from a Gmail account.

## Prerequisites
- Basic knowledge of JavaScript and Node.js
- Node.js and npm installed
- A Gmail account
- Code editor (e.g., VS Code)

## Step 1: Set Up Your Project
1. Create a new directory for your project:
   ```bash
   mkdir gmail-nodemailer-express
   cd gmail-nodemailer-express
   ```
2. Initialize a Node.js project:
   ```bash
   npm init -y
   ```
3. Install required dependencies:
   ```bash
   npm install express nodemailer dotenv
   ```

## Step 2: Configure Gmail for Sending Emails
1. Go to your [Google Account settings](https://myaccount.google.com/).
2. Enable **2-Step Verification** under Security.
3. After enabling, create an **App Password**:
   - Navigate to Security > App Passwords.
   - Select "Mail" as the app and "Other" as the device, then generate a 16-character password.
   - Save this password securely (you'll use it in Step 4).

## Step 3: Set Up Environment Variables
1. Create a `.env` file in your project root:
   ```bash
   touch .env
   ```
2. Add your Gmail credentials to `.env`:
   ```
   GMAIL_USER=your.email@gmail.com
   GMAIL_PASS=your-app-password
   ```
   Replace `your.email@gmail.com` with your Gmail address and `your-app-password` with the 16-character app password from Step 2.

## Step 4: Create the Express Server
1. Create an `index.js` file:
   ```bash
   touch index.js
   ```
2. Add the following code to set up an Express server with Nodemailer:
   ```javascript
   require('dotenv').config();
   const express = require('express');
   const nodemailer = require('nodemailer');
   const app = express();
   const port = 3000;

   // Middleware to parse JSON bodies
   app.use(express.json());

   // Create Nodemailer transporter
   const transporter = nodemailer.createTransport({
     service: 'gmail',
     auth: {
       user: process.env.GMAIL_USER,
       pass: process.env.GMAIL_PASS,
     },
   });

   // Route to send email
   app.post('/send-email', async (req, res) => {
     const { to, subject, text } = req.body;

     const mailOptions = {
       from: process.env.GMAIL_USER,
       to,
       subject,
       text,
     };

     try {
       await transporter.sendMail(mailOptions);
       res.status(200).json({ message: 'Email sent successfully!' });
     } catch (error) {
       console.error('Error sending email:', error);
       res.status(500).json({ message: 'Failed to send email', error });
     }
   });

   // Start the server
   app.listen(port, () => {
     console.log(`Server running on http://localhost:${port}`);
   });
   ```

## Step 5: Test the Email Sending Functionality
1. Start your server:
   ```bash
   node index.js
   ```
2. Use a tool like Postman or cURL to test the `/send-email` endpoint. Example cURL command:
   ```bash
   curl -X POST http://localhost:3000/send-email \
   -H "Content-Type: application/json" \
   -d '{"to":"recipient@example.com","subject":"Test Email","text":"Hello from Nodemailer!"}'
   ```
   Replace `recipient@example.com` with a valid email address.
3. Check the recipient's inbox (and spam/junk folder) for the email.

## Step 6: Troubleshooting Tips
- **Email not sending?** Verify your Gmail App Password and ensure 2-Step Verification is enabled.
- **Port conflict?** Change the `port` variable in `index.js` (e.g., to 3001).
- **Environment variables not loading?** Ensure `dotenv` is installed and the `.env` file is correctly formatted.
- **Rate limits?** Gmail has sending limits; avoid sending too many emails in a short period.

## Step 7: Enhance the Application (Optional)
- Add HTML content to emails using `html` in `mailOptions`:
  ```javascript
  html: '<h1>Hello!</h1><p>This is a <b>fancy</b> email.</p>'
  ```
- Implement input validation for `to`, `subject`, and `text`.
- Add error handling for invalid email addresses.
- Deploy the app to a platform like Heroku or Render for public access.

## Conclusion
You've built a Node.js application with Express and Nodemailer to send emails via Gmail. This setup can be extended for automated emails, notifications, or contact forms. Experiment with additional features like attachments or templating for more complex use cases.

## Resources
- [Nodemailer Documentation](https://nodemailer.com/)
- [Express Documentation](https://expressjs.com/)
- [Google App Passwords](https://myaccount.google.com/security)