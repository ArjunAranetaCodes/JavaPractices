public class BasicUnnamedVariable {
    public static void main(String[] args) {
        Object obj = "Hello, Java 21!";

        // Using unnamed variable in pattern matching
        if (obj instanceof String _) {
            System.out.println("It's a string, but we don't care about the value!");
        }
    }
} 