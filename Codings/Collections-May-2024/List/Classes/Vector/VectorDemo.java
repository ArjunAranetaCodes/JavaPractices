import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();

        // Add elements
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);
        vector.add(50);

        System.out.println("Initial Vector: " + vector);

        // Add element at the end
        vector.add(60);
        System.out.println("Vector after adding 60: " + vector);

        // Remove element
        vector.remove(2);
        System.out.println("Removed element: " + 30);
        System.out.println("Vector after removing 30: " + vector);

        // Get element at index
        System.out.println("Element at index 2: " + vector.get(2));

        // Replace element at index
        vector.set(2, 70);
        System.out.println("Vector after replacing 40 with 70: " + vector);

        // Get size of vector
        System.out.println("Vector size: " + vector.size());

        // Clear vector
        vector.clear();
        System.out.println("Vector after clearing: " + vector);
    }
}