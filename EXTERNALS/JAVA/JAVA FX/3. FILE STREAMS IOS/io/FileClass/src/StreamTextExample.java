import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class StreamTextExample {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your sentence: ");
        String input = reader.readLine();

        System.out.println("Uppercase version: " + input.toUpperCase());
    }
}