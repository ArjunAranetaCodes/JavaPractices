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

    public synchronized void method1(){
        for(int i = 0; i < 5; i++){
            System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter(10);

        Thread evenThread = new Thread(() -> numberPrinter.printEven(), "EvenThread");
        Thread oddThread = new Thread(() -> numberPrinter.printOdd(), "OddThread");
        Thread newMethod1 = new Thread(() -> numberPrinter.method1(), "Method1");

        evenThread.start();
        oddThread.start();
    }
}
