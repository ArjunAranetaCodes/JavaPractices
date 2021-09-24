public class Main {
    public static void main(String[] args) {
        String sentence = "Java is a powerful programming language";
        
        // Check if the substring "Java" is at the beginning of the sentence
        String substring = sentence.substring(0, 4);
        if (substring.equals("Java")) {
            System.out.println("The substring 'Java' is at the beginning of the sentence");
        } else {
            System.out.println("The substring 'Java' is not at the beginning of the sentence");
        }
    }
}
   