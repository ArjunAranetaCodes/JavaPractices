public class Main {
    public static void main(String[] args) {
        String sentence = "Java programming is fun!";
        char targetChar = 'a';
        int count = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == targetChar) {
                count++;
            }
        }

        System.out.println("Occurrences of '" + targetChar + "': " + count);
    }
}
   