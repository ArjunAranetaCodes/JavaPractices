import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class PersonNameList {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alice"), new Person("Bob"), new Person("Charlie"));
        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Original List: " + people);
        System.out.println("Names List: " + names);
    }
}
