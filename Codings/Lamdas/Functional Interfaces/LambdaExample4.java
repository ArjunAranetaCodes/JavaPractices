import java.util.concurrent.*;

public class LambdaExample4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> "Hello from Callable");

        System.out.println(future.get());

        executor.shutdown();
    }
}
