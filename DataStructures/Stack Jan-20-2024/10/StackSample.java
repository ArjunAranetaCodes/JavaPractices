import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println("Is valid stack sequence: " + validateStackSequences(pushed, popped));
    }

    private static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}
