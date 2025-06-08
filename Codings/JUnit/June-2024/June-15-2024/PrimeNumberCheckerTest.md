```java
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrimeNumberCheckerTest {

    PrimeNumberChecker primeNumberChecker = new PrimeNumberChecker();

    private static Stream<Arguments> argumentsForIsPrime() {
        return Stream.of(
            Arguments.of(2, true),
            Arguments.of(3, true), 
            Arguments.of(4, false),
            Arguments.of(5, true),
            Arguments.of(6, false)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForIsPrime")
    void testIsPrime(int number, boolean expectedResult) {
        boolean actualResult = primeNumberChecker.isPrime(number);
        assertTrue(actualResult == expectedResult, 
            "Number " + number + " did not have expected prime result " + expectedResult);
    }
}
```

Explanation:

- The `argumentsForIsPrime` method provides the test data as a `Stream<Arguments>`. Each `Arguments` object contains the input number and expected boolean result for checking if a number is prime.[1][4]
- The `@ParameterizedTest` annotation marks the `testIsPrime` method as a parameterized test.
- The `@MethodSource` annotation tells JUnit to use the `argumentsForIsPrime` method as the source of arguments for each invocation of `testIsPrime`.
- For each `Arguments` object provided, JUnit will call `testIsPrime` passing in the number and expected result from that `Arguments` instance.
- Inside `testIsPrime`, it calls the `isPrime` method on `PrimeNumberChecker` with the number parameter, and asserts that the actual result matches the expected result.[3]

This allows you to run the same `testIsPrime` logic with multiple different inputs in a concise way, without having to write separate test methods for each input case.

Citations:
[1] https://www.geeksforgeeks.org/junit-5-how-to-write-parameterized-tests/
[2] https://junit.org/junit5/docs/5.0.2/api/org/junit/jupiter/params/ParameterizedTest.html
[3] https://www.tutorialspoint.com/junit/junit_parameterized_test.htm
[4] https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-parameterized-tests/
[5] https://www.waldo.com/blog/parameterized-test-junit