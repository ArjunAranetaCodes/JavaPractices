import java.util.TreeSet;

public class TreeSetSample {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Orange");

        System.out.println("Does 'Banana' exist? " + treeSet.contains("Banana"));
        System.out.println("Does 'Grapes' exist? " + treeSet.contains("Grapes"));
    }
}
