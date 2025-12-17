import java.util.*;
import java.util.stream.*;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 3, 5, 8, 10, 13);

        nums.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

}
