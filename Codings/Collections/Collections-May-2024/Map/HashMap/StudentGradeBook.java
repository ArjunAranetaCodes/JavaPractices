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
        for(Map.Entry<String, Integer> entry : gradeBook.grades.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}