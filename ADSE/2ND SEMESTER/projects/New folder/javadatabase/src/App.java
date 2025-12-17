import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establishing the connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root",
                    "@Joelodufu123");

            // create sql statement
            Statement stmt = conn.createStatement();

            // execute the statement

            ResultSet result = stmt.executeQuery("CREATE DATABASE Aptech;");

            while (result.next()) {
                System.out.println(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
