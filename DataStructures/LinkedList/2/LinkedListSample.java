import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(15);

        System.out.println("Original LinkedList: " + linkedList);

        linkedList.addFirst(2);
        linkedList.addLast(20);
        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println("Modified LinkedList: " + linkedList);
    }
}
