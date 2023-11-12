import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class FlatMapExample4 {
    public static void main(String[] args) {
        List<List<String>> names = Arrays.asList(
                Arrays.asList("John", "Doe"),
                Arrays.asList("Jane", "Doe"),
                Arrays.asList("Bob", "Smith")
        );

        List<Person> people = names.stream()
                .flatMap(nameList -> nameList.stream().map(Person::new))
                .collect(Collectors.toList());

        people.forEach(person -> System.out.println(person.getName()));
    }
}
