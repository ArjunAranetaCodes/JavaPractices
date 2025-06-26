@echo off
echo Cleaning up old class files...
del *.class

echo.
echo Compiling String Template examples...
javac --enable-preview --release 21 *.java

if errorlevel 1 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo.
echo Running Basic String Template example...
java --enable-preview -cp . BasicStringTemplate

echo.
echo Running Custom Template Processor example...
java --enable-preview -cp . CustomTemplateProcessor

echo.
echo Running Advanced String Template example...
java --enable-preview -cp . AdvancedStringTemplate

echo.
echo All examples completed.
pause 