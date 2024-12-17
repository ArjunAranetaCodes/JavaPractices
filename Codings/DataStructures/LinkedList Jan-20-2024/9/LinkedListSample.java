import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("First Element: " + numbers.getFirst());
        System.out.println("Last Element: " + numbers.getLast());
    }
}
