class Main {
    public static void main(String[] args) {
        System.out.println("Result: " + divideNumbers());
    }

    static int divideNumbers() {
        try {
            // Code that may throw an exception
            return 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("Exception caught: " + e.getMessage());
        } finally {
        }
    }
}
