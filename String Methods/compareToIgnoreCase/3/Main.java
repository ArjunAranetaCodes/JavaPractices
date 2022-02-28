public class Main {
    public static void main(String[] args) {
        String str1 = "Programming";
        String str2 = "programming";
        
        int result = str1.compareToIgnoreCase(str2);
        
        if (result < 0) {
            System.out.println("str1 comes before str2 ignoring case.");
        } else if (result > 0) {
            System.out.println("str1 comes after str2 ignoring case.");
        } else {
            System.out.println("str1 and str2 are equal ignoring case.");
        }
    }
}
 