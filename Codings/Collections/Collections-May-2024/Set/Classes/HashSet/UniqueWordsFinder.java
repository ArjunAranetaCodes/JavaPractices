import java.util.*;

public class UniqueWordsFinder {
    public static void main(String[] args) {
        String text = "Hello world, hello again, world!";

        // Split the text into words
        String[] words = text.split("\\s+");

        // Use a HashSet to find unique words
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("Unique words: " + uniqueWords);
    }
}