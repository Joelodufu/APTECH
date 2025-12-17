# **Java JDBC Class Notes**

## **1. Introduction to JDBC**

**JDBC** (Java Database Connectivity) is a **Java API** that allows Java applications to interact with databases (like MySQL, Oracle, PostgreSQL, etc.).

* **Purpose:** Execute SQL statements from Java and handle results.
* **Use Cases:**

  * Querying data
  * Updating data
  * Inserting or deleting data
  * Transaction management

**Key points:**

* JDBC is **platform-independent**.
* You need a **JDBC driver** for the specific database.
* JDBC works with **SQL commands**.

---

## **2. JDBC Architecture**

JDBC has a **4-layer architecture**:

1. **Java Application:** Your Java code using JDBC API.
2. **JDBC API:** Interfaces like `Connection`, `Statement`, `ResultSet`.
3. **JDBC Driver Manager:** Connects your app to the database using the right driver.
4. **Database:** Actual data storage (MySQL, Oracle, PostgreSQL).

**Flow:**
Java App → JDBC API → Driver Manager → Database → Result back to Java App

---

## **3. JDBC Drivers**

JDBC requires a **driver** to communicate with a database. There are **4 types of JDBC drivers**:

| Type | Name                                 | Description                               | Pros                             | Cons                     |
| ---- | ------------------------------------ | ----------------------------------------- | -------------------------------- | ------------------------ |
| 1    | JDBC-ODBC Bridge Driver              | Uses ODBC driver to connect to DB         | Works with any ODBC-supported DB | Slow, requires ODBC      |
| 2    | Native-API/partly Java Driver        | Converts JDBC calls to native DB API      | Fast                             | Database-dependent       |
| 3    | Network Protocol / Middleware Driver | JDBC calls go through a middleware server | Database-independent             | Middleware server needed |
| 4    | Thin / Pure Java Driver              | Fully written in Java, connects directly  | Fast, portable                   | Specific driver needed   |

**Most used:** **Type 4** (Pure Java driver, e.g., `com.mysql.cj.jdbc.Driver` for MySQL)

---

## **4. JDBC Interfaces & Classes**

JDBC API provides **interfaces** and **classes**. Interfaces define behavior; classes implement them.

### **4.1 Core Interfaces**

| Interface           | Purpose                                        |
| ------------------- | ---------------------------------------------- |
| `DriverManager`     | Manages database drivers and connections       |
| `Connection`        | Represents a connection to a DB                |
| `Statement`         | Executes static SQL queries                    |
| `PreparedStatement` | Executes parameterized SQL queries             |
| `CallableStatement` | Executes stored procedures                     |
| `ResultSet`         | Holds results from a query                     |
| `ResultSetMetaData` | Provides metadata about columns in a ResultSet |
| `DatabaseMetaData`  | Provides info about the database               |

### **4.2 Important Classes**

| Class           | Purpose                               |
| --------------- | ------------------------------------- |
| `DriverManager` | Connects to DB using JDBC URL         |
| `SQLException`  | Handles database errors               |
| `Types`         | Provides constants for SQL data types |
| `Blob` / `Clob` | For handling large binary/text data   |

---

## **5. JDBC Workflow**

**Step by step to connect and query a DB:**

1. **Load the JDBC driver**

```java
Class.forName("com.mysql.cj.jdbc.Driver"); // Type 4 driver
```

2. **Establish a connection**

```java
Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/testdb", "root", "password");
```

3. **Create a statement**

```java
Statement stmt = conn.createStatement();
```

4. **Execute SQL query**

```java
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
```

5. **Process the result**

```java
while(rs.next()) {
    System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
}
```

6. **Close resources**

```java
rs.close();
stmt.close();
conn.close();
```

---

## **6. JDBC Data Models**

**JDBC works with SQL data types**, which map to Java data types:

| SQL Type              | Java Type          |
| --------------------- | ------------------ |
| VARCHAR, CHAR, TEXT   | String             |
| INT, BIGINT, SMALLINT | int, long          |
| FLOAT, DOUBLE         | float, double      |
| DATE                  | java.sql.Date      |
| TIME                  | java.sql.Time      |
| TIMESTAMP             | java.sql.Timestamp |
| BLOB                  | byte[]             |
| CLOB                  | String             |

**Tip:** Use `PreparedStatement` for type-safe data insertion.

---

## **7. Example 1 – Simple Query (Using Statement)**

```java
import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password");

            // 3. Create Statement
            Statement stmt = conn.createStatement();

            // 4. Execute Query
            ResultSet rs = stmt.executeQuery("SELECT id, name FROM users");

            // 5. Process Result
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            // 6. Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## **8. Example 2 – Using PreparedStatement**

```java
import java.sql.*;

public class PreparedStmtExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password");

            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "John Doe");
            pstmt.setString(2, "john@example.com");

            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## **9. Example 3 – Using CallableStatement (Stored Procedure)**

Assume a stored procedure exists: `CREATE PROCEDURE getUser(IN userId INT)`

```java
import java.sql.*;

public class CallableStmtExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password");

            CallableStatement cstmt = conn.prepareCall("{CALL getUser(?)}");
            cstmt.setInt(1, 1); // set input parameter

            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## **10. Tips & Best Practices**

1. Always **close** `ResultSet`, `Statement`, and `Connection`.
2. Use **PreparedStatement** to prevent **SQL injection**.
3. Handle exceptions with **try-catch-finally**.
4. Use **Connection Pooling** for performance in production.
5. Avoid hardcoding credentials; use a config file.

---

## **11. Summary Table – Interfaces & Use**

| Interface/Class     | Use                                |
| ------------------- | ---------------------------------- |
| `Connection`        | Connect & manage DB                |
| `Statement`         | Run SQL queries                    |
| `PreparedStatement` | Run parameterized SQL queries      |
| `CallableStatement` | Call stored procedures             |
| `ResultSet`         | Store query results                |
| `DriverManager`     | Load driver & establish connection |
| `SQLException`      | Handle DB errors                   |
| `DatabaseMetaData`  | Get DB info                        |
| `ResultSetMetaData` | Get info about query results       |

---

✅ **Conclusion:**
JDBC is your bridge from Java to databases. Start with **Statement**, move to **PreparedStatement**, then **CallableStatement** for advanced work. Remember, mastering JDBC means understanding **connections, statements, results, and exception handling**.

---

