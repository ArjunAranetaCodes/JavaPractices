import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        double avg = Arrays.stream(arr)
                          .average()
                          .orElseThrow(() -> new RuntimeException("Array is empty"));
        System.out.println("Average of elements in the array: " + avg);
    }
}