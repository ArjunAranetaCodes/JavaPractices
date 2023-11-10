import java.util.stream.IntStream;

public class ForEachOrderedExample5 {
    public static void main(String[] args) {
        int[] array = {4, 2, 6, 1, 8};

        // Using forEachOrdered with IntStream
        IntStream.of(array).forEachOrdered(value -> System.out.print(value + " "));
    }
}
