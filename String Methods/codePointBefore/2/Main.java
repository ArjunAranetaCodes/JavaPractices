public class Main {
    public static void main(String[] args) {
        String text = "Java Programming";
        int position = 9;
        
        int codePoint = text.codePointBefore(position);
        
        System.out.println("Code point before position " + position + ": " + codePoint);
    }
}
