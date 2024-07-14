import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.TimeUnit;

public class TimeoutExampleTest {

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testMethodWithTimeout() throws InterruptedException {
        // This test will pass because it completes within the timeout period
        Thread.sleep(500);
        Assertions.assertTrue(true);
    }

    @Test
    @Timeout(2) // Default unit is seconds
    public void testMethodThatExceedsTimeout() throws InterruptedException {
        // This test will fail because it exceeds the timeout period
        Thread.sleep(3000);
        Assertions.assertTrue(true);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testQuickMethod() {
        // This test will pass because it completes very quickly
        int result = 1 + 1;
        Assertions.assertEquals(2, result);
    }
}