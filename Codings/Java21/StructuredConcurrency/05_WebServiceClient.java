import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.time.Duration;

public class WebServiceClient {
    private static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    public static void main(String[] args) {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            List<StructuredTaskScope.Subtask<String>> subtasks = new ArrayList<>();
            
            // Simulate multiple API calls
            subtasks.add(scope.fork(() -> fetchData("https://api.example.com/users")));
            subtasks.add(scope.fork(() -> fetchData("https://api.example.com/products")));
            subtasks.add(scope.fork(() -> fetchData("https://api.example.com/orders")));

            try {
                // Wait for all API calls to complete
                scope.join();
                scope.throwIfFailed();

                // Process all responses
                for (var subtask : subtasks) {
                    System.out.println("Response: " + subtask.get());
                }
            } catch (ExecutionException e) {
                System.err.println("API call failed: " + e.getCause().getMessage());
            }
        } catch (InterruptedException e) {
            System.err.println("Tasks were interrupted: " + e.getMessage());
        }
    }

    private static String fetchData(String url) throws InterruptedException {
        try {
            // Simulate API call with delay
            Thread.sleep(1000);
            
            // In a real application, this would make an actual HTTP request
            // HttpRequest request = HttpRequest.newBuilder()
            //     .uri(URI.create(url))
            //     .GET()
            //     .build();
            // HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // return response.body();
            
            return "Data from " + url;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch data from " + url, e);
        }
    }
} 