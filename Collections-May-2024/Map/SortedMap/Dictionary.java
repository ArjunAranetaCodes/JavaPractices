import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map;

public class Dictionary {
    private SortedMap<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new TreeMap<>();
    }

    public void addWord(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    public String getMeaning(String word) {
        return dictionary.get(word);
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.addWord("apple", "a fruit");
        dictionary.addWord("banana", "a yellow fruit");
        dictionary.addWord("cherry", "a red fruit");

        System.out.println("Dictionary:");
        for (Map.Entry<String, String> entry : dictionary.dictionary.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}