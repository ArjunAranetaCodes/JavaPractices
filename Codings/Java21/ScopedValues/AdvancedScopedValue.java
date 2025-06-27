import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AdvancedScopedValue {
    // Define scoped values for different contexts
    private static final ScopedValue<String> USER_CONTEXT = ScopedValue.newInstance();
    private static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();
    private static final ScopedValue<Integer> PRIORITY = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Run a task with multiple nested contexts
            Future<String> result = executor.submit(() -> 
                processWithMultipleContexts("Charlie", "REQ-123", 1));

            System.out.println("Final result: " + result.get());
        }
    }

    private static String processWithMultipleContexts(String username, String requestId, int priority) {
        // Outer scope with user context
        return ScopedValue.where(USER_CONTEXT, username)
                .call(() -> {
                    System.out.println("Outer scope - User: " + USER_CONTEXT.get());
                    
                    // Middle scope with request ID
                    return ScopedValue.where(REQUEST_ID, requestId)
                            .call(() -> {
                                System.out.println("Middle scope - User: " + USER_CONTEXT.get() + 
                                                 ", Request: " + REQUEST_ID.get());
                                
                                // Inner scope with priority
                                return ScopedValue.where(PRIORITY, priority)
                                        .call(() -> {
                                            // All contexts are accessible here
                                            System.out.println("Inner scope - User: " + USER_CONTEXT.get() + 
                                                             ", Request: " + REQUEST_ID.get() + 
                                                             ", Priority: " + PRIORITY.get());
                                            
                                            // Simulate some work
                                            Thread.sleep(100);
                                            
                                            return String.format("Processed request %s for %s with priority %d",
                                                    REQUEST_ID.get(), USER_CONTEXT.get(), PRIORITY.get());
                                        });
                            });
                });
    }
} 