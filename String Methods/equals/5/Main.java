public class Main {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = "java";
        
        boolean result = str1.equalsIgnoreCase(str2);
        System.out.println("Are str1 and str2 equal (case-insensitive)? " + result);
    }
}
   