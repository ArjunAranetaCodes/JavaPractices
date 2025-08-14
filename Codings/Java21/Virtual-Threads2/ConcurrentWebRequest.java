import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;
import java.lang.InterruptedException;

public class ConcurrentWebRequest {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        Thread thread1 = Thread.startVirtualThread(() -> {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://example.com"))
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Response from example.com: " + response.body());
            } catch (IOException | InterruptedException e) {
                System.out.println("Error sending request to example.com: " + e.getMessage());
            }
        });

        Thread thread2 = Thread.startVirtualThread(() -> {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://google.com"))
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Response from google.com: " + response.body());
            } catch (IOException | InterruptedException e) {
                System.out.println("Error sending request to google.com: " + e.getMessage());
            }
        });
    }
}