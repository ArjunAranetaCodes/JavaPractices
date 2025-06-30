import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

public class ErrorHandling {
    public static void main(String[] args) {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            List<StructuredTaskScope.Subtask<String>> subtasks = new ArrayList<>();
            
            // Submit tasks, one of which will fail
            subtasks.add(scope.fork(() -> {
                Thread.sleep(1000);
                return "Task 1 completed successfully";
            }));

            subtasks.add(scope.fork(() -> {
                Thread.sleep(2000);
                throw new RuntimeException("Task 2 failed!");
            }));

            subtasks.add(scope.fork(() -> {
                Thread.sleep(3000);
                return "Task 3 completed successfully";
            }));

            try {
                // Wait for all tasks
                scope.join();
                scope.throwIfFailed();
            } catch (ExecutionException e) {
                System.err.println("A task failed: " + e.getCause().getMessage());
                // The scope will automatically shut down due to ShutdownOnFailure policy
            }

            // Try to get results from completed tasks
            for (var subtask : subtasks) {
                if (subtask.state() == StructuredTaskScope.Subtask.State.SUCCESS) {
                    System.out.println(subtask.get());
                } else {
                    System.out.println("Task failed: " + subtask.exception().getMessage());
                }
            }
        } catch (InterruptedException e) {
            System.err.println("Tasks were interrupted: " + e.getMessage());
        }
    }
} 