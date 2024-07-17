```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class TempDirectoryTest {

    @TempDir
    Path tempDir;

    @Test
    void testWriteAndReadFile() throws IOException {
        // Arrange
        Path testFile = tempDir.resolve("test.txt");
        String content = "Hello, TempDirectory!";

        // Act
        Files.write(testFile, content.getBytes());

        // Assert
        assertTrue(Files.exists(testFile), "File should exist");
        String readContent = new String(Files.readAllBytes(testFile));
        assertEquals(content, readContent, "File content should match");
    }

    @Test
    void testCreateSubDirectory() throws IOException {
        // Arrange
        Path subDir = tempDir.resolve("subDirectory");

        // Act
        Files.createDirectory(subDir);

        // Assert
        assertTrue(Files.exists(subDir), "Subdirectory should exist");
        assertTrue(Files.isDirectory(subDir), "Should be a directory");
    }

    @Test
    void testTempDirectoryCleanup(@TempDir Path anotherTempDir) throws IOException {
        // Arrange
        Path testFile = anotherTempDir.resolve("temporary.txt");
        Files.write(testFile, "This is temporary".getBytes());

        // Assert
        assertTrue(Files.exists(testFile), "File should exist during the test");
        
        // No need to clean up - JUnit will automatically delete the temporary directory
    }
}
```

Let's break down this script:

1. We import the necessary JUnit 5 and Java NIO classes.

2. We declare a class-level `@TempDir` field, which will be automatically created before each test method and deleted after each test method.

3. The `testWriteAndReadFile()` method demonstrates writing to and reading from a file in the temporary directory.

4. The `testCreateSubDirectory()` method shows how to create a subdirectory within the temporary directory.

5. The `testTempDirectoryCleanup()` method demonstrates using `@TempDir` as a parameter in a test method. This creates a separate temporary directory for this specific test.

Key points about `@TempDirectory`:

- It automatically creates a new temporary directory for each test method.
- The directory and its contents are automatically deleted after each test method, ensuring cleanup.
- You can use it as a field (shared across test methods in a class) or as a parameter (specific to a single test method).
- It works with `Path` from the `java.nio.file` package, which provides a powerful API for file operations.

This script demonstrates basic file and directory operations within a temporary directory, showcasing how `@TempDirectory` can be useful for tests that require file system interactions without leaving artifacts after the tests complete.