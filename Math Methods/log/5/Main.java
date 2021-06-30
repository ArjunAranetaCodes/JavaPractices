import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.info("Starting application...");
        performSomeTask();
        log.info("Application completed successfully.");
    }

    private static void performSomeTask() {
        log.info("Performing some task...");
        // Simulating some task execution
        log.warning("Task execution encountered a warning.");
    }
}
