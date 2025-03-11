import java.util.ArrayList;
import java.util.List;

public class FindFirstDuplicate {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(1);

        Integer firstDuplicate = findFirstDuplicate(list);

        System.out.println("First duplicate: " + firstDuplicate);
    }

    public static Integer findFirstDuplicate(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    return list.get(i);
                }
            }
        }
        return null;
    }
}