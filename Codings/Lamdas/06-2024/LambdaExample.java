import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 20));

        // Sort people by age using a lambda expression
        Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());

        System.out.println("People sorted by age:");
        people.forEach(p -> System.out.println(p.getName() + " (" + p.getAge() + ")"));

        // Use a lambda expression to create a Runnable
        Runnable runnable = () -> System.out.println("Running a lambda expression!");
        runnable.run();

        // Use a lambda expression to create a Thread
        Thread thread = new Thread(() -> System.out.println("Running a lambda expression in a thread!"));
        thread.start();
    }
}

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