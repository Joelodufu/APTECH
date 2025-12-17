import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File myFile = new File("Students/students1.txt");// define the path
        try {
            boolean fileIsCreated = myFile.createNewFile();
            if (fileIsCreated) {
                System.out.println("File " + myFile.getName() + " Have been created");
            } else {
                System.out.println("File Already Exists");
            }

            // print some perameters
            // absolute file path
            System.out.println(myFile.getAbsolutePath());
            // can write
            System.out.println(myFile.canWrite());
            // can be read
            System.out.println(myFile.canRead());

        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

    }
}
