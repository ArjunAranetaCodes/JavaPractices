import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int taskNumber = i + 1;
            executorService.execute(() -> processTask(taskNumber));
        }

        executorService.shutdown();
    }

    private static void processTask(int taskNumber) {
        // Task processing logic
        System.out.println(Thread.currentThread().getName() + ": Processing Task " + taskNumber);
    }
}
