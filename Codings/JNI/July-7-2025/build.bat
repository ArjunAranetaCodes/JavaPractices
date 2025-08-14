@echo off
REM Windows batch file for JNI HelloJNI compilation
REM Usage: build.bat [compile|run|clean|help]

setlocal enabledelayedexpansion

REM Check if JAVA_HOME is set
if "%JAVA_HOME%"=="" (
    echo ERROR: JAVA_HOME environment variable is not set.
    echo Please set JAVA_HOME to your JDK installation directory.
    echo Example: set JAVA_HOME=C:\Program Files\Java\jdk-17
    exit /b 1
)

REM Check if Java compiler is available
javac -version >nul 2>&1
if errorlevel 1 (
    echo ERROR: javac not found. Please ensure Java JDK is installed and in PATH.
    exit /b 1
)

REM Check if C compiler is available
cl >nul 2>&1
if errorlevel 1 (
    echo ERROR: cl (Microsoft C compiler) not found.
    echo Please ensure Visual Studio or Build Tools are installed and configured.
    echo You can also use MinGW-w64 as an alternative.
    exit /b 1
)

if "%1"=="" (
    echo Usage: build.bat [compile^|run^|clean^|help]
    echo.
    echo Commands:
    echo   compile  - Compile Java and native code
    echo   run      - Compile and run the program
    echo   clean    - Remove generated files
    echo   help     - Show this help message
    exit /b 0
)

if "%1"=="help" (
    echo JNI HelloJNI Build Script for Windows
    echo =====================================
    echo.
    echo Prerequisites:
    echo   - Java JDK installed and JAVA_HOME set
    echo   - Microsoft Visual Studio or Build Tools
    echo   - JNI headers (included with JDK)
    echo.
    echo Commands:
    echo   compile  - Compile Java and native code
    echo   run      - Compile and run the program
    echo   clean    - Remove generated files
    echo   help     - Show this help message
    echo.
    echo Examples:
    echo   build.bat compile
    echo   build.bat run
    echo   build.bat clean
    exit /b 0
)

if "%1"=="clean" (
    echo Cleaning generated files...
    if exist *.class del *.class
    if exist *.h del *.h
    if exist *.dll del *.dll
    if exist *.exp del *.exp
    if exist *.lib del *.lib
    echo Clean complete.
    exit /b 0
)

if "%1"=="compile" (
    echo Compiling Java code...
    javac HelloJNI.java
    if errorlevel 1 (
        echo ERROR: Java compilation failed.
        exit /b 1
    )
    
    echo Generating JNI header...
    javah -jni HelloJNI
    if errorlevel 1 (
        echo ERROR: Header generation failed.
        exit /b 1
    )
    
    echo Compiling native library...
    cl /LD -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" HelloJNI.c /Fe:HelloJNI.dll
    if errorlevel 1 (
        echo ERROR: Native compilation failed.
        exit /b 1
    )
    
    echo Compilation successful!
    echo Generated files:
    echo   - HelloJNI.class
    echo   - HelloJNI.h
    echo   - HelloJNI.dll
    exit /b 0
)

if "%1"=="run" (
    echo Compiling and running...
    call build.bat compile
    if errorlevel 1 (
        echo ERROR: Compilation failed, cannot run.
        exit /b 1
    )
    
    echo Running HelloJNI...
    java -Djava.library.path=. HelloJNI
    if errorlevel 1 (
        echo ERROR: Program execution failed.
        exit /b 1
    )
    exit /b 0
)

echo ERROR: Unknown command '%1'
echo Use 'build.bat help' for usage information.
exit /b 1 