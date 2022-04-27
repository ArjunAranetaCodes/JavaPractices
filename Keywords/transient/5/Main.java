public class Main {
    public static void main(String[] args) {
        try {
            processInput(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }

    static void processInput(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("Input value must be non-negative.");
        }
        System.out.println("Processing input: " + value);
    }
}
    