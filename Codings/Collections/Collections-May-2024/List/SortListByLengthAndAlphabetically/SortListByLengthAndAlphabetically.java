import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListByLengthAndAlphabetically {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cat");
        list.add("dog");
        list.add("elephant");
        list.add("fish");

        Collections.sort(list, new StringComparator());

        System.out.println("Sorted list: " + list);
    }
}

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return Integer.compare(s1.length(), s2.length());
        } else {
            return s1.compareTo(s2);
        }
    }
}