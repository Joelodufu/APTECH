package com.example.jdbcdemo;

import java.sql.Connection;

public class StudentDAO {

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
                                rs.getString("gender"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
}