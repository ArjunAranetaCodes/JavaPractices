public class Main {
    // Static variable
    static int counter = 0;

    public static void main(String[] args) {
        // Accessing a static variable
        System.out.println("Counter value: " + counter);

        counter++;
        System.out.println("Updated counter value: " + counter);
    }
}
