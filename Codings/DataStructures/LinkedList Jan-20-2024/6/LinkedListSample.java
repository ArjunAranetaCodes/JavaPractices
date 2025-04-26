import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");

        System.out.println("Original LinkedList: " + animals);

        animals.clear();
        System.out.println("Cleared LinkedList: " + animals);
    }
}
