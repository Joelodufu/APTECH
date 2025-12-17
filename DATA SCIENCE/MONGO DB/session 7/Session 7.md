Session 7 – MongoDB Indexing
Session Overview
This session introduces MongoDB indexing, a critical concept for optimizing query performance in both Data Science and MERN stack applications. Students will learn how indexes work, their types, and their impact on search and analytics. The session balances theory with hands-on exercises, ensuring students understand how to implement and manage indexes effectively.
Duration: 2 hoursTarget Audience: Data Science learners (focus on analytics) and MERN stack learners (focus on app performance)Prerequisites: Familiarity with MongoDB CRUD operations, queries, and collections (Sessions 1–6)

Learning Objectives
By the end of this session, students will be able to:

Understand the role of indexes in MongoDB and their impact on query performance.
Create and manage different types of indexes: single field, compound, and text indexes.
Apply indexing techniques for Data Science (e.g., analytics on large datasets) and MERN stack (e.g., fast user searches).
Analyze index performance using MongoDB tools like explain().
Implement best practices for indexing in real-world applications.


Session Outline
1. Introduction to Indexing (15 minutes)
Concepts Covered:

What is an index? (A data structure to improve query performance)
Why indexing matters: Faster searches, sorting, and filtering
Trade-offs: Storage overhead vs. query speed
Use cases:
Data Science: Speeding up aggregation pipelines for large datasets
MERN: Optimizing user searches (e.g., email lookup, product search)


How MongoDB uses B-tree indexes for efficient data retrieval

Teaching Method:

Slides explaining indexing concepts with analogies (e.g., book index vs. scanning every page)
Demo: Run a slow query on a large dataset without an index, then with an index, to show performance difference.

Discussion:

Why might a Data Scientist care about indexing for analytics?
How does indexing help a MERN developer improve app performance?


2. Types of Indexes in MongoDB (20 minutes)
Concepts Covered:

Single Field Index: Index on one field (e.g., email for user login)
Compound Index: Index on multiple fields (e.g., category and price for product search)
Text Index: For full-text search (e.g., searching product descriptions or customer reviews)
Other Indexes: Multikey (arrays), geospatial, TTL (time-to-live for auto-expiring data)
Index properties: unique, sparse, partial

Teaching Method:

Diagram showing how each index type organizes data
Code demo in MongoDB Shell/Compass showing index creation and usage

Example Code (MongoDB Shell):
// Single field index
db.users.createIndex({ email: 1 });

// Compound index
db.products.createIndex({ category: 1, price: -1 });

// Text index for searching reviews
db.reviews.createIndex({ comment: "text" });


3. Hands-on Exercises (45 minutes)
Students will work on practical exercises to apply indexing concepts. Exercises are designed for both Data Science and MERN learners, with varying difficulty levels.
Basic Exercise: Creating a Single Field Index
Objective: Create an index to speed up user email lookups.Task:

Use the aptech_students database with a users collection (1000 sample documents with fields: name, email, score).
Run a query to find a user by email without an index and note the time.
Create a single field index on email.
Rerun the query and compare performance using explain().

Code:
// Sample query without index
db.users.find({ email: "student123@aptech.com" }).explain("executionStats");

// Create index
db.users.createIndex({ email: 1 });

// Rerun query with index
db.users.find({ email: "student123@aptech.com" }).explain("executionStats");

Expected Outcome: Students observe that the indexed query uses fewer operations and runs faster.

Intermediate Exercise: Compound Index for Product Search
Objective: Optimize a product search for a MERN e-commerce app.Task:

Use the products collection (fields: name, category, price, stock).
Create a compound index on category (ascending) and price (descending).
Write a query to find products in the "Electronics" category, sorted by price (high to low).
Use explain() to verify the index is used.

Code:
// Create compound index
db.products.createIndex({ category: 1, price: -1 });

// Query with sorting
db.products.find({ category: "Electronics" }).sort({ price: -1 }).explain("executionStats");

Expected Outcome: Students learn how compound indexes support multi-field queries and sorting.

Advanced Exercise: Text Index for Sentiment Analysis
Objective: Enable full-text search on customer reviews for Data Science analysis.Task:

Use the customer_reviews collection (fields: product_id, comment, rating).
Create a text index on the comment field.
Search for reviews containing "excellent" or "poor" for sentiment analysis.
Aggregate results to count positive vs. negative reviews.

Code:
// Create text index
db.customer_reviews.createIndex({ comment: "text" });

// Search for reviews
db.customer_reviews.find({ $text: { $search: "excellent" } });

// Aggregate positive vs. negative reviews
db.customer_reviews.aggregate([
  { $match: { $text: { $search: "excellent poor" } } },
  { $group: { _id: "$rating", count: { $sum: 1 } } }
]);

Expected Outcome: Students see how text indexes enable full-text search and support Data Science tasks like sentiment analysis.

4. Index Management and Best Practices (15 minutes)
Concepts Covered:

Viewing indexes: db.collection.getIndexes()
Dropping indexes: db.collection.dropIndex()
Index optimization tips:
Avoid over-indexing (increases storage and write overhead)
Use selective indexes for frequently queried fields
Monitor index usage with explain() and $indexStats


Common pitfalls: Indexing large arrays, redundant indexes

Teaching Method:

Demo: Show how to list and drop indexes
Discuss real-world scenarios: When to index, when not to

Example Code:
// List all indexes
db.users.getIndexes();

// Drop an index
db.users.dropIndex("email_1");


5. Real-Life Case Studies (15 minutes)
Case Study 1: MERN Stack – E-commerce Search Optimization

Scenario: An e-commerce app needs fast product searches by category and price.
Solution: Use a compound index on category and price.
Impact: Reduces query time from seconds to milliseconds, improving user experience.

Case Study 2: Data Science – Analyzing Customer Feedback

Scenario: A Data Scientist needs to analyze customer reviews for sentiment trends.
Solution: Use a text index on the comment field and aggregate results.
Impact: Enables rapid text searches and scalable analytics on large datasets.

Discussion:

How do indexes balance performance vs. storage in real-world apps?
How can Data Scientists use indexes to optimize aggregation pipelines?


6. Q&A and Wrap-Up (10 minutes)

Address student questions on indexing concepts or exercises.
Recap key takeaways:
Indexes improve query performance but require careful management.
Single, compound, and text indexes serve different use cases.
Use explain() to verify index usage.


Assign homework: Optimize a sample dataset with appropriate indexes and justify choices.


Assessment

Quiz (5 questions):

What is the purpose of a MongoDB index?
Name two types of indexes and their use cases.
What is the difference between a single field and a compound index?
How does explain() help in index optimization?
What is a potential downside of creating too many indexes?


Homework Assignment:

Create a MongoDB collection with 10,000 documents (use a script to generate sample data).
Identify three common queries for a MERN app or Data Science use case.
Create appropriate indexes and use explain() to compare performance before and after indexing.
Submit a short report explaining your index choices.




Resources

MongoDB Documentation: Indexes
MongoDB Atlas: Free tier for practicing cloud-based indexing
MongoDB Compass: For visualizing index performance
Blog: "Optimizing MongoDB Queries with Indexes" (search online for examples)
