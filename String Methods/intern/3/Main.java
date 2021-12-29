public class Main {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = new String("Java").intern();
        
        System.out.println(str1 == str2); // Output: true
    }
}
 