module MyModule {
    requires someOtherModule;

    public class Main {
        public static void main(String[] args) {
            System.out.println("Hello from MyModule with dependencies!");
        }
    }
}
