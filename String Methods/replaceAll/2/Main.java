import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog.";
        String pattern = "\\bfox\\b";
        String replacement = "cat";
        String result = input.replaceAll(pattern, replacement);
        System.out.println(result);
    }
}
 