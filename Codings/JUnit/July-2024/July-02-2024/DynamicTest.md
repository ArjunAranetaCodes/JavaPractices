```java
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class StringManipulatorTest {

    @TestFactory
    Collection<DynamicTest> dynamicTestsWithCollection() {
        return Arrays.asList(
            dynamicTest("Test uppercase", () -> assertEquals("HELLO", StringManipulator.toUpperCase("hello"))),
            dynamicTest("Test lowercase", () -> assertEquals("world", StringManipulator.toLowerCase("WORLD"))),
            dynamicTest("Test reverse", () -> assertEquals("olleh", StringManipulator.reverse("hello")))
        );
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of("hello", "world", "junit")
            .map(str -> dynamicTest("Test length of " + str, () -> {
                assertEquals(str.length(), StringManipulator.length(str));
            }));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamFactoryMethod() {
        return DynamicTest.stream(
            Arrays.asList("racecar", "radar", "able was I ere I saw elba").iterator(),
            str -> "Testing palindrome: " + str,
            str -> assertEquals(true, StringManipulator.isPalindrome(str))
        );
    }
}

class StringManipulator {
    static String toUpperCase(String str) { return str.toUpperCase(); }
    static String toLowerCase(String str) { return str.toLowerCase(); }
    static String reverse(String str) { return new StringBuilder(str).reverse().toString(); }
    static int length(String str) { return str.length(); }
    static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
}
```

This example demonstrates three different ways to create dynamic tests in JUnit 5:

1. Using a Collection of DynamicTests[2][3]:
   The `dynamicTestsWithCollection()` method creates a collection of dynamic tests for different string operations.

2. Using a Stream of DynamicTests[2][3][4]:
   The `dynamicTestsFromStream()` method generates dynamic tests from a stream of input strings, testing the length of each string.

3. Using the DynamicTest.stream() factory method[2][3][4]:
   The `dynamicTestsFromStreamFactoryMethod()` method uses the `DynamicTest.stream()` method to create dynamic tests for palindrome checking.

Key points about dynamic tests in JUnit 5:

- They are defined using the `@TestFactory` annotation[1][2][3].
- The test factory method must return a `Stream`, `Collection`, `Iterable`, or `Iterator` of `DynamicTest` instances[2][3].
- Each dynamic test consists of a display name and an `Executable`[2][3].
- Dynamic tests are generated at runtime, allowing for flexible and programmatic test creation[1][3][4].
- They are useful for scenarios where test cases cannot be defined at compile time or when parameterized tests are not sufficient[3][4].

Remember that dynamic tests do not support lifecycle callbacks like `@BeforeEach` and `@AfterEach` for individual tests[3]. These callbacks are only executed for the entire `@TestFactory` method.

Citations:
[1] https://www.baeldung.com/junit5-dynamic-tests
[2] https://github.com/junit-team/junit5/blob/main/documentation/src/test/java/example/DynamicTestsDemo.java
[3] https://mincong.io/2021/04/09/junit-5-dynamic-tests/
[4] https://dzone.com/articles/junit-5-dynamic-tests-generate-tests-at-run-time
[5] https://nipafx.dev/junit-5-dynamic-tests/