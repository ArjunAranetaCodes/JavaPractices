import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Double> linkedList = new LinkedList<>();
        linkedList.add(2.5);
        linkedList.add(4.7);
        linkedList.add(6.3);

        System.out.println("LinkedList Elements:");

        Iterator<Double> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
