import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Original LinkedList: " + numbers);

        numbers.addFirst(5);
        numbers.addLast(40);
        numbers.remove(2);

        System.out.println("Updated LinkedList: " + numbers);
    }
}
