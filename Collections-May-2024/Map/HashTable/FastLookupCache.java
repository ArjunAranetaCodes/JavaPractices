import java.util.Hashtable;

public class FastLookupCache {
    private Hashtable<String, String> cache;

    public FastLookupCache() {
        cache = new Hashtable<>();
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        FastLookupCache cache = new FastLookupCache();

        cache.put("Key1", "Value1");
        cache.put("Key2", "Value2");
        cache.put("Key3", "Value3");

        System.out.println("Cache entries:");
        for (String key : cache.cache.keySet()) {
            System.out.println(key + " = " + cache.get(key));
        }
    }
}