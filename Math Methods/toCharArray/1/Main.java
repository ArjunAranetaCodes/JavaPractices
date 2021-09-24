public class Main {
    public static void main(String[] args) {
        String str = "Hello, World!";
        char[] charArray = str.toCharArray();

        System.out.print("Original String: " + str);
        System.out.print("\nChar Array: ");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
    }
}
