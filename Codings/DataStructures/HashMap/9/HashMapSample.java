import java.util.HashMap;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(101, "John Doe");
        employeeMap.put(102, "Jane Smith");
        employeeMap.put(103, "Bob Johnson");

        // Displaying employee names using key
        for (int empId : employeeMap.keySet()) {
            System.out.println("Employee ID: " + empId + ", Name: " + employeeMap.get(empId));
        }
    }
}
