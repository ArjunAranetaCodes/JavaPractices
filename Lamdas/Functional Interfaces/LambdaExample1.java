public class LambdaExample1 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello from a thread!"));
        thread.start();
    }
}
