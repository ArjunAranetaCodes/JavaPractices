import java.util.function.BiFunction;

public class ConcatenationWithNullCheck {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatWithNullCheck = (str1, str2) ->
                (str1 != null && str2 != null) ? str1.concat(str2) : "Input is null!";

        String result = concatWithNullCheck.apply("Hello, ", null);
        System.out.println(result); // Output: Input is null!
    }
}
