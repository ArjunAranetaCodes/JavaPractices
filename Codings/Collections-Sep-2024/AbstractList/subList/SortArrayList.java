import java.util.*;

public class SortArrayList {
    public static void main(String[] args) {
        List<Integer> randomNumbers = Arrays.asList(5, 3, 1, 4, 2); // create an unmodifiable list of random numbers
        
        Collections.sort(randomNumbers); // sort the list in ascending order
        
        System.out.println("Sorted Numbers: " + randomNumbers);
    }
}