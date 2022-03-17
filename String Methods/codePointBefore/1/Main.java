public class Main {
    public static void main(String[] args) {
        String str = "Hello World";
        int index = str.length() - 1;
        
        int codePoint = str.codePointBefore(index);
        
        System.out.println("Code point before index " + index + ": " + codePoint);
    }
}
 