```java
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @RepeatedTest(10)
    void testAddition(RepetitionInfo repetitionInfo) {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        int expectedResult = a + b;
        int actualResult = calculator.add(a, b);

        System.out.println("Iteration " + repetitionInfo.getCurrentRepetition() + ": " + a + " + " + b + " = " + actualResult);
        assertEquals(expectedResult, actualResult, "Addition operation failed");
    }
}
```

In this example, we have a test class `CalculatorTest` that tests the `add` method of a `Calculator` class. The `@RepeatedTest(10)` annotation is used to repeat the test 10 times.

The `testAddition` method takes a `RepetitionInfo` parameter, which provides information about the current repetition of the test. In this case, we use it to print the current iteration number, the input values, and the actual result.

Inside the test method, we generate two random integers `a` and `b` between 0 and 99. We then calculate the expected result by adding `a` and `b`, and the actual result by calling the `add` method of the `Calculator` instance.

Finally, we use the `assertEquals` method from JUnit to assert that the expected result matches the actual result. If the assertion fails, the test will fail with the provided error message.

By using `@RepeatedTest`, we can run the same test multiple times with different input values, which can be useful for testing edge cases or ensuring the stability of the code under different conditions.

Note that the `@RepeatedTest` annotation is part of JUnit 5, so you'll need to use JUnit 5 or a compatible version to use this feature.