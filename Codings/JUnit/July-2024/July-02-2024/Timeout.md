```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@Timeout(value = 5, unit = TimeUnit.SECONDS)
public class TimeoutTest {

    private static SlowCalculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new SlowCalculator();
    }

    @AfterAll
    public static void tearDown() {
        calculator = null;
    }

    @Test
    @Timeout(1) // 1 second timeout
    public void testQuickCalculation() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    public void testSlowCalculation() {
        int result = calculator.slowAdd(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testVerySlowCalculationWithAssertTimeout() {
        assertTimeout(java.time.Duration.ofSeconds(4), () -> {
            int result = calculator.verySlowAdd(2, 3);
            assertEquals(5, result);
        });
    }
}

class SlowCalculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int slowAdd(int a, int b) {
        try {
            Thread.sleep(2000); // Simulate a slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }

    public int verySlowAdd(int a, int b) {
        try {
            Thread.sleep(3500); // Simulate a very slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }
}
```

Let's break down the key elements of this JUnit script:

1. We use `@Timeout` at the class level to set a global timeout of 5 seconds for all tests in the class.

2. The `testQuickCalculation()` method has a 1-second timeout using `@Timeout(1)`.

3. The `testSlowCalculation()` method has a 3-second timeout using `@Timeout(value = 3, unit = TimeUnit.SECONDS)`.

4. The `testVerySlowCalculationWithAssertTimeout()` method uses `assertTimeout()` to set a 4-second timeout for a specific block of code.

5. We've created a `SlowCalculator` class with methods that simulate operations of varying durations.

6. The `@BeforeAll` and `@AfterAll` methods are used to set up and tear down the test environment.

This script demonstrates different ways to use timeouts in JUnit:
- Class-level timeout
- Method-level timeout with default time unit (seconds)
- Method-level timeout with specified time unit
- Asserting timeout for a specific block of code

When you run these tests, the `testQuickCalculation()` and `testSlowCalculation()` should pass, while `testVerySlowCalculationWithAssertTimeout()` will fail due to exceeding the 4-second timeout.

Remember to have the necessary JUnit 5 dependencies in your project to run this script.