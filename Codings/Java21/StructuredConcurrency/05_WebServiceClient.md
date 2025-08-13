# Web Service Client with Structured Concurrency

This example demonstrates a practical use case of Structured Concurrency in a web service client that makes multiple concurrent API calls.

## Overview

The program shows how to:
- Make concurrent API calls efficiently
- Handle HTTP client configuration
- Manage multiple web requests
- Process responses from multiple endpoints
- Handle errors in a web service context

## Key Concepts

1. **Concurrent API Calls**: Making multiple HTTP requests concurrently
2. **HTTP Client Configuration**: Setting up timeouts and other parameters
3. **Error Handling**: Managing network and API errors
4. **Response Processing**: Handling multiple API responses
5. **Resource Management**: Proper cleanup of HTTP resources

## Code Explanation

```java
// HTTP Client configuration
private static final HttpClient client = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(5))
        .build();

// Main execution
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    List<StructuredTaskScope.Subtask<String>> subtasks = new ArrayList<>();
    
    // Submit multiple API calls
    subtasks.add(scope.fork(() -> fetchData("https://api.example.com/users")));
    subtasks.add(scope.fork(() -> fetchData("https://api.example.com/products")));
    subtasks.add(scope.fork(() -> fetchData("https://api.example.com/orders")));

    // Wait for all calls to complete
    scope.join();
    scope.throwIfFailed();

    // Process responses
    for (var subtask : subtasks) {
        System.out.println("Response: " + subtask.get());
    }
}
```

## Running the Example

Compile and run with preview features enabled:

```bash
javac --enable-preview --release 21 05_WebServiceClient.java
java --enable-preview 05_WebServiceClient
```

## Expected Output

```
Response: Data from https://api.example.com/users
Response: Data from https://api.example.com/products
Response: Data from https://api.example.com/orders
```

## Notes

- The example uses Java's built-in HTTP client
- API calls are simulated with delays for demonstration
- Real HTTP requests are commented out but can be enabled
- The client is configured with a 5-second timeout
- Error handling includes both network and API errors
- The example demonstrates proper resource cleanup
- All API calls are made concurrently for better performance
- The ShutdownOnFailure policy ensures all calls are properly managed

## Real-World Applications

This pattern is useful for:
- Microservice architectures
- API aggregation services
- Data collection from multiple sources
- Parallel data processing
- Service health checks
- Load balancing scenarios 