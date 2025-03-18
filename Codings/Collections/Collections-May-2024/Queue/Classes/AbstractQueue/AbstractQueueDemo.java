import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

public class AbstractQueueDemo {
    public static void main(String[] args) {
        AbstractQueue<Integer> abstractQueue = new AbstractQueue<Integer>() {
            private ArrayList<Integer> list = new ArrayList<>();

            @Override
            public Iterator<Integer> iterator() {
                return list.iterator();
            }

            @Override
            public int size() {
                return list.size();
            }

            @Override
            public boolean offer(Integer e) {
                return list.add(e);
            }

            @Override
            public Integer peek() {
                return list.get(0);
            }

            @Override
            public Integer poll() {
                return list.remove(0);
            }

            @Override
            public boolean remove(Object o) {
                return list.remove(o);
            }
        };

        System.out.println("Initial AbstractQueue: " + abstractQueue);

        // Add elements
        abstractQueue.add(10);
        System.out.println("AbstractQueue after adding 10: " + abstractQueue);
        abstractQueue.add(20);
        System.out.println("AbstractQueue after adding 20: " + abstractQueue);
        abstractQueue.add(30);
        System.out.println("AbstractQueue after adding 30: " + abstractQueue);

        // Remove element
        System.out.println("Removed element: " + abstractQueue.remove());
        System.out.println("AbstractQueue after removing: " + abstractQueue);

        // Peek element
        System.out.println("Peeked element: " + abstractQueue.peek());

        // Get abstractQueue size
        System.out.println("AbstractQueue size: " + abstractQueue.size());

        // Check if abstractQueue is empty
        System.out.println("AbstractQueue is empty: " + abstractQueue.isEmpty());

        // Offer element
        System.out.println("Offered element 40: " + abstractQueue.offer(40));
        System.out.println("AbstractQueue after offering: " + abstractQueue);

        // Poll element
        System.out.println("Polled element: " + abstractQueue.poll());
        System.out.println("AbstractQueue after polling: " + abstractQueue);

        // Check if abstractQueue is empty
        System.out.println("AbstractQueue is empty: " + abstractQueue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + abstractQueue.remove());
        System.out.println("AbstractQueue after removing: " + abstractQueue);

        // Remove element using remove
        System.out.println("Removed element using remove: " + abstractQueue.remove());
        System.out.println("AbstractQueue after removing: " + abstractQueue);

        // Check if abstractQueue is empty
        System.out.println("AbstractQueue is empty: " + abstractQueue.isEmpty());
    }
}