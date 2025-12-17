

# ✅ **1. Install Everything You Need**

### **A. Install Java JDK**

Download & install **JDK 17 or JDK 21**:

* Oracle JDK or OpenJDK
* After installation, confirm in terminal:

```
java -version
```

You should see something like:
`java 17.0.x`

---

### **B. Install MySQL**

Download **MySQL Community Server** and install.

During installation:

* Create a **root password**
* Install **MySQL Workbench** (optional but helpful)

---

### **C. Install VS Code Extensions**

Open VS Code → Extensions (Ctrl+Shift+X) → Install:

1. **Extension Pack for Java** (by Microsoft)
2. **Debugger for Java**
3. **Java Test Runner**
4. **Maven for Java** (optional but recommended)

---

# ✅ **2. Create Your Java Project in VS Code**

### Option 1 — **Using Maven (Recommended)**

In VS Code:

1. Press **Ctrl + Shift + P**
2. Choose: **Maven: Create Maven Project**
3. Pick template: **quickstart**
4. Group Id: `com.example`
5. Artifact Id: `jdbc-demo`

A project will be created with:

```
src/main/java/
pom.xml
```

---

# ✅ **3. Add MySQL JDBC Driver**

Open your `pom.xml`, add this dependency inside `<dependencies>`:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.0.0</version>
</dependency>
```

Then save — VS Code will auto-download the driver.

---

# ✅ **4. Create Your MySQL Database & Table**

Open MySQL Workbench or CLI and run:

```sql
CREATE DATABASE jdbc_demo;
USE jdbc_demo;

CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  age INT,
  gender VARCHAR(10)
);
```

---

# ✅ **5. Create Your Database Connection Class**

Inside
`src/main/java/com/example/jdbcdemo/DBUtils.java`

Paste:

```java
package com.example.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

---

# ✅ **6. CRUD Operations (Copy & Paste)**

Create a file:
`src/main/java/com/example/jdbcdemo/StudentDAO.java`

### **A. INSERT (Create)**

```java
public void insertStudent(String first, String last, int age, String gender) {
    String sql = "INSERT INTO students (first_name, last_name, age, gender) VALUES (?, ?, ?, ?)";

    try (Connection conn = DBUtils.getConnection();
         var stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, first);
        stmt.setString(2, last);
        stmt.setInt(3, age);
        stmt.setString(4, gender);

        stmt.executeUpdate();
        System.out.println("Student inserted!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

---

### **B. SELECT (Read)**

```java
public void listStudents() {
    String sql = "SELECT * FROM students";

    try (Connection conn = DBUtils.getConnection();
         var stmt = conn.prepareStatement(sql);
         var rs = stmt.executeQuery()) {

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " - " +
                rs.getString("first_name") + " " +
                rs.getString("last_name") + " | " +
                rs.getInt("age") + " | " +
                rs.getString("gender")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

---

### **C. UPDATE**

```java
public void updateStudentAge(int id, int newAge) {
    String sql = "UPDATE students SET age = ? WHERE id = ?";

    try (Connection conn = DBUtils.getConnection();
         var stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, newAge);
        stmt.setInt(2, id);
        stmt.executeUpdate();

        System.out.println("Student updated!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

---

### **D. DELETE**

```java
public void deleteStudent(int id) {
    String sql = "DELETE FROM students WHERE id = ?";

    try (Connection conn = DBUtils.getConnection();
         var stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        stmt.executeUpdate();

        System.out.println("Student deleted!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

---

# ✅ **7. Main Class to Test Everything**

Create file:
`src/main/java/com/example/jdbcdemo/App.java`

```java
package com.example.jdbcdemo;

public class App {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // INSERT
        dao.insertStudent("John", "Doe", 23, "Male");

        // READ
        dao.listStudents();

        // UPDATE
        dao.updateStudentAge(1, 30);

        // DELETE
        dao.deleteStudent(1);
    }
}
```

---

# ✅ **8. How to Run the Program in VS Code**

Open terminal inside VS Code:

```
mvn clean package
mvn exec:java -Dexec.mainClass="com.example.jdbcdemo.App"
```

Or use the **Run** button beside the `main` method.

---

# 🎉 **You now have a complete JDBC + MySQL system built from scratch using VS Code.**

---

# If you want next, I can also generate:
