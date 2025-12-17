# ✅ **1. What Is Windows Authentication? (Very Simple Explanation)**

When you log into Windows, you already have an identity, e.g.:

```
DESKTOP-12345\Ismail
```

SQL Server can be configured to **trust** your Windows login.
So when your Java program connects, SQL Server says:

> “Oh, this is the same Windows user that is already allowed — let them in.”

No username and password needed.

---

# ✅ **2. JDBC Connection String for Windows Authentication**

For Microsoft SQL Server, the URL looks like this:

```java
String url = "jdbc:sqlserver://localhost:1433;"
           + "databaseName=TestDB;"
           + "integratedSecurity=true;"
           + "encrypt=false;";
```

### 🔥 Important:

To use Windows authentication in Java, you must include:

### ✔ `integratedSecurity=true`

### ✔ A special Microsoft DLL file: **mssql-jdbc_auth.dll**

This file comes with the SQL Server JDBC driver.

---

# ✅ **3. You MUST Add `mssql-jdbc_auth.dll` to Your System**

### Steps:

1. Download SQL Server JDBC driver from Microsoft
   (It contains a folder called `auth`)

2. Inside you will find:

```
/auth/x64/mssql-jdbc_auth-12.4.0.x64.dll
/auth/x86/mssql-jdbc_auth-12.4.0.x86.dll
```
@Joelodufu123
@Joelodufu123

Choose:

- **x64** DLL if your system + Java is 64-bit
- **x86** DLL if your Java is 32-bit

3. Copy the DLL to:

```
C:\Windows\System32\
```

OR add this folder to:

```
java -Djava.library.path="path/to/auth"
```

---

# ⭐ **4. Full JDBC Code Using Windows Authentication**

```java
import java.sql.*;

public class SQLServerWinAuth {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url =
                "jdbc:sqlserver://localhost:1433;"
              + "databaseName=TestDB;"
              + "integratedSecurity=true;"
              + "encrypt=false;";

            Connection conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

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

# 🧠 **5. How does Java actually authenticate you?**

When you run your Java app:

1. Windows tells SQL Server:
   “This process is running as user `DESKTOP\Ismail`.”

2. SQL Server checks if that Windows user is allowed on the database.

3. If yes → connection succeeds

4. If not → you get a “Login failed for user NT AUTHORITY\…” error.

---

# 🎯 **6. How to add your Windows user to SQL Server**

Open **SQL Server Management Studio (SSMS)** → Connect
Then:

**Security → Logins → New Login**

Select:

- Login type → _Windows Authentication_
- Select your Windows user
- Map it to your database
- Set permissions: db_owner (for testing)

---

# ✅ Summary

| Function                                  | Windows Auth | SQL Auth |
| ----------------------------------------- | ------------ | -------- |
| Needs username/password?                  | ❌ No        | ✔ Yes    |
| Uses your Windows login?                  | ✔ Yes        | ❌ No    |
| JDBC URL needs `integratedSecurity=true`? | ✔ Required   | ❌ No    |
| Needs `mssql-jdbc_auth.dll`?              | ✔ Required   | ❌ No    |

---
