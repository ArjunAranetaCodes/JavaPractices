import java.util.TreeSet;

public class TreeSetSample {
    public static void main(String[] args) {
        TreeSet<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        TreeSet<Integer> unionSet = new TreeSet<>(set1);
        unionSet.addAll(set2);

        TreeSet<Integer> intersectionSet = new TreeSet<>(set1);
        intersectionSet.retainAll(set2);

        System.out.println("Union Set: " + unionSet);
        System.out.println("Intersection Set: " + intersectionSet);
    }
}
