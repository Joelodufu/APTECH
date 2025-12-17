import java.io.File;
import java.io.IOException;

public class FileManager {
    public static void main(String[] args) {
        File file2 = new File("data/example2.txt");// defining the file path
        File file3 = new File("../homepage/example.txt");
        try {
            File parentDirectory = file3.getParentFile();
            System.out.println(parentDirectory);
            // defining the parent directory of above file
            if (parentDirectory != null /* If already defined */) {
                parentDirectory.mkdir(); // create the directory according to the defination
                System.out.println("Parent Directory Exists: " + parentDirectory.exists());

            }
            file3.createNewFile();

            // alert created, and log the absolut file path of the created file
            System.out.println("File Created succesfully, PATH: " + file3.getPath());
            boolean deleted = file3.delete();
            System.out.println("FIle is deleted: " + deleted);

            // deleting a folder
            // boolean deletedFolder = parentDirectory.delete();
            
            // System.out.println("Folder is deleted:" + deletedFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}