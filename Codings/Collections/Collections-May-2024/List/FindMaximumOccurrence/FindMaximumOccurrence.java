import java.util.HashMap;
import java.util.Map;

public class FindMaximumOccurrence {
    public static void main(String[] args) {
        String str = "hello world";

        char maxChar = findMaxOccurrence(str);
        int maxCount = countOccurrences(str, maxChar);

        System.out.println("Character with maximum occurrence: " + maxChar);
        System.out.println("Maximum occurrence: " + maxCount);
    }

    public static char findMaxOccurrence(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
    }

    public static int countOccurrences(String str, char c) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
}