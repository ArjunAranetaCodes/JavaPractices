@echo off
echo ========================================
echo Student Management System - Java GUI
echo ========================================
echo.

echo Checking Java installation...
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 8 or higher
    pause
    exit /b 1
)

echo Java found! Compiling...
javac StudentManagementSystem.java
if %errorlevel% neq 0 (
    echo ERROR: Compilation failed
    pause
    exit /b 1
)

echo Compilation successful! Running application...
echo.
echo ========================================
echo Starting Student Management System...
echo ========================================
echo.

java StudentManagementSystem

echo.
echo Application closed.
pause 