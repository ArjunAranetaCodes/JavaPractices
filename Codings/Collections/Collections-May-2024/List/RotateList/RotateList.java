import java.util.ArrayList;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        int steps = 3;

        List<Integer> rotatedList = rotate(list, steps);

        System.out.println("Original list: " + list);
        System.out.println("Rotated list: " + rotatedList);
    }

    public static <T> List<T> rotate(List<T> list, int steps) {
        int n = list.size();
        steps = steps % n;
        List<T> rotatedList = new ArrayList<>(list.subList(n - steps, n));
        rotatedList.addAll(list.subList(0, n - steps));
        return rotatedList;
    }
}