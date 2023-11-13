import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

public class FindFirstExample5 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alice"), new Person("Bob"), new Person("Charlie"));
        Optional<Person> firstPerson = people.stream().findFirst();

        firstPerson.ifPresent(
                result -> System.out.println("First person: " + result.name)
        );
    }
}
