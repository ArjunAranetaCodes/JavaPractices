import java.util.HashSet;
import java.util.Set;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}
  
public class Main {
    public static void main(String[] args) {
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("Alice"));
        personSet.add(new Person("Bob"));
        personSet.add(new Person("Charlie"));

        Person targetPerson = new Person("Bob");

        if (personSet.contains(targetPerson)) {
            System.out.println("The Set contains the target person.");
        } else {
            System.out.println("The Set does not contain the target person.");
        }
    }
}
