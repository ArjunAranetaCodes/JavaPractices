```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.logging.Logger;

class LoggingExtensionTest {

    @RegisterExtension
    static LoggingExtension loggingExtension = new LoggingExtension();

    @Test
    void testMethod1() {
        System.out.println("Executing test method 1");
    }

    @Test
    void testMethod2() {
        System.out.println("Executing test method 2");
    }
}

class LoggingExtension implements BeforeEachCallback, AfterEachCallback {
    private static final Logger logger = Logger.getLogger(LoggingExtension.class.getName());

    @Override
    public void beforeEach(ExtensionContext context) {
        logger.info(() -> String.format("Starting test: %s", context.getDisplayName()));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        logger.info(() -> String.format("Finished test: %s", context.getDisplayName()));
    }
}
```

Let's break down this script:

1. We define a test class `LoggingExtensionTest` with two simple test methods.

2. We create a custom extension `LoggingExtension` that implements `BeforeEachCallback` and `AfterEachCallback`. This extension logs messages before and after each test method execution.

3. In the test class, we use `@RegisterExtension` to register our custom `LoggingExtension`. This annotation tells JUnit to use this extension for all tests in the class.

4. The `LoggingExtension` uses Java's built-in `Logger` to log messages. It logs the start of each test in the `beforeEach` method and the end of each test in the `afterEach` method.

5. Each test method simply prints a message to demonstrate that it's being executed.

When you run this test class, you'll see log messages before and after each test method execution, along with the output from the test methods themselves.

This example demonstrates how `@RegisterExtension` can be used to add custom behavior to your tests, such as logging, setup, or teardown operations that are more complex than what can be achieved with standard JUnit annotations.