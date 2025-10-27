import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class LambdaIterationExample5 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 28));
        people.add(new Person("Bob", 35));
        people.add(new Person("Charlie", 22));

        // Using lambda expression to iterate through a list of custom objects
        people.forEach(person -> System.out.println(person.getName() + " is " + person.getAge() + " years old."));
    }
}
