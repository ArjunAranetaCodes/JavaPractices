# Shape Calculator - Abstraction Tutorial

## Overview
This program demonstrates the concept of **abstraction** in Java using geometric shapes. The abstract `Shape` class provides a common interface for different geometric shapes, while concrete classes implement specific area and perimeter calculations.

## What is Abstraction?
Abstraction is one of the four fundamental principles of Object-Oriented Programming (OOP). It involves:
- **Hiding complex implementation details** from the user
- **Showing only essential features** of an object
- **Providing a simplified interface** for complex operations

## Program Structure

### 1. Abstract Class: `Shape`
```java
public abstract class Shape {
    // Abstract methods (no implementation)
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    // Concrete methods (with implementation)
    public void displayInfo() { /* implementation */ }
}
```

**Key Points:**
- Cannot be instantiated directly
- Contains abstract methods that must be implemented by subclasses
- Can contain concrete methods with default behavior
- Provides a common interface for all shapes

### 2. Concrete Classes
- **Circle**: Implements area and perimeter using radius
- **Rectangle**: Implements area and perimeter using length and width
- **Triangle**: Implements area using Heron's formula and perimeter using side lengths

## How to Run

1. **Compile all files:**
   ```bash
   javac ShapeCalculator/*.java
   ```

2. **Run the demo:**
   ```bash
   java ShapeCalculator.ShapeCalculatorDemo
   ```

## Expected Output
```
=== Shape Calculator Demo ===

Shape: My Circle
Color: Red
Area: 78.53981633974483
Perimeter: 31.41592653589793
------------------------
Shape: My Rectangle
Color: Blue
Area: 24.0
Perimeter: 20.0
------------------------
Shape: My Triangle
Color: Green
Area: 6.0
Perimeter: 12.0
------------------------

=== Polymorphic Behavior ===
My Circle area: 78.53981633974483
My Rectangle area: 24.0
My Triangle area: 6.0
```

## Learning Objectives

### 1. Abstract Classes
- **Purpose**: Define a common interface for related classes
- **Syntax**: Use `abstract` keyword
- **Rules**: Cannot be instantiated, can contain abstract and concrete methods

### 2. Abstract Methods
- **Purpose**: Define behavior that subclasses must implement
- **Syntax**: `public abstract returnType methodName();`
- **Rules**: No implementation in abstract class, must be implemented in subclasses

### 3. Polymorphism
- **Purpose**: Treat different objects through a common interface
- **Example**: `Shape[] shapes = {circle, rectangle, triangle};`
- **Benefit**: Code flexibility and extensibility

### 4. Method Overriding
- **Purpose**: Provide specific implementation in subclasses
- **Syntax**: Use `@Override` annotation
- **Rules**: Same signature as parent method

## Key Benefits of Abstraction

1. **Code Reusability**: Common behavior defined once in abstract class
2. **Maintainability**: Changes to interface affect all implementations
3. **Extensibility**: Easy to add new shapes without changing existing code
4. **Type Safety**: Compile-time checking of method implementations

## Practice Exercises

1. **Add a new shape**: Create a `Square` class that extends `Shape`
2. **Add new methods**: Implement `calculateVolume()` for 3D shapes
3. **Enhance display**: Add shape-specific information to `displayInfo()`
4. **Validation**: Add input validation for shape dimensions

## Common Mistakes to Avoid

1. **Forgetting to implement abstract methods** in concrete classes
2. **Trying to instantiate abstract classes** directly
3. **Not using `@Override` annotation** when overriding methods
4. **Inconsistent method signatures** between abstract and concrete classes

## Advanced Concepts

- **Template Method Pattern**: Using abstract classes to define algorithm structure
- **Strategy Pattern**: Using abstraction to define different algorithms
- **Factory Pattern**: Using abstraction to create objects without specifying exact classes 