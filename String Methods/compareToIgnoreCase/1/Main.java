public class Main {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "hello";
        
        int result = str1.compareToIgnoreCase(str2);
        
        System.out.println("Comparison result: " + result);
    }
}
  