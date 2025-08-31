public class Main {
    public static void main(String[] args) {
        final int initialValue = 5;
        displayValue(initialValue);
    }

    public static void displayValue(final int value) {
        // Compilation error if you try to modify 'value'
        // value = value + 1;
        System.out.println("Final Parameter: " + value);
    }
}
