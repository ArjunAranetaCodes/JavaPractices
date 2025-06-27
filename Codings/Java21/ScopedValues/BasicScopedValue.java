import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasicScopedValue {
    // Define a scoped value for user context
    private static final ScopedValue<String> USER_CONTEXT = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        // Create a virtual thread executor
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Run multiple tasks with different user contexts
            Future<String> task1 = executor.submit(() -> processWithUser("Alice"));
            Future<String> task2 = executor.submit(() -> processWithUser("Bob"));

            System.out.println("Task 1 result: " + task1.get());
            System.out.println("Task 2 result: " + task2.get());
        }
    }

    private static String processWithUser(String username) {
        // Bind the scoped value for this execution
        return ScopedValue.where(USER_CONTEXT, username)
                .call(() -> {
                    // Access the user context
                    String currentUser = USER_CONTEXT.get();
                    System.out.println("Processing for user: " + currentUser);
                    
                    // Simulate some work
                    Thread.sleep(100);
                    
                    return "Processed request for " + currentUser;
                });
    }
} 