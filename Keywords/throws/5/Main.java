public class Main {
    public static void main(String[] args) {
        throwUncheckedException();
    }

    private static void throwUncheckedException() {
        throw new RuntimeException("Unchecked exception thrown");
    }
}
