import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Map;

public class ThreadSafeCache {
    private ConcurrentMap<String, String> cache;

    public ThreadSafeCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public int getHitCount() {
        return cache.size();
    }

    public static void main(String[] args) {
        ThreadSafeCache cache = new ThreadSafeCache();

        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        System.out.println("Cache entries:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Cache hit count: " + cache.getHitCount());
    }
}