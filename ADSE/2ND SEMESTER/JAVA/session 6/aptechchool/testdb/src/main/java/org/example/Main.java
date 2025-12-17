package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/schooldb";
        String user = "root";
        String password = "@Joelodufu123";


        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet result = statement.executeQuery("SELECT * FROM students");
            System.out.println("Connection succesful");
            while (result.next()) {
                ResultSetMetaData rsmtd = result.getMetaData();

                System.out.printf("%s: %s     %s: %s   %s: %s\n",
                        rsmtd.getColumnName(1),
                        result.getInt(1),
                        rsmtd.getColumnName(2),
                        result.getString(2),
                        rsmtd.getColumnName(3),
                        result.getString(3));
                System.out.println(result.getRow());
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
        };


    }


}