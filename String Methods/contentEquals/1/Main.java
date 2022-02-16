public class Main {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        boolean result = str1.contentEquals(str2);
        System.out.println("Are the strings equal? " + result);
    }
}
