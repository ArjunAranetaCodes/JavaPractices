//Exercise 1: Sorting Strings by Length
//Description: Write a lambda expression to sort an array of strings by their length in ascending order.
import java.util.Arrays;

public class StringSortByLength {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};

        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        for (String word : words) {
            System.out.println(word);
        }
    }
}
