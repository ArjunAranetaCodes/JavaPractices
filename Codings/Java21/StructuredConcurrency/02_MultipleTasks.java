import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

public class MultipleTasks {
    public static void main(String[] args) {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            // Create a list to store our subtasks
            List<StructuredTaskScope.Subtask<String>> subtasks = new ArrayList<>();
            
            // Submit multiple tasks
            for (int i = 1; i <= 3; i++) {
                final int taskId = i;
                subtasks.add(scope.fork(() -> {
                    // Simulate different work durations
                    Thread.sleep(taskId * 1000);
                    return "Task " + taskId + " completed!";
                }));
            }

            // Wait for all tasks to complete
            scope.join();
            scope.throwIfFailed();

            // Process all results
            for (var subtask : subtasks) {
                System.out.println(subtask.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Tasks failed: " + e.getMessage());
        }
    }
} 