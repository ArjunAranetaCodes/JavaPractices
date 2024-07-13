import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private static Database db;

    @BeforeAll
    static void initAll() {
        System.out.println("Initializing database connection...");
        db = new Database();
        db.connect();
    }

    @Test
    void testDatabaseInsert() {
        System.out.println("Running test: Database Insert");
        assertTrue(db.insert("test data"));
    }

    @Test
    void testDatabaseQuery() {
        System.out.println("Running test: Database Query");
        assertNotNull(db.query("SELECT * FROM test_table"));
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Closing database connection...");
        db.disconnect();
        db = null;
    }
}

// Mock Database class for illustration
class Database {
    void connect() {
        // Connection logic
    }

    boolean insert(String data) {
        // Insert logic
        return true;
    }

    String query(String sql) {
        // Query logic
        return "Result";
    }

    void disconnect() {
        // Disconnection logic
    }
}