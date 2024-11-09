## Problem: 
Implementing a Student Database

## Description: 
Create a program that demonstrates the use of Hashtable to implement a student database, which stores student information with their roll number as the key.

## Input:

Student information: {"1", "John Doe"}, {"2", "Jane Smith"}, {"3", "Bob Johnson"}

## Output:

Student database:

1 = John Doe

2 = Jane Smith

3 = Bob Johnson

## Code Answer:
```Java
import java.util.Hashtable;

public class StudentDatabase {
    private Hashtable<String, String> database;

    public StudentDatabase() {
        database = new Hashtable<>();
    }

    public void addStudent(String rollNumber, String name) {
        database.put(rollNumber, name);
    }

    public String getStudentName(String rollNumber) {
        return database.get(rollNumber);
    }

    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        database.addStudent("1", "John Doe");
        database.addStudent("2", "Jane Smith");
        database.addStudent("3", "Bob Johnson");

        System.out.println("Student database:");
        for (String rollNumber : database.database.keySet()) {
            System.out.println(rollNumber + " = " + database.getStudentName(rollNumber));
        }
    }
}
```

File Name: StudentDatabase.java

This program demonstrates the use of Hashtable to implement a student database, which stores student information with their roll number as the key. The StudentDatabase class uses a Hashtable to store student information, and provides methods for adding and retrieving student names. The main() method tests the database by adding student information and printing the student database.

Note: Hashtable is used to implement a student database, which stores student information with their roll number as the key. This is useful for creating databases, dictionaries, and other similar data structures that need to store information with a unique key.