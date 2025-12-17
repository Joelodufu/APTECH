import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicDatabaseDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/schooldb";
        String user = "root";
        String password = "@Joelodufu123";
        try {
            //creating connection instance
            Connection cn = DriverManager.getConnection(url, user, password);

            // creating a statement instance from the connection instance 
            Statement st = cn.createStatement();

            // executing queries using the statement object and returning a RS object
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("First Name: " + rs.getString(2));
                System.out.println("Last Name: " + rs.getString(3));
                System.out.println("Age: " + rs.getInt(4));
                System.out.println("Gender: " + rs.getString(5));
                System.out.println("Grade Level: " + rs.getString(6));
            }

            System.out.println("Connection Succesfully Established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
