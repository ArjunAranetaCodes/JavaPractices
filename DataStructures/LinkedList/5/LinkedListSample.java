import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.add('A');
        linkedList.add('B');
        linkedList.add('C');

        int size = linkedList.size();

        System.out.println("Size of LinkedList: " + size);
    }
}
