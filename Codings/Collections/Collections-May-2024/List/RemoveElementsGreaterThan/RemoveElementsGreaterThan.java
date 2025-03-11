import java.util.ArrayList;
import java.util.List;

public class RemoveElementsGreaterThan {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        int givenValue = 5;

        List<Integer> listAfterRemoval = removeElementsGreaterThan(list, givenValue);

        System.out.println("List after removal: " + listAfterRemoval);
    }

    public static List<Integer> removeElementsGreaterThan(List<Integer> list, int givenValue) {
        List<Integer> newList = new ArrayList<>();
        for (Integer element : list) {
            if (element <= givenValue) {
                newList.add(element);
            }
        }
        return newList;
    }
}