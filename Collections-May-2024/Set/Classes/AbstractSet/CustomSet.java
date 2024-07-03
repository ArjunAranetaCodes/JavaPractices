import java.util.*;

public class CustomSet extends AbstractSet<String> {
    private List<String> elements = new ArrayList<>();

    public boolean add(String element) {
        if (!elements.contains(element)) {
            elements.add(element);
            return true;
        }
        return false;
    }

    public boolean contains(Object object) {
        return elements.contains(object);
    }

    public Iterator<String> iterator() {
        return elements.iterator();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        CustomSet set = new CustomSet();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple");
        set.add("Orange");

        System.out.println(set);
    }
}