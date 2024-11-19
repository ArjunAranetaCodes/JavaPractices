import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String sentence = "Hello World, Hello Java, World Java";
        String[] words = sentence.split("\\s+");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : uniqueWords) {
            int frequency = 0;
            for (String w : words) {
                if (word.equals(w)) {
                    frequency++;
                }
            }
            frequencyMap.put(word, frequency);
        }

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}