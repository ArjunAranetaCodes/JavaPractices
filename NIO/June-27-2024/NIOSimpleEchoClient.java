import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class NIOSimpleEchoClient {
    private final String SERVER_ADDRESS = "localhost";
    private final int PORT = 8080;
    private final String MESSAGE = "Hello, NIOServer!\n";
    private final String END_SIGNAL = "END\n";

    public void start() {
        try (Socket socket = new Socket();
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            socket.connect(new InetSocketAddress(SERVER_ADDRESS, PORT), 5000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

            writer.print(MESSAGE);
            System.out.println("Sent: " + MESSAGE);

            boolean keepListening = true;
            while (keepListening) {
                String responseLine = reader.readLine();
                if (responseLine == null || responseLine.equalsIgnoreCase(END_SIGNAL)) {
                    keepListening = false;
                } else {
                    System.out.println("Received: " + responseLine);
                }
            }
        } catch (Exception e) {
            System.err.println("[ERROR]: Could not establish connection to server.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NIOSimpleEchoClient client = new NIOSimpleEchoClient();
        client.start();
    }
}