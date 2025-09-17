import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Functional {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Functional: Use Streams to filter even numbers and double them
        List<Integer> doubledEvens = numbers.stream()
                .filter(n -> n % 2 == 0)           // filter even numbers
                .map(n -> n * 2)                   // double each number
                .collect(Collectors.toList());

        System.out.println("Functional result: " + doubledEvens);
    }
}