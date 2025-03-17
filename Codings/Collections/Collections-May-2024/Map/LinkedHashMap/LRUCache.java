import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private LinkedHashMap<String, String> cache;

    public LRUCache(int size) {
        cache = new LinkedHashMap<>(size, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > LRUCache.this.size;
            }
        };
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put("Key1", "Value1");
        cache.put("Key2", "Value2");
        cache.put("Key3", "Value3");

        System.out.println("Cache entries:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        cache.get("Key2");

        System.out.println("After accessing Key2:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        cache.put("Key4", "Value4");

        System.out.println("After adding Key4:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}