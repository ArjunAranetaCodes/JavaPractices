import java.util.TreeSet;

public class TreeSetSample {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Orange");

        System.out.println("Original TreeSet: " + treeSet);

        // Clearing the TreeSet
        treeSet.clear();

        System.out.println("TreeSet after clearing: " + treeSet);
    }
}
