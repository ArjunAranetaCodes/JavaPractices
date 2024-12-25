import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        int[] array = {4, 5, 2, 10, 8};
        printNextGreaterElements(array);
    }

    private static void printNextGreaterElements(int[] array) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();

        for (int num : array) {
            while (!stack.isEmpty() && num > stack.peek()) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        for (int num : array) {
            System.out.println("Next Greater Element for " + num + ": " + nextGreaterMap.get(num));
        }
    }
}
