class Main {
    private Main() {
        System.out.println("This is a private constructor.");
    }

    public static void main(String[] args) {
        // Cannot create an instance of Main using private constructor
        // Main obj = new Main(); // Uncommenting this line will result in a compilation error
    }
}
