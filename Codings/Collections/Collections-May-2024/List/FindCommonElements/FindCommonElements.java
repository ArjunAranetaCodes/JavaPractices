import java.util.ArrayList;
import java.util.List;

public class FindCommonElements {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Orange");

        List<String> list2 = new ArrayList<>();
        list2.add("Orange");
        list2.add("Mango");
        list2.add("Banana");

        List<String> commonElements = findCommonElements(list1, list2);

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Common elements: " + commonElements);
    }

    public static <T> List<T> findCommonElements(List<T> list1, List<T> list2) {
        List<T> commonElements = new ArrayList<>();
        for (T element : list1) {
            if (list2.contains(element)) {
                commonElements.add(element);
            }
        }
        return commonElements;
    }
}