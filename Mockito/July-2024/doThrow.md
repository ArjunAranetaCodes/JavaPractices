Certainly! I'll create a Mockito script that demonstrates the usage of `doThrow()`. This example will simulate a scenario where we're testing a service that interacts with a database, and we want to test how it handles exceptions.

Here's a Mockito script using `doThrow()`:

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

class UserServiceTest {

    @Test
    void testDeleteUser_DatabaseException() {
        // Create mock objects
        UserRepository mockRepository = mock(UserRepository.class);
        UserService userService = new UserService(mockRepository);

        // Set up the mock to throw an exception
        doThrow(new SQLException("Database connection failed"))
            .when(mockRepository).deleteUser(anyInt());

        // Test the service method
        assertThrows(ServiceException.class, () -> {
            userService.deleteUser(1);
        });

        // Verify that the deleteUser method was called
        verify(mockRepository).deleteUser(1);
    }
}

// These classes are just for context and would be in separate files in a real project
class UserService {
    private UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    void deleteUser(int userId) throws ServiceException {
        try {
            repository.deleteUser(userId);
        } catch (SQLException e) {
            throw new ServiceException("Failed to delete user", e);
        }
    }
}

interface UserRepository {
    void deleteUser(int userId) throws SQLException;
}

class ServiceException extends Exception {
    ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

Let's break down this Mockito script:

1. We're testing a `UserService` class that depends on a `UserRepository`.

2. We create a mock `UserRepository` using `Mockito.mock()`.

3. We use `doThrow()` to configure the mock repository to throw a `SQLException` when `deleteUser()` is called with any integer argument (`anyInt()`).

4. We then test the `deleteUser()` method of our `UserService`, expecting it to throw a `ServiceException`.

5. Finally, we verify that the `deleteUser()` method of the repository was indeed called with the correct argument.

This script demonstrates how to use `doThrow()` to test exception handling in your code. It's particularly useful when you want to simulate failures in dependencies (like database operations) to ensure your service layer handles these exceptions correctly.