import java.util.HashMap;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, new Student("John"));
        studentMap.put(2, new Student("Alice"));
        studentMap.put(3, new Student("Bob"));

        // Accessing custom objects from the HashMap
        System.out.println("Student with key 2: " + studentMap.get(2).name);
    }
}
