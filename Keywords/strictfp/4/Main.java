public class Main {
    public static void main(String[] args) {
        StaticNestedClass nestedObj = new StaticNestedClass();
        nestedObj.display();
    }

    static class StaticNestedClass {
        void display() {
            System.out.println("Inside the static nested class.");
        }
    }
}
 