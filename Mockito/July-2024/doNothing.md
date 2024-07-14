```java
import static org.mockito.Mockito.*;

// Assume we have a class called EmailService with a method sendEmail
EmailService emailServiceMock = mock(EmailService.class);

// Using doNothing() to mock void method
doNothing().when(emailServiceMock).sendEmail(anyString(), anyString());

// Now you can call the method without any actual execution
emailServiceMock.sendEmail("user@example.com", "Hello, World!");

// Verify that the method was called
verify(emailServiceMock).sendEmail("user@example.com", "Hello, World!");
```

Here's what this code does:

1. We create a mock object of `EmailService` using `mock()`.
2. We use `doNothing()` to specify that when `sendEmail()` is called on the mock object, it should do nothing (i.e., the actual method implementation is not executed).
3. The `when()` method is used to specify the method call that should be mocked.
4. We can then call `sendEmail()` on our mock object without any actual email being sent.
5. Finally, we can use `verify()` to check if the method was indeed called with the expected arguments.

`doNothing()` is particularly useful when:

- You're mocking void methods
- You want to explicitly state that a method should do nothing when called
- You need to use it in combination with `when()` for stubbing void methods

Remember to import the necessary Mockito classes and static methods for this to work in your test class.