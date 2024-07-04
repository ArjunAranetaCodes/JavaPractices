import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class Cache {
    private CopyOnWriteArraySet<String> keys = new CopyOnWriteArraySet<>();
    private Map<String, String> cache = new HashMap<>();

    public void put(String key, String value) {
        keys.add(key);
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void printCache() {
        System.out.println(cache);
    }

    public static void main(String[] args) {
        Cache cache = new Cache();

        Thread thread1 = new Thread(() -> {
            cache.put("Key1", "Value1");
        });

        Thread thread2 = new Thread(() -> {
            cache.put("Key2", "Value2");
        });

        Thread thread3 = new Thread(() -> {
            cache.put("Key3", "Value3");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cache.printCache();
    }
}