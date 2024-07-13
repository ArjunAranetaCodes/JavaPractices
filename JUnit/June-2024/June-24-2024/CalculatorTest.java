import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up a new Calculator instance");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Tearing down the Calculator instance");
    }

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
        System.out.println("Addition test completed");
    }

    @Test
    void testAdditionWithNegativeNumbers() {
        assertEquals(-1, calculator.add(-3, 2), "-3 + 2 should equal -1");
        System.out.println("Addition with negative numbers test completed");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}