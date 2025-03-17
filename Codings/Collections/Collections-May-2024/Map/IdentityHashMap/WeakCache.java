import java.lang.ref.WeakReference;
import java.util.IdentityHashMap;
import java.util.Map;

public class WeakCache {
    private IdentityHashMap<WeakReference<Object>, Object> cache;

    public WeakCache() {
        cache = new IdentityHashMap<>();
    }

    public void put(Object key, Object value) {
        cache.put(new WeakReference<>(key), value);
    }

    public Object get(Object key) {
        return cache.get(new WeakReference<>(key));
    }

    public static void main(String[] args) {
        WeakCache cache = new WeakCache();

        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();

        cache.put(key1, "Value1");
        cache.put(key2, "Value2");
        cache.put(key3, "Value3");

        System.out.println("Cache entries:");
        for (Map.Entry<WeakReference<Object>, Object> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey().get() + " = " + entry.getValue());
        }

        // Allow key1 and key2 to be garbage collected
        key1 = null;
        key2 = null;

        System.gc();

        System.out.println("After garbage collection:");
        for (Map.Entry<WeakReference<Object>, Object> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey().get() + " = " + entry.getValue());
        }
    }
}