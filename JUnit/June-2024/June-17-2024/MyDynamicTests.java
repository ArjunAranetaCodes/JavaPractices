import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class MyDynamicTests {

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
            dynamicTest("Simple multiplication", () -> assertEquals(6, Math.multiplyFull(2, 3))),
            dynamicTest("Multiplication with zero", () -> assertEquals(0, Math.multiplyFull(0, 5)))
        );
    }

    @TestFactory
    Iterable<DynamicTest> dynamicTestsFromIterable() {
        return Arrays.asList(
            dynamicTest("Integer multiplication", () -> assertEquals(10, Math.multiplyFull(2, 5))),
            dynamicTest("Double multiplication", () -> assertEquals(6.0, Math.multiplyFull(2.0, 3.0)))
        );
    }

    @TestFactory
    Iterator<DynamicTest> dynamicTestsFromIterator() {
        Iterator<Integer> inputsIterator = Arrays.asList(2, 3, 4).iterator();
        return Stream.iterate(0, n -> n + 1)
            .limit(3)
            .map(n -> dynamicTest("Multiplication with " + inputsIterator.next(), () -> {
                int input = inputsIterator.next();
                assertEquals(input * 2, Math.multiplyFull(input, 2));
            }))
            .iterator();
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of(2, 3, 4)
            .map(input -> dynamicTest("Multiplication with " + input, () -> assertEquals(input * 3, Math.multiplyFull(input, 3))));
    }
}