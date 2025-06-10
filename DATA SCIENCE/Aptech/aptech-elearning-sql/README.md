# Aptech E-Learning Platform Database

## Overview
This project contains the SQL schema for managing CRUD operations for the Aptech e-learning platform. The schema is designed to facilitate the management of users, courses, modules, enrollments, and assessments.

## Files Structure
- **schema/**
  - **01_create_database.sql**: Contains the SQL command to create the `AptechDatabase`.
  - **02_tables.sql**: Defines the tables required for managing CRUD operations.
  - **03_relationships.sql**: Establishes foreign key relationships between the tables.
  - **04_indexes.sql**: Creates indexes on frequently queried columns.
  - **05_views.sql**: Defines views for common queries.
  - **06_stored_procedures.sql**: Contains stored procedures for common operations.
  - **07_triggers.sql**: Defines triggers for automatic actions.

## Setup Instructions
1. Execute `01_create_database.sql` to create the database.
2. Run `02_tables.sql` to create the necessary tables.
3. Execute `03_relationships.sql` to set up foreign key relationships.
4. Run `04_indexes.sql` to create indexes for performance optimization.
5. Execute `05_views.sql` to create views for common queries.
6. Run `06_stored_procedures.sql` to set up stored procedures.
7. Execute `07_triggers.sql` to define triggers for automatic actions.

## Usage
After setting up the database, you can perform CRUD operations using the defined tables, views, and stored procedures. The triggers will help maintain data integrity and automate certain actions within the database.

## License
This project is licensed under the MIT License.