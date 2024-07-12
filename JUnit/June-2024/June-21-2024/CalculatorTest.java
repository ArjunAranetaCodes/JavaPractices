import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    @DisplayName("Testing addition of two positive numbers")
    void testAdditionPositiveNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    @DisplayName("Testing addition of a positive and a negative number")
    void testAdditionPositiveNegativeNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(5, -3);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Testing addition of two negative numbers")
    void testAdditionNegativeNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(-5, -3);
        assertEquals(-8, result);
    }

    @Test
    @DisplayName("Testing addition of zero with a positive number")
    void testAdditionWithZero() {
        Calculator calculator = new Calculator();
        int result = calculator.add(0, 5);
        assertEquals(5, result);
    }
}