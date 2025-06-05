Here's a JUnit 5 script that uses `@RegisterExtension`:

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.logging.Logger;

public class TimingExtensionTest {

    @RegisterExtension
    static TimingExtension timer = new TimingExtension();

    @Test
    void testMethod1() throws InterruptedException {
        // Simulate some work
        Thread.sleep(1000);
    }

    @Test
    void testMethod2() throws InterruptedException {
        // Simulate some work
        Thread.sleep(500);
    }
}

class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final Logger logger = Logger.getLogger(TimingExtension.class.getName());

    private long startTime;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        long duration = System.currentTimeMillis() - startTime;
        logger.info(() -> String.format("Test [%s] took %d ms.", 
                     context.getRequiredTestMethod().getName(), duration));
    }
}
```

Let's break down this script:

1. We define a `TimingExtension` class that implements both `BeforeTestExecutionCallback` and `AfterTestExecutionCallback`. This extension will measure the execution time of each test method.

2. In the `TimingExtensionTest` class, we use `@RegisterExtension` to register our `TimingExtension`:

   ```java
   @RegisterExtension
   static TimingExtension timer = new TimingExtension();
   ```

   This creates a static field that JUnit will use to register the extension.

3. We define two test methods, `testMethod1()` and `testMethod2()`, each simulating some work by sleeping for different durations.

4. The `TimingExtension` class:
   - Implements `beforeTestExecution()` to record the start time before each test method.
   - Implements `afterTestExecution()` to calculate the duration and log it after each test method.

When you run this test class, JUnit will automatically use the registered extension for each test method. The extension will measure and log the execution time for each test.

The output might look something like this:

```
INFO: Test [testMethod1] took 1003 ms.
INFO: Test [testMethod2] took 502 ms.
```

This example demonstrates how `@RegisterExtension` can be used to add custom behavior to your tests in a reusable way. You can create more complex extensions to suit your specific testing needs, such as setting up database connections, mocking external services, or customizing test reporting.