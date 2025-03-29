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