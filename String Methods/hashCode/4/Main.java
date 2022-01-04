import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Creating a HashMap with String keys and values
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);

        for (String key : hashMap.keySet()) {
            System.out.println("HashCode of key '" + key + "': " + key.hashCode());
        }
    }
}
   