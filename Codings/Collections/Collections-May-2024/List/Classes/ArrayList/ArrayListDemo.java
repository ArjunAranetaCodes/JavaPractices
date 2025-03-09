import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Add elements
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);

        System.out.println("Initial ArrayList: " + arrayList);

        // Add element at the end
        arrayList.add(60);
        System.out.println("ArrayList after adding 60: " + arrayList);

        // Remove element
        arrayList.remove(2);
        System.out.println("Removed element: " + 30);
        System.out.println("ArrayList after removing 30: " + arrayList);

        // Get element at index
        System.out.println("Element at index 2: " + arrayList.get(2));

        // Replace element at index
        arrayList.set(2, 70);
        System.out.println("ArrayList after replacing 40 with 70: " + arrayList);

        // Get size of ArrayList
        System.out.println("ArrayList size: " + arrayList.size());

        // Clear ArrayList
        arrayList.clear();
        System.out.println("ArrayList after clearing: " + arrayList);
    }
}