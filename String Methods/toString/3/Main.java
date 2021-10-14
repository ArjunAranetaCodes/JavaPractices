public class Main {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "HELLO";

        if (str1.toLowerCase().equals(str2.toLowerCase())) {
            System.out.println("The strings are equal (case-insensitive).");
        } else {
            System.out.println("The strings are not equal.");
        }
    }
}
