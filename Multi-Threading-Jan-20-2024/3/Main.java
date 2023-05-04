public class Main {
    private static int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> incrementCounter());
        Thread t2 = new Thread(() -> incrementCounter());

        t1.start();
        t2.start();
    }

    private static synchronized void incrementCounter() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + (++counter));
        }
    }
}
