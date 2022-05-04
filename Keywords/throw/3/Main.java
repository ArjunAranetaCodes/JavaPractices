public class Main {
    public static void main(String[] args) {
        try {
            methodThatThrowsException();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    private static void methodThatThrowsException() throws Exception {
        throw new Exception("Exception thrown from method");
    }
}
