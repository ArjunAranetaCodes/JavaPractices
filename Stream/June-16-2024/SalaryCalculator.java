import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalaryCalculator {

    /**
     * Calculates the total salary for each department given a list of employees.
     *
     * @param employees A list of Employee objects representing the input dataset.
     * @return A Map where the keys are department names, and the values are the corresponding total salaries.
     */
    public static Map<String, Double> calculateTotalSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)
                ));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John Doe", "IT", 5000.0),
                new Employee("Jane Smith", "HR", 4500.0),
                new Employee("Bob Johnson", "IT", 6000.0),
                new Employee("Alice Williams", "HR", 5200.0),
                new Employee("Charlie Brown", "Finance", 6500.0)
        );

        Map<String, Double> totalSalaryByDepartment = calculateTotalSalaryByDepartment(employees);
        System.out.println(totalSalaryByDepartment);
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
