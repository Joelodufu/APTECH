import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("MyFile.txt");
        File folder = new File("/homes/about");

        try {
            if (file.exists()) {

                System.out.println("File created ");
            }
            file.createNewFile();
            folder.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
