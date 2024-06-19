import java.util.Map;
import java.util.HashMap;

public class Cache {
    private Map<String, String> cache;

    public Cache() {
        this.cache = new HashMap<>();
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        Cache cache = new Cache();

        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        System.out.println("Cached values:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}