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

public class ObjectSortExample {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22)
        );

        personList.stream().sorted((p1, p2) -> p1.name.compareTo(p2.name)).forEach(p -> System.out.println(p.name));
    }
}
