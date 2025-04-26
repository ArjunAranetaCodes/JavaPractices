import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        String expression = "{[()]}";
        boolean isBalanced = isBalanced(expression);
        System.out.println("Is the expression balanced? " + isBalanced);
    }

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Unmatched closing bracket
            }
        }

        return stack.isEmpty(); // Stack should be empty for balanced expression
    }
}
