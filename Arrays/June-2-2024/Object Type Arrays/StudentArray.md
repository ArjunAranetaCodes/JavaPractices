## Problem: 
Creating an Array of Student Objects

## Description: 
Create a program that demonstrates the use of object type arrays to store and manipulate student information.

## Input:

Student information:

Student 1: John Doe, 20, Male

Student 2: Jane Smith, 22, Female

Student 3: Bob Johnson, 21, Male

## Output:

Student array:

Student 1: John Doe, 20, Male

Student 2: Jane Smith, 22, Female

Student 3: Bob Johnson, 21, Male

## Code Answer:
```Java
public class Student {
    private String name;
    private int age;
    private String gender;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

public class StudentArray {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("John Doe", 20, "Male");
        students[1] = new Student("Jane Smith", 22, "Female");
        students[2] = new Student("Bob Johnson", 21, "Male");

        for (Student student : students) {
            System.out.println("Student: " + student.getName() + ", " + student.getAge() + ", " + student.getGender());
        }
    }
}
```

File Name: StudentArray.java

This program demonstrates the use of object type arrays to store and manipulate student information. The Student class represents a student object, and the StudentArray class creates an array of Student objects.

Note: Object type arrays are used to store and manipulate objects, which can contain multiple attributes and methods. This is useful for creating arrays of complex data types, like objects, that need to be stored and manipulated.