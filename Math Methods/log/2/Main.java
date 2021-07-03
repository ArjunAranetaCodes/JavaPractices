import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.info("This is an informational message.");
        log.warning("This is a warning message.");
        log.log(Level.SEVERE, "This is a severe message.");
    }
}
