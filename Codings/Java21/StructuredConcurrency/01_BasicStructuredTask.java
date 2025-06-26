import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ExecutionException;

public class BasicStructuredTask {
    public static void main(String[] args) {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            // Submit a task to the scope
            var subtask = scope.fork(() -> {
                // Simulate some work
                Thread.sleep(1000);
                return "Task completed successfully!";
            });

            // Wait for all tasks to complete
            scope.join();
            // Check for any failures
            scope.throwIfFailed();

            // Get the result
            String result = subtask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Task failed: " + e.getMessage());
        }
    }
} 