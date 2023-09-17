public class Student {
    private String name;
    private int age;
    private char grade;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }

    public void setGrade(char grade) {
        if (grade >= 'A' && grade <= 'F') {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade.");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGrade() {
        return grade;
    }
}
