import java.util.TreeSet;

class Person implements Comparable<Person> {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

public class TreeSetSample {
    public static void main(String[] args) {
        TreeSet<Person> personSet = new TreeSet<>();
        personSet.add(new Person("John"));
        personSet.add(new Person("Alice"));
        personSet.add(new Person("Bob"));

        System.out.println("TreeSet elements: " + personSet);
    }
}
