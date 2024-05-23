import java.util.ArrayDeque;
import java.util.Deque;

public class CacheSystem {
    private Deque<String> cache = new ArrayDeque<>(5);

    public void addItem(String item) {
        cache.addLast(item);
        System.out.println(item + " added to cache");
    }

    public String getItem(String item) {
        if (cache.contains(item)) {
            return cache.pollFirst();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        CacheSystem cacheSystem = new CacheSystem();

        cacheSystem.addItem("Item 1");
        cacheSystem.addItem("Item 2");
        System.out.println(cacheSystem.getItem("Item 1"));
        cacheSystem.addItem("Item 3");
        System.out.println(cacheSystem.getItem("Item 2"));
    }
}