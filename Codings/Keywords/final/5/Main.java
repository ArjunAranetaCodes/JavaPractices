public class Main {
    final int instanceVariable;

    public Main() {
        instanceVariable = 42;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Final Instance Variable: " + obj.instanceVariable);
    }
}
