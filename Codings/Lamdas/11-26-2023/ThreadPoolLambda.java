import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolLambda {
    public static void main(String[] args) {
        // Lambda expression with thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(() -> System.out.println("Task " + finalI + " executed by " +
                    Thread.currentThread().getName()));
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
