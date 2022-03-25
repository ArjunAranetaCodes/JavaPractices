public class Main {
    public static void main(String[] args) {
        String original = "OpenAI";
        StringBuilder reversed = new StringBuilder();

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed.append(original.charAt(i));
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed.toString());
    }
}
