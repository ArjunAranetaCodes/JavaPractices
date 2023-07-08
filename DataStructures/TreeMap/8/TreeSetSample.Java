import java.util.*;

class Student implements Comparable<Student> {
    private int rollNumber;
    private String name;

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNumber, other.rollNumber);
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name;
    }
}

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMap<Student, String> studentMap = new TreeMap<>();

        studentMap.put(new Student(101, "Alice"), "Grade A");
        studentMap.put(new Student(102, "Bob"), "Grade B");
        studentMap.put(new Student(103, "Charlie"), "Grade C");

        System.out.println("Student TreeMap: " + studentMap);
    }
}
