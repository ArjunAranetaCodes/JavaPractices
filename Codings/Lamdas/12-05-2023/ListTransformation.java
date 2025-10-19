//Exercise 4: List Transformation
//Description: Convert a list of names to uppercase using lambdas.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTransformation {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseNames);
    }
}