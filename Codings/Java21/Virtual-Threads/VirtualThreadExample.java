import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExample {

    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Submit a task to the executor
            executor.submit(() -> {
                // Your task
                System.out.println("Task is running on thread: " + Thread.currentThread().getName());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}