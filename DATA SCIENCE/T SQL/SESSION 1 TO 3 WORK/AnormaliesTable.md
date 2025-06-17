Let’s create a flawed (unnormalized) table filled with anomalies and then walk through **1NF**, **2NF**, and **3NF** normalization processes.

---

### ⚠️ Unnormalized Table: `StudentCourseScores`

| StudentID | StudentName | Courses                           | Scores         | AdvisorName | AdvisorPhone |
| --------- | ----------- | --------------------------------- | -------------- | ----------- | ------------ |
| 101       | Alice Brown | Math, English, Physics            | 85, 78, 92     | Mr. John    | 08011223344  |
| 102       | Bob Smith   | Chemistry, Math                   | 88, 90         | Ms. Rita    | 08022334455  |
| 103       | Clara Jones | Biology, Chemistry, Physics, Math | 75, 80, 89, 95 | Mr. John    | 08011223344  |

---

### 🚫 Problems (Anomalies):

- **Repeating groups** (Courses & Scores): Violates atomicity (1NF).
- **Partial dependencies**: If StudentID is the key, then `AdvisorName` and `AdvisorPhone` depend only on a portion of the data, not each course.
- **Transitive dependency**: AdvisorPhone depends on AdvisorName which depends on StudentID (via relation).

---

## ✅ First Normal Form (1NF)

**Goal**:

- No repeating groups.
- Atomic values in all fields.
- Primary key identified.

### ✅ Table: `StudentCourses` (Flattened, Atomic)

| StudentID | StudentName | Course    | Score | AdvisorName | AdvisorPhone |
| --------- | ----------- | --------- | ----- | ----------- | ------------ |
| 101       | Alice Brown | Math      | 85    | Mr. John    | 08011223344  |
| 101       | Alice Brown | English   | 78    | Mr. John    | 08011223344  |
| 101       | Alice Brown | Physics   | 92    | Mr. John    | 08011223344  |
| 102       | Bob Smith   | Chemistry | 88    | Ms. Rita    | 08022334455  |
| 102       | Bob Smith   | Math      | 90    | Ms. Rita    | 08022334455  |
| 103       | Clara Jones | Biology   | 75    | Mr. John    | 08011223344  |
| 103       | Clara Jones | Chemistry | 80    | Mr. John    | 08011223344  |
| 103       | Clara Jones | Physics   | 89    | Mr. John    | 08011223344  |
| 103       | Clara Jones | Math      | 95    | Mr. John    | 08011223344  |

- Primary Key: (`StudentID`, `Course`)

---

## ✅ Second Normal Form (2NF)

**Goal**:

- Remove partial dependencies.
- Every non-key column depends on the _whole_ primary key.

### Solution: Split into multiple related tables.

---

### Table 1: `Students`

| StudentID | StudentName | AdvisorID |
| --------- | ----------- | --------- |
| 101       | Alice Brown | 1         |
| 102       | Bob Smith   | 2         |
| 103       | Clara Jones | 1         |

---

### Table 2: `Advisors`

| AdvisorID | AdvisorName | AdvisorPhone |
| --------- | ----------- | ------------ |
| 1         | Mr. John    | 08011223344  |
| 2         | Ms. Rita    | 08022334455  |

---

### Table 3: `Courses`

| CourseID | CourseName |
| -------- | ---------- |
| 1        | Math       |
| 2        | English    |
| 3        | Physics    |
| 4        | Chemistry  |
| 5        | Biology    |

---

### Table 4: `StudentScores`

| StudentID | CourseName | Score |
| --------- | ---------- | ----- |
| 101       | Math       | 85    |
| 101       | English    | 78    |
| 101       | Physics    | 92    |
| 102       | Chemistry  | 88    |
| 102       | Math       | 90    |
| 103       | Biology    | 75    |
| 103       | Chemistry  | 80    |
| 103       | Physics    | 89    |
| 103       | Math       | 95    |

---

## ✅ Third Normal Form (3NF)

**Goal**:

- Eliminate **transitive dependencies**.
- All non-key columns must depend _only_ on the key, and _nothing but the key_.

Let’s revise:

- In `Students`, `AdvisorName` and `AdvisorPhone` have been removed and placed in the `Advisors` table.
- In `StudentScores`, course details are not repeated—only referenced via `CourseName` or `CourseID`.

### ✅ Final Tables Summary:

#### `Students`

| StudentID | StudentName | AdvisorID |
| --------- | ----------- | --------- |
| 101       | Alice Brown | 1         |
| 102       | Bob Smith   | 2         |
| 103       | Clara Jones | 1         |

#### `Advisors`

| AdvisorID | AdvisorName | AdvisorPhone |
| --------- | ----------- | ------------ |
| 1         | Mr. John    | 08011223344  |
| 2         | Ms. Rita    | 08022334455  |

#### `Courses`

| CourseID | CourseName |
| -------- | ---------- |
| 1        | Math       |
| 2        | English    |
| 3        | Physics    |
| 4        | Chemistry  |
| 5        | Biology    |

#### `StudentScores`

| StudentID | CourseID | Score |
| --------- | -------- | ----- |
| 101       | 1        | 85    |
| 101       | 2        | 78    |
| 101       | 3        | 92    |
| 102       | 4        | 88    |
| 102       | 1        | 90    |
| 103       | 5        | 75    |
| 103       | 4        | 80    |
| 103       | 3        | 89    |
| 103       | 1        | 95    |

---
