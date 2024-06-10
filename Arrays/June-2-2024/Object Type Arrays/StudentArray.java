

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