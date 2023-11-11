import java.util.Arrays;
import java.util.List;

class Employee {
    private List<Double> salaries;

    public Employee(List<Double> salaries) {
        this.salaries = salaries;
    }

    public List<Double> getSalaries() {
        return salaries;
    }
}

public class FlatMapToDoubleExample3 {
    public static void main(String[] args) {
        // Example: FlatMapToDouble with objects
        List<Employee> employees = Arrays.asList(
                new Employee(Arrays.asList(3000.0, 4000.0)),
                new Employee(Arrays.asList(5000.0, 6000.0)),
                new Employee(Arrays.asList(7000.0, 8000.0))
        );

        employees.stream()
                .flatMapToDouble(employee -> employee.getSalaries().stream().mapToDouble(Double::doubleValue))
                .forEach(System.out::println);
    }
}
