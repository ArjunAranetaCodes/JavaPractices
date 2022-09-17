class Main {
    public static void main(String[] args) {
        System.out.println("Result: " + divideNumbers());
    }

    static int divideNumbers() {
        try {
            return 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("Exception caught: " + e.getMessage());
        } finally {
        }
    }
}
