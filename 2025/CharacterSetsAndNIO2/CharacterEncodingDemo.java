/**
 * Tutorial: Character Sets and Encodings
 * Demonstrates different character sets and encodings in Java
 */
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharacterEncodingDemo {
    public static void main(String[] args) {
        System.out.println("=== Character Sets and Encodings Demo ===\n");
        
        // Display available standard charsets
        System.out.println("Standard Character Sets in Java:");
        System.out.println("1. UTF-8: " + StandardCharsets.UTF_8);
        System.out.println("   - Variable-length encoding");
        System.out.println("   - Most efficient and widely supported");
        System.out.println("   - Can represent all Unicode characters");
        
        System.out.println("\n2. UTF-16: " + StandardCharsets.UTF_16);
        System.out.println("   - Fixed 2-byte encoding (mostly)");
        System.out.println("   - Used internally by Java strings");
        
        System.out.println("\n3. UTF-32: " + StandardCharsets.UTF_32);
        System.out.println("   - Fixed 4-byte encoding");
        System.out.println("   - Rarely used (takes more space)");
        
        System.out.println("\n4. ISO-8859-1: " + StandardCharsets.ISO_8859_1);
        System.out.println("   - 8-bit encoding");
        System.out.println("   - Latin alphabet support");
        System.out.println("   - More efficient for ASCII-only text");
        
        System.out.println("\n5. US-ASCII: " + StandardCharsets.US_ASCII);
        System.out.println("   - 7-bit encoding");
        System.out.println("   - Basic English characters only");
        
        // Demonstrate encoding differences
        System.out.println("\n=== Encoding Examples ===\n");
        
        String text = "Hello, 世界! 🌍";
        System.out.println("Original text: " + text);
        
        // UTF-8 encoding
        byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);
        System.out.println("UTF-8 bytes length: " + utf8Bytes.length);
        System.out.println("UTF-8 decoded: " + new String(utf8Bytes, StandardCharsets.UTF_8));
        
        // UTF-16 encoding
        byte[] utf16Bytes = text.getBytes(StandardCharsets.UTF_16);
        System.out.println("UTF-16 bytes length: " + utf16Bytes.length);
        System.out.println("UTF-16 decoded: " + new String(utf16Bytes, StandardCharsets.UTF_16));
        
        // ISO-8859-1 (may lose some characters)
        try {
            byte[] isoBytes = text.getBytes(StandardCharsets.ISO_8859_1);
            System.out.println("ISO-8859-1 bytes length: " + isoBytes.length);
            String decoded = new String(isoBytes, StandardCharsets.ISO_8859_1);
            System.out.println("ISO-8859-1 decoded: " + decoded);
            System.out.println("   (Note: Some characters may be lost)");
        } catch (Exception e) {
            System.out.println("ISO-8859-1: Cannot encode all characters");
        }
        
        // ASCII (will lose non-ASCII characters)
        System.out.println("\nASCII encoding (English only):");
        String asciiText = "Hello, World!";
        byte[] asciiBytes = asciiText.getBytes(StandardCharsets.US_ASCII);
        System.out.println("ASCII text: " + asciiText);
        System.out.println("ASCII bytes length: " + asciiBytes.length);
        System.out.println("ASCII decoded: " + new String(asciiBytes, StandardCharsets.US_ASCII));
        
        // Backward compatibility demonstration
        System.out.println("\n=== Backward Compatibility ===");
        System.out.println("UTF-8, UTF-16, and UTF-32 are backward compatible with ASCII.");
        System.out.println("ASCII characters are encoded the same way in all UTF encodings.");
        
        String ascii = "ABC123";
        System.out.println("\nASCII string: " + ascii);
        System.out.println("UTF-8 bytes: " + java.util.Arrays.toString(ascii.getBytes(StandardCharsets.UTF_8)));
        System.out.println("US-ASCII bytes: " + java.util.Arrays.toString(ascii.getBytes(StandardCharsets.US_ASCII)));
        System.out.println("(Notice they are identical for ASCII characters)");
    }
}

