class NumberPrinter {
    private int count = 1;
    private int maxCount;

    public NumberPrinter(int maxCount) {
        this.maxCount = maxCount;
    }

    public synchronized void printOdd() {
        while (count <= maxCount) {
            if (count % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void printEven() {
        while (count <= maxCount) {
            if (count % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter(10);

        Thread evenThread = new Thread(() -> numberPrinter.printEven(), "EvenThread");
        Thread oddThread = new Thread(() -> numberPrinter.printOdd(), "OddThread");

        evenThread.start();
        oddThread.start();
    }
}
