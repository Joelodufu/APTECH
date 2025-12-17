import java.io.File;
import java.io.IOException;

public class FileHandling {
     public static void main(String[] args) {
         try {
            File f1= new File("newFile.txt");
            if (f1.createNewFile()){
                System.out.println("Created the file: "+f1.getName());
            }
         } catch (IOException e) {
             System.err.println("An Error occored while creating the file");
             e.printStackTrace();
         }
    }
}
