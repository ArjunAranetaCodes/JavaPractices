public class Main {
    public static void main(String[] args) {
        String sentence = "This is a sample sentence";
        String[] words = sentence.split(" ");
        System.out.println("Words in the sentence:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
