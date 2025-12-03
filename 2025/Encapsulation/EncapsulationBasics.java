/**
 * Tutorial: Encapsulation Basics
 * Demonstrates data hiding using private access modifier
 */
public class EncapsulationBasics {
    // Private fields - data hiding
    private String name;
    private int age;
    private double salary;
    
    // Public getter methods - controlled access
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getSalary() {
        return salary;
    }
    
    // Public setter methods - controlled modification
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name");
        }
    }
    
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }
    
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary");
        }
    }
    
    public static void main(String[] args) {
        EncapsulationBasics person = new EncapsulationBasics();
        
        // Access through setters (with validation)
        person.setName("Alice");
        person.setAge(25);
        person.setSalary(50000);
        
        // Access through getters
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Salary: " + person.getSalary());
        
        // Invalid data is rejected
        person.setAge(-5);
        person.setSalary(-1000);
    }
}


















