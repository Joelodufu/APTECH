import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = { 4, 5, 6, 3, 5, 6, };
        System.out.println(numbers);
        var numbers1 = numbers;
        System.out.println(numbers1);

        numbers[2] = 10;
        System.out.println(numbers1[2]);

        Scanner input = new Scanner(System.in);
        String age = input.next();
        System.out.println(age);
        input.close();


    }
}
