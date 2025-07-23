/**
 * Employee Payroll System - Advanced Encapsulation with Calculations
 * Demonstrates advanced encapsulation using Employee and PayrollSystem classes
 */
class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    private double bonus;
    private double taxRate;

    public Employee(int employeeId, String name, double baseSalary, double bonus, double taxRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.taxRate = taxRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    public void setBonus(double bonus) {
        if (bonus >= 0) {
            this.bonus = bonus;
        }
    }

    public void setTaxRate(double taxRate) {
        if (taxRate >= 0 && taxRate <= 100) {
            this.taxRate = taxRate;
        }
    }

    public double calculateNetSalary() {
        double gross = baseSalary + bonus;
        double tax = gross * (taxRate / 100.0);
        return gross - tax;
    }
}

public class PayrollSystem {
    private Employee[] employees;
    private int employeeCount;

    public PayrollSystem() {
        employees = new Employee[20];
        employeeCount = 0;
    }

    public boolean addEmployee(int id, String name, double baseSalary, double bonus, double taxRate) {
        if (getEmployeeById(id) != null) {
            System.out.println("Employee with ID " + id + " already exists.");
            return false;
        }
        if (employeeCount >= employees.length) {
            employees = java.util.Arrays.copyOf(employees, employees.length * 2);
        }
        employees[employeeCount++] = new Employee(id, name, baseSalary, bonus, taxRate);
        System.out.println("Employee added: " + name);
        return true;
    }

    public boolean removeEmployee(int id) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId() == id) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employeeCount--;
                System.out.println("Employee with ID " + id + " removed.");
                return true;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void listAllEmployees() {
        System.out.println("\nAll Employees:");
        if (employeeCount == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        for (int i = 0; i < employeeCount; i++) {
            Employee e = employees[i];
            System.out.printf("ID: %d, Name: %s, Net Salary: $%.2f\n", e.getEmployeeId(), e.getName(), e.calculateNetSalary());
        }
    }

    public static void main(String[] args) {
        PayrollSystem payroll = new PayrollSystem();
        payroll.addEmployee(1, "Alice", 4000, 500, 20);
        payroll.addEmployee(2, "Bob", 3500, 300, 18);
        payroll.addEmployee(3, "Charlie", 5000, 1000, 25);
        payroll.listAllEmployees();
        payroll.removeEmployee(2);
        payroll.listAllEmployees();
    }
} 