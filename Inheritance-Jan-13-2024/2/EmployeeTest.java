class Employee {
    String name;
    int employeeID;
    double salary;

    Employee(String name, int employeeID, double salary) {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
    }

    // Getters and setters for basic information
    // ...

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {

    Manager(String name, int employeeID, double salary) {
        super(name, employeeID, salary);
    }
}

class Developer extends Employee {

    Developer(String name, int employeeID, double salary) {
        super(name, employeeID, salary);

    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager("John Doe", 101, 80000);
        manager.displayInfo();

        Developer developer = new Developer("Jane Smith", 201, 60000);
        developer.displayInfo();
    }
}
