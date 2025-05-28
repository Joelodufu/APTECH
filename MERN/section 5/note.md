Sure! Here's a **simple Express server** using **Multer** to upload images into an `uploads/` folder, with clear comments to help you understand each part.

---

### ✅ 1. Install Required Packages

Make sure you have these dependencies installed:

```bash
npm init -y
npm install express multer
```

---

### ✅ 2. Project Structure

```
project-folder/
│
├── uploads/            # This will hold uploaded images (create this manually or dynamically)
├── server.js           # Your main server file
```

---

### ✅ 3. `server.js` – Full Code with Comments

```js
// Import required modules
const express = require('express');
const multer = require('multer');
const path = require('path');

// Initialize express app
const app = express();

// ==========================
// Configure Multer
// ==========================

// Set storage engine and destination
const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, 'uploads/'); // where files will be saved
  },
  filename: function (req, file, cb) {
    // Generate a unique filename using the original name
    const uniqueName = Date.now() + '-' + file.originalname;
    cb(null, uniqueName);
  }
});

// Set file filter to accept only images
const fileFilter = (req, file, cb) => {
  const allowedTypes = /jpeg|jpg|png|gif/;
  const mimeType = allowedTypes.test(file.mimetype);
  const extName = allowedTypes.test(path.extname(file.originalname).toLowerCase());

  if (mimeType && extName) {
    return cb(null, true);
  }
  cb(new Error('Only image files are allowed!'));
};

// Initialize multer middleware
const upload = multer({
  storage: storage,
  fileFilter: fileFilter,
  limits: {
    fileSize: 5 * 1024 * 1024 // max 5 MB
  }
});

// ==========================
// Routes
// ==========================

// Home route
app.get('/', (req, res) => {
  res.send('Welcome to the Image Upload Server!');
});

// Image upload route (POST)
app.post('/upload', upload.single('image'), (req, res) => {
  // 'image' is the name of the form field
  if (!req.file) {
    return res.status(400).send('No file uploaded or invalid file type.');
  }

  res.send({
    message: 'File uploaded successfully!',
    filename: req.file.filename,
    path: req.file.path
  });
});

// ==========================
// Start Server
// ==========================
const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
```

---

### ✅ 4. Example `cURL` to Test Upload

```bash
curl -X POST -F "image=@/path/to/image.jpg" http://localhost:3000/upload
```

Or use **Postman** with:

* Method: `POST`
* URL: `http://localhost:3000/upload`
* Body > form-data:

  * Key: `image` (type: File)
  * Value: select an image

---

### ✅ 5. Notes

* Make sure `uploads/` folder exists or handle directory creation in code.
* This is a **single image upload**. For **multiple images**, replace:

  ```js
  upload.single('image')
  ```

  with:

  ```js
  upload.array('images', 5) // accepts up to 5 images
  ```

---

