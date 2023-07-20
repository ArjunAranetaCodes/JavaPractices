import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetSample {
    public static void main(String[] args) {
        NavigableSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);

        System.out.println("Ceiling for 15: " + treeSet.ceiling(15));
        System.out.println("Floor for 25: " + treeSet.floor(25));
    }
}
