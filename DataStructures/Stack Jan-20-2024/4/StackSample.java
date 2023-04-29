import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        String postfixExpression = "34+2*";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result of the postfix expression: " + result);
    }

    private static int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : postfixExpression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }
}
