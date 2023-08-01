import java.util.HashSet;
import java.util.Iterator;

public class HashSetSample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Red");
        set.add("Green");
        set.add("Blue");

        System.out.println("HashSet elements:");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Other HashSet operations can be performed here
    }
}
