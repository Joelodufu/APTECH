package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/schooldb";
        String user = "root";
        String password = "@Joelodufu123";
        // create connection
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            // create statement
            Statement statement = connection.createStatement();
            // execute statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            // handle ResultSet][=l9i8uj
            while (resultSet.next()){
                System.out.printf("ID: %d, FirstName: %s, LastName: %s, Age: %d, Gender = %s, Grade: %s\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}