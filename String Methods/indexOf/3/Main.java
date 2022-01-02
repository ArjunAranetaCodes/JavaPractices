import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");

        for (String fruit : hashSet) {
            System.out.println("HashCode of " + fruit + ": " + fruit.hashCode());
        }
    }
}
   