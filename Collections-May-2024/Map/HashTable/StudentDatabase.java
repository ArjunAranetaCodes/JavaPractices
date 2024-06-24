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