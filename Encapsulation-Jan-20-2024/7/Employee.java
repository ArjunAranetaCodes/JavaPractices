public class Employee {
    private String name;
    private int employeeID;
    private double monthlySalary;

    public Employee(String empName, int empID, double empMonthlySalary) {
        name = empName;
        employeeID = empID;
        monthlySalary = empMonthlySalary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double calculateYearlySalary() {
        return monthlySalary * 12;
    }

    public void setMonthlySalary(double newMonthlySalary) {
        if (newMonthlySalary >= 0) {
            monthlySalary = newMonthlySalary;
        }
    }
}
