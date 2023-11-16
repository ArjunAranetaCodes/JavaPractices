import java.util.Arrays;
import java.util.List;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

public class DistinctObjects {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alice"), new Person("Bob"),
                new Person("Alice"), new Person("Charlie"));

        // Using distinct() with lambda expression to get distinct objects based on their names
        people.stream()
                .distinct()
                .forEach(person -> System.out.println(person.name));
    }
}
