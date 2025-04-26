import java.util.HashMap;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<String, Double> prices = new HashMap<>();
        prices.put("Apple", 1.99);
        prices.put("Banana", 0.99);
        prices.put("Orange", 2.49);

        // Clearing the HashMap
        prices.clear();

        System.out.println("HashMap after clearing: " + prices);
    }
}
