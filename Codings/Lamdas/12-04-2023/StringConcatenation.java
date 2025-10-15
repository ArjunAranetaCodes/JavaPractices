import java.util.function.BinaryOperator;

public class StringConcatenation {
    public static void main(String[] args) {
        BinaryOperator<String> concatenate = (s1, s2) -> s1 + " " + s2;

        String first = "Hello";
        String second = "World!";
        String result = concatenate.apply(first, second);

        System.out.println(result);
    }
}