public class Main {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = "java";
        
        int result = str1.compareToIgnoreCase(str2);
        
        if (result == 0) {
            System.out.println("Strings are equal ignoring case.");
        } else {
            System.out.println("Strings are not equal ignoring case.");
        }
    }
}
 