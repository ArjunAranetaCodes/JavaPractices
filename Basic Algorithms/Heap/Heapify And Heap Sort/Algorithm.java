import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Algorithm {
    public static void main(String[] args) {
        String inputString = "Hello, Hashing!";

        // Hash the input string using SHA-256 algorithm
        String hashedValue = hashSHA256(inputString);

        // Display the original string and its hashed value
        System.out.println("Original String: " + inputString);
        System.out.println("Hashed Value: " + hashedValue);
    }

    // Method to hash a string using SHA-256 algorithm
    private static String hashSHA256(String input) {
        try {
            // Get instance of MessageDigest for SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Update the message digest with the input bytes
            messageDigest.update(input.getBytes());

            // Get the hashed bytes
            byte[] hashedBytes = messageDigest.digest();

            // Convert hashed bytes to hexadecimal format
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
            }

        } catch (NoSuchAlgorithmException e) {
        }
    }
}
