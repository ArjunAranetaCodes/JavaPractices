public class Main {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "hello";

        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("The strings are equal (case-insensitive).");
        } else {
            System.out.println("The strings are not equal.");
        }
    }
}
   