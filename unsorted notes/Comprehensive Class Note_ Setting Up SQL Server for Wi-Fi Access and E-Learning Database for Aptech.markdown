# Comprehensive Class Note: Setting Up SQL Server for Wi-Fi Access and E-Learning Database for Aptech

This class note guides you through setting up a Microsoft SQL Server (MSSQL) database for remote access via Wi-Fi using SQL Server Management Studio (SSMS). Students at Aptech will connect to a shared database, create tables, and query them for an e-learning platform. All examples use entities relevant to an e-learning system for Aptech, such as students, courses, instructors, and enrollments.

---

## 1. Overview
**Goal**: Enable students to:
- Connect to a SQL Server database over Wi-Fi.
- Create tables with relationships (primary and foreign keys) for an e-learning platform.
- Query and manage data using SSMS.
- Practice SQL skills collaboratively for Aptech's e-learning system.

**Prerequisites**:
- SQL Server (e.g., Express, Developer, or Standard edition) installed on a host computer (teacher’s machine or server).
- SSMS installed on the host and all student computers.
- All devices connected to the same Wi-Fi network (e.g., Aptech’s school Wi-Fi).
- Administrative access to the host machine for setup.
- Basic SQL knowledge (e.g., CREATE, INSERT, SELECT).

**Database Theme**: We’ll create an `AptechELearning` database to manage students, courses, instructors, and enrollments for an e-learning platform.

---

## 2. Setting Up SQL Server for Wi-Fi Access

### 2.1. Configure SQL Server for Remote Connections
SQL Server needs to allow connections from other devices on the Wi-Fi network.

- **Step 1: Enable Remote Connections**
  - Open SSMS on the host machine.
  - Connect to the SQL Server instance (e.g., `localhost` or server name) using Windows Authentication.
  - Right-click the server name in Object Explorer, select **Properties**.
  - Go to the **Connections** page.
  - Check **Allow remote connections to this server**.
  - Click **OK**.
- **Step 2: Enable SQL Server Authentication**
  - In SSMS, right-click the server, select **Properties**.
  - Go to the **Security** page.
  - Select **SQL Server and Windows Authentication mode**.
  - Click **OK**.
- **Step 3: Restart SQL Server**
  - Open **SQL Server Configuration Manager** (Start > SQL Server Configuration Manager).
  - Go to **SQL Server Services**.
  - Right-click **SQL Server (Your Instance Name)**, select **Restart**.

### 2.2. Configure Network Settings
Enable protocols and services for Wi-Fi connections.

- **Step 1: Enable TCP/IP**
  - In SQL Server Configuration Manager, go to **SQL Server Network Configuration** > **Protocols for [Your Instance Name]**.
  - Right-click **TCP/IP**, select **Enable**.
  - Double-click **TCP/IP**, go to the **IP Addresses** tab.
  - Scroll to **IPAll**, ensure **TCP Port** is set to `1433` (default port).
  - Click **OK**.
- **Step 2: Enable SQL Server Browser**
  - In SQL Server Configuration Manager, go to **SQL Server Services**.
  - Right-click **SQL Server Browser**, select **Properties**.
  - Set **Start Mode** to **Automatic**.
  - Right-click **SQL Server Browser**, select **Start** if not running.
- **Step 3: Restart SQL Server**
  - Right-click **SQL Server (Your Instance Name)**, select **Restart**.

### 2.3. Configure Windows Firewall
Allow SQL Server traffic through the firewall on the host machine.

- **Step 1: Open Firewall Settings**
  - On the host, go to **Control Panel** > **Windows Defender Firewall** > **Advanced Settings**.
- **Step 2: Create Inbound Rules**
  - Right-click **Inbound Rules**, select **New Rule**.
  - **Rule for TCP Port 1433**:
    - Select **Port**, then **TCP**.
    - Enter `1433` as the specific local port.
    - Choose **Allow the connection**.
    - Apply to all profiles (Domain, Private, Public).
    - Name it “SQL Server TCP 1433”, click **Finish**.
  - **Rule for UDP Port 1434 (SQL Server Browser)**:
    - Select **Port**, then **UDP**.
    - Enter `1434` as the specific local port.
    - Choose **Allow the connection**.
    - Name it “SQL Server Browser UDP 1434”, click **Finish**.
  - **Optional Program Rule**:
    - Select **Program**.
    - Browse to `sqlservr.exe` (e.g., `C:\Program Files\Microsoft SQL Server\MSSQLXX.MSSQLSERVER\MSSQL\Binn`).
    - Allow the connection, name it “SQL Server Program”, click **Finish**.

### 2.4. Find the Host Machine’s IP Address
Students need the host’s IP address to connect via Wi-Fi.

- **Step 1: Check IP Address**
  - On the host machine, open Command Prompt (cmd).
  - Type `ipconfig` and press Enter.
  - Look under your Wi-Fi adapter (e.g., “Wireless LAN adapter Wi-Fi”).
  - Note the **IPv4 Address** (e.g., `192.168.1.100`).
- **Step 2: Share with Students**
  - Provide the IP address (e.g., `192.168.1.100`) and the SQL Server instance name (if not default, e.g., `SQLEXPRESS`).

### 2.5. Create Student Logins
Each student needs a login to access the database securely.

- **Step 1: Create Logins**
  - In SSMS on the host, expand **Security**, right-click **Logins**, select **New Login**.
  - **Login Name**: Enter a name (e.g., `AptechStudent1`).
  - Select **SQL Server Authentication**.
  - Enter a strong password (e.g., `Aptech2025!`).
  - Uncheck **Enforce password policy** (optional for class).
  - Set **Default database** to `AptechELearning`.
  - Go to **User Mapping**, check `AptechELearning`, and assign roles:
    - `db_datareader`: Read data.
    - `db_datawriter`: Write data.
    - `db_ddladmin`: Create and modify tables.
  - Click **OK**.
  - Repeat for each student (e.g., `AptechStudent2`, `AptechStudent3`).
- **Step 2: Grant Permissions**
  - Run this SQL to ensure students can create tables:
    ```sql
    USE AptechELearning;
    GRANT CREATE TABLE, ALTER, SELECT, INSERT, UPDATE, DELETE TO AptechStudent1;
    ```
  - Repeat for each student login.

---

## 3. Create the Aptech E-Learning Database

### 3.1. Create the Database
Set up a database named `AptechELearning` for the e-learning platform.

- **SQL Script**:
  ```sql
  IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'AptechELearning')
      CREATE DATABASE AptechELearning;
  USE AptechELearning;
  ```

### 3.2. Design Tables for Aptech E-Learning
We’ll create tables for an e-learning system: Students, Courses, Instructors, Enrollments, and Lessons.

- **Students Table**: Stores student info for Aptech learners.
  ```sql
  CREATE TABLE Students (
      StudentID INT PRIMARY KEY,
      FirstName VARCHAR(50) NOT NULL,
      LastName VARCHAR(50) NOT NULL,
      Email VARCHAR(100) UNIQUE NOT NULL,
      RegistrationDate DATE
  );
  ```
- **Courses Table**: Stores Aptech course details.
  ```sql
  CREATE TABLE Courses (
      CourseID INT PRIMARY KEY,
      CourseName VARCHAR(100) NOT NULL,
      CourseCode VARCHAR(20) UNIQUE NOT NULL,
      Credits INT,
      Description VARCHAR(255)
  );
  ```
- **Instructors Table**: Stores Aptech instructor info.
  ```sql
  CREATE TABLE Instructors (
      InstructorID INT PRIMARY KEY,
      FirstName VARCHAR(50) NOT NULL,
      LastName VARCHAR(50) NOT NULL,
      Email VARCHAR(100) UNIQUE NOT NULL,
      HireDate DATE
  );
  ```
- **Enrollments Table**: Links students to courses.
  ```sql
  CREATE TABLE Enrollments (
      EnrollmentID INT PRIMARY KEY,
      StudentID INT,
      CourseID INT,
      EnrollmentDate DATE NOT NULL,
      Grade VARCHAR(2),
      FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
      FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
  );
  ```
- **Lessons Table**: Stores lesson details for each course.
  ```sql
  CREATE TABLE Lessons (
      LessonID INT PRIMARY KEY,
      CourseID INT,
      InstructorID INT,
      LessonTitle VARCHAR(100) NOT NULL,
      LessonDate DATE,
      DurationMinutes INT,
      FOREIGN KEY (CourseID) REFERENCES Courses(CourseID),
      FOREIGN KEY (InstructorID) REFERENCES Instructors(InstructorID)
  );
  ```

### 3.3. Insert Sample Data
Add sample data to test the database.

- **Students**:
  ```sql
  INSERT INTO Students (StudentID, FirstName, LastName, Email, RegistrationDate)
  VALUES 
  (1, 'Aisha', 'Khan', 'aisha.khan@aptech.com', '2025-01-15'),
  (2, 'Michael', 'Okafor', 'michael.okafor@aptech.com', '2025-02-01'),
  (3, 'Priya', 'Sharma', 'priya.sharma@aptech.com', '2025-03-10');
  ```
- **Courses**:
  ```sql
  INSERT INTO Courses (CourseID, CourseName, CourseCode, Credits, Description)
  VALUES 
  (1, 'Python Programming', 'AP-PY101', 3, 'Intro to Python for Aptech students'),
  (2, 'Web Development', 'AP-WD201', 4, 'HTML, CSS, and JS basics'),
  (3, 'Database Design', 'AP-DB301', 3, 'SQL and database concepts');
  ```
- **Instructors**:
  ```sql
  INSERT INTO Instructors (InstructorID, FirstName, LastName, Email, HireDate)
  VALUES 
  (1, 'Dr. John', 'Adeyemi', 'john.adeyemi@aptech.com', '2023-06-01'),
  (2, 'Prof. Sara', 'Patel', 'sara.patel@aptech.com', '2024-01-15');
  ```
- **Enrollments**:
  ```sql
  INSERT INTO Enrollments (EnrollmentID, StudentID, CourseID, EnrollmentDate, Grade)
  VALUES 
  (1, 1, 1, '2025-06-01', NULL),
  (2, 2, 1, '2025-06-01', 'B+'),
  (3, 3, 2, '2025-06-02', NULL);
  ```
- **Lessons**:
  ```sql
  INSERT INTO Lessons (LessonID, CourseID, InstructorID, LessonTitle, LessonDate, DurationMinutes)
  VALUES 
  (1, 1, 1, 'Python Variables', '2025-06-10', 60),
  (2, 1, 1, 'Python Loops', '2025-06-12', 45),
  (3, 2, 2, 'HTML Basics', '2025-06-11', 90);
  ```

---

## 4. Connecting to the Database via Wi-Fi

### 4.1. Student Instructions
Students will use SSMS to connect to the `AptechELearning` database over Wi-Fi.

- **Step 1: Open SSMS**
  - Launch SQL Server Management Studio on your computer.
- **Step 2: Connect to Server**
  - In the **Connect to Server** dialog:
    - **Server name**: Enter the host machine’s IP address and instance name (e.g., `192.168.1.100` or `192.168.1.100\SQLEXPRESS`).
    - **Authentication**: Select **SQL Server Authentication**.
    - **Login**: Enter your assigned username (e.g., `AptechStudent1`).
    - **Password**: Enter your assigned password (e.g., `Aptech2025!`).
    - Click **Connect**.
- **Step 3: Verify Connection**
  - In Object Explorer, expand the server, then **Databases**.
  - Ensure `AptechELearning` appears.
  - Test with a simple query:
    ```sql
    USE AptechELearning;
    SELECT * FROM Students;
    ```

### 4.2. Troubleshooting
- **Login Failed (Error 18456)**: Check username and password. Ensure SQL Server Authentication is enabled.
- **Cannot Connect**: Verify the IP address, instance name, and port (1433). Ensure the host’s firewall allows connections.
- **Ask Your Instructor**: If issues persist, note the error and contact the teacher.

---

## 5. Classwork: Creating Tables and Querying
Practice creating tables and querying the `AptechELearning` database.

### 5.1. Task 1: Create a New Table
Create a table for `Assignments` to track student assignments at Aptech.

- **SQL Script**:
  ```sql
  USE AptechELearning;
  CREATE TABLE Assignments (
      AssignmentID INT PRIMARY KEY,
      CourseID INT,
      LessonID INT,
      AssignmentTitle VARCHAR(100) NOT NULL,
      DueDate DATE NOT NULL,
      MaxScore INT,
      FOREIGN KEY (CourseID) REFERENCES Courses(CourseID),
      FOREIGN KEY (LessonID) REFERENCES Lessons(LessonID)
  );
  ```
- **Insert Sample Data**:
  ```sql
  INSERT INTO Assignments (AssignmentID, CourseID, LessonID, AssignmentTitle, DueDate, MaxScore)
  VALUES 
  (1, 1, 1, 'Python Variables Quiz', '2025-06-15', 100),
  (2, 2, 3, 'Build a Webpage', '2025-06-20', 150);
  ```

### 5.2. Task 2: Query the Database
Write queries to explore the e-learning data.

- **Query 1: List All Students**
  ```sql
  SELECT FirstName, LastName, Email
  FROM Students;
  ```
- **Query 2: Find Courses and Enrolled Students**
  ```sql
  SELECT s.FirstName, s.LastName, c.CourseName, e.EnrollmentDate
  FROM Students s
  JOIN Enrollments e ON s.StudentID = e.StudentID
  JOIN Courses c ON e.CourseID = c.CourseID;
  ```
- **Query 3: List Lessons by Instructor**
  ```sql
  SELECT i.FirstName, i.LastName, l.LessonTitle, c.CourseName
  FROM Instructors i
  JOIN Lessons l ON i.InstructorID = l.InstructorID
  JOIN Courses c ON l.CourseID = c.CourseID;
  ```

### 5.3. Task 3: Advanced Practice
- **Create a Table**: Design a `Grades` table to store student assignment grades, linking to `Students` and `Assignments`.
- **SQL Example**:
  ```sql
  CREATE TABLE Grades (
      GradeID INT PRIMARY KEY,
      StudentID INT,
      AssignmentID INT,
      Score INT,
      SubmissionDate DATE,
      FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
      FOREIGN KEY (AssignmentID) REFERENCES Assignments(AssignmentID)
  );
  ```
- **Insert and Query**:
  - Insert a sample grade: `INSERT INTO Grades (GradeID, StudentID, AssignmentID, Score, SubmissionDate) VALUES (1, 1, 1, 85, '2025-06-14');`
  - Query grades: `SELECT s.FirstName, s.LastName, a.AssignmentTitle, g.Score FROM Students s JOIN Grades g ON s.StudentID = g.StudentID JOIN Assignments a ON g.AssignmentID = a.AssignmentID;`

---

## 6. Collaboration Tips
- **Avoid Conflicts**: Use unique table prefixes (e.g., `AptechStudent1_Assignments`) for each student’s work.
  ```sql
  CREATE TABLE AptechStudent1_Assignments (
      AssignmentID INT PRIMARY KEY,
      CourseID INT,
      AssignmentTitle VARCHAR(100) NOT NULL,
      DueDate DATE,
      FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
  );
  ```
- **Backup Database**: Before class, back up the database to avoid data loss:
  ```sql
  BACKUP DATABASE AptechELearning
  TO DISK = 'C:\Backups\AptechELearning.bak';
  ```
- **Safety**: Do not drop tables or the database without instructor approval.

---

## 7. Security and Best Practices
- **Permissions**: Students have `db_ddladmin`, `db_datareader`, and `db_datawriter` roles to create, read, and write. Avoid `db_owner` to prevent accidental deletes.
- **Passwords**: Use strong passwords for logins (e.g., `Aptech2025!`).
- **Wi-Fi Safety**: Ensure all devices are on Aptech’s secure Wi-Fi network.
- **Monitor**: In SSMS, check connections: `SELECT * FROM sys.dm_exec_sessions;`

---

## 8. Next Steps
- Learn `ALTER TABLE` to modify tables (e.g., add columns).
- Practice advanced queries (e.g., aggregations: `SELECT CourseID, COUNT(*) AS Enrollments FROM Enrollments GROUP BY CourseID;`)
- Explore SSMS features like diagrams to visualize relationships.

**Contact**: If you encounter issues, note the error and ask your Aptech instructor for help!