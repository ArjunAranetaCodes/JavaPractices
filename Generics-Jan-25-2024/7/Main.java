import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> future = executorService.submit(new FactorialTask(5));

        // Waiting for the result
        long result = future.get();
        System.out.println("Factorial result: " + result);

        executorService.shutdown();
    }

    static class FactorialTask implements Callable<Long> {
        private int number;

        FactorialTask(int number) {
            this.number = number;
        }

        @Override
        public Long call() {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}
