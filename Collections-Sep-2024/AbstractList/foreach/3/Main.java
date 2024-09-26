import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String sentence = "This is a sample sentence";
        long wordCount = new StringTokenizer(sentence).countTokens();
        System.out.println("Number of words in the given sentence: " + wordCount);
    }
}