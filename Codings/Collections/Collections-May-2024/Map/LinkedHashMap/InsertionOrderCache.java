import java.util.LinkedHashMap;
import java.util.Map;

public class InsertionOrderCache {
    private LinkedHashMap<String, String> cache;

    public InsertionOrderCache() {
        cache = new LinkedHashMap<>();
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        InsertionOrderCache cache = new InsertionOrderCache();

        cache.put("Key1", "Value1");
        cache.put("Key2", "Value2");
        cache.put("Key3", "Value3");
        cache.put("Key4", "Value4");

        System.out.println("Cache entries in order of insertion:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}