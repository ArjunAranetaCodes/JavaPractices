public class Main {
    public static void main(String[] args) {
        // Creating an instance of a static nested class
        StaticNestedClass nestedObj = new StaticNestedClass();
        nestedObj.display();
    }

    // Static nested class
    static class StaticNestedClass {
        void display() {
            System.out.println("Inside the static nested class.");
        }
    }
}
