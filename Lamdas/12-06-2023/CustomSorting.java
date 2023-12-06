//Exercise 5: Custom Sorting
//Description: Sort a list of persons based on their age using lambdas.
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomSorting {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 28));
        persons.add(new Person("Bob", 22));
        persons.add(new Person("Charlie", 30));
        persons.add(new Person("David", 25));

        persons.sort(Comparator.comparingInt(Person::getAge));

        System.out.println(persons);
    }

    static class Person {
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

        @Override
        public String toString() {
            return name + " (" + age + " years)";
        }
    }
}
