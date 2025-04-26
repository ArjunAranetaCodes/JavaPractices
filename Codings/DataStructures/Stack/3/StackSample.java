import java.util.Stack;

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }
}

public class StackSample {
    public static void main(String[] args) {
        Stack<Student> studentStack = new Stack<>();
        studentStack.push(new Student("John"));
        studentStack.push(new Student("Alice"));

        // Pop and print student names
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            System.out.println("Popped student: " + student.name);
        }
    }
}
