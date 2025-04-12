import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class Logger {
    private CopyOnWriteArraySet<String> logMessages = new CopyOnWriteArraySet<>();

    public void log(String message) {
        logMessages.add(message);
    }

    public void printLog() {
        System.out.println(logMessages);
    }

    public static void main(String[] args) {
        Logger logger = new Logger();

        Thread thread1 = new Thread(() -> {
            logger.log("Message 1");
        });

        Thread thread2 = new Thread(() -> {
            logger.log("Message 2");
        });

        Thread thread3 = new Thread(() -> {
            logger.log("Message 3");
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

        logger.printLog();
    }
}