//Exercise 3: String Manipulation
//Description: Create a lambda expression that takes a string and returns the string reversed.

import java.util.function.Function;

public class StringReverse {
    public static void main(String[] args) {
        Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();

        String input = "Hello, World!";
        String reversed = reverse.apply(input);

        System.out.println(reversed);
    }
}