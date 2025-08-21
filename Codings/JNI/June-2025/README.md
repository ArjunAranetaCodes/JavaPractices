# JNI Programming Examples - June 2025

This directory contains 5 comprehensive JNI (Java Native Interface) programs, each demonstrating different aspects of native code integration with Java applications.

## 📁 Program Overview

### 1. **File Operations** (`01-FileOperations/`)
**Purpose**: Demonstrates file I/O operations through native code
- File creation, reading, writing, and deletion
- Directory listing and file information
- Memory management for file operations
- Error handling and validation

**Key Features**:
- `createFile()`, `writeToFile()`, `readFromFile()`
- `deleteFile()`, `fileExists()`, `getFileSize()`
- `listDirectory()`, `appendToFile()`

### 2. **System Information** (`02-SystemInfo/`)
**Purpose**: Shows how to retrieve system information using native code
- Operating system detection and architecture
- Memory usage and processor information
- Environment variables and process details
- System uptime and load monitoring

**Key Features**:
- `getOperatingSystem()`, `getArchitecture()`
- `getTotalMemory()`, `getFreeMemory()`, `getProcessorCount()`
- `getEnvironmentVariable()`, `getCurrentProcessId()`
- `getSystemUptime()`, `getSystemLoad()`

### 3. **Mathematical Operations** (`03-MathOperations/`)
**Purpose**: Demonstrates complex mathematical computations in native code
- Basic and advanced mathematical functions
- Matrix operations and linear algebra
- Statistical calculations and number theory
- Performance comparison with Java Math

**Key Features**:
- `sqrt()`, `pow()`, `sin()`, `cos()`, `log()`, `exp()`
- `matrixMultiply()`, `determinant()`, `solveLinearSystem()`
- `mean()`, `variance()`, `correlation()`
- `factorial()`, `fibonacci()`, `gcd()`, `isPrime()`

### 4. **String Processing** (`04-StringProcessing/`)
**Purpose**: Shows advanced string manipulation using native code
- String analysis and transformation
- Pattern matching and text processing
- Performance optimization for string operations
- Character counting and word extraction

**Key Features**:
- `reverse()`, `toUpperCase()`, `toLowerCase()`
- `countWords()`, `countVowels()`, `isPalindrome()`
- `split()`, `replace()`, `contains()`, `findFirst()`
- `extractWords()`, `removeSpecialCharacters()`

### 5. **Memory Management** (`05-MemoryManagement/`)
**Purpose**: Demonstrates advanced memory management techniques
- Direct memory allocation and deallocation
- Memory copying and setting operations
- Memory leak prevention and monitoring
- Performance optimization strategies

**Key Features**:
- `allocateMemory()`, `freeMemory()`, `writeToMemory()`, `readFromMemory()`
- `memoryCopy()`, `memorySet()`, `clearMemory()`
- `getMemoryUsage()`, `getActiveAllocations()`
- `isValidAddress()`, `forceGarbageCollection()`

## 🛠️ Prerequisites

Before running any of these JNI examples, ensure you have:

1. **Java JDK** (version 8 or higher)
   - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
   - Set `JAVA_HOME` environment variable

2. **C Compiler**:
   - **Windows**: Microsoft Visual Studio or MinGW
   - **Linux/macOS**: GCC (usually pre-installed)

3. **JNI Headers**: Included with JDK installation

## 🚀 Quick Start

### Compile and Run All Programs

**Using Makefile (if available):**
```bash
# Navigate to any program directory
cd 01-FileOperations
make run

cd ../02-SystemInfo
make run

# Continue for other programs...
```

**Using Build Scripts:**

**Windows:**
```cmd
cd 01-FileOperations
build.bat run

cd ..\02-SystemInfo
build.bat run

# Continue for other programs...
```

**Linux/macOS:**
```bash
cd 01-FileOperations
./build.sh run

cd ../02-SystemInfo
./build.sh run

# Continue for other programs...
```

**Manual Compilation:**
```bash
# For each program directory:
javac *.java
javah -jni [ClassName]

# Windows:
cl /LD -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" *.c /Fe:[LibraryName].dll

# Linux/macOS:
gcc -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -o lib[LibraryName].so *.c

# Run:
java -Djava.library.path=. [ClassName]
```

## 📊 Expected Outputs

Each program provides comprehensive output demonstrating its functionality:

### File Operations
- File creation, writing, reading, and deletion
- Directory listing and file size information
- Error handling for file operations

### System Information
- OS detection, memory usage, CPU information
- Environment variables and process details
- System uptime and performance metrics

### Mathematical Operations
- Mathematical function calculations
- Matrix operations and statistical analysis
- Performance comparison with Java Math

### String Processing
- String manipulation and analysis
- Pattern matching and text processing
- Performance benchmarks

### Memory Management
- Memory allocation and deallocation
- Memory operations and monitoring
- Memory leak prevention

## 🔍 Learning Objectives

### For Each Program:

1. **Understand JNI Basics**
   - Native method declarations
   - Library loading and error handling
   - Data type mapping between Java and C

2. **Master Specific Concepts**
   - File I/O operations and system calls
   - System information retrieval
   - Mathematical computations and algorithms
   - String processing and text analysis
   - Memory management and optimization

3. **Learn Best Practices**
   - Error handling and validation
   - Memory management and leak prevention
   - Performance optimization
   - Cross-platform compatibility

## 🚨 Common Issues and Solutions

### Issue 1: "UnsatisfiedLinkError"
**Solution**: Ensure native library is compiled and in the correct location.

### Issue 2: "Cannot find jni.h"
**Solution**: Set `JAVA_HOME` environment variable correctly.

### Issue 3: "Permission denied" (Linux/macOS)
**Solution**: Make shell scripts executable with `chmod +x build.sh`.

### Issue 4: "Symbol not found"
**Solution**: Check function signatures match between Java and C.

## 🛠️ Advanced Topics Covered

### File Operations
- Cross-platform file handling
- Binary and text file operations
- Directory traversal and file system access

### System Information
- Platform-specific system calls
- Real-time system monitoring
- Environment variable management

### Mathematical Operations
- High-performance mathematical computations
- Linear algebra and matrix operations
- Statistical analysis and algorithms

### String Processing
- Efficient string manipulation
- Text analysis and pattern matching
- Unicode and character encoding

### Memory Management
- Direct memory access and manipulation
- Memory optimization techniques
- Memory leak detection and prevention

## 📚 Additional Resources

- [Oracle JNI Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/)
- [JNI Programming Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/functions.html)
- [C Programming Reference](https://www.cplusplus.com/reference/)
- [System Programming Guides](https://man7.org/linux/man-pages/)

## 🎯 Exercises and Extensions

### For Each Program:

1. **Add Error Handling**
   - Implement comprehensive error checking
   - Add logging and debugging capabilities

2. **Performance Optimization**
   - Profile and optimize critical sections
   - Implement caching and buffering

3. **Cross-Platform Support**
   - Add support for additional platforms
   - Handle platform-specific features

4. **Integration**
   - Combine multiple programs
   - Create a comprehensive JNI framework

## 📝 Best Practices Demonstrated

1. **Memory Management**
   - Always release JNI string references
   - Proper allocation and deallocation
   - Memory leak prevention

2. **Error Handling**
   - Check return values from native calls
   - Provide meaningful error messages
   - Graceful degradation

3. **Performance**
   - Minimize JNI calls
   - Use efficient algorithms
   - Profile and optimize

4. **Maintainability**
   - Clear code organization
   - Comprehensive documentation
   - Consistent naming conventions

---

**Happy JNI Programming! 🚀**

Each program in this collection provides a solid foundation for understanding different aspects of JNI programming. Start with the basic examples and gradually explore more advanced features as you become comfortable with the concepts. 