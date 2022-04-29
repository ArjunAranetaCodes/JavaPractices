public class Main {
    public static void main(String[] args) {
        try {
            throwMultipleExceptions(1);
        } catch (CustomException | AnotherException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    static void throwMultipleExceptions(int option) throws CustomException, AnotherException {
        if (option == 1) {
            throw new CustomException("This is a custom exception.");
        } else {
            throw new AnotherException("This is another exception.");
        }
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
  
class AnotherException extends Exception {
    public AnotherException(String message) {
        super(message);
    }
}
