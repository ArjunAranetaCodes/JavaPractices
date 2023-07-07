import java.util.*;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Salary: " + salary;
    }
}

public class TreeMapSample {
    public static void main(String[] args) {
        Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary);

        TreeMap<Employee, String> employeeMap = new TreeMap<>(salaryComparator);

        employeeMap.put(new Employee("Alice", 50000), "Department A");
        employeeMap.put(new Employee("Bob", 60000), "Department B");
        employeeMap.put(new Employee("Charlie", 55000), "Department C");

        System.out.println("Employee TreeMap (sorted by salary): " + employeeMap);
    }
}
