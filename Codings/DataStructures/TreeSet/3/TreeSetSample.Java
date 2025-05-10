import java.util.TreeSet;
import java.util.Comparator;

public class TreeSetSample {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Orange");

        System.out.println("TreeSet elements (reverse order): " + treeSet);
    }
}
