@echo off
echo ========================================
echo Java Exception Handling Examples
echo ========================================
echo.

echo Compiling Java files...
javac *.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b 1
)
echo Compilation successful!
echo.

echo Choose a program to run:
echo 1. ExceptionExamples - Comprehensive examples
echo 2. ExceptionBestPractices - Best practices demo
echo 3. ExceptionTest - Interactive test program
echo 4. Run all programs
echo 5. Exit
echo.

set /p choice="Enter your choice (1-5): "

if "%choice%"=="1" (
    echo.
    echo Running ExceptionExamples...
    echo ========================================
    java ExceptionExamples
) else if "%choice%"=="2" (
    echo.
    echo Running ExceptionBestPractices...
    echo ========================================
    java ExceptionBestPractices
) else if "%choice%"=="3" (
    echo.
    echo Running ExceptionTest...
    echo ========================================
    java ExceptionTest
) else if "%choice%"=="4" (
    echo.
    echo Running all programs...
    echo ========================================
    echo.
    echo 1. ExceptionExamples:
    echo ========================================
    java ExceptionExamples
    echo.
    echo ========================================
    echo 2. ExceptionBestPractices:
    echo ========================================
    java ExceptionBestPractices
    echo.
    echo ========================================
    echo 3. ExceptionTest:
    echo ========================================
    java ExceptionTest
) else if "%choice%"=="5" (
    echo Goodbye!
    exit /b 0
) else (
    echo Invalid choice!
)

echo.
echo ========================================
echo Program execution completed!
echo ========================================
pause 