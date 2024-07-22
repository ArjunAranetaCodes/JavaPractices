public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumbers(1, 10, 2));
        Thread t2 = new Thread(() -> printNumbers(2, 10, 2));

        t1.start();
        t2.start();
    }

    private static void printNumbers(int start, int end, int step) {
        for (int i = start; i <= end; i += step) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
