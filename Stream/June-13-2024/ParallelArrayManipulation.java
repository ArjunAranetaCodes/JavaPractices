import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.Arrays;

public class ParallelArrayManipulation {

    public static void main(String[] args) {
        int size = 10_000_000; // 10 million elements
        Random rand = ThreadLocalRandom.current();

        int[] arr1 = generateRandomArray(size, rand);
        int[] arr2 = generateRandomArray(size, rand);

        long seqTime = executeTime(() -> {
            int[] copyOfArr1 = arr1.clone();
            int[] copyOfArr2 = arr2.clone();
            IntStream intStreamArr1 = Arrays.stream(copyOfArr1);
            IntStream intStreamArr2 = Arrays.stream(copyOfArr2);
            long countOddSeq = IntStream.concat(intStreamArr1, intStreamArr2)
                       .filter(n -> n % 2 != 0)
                       .count();
        });

        long parTime = executeTime(() -> {
            int[] copyOfArr1 = arr1.clone();
            int[] copyOfArr2 = arr2.clone();
            IntStream intStreamArr1 = Arrays.stream(copyOfArr1);
            IntStream intStreamArr2 = Arrays.stream(copyOfArr2);
            long countOddPar = IntStream.concat(intStreamArr1, intStreamArr2)
                      .parallel()
                      .filter(n -> n % 2 != 0)
                      .count();
        });

        System.out.println("Sequential execution time: " + seqTime + " ms");
        System.out.println("Parallel execution time: " + parTime + " ms");
    }

    private static int[] generateRandomArray(int size, Random rand) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(100);
        }
        return result;
    }

    public static long executeTime(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        return end - start;
    }
}