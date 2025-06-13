# Supermarket Inventory Database Schema

This document outlines the database schema for a well-managed inventory system in a modern supermarket. The schema supports barcode scanning, product search, inventory tracking, and related operations. It is designed as a relational database model with tables, fields, data types, constraints, and relationships.

## 1. Products Table
Stores core information about each product.

| Field Name       | Data Type       | Constraints                     | Description                                  |
|------------------|-----------------|---------------------------------|----------------------------------------------|
| ProductID        | Integer/BigInt  | Primary Key                     | Unique identifier for the product.           |
| ProductName      | Varchar(100)    | Not Null                        | Name of the product (e.g., "Organic Milk 1L").|
| Barcode          | Varchar(50)     | Unique, Not Null                | Barcode (UPC, EAN) for scanning.             |
| Description      | Text            | Nullable                        | Detailed description of the product.         |
| CategoryID       | Integer         | Foreign Key (Categories)        | Links to the product category.               |
| BrandID          | Integer         | Foreign Key (Brands)            | Links to the product brand.                  |
| UnitPrice        | Decimal(10,2)   | Not Null                        | Price per unit (e.g., 3.99).                 |
| CostPrice        | Decimal(10,2)   | Not Null                        | Cost to the supermarket per unit.            |
| SKU              | Varchar(50)     | Unique, Not Null                | Stock Keeping Unit (internal identifier).    |
| Weight           | Decimal(10,2)   | Nullable                        | Weight of the product (e.g., in kg).         |
| Dimensions       | Varchar(50)     | Nullable                        | Size of the product (e.g., "10x5x3 cm").     |
| IsActive         | Boolean         | Default: True                   | Indicates if the product is available.       |
| CreatedAt        | Timestamp       | Not Null                        | Date and time the product was added.         |
| UpdatedAt        | Timestamp       | Not Null                        | Date and time of the last update.            |

## 2. Categories Table
Organizes products into categories for search and management.

| Field Name        | Data Type       | Constraints                     | Description                                  |
|-------------------|-----------------|---------------------------------|----------------------------------------------|
| CategoryID        | Integer         | Primary Key                     | Unique identifier for the category.          |
| CategoryName      | Varchar(50)     | Not Null                        | Name of the category (e.g., "Dairy").        |
| ParentCategoryID  | Integer         | Foreign Key (Categories), Nullable | For hierarchical categories (e.g., "Milk"). |
| Description       | Text            | Nullable                        | Optional description of the category.        |

## 3. Brands Table
Stores brand information for products.

| Field Name       | Data Type       | Constraints                     | Description                                  |
|------------------|-----------------|---------------------------------|----------------------------------------------|
| BrandID          | Integer         | Primary Key                     | Unique identifier for the brand.             |
| BrandName        | Varchar(50)     | Not Null                        | Name of the brand (e.g., "Nestlé").          |
| ManufacturerInfo | Text            | Nullable                        | Details about the manufacturer.              |

## 4. Inventory Table
Tracks stock levels and inventory-related data.

| Field Name       | Data Type       | Constraints                     | Description                                  |
|------------------|-----------------|---------------------------------|----------------------------------------------|
| InventoryID      | Integer         | Primary Key                     | Unique identifier for inventory records.     |
| ProductID        | Integer         | Foreign Key (Products)          | Links to the product.                        |
| StoreID          | Integer         | Foreign Key (Stores)            | Links to the store location.                 |
| QuantityInStock  | Integer         | Not Null, Default: 0            | Current stock level.                         |
| ReorderLevel     | Integer         | Not Null                        | Minimum stock level before reordering.       |
| ReorderQuantity  | Integer         | Not Null                        | Quantity to order when stock is low.         |
| LastRestocked    | Timestamp       | Nullable                        | Date of the last restock.                    |
| ExpiryDate       | Date            | Nullable                        | Expiry date for perishable items.            |

## 5. Stores Table
Manages information for different store locations.

| Field Name       | Data Type       | Constraints                     | Description                                  |
|------------------|-----------------|---------------------------------|----------------------------------------------|
| StoreID          | Integer         | Primary Key                     | Unique identifier for the store.             |
| StoreName        | Varchar(50)     | Not Null                        | Name of the store.                           |
| Location         | Varchar(200)    | Not Null                        | Address or location details.                 |
| ContactInfo      | Varchar(100)    | Nullable                        | Phone or email for the store.                |

## 6. Transactions Table
Records sales transactions for tracking product movement.

| Field Name       | Data Type       | Constraints                     | Description                                  |
|------------------|-----------------|---------------------------------|----------------------------------------------|
| TransactionID    | Integer         | Primary Key                     | Unique identifier for the transaction.       |
| ProductID        | Integer         | Foreign Key (Products)          | Links to the product sold.                   |
| StoreID          | Integer         | Foreign Key (Stores)            | Links to the store where the sale occurred.  |
| QuantitySold     | Integer         | Not Null                        | Number of units sold.                        |
| SalePrice        | Decimal(10,2)   | Not Null                        | Price at which the product was sold.         |
| TransactionDate  | Timestamp       | Not Null                        | Date and time of the sale.                   |
| CashierID        | Integer         | Foreign Key (Staff), Nullable   | Links to the staff member (if tracked).      |

## 7. Suppliers Table
Manages supplier information for restocking.

| Field Name       | Data Type       | Constraints                     | Description                                  |
|------------------|-----------------|---------------------------------|----------------------------------------------|
| SupplierID       | Integer         | Primary Key                     | Unique identifier for the supplier.          |
| SupplierName     | Varchar(100)    | Not Null                        | Name of the supplier.                        |
| ContactInfo      | Varchar(100)    | Nullable                        | Contact details (phone, email).              |
| Address          | Varchar(200)    | Nullable                        | Supplier’s address.                          |

## 8. ProductSuppliers Table
Links products to their suppliers (many-to-many relationship).

| Field Name       | Data Type       | Constraints                     | Description                                  |
|------------------|-----------------|---------------------------------|----------------------------------------------|
| ProductID        | Integer         | Foreign Key (Products)          | Links to the product.                        |
| SupplierID       | Integer         | Foreign Key (Suppliers)         | Links to the supplier.                       |
| SupplyPrice      | Decimal(10,2)   | Not Null                        | Cost of the product from this supplier.      |
| LeadTimeDays     | Integer         | Not Null                        | Time taken for delivery (in days).           |

## Relationships
- `Products.CategoryID` → `Categories.CategoryID` (Many-to-One)
- `Products.BrandID` → `Brands.BrandID` (Many-to-One)
- `Inventory.ProductID` → `Products.ProductID` (Many-to-One)
- `Inventory.StoreID` → `Stores.StoreID` (Many-to-One)
- `Transactions.ProductID` → `Products.ProductID` (Many-to-One)
- `Transactions.StoreID` → `Stores.StoreID` (Many-to-One)
- `ProductSuppliers.ProductID` → `Products.ProductID` (Many-to-Many)
- `ProductSuppliers.SupplierID` → `Suppliers.SupplierID` (Many-to-Many)

## Notes
- **Primary Keys**: Ensure unique identification of records.
- **Foreign Keys**: Enforce referential integrity between tables.
- **Indexes**: Recommended on `Products.Barcode`, `Products.SKU`, `Products.ProductName`, and `Categories.CategoryName` for faster searches.
- **Scalability**: For large chains, consider partitioning `Inventory` and `Transactions` by `StoreID` or date.
- **Perishable Goods**: The `ExpiryDate` in `Inventory` supports tracking perishables.
- **Barcode Scanning**: The `Barcode` field in `Products` integrates with POS systems for quick lookups.
- **Product Search**: Fields like `ProductName`, `Barcode`, `SKU`, `CategoryID`, and `BrandID` enable robust search functionality.

This schema provides a solid foundation for managing inventory in a supermarket, supporting barcode scanning, product search, stock tracking, and supplier management.