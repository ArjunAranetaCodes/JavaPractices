public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread primeThread = new Thread(() -> generatePrimes());
        Thread interruptThread = new Thread(() -> interruptAfterDelay(primeThread, 2000));

        primeThread.start();
        interruptThread.start();

        primeThread.join();
        interruptThread.join();
    }

    private static void generatePrimes() {
        // Prime number generation logic
    }

    private static void interruptAfterDelay(Thread targetThread, long delayMillis) {
        try {
            Thread.sleep(delayMillis);
            targetThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
