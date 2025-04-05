import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
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
            System.out.println(cache.get("Key1"));
        });

        Thread thread4 = new Thread(() -> {
            System.out.println(cache.get("Key2"));
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}