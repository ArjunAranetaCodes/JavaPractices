import java.util.LinkedList;

public class StackSample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    static class Stack<T> {
        private LinkedList<T> list = new LinkedList<>();

        public void push(T item) {
            list.addFirst(item);
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return list.removeFirst();
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return list.getFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
}
