//Exercise 1: Filter a List
//Description: Create a lambda expression to filter a list of integers and print the even numbers.

import java.util.Arrays;
import java.util.List;

public class FilterAList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
