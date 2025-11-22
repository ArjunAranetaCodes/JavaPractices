/**
 * Tutorial: CompletableFuture
 * Demonstrates asynchronous programming with CompletableFuture
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncExample {
    public static void main(String[] args) {
        // Simple async task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Hello from async task";
        });
        
        // Get result (blocks until complete)
        try {
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        // Chaining futures
        CompletableFuture<String> chain = CompletableFuture
            .supplyAsync(() -> "Hello")
            .thenApply(s -> s + " World")
            .thenApply(String::toUpperCase);
        
        try {
            System.out.println("Chained result: " + chain.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        // Combining futures
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "First");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Second");
        
        CompletableFuture<String> combined = future1.thenCombine(future2, (a, b) -> a + " + " + b);
        
        try {
            System.out.println("Combined: " + combined.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        // Exception handling
        CompletableFuture<String> errorFuture = CompletableFuture
            .supplyAsync(() -> {
                throw new RuntimeException("Error occurred");
            })
            .exceptionally(ex -> "Handled: " + ex.getMessage());
        
        try {
            System.out.println("Error handled: " + errorFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

