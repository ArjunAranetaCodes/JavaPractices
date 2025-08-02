public class Student {
    private String name;
    private int age;
    private String course;

    public Student(String studentName, int studentAge, String studentCourse) {
        name = studentName;
        age = studentAge;
        course = studentCourse;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public void setAge(int newAge) {
        if (newAge >= 18 && newAge <= 40) {
            age = newAge;
        }
    }

    public void setCourse(String newCourse) {
        if (newCourse.equals("Computer Science") || newCourse.equals("Mathematics") || newCourse.equals("Physics")) {
            course = newCourse;
        }
    }
}
