import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Integer> sourceList = new LinkedList<>();
        sourceList.add(1);
        sourceList.add(2);
        sourceList.add(3);

        LinkedList<Integer> targetList = new LinkedList<>(sourceList);
        
        System.out.println("Source LinkedList: " + sourceList);
        System.out.println("Target LinkedList: " + targetList);
    }
}
