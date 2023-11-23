import java.util.Arrays;
import java.util.List;

public class AllMatchExample2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Amy", "Andrew");

        boolean allStartsWithA = names.stream().allMatch(name -> name.startsWith("A"));

        System.out.println("Do all names start with 'A'? " + allStartsWithA);
    }
}
