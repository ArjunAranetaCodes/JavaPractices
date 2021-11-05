public class Main {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Cherry", "Orange"};
        
        // Check if any word in the array starts with "B"
        for (String word : words) {
            if (word.startsWith("B")) {
                System.out.println("Found a word in the array starting with 'B': " + word);
            }
        }
    }
}
  