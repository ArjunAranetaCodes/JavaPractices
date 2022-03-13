public class Main {
    public static void main(String[] args) {
        String input = "Programming";
        int charIndex = 5;
        
        int codePoint = input.codePointBefore(charIndex);
        
        System.out.println("Code point before index " + charIndex + ": " + codePoint);
    }
}
