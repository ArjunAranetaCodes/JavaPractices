#!/bin/bash

echo "========================================"
echo "Java Exception Handling Examples"
echo "========================================"
echo

echo "Compiling Java files..."
javac *.java
if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi
echo "Compilation successful!"
echo

echo "Choose a program to run:"
echo "1. ExceptionExamples - Comprehensive examples"
echo "2. ExceptionBestPractices - Best practices demo"
echo "3. ExceptionTest - Interactive test program"
echo "4. Run all programs"
echo "5. Exit"
echo

read -p "Enter your choice (1-5): " choice

case $choice in
    1)
        echo
        echo "Running ExceptionExamples..."
        echo "========================================"
        java ExceptionExamples
        ;;
    2)
        echo
        echo "Running ExceptionBestPractices..."
        echo "========================================"
        java ExceptionBestPractices
        ;;
    3)
        echo
        echo "Running ExceptionTest..."
        echo "========================================"
        java ExceptionTest
        ;;
    4)
        echo
        echo "Running all programs..."
        echo "========================================"
        echo
        echo "1. ExceptionExamples:"
        echo "========================================"
        java ExceptionExamples
        echo
        echo "========================================"
        echo "2. ExceptionBestPractices:"
        echo "========================================"
        java ExceptionBestPractices
        echo
        echo "========================================"
        echo "3. ExceptionTest:"
        echo "========================================"
        java ExceptionTest
        ;;
    5)
        echo "Goodbye!"
        exit 0
        ;;
    *)
        echo "Invalid choice!"
        ;;
esac

echo
echo "========================================"
echo "Program execution completed!"
echo "========================================" 