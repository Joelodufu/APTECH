# Using RESTful APIs with Express.js — Class Notes

# 1. What is REST and what we’re building

**REST** = Representational State Transfer — a set of conventions for building HTTP APIs.
Goal for this lesson: build a simple **students** REST API with Express.js that can create/read/update/delete (CRUD) student records and validates input before saving.

Key endpoints we’ll make:

- `GET  /students` — list students
- `GET  /students/:id` — get one student
- `POST /students` — create student (validate input)
- `PUT  /students/:id` — update student (validate input)
- `DELETE /students/:id` — remove student

---

# 2. Step 1 — Ensure Node.js and Express are installed

1. Install Node from nodejs.org (or use nvm).
2. Make a project folder and initialize npm:

```bash
mkdir student-api
cd student-api
npm init -y
```

3. Install Express:

```bash
npm install express
```

(We’ll also install other packages below.)

---

# 3. Steps 2 & 3 — Install a schema package and a validator package

You can validate requests in different ways. The image suggests two packages (schema + validator). A simple, popular pairing:

- **Schema package** (JSON schema tool): `ajv` — validates JSON bodies against a JSON Schema file.
- **Validator package** (request-level helpers): `express-validator` — provides middleware for validating & sanitizing.

Install:

```bash
npm install ajv express-validator
```

(Alternative: use `joi` instead of `ajv` — both are fine. I’ll show `ajv` below since it uses a separate `studentSchema.json` file like the image.)

Also install `nodemon` as a dev helper:

```bash
npm install --save-dev nodemon
```

Add a start script in `package.json`:

```json
"scripts": {
  "start": "node studentRESTfulapi.js",
  "dev": "nodemon studentRESTfulapi.js"
}
```

---

# 4. Step 4 — Create the schema (`studentSchema.json`)

Create a small JSON Schema that describes a student object.

`studentSchema.json`

```json
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "required": ["firstName", "lastName", "email", "age"],
  "properties": {
    "firstName": { "type": "string", "minLength": 1 },
    "lastName": { "type": "string", "minLength": 1 },
    "email": { "type": "string", "format": "email" },
    "age": { "type": "integer", "minimum": 0 },
    "course": { "type": "string" }
  },
  "additionalProperties": false
}
```

This is the file the image refers to when it says `studentSchema.json`.

---

# 5. Step 5 & 6 — Create `studentRESTfulapi.js` and import the validator + schema

Create `studentRESTfulapi.js` with a full example: Express server, in-memory storage (simple array), Ajv-based validation, and some basic routes.

`studentRESTfulapi.js`

```js
const express = require("express");
const fs = require("fs");
const path = require("path");
const Ajv = require("ajv");

const app = express();
app.use(express.json()); // parse JSON request bodies

// Load JSON Schema (step 6 in image)
const schemaPath = path.join(__dirname, "studentSchema.json");
const studentSchema = JSON.parse(fs.readFileSync(schemaPath, "utf8"));

const ajv = new Ajv({ allErrors: true });
const validateStudent = ajv.compile(studentSchema);

// Simple in-memory "database"
let students = [];
let nextId = 1;

// Helper: run schema validation and return friendly errors
function validateBody(body) {
  const valid = validateStudent(body);
  if (valid) return null;
  // Transform Ajv errors into readable list
  return validateStudent.errors
    .map((err) => `${err.instancePath || "/"} ${err.message}`)
    .join("; ");
}

// GET /students
app.get("/students", (req, res) => {
  res.json(students);
});

// GET /students/:id
app.get("/students/:id", (req, res) => {
  const id = Number(req.params.id);
  const student = students.find((s) => s.id === id);
  if (!student) return res.status(404).json({ error: "Student not found" });
  res.json(student);
});

// POST /students (create) — step 7 in image (update code for creating a new student)
app.post("/students", (req, res) => {
  const body = req.body;
  const errors = validateBody(body);
  if (errors) {
    return res
      .status(400)
      .json({ error: "Validation failed", details: errors });
  }

  // Create new student record
  const student = { id: nextId++, ...body };
  students.push(student);
  res.status(201).json(student);
});

// PUT /students/:id (update)
app.put("/students/:id", (req, res) => {
  const id = Number(req.params.id);
  const idx = students.findIndex((s) => s.id === id);
  if (idx === -1) return res.status(404).json({ error: "Student not found" });

  const errors = validateBody(req.body);
  if (errors)
    return res
      .status(400)
      .json({ error: "Validation failed", details: errors });

  students[idx] = { id, ...req.body };
  res.json(students[idx]);
});

// DELETE /students/:id
app.delete("/students/:id", (req, res) => {
  const id = Number(req.params.id);
  const idx = students.findIndex((s) => s.id === id);
  if (idx === -1) return res.status(404).json({ error: "Student not found" });
  students.splice(idx, 1);
  res.status(204).send();
});

// Start server (step 8)
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Student API listening at http://localhost:${PORT}`);
});
```

Save this file in your project root. This is the `studentRESTfulapi.js` the image mentions.

---

# 6. Step 7 — Update the create-new-student code (we already did)

The `POST /students` route above does:

- Validate the body against `studentSchema.json`.
- If validation fails → 400 with friendly message.
- If ok → add to the in-memory `students` array and return 201 + created record.

**Note**: in production, you’d save to a database (Mongo, MySQL, etc.) instead of the in-memory array.

---

# 7. Step 8 — Start the server

Run the server:

```bash
npm run dev   # if using nodemon
# or
npm start
```

You should see:

```
Student API listening at http://localhost:3000
```

---

# 8. Step 9 — Create records of new students (test with curl or Postman)

Example curl to create one student (valid):

```bash
curl -X POST http://localhost:3000/students \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Tunde","lastName":"Adebayo","email":"tunde@example.com","age":20,"course":"Computer Science"}'
```

Expected response: `201` and the created student JSON with `id`.

Example invalid (missing required `email`):

```bash
curl -X POST http://localhost:3000/students \
  -H "Content-Type: application/json" \
  -d '{"firstName":"NoEmail","lastName":"Person","age":18}'
```

Expected: `400` with validation details.

Get all students:

```bash
curl http://localhost:3000/students
```

Get student by id:

```bash
curl http://localhost:3000/students/1
```

Update student:

```bash
curl -X PUT http://localhost:3000/students/1 \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Tunde","lastName":"New","email":"tunde@new.com","age":21}'
```

Delete student:

```bash
curl -X DELETE http://localhost:3000/students/1
```

---

# 9. Extra: Using `express-validator` (optional)

If you prefer express-validator middleware instead of Ajv, you can do quick checks like:

```js
const { body, validationResult } = require("express-validator");

app.post(
  "/students",
  body("firstName").isString().notEmpty(),
  body("email").isEmail(),
  body("age").isInt({ min: 0 }),
  (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty())
      return res.status(400).json({ errors: errors.array() });
    // create student...
  }
);
```

`express-validator` is great for quick field rules and helpful error messages. `ajv` + JSON Schema is great when you want a portable JSON Schema file (e.g., `studentSchema.json`) that other tools can reuse.

---

# 10. File structure (what you should have)

```
student-api/
├─ package.json
├─ studentRESTfulapi.js
├─ studentSchema.json
└─ node_modules/
```

---

# 11. Exercises & classwork (from basic → intermediate → advanced)

**Basic**

1. Start the server and create three student records with curl or Postman.
2. Try creating a student missing `firstName` — inspect the validation response.

**Intermediate**

1. Add a `createdAt` timestamp to each student automatically on creation.
2. Add pagination to `GET /students` (query params `?page=1&limit=10`).
3. Add search: `GET /students?name=tunde` filters by first/last name substring.

**Advanced**

1. Replace the in-memory array with a real DB (SQLite, MongoDB, or MySQL).
2. Add authentication (JWT) and make `POST/PUT/DELETE` require an authenticated user.
3. Write unit tests for your endpoints (use Jest + supertest).
4. Add rate limiting and helmet for basic security.

---

# 12. Troubleshooting common errors

- **`SyntaxError` reading JSON**: ensure `studentSchema.json` is valid JSON.
- **`EADDRINUSE`**: port already used — change `PORT` or stop the process using the port.
- **Validation “additionalProperties” errors**: schema forbids extra fields — either remove them or set `"additionalProperties": true` in your schema.

---

# 13. Short recap (one-liner per image step)

1. Install Node & Express.
2. Install schema package (e.g., `ajv`).
3. Install validator package (e.g., `express-validator`) — optional choice.
4. Write `studentSchema.json`.
5. Open (create) `studentRESTfulapi.js`.
6. Import schema and validator middleware.
7. Implement `POST /students` with validation.
8. Start the server.
9. Create student records and test your API.

---
