```java
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.Test;

import java.util.List;

public class MockitoDoAnswerExample {

    @Test
    public void testDoAnswer() {
        // Create a mock object
        List<String> mockedList = mock(List.class);

        // Define the behavior using doAnswer
        doAnswer(new Answer<String>() {
            public String answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                return "Called with arguments: " + args[0];
            }
        }).when(mockedList).get(anyInt());

        // Test the mocked behavior
        String result = mockedList.get(0);
        assertEquals("Called with arguments: 0", result);

        result = mockedList.get(999);
        assertEquals("Called with arguments: 999", result);

        // Verify that the method was called
        verify(mockedList, times(2)).get(anyInt());
    }

    @Test
    public void testDoAnswerWithLambda() {
        // Create a mock object
        List<String> mockedList = mock(List.class);

        // Define the behavior using doAnswer with lambda
        doAnswer(invocation -> {
            int index = invocation.getArgument(0);
            return "Element at index " + index;
        }).when(mockedList).get(anyInt());

        // Test the mocked behavior
        String result = mockedList.get(5);
        assertEquals("Element at index 5", result);

        result = mockedList.get(10);
        assertEquals("Element at index 10", result);

        // Verify that the method was called
        verify(mockedList, times(2)).get(anyInt());
    }
}
```

This script demonstrates two test methods that use the `doAnswer` method in different ways:

1. `testDoAnswer()`: This method shows how to use `doAnswer` with an anonymous `Answer` implementation. It mocks the `get` method of a `List` to return a custom string based on the input argument.

2. `testDoAnswerWithLambda()`: This method demonstrates a more concise way to use `doAnswer` with a lambda expression. It achieves the same result as the first method but with less verbose code.

In both cases, the `doAnswer` method allows you to define custom behavior for the mocked method, which can be useful when you need more complex logic or want to use the method arguments in the response.

To run this script, you'll need to have Mockito and JUnit in your project's dependencies. Make sure to import the necessary classes and static methods as shown at the beginning of the script.