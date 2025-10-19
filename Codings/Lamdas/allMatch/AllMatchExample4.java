import java.util.Arrays;
import java.util.List;

public class AllMatchExample4 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "API", "Lambda");

        boolean allLongerThanThree = words.stream().allMatch(word -> word.length() > 3);

        System.out.println("Are all words longer than 3 characters? " + allLongerThanThree);
    }
}
