//Exercise 1: Sorting Strings
//Description: Write a program that sorts a list of strings in ascending order using lambdas.

import java.util.ArrayList;
import java.util.List;

public class SortingStrings {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("grape");
        strings.add("cherry");

        strings.sort((s1, s2) -> s1.compareTo(s2));

        System.out.println(strings);

    }
}
