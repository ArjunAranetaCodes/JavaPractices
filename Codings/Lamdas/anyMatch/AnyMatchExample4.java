import java.util.Arrays;

public class AnyMatchExample4 {
    public static void main(String[] args) {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};

        boolean anyMatch = Arrays.stream(colors)
                .anyMatch(color -> color.equalsIgnoreCase("blue"));

        System.out.println("Any color equals 'Blue' (case-insensitive): " + anyMatch);
    }
}
// Output: Any color equals 'Blue' (case-insensitive): true
