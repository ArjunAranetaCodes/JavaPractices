import java.util.LinkedList;

public class LinkedListDemo2 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Initial LinkedList: " + linkedList);

        // Add element at beginning
        linkedList.addFirst(10);
        System.out.println("LinkedList after adding 10 at beginning: " + linkedList);

        // Add element at end
        linkedList.addLast(20);
        System.out.println("LinkedList after adding 20 at end: " + linkedList);

        // Add element at beginning
        linkedList.addFirst(30);
        System.out.println("LinkedList after adding 30 at beginning: " + linkedList);

        // Get first element
        System.out.println("First element: " + linkedList.getFirst());

        // Get last element
        System.out.println("Last element: " + linkedList.getLast());

        // Remove first element
        linkedList.removeFirst();
        System.out.println("LinkedList after removing first element: " + linkedList);

        // Remove last element
        linkedList.removeLast();
        System.out.println("LinkedList after removing last element: " + linkedList);
    }
}