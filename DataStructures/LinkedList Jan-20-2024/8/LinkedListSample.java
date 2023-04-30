import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();

        System.out.println("Is the LinkedList empty? " + names.isEmpty());

        names.add("John");
        names.add("Alice");

        System.out.println("Is the LinkedList empty? " + names.isEmpty());
    }
}
