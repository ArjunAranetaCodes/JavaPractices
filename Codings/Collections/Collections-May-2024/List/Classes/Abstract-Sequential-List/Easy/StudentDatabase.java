import java.util.ArrayList;

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
        students.removeIf(student -> student.id == 2);

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
            System.out.println(student.name + ", " + (student.id));
        }
        System.out.println("The student found by searching: " + foundStudent.name + ", " + foundStudent.id);
    }
}

class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}