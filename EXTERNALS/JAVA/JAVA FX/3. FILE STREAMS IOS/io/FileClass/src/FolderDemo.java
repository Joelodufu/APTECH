import java.io.File;

public class FolderDemo {
    public static void main(String[] args) {
        File dir = new File("Attendace");
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("Folder Named: " + dir.getName() + " Have Been created succesfully");
        }
    }

}
