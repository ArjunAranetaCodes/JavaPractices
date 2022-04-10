class SharedResource {
    volatile boolean flag = false;
}

class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        new Thread(() -> {
            sharedResource.flag = true;
        }).start();

        // Thread 2: reads the flag value
        new Thread(() -> {
            while (!sharedResource.flag) {
                // busy-wait until the flag becomes true
            }
            System.out.println("Flag is true now!");
        }).start();
    }
}
