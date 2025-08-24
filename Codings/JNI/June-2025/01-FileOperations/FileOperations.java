public class FileOperations {
    // Load the native library
    static {
        try {
            System.loadLibrary("FileOperations");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native library 'FileOperations' not found.");
            System.err.println("Please ensure the library is compiled and in the library path.");
            System.exit(1);
        }
    }

    // Native method declarations for file operations
    public native boolean createFile(String filename);
    public native boolean writeToFile(String filename, String content);
    public native String readFromFile(String filename);
    public native boolean appendToFile(String filename, String content);
    public native long getFileSize(String filename);
    public native boolean deleteFile(String filename);
    public native boolean fileExists(String filename);
    public native String[] listDirectory(String path);

    public static void main(String[] args) {
        System.out.println("=== JNI File Operations Demo ===");
        
        FileOperations fileOps = new FileOperations();
        
        // Test 1: Create a file
        System.out.println("\n1. Creating a test file...");
        boolean created = fileOps.createFile("test.txt");
        System.out.println("File created: " + created);
        
        // Test 2: Write to file
        System.out.println("\n2. Writing content to file...");
        String content = "Hello from JNI!\nThis is a test file.\nLine 3 of the file.";
        boolean written = fileOps.writeToFile("test.txt", content);
        System.out.println("Content written: " + written);
        
        // Test 3: Read from file
        System.out.println("\n3. Reading content from file...");
        String readContent = fileOps.readFromFile("test.txt");
        System.out.println("File content:");
        System.out.println(readContent);
        
        // Test 4: Get file size
        System.out.println("\n4. Getting file size...");
        long size = fileOps.getFileSize("test.txt");
        System.out.println("File size: " + size + " bytes");
        
        // Test 5: Append to file
        System.out.println("\n5. Appending content to file...");
        String appendContent = "\nThis line was appended via JNI.";
        boolean appended = fileOps.appendToFile("test.txt", appendContent);
        System.out.println("Content appended: " + appended);
        
        // Test 6: Read updated content
        System.out.println("\n6. Reading updated content...");
        String updatedContent = fileOps.readFromFile("test.txt");
        System.out.println("Updated file content:");
        System.out.println(updatedContent);
        
        // Test 7: Check if file exists
        System.out.println("\n7. Checking file existence...");
        boolean exists = fileOps.fileExists("test.txt");
        System.out.println("File exists: " + exists);
        
        // Test 8: List directory contents
        System.out.println("\n8. Listing current directory...");
        String[] files = fileOps.listDirectory(".");
        System.out.println("Directory contents:");
        if (files != null) {
            for (String file : files) {
                System.out.println("  - " + file);
            }
        }
        
        // Test 9: Delete the test file
        System.out.println("\n9. Deleting test file...");
        boolean deleted = fileOps.deleteFile("test.txt");
        System.out.println("File deleted: " + deleted);
        
        // Test 10: Verify deletion
        System.out.println("\n10. Verifying file deletion...");
        boolean stillExists = fileOps.fileExists("test.txt");
        System.out.println("File still exists: " + stillExists);
        
        System.out.println("\n=== JNI File Operations Demo Complete ===");
    }
} 