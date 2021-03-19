import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3, 4.4);
        printList(intList);    // Output: 1 2 3 4
        printList(doubleList); // Output: 1.1 2.2 3.3 4.4
    }

    static void printList(List<? extends Number> list) {
        for (Number element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
