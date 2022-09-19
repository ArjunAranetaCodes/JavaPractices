public class Main {
    final int instanceVariable;

    public Main() {
        // Initialization is required in the constructor for final instance variable
        instanceVariable = 42;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Final Instance Variable: " + obj.instanceVariable);
    }
}
