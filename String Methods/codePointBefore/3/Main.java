public class Main {
    public static void main(String[] args) {
        String sample = "OpenAI";
        int lastIndex = sample.length() - 1;
        
        int codePoint = sample.codePointBefore(lastIndex);
        
        System.out.println("Code point before last index: " + codePoint);
    }
}
  