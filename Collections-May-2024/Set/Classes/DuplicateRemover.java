import java.util.*;

public class DuplicateRemover {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Hello");
        list.add("Java");
        list.add("World");
        list.add("Java");

        Set<String> set = new HashSet<>(list);

        System.out.println(set);
    }
}