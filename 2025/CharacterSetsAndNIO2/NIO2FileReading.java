/**
 * Tutorial: NIO.2 File Reading Methods
 * Demonstrates various NIO.2 methods for reading files
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NIO2FileReading {
    public static void main(String[] args) {
        // Create a sample text file for demonstration
        String fileName = "sample.txt";
        createSampleFile(fileName);
        
        System.out.println("=== NIO.2 File Reading Methods ===\n");
        
        Path path = Paths.get(fileName);
        
        // Method 1: readAllBytes() - Read entire file as bytes
        System.out.println("1. Files.readAllBytes() - Read as bytes:");
        try {
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes);
            System.out.println("   File size: " + bytes.length + " bytes");
            System.out.println("   Content:\n" + content);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Method 2: readString() - Read entire text file as String
        System.out.println("2. Files.readString() - Read as String:");
        try {
            String content = Files.readString(path);
            System.out.println("   Content:\n" + content);
            System.out.println("   Length: " + content.length() + " characters");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Method 3: readAllLines() - Read all lines into List
        System.out.println("3. Files.readAllLines() - Read all lines:");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println("   Total lines: " + lines.size());
            System.out.println("   Lines:");
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("   [" + (i + 1) + "] " + lines.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Method 4: readString() with specific charset
        System.out.println("4. Files.readString() with UTF-8 charset:");
        try {
            String content = Files.readString(path, java.nio.charset.StandardCharsets.UTF_8);
            System.out.println("   Content (first 100 chars): " + 
                content.substring(0, Math.min(100, content.length())) + "...");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Method 5: readAllLines() with specific charset
        System.out.println("5. Files.readAllLines() with UTF-8 charset:");
        try {
            List<String> lines = Files.readAllLines(path, 
                java.nio.charset.StandardCharsets.UTF_8);
            System.out.println("   Total lines: " + lines.size());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        // Cleanup
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            // Ignore cleanup errors
        }
    }
    
    // Helper method to create a sample file
    private static void createSampleFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            String content = "Line 1: Hello, World!\n" +
                           "Line 2: This is a sample file.\n" +
                           "Line 3: Demonstrating NIO.2 file reading.\n" +
                           "Line 4: Java NIO.2 provides efficient file operations.\n" +
                           "Line 5: End of file.";
            Files.writeString(path, content);
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }
}

