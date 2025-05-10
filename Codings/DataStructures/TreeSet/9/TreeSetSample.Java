import java.util.TreeSet;

public class TreeSetSample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);

        System.out.println("HeadSet (less than 25): " + treeSet.headSet(25));
        System.out.println("TailSet (greater than or equal to 20): " + treeSet.tailSet(20));
    }
}
