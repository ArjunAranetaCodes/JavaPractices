import java.util.LinkedList;
import java.util.Queue;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class QueueSample {
    public static void main(String[] args) {
        Queue<Person> personQueue = new LinkedList<>();

        personQueue.add(new Person("Alice"));
        personQueue.add(new Person("Bob"));
        personQueue.add(new Person("Charlie"));

        System.out.println("Person Queue: " + personQueue);
    }
}
