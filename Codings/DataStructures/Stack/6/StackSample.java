import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);

        System.out.println("Min Element: " + minStack.getMin()); // Output: 2

        minStack.pop();
        System.out.println("Min Element after pop: " + minStack.getMin()); // Output: 3
    }
}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

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
        return minStack.peek();
    }
}
