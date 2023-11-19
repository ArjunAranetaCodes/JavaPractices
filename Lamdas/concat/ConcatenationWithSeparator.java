import java.util.function.BiFunction;

public class ConcatenationWithSeparator {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatWithSeparator = (str1, str2) -> str1.concat(" - ").concat(str2);

        String result = concatWithSeparator.apply("Java", "Lambda");
        System.out.println(result); // Output: Java - Lambda
    }
}
