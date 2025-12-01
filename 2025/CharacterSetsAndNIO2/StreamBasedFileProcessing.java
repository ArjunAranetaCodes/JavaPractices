/**
 * Tutorial: Stream-Based File Processing
 * Demonstrates using Files.lines() with Java Streams for efficient file processing
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamBasedFileProcessing {
    public static void main(String[] args) {
        // Create a sample fixed-width file
        String fileName = "employees.txt";
        createFixedWidthFile(fileName);
        
        System.out.println("=== Stream-Based File Processing ===\n");
        
        Path path = Paths.get(fileName);
        Pattern pattern = Pattern.compile("(.{20})(.{10})(.{15})");
        
        // Method 1: Extract distinct departments using Stream
        System.out.println("Method 1: Extract distinct departments using Stream");
        System.out.println("Using Files.lines() with Stream operations:\n");
        
        try (Stream<String> stringStream = Files.lines(path)) {
            String[] results = stringStream
                .skip(2) // Skip header and separator line
                .map(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher;
                })
                .filter(Matcher::matches) // Filter by actual matches
                .map(matcher -> matcher.group(3).trim()) // Extract department
                .distinct() // Get unique values
                .sorted() // Sort alphabetically
                .toArray(String[]::new); // Convert to array
            
            System.out.println("Distinct departments:");
            for (String dept : results) {
                System.out.println("  - " + dept);
            }
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Method 2: Count lines
        System.out.println("Method 2: Count total lines (excluding header)");
        
        try (Stream<String> lines = Files.lines(path)) {
            long count = lines
                .skip(2) // Skip header and separator
                .count();
            
            System.out.println("Total employee records: " + count);
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Method 3: Filter by department
        System.out.println("Method 3: Filter employees by department (IT)");
        
        try (Stream<String> lines = Files.lines(path)) {
            lines
                .skip(2)
                .map(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher.matches() ? matcher : null;
                })
                .filter(matcher -> matcher != null)
                .filter(matcher -> matcher.group(3).trim().equals("IT"))
                .forEach(matcher -> {
                    String name = matcher.group(1).trim();
                    String id = matcher.group(2).trim();
                    System.out.println("  " + name + " (" + id + ")");
                });
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Method 4: Extract all employee IDs
        System.out.println("Method 4: Extract all employee IDs");
        
        try (Stream<String> lines = Files.lines(path)) {
            String[] ids = lines
                .skip(2)
                .map(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher.matches() ? matcher.group(2).trim() : null;
                })
                .filter(id -> id != null)
                .toArray(String[]::new);
            
            System.out.println("Employee IDs:");
            for (String id : ids) {
                System.out.println("  - " + id);
            }
            
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
    
    // Helper method to create a fixed-width sample file
    private static void createFixedWidthFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            StringBuilder content = new StringBuilder();
            
            // Header row
            content.append(String.format("%-20s%-10s%-15s%n", "Name", "ID", "Department"));
            content.append("-".repeat(45)).append("\n");
            
            // Data rows
            content.append(String.format("%-20s%-10s%-15s%n", "John Smith", "E001", "IT"));
            content.append(String.format("%-20s%-10s%-15s%n", "Jane Doe", "E002", "HR"));
            content.append(String.format("%-20s%-10s%-15s%n", "Bob Johnson", "E003", "Finance"));
            content.append(String.format("%-20s%-10s%-15s%n", "Alice Brown", "E004", "Marketing"));
            content.append(String.format("%-20s%-10s%-15s%n", "Charlie Wilson", "E005", "IT"));
            content.append(String.format("%-20s%-10s%-15s%n", "Diana Davis", "E006", "HR"));
            content.append(String.format("%-20s%-10s%-15s%n", "Edward Miller", "E007", "Finance"));
            content.append(String.format("%-20s%-10s%-15s%n", "Fiona Garcia", "E008", "Marketing"));
            content.append(String.format("%-20s%-10s%-15s%n", "George Martinez", "E009", "IT"));
            content.append(String.format("%-20s%-10s%-15s%n", "Helen Anderson", "E010", "HR"));
            
            Files.writeString(path, content.toString());
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }
}

