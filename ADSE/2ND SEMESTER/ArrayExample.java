import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = { 20, 10, 3, 8, 5 };
        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("Index of 8: " + index);
        System.out.println(Arrays.toString(numbers));
    }
}
