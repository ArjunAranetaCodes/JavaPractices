class Main {
    public static void main(String[] args) {
        try {
            // Code that may throw an exception
            int result = performOperation();
            System.out.println("Result: " + result);
        } finally {
            System.out.println("Finally block executed.");
        }
    }

    static int performOperation() {
        try {
            int result = 10 / 0;
            return result;
        } catch (ArithmeticException e) {
            System.err.println("Exception caught: " + e.getMessage());
            System.exit(1); // Terminate the program in case of an exception
            return -1; // This line will not be reached
        }
    }
}
