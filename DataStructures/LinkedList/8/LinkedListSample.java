import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Integer> originalList = new LinkedList<>();
        originalList.add(10);
        originalList.add(20);
        originalList.add(30);

        LinkedList<Integer> copiedList = new LinkedList<>(originalList);

        System.out.println("Original LinkedList: " + originalList);
        System.out.println("Copied LinkedList: " + copiedList);
    }
}
