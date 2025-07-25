# Student Information System - Encapsulation with Validation

## Overview
This program demonstrates encapsulation with comprehensive data validation. It shows how to protect student data while providing controlled access through well-defined interfaces with validation rules.

## What is Data Validation in Encapsulation?
Data validation ensures that only valid data is stored in the object's private fields. This is a crucial aspect of encapsulation that maintains data integrity and prevents invalid states.

## Key Concepts Demonstrated

### 1. Private Fields with Validation
- `studentId` - Must be a positive integer
- `name` - Must not be null or empty, must contain only letters and spaces
- `age` - Must be between 16 and 100
- `email` - Must follow email format validation
- `gpa` - Must be between 0.0 and 4.0
- `courses` - Array of enrolled courses

### 2. Validation Methods
- `isValidName()` - Validates student name format
- `isValidEmail()` - Validates email format using regex
- `isValidAge()` - Validates age range
- `isValidGpa()` - Validates GPA range
- `isValidStudentId()` - Validates student ID

### 3. Public Interface Methods
- `getStudentId()` - Returns student ID
- `getName()` - Returns student name
- `getAge()` - Returns student age
- `getEmail()` - Returns student email
- `getGpa()` - Returns current GPA
- `setName()` - Updates name with validation
- `setAge()` - Updates age with validation
- `setEmail()` - Updates email with validation
- `setGpa()` - Updates GPA with validation
- `addCourse()` - Adds a course to student's list
- `removeCourse()` - Removes a course from student's list
- `getCourses()` - Returns copy of courses array

## Benefits of Validation in Encapsulation

1. **Data Integrity**: Ensures only valid data is stored
2. **Error Prevention**: Prevents invalid states that could cause program errors
3. **Business Rules**: Enforces domain-specific validation rules
4. **User Feedback**: Provides meaningful error messages for invalid input
5. **Maintainability**: Centralizes validation logic in one place

## Code Structure

```java
public class Student {
    // Private fields with validation
    private int studentId;
    private String name;
    private int age;
    private String email;
    private double gpa;
    private String[] courses;
    
    // Constructor with validation
    public Student(int studentId, String name, int age, String email, double gpa)
    
    // Private validation methods
    private boolean isValidName(String name)
    private boolean isValidEmail(String email)
    private boolean isValidAge(int age)
    private boolean isValidGpa(double gpa)
    private boolean isValidStudentId(int studentId)
    
    // Public getter methods
    public int getStudentId()
    public String getName()
    public int getAge()
    public String getEmail()
    public double getGpa()
    public String[] getCourses()
    
    // Public setter methods with validation
    public boolean setName(String name)
    public boolean setAge(int age)
    public boolean setEmail(String email)
    public boolean setGpa(double gpa)
    
    // Public business logic methods
    public boolean addCourse(String course)
    public boolean removeCourse(String course)
    public void displayStudentInfo()
}
```

## Validation Rules Implemented

1. **Student ID**: Must be positive integer
2. **Name**: Must not be null/empty, only letters and spaces allowed
3. **Age**: Must be between 16 and 100
4. **Email**: Must follow standard email format (user@domain.com)
5. **GPA**: Must be between 0.0 and 4.0
6. **Courses**: Array management with bounds checking

## How to Run
1. Compile: `javac Student.java`
2. Run: `java Student`

## Expected Output
The program will demonstrate:
- Creating students with valid and invalid data
- Updating student information with validation
- Adding and removing courses
- Error handling for invalid input
- Displaying student information

## Learning Objectives
- Understand how to implement data validation in encapsulated classes
- Learn regex patterns for email validation
- See how to provide meaningful error messages
- Understand defensive programming techniques
- Learn best practices for data integrity 