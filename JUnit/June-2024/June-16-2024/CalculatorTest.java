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