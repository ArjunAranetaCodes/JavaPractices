public class Main {
    public static void main(String[] args) {
        String original = "Hello";
        System.out.print("Reversed string: ");
        for (int i = original.length() - 1; i >= 0; i--) {
            System.out.print(original.charAt(i));
        }
    }
}
