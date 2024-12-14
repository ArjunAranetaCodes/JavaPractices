import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("apple");
        linkedList.add("banana");
        linkedList.add("orange");

        String searchElement = "banana";
        boolean containsElement = linkedList.contains(searchElement);

        System.out.println("LinkedList contains '" + searchElement + "': " + containsElement);
    }
}
