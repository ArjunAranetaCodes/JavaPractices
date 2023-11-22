import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class AnyMatchExample3 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22))
        );

        boolean anyMatch = people.stream().anyMatch(person -> person.age > 25);

        System.out.println("Any person older than 25: " + anyMatch);
    }
}
// Output: Any person older than 25: true
