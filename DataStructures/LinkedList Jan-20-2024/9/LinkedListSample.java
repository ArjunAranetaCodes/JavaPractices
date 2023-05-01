import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("red");
        linkedList.add("green");
        linkedList.add("blue");

        System.out.println("Original LinkedList: " + linkedList);

        linkedList.remove("green");

        System.out.println("LinkedList after removal: " + linkedList);
    }
}
