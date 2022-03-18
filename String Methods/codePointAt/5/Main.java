public class Main {
    public static void main(String[] args) {
        String str = "A1B";
        for (int i = 0; i < str.length(); i++) {
            int codePoint = str.codePointAt(i);
            boolean isLetter = Character.isLetter(codePoint);
            System.out.println("Code point at index " + i + " is a letter: " + isLetter);
        }
    }
}
  