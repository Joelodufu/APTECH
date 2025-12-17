public class Student {
    String name;
    int age;
    int studentId;
    static String schoolName = "ABC High School"; // Static variable shared by all instances
    static int studentCount = 0; // Static variable to keep track of number of students

    // Constructor
    public Student(String name, int age, int studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        studentCount++; // Increment the student count whenever a new student is created
    }


    //getter for studentCount
    public static int getStudentCount() {
        return studentCount;
    }
   
}

