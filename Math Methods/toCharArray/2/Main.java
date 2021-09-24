public class Main {
    public static void main(String[] args) {
        String str = "Java Programming";
        char[] charArray = str.toCharArray();

        System.out.print("Original String: " + str);
        System.out.print("\nReversed String: ");
        for (int i = charArray.length - 1; i >= 0; i--) {
            System.out.print(charArray[i]);
        }
    }
}
    