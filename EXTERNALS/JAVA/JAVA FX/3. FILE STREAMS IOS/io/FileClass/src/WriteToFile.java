import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("Note.txt")) {
            writer.write("Hello This is my first writing");
            System.out.println("Data writen succesfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
