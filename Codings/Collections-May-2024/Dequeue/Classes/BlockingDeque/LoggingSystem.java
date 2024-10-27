import java.util.concurrent.LinkedBlockingDeque;

public class LoggingSystem {
    private LinkedBlockingDeque<String> logQueue = new LinkedBlockingDeque<>(10);

    public void logMessage(String message) {
        try {
            logQueue.put(message);
            System.out.println(message + " added to queue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processLogs() {
        while (true) {
            try {
                String message = logQueue.take();
                System.out.println("Processing log: " + message);
                // Process the log message
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        LoggingSystem loggingSystem = new LoggingSystem();

        Thread logger1 = new Thread(() -> {
            loggingSystem.logMessage("Log Message 1");
        });

        Thread logger2 = new Thread(() -> {
            loggingSystem.logMessage("Log Message 2");
        });

        Thread logger3 = new Thread(() -> {
            loggingSystem.logMessage("Log Message 3");
        });

        Thread logger4 = new Thread(() -> {
            loggingSystem.logMessage("Log Message 4");
        });

        logger1.start();
        logger2.start();
        logger3.start();
        logger4.start();

        loggingSystem.processLogs();
    }
}