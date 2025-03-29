import java.util.TreeMap;
import java.util.Map;

public class Dictionary {
    private TreeMap<String, String> words;

    public Dictionary() {
        this.words = new TreeMap<>();
    }

    public void addWord(String word, String meaning) {
        words.put(word, meaning);
    }

    public String getMeaning(String word) {
        return words.get(word);
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.addWord("apple", "a fruit");
        dictionary.addWord("banana", "a yellow fruit");
        dictionary.addWord("cherry", "a red fruit");

        System.out.println("Dictionary:");
        for (Map.Entry<String, String> entry : dictionary.words.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}