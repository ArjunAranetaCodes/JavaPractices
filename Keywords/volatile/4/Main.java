class SharedData {
    volatile int[] dataArray = new int[10];
}

class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        // Thread 1: updates array elements
        new Thread(() -> {
            for (int i = 0; i < sharedData.dataArray.length; i++) {
                sharedData.dataArray[i] = i;
            }
        }).start();

        // Thread 2: reads array elements
        new Thread(() -> {
            while (sharedData.dataArray[sharedData.dataArray.length - 1] == 0) {
                // busy-wait until the array is initialized
            }
            for (int value : sharedData.dataArray) {
                System.out.println(value);
            }
        }).start();
    }
}
