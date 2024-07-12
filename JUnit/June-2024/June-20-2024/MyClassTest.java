import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyClassTest {

    private static MyClass myClass;

    @BeforeAll
    static void setUp() {
        myClass = new MyClass();
    }

    @AfterAll
    static void tearDown() {
        myClass = null;
    }

    @Test
    void testMethod1() {
        // Test logic for method1
        assertTrue(myClass.method1());
    }

    @Test
    void testMethod2() {
        // Test logic for method2
        assertEquals(5, myClass.method2(2, 3));
    }

    // More test methods...
}