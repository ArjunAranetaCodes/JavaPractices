```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "5, 3, 8",
        "10, -2, 8",
        "0, 0, 0",
        "-5, -7, -12"
    })
    void testAddition(int a, int b, int expectedSum) {
        Calculator calculator = new Calculator();
        int actualSum = calculator.add(a, b);
        assertEquals(expectedSum, actualSum, 
            () -> a + " + " + b + " should equal " + expectedSum);
    }
}
```

In this example:

1. We're testing a `Calculator` class that has an `add` method.
2. The `@ParameterizedTest` annotation indicates that this is a parameterized test.
3. The `@CsvSource` annotation provides the test data in a comma-separated format. Each line represents a set of parameters: two input values and the expected output.
4. The test method `testAddition` takes three parameters: `a`, `b`, and `expectedSum`.
5. Inside the test method, we create a `Calculator` instance, call its `add` method with `a` and `b`, and then assert that the result matches the `expectedSum`.

For this test to work, you would need a `Calculator` class like this:

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

This parameterized test will run five times, once for each set of parameters provided in the `@CsvSource`. It tests the addition operation with positive numbers, negative numbers, zero, and a mix of positive and negative numbers.

Using parameterized tests can significantly reduce code duplication in your test suite and make it easier to test a method with multiple inputs and expected outputs.