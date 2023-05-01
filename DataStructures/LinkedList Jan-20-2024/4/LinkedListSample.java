import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        String searchElement = "Banana";
        if (fruits.contains(searchElement)) {
            System.out.println(searchElement + " found in the LinkedList.");
        } else {
            System.out.println(searchElement + " not found in the LinkedList.");
        }
    }
}
