// File name: ArrayListOperations.java

import java.util.ArrayList;

public class ArrayListOperations {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Add a new element
        list.add(6);

        // Remove an element
        list.remove((Integer) 4);

        // Search for an element
        int index = list.indexOf(3);

        // Print the updated list and the index of the searched element
        System.out.println("Updated List: " + list);
        System.out.println("Index of 3: " + index);
    }
}