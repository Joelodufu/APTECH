
import java.io.*;

public class TextWriterBasics {
    public static void main(String[] args) {
        String fileName = "data/output.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello to the world of tech\n");
            writer.write("Hello Again, to the world of tech\n");
            System.out.println("Succesfully written into the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
}
