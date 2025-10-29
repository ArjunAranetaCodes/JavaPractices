import java.util.Arrays;
import java.util.List;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class MaxExample5 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22)
        );
        Person oldestPerson = people.stream().max((p1, p2) -> Integer.compare(p1.age, p2.age)).orElse(null);
        System.out.println("Oldest person: " + oldestPerson.name);
    }
}
