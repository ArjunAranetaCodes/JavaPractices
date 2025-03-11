import java.util.ArrayList;
import java.util.List;

public class FindCommonElementsInThreeLists {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);

        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(5);
        list3.add(9);
        list3.add(10);
        list3.add(11);

        List<Integer> commonElements = findCommonElements(list1, list2, list3);

        System.out.println("Common elements: " + commonElements);
    }

    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        List<Integer> commonElements = new ArrayList<>();
        for (Integer element : list1) {
            if (list2.contains(element) && list3.contains(element)) {
                commonElements.add(element);
            }
        }
        return commonElements;
    }
}