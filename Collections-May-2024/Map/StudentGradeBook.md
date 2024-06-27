## Problem: 
Implementing a Student Grade Book

## Description: 
Create a program that demonstrates the use of Map to implement a student grade book.

## Input:

Student names and grades: {"John", 85}, {"Alice", 92}, {"Bob", 78}

## Output:

Student grades:

John = 85

Alice = 92

Bob = 78

## Code Answer:
```Java
import java.util.Map;
import java.util.HashMap;

public class StudentGradeBook {
private Map<String, Integer> grades;

    public StudentGradeBook() {
        this.grades = new HashMap<>();
    }

    public void addStudentGrade(String name, int grade) {
        grades.put(name, grade);
    }

    public int getStudentGrade(String name) {
        return grades.get(name);
    }

    public static void main(String[] args) {
        StudentGradeBook gradeBook = new StudentGradeBook();

        gradeBook.addStudentGrade("John", 85);
        gradeBook.addStudentGrade("Alice", 92);
        gradeBook.addStudentGrade("Bob", 78);

        System.out.println("Student grades:");
        for (Map.Entry<String, Integer> entry : gradeBook.grades.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

File Name: StudentGradeBook.java

This program demonstrates the use of Map to implement a student grade book. The StudentGradeBook class uses a HashMap to store student names and grades. The addStudentGrade method adds a student's grade to the grade book, and the getStudentGrade method retrieves a student's grade by their name. The program prints the student grades.

Note: Map is a collection that stores key-value pairs, and it provides methods for navigating and searching the elements in the map. It is useful for implementing dictionaries, caches, and other similar data structures.