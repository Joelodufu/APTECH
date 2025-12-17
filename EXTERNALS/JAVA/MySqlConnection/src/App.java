public class App {
    public static void main(String[] args) throws Exception {
        StudentDBO stdbo = new StudentDBO();
        // create
        stdbo.insertStudent("Heavenly", "Ojoh", 18, "Male");

        // read
        stdbo.listStudent();

        // update student

        stdbo.updateAge(2, 100);

        //delete student
        stdbo.deleteStudent(1);

    }
}
