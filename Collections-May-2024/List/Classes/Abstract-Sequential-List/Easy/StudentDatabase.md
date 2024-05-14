# Problem: 
Student Database

## Description: 
Create a Java program using the Abstract Sequential List Class (ArrayList) to manage a student database. The program should allow adding, removing, and searching for students by name or ID.

## Input:
A list of students (name, ID):
* John, 1
* Alice, 2
* Bob, 3
Add a new student: Charlie, 4
Remove a student by ID: 2
Search for a student by name: Bob

## Output:
The updated list of students after adding and removing:
* John, 1
* Bob, 3
* Charlie, 4
The student found by searching: Bob, 3

## Code Answer:
```
// File name: StudentDatabase.java

import java.util.ArrayList;

class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        (link unavailable) = id;
    }
}

public class StudentDatabase {
    public static void main(String[] args) {
        // Create an ArrayList to store students
        ArrayList<Student> students = new ArrayList<>();

        // Add students
        students.add(new Student("John", 1));
        students.add(new Student("Alice", 2));
        students.add(new Student("Bob", 3));

        // Add a new student
        students.add(new Student("Charlie", 4));

        // Remove a student by ID
        students.removeIf(student -> (link unavailable) == 2);

        // Search for a student by name
        Student foundStudent = null;
        for (Student student : students) {
            if (student.name.equals("Bob")) {
                foundStudent = student;
                break;
            }
        }

        // Print the updated list and the found student
        System.out.println("Updated Student List:");
        for (Student student : students) {
            System.out.println(student.name + ", " + (link unavailable));
        }
        System.out.println("Found Student: " + foundStudent.name + ", " + (link unavailable));
    }
}
```

## Explanation:
* We create a Student class to represent a student with a name and ID.
* We create an ArrayList to store Student objects.
* We add students to the list.
* We add a new student using the add() method.
* We remove a student by ID using the removeIf() method.
* We search for a student by name using a loop.
* We print the updated list and the found student.

<p>
Note: This code uses the ArrayList class from the Java Collections Framework, which is a built-in library in Java. The Abstract Sequential List Class is an abstract class that ArrayList extends, providing the basic implementation for a sequential list.
</p>