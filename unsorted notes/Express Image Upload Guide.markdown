# Express Server: Uploading and Serving Product Images

This guide provides a step-by-step process to set up an Express server for uploading product images and serving them as static assets to front-end applications, following best practices for security, organization, and performance.

## Prerequisites
- Node.js and npm installed
- Basic knowledge of Express.js
- A front-end application to test the API (optional)

## Step 1: Project Setup
1. Create a new directory for your project:
   ```
   mkdir product-image-server
   cd product-image-server
   ```
2. Initialize a Node.js project:
   ```
   npm init -y
   ```
3. Install required dependencies:
   ```
   npm install express multer dotenv cors
   ```

## Step 2: Project Structure
Organize your project for scalability:
```
product-image-server/
├── public/
│   └── uploads/
├── src/
│   ├── routes/
│   │   └── productRoutes.js
│   ├── middleware/
│   │   └── upload.js
│   └── app.js
├── .env
├── package.json
└── README.md
```

## Step 3: Configure Environment Variables
Create a `.env` file to store configuration settings:
```
PORT=3000
UPLOAD_DIR=public/uploads
ALLOWED_ORIGINS=http://localhost:3000,http://your-frontend-domain.com
```

## Step 4: Set Up the Express Server
Create `src/app.js` to configure the Express server with best practices like CORS, security headers, and static file serving.

```javascript
const express = require('express');
const cors = require('cors');
const path = require('path');
require('dotenv').config();

const productRoutes = require('./routes/productRoutes');

const app = express();

// Middleware
app.use(cors({
  origin: process.env.ALLOWED_ORIGINS.split(','),
  methods: ['GET', 'POST'],
  allowedHeaders: ['Content-Type']
}));
app.use(express.json());

// Serve static files
app.use('/uploads', express.static(path.join(__dirname, '../public/uploads')));

// Routes
app.use('/api/products', productRoutes);

// Error handling middleware
app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).json({ error: 'Something went wrong!' });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
```

**Best Practices**:
- Use `dotenv` for environment-specific configurations.
- Enable CORS with specific origins for security.
- Serve static files from a dedicated directory.
- Include basic error handling middleware.

## Step 5: Configure File Upload Middleware
Create `src/middleware/upload.js` to handle image uploads using `multer` with validation and storage configuration.

```javascript
const multer = require('multer');
const path = require('path');

// Configure storage
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, process.env.UPLOAD_DIR);
  },
  filename: (req, file, cb) => {
    const uniqueSuffix = Date.now() + '-' + Math.round(Math.random() * 1E9);
    cb(null, `${file.fieldname}-${uniqueSuffix}${path.extname(file.originalname)}`);
  }
});

// File filter for image types
const fileFilter = (req, file, cb) => {
  const allowedTypes = ['image/jpeg', 'image/png', 'image/gif'];
  if (allowedTypes.includes(file.mimetype)) {
    cb(null, true);
  } else {
    cb(new Error('Only JPEG, PNG, and GIF images are allowed'), false);
  }
};

// Multer configuration
const upload = multer({
  storage,
  fileFilter,
  limits: {
    fileSize: 5 * 1024 * 1024 // 5MB limit
  }
});

module.exports = upload;
```

**Best Practices**:
- Store images in a dedicated directory (`public/uploads`).
- Generate unique filenames to avoid conflicts.
- Restrict file types to common image formats.
- Set a file size limit to prevent abuse.
- Use environment variables for the upload directory.

## Step 6: Create Routes for Product Image Upload
Create `src/routes/productRoutes.js` to handle image upload and retrieval endpoints.

```javascript
const express = require('express');
const router = express.Router();
const upload = require('../middleware/upload');

// POST: Upload product image
router.post('/upload', upload.single('productImage'), (req, res) => {
  try {
    if (!req.file) {
      return res.status(400).json({ error: 'No file uploaded' });
    }
    
    const imageUrl = `/uploads/${req.file.filename}`;
    res.status(201).json({
      message: 'Image uploaded successfully',
      imageUrl
    });
  } catch (error) {
    res.status(400).json({ error: error.message });
  }
});

// GET: Example endpoint to list uploaded images (optional)
router.get('/images', (req, res) => {
  const fs = require('fs');
  const uploadDir = process.env.UPLOAD_DIR;
  
  fs.readdir(uploadDir, (err, files) => {
    if (err) {
      return res.status(500).json({ error: 'Failed to list images' });
    }
    const imageUrls = files.map(file => `/uploads/${file}`);
    res.json({ images: imageUrls });
  });
});

module.exports = router;
```

**Best Practices**:
- Use `upload.single('productImage')` to handle single file uploads.
- Return the image URL in the response for front-end use.
- Include error handling for failed uploads.
- Provide an optional endpoint to list images for debugging.

## Step 7: Create the Upload Directory
Ensure the `public/uploads` directory exists:
```
mkdir -p public/uploads
```

## Step 8: Test the Server
1. Start the server:
   ```
   node src/app.js
   ```
2. Use a tool like Postman or a front-end form to test the upload:
   - **POST** `http://localhost:3000/api/products/upload`
   - Attach an image file with the field name `productImage`.
   - Expect a response like:
     ```json
     {
       "message": "Image uploaded successfully",
       "imageUrl": "/uploads/productImage-1234567890.jpg"
     }
     ```
3. Access the image at `http://localhost:3000/uploads/productImage-1234567890.jpg`.

## Step 9: Front-End Integration
To upload images from a front-end (e.g., React), use a form with `FormData`:

```javascript
const handleUpload = async (file) => {
  const formData = new FormData();
  formData.append('productImage', file);

  try {
    const response = await fetch('http://localhost:3000/api/products/upload', {
      method: 'POST',
      body: formData
    });
    const data = await response.json();
    console.log('Image URL:', data.imageUrl);
  } catch (error) {
    console.error('Upload failed:', error);
  }
};
```

To display the image:
```html
<img src="http://localhost:3000/uploads/productImage-1234567890.jpg" alt="Product" />
```

## Best Practices Summary
- **Security**:
  - Validate file types and sizes.
  - Restrict CORS to trusted origins.
  - Use unique filenames to prevent overwrites.
- **Performance**:
  - Serve static files efficiently using `express.static`.
  - Limit file sizes to prevent server overload.
- **Organization**:
  - Separate routes, middleware, and app logic.
  - Use environment variables for configuration.
- **Error Handling**:
  - Implement global error handling.
  - Provide meaningful error messages to the client.

## Optional Enhancements
- Add database integration (e.g., MongoDB) to store image metadata.
- Implement authentication to restrict uploads.
- Use a CDN or cloud storage (e.g., AWS S3) for scalability.
- Add image compression (e.g., `sharp`) to reduce file sizes.