import java.util.LinkedList;
import java.util.Queue;

class Person {
    private String name;

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

        personQueue.offer(new Person("John"));
        personQueue.offer(new Person("Alice"));

        System.out.println("Person Queue: " + personQueue);
    }
}
