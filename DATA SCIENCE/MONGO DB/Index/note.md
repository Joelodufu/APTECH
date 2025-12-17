

# 📘 Class Notes: Advanced Indexing in MongoDB

---

## 1. Text Index

- **Concept**:
  Text indexes support text search on string content. Useful for searching documents by keywords.
  Only **one text index per collection**.

- **Syntax**:

  ```js
  db.collection.createIndex({ fieldName: "text" });
  ```

- **Example**:

  ```js
  db.articles.createIndex({ content: "text" });
  ```

- **Use Case**:

  - Searching blogs, product descriptions, or news articles.

- **Extra**:

  - Supports `$text` operator with `$search`, `$caseSensitive`, `$diacriticSensitive`.

---

## 2. Wildcard Index

- **Concept**:
  Wildcard indexes are dynamic indexes that allow you to index **unknown fields or subdocuments** without explicitly naming them.

- **Syntax**:

  ```js
  db.collection.createIndex({ "fieldPath.$**": 1 });
  ```

- **Example**:

  ```js
  db.profiles.createIndex({ "contact.$**": 1 });
  ```

- **Use Case**:

  - Flexible indexing for JSON data with unpredictable fields.

---

## 3. Wildcard Index on All Fields

- **Concept**:
  Index every field and subfield in the collection.

- **Syntax**:

  ```js
  db.collection.createIndex({ "$**": 1 });
  ```

- **Example**:

  ```js
  db.profiles.createIndex({ "$**": 1 });
  ```

- **Use Case**:

  - When collection fields are highly dynamic and queries can target any field.

- **Note**:
  May cause performance and storage overhead.

---

## 4. Wildcard Index Including/Excluding Multiple Fields

- **Concept**:
  Control which fields get wildcard indexed using `wildcardProjection`.

- **Syntax**:

  ```js
  db.collection.createIndex(
    { "$**": 1 },
    { wildcardProjection: { fieldToInclude: 1, fieldToExclude: 0 } }
  );
  ```

- **Example**:

  ```js
  db.profiles.createIndex(
    { "$**": 1 },
    { wildcardProjection: { name: 1, email: 1, password: 0 } }
  );
  ```

- **Use Case**:

  - Include sensitive fields selectively.
  - Exclude heavy arrays or binary data.

---

## 5. Hashed Index

- **Concept**:
  Index that stores hash of field values → useful for **sharding** and evenly distributing data.

- **Syntax**:

  ```js
  db.collection.createIndex({ fieldName: "hashed" });
  ```

- **Example**:

  ```js
  db.users.createIndex({ email: "hashed" });
  ```

- **Use Case**:

  - Equality queries (`{ email: "abc@example.com" }`).
  - Efficient shard key for load balancing.

- **Note**:
  Cannot be used for range queries.

---

## 6. Drop Indexes

- **Concept**:
  Remove indexes that are no longer needed.

- **Syntax**:

  ```js
  db.collection.dropIndex("indexName");
  db.collection.dropIndexes(); // drops all except _id
  ```

- **Example**:

  ```js
  db.articles.dropIndex("content_text");
  ```

- **Use Case**:

  - Free up storage space.
  - Improve write performance when indexes are unnecessary.

---
