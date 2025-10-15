//Exercise 2: Filtering Even Numbers
//Description: Create a program that filters out even numbers from a list of integers using lambdas.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(12);
        numbers.add(7);
        numbers.add(4);
        numbers.add(9);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }
}