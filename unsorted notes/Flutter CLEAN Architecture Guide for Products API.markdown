# Flutter CLEAN Architecture Guide: Building a Products App

This guide walks you through implementing **CLEAN Architecture** in a Flutter application to interact with a REST API for managing products (`http://localhost:3000/api/products`). The API supports CRUD operations for products with the following structure:

```json
{
  "id": int,
  "_id": mongooseObjectID,
  "name": String,
  "description": String,
  "stock": int,
  "images": String[]
}
```

We’ll use **Provider** for state management and the **http** package for API calls, keeping dependency injection simple and manual (no `get_it` or `injectable`). By the end, you’ll have a modular, testable, and maintainable app that follows CLEAN Architecture principles.

---

## Table of Contents

1. [What is CLEAN Architecture?](#1-what-is-clean-architecture)
2. [Project Structure](#2-project-structure)
3. [Setting Up Dependencies](#3-setting-up-dependencies)
4. [Domain Layer](#4-domain-layer)
   - [Entities](#41-entities)
   - [Repository Interfaces](#42-repository-interfaces)
   - [Use Cases](#43-use-cases)
   - [Error Handling](#44-error-handling)
5. [Data Layer](#5-data-layer)
   - [Models](#51-models)
   - [Data Sources](#52-data-sources)
   - [Repository Implementations](#53-repository-implementations)
6. [Presentation Layer](#6-presentation-layer)
   - [Providers](#61-providers)
   - [Screens and Widgets](#62-screens-and-widgets)
7. [Wiring It All Together](#7-wiring-it-all-together)
8. [Running and Testing](#8-running-and-testing)
9. [Best Practices and Next Steps](#9-best-practices-and-next-steps)

---

## 1. What is CLEAN Architecture?

CLEAN Architecture, proposed by Robert C. Martin, organizes your code into layers to separate concerns, making it modular, testable, and independent of frameworks or databases. In Flutter, the layers are:

- **Presentation Layer**: Handles UI and user interaction (Widgets and Provider).
- **Domain Layer**: Contains business logic (Entities, Use Cases, Repository Interfaces).
- **Data Layer**: Manages data sources (API calls, Models, Repository Implementations).

The flow is:
- **UI** depends on **Provider** for state.
- **Provider** depends on **Use Cases**.
- **Use Cases** depend on **Repository Interfaces**.
- **Repository Interfaces** are implemented by **Repository Implementations** in the Data Layer, which use **Models** to map API data to **Entities**.

This ensures the business logic (Domain) is independent of the UI and data sources.

---

## 2. Project Structure

Organize your Flutter project as follows to keep layers separated:

```
lib/
├── data/
│   ├── models/
│   │   └── product_model.dart
│   ├── repositories/
│   │   └── product_repository_impl.dart
│   ├── data_sources/
│   │   └── remote_data_source.dart
├── domain/
│   ├── entities/
│   │   └── product.dart
│   ├── repositories/
│   │   └── product_repository.dart
│   ├── use_cases/
│   │   ├── get_products.dart
│   │   ├── create_product.dart
│   │   ├── update_product.dart
│   │   ├── delete_product.dart
│   ├── core/
│   │   ├── error/
│   │   │   ├── failures.dart
│   │   │   ├── exceptions.dart
├── presentation/
│   ├── providers/
│   │   └── product_provider.dart
│   ├── screens/
│   │   └── product_screen.dart
│   ├── widgets/
│   │   └── product_item.dart
├── main.dart
```

Each folder corresponds to a layer, keeping the codebase clean and maintainable.

---

## 3. Setting Up Dependencies

Add the following dependencies to your `pubspec.yaml` to enable state management, API calls, and functional programming for error handling:

```yaml
dependencies:
  flutter:
    sdk: flutter
  provider: ^6.0.0
  http: ^1.0.0
  dartz: ^0.10.0
```

Run `flutter pub get` to install them.

- **provider**: For state management.
- **http**: For making API requests.
- **dartz**: For functional error handling with `Either`.

---

## 4. Domain Layer

The Domain Layer is the core of your app, containing business logic and data structures independent of Flutter or external systems.

### 4.1 Entities

Entities define the business objects. For the `products` API, we create a `Product` entity.

**`lib/domain/entities/product.dart`**

```dart
class Product {
  final int id;
  final String mongooseId;
  final String name;
  final String description;
  final int stock;
  final List<String> images;

  Product({
    required this.id,
    required this.mongooseId,
    required this.name,
    required this.description,
    required this.stock,
    required this.images,
  });
}
```

This class represents a product with all required fields from the API.

### 4.2 Repository Interfaces

Define an abstract repository to specify what data operations are available, without implementing how they’re done.

**`lib/domain/repositories/product_repository.dart`**

```dart
import 'package:dartz/dartz.dart';
import '../core/error/failures.dart';
import '../entities/product.dart';

abstract class ProductRepository {
  Future<Either<Failure, List<Product>>> getProducts();
  Future<Either<Failure, Product>> createProduct(Product product);
  Future<Either<Failure, Product>> updateProduct(Product product);
  Future<Either<Failure, void>> deleteProduct(int id);
}
```

The `Either` type from `dartz` allows us to return either a `Failure` (error) or a success value (`List<Product>`, `Product`, or `void`).

### 4.3 Use Cases

Use Cases encapsulate specific business actions (e.g., fetching products, creating a product). Each use case performs one task and depends on the repository.

**`lib/domain/use_cases/get_products.dart`**

```dart
import 'package:dartz/dartz.dart';
import '../core/error/failures.dart';
import '../entities/product.dart';
import '../repositories/product_repository.dart';

class GetProducts {
  final ProductRepository repository;

  GetProducts(this.repository);

  Future<Either<Failure, List<Product>>> call() async {
    return await repository.getProducts();
  }
}
```

**`lib/domain/use_cases/create_product.dart`**

```dart
import 'package:dartz/dartz.dart';
import '../core/error/failures.dart';
import '../entities/product.dart';
import '../repositories/product_repository.dart';

class CreateProduct {
  final ProductRepository repository;

  CreateProduct(this.repository);

  Future<Either<Failure, Product>> call(Product product) async {
    return await repository.createProduct(product);
  }
}
```

**`lib/domain/use_cases/update_product.dart`**

```dart
import 'package:dartz/dartz.dart';
import '../core/error/failures.dart';
import '../entities/product.dart';
import '../repositories/product_repository.dart';

class UpdateProduct {
  final ProductRepository repository;

  UpdateProduct(this.repository);

  Future<Either<Failure, Product>> call(Product product) async {
    return await repository.updateProduct(product);
  }
}
```

**`lib/domain/use_cases/delete_product.dart`**

```dart
import 'package:dartz/dartz.dart';
import '../core/error/failures.dart';
import '../repositories/product_repository.dart';

class DeleteProduct {
  final ProductRepository repository;

  DeleteProduct(this.repository);

  Future<Either<Failure, void>> call(int id) async {
    return await repository.deleteProduct(id);
  }
}
```

Each use case is simple, delegating the actual work to the repository.

### 4.4 Error Handling

Define errors to handle API or network failures gracefully.

**`lib/domain/core/error/failures.dart`**

```dart
abstract class Failure {
  final String message;
  Failure(this.message);
}

class ServerFailure extends Failure {
  ServerFailure(String message) : super(message);
}

class NetworkFailure extends Failure {
  NetworkFailure(String message) : super(message);
}
```

**`lib/domain/core/error/exceptions.dart`**

```dart
class ServerException implements Exception {
  final String message;
  ServerException(this.message);
}

class NetworkException implements Exception {
  final String message;
  NetworkException(this.message);
}
```

These classes allow you to handle errors consistently across layers.

---

## 5. Data Layer

The Data Layer handles data retrieval and storage, mapping API responses to domain entities.

### 5.1 Models

Models extend entities and include serialization logic (`fromJson`/`toJson`) for API communication.

**`lib/data/models/product_model.dart`**

```dart
import '../../domain/entities/product.dart';

class ProductModel extends Product {
  ProductModel({
    required int id,
    required String mongooseId,
    required String name,
    required String description,
    required int stock,
    required List<String> images,
  }) : super(
          id: id,
          mongooseId: mongooseId,
          name: name,
          description: description,
          stock: stock,
          images: images,
        );

  factory ProductModel.fromJson(Map<String, dynamic> json) {
    return ProductModel(
      id: json['id'] as int,
      mongooseId: json['_id'] as String,
      name: json['name'] as String,
      description: json['description'] as String,
      stock: json['stock'] as int,
      images: List<String>.from(json['images'] as List),
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      '_id': mongooseId,
      'name': name,
      'description': description,
      'stock': stock,
      'images': images,
    };
  }
}
```

The `ProductModel` extends `Product` to inherit its properties and adds JSON serialization.

### 5.2 Data Sources

The data source handles API calls using the `http` package.

**`lib/data/data_sources/remote_data_source.dart`**

```dart
import 'dart:convert';
import 'package:http/http.dart' as http;
import '../../domain/core/error/exceptions.dart';
import '../models/product_model.dart';

class RemoteDataSource {
  final http.Client client;
  final String baseUrl = 'http://localhost:3000/api';

  RemoteDataSource(this.client);

  Future<List<ProductModel>> getProducts() async {
    final response = await client.get(Uri.parse('$baseUrl/products'));
    if (response.statusCode == 200) {
      final List<dynamic> jsonList = jsonDecode(response.body);
      return jsonList.map((json) => ProductModel.fromJson(json)).toList();
    } else {
      throw ServerException('Failed to fetch products');
    }
  }

  Future<ProductModel> createProduct(ProductModel product) async {
    final response = await client.post(
      Uri.parse('$baseUrl/products'),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(product.toJson()),
    );
    if (response.statusCode == 201) {
      return ProductModel.fromJson(jsonDecode(response.body));
    } else {
      throw ServerException('Failed to create product');
    }
  }

  Future<ProductModel> updateProduct(ProductModel product) async {
    final response = await client.put(
      Uri.parse('$baseUrl/products/${product.id}'),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(product.toJson()),
    );
    if (response.statusCode == 200) {
      return ProductModel.fromJson(jsonDecode(response.body));
    } else {
      throw ServerException('Failed to update product');
    }
  }

  Future<void> deleteProduct(int id) async {
    final response = await client.delete(Uri.parse('$baseUrl/products/$id'));
    if (response.statusCode != 204) {
      throw ServerException('Failed to delete product');
    }
  }
}
```

This class handles CRUD operations, throwing exceptions on failure.

### 5.3 Repository Implementations

The repository implementation connects the Domain Layer to the Data Layer, converting models to entities and handling errors.

**`lib/data/repositories/product_repository_impl.dart`**

```dart
import 'package:dartz/dartz.dart';
import '../../domain/core/error/failures.dart';
import '../../domain/entities/product.dart';
import '../../domain/repositories/product_repository.dart';
import '../data_sources/remote_data_source.dart';
import '../models/product_model.dart';

class ProductRepositoryImpl implements ProductRepository {
  final RemoteDataSource remoteDataSource;

  ProductRepositoryImpl(this.remoteDataSource);

  @override
  Future<Either<Failure, List<Product>>> getProducts() async {
    try {
      final productModels = await remoteDataSource.getProducts();
      return Right(productModels);
    } catch (e) {
      return Left(ServerFailure(e.toString()));
    }
  }

  @override
  Future<Either<Failure, Product>> createProduct(Product product) async {
    try {
      final productModel = ProductModel(
        id: product.id,
        mongooseId: product.mongooseId,
        name: product.name,
        description: product.description,
        stock: product.stock,
        images: product.images,
      );
      final result = await remoteDataSource.createProduct(productModel);
      return Right(result);
    } catch (e) {
      return Left(ServerFailure(e.toString()));
    }
  }

  @override
  Future<Either<Failure, Product>> updateProduct(Product product) async {
    try {
      final productModel = ProductModel(
        id: product.id,
        mongooseId: product.mongooseId,
        name: product.name,
        description: product.description,
        stock: product.stock,
        images: product.images,
      );
      final result = await remoteDataSource.updateProduct(productModel);
      return Right(result);
    } catch (e) {
      return Left(ServerFailure(e.toString()));
    }
  }

  @override
  Future<Either<Failure, void>> deleteProduct(int id) async {
    try {
      await remoteDataSource.deleteProduct(id);
      return const Right(null);
    } catch (e) {
      return Left(ServerFailure(e.toString()));
    }
  }
}
```

This maps `ProductModel` to `Product` and handles errors using `Either`.

---

## 6. Presentation Layer

The Presentation Layer manages the UI and state using **Provider**.

### 6.1 Providers

The provider manages state and interacts with use cases.

**`lib/presentation/providers/product_provider.dart`**

```dart
import 'package:flutter/material.dart';
import '../../domain/entities/product.dart';
import '../../domain/use_cases/get_products.dart';
import '../../domain/use_cases/create_product.dart';
import '../../domain/use_cases/update_product.dart';
import '../../domain/use_cases/delete_product.dart';

class ProductProvider with ChangeNotifier {
  final GetProducts getProducts;
  final CreateProduct createProduct;
  final UpdateProduct updateProduct;
  final DeleteProduct deleteProduct;

  List<Product> _products = [];
  bool _isLoading = false;
  String? _errorMessage;

  ProductProvider({
    required this.getProducts,
    required this.createProduct,
    required this.updateProduct,
    required this.deleteProduct,
  });

  List<Product> get products => _products;
  bool get isLoading => _isLoading;
  String? get errorMessage => _errorMessage;

  Future<void> fetchProducts() async {
    _isLoading = true;
    notifyListeners();

    final result = await getProducts();
    result.fold(
      (failure) {
        _errorMessage = failure.message;
        _isLoading = false;
        notifyListeners();
      },
      (products) {
        _products = products;
        _errorMessage = null;
        _isLoading = false;
        notifyListeners();
      },
    );
  }

  Future<void> addProduct(Product product) async {
    _isLoading = true;
    notifyListeners();

    final result = await createProduct(product);
    result.fold(
      (failure) {
        _errorMessage = failure.message;
        _isLoading = false;
        notifyListeners();
      },
      (product) {
        _products.add(product);
        _errorMessage = null;
        _isLoading = false;
        notifyListeners();
      },
    );
  }

  Future<void> updateProductItem(Product product) async {
    _isLoading = true;
    notifyListeners();

    final result = await updateProduct(product);
    result.fold(
      (failure) {
        _errorMessage = failure.message;
        _isLoading = false;
        notifyListeners();
      },
      (updatedProduct) {
        final index = _products.indexWhere((p) => p.id == updatedProduct.id);
        if (index != -1) {
          _products[index] = updatedProduct;
        }
        _errorMessage = null;
        _isLoading = false;
        notifyListeners();
      },
    );
  }

  Future<void> deleteProductItem(int id) async {
    _isLoading = true;
    notifyListeners();

    final result = await deleteProduct(id);
    result.fold(
      (failure) {
        _errorMessage = failure.message;
        _isLoading = false;
        notifyListeners();
      },
      (_) {
        _products.removeWhere((p) => p.id == id);
        _errorMessage = null;
        _isLoading = false;
        notifyListeners();
      },
    );
  }
}
```

This provider handles all CRUD operations and notifies the UI of state changes.

### 6.2 Screens and Widgets

Create a screen to display products and a widget for each product item.

**`lib/presentation/screens/product_screen.dart`**

```dart
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../providers/product_provider.dart';
import '../widgets/product_item.dart';

class ProductScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final productProvider = Provider.of<ProductProvider>(context);

    return Scaffold(
      appBar: AppBar(title: const Text('Products')),
      body: productProvider.isLoading
          ? const Center(child: CircularProgressIndicator())
          : productProvider.errorMessage != null
              ? Center(child: Text(productProvider.errorMessage!))
              : ListView.builder(
                  itemCount: productProvider.products.length,
                  itemBuilder: (context, index) {
                    return ProductItem(product: productProvider.products[index]);
                  },
                ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          productProvider.addProduct(Product(
            id: 0, // API will assign
            mongooseId: '',
            name: 'New Product',
            description: 'Description',
            stock: 10,
            images: [],
          ));
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}
```

**`lib/presentation/widgets/product_item.dart`**

```dart
import 'package:flutter/material.dart';
import '../../domain/entities/product.dart';
import '../providers/product_provider.dart';
import 'package:provider/provider.dart';

class ProductItem extends StatelessWidget {
  final Product product;

  const ProductItem({required this.product});

  @override
  Widget build(BuildContext context) {
    final productProvider = Provider.of<ProductProvider>(context, listen: false);

    return ListTile(
      title: Text(product.name),
      subtitle: Text(product.description),
      trailing: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          Text('Stock: ${product.stock}'),
          IconButton(
            icon: const Icon(Icons.edit),
            onPressed: () {
              productProvider.updateProductItem(
                Product(
                  id: product.id,
                  mongooseId: product.mongooseId,
                  name: '${product.name} Updated',
                  description: product.description,
                  stock: product.stock + 1,
                  images: product.images,
                ),
              );
            },
          ),
          IconButton(
            icon: const Icon(Icons.delete),
            onPressed: () {
              productProvider.deleteProductItem(product.id);
            },
          ),
        ],
      ),
    );
  }
}
```

The `ProductScreen` displays a list of products, and `ProductItem` shows individual product details with update and delete buttons.

---

## 7. Wiring It All Together

Set up the app in `main.dart`, manually injecting dependencies and providing the `ProductProvider`.

**`lib/main.dart`**

```dart
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:http/http.dart' as http;
import 'data/data_sources/remote_data_source.dart';
import 'data/repositories/product_repository_impl.dart';
import 'domain/use_cases/get_products.dart';
import 'domain/use_cases/create_product.dart';
import 'domain/use_cases/update_product.dart';
import 'domain/use_cases/delete_product.dart';
import 'presentation/providers/product_provider.dart';
import 'presentation/screens/product_screen.dart';

void main() {
  // Manual Dependency Injection
  final client = http.Client();
  final remoteDataSource = RemoteDataSource(client);
  final productRepository = ProductRepositoryImpl(remoteDataSource);

  final getProducts = GetProducts(productRepository);
  final createProduct = CreateProduct(productRepository);
  final updateProduct = UpdateProduct(productRepository);
  final deleteProduct = DeleteProduct(productRepository);

  runApp(MyApp(
    productProvider: ProductProvider(
      getProducts: getProducts,
      createProduct: createProduct,
      updateProduct: updateProduct,
      deleteProduct: deleteProduct,
    ),
  ));
}

class MyApp extends StatelessWidget {
  final ProductProvider productProvider;

  MyApp({required this.productProvider});

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider.value(
      value: productProvider,
      child: MaterialApp(
        title: 'Products App',
        theme: ThemeData(primarySwatch: Colors.blue),
        home: ProductScreen(),
      ),
    );
  }
}
```

This sets up the app, injects dependencies, and provides the `ProductProvider` to the widget tree.

---

## 8. Running and Testing

1. **Start the Backend**: Ensure your API server is running at `http://localhost:3000`.
2. **Run the App**: Use `flutter run` to launch the app.
3. **Test CRUD Operations**:
   - The `ProductScreen` fetches and displays products on load.
   - Use the Floating Action Button to add a new product.
   - Use the edit and delete buttons in `ProductItem` to update or delete products.
4. **Verify Errors**: If the API is down, the UI will display error messages from the provider.

---

## 9. Best Practices and Next Steps

- **Error Handling**: Use the `errorMessage` in `ProductProvider` to show user-friendly error messages (e.g., via SnackBars).
- **Testing**: Write unit tests for use cases (mock the repository) and widget tests for the UI (mock the provider).
- **Input Forms**: Extend the UI with a form to create/update products instead of hardcoding values.
- **API Adjustments**: If your API differs (e.g., different endpoints or status codes), update the `RemoteDataSource` accordingly.
- **Scalability**: Add more features (e.g., filtering products) by creating new use cases and updating the provider.

This guide provides a complete, working implementation of CLEAN Architecture in Flutter for the `products` API. You can extend it by adding more UI features or handling additional APIs in