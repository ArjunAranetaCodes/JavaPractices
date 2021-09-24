public class Main {
    public static void main(String[] args) {
        String message = "Java is fun!";
        int endPosition = 7;
        
        int codePoint = message.codePointBefore(endPosition);
        
        System.out.println("Code point before position " + endPosition + ": " + codePoint);
    }
}
  