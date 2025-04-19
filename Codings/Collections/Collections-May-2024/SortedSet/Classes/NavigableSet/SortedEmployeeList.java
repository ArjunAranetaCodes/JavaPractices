import java.util.*;

public class SortedEmployeeList {
    public static void main(String[] args) {
        NavigableSet<Employee> employees = new TreeSet<>();

        employees.add(new Employee("John Doe", 30));
        employees.add(new Employee("Alice Smith", 25));
        employees.add(new Employee("Bob Johnson", 35));

        System.out.println("Employees sorted by age:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Employee implements Comparable<Employee> {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}