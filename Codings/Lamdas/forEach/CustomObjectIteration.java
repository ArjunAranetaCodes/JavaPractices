import java.util.Arrays;
import java.util.List;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

public class CustomObjectIteration {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice"),
                new Person("Bob"),
                new Person("Charlie")
        );

        // Using forEach() to print names of people
        people.forEach(person -> System.out.println(person.name));
    }
}
