# NIO.2 File Reading Tutorial

## Overview
Java NIO.2 provides several convenient methods for reading files. These methods read the entire file into memory, making them suitable for files up to about 2GB.

## Key Methods

### 1. Files.readAllBytes()
- Reads entire file into byte array
- Works with any file type (text, binary, images, etc.)
- Automatically closes the resource
- Returns `byte[]`

```java
byte[] bytes = Files.readAllBytes(path);
String content = new String(bytes);
```

### 2. Files.readString()
- Reads entire text file as String
- Preferred over readAllBytes() for text files
- Handles security checks and access issues
- Automatically closes the resource
- Returns `String`

```java
String content = Files.readString(path);
```

### 3. Files.readAllLines()
- Reads all lines into a List
- Each element is a line of text
- Preserves line order
- Automatically closes the resource
- Returns `List<String>`

```java
List<String> lines = Files.readAllLines(path);
```

### 4. Files.lines()
- Returns Stream<String> for lazy processing
- Each element is a line of text
- Must be used in try-with-resources
- More memory efficient for large files
- Returns `Stream<String>`

```java
try (Stream<String> lines = Files.lines(path)) {
    lines.forEach(System.out::println);
}
```

## Method Comparison

| Method | Returns | Best For | Memory | Auto-Close |
|--------|---------|----------|--------|------------|
| readAllBytes() | byte[] | Any file type | High | Yes |
| readString() | String | Text files | High | Yes |
| readAllLines() | List<String> | Text files (list) | High | Yes |
| lines() | Stream<String> | Large text files | Low | Manual (try-with-resources) |

## Example Usage

### Read Entire File as String
```java
Path path = Paths.get("file.txt");
String content = Files.readString(path);
```

### Read All Lines
```java
List<String> lines = Files.readAllLines(path);
for (String line : lines) {
    System.out.println(line);
}
```

### Read with Specific Charset
```java
String content = Files.readString(path, StandardCharsets.UTF_8);
List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
```

## Best Practices

1. **Use readString() for text files** - Preferred over readAllBytes()
2. **Specify charset when needed** - Don't rely on default
3. **Use lines() for large files** - More memory efficient
4. **Handle IOException** - All methods throw IOException
5. **Consider file size** - Methods read entire file into memory
6. **Use BufferedReader for very large files** - Beyond 2GB

## When to Use

- **readAllBytes()**: Binary files, images, any file type
- **readString()**: Small to medium text files
- **readAllLines()**: When you need a List of lines
- **lines()**: Large text files, stream processing

## Limitations

- All methods (except lines()) read entire file into memory
- Suitable for files up to ~2GB
- Risk of OutOfMemoryError for very large files
- For larger files, use BufferedReader or Channel

## Important Notes

- `readAllBytes()` and `readString()` automatically close resources
- `readAllLines()` automatically closes resources
- `lines()` must be in try-with-resources block
- All methods throw IOException
- Default charset is used if not specified

## Common Use Cases

- Reading configuration files
- Processing small data files
- Loading text resources
- Reading log files (small to medium)
- Parsing structured text files
- Loading application data

