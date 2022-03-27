public class Main {
    public static void main(String[] args) {
        String text = "Hello, World!";
        
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            System.out.println("Character at index " + i + ": " + character);
        }
    }
}
