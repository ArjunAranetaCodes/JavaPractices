This method is useful when you want to verify interactions on real objects while ignoring stubbed methods. Here's an example script:

```java
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class IgnoreStubsExample {

    interface DataService {
        String fetchData();
        void processData(String data);
        void logActivity();
    }

    class DataProcessor {
        private DataService dataService;

        public DataProcessor(DataService dataService) {
            this.dataService = dataService;
        }

        public void performOperation() {
            String data = dataService.fetchData();
            dataService.processData(data);
            dataService.logActivity();
        }
    }

    @Test
    public void testPerformOperationIgnoringStubs() {
        // Create a mock of DataService
        DataService mockDataService = mock(DataService.class);

        // Stub the fetchData method
        when(mockDataService.fetchData()).thenReturn("Test Data");

        // Create the object under test
        DataProcessor dataProcessor = new DataProcessor(mockDataService);

        // Perform the operation
        dataProcessor.performOperation();

        // Verify interactions, ignoring stubs
        verify(mockDataService).processData("Test Data");
        verify(mockDataService).logActivity();

        // Use ignoreStubs() to verify only non-stubbed method calls
        verifyNoMoreInteractions(ignoreStubs(mockDataService));

        // Verify the order of non-stubbed method calls
        InOrder inOrder = inOrder(ignoreStubs(mockDataService));
        inOrder.verify(mockDataService).processData("Test Data");
        inOrder.verify(mockDataService).logActivity();
    }
}
```

Let's break down this example:

1. We define a `DataService` interface with three methods: `fetchData()`, `processData()`, and `logActivity()`.

2. We create a `DataProcessor` class that uses the `DataService`.

3. In the test method `testPerformOperationIgnoringStubs()`:
   - We create a mock of `DataService`.
   - We stub the `fetchData()` method to return "Test Data".
   - We create an instance of `DataProcessor` with the mock service.
   - We call the `performOperation()` method.

4. We use `verify()` to check that `processData()` and `logActivity()` were called.

5. We use `verifyNoMoreInteractions(ignoreStubs(mockDataService))` to ensure no other non-stubbed methods were called on the mock. This ignores the stubbed `fetchData()` method.

6. We use `InOrder` with `ignoreStubs()` to verify the order of non-stubbed method calls, again ignoring the stubbed `fetchData()` method.

This script demonstrates how `ignoreStubs()` can be used to focus verification on non-stubbed methods, which is particularly useful when you want to ensure that only specific interactions occurred without being concerned about stubbed method calls.