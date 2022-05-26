class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

class Employee extends Person {
    String department;

    Employee(String name, String department) {
        this.department = department;
    }

    void displayInfo() {
        System.out.println("Employee name: " + super.name); // Using super to access superclass field
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("John", "IT");
        emp.displayInfo();
    }
}
