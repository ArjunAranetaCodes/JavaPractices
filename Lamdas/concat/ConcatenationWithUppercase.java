import java.util.function.BiFunction;

public class ConcatenationWithUppercase {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatAndTransform = (str1, str2) ->
                str1.concat(str2).toUpperCase();

        String result = concatAndTransform.apply("hello, ", "world!");
        System.out.println(result); // Output: HELLO, WORLD!
    }
}
