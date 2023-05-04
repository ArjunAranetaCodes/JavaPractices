public class Main {
    private static int number = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> printOdd());
        Thread evenThread = new Thread(() -> printEven());

        oddThread.start();
        evenThread.start();
    }

    private static synchronized void printOdd() {
        while (number <= 10) {
            if (number % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + number++);
            }
        }
    }

    private static synchronized void printEven() {
        while (number <= 10) {
            if (number % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + number++);
            }
        }
    }
}
