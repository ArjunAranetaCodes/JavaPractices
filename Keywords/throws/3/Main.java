public class Main {
    public static void main(String[] args) {
        try {
            throwCheckedException();
        } catch (CheckedException e) {
            System.out.println("Caught CheckedException: " + e.getMessage());
        }

        throwUncheckedException();
    }

    static void throwCheckedException() throws CheckedException {
        throw new CheckedException("This is a checked exception.");
    }

    static void throwUncheckedException() {
        throw new UncheckedException("This is an unchecked exception.");
    }
}
 
class CheckedException extends Exception {
    public CheckedException(String message) {
        super(message);
    }
}

class UncheckedException extends RuntimeException {
    public UncheckedException(String message) {
        super(message);
    }
}
