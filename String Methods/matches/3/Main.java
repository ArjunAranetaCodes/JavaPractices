public class Main {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog.";
        if (sentence.matches(".*\\bfox\\b.*")) {
            System.out.println("The sentence contains the word 'fox'.");
        } else {
            System.out.println("The sentence does not contain the word 'fox'.");
        }
    }
}
 