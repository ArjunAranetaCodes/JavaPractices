import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("Initial Stack: " + stack);

        // Push elements
        stack.push(10);
        System.out.println("Stack after pushing 10: " + stack);
        stack.push(20);
        System.out.println("Stack after pushing 20: " + stack);
        stack.push(30);
        System.out.println("Stack after pushing 30: " + stack);

        // Pop element
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after popping: " + stack);

        // Peek element
        System.out.println("Peek element: " + stack.peek());

        // Check if stack is empty
        System.out.println("Stack is empty: " + stack.empty());

        // Search element
        System.out.println("Search 20: " + stack.search(20));

        // Clear stack
        stack.clear();
        System.out.println("Stack is empty after clearing: " + stack.empty());
    }
}