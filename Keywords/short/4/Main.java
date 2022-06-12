public class Main {
    public static void main(String[] args) {
        String input = "Hello, World!";
        int length = calculateStringLength(input);
        System.out.println("String Length: " + length);
    }

    static int calculateStringLength(String str) {
        return str.length();
    }
}
