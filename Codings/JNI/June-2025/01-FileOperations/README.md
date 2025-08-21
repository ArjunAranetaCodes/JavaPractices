# JNI File Operations Tutorial

This tutorial demonstrates how to perform file operations using JNI (Java Native Interface). You'll learn how to create, read, write, and manage files through native C code called from Java.

## 📁 Project Structure

```
01-FileOperations/
├── FileOperations.java    # Java class with native file operation methods
├── FileOperations.c       # C implementation of file operations
├── Makefile              # Build automation
├── build.bat             # Windows build script
├── build.sh              # Unix/Linux/macOS build script
└── README.md             # This tutorial file
```

## 🎯 What You'll Learn

This program demonstrates:

- **File Creation**: Creating new files using native code
- **File Writing**: Writing content to files
- **File Reading**: Reading content from files
- **File Appending**: Adding content to existing files
- **File Information**: Getting file size and existence status
- **File Deletion**: Removing files
- **Directory Listing**: Listing directory contents
- **Error Handling**: Proper error handling in native code
- **Memory Management**: Managing memory for file operations

## 🛠️ Prerequisites

Before running this JNI file operations example, ensure you have:

1. **Java JDK** (version 8 or higher)
2. **C Compiler** (GCC for Unix/Linux/macOS, Visual Studio for Windows)
3. **JNI Headers** (included with JDK)
4. **Basic understanding of C file I/O operations**

## 📋 Step-by-Step Guide

### Step 1: Understand the Java Code

The `FileOperations.java` file contains native method declarations for various file operations:

```java
// File creation and management
public native boolean createFile(String filename);
public native boolean deleteFile(String filename);
public native boolean fileExists(String filename);

// File content operations
public native boolean writeToFile(String filename, String content);
public native String readFromFile(String filename);
public native boolean appendToFile(String filename, String content);

// File information
public native long getFileSize(String filename);
public native String[] listDirectory(String path);
```

### Step 2: Understand the C Implementation

The `FileOperations.c` file implements each native method using standard C file I/O functions:

#### File Creation
```c
JNIEXPORT jboolean JNICALL Java_FileOperations_createFile(JNIEnv *env, jobject obj, jstring filename) {
    const char *native_filename = (*env)->GetStringUTFChars(env, filename, 0);
    
    FILE *file = fopen(native_filename, "w");
    jboolean result = (file != NULL) ? JNI_TRUE : JNI_FALSE;
    
    if (file != NULL) {
        fclose(file);
        printf("Created file: %s\n", native_filename);
    }
    
    (*env)->ReleaseStringUTFChars(env, filename, native_filename);
    return result;
}
```

#### File Reading
```c
JNIEXPORT jstring JNICALL Java_FileOperations_readFromFile(JNIEnv *env, jobject obj, jstring filename) {
    const char *native_filename = (*env)->GetStringUTFChars(env, filename, 0);
    
    FILE *file = fopen(native_filename, "r");
    if (file == NULL) {
        (*env)->ReleaseStringUTFChars(env, filename, native_filename);
        return (*env)->NewStringUTF(env, "Error: Could not open file");
    }
    
    // Get file size and read content
    fseek(file, 0, SEEK_END);
    long file_size = ftell(file);
    fseek(file, 0, SEEK_SET);
    
    char *buffer = (char *)malloc(file_size + 1);
    size_t read_size = fread(buffer, 1, file_size, file);
    buffer[read_size] = '\0';
    fclose(file);
    
    jstring result = (*env)->NewStringUTF(env, buffer);
    free(buffer);
    
    (*env)->ReleaseStringUTFChars(env, filename, native_filename);
    return result;
}
```

### Step 3: Compile and Run

#### Using Makefile:
```bash
make compile
make run
```

#### Using Build Scripts:
```bash
# Windows
build.bat run

# Unix/Linux/macOS
./build.sh run
```

#### Manual Compilation:
```bash
# 1. Compile Java
javac FileOperations.java

# 2. Generate header
javah -jni FileOperations

# 3. Compile native library
# Windows:
cl /LD -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" FileOperations.c /Fe:FileOperations.dll

# Linux:
gcc -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -o libFileOperations.so FileOperations.c

# macOS:
gcc -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin" -o libFileOperations.dylib FileOperations.c

# 4. Run
java -Djava.library.path=. FileOperations
```

## 📊 Expected Output

When you run the program successfully, you should see:

```
JNI FileOperations library loaded successfully!
=== JNI File Operations Demo ===

1. Creating a test file...
Created file: test.txt
File created: true

2. Writing content to file...
Written 45 bytes to file: test.txt
Content written: true

3. Reading content from file...
Read 45 bytes from file: test.txt
File content:
Hello from JNI!
This is a test file.
Line 3 of the file.

4. Getting file size...
File size: 45 bytes

5. Appending content to file...
Appended 32 bytes to file: test.txt
Content appended: true

6. Reading updated content...
Read 77 bytes from file: test.txt
Updated file content:
Hello from JNI!
This is a test file.
Line 3 of the file.
This line was appended via JNI.

7. Checking file existence...
File test.txt: exists
File exists: true

8. Listing current directory...
Listed 8 items in directory: .
Directory contents:
  - .
  - ..
  - FileOperations.class
  - FileOperations.h
  - libFileOperations.so
  - test.txt
  - FileOperations.c
  - FileOperations.java

9. Deleting test file...
Deleted file: test.txt
File deleted: true

10. Verifying file deletion...
File test.txt: does not exist
File still exists: false

=== JNI File Operations Demo Complete ===
JNI FileOperations library unloaded.
```

## 🔍 Key Concepts Explained

### 1. String Handling in JNI
```c
// Convert Java string to C string
const char *native_string = (*env)->GetStringUTFChars(env, java_string, 0);

// Always release the string when done
(*env)->ReleaseStringUTFChars(env, java_string, native_string);
```

### 2. Memory Management
```c
// Allocate memory for file content
char *buffer = (char *)malloc(file_size + 1);

// Always free allocated memory
free(buffer);
```

### 3. Error Handling
```c
// Check for file operation failures
if (file == NULL) {
    printf("Failed to open file: %s\n", filename);
    return JNI_FALSE;
}
```

### 4. Array Handling
```c
// Create Java string array
jobjectArray result = (*env)->NewObjectArray(env, count, 
    (*env)->FindClass(env, "java/lang/String"), NULL);

// Set array elements
(*env)->SetObjectArrayElement(env, result, index, filename);
```

## 🚨 Common Issues and Solutions

### Issue 1: "Permission denied" when creating files
**Solution:** Check file permissions and directory access rights.

### Issue 2: "File not found" when reading
**Solution:** Ensure the file exists and the path is correct.

### Issue 3: "Memory allocation failed"
**Solution:** Check available system memory and file size limits.

### Issue 4: "Directory listing failed"
**Solution:** Ensure the directory path is valid and accessible.

## 🛠️ Advanced Topics

### 1. Binary File Operations
```c
// Reading binary data
size_t read_size = fread(buffer, sizeof(char), file_size, file);

// Writing binary data
size_t write_size = fwrite(data, sizeof(char), data_size, file);
```

### 2. File Locking
```c
// Implement file locking for concurrent access
flock(fileno(file), LOCK_EX);  // Exclusive lock
flock(fileno(file), LOCK_UN);  // Unlock
```

### 3. Buffered I/O
```c
// Use buffered I/O for better performance
setvbuf(file, NULL, _IOFBF, 8192);  // 8KB buffer
```

### 4. Error Codes
```c
// Get system error information
perror("File operation failed");
printf("Error code: %d\n", errno);
```

## 🔗 Additional Resources

- [C File I/O Functions](https://www.cplusplus.com/reference/cstdio/)
- [JNI String Operations](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/functions.html#string_operations)
- [File System Operations](https://docs.oracle.com/javase/8/docs/api/java/nio/file/package-summary.html)

## 📝 Best Practices

1. **Always release JNI string references**
2. **Check return values from file operations**
3. **Handle memory allocation failures**
4. **Use proper error handling**
5. **Close files after use**
6. **Validate file paths and permissions**

## 🎯 Exercises

1. **Add file copying functionality**
2. **Implement file searching in directories**
3. **Add file modification time tracking**
4. **Create a file compression utility**
5. **Implement file encryption/decryption**

---

**Happy File Operations with JNI! 🚀** 