class SharedFlag {
    volatile boolean flag = false;
}

class Main {
    public static void main(String[] args) {
        SharedFlag sharedFlag = new SharedFlag();

        // Thread 1: sets the flag to true after a delay
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sharedFlag.flag = true;
        }).start();

        new Thread(() -> {
            while (!sharedFlag.flag) {
                // busy-wait until the flag becomes true
            }
            System.out.println("Flag is true now!");
        }).start();
    }
}
