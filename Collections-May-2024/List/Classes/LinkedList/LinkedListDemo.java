import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Initial LinkedList: " + linkedList);

        // Add elements
        linkedList.add(10);
        System.out.println("LinkedList after adding 10: " + linkedList);
        linkedList.add(20);
        System.out.println("LinkedList after adding 20: " + linkedList);
        linkedList.add(30);
        System.out.println("LinkedList after adding 30: " + linkedList);

        // Remove element
        linkedList.remove(1);
        System.out.println("Removed element: " + 20);
        System.out.println("LinkedList after removing 20: " + linkedList);

        // Get element at index
        System.out.println("Element at index 0: " + linkedList.get(0));

        // Replace element at index
        linkedList.set(0, 40);
        System.out.println("LinkedList after replacing 10 with 40: " + linkedList);

        // Get size of LinkedList
        System.out.println("LinkedList size: " + linkedList.size());

        // Clear LinkedList
        linkedList.clear();
        System.out.println("LinkedList after clearing: " + linkedList);
    }
}