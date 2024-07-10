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