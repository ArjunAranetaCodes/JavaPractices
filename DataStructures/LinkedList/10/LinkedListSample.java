import java.util.LinkedList;
import java.util.Collections;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println("Original LinkedList: " + linkedList);

        Collections.reverse(linkedList);

        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
