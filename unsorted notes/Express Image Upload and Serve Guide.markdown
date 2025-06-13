# Express Server: Uploading and Serving Product Images with 404 Handling

This guide provides a step-by-step process to set up an Express server for uploading product images to a dedicated folder (`public/uploads`) and serving them statically at `http://localhost:3000/uploads/imageName.jpg`. If the requested image exists, it is displayed; if not, a 404 response is returned. The setup follows best practices for security, organization, and performance.

## Prerequisites
- Node.js and npm installed
- Basic knowledge of Express.js
- A front-end application or tool (e.g., Postman) to test the API

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
Create `src/app.js` to configure the Express server with CORS, static file serving, and custom 404 handling for missing images.

```javascript
const express = require('express');
const cors = require('cors');
const path = require('path');
const fs = require('fs');
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

// Serve static files from uploads directory
app.use('/uploads', express.static(path.join(__dirname, '../public/uploads')));

// Custom 404 handler for missing static files
app.use('/uploads', (req, res, next) => {
  const filePath = path.join(__dirname, '../public/uploads', req.path);
  fs.access(filePath, fs.constants.F_OK, (err) => {
    if (err) {
      return res.status(404).json({ error: 'Image not found' });
    }
    next();
  });
});

// Routes
app.use('/api/products', productRoutes);

// Global error handling middleware
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
- Serve static files from `public/uploads` using `express.static`.
- Add a custom middleware to check for file existence and return a 404 for missing images.
- Use `dotenv` for environment-specific configurations.
- Enable CORS with specific origins for security.
- Include global error handling middleware.

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
- Store images in `public/uploads` as specified in `UPLOAD_DIR`.
- Generate unique filenames to avoid conflicts.
- Restrict file types to JPEG, PNG, and GIF.
- Set a 5MB file size limit to prevent abuse.
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

// GET: List uploaded images (optional for debugging)
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
- Use `upload.single('productImage')` for single file uploads.
- Return the image URL in the response for front-end use.
- Handle upload errors gracefully.
- Include an optional endpoint to list images for debugging.

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
2. Test image upload using Postman or a front-end form:
   - **POST** `http://localhost:3000/api/products/upload`
   - Attach an image file with the field name `productImage`.
   - Expect a response like:
     ```json
     {
       "message": "Image uploaded successfully",
       "imageUrl": "/uploads/productImage-1234567890.jpg"
     }
     ```
3. Test image serving:
   - Access `http://localhost:3000/uploads/productImage-1234567890.jpg` in a browser.
     - If the image exists, it will be displayed.
     - If the image does not exist (e.g., `http://localhost:3000/uploads/nonexistent.jpg`), expect a 404 response:
       ```json
       { "error": "Image not found" }
       ```
4. Test the optional list endpoint:
   - **GET** `http://localhost:3000/api/products/images`
   - Expect a response listing all uploaded image URLs.

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

To display an image:
```html
<img src="http://localhost:3000/uploads/productImage-1234567890.jpg" alt="Product" />
```

If the image URL is invalid, the server will return a 404, which can be handled in the front-end (e.g., display a placeholder image).

## Best Practices Summary
- **Static File Serving**:
  - Images are stored in `public/uploads` and served via `express.static`.
  - A custom middleware checks for file existence and returns a 404 for missing images.
- **Security**:
  - Validate file types (JPEG, PNG, GIF) and sizes (5MB limit).
  - Restrict CORS to trusted origins.
  - Use unique filenames to prevent overwrites.
- **Organization**:
  - Separate routes, middleware, and app logic.
  - Use environment variables for configuration.
- **Error Handling**:
  - Return a 404 JSON response for missing images.
  - Implement global error handling for server errors.
- **Performance**:
  - Serve static files efficiently with `express.static`.
  - Limit file sizes to prevent server overload.

## Optional Enhancements
- Add database integration to store image metadata (e.g., MongoDB).
- Implement authentication to restrict uploads.
- Use cloud storage (e.g., AWS S3) for scalability.
- Add image compression (e.g., `sharp`) to reduce file sizes.