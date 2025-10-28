import java.util.Arrays;
import java.util.List;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class MaxExample3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 50000),
                new Employee("Alice", 60000),
                new Employee("Bob", 55000)
        );
        Employee highestPaidEmployee = employees.stream().max((e1, e2) -> Double.compare(e1.salary, e2.salary)).orElse(null);
        System.out.println("Highest paid employee: " + highestPaidEmployee.name);
    }
}
