# Java Inheritance Tutorial

## Overview
This project demonstrates the core concepts of inheritance in Java through a practical animal hierarchy example. The code showcases single inheritance, method overriding, polymorphism, interfaces, and multiple inheritance concepts.

## Inheritance Hierarchy

```
Animal (Base Class)
├── Dog
│   └── PetDog (implements Pet interface)
├── Cat
└── Bird

Pet (Interface)
└── PetDog (implements)
```

## Key Concepts Demonstrated

### 1. Single Inheritance
- **Definition**: A class can inherit from only one parent class
- **Example**: `Dog extends Animal`, `Cat extends Animal`, `Bird extends Animal`

```java
public class Dog extends Animal {
    // Dog-specific fields and methods
}
```

### 2. Method Overriding
- **Definition**: Subclass provides a specific implementation of a method defined in the parent class
- **Example**: Each animal type has its own `makeSound()` implementation

```java
// In Animal class
public void makeSound() {
    System.out.println(name + " makes a generic animal sound");
}

// In Dog class
@Override
public void makeSound() {
    System.out.println(name + " barks: Woof! Woof!");
}
```

### 3. Polymorphism
- **Definition**: Same interface, different implementations
- **Example**: Using `Animal` reference to call methods on different animal types

```java
Animal[] animals = {dog, cat, bird};
for (Animal animal : animals) {
    animal.makeSound(); // Calls appropriate implementation
}
```

### 4. Access Modifiers
- **Public**: Accessible everywhere
- **Protected**: Accessible within package and subclasses
- **Private**: Accessible only within the class
- **Default (Package-private)**: Accessible within package

```java
public class Animal {
    protected String name;    // Accessible by subclasses
    private String habitat;   // Only accessible within Animal class
    public void eat() { }     // Accessible everywhere
}
```

### 5. Constructor Chaining
- **Definition**: Calling parent constructor using `super()`
- **Example**: `PetDog` constructor calls `Dog` constructor, which calls `Animal` constructor

```java
public PetDog(String name, int age, String habitat, String breed, 
              boolean isTrained, String ownerName, boolean isVaccinated) {
    super(name, age, habitat, breed, isTrained); // Call parent constructor
    this.ownerName = ownerName;
    this.isVaccinated = isVaccinated;
}
```

### 6. Multiple Inheritance through Interfaces
- **Definition**: A class can implement multiple interfaces
- **Example**: `PetDog extends Dog implements Pet`

```java
public class PetDog extends Dog implements Pet {
    // Must implement all abstract methods from Pet interface
    @Override
    public void play() { }
    @Override
    public void beFriendly() { }
    @Override
    public void getVaccinated() { }
}
```

### 7. Final Methods and Classes
- **Final Method**: Cannot be overridden by subclasses
- **Final Class**: Cannot be extended

```java
public final void breathe() {
    System.out.println(name + " is breathing");
}
```

### 8. Static Methods
- **Definition**: Belong to the class, not instances
- **Example**: `Animal.animalFact()` and `Pet.petFact()`

```java
public static void animalFact() {
    System.out.println("All animals are multicellular organisms");
}
```

### 9. Type Casting
- **Upcasting**: Converting subclass to parent class (implicit)
- **Downcasting**: Converting parent class to subclass (explicit)

```java
Animal animalRef = petDog;                    // Upcasting
PetDog castedPetDog = (PetDog) animalRef;     // Downcasting
```

### 10. instanceof Operator
- **Purpose**: Check if an object is an instance of a specific class or interface

```java
if (animalRef instanceof PetDog) {
    PetDog castedPetDog = (PetDog) animalRef;
}
```

## File Structure

```
Inheritance/July2025/
├── Animal.java           # Base class with common animal behavior
├── Dog.java             # Extends Animal, adds dog-specific behavior
├── Cat.java             # Extends Animal, adds cat-specific behavior
├── Bird.java            # Extends Animal, adds bird-specific behavior
├── Pet.java             # Interface for pet behavior
├── PetDog.java          # Extends Dog, implements Pet (multiple inheritance)
├── InheritanceDemo.java # Main class demonstrating all concepts
└── README.md            # This tutorial file
```

## Key Features of Each Class

### Animal (Base Class)
- Protected fields accessible by subclasses
- Public methods for common behavior
- Final method that cannot be overridden
- Static method demonstrating class-level functionality

### Dog (Subclass)
- Extends Animal with dog-specific behavior
- Overrides `makeSound()` and `move()` methods
- Adds new methods like `fetch()` and `guard()`
- Demonstrates constructor chaining

### Cat (Subclass)
- Extends Animal with cat-specific behavior
- Overrides `makeSound()`, `move()`, and `sleep()` methods
- Adds methods like `purr()` and `hunt()`

### Bird (Subclass)
- Extends Animal with bird-specific behavior
- Overrides `makeSound()` and `move()` methods
- Adds flying-related methods like `fly()` and `migrate()`

### Pet (Interface)
- Defines contract for pet behavior
- Contains abstract methods that must be implemented
- Includes default method with implementation
- Contains static method for utility

### PetDog (Multiple Inheritance)
- Extends Dog class
- Implements Pet interface
- Demonstrates multiple inheritance through interfaces
- Shows how to override default methods from interfaces

## Running the Demo

To run the inheritance demonstration:

1. Compile all Java files:
   ```bash
   javac *.java
   ```

2. Run the main class:
   ```bash
   java InheritanceDemo
   ```

## Learning Objectives

After studying this code, you should understand:

1. **Inheritance Basics**: How classes inherit from parent classes
2. **Method Overriding**: How subclasses provide specific implementations
3. **Polymorphism**: How the same method call can have different behaviors
4. **Access Control**: How different access modifiers work in inheritance
5. **Constructor Chaining**: How constructors call parent constructors
6. **Interfaces**: How to use interfaces for multiple inheritance
7. **Type Casting**: How to convert between related types
8. **Final Methods**: How to prevent method overriding
9. **Static Methods**: How class-level methods work
10. **instanceof Operator**: How to check object types

## Best Practices Demonstrated

1. **Use @Override annotation** for method overriding
2. **Call super() in constructors** to initialize parent class
3. **Use protected fields** for data that subclasses need to access
4. **Provide meaningful method names** that describe behavior
5. **Use interfaces** for defining contracts
6. **Check instanceof before downcasting** to avoid ClassCastException
7. **Use final methods** when you want to prevent overriding
8. **Document your code** with clear comments and JavaDoc

## Common Inheritance Patterns

1. **Template Method Pattern**: Base class defines algorithm structure, subclasses provide specific implementations
2. **Strategy Pattern**: Different subclasses provide different strategies for the same operation
3. **Decorator Pattern**: Adding functionality through inheritance
4. **Composite Pattern**: Treating individual objects and compositions uniformly

This tutorial provides a solid foundation for understanding inheritance in Java and can be extended with additional examples and patterns. 