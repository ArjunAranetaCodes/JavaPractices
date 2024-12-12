import java.util.HashMap;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<String, Integer> population = new HashMap<>();
        population.put("New York", 8398748);
        population.put("Los Angeles", 3990456);
        population.put("Chicago", 2716000);

        // Getting the size of the HashMap
        int size = population.size();
        System.out.println("Size of the population HashMap: " + size);
    }
}
