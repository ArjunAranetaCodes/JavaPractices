import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        String reversedString = reverseString(originalString);
        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
    }

    private static String reverseString(String originalString) {
        Stack<Character> stack = new Stack<>();

        for (char ch : originalString.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString();
    }
}
