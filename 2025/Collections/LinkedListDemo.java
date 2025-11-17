/**
 * Tutorial: LinkedList
 * Demonstrates LinkedList operations
 */
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        // Create LinkedList
        LinkedList<String> list = new LinkedList<>();
        
        // Add elements
        list.add("First");
        list.add("Second");
        list.addLast("Last");
        list.addFirst("Very First");
        
        System.out.println("List: " + list);
        
        // Access elements
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        
        // Remove elements
        list.removeFirst();
        list.removeLast();
        System.out.println("After removal: " + list);
        
        // Queue operations
        list.offer("Queue Element");
        System.out.println("After offer: " + list);
        System.out.println("Peek: " + list.peek());
        System.out.println("Poll: " + list.poll());
        System.out.println("After poll: " + list);
        
        // Stack operations
        list.push("Stack Element");
        System.out.println("After push: " + list);
        System.out.println("Pop: " + list.pop());
        System.out.println("After pop: " + list);
    }
}










