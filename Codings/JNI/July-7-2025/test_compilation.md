# JNI Compilation Test Guide

This guide helps you test your JNI setup and verify that everything works correctly.

## 🧪 Quick Test

### Step 1: Check Prerequisites

**Check Java Installation:**
```bash
java -version
javac -version
```

**Check JAVA_HOME:**
```bash
# Windows
echo %JAVA_HOME%

# Linux/macOS
echo $JAVA_HOME
```

**Check C Compiler:**
```bash
# Windows (Visual Studio)
cl

# Linux/macOS
gcc --version
```

### Step 2: Test Compilation

**Using Makefile:**
```bash
# Compile everything
make compile

# Run the program
make run
```

**Using Build Scripts:**

**Windows:**
```cmd
build.bat compile
build.bat run
```

**Linux/macOS:**
```bash
./build.sh compile
./build.sh run
```

**Manual Compilation:**
```bash
# 1. Compile Java
javac HelloJNI.java

# 2. Generate header
javah -jni HelloJNI

# 3. Compile native library
# Windows:
cl /LD -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" HelloJNI.c /Fe:HelloJNI.dll

# Linux:
gcc -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -o libHelloJNI.so HelloJNI.c

# macOS:
gcc -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin" -o libHelloJNI.dylib HelloJNI.c

# 4. Run
java -Djava.library.path=. HelloJNI
```

## ✅ Expected Results

If everything works correctly, you should see:

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

## 🔍 Generated Files

After successful compilation, you should have:

- `HelloJNI.class` - Compiled Java bytecode
- `HelloJNI.h` - Generated JNI header file
- `HelloJNI.dll` (Windows) or `libHelloJNI.so` (Linux) or `libHelloJNI.dylib` (macOS) - Native library

## 🚨 Common Issues

### Issue 1: "javah not found"
**Solution:** Use `javac -h` instead (Java 10+):
```bash
javac -h . HelloJNI.java
```

### Issue 2: "Cannot find jni.h"
**Solution:** Check JAVA_HOME and include paths:
```bash
# Verify JNI headers exist
ls $JAVA_HOME/include/jni.h
```

### Issue 3: "UnsatisfiedLinkError"
**Solution:** Check library path and naming:
```bash
# Ensure library is in current directory
ls -la *.so *.dll *.dylib

# Check library path
java -Djava.library.path=. HelloJNI
```

### Issue 4: "Permission denied" (Linux/macOS)
**Solution:** Make shell script executable:
```bash
chmod +x build.sh
```

## 🎯 Success Criteria

Your JNI setup is working correctly if:

1. ✅ Java compilation succeeds
2. ✅ Header generation succeeds  
3. ✅ Native compilation succeeds
4. ✅ Program runs without errors
5. ✅ All test outputs match expected results
6. ✅ No UnsatisfiedLinkError occurs

## 📞 Getting Help

If you encounter issues:

1. Check the main README.md for detailed troubleshooting
2. Verify all prerequisites are installed
3. Ensure environment variables are set correctly
4. Check file permissions and paths
5. Review error messages carefully

---

**Happy Testing! 🚀** 