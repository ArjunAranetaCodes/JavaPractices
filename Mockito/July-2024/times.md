```java
import static org.mockito.Mockito.*;
import org.junit.Test;

public class UserServiceTest {

    @Test
    public void testUserInteractions() {
        // Create a mock object
        UserDatabase mockDatabase = mock(UserDatabase.class);
        
        // Create the service and inject the mock
        UserService userService = new UserService(mockDatabase);

        // Define the behavior of the mock
        when(mockDatabase.isUserActive("alice")).thenReturn(true);
        when(mockDatabase.isUserActive("bob")).thenReturn(false);

        // Perform some actions
        userService.greetUser("alice");
        userService.greetUser("bob");
        userService.greetUser("alice");

        // Verify the interactions
        verify(mockDatabase, times(2)).isUserActive("alice");
        verify(mockDatabase, times(1)).isUserActive("bob");
        
        // Verify that a method was never called
        verify(mockDatabase, times(0)).deleteUser(anyString());
    }
}

// Classes used in the test
class UserService {
    private UserDatabase database;

    public UserService(UserDatabase database) {
        this.database = database;
    }

    public void greetUser(String username) {
        if (database.isUserActive(username)) {
            System.out.println("Hello, " + username + "!");
        } else {
            System.out.println("User not active.");
        }
    }
}

interface UserDatabase {
    boolean isUserActive(String username);
    void deleteUser(String username);
}
```

In this example:

1. We create a mock `UserDatabase` object using `mock()`.

2. We inject this mock into a `UserService` instance.

3. We define the behavior of the mock using `when()...thenReturn()`.

4. We perform some actions on the `UserService` that will interact with the mock.

5. We use `verify()` with `times()` to check how many times certain methods were called:
   - `isUserActive("alice")` should be called exactly 2 times.
   - `isUserActive("bob")` should be called exactly 1 time.
   - `deleteUser()` should never be called (0 times) with any string argument.

The `times()` method is very useful for verifying the exact number of invocations of a method. It helps ensure that your code is interacting with dependencies the correct number of times, which can be crucial for performance, correctness, and avoiding unnecessary operations.

Remember to include the necessary Mockito dependencies in your project to run this test. If you're using Maven, you can add the following to your pom.xml:

```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.12.4</version>
    <scope>test</scope>
</dependency>
```

This script demonstrates a basic usage of `times()` in Mockito. You can adjust the number of invocations and add more complex verifications as needed for your specific testing scenarios.