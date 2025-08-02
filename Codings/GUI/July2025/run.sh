#!/bin/bash

echo "========================================"
echo "Student Management System - Java GUI"
echo "========================================"
echo

echo "Checking Java installation..."
if ! command -v java &> /dev/null; then
    echo "ERROR: Java is not installed or not in PATH"
    echo "Please install Java 8 or higher"
    exit 1
fi

echo "Java found! Compiling..."
javac StudentManagementSystem.java
if [ $? -ne 0 ]; then
    echo "ERROR: Compilation failed"
    exit 1
fi

echo "Compilation successful! Running application..."
echo
echo "========================================"
echo "Starting Student Management System..."
echo "========================================"
echo

java StudentManagementSystem

echo
echo "Application closed." 