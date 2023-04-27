import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);

        System.out.println("Minimum Element: " + stack.getMin());
        stack.pop();
        System.out.println("Minimum Element: " + stack.getMin());
    }

    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                if (stack.pop().equals(minStack.peek())) {
                    minStack.pop();
                }
            }
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return minStack.peek();
        }
    }
}
