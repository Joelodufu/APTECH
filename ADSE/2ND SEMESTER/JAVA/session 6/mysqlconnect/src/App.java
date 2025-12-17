
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