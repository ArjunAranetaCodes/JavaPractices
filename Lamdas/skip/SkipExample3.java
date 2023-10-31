import java.util.stream.Stream;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

public class SkipExample3 {
    public static void main(String[] args) {
        Stream<Person> people = Stream.of(
                new Person("Alice"),
                new Person("Bob"),
                new Person("Charlie"),
                new Person("David")
        );

        people.skip(2)
                .forEach(person -> System.out.println("Name: " + person.name));
    }
}
