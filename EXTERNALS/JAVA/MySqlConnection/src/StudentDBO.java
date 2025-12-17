import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class StudentDBO {
    // C: insert stuent
    public void insertStudent(String first, String last, int age, String gender) {
        String sql = " INSERT INTO students(first_name, last_name, age, gender) VALUES (?,?,?,?)";
        try (Connection conn = DBUtils.getConnection(); var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setInt(3, age);
            stmt.setString(4, gender);

            stmt.executeUpdate();
            System.out.println("Student have been inserted successfull");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // R: list all student

    public void listStudent() {
        String sql = "SELECT * FROM students";

        try (Connection conn = DBUtils.getConnection();
                var stmt = conn.prepareStatement(sql);
                var res = stmt.executeQuery()) {
            while (res.next()) {
                System.out.println(
                        res.getInt("id") + " " +
                                res.getString("first_name") + " " +
                                res.getString("last_name") + " " +
                                res.getInt("age") + " " +
                                res.getString("gender"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // U: update student

    public void updateAge(int id, int age) {
        String sql = "UPDATE students SET age = ? WHERE id=?";

        try (Connection conn = DBUtils.getConnection(); var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, age);
            stmt.executeUpdate();
            System.out.println("Student updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // D: delete student
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBUtils.getConnection(); var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Students deleted succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}