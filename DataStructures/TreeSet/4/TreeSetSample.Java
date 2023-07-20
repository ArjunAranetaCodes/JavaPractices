import java.util.TreeSet;

public class TreeSetSample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);

        TreeSet<Integer> subSet = new TreeSet<>(treeSet.subSet(10, 30));

        System.out.println("Original TreeSet: " + treeSet);
        System.out.println("Subset (10 to 30): " + subSet);
    }
}
