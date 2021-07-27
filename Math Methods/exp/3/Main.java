import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String text = "This is an example expression.";
        String pattern = "exp.*";
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("Does the text match the expression pattern? " + matches);
    }
}
  