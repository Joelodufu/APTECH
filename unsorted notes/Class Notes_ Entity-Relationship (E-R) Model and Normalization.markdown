# Class Notes: Session 2 - Entity-Relationship (E-R) Model and Normalization

## Overview
This session introduces the Entity-Relationship (E-R) model and normalization, essential techniques for designing efficient relational databases in SQL Server. The E-R model helps visualize data structures and relationships, while normalization organizes data to eliminate redundancy and ensure integrity, forming the foundation for robust database design.

## Key Concepts
- **Entity-Relationship (E-R) Model**:
  - A diagrammatic approach to model database structure.
  - **Entities**: Real-world objects (e.g., Student, Course) with properties.
  - **Attributes**: Characteristics of entities (e.g., StudentID, Name, Grade).
    - **Types**: Simple (e.g., Age), Composite (e.g., Name: FirstName + LastName), Multivalued (e.g., PhoneNumbers).
  - **Relationships**: Associations between entities (e.g., Student enrolls in Course).
    - **Types**:
      - One-to-One: One entity relates to exactly one other (e.g., Person to Passport).
      - One-to-Many: One entity relates to multiple others (e.g., Department to Employees).
      - Many-to-Many: Multiple entities relate to multiple others (e.g., Students to Courses).
  - **Keys**:
    - **Primary Key**: Uniquely identifies each record in a table.
    - **Foreign Key**: A column in one table that links to the primary key of another.
- **Normalization**:
  - A systematic process to structure tables, reducing redundancy and preventing data anomalies (insertion, update, deletion).
  - **Normal Forms**:
    - **First Normal Form (1NF)**: Ensure all values are atomic (no repeating groups or arrays).
    - **Second Normal Form (2NF)**: Meet 1NF; eliminate partial dependencies (non-key attributes must depend on the entire primary key).
    - **Third Normal Form (3NF)**: Meet 2NF; remove transitive dependencies (non-key attributes depend only on the primary key, not other non-key attributes).

## Examples

### Example 1: E-R Model
**Scenario**: A school needs to track students and their courses.
- **Entities**:
  - Student (Attributes: StudentID, StudentName)
  - Course (Attributes: CourseID, CourseName)
- **Relationship**:
  - Enrollment (Attributes: Grade, links Student to Course)
- **E-R Diagram Representation**:
  - Rectangles: Entities (Student, Course)
  - Diamond: Relationship (Enrollment)
  - Lines connect Student to Enrollment and Enrollment to Course, indicating a Many-to-Many relationship.

### Example 2: Normalization
**Initial Table (Unnormalized)**:
A table with redundant data for students and courses:

| StudentID | StudentName | CourseID | CourseName | Grade |
|-----------|-------------|----------|------------|-------|
| 1         | Sam Reiner  | C101     | Math       | 85    |
| 1         | Sam Reiner  | C102     | Science    | 90    |
| 2         | John Park   | C102     | Science    | 88    |

**Problems**:
- Redundancy: StudentName and CourseName repeated.
- Anomalies: Updating CourseName for C102 requires multiple changes; deleting a student may lose course data.

**Normalization Steps**:
1. **1NF**: Ensure atomic values.
   - Data is already atomic (no repeating groups like multiple courses in one cell).
2. **2NF**: Remove partial dependencies.
   - Split table, as StudentName depends only on StudentID, and CourseName depends only on CourseID.
   - Create:
     - **Student**: (StudentID, StudentName)
     - **Course**: (CourseID, CourseName)
     - **Enrollment**: (StudentID, CourseID, Grade)
3. **3NF**: Remove transitive dependencies.
   - No non-key attributes depend on other non-key attributes; already in 3NF.

**Normalized Tables**:
- **Student**
| StudentID | StudentName |
|-----------|-------------|
| 1         | Sam Reiner  |
| 2         | John Park   |

- **Course**
| CourseID | CourseName |
|----------|------------|
| C101     | Math       |
| C102     | Science    |

- **Enrollment**
| StudentID | CourseID | Grade |
|-----------|----------|-------|
| 1         | C101     | 85    |
| 1         | C102     | 90    |
| 2         | C102     | 88    |

**SQL Implementation**:
```sql
CREATE DATABASE SchoolDB;
GO
USE SchoolDB;
GO
-- Create Student table
CREATE TABLE Student (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(50)
);
-- Create Course table
CREATE TABLE Course (
    CourseID VARCHAR(10) PRIMARY KEY,
    CourseName VARCHAR(50)
);
-- Create Enrollment table
CREATE TABLE Enrollment (
    StudentID INT,
    CourseID VARCHAR(10),
    Grade INT,
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);
-- Insert sample data
INSERT INTO Student (StudentID, StudentName)
VALUES (1, 'Sam Reiner'), (2, 'John Park');
INSERT INTO Course (CourseID, CourseName)
VALUES ('C101', 'Math'), ('C102', 'Science');
INSERT INTO Enrollment (StudentID, CourseID, Grade)
VALUES (1, 'C101', 85), (1, 'C102', 90), (2, 'C102', 88);
-- Query enrollment details
SELECT s.StudentName, c.CourseName, e.Grade
FROM Student s
JOIN Enrollment e ON s.StudentID = e.StudentID
JOIN Course c ON e.CourseID = c.CourseID;
```

**Result**:
| StudentName | CourseName | Grade |
|-------------|------------|-------|
| Sam Reiner  | Math       | 85    |
| Sam Reiner  | Science    | 90    |
| John Park   | Science    | 88    |

## Classwork
1. **E-R Diagram Design**:
   - Draw an E-R diagram for a library system:
     - **Entities**: Book (BookID, Title, Author), Borrower (BorrowerID, Name)
     - **Relationship**: Borrows (includes BorrowDate)
   - Hint: Consider the type of relationship (e.g., one borrower can borrow many books).
2. **Normalization Exercise**:
   - Start with this unnormalized table for employees:
     | EmpID | Name        | Dept     | DeptLocation |
     |-------|-------------|----------|--------------|
     | 101   | Jane Doe    | Sales    | New York     |
     | 102   | John Smith  | Sales    | New York     |
     | 103   | Bob Lee     | HR       | Chicago      |
   - Normalize it to 3NF, identifying primary and foreign keys.
   - Describe each step (1NF, 2NF, 3NF).
3. **SQL Practice**:
   - Write SQL to:
     - Create the normalized tables from the employee example.
     - Insert the sample records provided.
     - Query to display employee names and their department locations.

## Test
1. The E-R model is primarily used to:
   - A) Store data physically
   - B) Visualize entities and relationships
   - C) Optimize query performance
   - D) Encrypt database records
2. To achieve 1NF, a table must:
   - A) Have a primary key
   - B) Contain only atomic values
   - C) Remove transitive dependencies
   - D) Include foreign keys
3. A relationship where one department has many employees is:
   - A) One-to-One
   - B) One-to-Many
   - C) Many-to-Many
   - D) None of these
4. What is the purpose of normalization?
   - A) Increase data redundancy
   - B) Reduce data redundancy and prevent anomalies
   - C) Speed up queries automatically
   - D) Add more tables without purpose
5. In the table below, identify the issue and suggest a fix:
   | OrderID | CustomerName | Product1 | Product2 |
   |---------|--------------|----------|----------|
   | 1       | Alice        | Laptop   | Mouse    |
   | 2       | Bob          | Phone    | Charger   |
   - A) Issue: Non-atomic values; Fix: Split into Order and Product tables
   - B) Issue: No primary key; Fix: Add foreign keys
   - C) Issue: Transitive dependency; Fix: Remove CustomerName
   - D) Issue: No issue; Fix: None needed

**Answers:**
1. B
2. B
3. B
4. B
5. A