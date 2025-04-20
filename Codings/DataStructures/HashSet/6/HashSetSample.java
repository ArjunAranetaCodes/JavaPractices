import java.util.HashSet;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class HashSetSample {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("Alice"));
        set.add(new Person("Bob"));
        set.add(new Person("Charlie"));

        System.out.println("HashSet elements: " + set);

        // Other HashSet operations can be performed here
    }
}
