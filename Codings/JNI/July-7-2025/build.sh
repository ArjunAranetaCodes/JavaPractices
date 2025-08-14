#!/bin/bash

# Unix/Linux/macOS shell script for JNI HelloJNI compilation
# Usage: ./build.sh [compile|run|clean|help]

set -e  # Exit on any error

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Function to print colored output
print_status() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

print_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Check if JAVA_HOME is set
if [ -z "$JAVA_HOME" ]; then
    print_error "JAVA_HOME environment variable is not set."
    echo "Please set JAVA_HOME to your JDK installation directory."
    echo "Example: export JAVA_HOME=/usr/lib/jvm/java-17-openjdk"
    exit 1
fi

# Check if Java compiler is available
if ! command -v javac &> /dev/null; then
    print_error "javac not found. Please ensure Java JDK is installed and in PATH."
    exit 1
fi

# Check if C compiler is available
if ! command -v gcc &> /dev/null; then
    print_error "gcc not found. Please install GCC compiler."
    echo "Ubuntu/Debian: sudo apt-get install build-essential"
    echo "CentOS/RHEL: sudo yum install gcc"
    echo "macOS: Install Xcode Command Line Tools"
    exit 1
fi

# Function to show help
show_help() {
    echo "JNI HelloJNI Build Script for Unix/Linux/macOS"
    echo "=============================================="
    echo ""
    echo "Prerequisites:"
    echo "  - Java JDK installed and JAVA_HOME set"
    echo "  - GCC compiler installed"
    echo "  - JNI headers (included with JDK)"
    echo ""
    echo "Commands:"
    echo "  compile  - Compile Java and native code"
    echo "  run      - Compile and run the program"
    echo "  clean    - Remove generated files"
    echo "  help     - Show this help message"
    echo ""
    echo "Examples:"
    echo "  ./build.sh compile"
    echo "  ./build.sh run"
    echo "  ./build.sh clean"
}

# Function to clean generated files
clean_files() {
    print_status "Cleaning generated files..."
    rm -f *.class *.h *.so *.dylib
    print_success "Clean complete."
}

# Function to compile everything
compile_code() {
    print_status "Compiling Java code..."
    javac HelloJNI.java
    if [ $? -eq 0 ]; then
        print_success "Java compilation successful"
    else
        print_error "Java compilation failed"
        exit 1
    fi
    
    print_status "Generating JNI header..."
    javah -jni HelloJNI
    if [ $? -eq 0 ]; then
        print_success "Header generation successful"
    else
        print_error "Header generation failed"
        exit 1
    fi
    
    print_status "Compiling native library..."
    
    # Determine platform-specific compilation
    if [[ "$OSTYPE" == "darwin"* ]]; then
        # macOS
        gcc -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin" -o libHelloJNI.dylib HelloJNI.c
        LIB_NAME="libHelloJNI.dylib"
    else
        # Linux
        gcc -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -o libHelloJNI.so HelloJNI.c
        LIB_NAME="libHelloJNI.so"
    fi
    
    if [ $? -eq 0 ]; then
        print_success "Native compilation successful"
    else
        print_error "Native compilation failed"
        exit 1
    fi
    
    print_success "Compilation completed successfully!"
    echo "Generated files:"
    echo "  - HelloJNI.class"
    echo "  - HelloJNI.h"
    echo "  - $LIB_NAME"
}

# Function to run the program
run_program() {
    print_status "Compiling and running..."
    compile_code
    
    print_status "Running HelloJNI..."
    java -Djava.library.path=. HelloJNI
    if [ $? -eq 0 ]; then
        print_success "Program executed successfully"
    else
        print_error "Program execution failed"
        exit 1
    fi
}

# Main script logic
case "${1:-}" in
    "help"|"-h"|"--help")
        show_help
        ;;
    "clean")
        clean_files
        ;;
    "compile")
        compile_code
        ;;
    "run")
        run_program
        ;;
    "")
        echo "Usage: ./build.sh [compile|run|clean|help]"
        echo "Use './build.sh help' for more information"
        exit 1
        ;;
    *)
        print_error "Unknown command '$1'"
        echo "Use './build.sh help' for usage information"
        exit 1
        ;;
esac 