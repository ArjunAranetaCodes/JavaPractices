import java.util.Arrays;
import java.util.List;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class FindAnyCustomObjectExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alice"), new Person("Bob"), new Person("Charlie"));

        String result = people.stream()
                .filter(p -> p.getName().startsWith("B"))
                .findAny()
                .map(Person::getName)
                .orElse("Not found");

        System.out.println("Any person with name starting with 'B': " + result);
    }
}
