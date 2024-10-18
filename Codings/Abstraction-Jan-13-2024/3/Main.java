abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class Manager extends Employee {
    double bonus;

    Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    double calculateTotalSalary() {
        return salary + bonus;
    }
}

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("John", 50000.0, 10000.0);

        System.out.println("Total Salary for Manager " + manager.name + ": $" + manager.calculateTotalSalary());
    }
}
