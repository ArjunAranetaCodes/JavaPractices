```java
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
```

## Explanation

1. The program defines a `Person` class with a name and age.
2. In the `main` method, a list of `Person` objects is created.
3. The `Collections.sort` method is used to sort the list of people by age. The sorting logic is provided as a lambda expression: `(p1, p2) -> p1.getAge() - p2.getAge()`. This lambda expression takes two `Person` objects and returns the difference between their ages, which is used for sorting.
4. The sorted list of people is printed using the `forEach` method and a lambda expression: `p -> System.out.println(p.getName() + " (" + p.getAge() + ")")`. This lambda expression takes a `Person` object and prints its name and age.
5. A `Runnable` object is created using a lambda expression: `() -> System.out.println("Running a lambda expression!")`. The `run` method of this `Runnable` is then called.
6. A new `Thread` is created using a lambda expression: `() -> System.out.println("Running a lambda expression in a thread!")`. The `start` method of this `Thread` is called to execute the lambda expression in a separate thread.

When you run this program, you should see the following output:

```
People sorted by age:
Charlie (20)
Alice (25)
Bob (30)
Running a lambda expression!
Running a lambda expression in a thread!
```

This example demonstrates how lambda expressions can be used to provide concise and readable code for sorting, iterating over collections, and creating instances of functional interfaces like `Runnable` and `Thread`.