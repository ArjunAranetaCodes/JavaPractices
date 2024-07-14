```java
import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTest {

    class MyClass {
        public String getMessage() {
            return "Real message";
        }
        
        public int calculateValue() {
            // Some complex calculation
            return 42;
        }
    }

    @Test
    public void testDoCallRealMethod() {
        // Create a mock of MyClass
        MyClass mockObject = mock(MyClass.class);

        // Use doCallRealMethod for getMessage
        doCallRealMethod().when(mockObject).getMessage();

        // Stub calculateValue to return a specific value
        when(mockObject.calculateValue()).thenReturn(100);

        // Test the real method call
        assertEquals("Real message", mockObject.getMessage());

        // Test the stubbed method
        assertEquals(100, mockObject.calculateValue());

        // Verify that getMessage was called
        verify(mockObject).getMessage();
    }
}
```

In this example:

1. We create a mock object of `MyClass` using `mock(MyClass.class)`.

2. We use `doCallRealMethod().when(mockObject).getMessage()` to specify that the real implementation of `getMessage()` should be called when invoked on the mock object.

3. We stub the `calculateValue()` method to return 100 using `when(mockObject.calculateValue()).thenReturn(100)`.

4. In our assertions, we verify that:
   - `getMessage()` returns the real message ("Real message")
   - `calculateValue()` returns the stubbed value (100)

5. Finally, we use `verify(mockObject).getMessage()` to ensure that `getMessage()` was indeed called during the test.

This example demonstrates how `doCallRealMethod()` allows you to selectively call real methods on a mock object while still maintaining control over other methods. This can be particularly useful in scenarios where you want to test the interaction between real and mocked behaviors within the same object.