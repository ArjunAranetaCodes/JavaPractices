Certainly! Here's an example of a JUnit 5 test class that demonstrates the use of nested tests. This example will test a simple `Calculator` class with basic arithmetic operations.

```java
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    class AdditionTests {
        @Test
        void addTwoPositiveNumbers() {
            assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
        }

        @Test
        void addPositiveAndNegativeNumber() {
            assertEquals(1, calculator.add(5, -4), "5 + (-4) should equal 1");
        }

        @Test
        void addTwoNegativeNumbers() {
            assertEquals(-7, calculator.add(-3, -4), "(-3) + (-4) should equal -7");
        }
    }

    @Nested
    class SubtractionTests {
        @Test
        void subtractTwoPositiveNumbers() {
            assertEquals(2, calculator.subtract(5, 3), "5 - 3 should equal 2");
        }

        @Test
        void subtractNegativeFromPositive() {
            assertEquals(8, calculator.subtract(5, -3), "5 - (-3) should equal 8");
        }

        @Test
        void subtractPositiveFromNegative() {
            assertEquals(-8, calculator.subtract(-5, 3), "(-5) - 3 should equal -8");
        }
    }

    @Nested
    class MultiplicationTests {
        @Test
        void multiplyTwoPositiveNumbers() {
            assertEquals(15, calculator.multiply(3, 5), "3 * 5 should equal 15");
        }

        @Test
        void multiplyPositiveAndNegativeNumber() {
            assertEquals(-12, calculator.multiply(3, -4), "3 * (-4) should equal -12");
        }

        @Test
        void multiplyTwoNegativeNumbers() {
            assertEquals(20, calculator.multiply(-4, -5), "(-4) * (-5) should equal 20");
        }
    }

    @Nested
    class DivisionTests {
        @Test
        void divideTwoPositiveNumbers() {
            assertEquals(4, calculator.divide(12, 3), "12 / 3 should equal 4");
        }

        @Test
        void dividePositiveByNegativeNumber() {
            assertEquals(-3, calculator.divide(12, -4), "12 / (-4) should equal -3");
        }

        @Test
        void divideByZero() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0),
                    "Division by zero should throw ArithmeticException");
        }
    }
}
```

This test class assumes the existence of a `Calculator` class with methods `add()`, `subtract()`, `multiply()`, and `divide()`. Here's a simple implementation of the `Calculator` class that would work with these tests:

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
```

In this JUnit test class:

1. We use the `@Nested` annotation to create nested test classes for each operation (addition, subtraction, multiplication, and division).
2. Each nested class contains multiple test methods for different scenarios of that operation.
3. We use assertions like `assertEquals()` and `assertThrows()` to verify the expected behavior of the `Calculator` methods.

This structure allows for better organization of tests, grouping related tests together, and providing a clear hierarchy of test cases. It's particularly useful for complex classes with multiple operations or behaviors that need to be tested separately.