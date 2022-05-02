public class Main {
    public static void main(String[] args) {
        try {
            throwException();
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        }
    }

    static void throwException() throws CustomException {
        throw new CustomException("This is a custom exception.");
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
