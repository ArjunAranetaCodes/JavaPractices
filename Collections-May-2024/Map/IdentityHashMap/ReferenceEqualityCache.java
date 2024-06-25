import java.util.IdentityHashMap;
import java.util.Map;

public class ReferenceEqualityCache {
    private IdentityHashMap<Object, Object> cache;

    public ReferenceEqualityCache() {
        cache = new IdentityHashMap<>();
    }

    public void put(Object key, Object value) {
        cache.put(key, value);
    }

    public Object get(Object key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        ReferenceEqualityCache cache = new ReferenceEqualityCache();

        String key1 = new String("Key1");
        String key2 = new String("Key1");

        cache.put(key1, "Value1");
        cache.put(key2, "Value2");

        System.out.println("Cache entries:");
        for (Map.Entry<Object, Object> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Getting value for key1: " + cache.get(key1));
        System.out.println("Getting value for key2: " + cache.get(key2));
    }
}