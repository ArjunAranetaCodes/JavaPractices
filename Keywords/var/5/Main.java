class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Code that may throw a custom exception
            throw new CustomException("This is a custom exception");
        } catch (CustomException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
    }
}
