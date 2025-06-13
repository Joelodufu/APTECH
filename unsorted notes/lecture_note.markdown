# Lecture Note: Building a Full-Stack Product Management App with Flutter and Express.js (CLEAN Architecture, Feature-First)

## Introduction
This lecture note provides a step-by-step guide to building a full-stack application where users can create products with images using a Flutter frontend and an Express.js backend. The backend uses Multer for image uploads and MongoDB for data storage, while the frontend displays the created products. We follow the **CLEAN Architecture** for separation of concerns and a **Feature-First** approach for organizing code by features (e.g., product creation, product listing). This note is designed to be complete, referenceable, and educational, covering all code, setup, and explanations.

---

## Table of Contents
1. [Project Overview](#project-overview)
2. [Architecture Explanation](#architecture-explanation)
   - CLEAN Architecture
   - Feature-First Approach
3. [Backend: Express.js Setup (JavaScript)](#backend-expressjs-setup-javascript)
   - Project Structure
   - Dependencies
   - Implementation
4. [Frontend: Flutter Setup](#frontend-flutter-setup)
   - Project Structure
   - Dependencies
   - Implementation
5. [Testing the Application](#testing-the-application)
6. [Running the Application](#running-the-application)
7. [Conclusion and Extensions](#conclusion-and-extensions)

---

## Project Overview
The application enables users to:
- Create a product with a name, description, price, and an image via the Flutter frontend.
- Upload the image to the Express.js backend using Multer.
- Store product details in MongoDB.
- Display a list of created products in the Flutter frontend.

### Technologies
- **Backend**: Node.js, Express.js (JavaScript), Multer, MongoDB (via Mongoose).
- **Frontend**: Flutter, Dart, Dio (HTTP requests), Image Picker.
- **Architecture**: CLEAN Architecture with a Feature-First folder structure.

### Prerequisites
- Node.js (v16 or higher)
- Flutter (v3.x or higher)
- MongoDB (local or MongoDB Atlas)
- Basic knowledge of JavaScript, Dart, and REST APIs

---

## Architecture Explanation

### CLEAN Architecture
CLEAN Architecture promotes maintainable and testable code through:
- **Entities**: Core business models (e.g., Product).
- **Use Cases**: Business logic defining application behavior (e.g., CreateProduct, GetProducts).
- **Controllers/Repositories**: Interfaces between use cases and external systems (e.g., HTTP routes, database).
- **Infrastructure**: External systems (e.g., Express.js, MongoDB, Flutter UI).

Dependencies flow inward: Infrastructure depends on Use Cases, which depend on Entities. This ensures business logic is independent of frameworks or databases.

### Feature-First Approach
Code is organized by features (e.g., `product`) rather than layers (e.g., controllers). Each feature contains its entities, use cases, controllers, and repositories, making related code easier to manage.

---

## Backend: Express.js Setup (JavaScript)

### Project Structure
```
backend/
├── src/
│   ├── features/
│   │   ├── product/
│   │   │   ├── domain/
│   │   │   │   ├── entities/
│   │   │   │   │   └── product.entity.js
│   │   │   │   ├── interfaces/
│   │   │   │   │   └── product.repository.interface.js
│   │   │   ├── application/
│   │   │   │   ├── usecases/
│   │   │   │   │   ├── create-product.usecase.js
│   │   │   │   │   └── get-products.usecase.js
│   │   │   ├── infrastructure/
│   │   │   │   ├── controllers/
│   │   │   │   │   └── product.controller.js
│   │   │   │   ├── repositories/
│   │   │   │   │   └── product.repository.js
│   │   │   │   └── models/
│   │   │   │       └── product.model.js
│   ├── shared/
│   │   ├── middleware/
│   │   │   └── multer.middleware.js
│   │   └── config/
│   │       └── db.js
│   ├── app.js
│   └── server.js
├── package.json
├── .env
└── uploads/
```

### Dependencies
1. Initialize the project:
   ```bash
   mkdir backend && cd backend
   npm init -y
   npm install express mongoose multer dotenv
   npm install -D nodemon
   ```

2. Update `package.json`:
```json
{
  "name": "backend",
  "version": "1.0.0",
  "scripts": {
    "start": "nodemon src/server.js",
    "build": "node src/server.js"
  },
  "dependencies": {
    "express": "^4.18.2",
    "mongoose": "^7.0.0",
    "multer": "^1.4.5-lts.1",
    "dotenv": "^16.0.3"
  },
  "devDependencies": {
    "nodemon": "^2.0.22"
  }
}
```

### Implementation

#### 1. Environment Variables
Create `.env`:
```plaintext
MONGO_URI=mongodb://localhost:27017/product_db
PORT=3000
```

#### 2. Database Connection
Connect to MongoDB:
```javascript
// src/shared/config/db.js
const mongoose = require('mongoose');
require('dotenv').config();

const connectDB = async () => {
  try {
    await mongoose.connect(process.env.MONGO_URI);
    console.log('MongoDB connected');
  } catch (error) {
    console.error('MongoDB connection error:', error);
    process.exit(1);
  }
};

module.exports = { connectDB };
```

#### 3. Product Entity
Define the core business model:
```javascript
// src/features/product/domain/entities/product.entity.js
class Product {
  constructor({ id, name, description, price, imageUrl }) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imageUrl = imageUrl;
  }
}

module.exports = Product;
```

#### 4. Product Repository Interface
Define the interface for dependency inversion:
```javascript
// src/features/product/domain/interfaces/product.repository.interface.js
class ProductRepository {
  async create(product) {
    throw new Error('Method not implemented');
  }
  async findAll() {
    throw new Error('Method not implemented');
  }
}

module.exports = ProductRepository;
```

#### 5. Product Model
Define the MongoDB schema:
```javascript
// src/features/product/infrastructure/models/product.model.js
const mongoose = require('mongoose');

const ProductSchema = new mongoose.Schema({
  name: { type: String, required: true },
  description: { type: String, required: true },
  price: { type: Number, required: true },
  imageUrl: { type: String, required: true },
});

module.exports = mongoose.model('Product', ProductSchema);
```

#### 6. Product Repository Implementation
Implement the repository:
```javascript
// src/features/product/infrastructure/repositories/product.repository.js
const ProductRepository = require('../domain/interfaces/product.repository.interface');
const ProductModel = require('../infrastructure/models/product.model');

class ProductRepositoryImpl extends ProductRepository {
  async create(product) {
    const newProduct = new ProductModel(product);
    return await newProduct.save();
  }

  async findAll() {
    return await ProductModel.find().lean();
  }
}

module.exports = ProductRepositoryImpl;
```

#### 7. Use Cases
Define business logic for creating and fetching products:
```javascript
// src/features/product/application/usecases/create-product.usecase.js
class CreateProductUseCase {
  constructor(productRepository) {
    this.productRepository = productRepository;
  }

  async execute(product) {
    return await this.productRepository.create(product);
  }
}

module.exports = CreateProductUseCase;
```

```javascript
// src/features/product/application/usecases/get-products.usecase.js
class GetProductsUseCase {
  constructor(productRepository) {
    this.productRepository = productRepository;
  }

  async execute() {
    return await this.productRepository.findAll();
  }
}

module.exports = GetProductsUseCase;
```

#### 8. Multer Middleware
Set up Multer for image uploads:
```javascript
// src/shared/middleware/multer.middleware.js
const multer = require('multer');
const path = require('path');

const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, 'uploads/');
  },
  filename: (req, file, cb) => {
    cb(null, `${Date.now()}-${file.originalname}`);
  },
});

const fileFilter = (req, file, cb) => {
  const fileTypes = /jpeg|jpg|png/;
  const extname = fileTypes.test(path.extname(file.originalname).toLowerCase());
  const mimetype = fileTypes.test(file.mimetype);
  if (extname && mimetype) {
    cb(null, true);
  } else {
    cb(new Error('Only images (jpeg, jpg, png) are allowed'), false);
  }
};

const upload = multer({
  storage,
  fileFilter,
  limits: { fileSize: 5 * 1024 * 1024 }, // 5MB limit
});

module.exports = { upload };
```

#### 9. Product Controller
Handle HTTP requests:
```javascript
// src/features/product/infrastructure/controllers/product.controller.js
const CreateProductUseCase = require('../../application/usecases/create-product.usecase');
const GetProductsUseCase = require('../../application/usecases/get-products.usecase');
const ProductRepositoryImpl = require('../repositories/product.repository');

const productRepository = new ProductRepositoryImpl();
const createProductUseCase = new CreateProductUseCase(productRepository);
const getProductsUseCase = new GetProductsUseCase(productRepository);

class ProductController {
  async createProduct(req, res) {
    try {
      const { name, description, price } = req.body;
      const imageUrl = req.file ? `/uploads/${req.file.filename}` : '';
      const product = await createProductUseCase.execute({
        name,
        description,
        price: parseFloat(price),
        imageUrl,
      });
      res.status(201).json(product);
    } catch (error) {
      res.status(400).json({ error: error.message });
    }
  }

  async getProducts(req, res) {
    try {
      const products = await getProductsUseCase.execute();
      res.status(200).json(products);
    } catch (error) {
      res.status(500).json({ error: error.message });
    }
  }
}

module.exports = ProductController;
```

#### 10. Express App Setup
Set up the Express app:
```javascript
// src/app.js
const express = require('express');
const ProductController = require('./features/product/infrastructure/controllers/product.controller');
const { upload } = require('./shared/middleware/multer.middleware');

const app = express();
app.use(express.json());
app.use('/uploads', express.static('uploads'));

const productController = new ProductController();

app.post('/products', upload.single('image'), productController.createProduct.bind(productController));
app.get('/products', productController.getProducts.bind(productController));

module.exports = app;
```

#### 11. Server Entry Point
Start the server:
```javascript
// src/server.js
const app = require('./app');
const { connectDB } = require('./shared/config/db');
require('dotenv').config();

const PORT = process.env.PORT || 3000;

const startServer = async () => {
  await connectDB();
  app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
  });
};

startServer();
```

---

## Frontend: Flutter Setup

### Project Structure
```
flutter_app/
├── lib/
│   ├── features/
│   │   ├── product/
│   │   │   ├── domain/
│   │   │   │   ├── entities/
│   │   │   │   │   └── product.dart
│   │   │   │   ├── repositories/
│   │   │   │   │   └── product_repository.dart
│   │   │   │   ├── usecases/
│   │   │   │   │   ├── create_product.dart
│   │   │   │   │   └── get_products.dart
│   │   │   ├── data/
│   │   │   │   ├── models/
│   │   │   │   │   └── product_model.dart
│   │   │   │   ├── repositories/
│   │   │   │   │   └── product_repository_impl.dart
│   │   │   ├── presentation/
│   │   │   │   ├── pages/
│   │   │   │   │   ├── product_create_page.dart
│   │   │   │   │   └── product_list_page.dart
│   │   │   │   ├── providers/
│   │   │   │   │   └── product_provider.dart
│   ├── shared/
│   │   ├── services/
│   │   │   └── api_service.dart
│   ├── main.dart
├── pubspec.yaml
```

### Dependencies
Create a Flutter project:
```bash
flutter create flutter_app
cd flutter_app
```

Update `pubspec.yaml`:
```yaml
name: flutter_app
description: A Flutter app for product management
version: 1.0.0
environment:
  sdk: '>=2.17.0 <3.0.0'

dependencies:
  flutter:
    sdk: flutter
  dio: ^5.0.0
  image_picker: ^0.8.6
  provider: ^6.0.0
  http_parser: ^4.0.0

dev_dependencies:
  flutter_test:
    sdk: flutter
```

Run `flutter pub get` to install dependencies.

### Implementation

#### 1. Product Entity
Define the core model:
```dart
// lib/features/product/domain/entities/product.dart
class Product {
  final String? id;
  final String name;
  final String description;
  final double price;
  final String imageUrl;

  Product({
    this.id,
    required this.name,
    required this.description,
    required this.price,
    required this.imageUrl,
  });
}
```

#### 2. Product Repository Interface
Define the repository interface:
```dart
// lib/features/product/domain/repositories/product_repository.dart
import '../entities/product.dart';

abstract class ProductRepository {
  Future<Product> createProduct(Product product, String imagePath);
  Future<List<Product>> getProducts();
}
```

#### 3. Product Model
Define the data model for serialization:
```dart
// lib/features/product/data/models/product_model.dart
import '../../domain/entities/product.dart';

class ProductModel extends Product {
  ProductModel({
    String? id,
    required String name,
    required String description,
    required double price,
    required String imageUrl,
  }) : super(id: id, name: name, description: description, price: price, imageUrl: imageUrl);

  factory ProductModel.fromJson(Map<String, dynamic> json) {
    return ProductModel(
      id: json['_id'],
      name: json['name'],
      description: json['description'],
      price: json['price'].toDouble(),
      imageUrl: json['imageUrl'],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'name': name,
      'description': description,
      'price': price,
      'imageUrl': imageUrl,
    };
  }
}
```

#### 4. API Service
Handle HTTP requests with Dio:
```dart
// lib/shared/services/api_service.dart
import 'package:dio/dio.dart';
import 'package:http_parser/http_parser.dart';

class ApiService {
  final Dio _dio = Dio(BaseOptions(baseUrl: 'http://localhost:3000'));

  Future<Response> createProduct(Map<String, dynamic> data, String imagePath) async {
    FormData formData = FormData.fromMap({
      'name': data['name'],
      'description': data['description'],
      'price': data['price'],
      'image': await MultipartFile.fromFile(imagePath, contentType: MediaType('image', 'jpeg')),
    });
    return await _dio.post('/products', data: formData);
  }

  Future<List<dynamic>> getProducts() async {
    final response = await _dio.get('/products');
    return response.data;
  }
}
```

#### 5. Product Repository Implementation
Implement the repository:
```dart
// lib/features/product/data/repositories/product_repository_impl.dart
import '../../domain/entities/product.dart';
import '../../domain/repositories/product_repository.dart';
import '../models/product_model.dart';
import '../../../shared/services/api_service.dart';

class ProductRepositoryImpl implements ProductRepository {
  final ApiService _apiService;

  ProductRepositoryImpl(this._apiService);

  @override
  Future<Product> createProduct(Product product, String imagePath) async {
    final response = await _apiService.createProduct(ProductModel.fromProduct(product).toJson(), imagePath);
    return ProductModel.fromJson(response.data);
  }

  @override
  Future<List<Product>> getProducts() async {
    final data = await _apiService.getProducts();
    return data.map((json) => ProductModel.fromJson(json)).toList();
  }
}

extension on ProductModel {
  static ProductModel fromProduct(Product product) {
    return ProductModel(
      name: product.name,
      description: product.description,
      price: product.price,
      imageUrl: product.imageUrl,
    );
  }
}
```

#### 6. Use Cases
Define business logic:
```dart
// lib/features/product/domain/usecases/create_product.dart
import '../entities/product.dart';
import '../repositories/product_repository.dart';

class CreateProduct {
  final ProductRepository repository;

  CreateProduct(this.repository);

  Future<Product> call(Product product, String imagePath) async {
    return await repository.createProduct(product, imagePath);
  }
}
```

```dart
// lib/features/product/domain/usecases/get_products.dart
import '../entities/product.dart';
import '../repositories/product_repository.dart';

class GetProducts {
  final ProductRepository repository;

  GetProducts(this.repository);

  Future<List<Product>> call() async {
    return await repository.getProducts();
  }
}
```

#### 7. Product Provider
Manage state with Provider:
```dart
// lib/features/product/presentation/providers/product_provider.dart
import 'package:flutter/material.dart';
import '../../domain/entities/product.dart';
import '../../domain/usecases/create_product.dart';
import '../../domain/usecases/get_products.dart';
import '../../data/repositories/product_repository_impl.dart';
import '../../../shared/services/api_service.dart';

class ProductProvider with ChangeNotifier {
  final CreateProduct createProduct;
  final GetProducts getProducts;
  List<Product> products = [];
  bool isLoading = false;

  ProductProvider()
      : createProduct = CreateProduct(ProductRepositoryImpl(ApiService())),
        getProducts = GetProducts(ProductRepositoryImpl(ApiService()));

  Future<void> create(Product product, String imagePath) async {
    isLoading = true;
    notifyListeners();
    try {
      final newProduct = await createProduct(product, imagePath);
      products.add(newProduct);
      notifyListeners();
    } catch (e) {
      print('Error creating product: $e');
    } finally {
      isLoading = false;
      notifyListeners();
    }
  }

  Future<void> fetchProducts() async {
    isLoading = true;
    notifyListeners();
    try {
      products = await getProducts();
      notifyListeners();
    } catch (e) {
      print('Error fetching products: $e');
    } finally {
      isLoading = false;
      notifyListeners();
    }
  }
}
```

#### 8. Product Create Page
Create a UI for product creation:
```dart
// lib/features/product/presentation/pages/product_create_page.dart
import 'dart:io';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:provider/provider.dart';
import '../../domain/entities/product.dart';
import '../providers/product_provider.dart';

class ProductCreatePage extends StatefulWidget {
  @override
  _ProductCreatePageState createState() => _ProductCreatePageState();
}

class _ProductCreatePageState extends State<ProductCreatePage> {
  final _formKey = GlobalKey<FormState>();
  String _name = '';
  String _description = '';
  double _price = 0.0;
  File? _image;

  Future<void> _pickImage() async {
    final picker = ImagePicker();
    final pickedFile = await picker.pickImage(source: ImageSource.gallery);
    if (pickedFile != null) {
      setState(() {
        _image = File(pickedFile.path);
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    final provider = Provider.of<ProductProvider>(context);

    return Scaffold(
      appBar: AppBar(title: Text('Create Product')),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                decoration: InputDecoration(labelText: 'Name'),
                onChanged: (value) => _name = value,
                validator: (value) => value!.isEmpty ? 'Enter a name' : null,
              ),
              TextFormField(
                decoration: InputDecoration(labelText: 'Description'),
                onChanged: (value) => _description = value,
                validator: (value) => value!.isEmpty ? 'Enter a description' : null,
              ),
              TextFormField(
                decoration: InputDecoration(labelText: 'Price'),
                keyboardType: TextInputType.number,
                onChanged: (value) => _price = double.tryParse(value) ?? 0.0,
                validator: (value) => value!.isEmpty ? 'Enter a price' : null,
              ),
              SizedBox(height: 16),
              _image == null
                  ? Text('No image selected')
                  : Image.file(_image!, height: 100),
              ElevatedButton(
                onPressed: _pickImage,
                child: Text('Pick Image'),
              ),
              SizedBox(height: 16),
              provider.isLoading
                  ? CircularProgressIndicator()
                  : ElevatedButton(
                      onPressed: () async {
                        if (_formKey.currentState!.validate() && _image != null) {
                          final product = Product(
                            name: _name,
                            description: _description,
                            price: _price,
                            imageUrl: '', // Backend handles imageUrl
                          );
                          await provider.create(product, _image!.path);
                          Navigator.pop(context);
                        }
                      },
                      child: Text('Create Product'),
                    ),
            ],
          ),
        ),
      ),
    );
  }
}
```

#### 9. Product List Page
Display the product list:
```dart
// lib/features/product/presentation/pages/product_list_page.dart
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../providers/product_provider.dart';
import 'product_create_page.dart';

class ProductListPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final provider = Provider.of<ProductProvider>(context, listen: false);

    return Scaffold(
      appBar: AppBar(
        title: Text('Products'),
        actions: [
          IconButton(
            icon: Icon(Icons.add),
            onPressed: () => Navigator.push(
              context,
              MaterialPageRoute(builder: (_) => ProductCreatePage()),
            ),
          ),
        ],
      ),
      body: Consumer<ProductProvider>(
        builder: (context, provider, child) {
          if (provider.isLoading) {
            return Center(child: CircularProgressIndicator());
          }
          if (provider.products.isEmpty) {
            return Center(child: Text('No products found'));
          }
          return ListView.builder(
            itemCount: provider.products.length,
            itemBuilder: (context, index) {
              final product = provider.products[index];
              return ListTile(
                leading: Image.network(
                  'http://localhost:3000${product.imageUrl}',
                  width: 50,
                  height: 50,
                  errorBuilder: (context, error, stackTrace) => Icon(Icons.error),
                ),
                title: Text(product.name),
                subtitle: Text('${product.description}\n\$${product.price}'),
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => provider.fetchProducts(),
        child: Icon(Icons.refresh),
      ),
    );
  }
}
```

#### 10. Main App
Set up the app with Provider:
```dart
// lib/main.dart
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'features/product/presentation/providers/product_provider.dart';
import 'features/product/presentation/pages/product_list_page.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (_) => ProductProvider()..fetchProducts(),
      child: MaterialApp(
        title: 'Product App',
        theme: ThemeData(primarySwatch: Colors.blue),
        home: ProductListPage(),
      ),
    );
  }
}
```

---

## Testing the Application

### Backend Testing
1. Start MongoDB (local or Atlas).
2. Run the backend:
   ```bash
   cd backend
   npm start
   ```
3. Test endpoints using curl or Postman:
   ```bash
   curl -X POST http://localhost:3000/products -F "name=Test Product" -F "description=Test Description" -F "price=29.99" -F "image=@/path/to/image.jpg"
   curl http://localhost:3000/products
   ```

### Frontend Testing
1. Ensure the backend is running.
2. Run the Flutter app:
   ```bash
   cd flutter_app
   flutter run
   ```
3. Use an emulator or physical device with image access.
4. Create a product with an image and verify it appears in the list.

---

## Running the Application

### Backend
1. Create an `uploads` folder:
   ```bash
   mkdir backend/uploads
   ```
2. Ensure MongoDB is running.
3. Start the server:
   ```bash
   cd backend
   npm start
   ```

### Frontend
1. Ensure the backend is accessible at `http://localhost:3000`.
2. Run the Flutter app:
   ```bash
   cd flutter_app
   flutter run
   ```
3. For physical devices, replace `localhost` with your machine’s IP address in `api_service.dart`.

---

## Conclusion and Extensions
This note provided a complete guide to building a full-stack application with a Flutter frontend and an Express.js backend (in JavaScript) using CLEAN Architecture and a Feature-First approach. The backend handles image uploads with Multer and stores data in MongoDB, while the frontend allows product creation and listing.

### Possible Extensions
- Add authentication for secure product creation.
- Implement product updates or deletion.
- Enhance the UI with better styling or animations.
- Add error handling for network failures.
- Deploy the backend to a cloud service (e.g., Heroku) and update the frontend API base URL.

This note serves as a referenceable resource for building scalable and maintainable full-stack applications. Refer to the code snippets and structure for implementation details.