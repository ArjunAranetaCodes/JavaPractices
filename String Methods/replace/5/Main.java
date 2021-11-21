public class Main {
    public static void main(String[] args) {
        String sentence = "Java programming is fun!";
        String replacedSentence = sentence.replaceAll("(?i)java", "Python");
        System.out.println(replacedSentence);
    }
}
 