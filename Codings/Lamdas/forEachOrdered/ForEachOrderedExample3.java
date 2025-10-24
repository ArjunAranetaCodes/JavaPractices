import java.util.Arrays;
import java.util.List;

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class ForEachOrderedExample3 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alice"), new Person("Bob"), new Person("Charlie"));

        // Using forEachOrdered to print names in order
        people.stream().map(Person::getName).forEachOrdered(name -> System.out.print(name + " "));
    }
}
