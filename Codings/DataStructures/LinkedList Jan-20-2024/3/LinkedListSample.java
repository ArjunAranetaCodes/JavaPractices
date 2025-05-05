import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Double> prices = new LinkedList<>();
        prices.add(25.5);
        prices.add(30.0);
        prices.add(15.75);

        System.out.println("LinkedList Elements:");
        Iterator<Double> iterator = prices.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
