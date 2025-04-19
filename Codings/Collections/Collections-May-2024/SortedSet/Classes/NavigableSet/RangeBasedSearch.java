import java.util.*;

public class RangeBasedSearch {
    public static void main(String[] args) {
        NavigableSet<Integer> numbers = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15));
        int start = 5;
        int end = 12;

        NavigableSet<Integer> range = numbers.subSet(start, true, end, true);

        System.out.println("Numbers in range: " + range);
    }
}