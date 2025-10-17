import java.util.stream.Stream;

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class StreamBuilderExample4 {
    public static void main(String[] args) {
        Stream<Person> stream = Stream.<Person>builder()
                .add(new Person("John"))
                .add(new Person("Alice"))
                .add(new Person("Bob"))
                .build();

        stream.map(Person::getName)
                .forEach(System.out::println);
    }
}
