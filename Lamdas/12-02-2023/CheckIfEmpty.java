import java.util.Collections;
import java.util.List;

public class CheckIfEmpty {
    public static void main(String[] args) {
        List<String> words = Collections.emptyList();
        boolean isEmpty = words.isEmpty();
        System.out.println("List is empty: " + isEmpty);
    }
}
