import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public class MultithreadedLogger {
    private ConcurrentLinkedQueue<String> logQueue = new ConcurrentLinkedQueue<>();
    private Logger logger = Logger.getLogger(MultithreadedLogger.class.getName());

    public void logMessage(String message, String threadName) {
        logQueue.add(message);
        logger.info(threadName + ": " + message);
    }

    public void processLogs() {
        while (true) {
            String message = logQueue.poll();
            if (message != null) {
                logger.info("Processed log message: " + message);
            }
        }
    }

    public static void main(String[] args) {
        MultithreadedLogger multithreadedLogger = new MultithreadedLogger();

        Thread thread1 = new Thread(() -> {
            multithreadedLogger.logMessage("Message 1", "Thread 1");
        });

        Thread thread2 = new Thread(() -> {
            multithreadedLogger.logMessage("Message 2", "Thread 2");
        });

        Thread thread3 = new Thread(() -> {
            multithreadedLogger.logMessage("Message 3", "Thread 3");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        multithreadedLogger.processLogs();
    }
}