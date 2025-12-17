package com.joellee;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=AdventureWorks2022;"
                + "integratedSecurity=true;"
                + "encrypt=true;"
                + "trustServerCertificate=true;";

        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM students");
            while (result.next()) {
                System.out.printf("ID: %d     Name: %s %s", result.getInt(1), result.getString(2), result.getString(3));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}