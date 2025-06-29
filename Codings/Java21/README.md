# Java 21 Features Demo

This repository contains examples demonstrating various new features introduced in Java 21. Each feature is organized in its own directory with working examples and detailed explanations.

## Project Structure

- `ForeignFunctionAPI/` - Examples of Foreign Function & Memory API
- `Pattern-Matching/` - Examples of Pattern Matching for Switch statements
- `PatternMatch2/` - Additional pattern matching examples
- `Record-Patterns/` - Demonstrations of Record Patterns feature
- `Record-Patterns2/` - More examples of Record Patterns
- `ScopedValues/` - Examples of Scoped Values (Preview)
  - `BasicScopedValue.java` - Basic usage of Scoped Values with user context
  - `AdvancedScopedValue.java` - Advanced examples with nested scopes and inheritance
- `SequenceCollection1/` - Examples of Sequenced Collections
- `String-Templates/` - Examples of String Templates (Preview)
  - `BasicStringTemplate.java` - Basic string interpolation examples
  - `CustomTemplateProcessor.java` - Custom template processor implementation
  - `AdvancedStringTemplate.java` - Advanced features and use cases
- `Switch/` - Enhanced Switch statement examples
- `Virtual-Threads/` - Basic Virtual Threads implementation
- `Virtual-Threads2/` - Advanced Virtual Threads examples

## Key Features Demonstrated

### 1. Pattern Matching for Switch
- Enhanced switch expressions with pattern matching
- Type pattern matching in switch statements
- More concise and readable code for type checking
- Guarded patterns and null handling
- Exhaustiveness checking

### 2. Virtual Threads
- Lightweight thread implementation
- Efficient handling of concurrent operations
- Examples of virtual thread creation and management
- Integration with existing thread pools
- Performance benefits and use cases
- Best practices for virtual thread usage

### 3. Record Patterns
- Pattern matching with records
- Destructuring of record components
- Simplified data handling with records
- Nested record patterns
- Type inference improvements

### 4. Sequenced Collections
- New collection interfaces for ordered data
- Methods for accessing first and last elements
- Consistent API for ordered collections
- Reversed view of collections
- Enhanced iteration capabilities

### 5. String Templates (Preview)
- Basic string interpolation with STR processor
- Custom template processors for JSON and SQL
- Advanced features including:
  - Nested expressions
  - Collection processing
  - Date/time formatting
  - Conditional expressions
  - Multi-line templates
  - Security considerations
  - Performance optimizations

### 6. Scoped Values (Preview)
- Immutable context sharing within a scope
- Thread-safe context passing
- Features demonstrated:
  - Basic user context management
  - Nested scopes and inheritance
  - Integration with virtual threads
  - Multiple context values working together
  - Best practices for scope management

### 7. Foreign Function & Memory API
- Native code integration
- Memory management
- Performance optimization
- Direct memory access
- Native function calls
- Memory safety features

## Additional Java 21 Features

While not demonstrated in the examples, Java 21 also includes:

- Structured Concurrency (Preview)
  - Simplified concurrent programming
  - Better error handling
  - Resource management
- Unnamed Patterns and Variables (Preview)
  - Improved pattern matching
  - Better code readability
- Unnamed Classes and Instance Main Methods (Preview)
  - Simplified program structure
  - Quick prototyping capabilities

## Requirements

- Java 21 or later
- Maven or Gradle (if using build tools)
- IDE with Java 21 support (recommended)

## Running the Examples

Each directory contains standalone Java files that can be compiled and run directly:

```bash
# Compile with preview features enabled
javac --enable-preview --release 21 *.java

# Run with preview features enabled
java --enable-preview Main
```

For specific examples with preview features, use:

```bash
# Run specific preview feature example
java --enable-preview -cp . path.to.example.Main
```

## Contributing

Feel free to add more examples or improve existing ones. Each feature should be demonstrated with:
- Clear, working code examples
- Detailed comments explaining the feature
- Best practices and common pitfalls
- Performance considerations where applicable

## License

This project is open source and available under the MIT License. 