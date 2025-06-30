import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ExecutionException;

public class NestedScopes {
    public static void main(String[] args) {
        try (var outerScope = new StructuredTaskScope.ShutdownOnFailure()) {
            // First task in outer scope
            var task1 = outerScope.fork(() -> {
                try (var innerScope = new StructuredTaskScope.ShutdownOnFailure()) {
                    // Nested tasks
                    var nestedTask1 = innerScope.fork(() -> {
                        Thread.sleep(1000);
                        return "Nested Task 1 completed";
                    });

                    var nestedTask2 = innerScope.fork(() -> {
                        Thread.sleep(2000);
                        return "Nested Task 2 completed";
                    });

                    // Wait for nested tasks
                    innerScope.join();
                    innerScope.throwIfFailed();

                    // Combine nested results
                    return nestedTask1.get() + " and " + nestedTask2.get();
                }
            });

            // Second task in outer scope
            var task2 = outerScope.fork(() -> {
                Thread.sleep(1500);
                return "Outer Task 2 completed";
            });

            // Wait for outer tasks
            outerScope.join();
            outerScope.throwIfFailed();

            // Process outer results
            System.out.println("Task 1 result: " + task1.get());
            System.out.println("Task 2 result: " + task2.get());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Tasks failed: " + e.getMessage());
        }
    }
} 