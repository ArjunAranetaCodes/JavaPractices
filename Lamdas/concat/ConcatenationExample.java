import java.util.function.BiFunction;

public class ConcatenationExample {
    public static void main(String[] args) {
        BiFunction<String, String, String> concat = (str1, str2) -> str1.concat(str2);

        String result = concat.apply("Hello, ", "World!");
        System.out.println(result); // Output: Hello, World!
    }
}
