public class Main {
    public static void main(String[] args) {
        String str = "😊Hello";
        for (int i = 0; i < str.length(); i++) {
            int codePoint = str.codePointAt(i);
            System.out.println("Code point at index " + i + ": " + codePoint + " (Character: " + new String(Character.toChars(codePoint)) + ")");
        }
    }
}
 