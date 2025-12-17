
import java.util.Scanner;
import java.util.Arrays;

public class ArrayClassWork {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Read all 5 numbers in one line
        System.out.println("Enter 5 numbers separated by spaces:");
        String line = input.nextLine();

        // Step 2: Split the input string into parts
        String[] parts = line.split(" ");

        // Step 3: Create an integer array and parse the numbers
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        // Step 4: Sort the array
        Arrays.sort(numbers);

        // Step 5: Display the sorted numbers
        System.out.println("\nSorted numbers in ascending order:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        input.close();
    }
    
}


