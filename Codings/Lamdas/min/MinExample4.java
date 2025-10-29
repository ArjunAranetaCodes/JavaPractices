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

public class MinExample4 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 50000),
                new Employee("Alice", 60000),
                new Employee("Bob", 45000)
        );

        Employee minSalaryEmployee = employees.stream().min((e1, e2) -> Double.compare(e1.salary, e2.salary)).orElse(null);

        System.out.println("Employee with minimum salary: " + minSalaryEmployee.name);
    }
}
