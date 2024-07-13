Certainly! Here's an example of a JUnit script that demonstrates the usage of the `@Disabled` annotation:

```java
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should equal 1");
    }

    @Test
    @Disabled("Multiplication method not yet implemented")
    public void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
    }

    @Test
    @Disabled
    public void testDivision() {
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should equal 2");
    }

    @Disabled("Entire class disabled for maintenance")
    class DisabledTestClass {
        @Test
        public void testSquareRoot() {
            assertEquals(3, calculator.squareRoot(9), "Square root of 9 should be 3");
        }

        @Test
        public void testPower() {
            assertEquals(8, calculator.power(2, 3), "2 to the power of 3 should be 8");
        }
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    // Other methods (multiply, divide, squareRoot, power) are not implemented
}
```

In this example:

1. We have a `CalculatorTest` class that tests various methods of a `Calculator` class.

2. The `testAddition()` and `testSubtraction()` methods are regular test methods that will run normally.

3. The `testMultiplication()` method is disabled with a custom message explaining why it's disabled. This is useful when you want to provide a reason for disabling the test.

4. The `testDivision()` method is disabled without a custom message. This is useful when you just want to temporarily skip a test without providing a specific reason.

5. There's an inner class `DisabledTestClass` that is entirely disabled. This demonstrates how you can disable a group of related tests at once.

6. The `@Disabled` annotation is part of JUnit 5 (Jupiter). Make sure you're using JUnit 5 in your project to use this annotation.

When you run this test class:
- The addition and subtraction tests will run normally.
- The multiplication and division tests will be skipped.
- The entire `DisabledTestClass` will be skipped, so neither the `testSquareRoot()` nor the `testPower()` method will run.

This approach is useful when you have tests that are temporarily broken, or when you're working on implementing new features and don't want incomplete tests to cause failures in your test suite.