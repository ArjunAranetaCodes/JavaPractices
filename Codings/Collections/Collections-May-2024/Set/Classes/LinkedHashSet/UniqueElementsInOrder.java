import java.util.*;

public class UniqueElementsInOrder {
    public static void main(String[] args) {
        List<String> elements = Arrays.asList(
                "Apple",
                "Banana",
                "Apple",
                "Orange",
                "Banana",
                "Grape"
        );

        Set<String> uniqueElements = new LinkedHashSet<>(elements);

        System.out.println("Unique elements in order: " + uniqueElements);
    }
}