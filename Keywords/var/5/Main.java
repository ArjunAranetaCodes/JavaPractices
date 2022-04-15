import java.util.List;

public class Main {
    public static void main(String[] args) {
        var names = List.of("Alice", "Bob", "Charlie");
        for (var name : names) {
            System.out.println("Hello, " + name + "!");
        }
    }
}
