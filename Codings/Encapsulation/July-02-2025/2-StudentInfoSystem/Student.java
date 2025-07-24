import java.util.Arrays;

/**
 * Student Information System - Encapsulation with Validation
 * Demonstrates encapsulation with comprehensive data validation
 */
public class Student {
    // Private fields - Data hiding with validation
    private int studentId;
    private String name;
    private int age;
    private String email;
    private double gpa;
    private String[] courses;
    private int courseCount;
    
    // Constructor with validation
    public Student(int studentId, String name, int age, String email, double gpa) {
        // Validate all parameters before setting
        if (!isValidStudentId(studentId)) {
            throw new IllegalArgumentException("Invalid student ID: " + studentId);
        }
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        if (!isValidAge(age)) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
        if (!isValidGpa(gpa)) {
            throw new IllegalArgumentException("Invalid GPA: " + gpa);
        }
        
        // Set validated values
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gpa = gpa;
        this.courses = new String[10]; // Initial capacity
        this.courseCount = 0;
    }
    
    // Private validation methods
    private boolean isValidStudentId(int studentId) {
        return studentId > 0;
    }
    
    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && 
               name.matches("^[a-zA-Z\\s]+$");
    }
    
    private boolean isValidAge(int age) {
        return age >= 16 && age <= 100;
    }
    
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
    
    private boolean isValidGpa(double gpa) {
        return gpa >= 0.0 && gpa <= 4.0;
    }
    
    // Public getter methods - Controlled access to private data
    public int getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public String[] getCourses() {
        // Return a copy to prevent external modification
        return Arrays.copyOf(courses, courseCount);
    }
    
    // Public setter methods with validation
    public boolean setName(String name) {
        if (isValidName(name)) {
            this.name = name;
            System.out.println("Name updated successfully to: " + name);
            return true;
        } else {
            System.out.println("Invalid name format. Name must contain only letters and spaces.");
            return false;
        }
    }
    
    public boolean setAge(int age) {
        if (isValidAge(age)) {
            this.age = age;
            System.out.println("Age updated successfully to: " + age);
            return true;
        } else {
            System.out.println("Invalid age. Age must be between 16 and 100.");
            return false;
        }
    }
    
    public boolean setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
            System.out.println("Email updated successfully to: " + email);
            return true;
        } else {
            System.out.println("Invalid email format. Please use format: user@domain.com");
            return false;
        }
    }
    
    public boolean setGpa(double gpa) {
        if (isValidGpa(gpa)) {
            this.gpa = gpa;
            System.out.println("GPA updated successfully to: " + gpa);
            return true;
        } else {
            System.out.println("Invalid GPA. GPA must be between 0.0 and 4.0.");
            return false;
        }
    }
    
    // Public business logic methods
    public boolean addCourse(String course) {
        if (course == null || course.trim().isEmpty()) {
            System.out.println("Course name cannot be null or empty.");
            return false;
        }
        
        // Check if course already exists
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equals(course)) {
                System.out.println("Course '" + course + "' is already enrolled.");
                return false;
            }
        }
        
        // Expand array if needed
        if (courseCount >= courses.length) {
            courses = Arrays.copyOf(courses, courses.length * 2);
        }
        
        courses[courseCount++] = course;
        System.out.println("Course '" + course + "' added successfully.");
        return true;
    }
    
    public boolean removeCourse(String course) {
        if (course == null || course.trim().isEmpty()) {
            System.out.println("Course name cannot be null or empty.");
            return false;
        }
        
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equals(course)) {
                // Shift remaining courses
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courseCount--;
                System.out.println("Course '" + course + "' removed successfully.");
                return true;
            }
        }
        
        System.out.println("Course '" + course + "' not found in enrolled courses.");
        return false;
    }
    
    public void displayStudentInfo() {
        System.out.println("\n=== Student Information ===");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + gpa);
        System.out.println("Enrolled Courses (" + courseCount + "):");
        
        if (courseCount == 0) {
            System.out.println("  No courses enrolled");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.println("  " + (i + 1) + ". " + courses[i]);
            }
        }
        System.out.println("===========================");
    }
    
    // Main method to demonstrate encapsulation with validation
    public static void main(String[] args) {
        System.out.println("=== Student Information System - Encapsulation with Validation ===\n");
        
        try {
            // Create a student with valid data
            Student student = new Student(1001, "John Smith", 20, "john.smith@university.edu", 3.5);
            student.displayStudentInfo();
            
            // Demonstrate valid updates
            System.out.println("\n--- Valid Updates ---");
            student.setName("John Michael Smith");
            student.setAge(21);
            student.setEmail("john.m.smith@university.edu");
            student.setGpa(3.7);
            
            // Demonstrate course management
            System.out.println("\n--- Course Management ---");
            student.addCourse("Computer Science 101");
            student.addCourse("Mathematics 201");
            student.addCourse("Physics 101");
            student.addCourse("Computer Science 101"); // Duplicate course
            
            // Demonstrate invalid updates
            System.out.println("\n--- Invalid Updates ---");
            student.setName("John123"); // Invalid name (contains numbers)
            student.setAge(15); // Invalid age (too young)
            student.setEmail("invalid-email"); // Invalid email format
            student.setGpa(4.5); // Invalid GPA (too high)
            
            // Demonstrate course removal
            System.out.println("\n--- Course Removal ---");
            student.removeCourse("Mathematics 201");
            student.removeCourse("Non-existent Course");
            
            // Final display
            student.displayStudentInfo();
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating student: " + e.getMessage());
        }
        
        // Demonstrate constructor validation
        System.out.println("\n--- Constructor Validation ---");
        try {
            Student invalidStudent = new Student(-1, "Invalid", 15, "invalid-email", 5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Constructor validation caught: " + e.getMessage());
        }
        
        System.out.println("\n=== Encapsulation with Validation Benefits ===");
        System.out.println("1. Data integrity: Only valid data is stored");
        System.out.println("2. Error prevention: Invalid states are prevented");
        System.out.println("3. Business rules: Domain-specific validation enforced");
        System.out.println("4. User feedback: Meaningful error messages provided");
        System.out.println("5. Defensive programming: Robust error handling");
    }
} 