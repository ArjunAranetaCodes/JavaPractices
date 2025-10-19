import java.util.function.BiFunction;

public class ConcatenationWithLengthCheck {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatIfLengthLessThanTen = (str1, str2) ->
                (str1.length() + str2.length() < 10) ? str1.concat(str2) : "Too long!";

        String result = concatIfLengthLessThanTen.apply("Hello, ", "World!");
        System.out.println(result); // Output: Too long!
    }
}
