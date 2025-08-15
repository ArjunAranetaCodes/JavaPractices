# JNI (Java Native Interface) Tutorial

This tutorial demonstrates how to use JNI to call native C code from Java applications. JNI allows Java applications to interact with native code written in C, C++, or other languages.

## 📁 Project Structure

```
July-7-2025/
├── HelloJNI.java      # Java class with native method declarations
├── HelloJNI.c         # C implementation of native methods
├── Makefile           # Build automation for compilation
└── README.md          # This tutorial file
```

## 🎯 What is JNI?

JNI (Java Native Interface) is a programming framework that enables Java code running in a JVM to call and be called by native applications and libraries written in other languages such as C, C++, and assembly.

### Key Benefits:
- **Performance**: Critical sections can be written in native code for better performance
- **Legacy Code Integration**: Reuse existing C/C++ libraries
- **Platform-Specific Features**: Access to system-level APIs not available in Java
- **Hardware Access**: Direct access to hardware features

## 🛠️ Prerequisites

Before running this JNI example, ensure you have:

1. **Java JDK** (version 8 or higher)
   - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
   - Set `JAVA_HOME` environment variable

2. **C Compiler**:
   - **Windows**: Microsoft Visual Studio or MinGW
   - **Linux/macOS**: GCC (usually pre-installed)

3. **JNI Headers**: Included with JDK installation

## 📋 Step-by-Step Guide

### Step 1: Understand the Java Code

The `HelloJNI.java` file contains:

```java
// Native method declarations
public native void sayHello();
public native int add(int a, int b);
public native String getMessage();
public native void printArray(int[] array);
public native int[] createArray(int size);
public native double calculateAverage(double[] numbers);
```

Key points:
- `native` keyword indicates these methods are implemented in native code
- Method signatures must match exactly between Java and C
- Static block loads the native library

### Step 2: Generate Header File

The JNI header file contains function declarations that the C compiler needs:

```bash
# Compile Java class first
javac HelloJNI.java

# Generate header file
javah -jni HelloJNI
```

This creates `HelloJNI.h` with function signatures like:
```c
JNIEXPORT void JNICALL Java_HelloJNI_sayHello(JNIEnv *, jobject);
```

### Step 3: Implement Native Methods

The `HelloJNI.c` file implements each native method:

```c
JNIEXPORT void JNICALL Java_HelloJNI_sayHello(JNIEnv *env, jobject obj) {
    printf("Hello from C! This is a native method call.\n");
}
```

### Step 4: Compile Native Library

#### Using Makefile (Recommended):
```bash
# Compile everything
make compile

# Or step by step:
make compile-java
make generate-header
make compile-native
```

#### Manual Compilation:

**Windows:**
```cmd
cl /LD -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" HelloJNI.c /Fe:HelloJNI.dll
```

**Linux/macOS:**
```bash
gcc -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -o libHelloJNI.so HelloJNI.c
```

### Step 5: Run the Program

```bash
# Using Makefile
make run

# Or manually
java -Djava.library.path=. HelloJNI
```

## 🔧 Compilation Commands

### Quick Start (Using Makefile):
```bash
# Compile and run everything
make run

# Clean generated files
make clean

# Show available commands
make help
```

### Manual Compilation:

1. **Compile Java:**
   ```bash
   javac HelloJNI.java
   ```

2. **Generate Header:**
   ```bash
   javah -jni HelloJNI
   ```

3. **Compile Native Library:**

   **Windows:**
   ```cmd
   cl /LD -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" HelloJNI.c /Fe:HelloJNI.dll
   ```

   **Linux/macOS:**
   ```bash
   gcc -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -o libHelloJNI.so HelloJNI.c
   ```

4. **Run:**
   ```bash
   java -Djava.library.path=. HelloJNI
   ```

## 📊 Expected Output

When you run the program successfully, you should see:

```
JNI library loaded successfully!
=== JNI Demo Program ===

1. Testing sayHello():
Hello from C! This is a native method call.

2. Testing add():
Adding 10 + 20 in native code
10 + 20 = 30

3. Testing getMessage():
Message from native code: Hello from native C code!

4. Testing printArray():
Array from Java (length: 5): 1 2 3 4 5

5. Testing createArray():
Created array of size 5 in native code
Created array: 10 20 30 40 50

6. Testing calculateAverage():
Calculated average of 5 numbers in native code
Average of numbers: 13.5

7. Testing Java-Native interaction:
This is a Java method calling native code!

=== JNI Demo Complete ===
JNI library unloaded.
```

## 🔍 Understanding JNI Concepts

### 1. Function Naming Convention
JNI functions follow this pattern:
```
Java_[PackageName]_[ClassName]_[MethodName]
```

### 2. JNI Environment (JNIEnv)
- Provides access to JVM functions
- Used for memory management and object creation
- Always the first parameter in JNI functions

### 3. Data Type Mapping
| Java Type | JNI Type | C Type |
|-----------|----------|--------|
| boolean   | jboolean | unsigned char |
| byte      | jbyte    | signed char |
| char      | jchar    | unsigned short |
| short     | jshort   | signed short |
| int       | jint     | signed int |
| long      | jlong    | signed long long |
| float     | jfloat   | float |
| double    | jdouble  | double |
| String    | jstring  | N/A |
| Object    | jobject  | N/A |
| Array     | jarray   | N/A |

### 4. Memory Management
- **Local References**: Automatically freed when function returns
- **Global References**: Must be explicitly freed
- **Weak References**: Can be garbage collected

## 🚨 Common Issues and Solutions

### 1. "UnsatisfiedLinkError"
**Problem:** Native library not found
**Solution:** 
- Ensure library is in the correct location
- Set `java.library.path` correctly
- Check library name matches `System.loadLibrary()`

### 2. "Cannot find jni.h"
**Problem:** JNI headers not found
**Solution:**
- Set `JAVA_HOME` environment variable
- Include correct JNI header paths in compilation

### 3. "Symbol not found"
**Problem:** Function signature mismatch
**Solution:**
- Ensure C function names match generated header
- Check parameter types and return types
- Verify JNIEXPORT and JNICALL macros

### 4. "Segmentation fault"
**Problem:** Memory access violation
**Solution:**
- Check array bounds
- Ensure proper memory management
- Validate pointer operations

## 🛠️ Troubleshooting

### Check Java Version:
```bash
java -version
javac -version
```

### Check JAVA_HOME:
```bash
echo $JAVA_HOME  # Linux/macOS
echo %JAVA_HOME% # Windows
```

### Verify JNI Headers:
```bash
ls $JAVA_HOME/include/jni.h  # Linux/macOS
dir %JAVA_HOME%\include\jni.h  # Windows
```

### Debug Compilation:
```bash
# Add verbose output
make compile V=1

# Check generated files
ls -la *.h *.so *.dll *.class
```

## 📚 Advanced Topics

### 1. Exception Handling
```c
// Check for exceptions
if ((*env)->ExceptionCheck(env)) {
    (*env)->ExceptionDescribe(env);
    (*env)->ExceptionClear(env);
    return;
}
```

### 2. Global References
```c
// Create global reference
jobject globalRef = (*env)->NewGlobalRef(env, localRef);

// Delete global reference
(*env)->DeleteGlobalRef(env, globalRef);
```

### 3. Thread Safety
- JNIEnv is not thread-safe
- Each thread needs its own JNIEnv
- Use `AttachCurrentThread()` for new threads

### 4. Performance Optimization
- Minimize JNI calls
- Use direct buffers for large data
- Batch operations when possible
- Consider using JNA for simpler cases

## 🔗 Additional Resources

- [Oracle JNI Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/)
- [JNI Specification](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/jniTOC.html)
- [JNI Programming Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/functions.html)

## 📝 License

This tutorial and example code are provided for educational purposes. Feel free to modify and use in your projects.

---

**Happy JNI Programming! 🚀** 