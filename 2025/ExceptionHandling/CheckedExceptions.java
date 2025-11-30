/**
 * Tutorial: Checked Exceptions
 * Demonstrates checked exceptions that must be handled
 */
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CheckedExceptions {
    // Method must declare checked exception
    public static void readFile(String filename) throws IOException {
        FileReader file = new FileReader(filename);
        file.close();
    }
    
    // Handling checked exception
    public static void readFileWithTryCatch(String filename) {
        try {
            FileReader file = new FileReader(filename);
            file.close();
            System.out.println("File read successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Must handle or declare
        try {
            readFile("test.txt");
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Using try-catch
        readFileWithTryCatch("test.txt");
        readFileWithTryCatch("nonexistent.txt");
    }
}


















