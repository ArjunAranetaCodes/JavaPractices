## Problem: 
Implementing a Student Grade Book

## Description: 
Create a program that demonstrates the use of HashMap to implement a student grade book.

## Input:

Student names and grades: {"John Doe", 85}, {"Alice Smith", 92}, {"Bob Johnson", 78}

## Output:

Student grade book:

John Doe = 85

Alice Smith = 92

Bob Johnson = 78

## Code Answer:
```Java
import java.util.HashMap;
import java.util.Map;

public class StudentGradeBook {
    private HashMap<String, Integer> grades;

    public StudentGradeBook() {
        grades = new HashMap<>();
    }

    public void addStudentGrade(String name, int grade) {
        grades.put(name, grade);
    }

    public int getStudentGrade(String name) {
        return grades.get(name);
    }

    public static void main(String[] args) {
        StudentGradeBook gradeBook = new StudentGradeBook();

        gradeBook.addStudentGrade("John Doe", 85);
        gradeBook.addStudentGrade("Alice Smith", 92);
        gradeBook.addStudentGrade("Bob Johnson", 78);

        System.out.println("Student grade book:");
        for (Map.Entry<String, Integer> entry : gradeBook.grades.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

File Name: StudentGradeBook.java

This program demonstrates the use of HashMap to implement a student grade book. The StudentGradeBook class uses a HashMap to store 
student names and grades, and provides methods for adding and retrieving grades. The main() method tests the grade book by adding student grades and printing the grade book.

Note: HashMap is a widely used data structure in Java, and is useful for creating dictionaries, caches, and other similar data structures that need to be accessed by key.