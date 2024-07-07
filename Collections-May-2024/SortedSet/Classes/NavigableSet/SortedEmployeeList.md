## Problem: 
Implementing a Sorted List of Employees

## Description: 
Create a program that demonstrates the use of NavigableSet to implement a sorted list of employees.

## Input:

Employees: [{"John Doe", 30}, {"Alice Smith", 25}, {"Bob Johnson", 35}]

## Output:

Employees sorted by age:

Alice Smith (25)

John Doe (30)

Bob Johnson (35)

## Code Answer:

```Java
import java.util.*;

class Employee implements Comparable<Employee> {
String name;
int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class SortedEmployeeList {
public static void main(String[] args) {
NavigableSet<Employee> employees = new TreeSet<>();

        employees.add(new Employee("John Doe", 30));
        employees.add(new Employee("Alice Smith", 25));
        employees.add(new Employee("Bob Johnson", 35));

        System.out.println("Employees sorted by age:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
```

File Name: SortedEmployeeList.java

This program demonstrates the use of NavigableSet to implement a sorted list of employees. The Employee class implements the Comparable interface to compare employees by age. The NavigableSet class uses a tree for storage, and it provides methods for navigating and searching the elements in the set. The add method is used to add employees to the set, and the toString method is used to print the employees in the set.

Note: NavigableSet is a collection that stores elements in a sorted order, and it provides methods for navigating and searching the elements in the set. It is useful for implementing sorted lists and other similar operations.