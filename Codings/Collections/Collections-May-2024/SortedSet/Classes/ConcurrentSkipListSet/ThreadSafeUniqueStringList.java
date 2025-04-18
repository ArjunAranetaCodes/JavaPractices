import java.util.concurrent.ConcurrentSkipListSet;

public class ThreadSafeUniqueStringList {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> uniqueStrings = new ConcurrentSkipListSet<>(String.CASE_INSENSITIVE_ORDER);

        // Multiple threads adding strings concurrently
        Thread t1 = new Thread(() -> {
            uniqueStrings.add("Hello");
            uniqueStrings.add("world");
        });
        Thread t2 = new Thread(() -> {
            uniqueStrings.add("HELLO");
            uniqueStrings.add("World");
        });
        Thread t3 = new Thread(() -> {
            uniqueStrings.add("java");
            uniqueStrings.add("Java");
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Unique strings (case-insensitive):");
        for (String str : uniqueStrings) {
            System.out.println(str);
        }
    }
}