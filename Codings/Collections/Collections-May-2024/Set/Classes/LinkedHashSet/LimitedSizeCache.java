import java.util.*;

public class LimitedSizeCache {
    private final int maxSize;
    private final LinkedHashSet<String> cache;

    public LimitedSizeCache(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new LinkedHashSet<>();
    }

    public void add(String element) {
        if (cache.size() >= maxSize) {
            // Remove the oldest element (first added)
            cache.remove(cache.iterator().next());
        }
        cache.add(element);
    }

    public Set<String> getCache() {
        return cache;
    }

    public static void main(String[] args) {
        LimitedSizeCache cache = new LimitedSizeCache(3);

        cache.add("A");
        cache.add("B");
        cache.add("C");
        cache.add("D");
        cache.add("E");
        cache.add("F");

        System.out.println("Cache contents: " + cache.getCache());
    }
}