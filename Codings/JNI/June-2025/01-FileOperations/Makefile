# Makefile for JNI FileOperations example
# Supports both Windows and Unix-like systems

# Java compiler
JAVAC = javac

# C compiler (gcc for Unix-like, cl for Windows)
ifeq ($(OS),Windows_NT)
    CC = cl
    LIB_EXT = .dll
    LIB_PREFIX = 
    JNI_INCLUDE = -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/win32"
    CFLAGS = /LD $(JNI_INCLUDE)
    LIB_NAME = FileOperations.dll
else
    CC = gcc
    LIB_EXT = .so
    LIB_PREFIX = lib
    JNI_INCLUDE = -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/linux"
    CFLAGS = -shared -fPIC $(JNI_INCLUDE)
    LIB_NAME = libFileOperations.so
endif

# Default target
all: compile run

# Compile Java class
compile-java:
	$(JAVAC) FileOperations.java

# Generate JNI header file
generate-header: compile-java
	javah -jni FileOperations

# Compile native library
compile-native: generate-header
ifeq ($(OS),Windows_NT)
	$(CC) $(CFLAGS) FileOperations.c /Fe:$(LIB_NAME)
else
	$(CC) $(CFLAGS) -o $(LIB_NAME) FileOperations.c
endif

# Compile everything
compile: compile-java compile-native

# Run the program
run: compile
	java -Djava.library.path=. FileOperations

# Clean generated files
clean:
	rm -f *.class
	rm -f *.h
ifeq ($(OS),Windows_NT)
	rm -f *.dll
	rm -f *.exp
	rm -f *.lib
else
	rm -f *.so
endif
	rm -f test.txt

# Show help
help:
	@echo "Available targets:"
	@echo "  compile-java    - Compile Java source files"
	@echo "  generate-header - Generate JNI header file"
	@echo "  compile-native  - Compile native library"
	@echo "  compile         - Compile everything"
	@echo "  run            - Compile and run the program"
	@echo "  clean          - Remove generated files"
	@echo "  help           - Show this help message"
	@echo ""
	@echo "Prerequisites:"
	@echo "  - Java JDK installed and JAVA_HOME set"
	@echo "  - C compiler (gcc on Unix, cl on Windows)"
	@echo "  - JNI headers (included with JDK)"

.PHONY: all compile-java generate-header compile-native compile run clean help 