Certainly! I'll create a JUnit script that uses the `@ExtendWith` annotation. This annotation is part of JUnit 5 and is used to register extensions for the test class. Let's create a simple example with a custom extension and a test class.

First, let's create a custom extension:

```java
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;

public class CustomExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Before each test");
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("After each test");
    }
}
```

Now, let's create a test class that uses this extension:

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(CustomExtension.class)
public class ExampleTest {

    @Test
    void testAddition() {
        System.out.println("Running addition test");
        assertEquals(4, 2 + 2);
    }

    @Test
    void testSubtraction() {
        System.out.println("Running subtraction test");
        assertEquals(0, 2 - 2);
    }
}
```

In this example:

1. We created a `CustomExtension` class that implements `BeforeEachCallback` and `AfterEachCallback`. This extension will print messages before and after each test method.

2. The `ExampleTest` class is annotated with `@ExtendWith(CustomExtension.class)`, which tells JUnit to use our custom extension for this test class.

3. We have two simple test methods: `testAddition()` and `testSubtraction()`.

When you run this test class, you'll see output similar to this:

```
Before each test
Running addition test
After each test
Before each test
Running subtraction test
After each test
```

This demonstrates that our custom extension is being called before and after each test method.

To run this test, you'll need JUnit 5 in your classpath. If you're using Maven, you can add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.8.2</version>
    <scope>test</scope>
</dependency>
```

This script showcases a basic usage of `@ExtendWith` in JUnit 5. You can create more complex extensions to handle various scenarios like setting up test data, managing resources, or implementing custom test lifecycle behaviors.