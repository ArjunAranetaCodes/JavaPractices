import java.util.*;

public class AbstractListExample {
    public static void main(String[] args) {
        // Create an abstract list using one of its concrete subclasses (ArrayList)
        List<Integer> myList = new ArrayList<>();

        // Add some elements to the list
        myList.add(1);
        myList.add(2);
        myList.add(3);

        // Use some methods defined in the AbstractList class
        System.out.println("Size of myList: " + myList.size());
        System.out.println("Is myList empty? " + myList.isEmpty());
        System.out.println("Index of 2 in myList: " + myList.indexOf(2));

        // Modify the list using methods inherited from AbstractList
        myList.remove(0);
        myList.add(4, 5); // add 5 at index 4

        // Print out the modified list
        System.out.println("My List: " + myList);
    }
}