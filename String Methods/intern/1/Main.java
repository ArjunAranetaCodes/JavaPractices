public class Main {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = str1.intern();
        
        System.out.println(str1 == str2); // Output: false
    }
}
``
 