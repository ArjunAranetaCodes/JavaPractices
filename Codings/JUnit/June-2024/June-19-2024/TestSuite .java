import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestClassA.class,
    TestClassB.class,
    TestClassC.class
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSuite {
    // This class remains empty, it is used only as a holder for the suite annotations
}

class TestClassA {
    @Test
    public void testA1() {
        // Test logic for testA1
    }

    @Test
    public void testA2() {
        // Test logic for testA2
    }
}

class TestClassB {
    @Test
    public void testB1() {
        // Test logic for testB1
    }

    @Test
    public void testB2() {
        // Test logic for testB2
    }
}

class TestClassC {
    @Test
    public void testC1() {
        // Test logic for testC1
    }

    @Test
    public void testC2() {
        // Test logic for testC2
    }
}