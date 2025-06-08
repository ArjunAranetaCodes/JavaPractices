import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestTemplateInvocationContextProvider.class)
public class CalculatorTests {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(3, 4);
        assertEquals(12, result);
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
    }

    @TestTemplate
    void testOperations(int a, int b, int expected, String operation) {
        Calculator calculator = new Calculator();
        int result;
        switch (operation) {
            case "add":
                result = calculator.add(a, b);
                break;
            case "subtract":
                result = calculator.subtract(a, b);
                break;
            case "multiply":
                result = calculator.multiply(a, b);
                break;
            case "divide":
                result = calculator.divide(a, b);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
        assertEquals(expected, result, operation + "(" + a + ", " + b + ") should equal " + expected);
    }

    static Stream<Arguments> testOperationsArguments() {
        return Stream.of(
            Arguments.of(2, 3, 5, "add"),
            Arguments.of(5, 3, 2, "subtract"),
            Arguments.of(3, 4, 12, "multiply"),
            Arguments.of(10, 2, 5, "divide")
        );
    }
}