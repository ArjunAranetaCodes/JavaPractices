# Buffered Stream Tutorial

## Overview
`BufferedInputStream` and `BufferedOutputStream` wrap other streams to provide buffering, which significantly improves I/O performance by reducing the number of system calls.

## Key Concepts

### 1. Buffering
- Buffers data in memory before reading/writing
- Reduces number of system calls
- Default buffer size is 8192 bytes (8KB)

### 2. Creating Buffered Streams
```java
BufferedInputStream bis = new BufferedInputStream(
    new FileInputStream("file.txt"));

BufferedOutputStream bos = new BufferedOutputStream(
    new FileOutputStream("file.txt"));
```

### 3. Custom Buffer Size
```java
BufferedInputStream bis = new BufferedInputStream(
    new FileInputStream("file.txt"), 16384); // 16KB buffer
```

## Performance Benefits

### Without Buffering
- Each read/write operation makes a system call
- Slow for many small operations

### With Buffering
- Data is read/written in chunks
- Fewer system calls
- Much faster for multiple operations

## Example Usage

### Reading with Buffer
```java
BufferedInputStream bis = new BufferedInputStream(
    new FileInputStream("file.txt"));
byte[] buffer = new byte[1024];
int bytesRead = bis.read(buffer);
```

### Writing with Buffer
```java
BufferedOutputStream bos = new BufferedOutputStream(
    new FileOutputStream("file.txt"));
bos.write(data.getBytes());
bos.flush(); // Ensure data is written
```

## Important Methods

### BufferedInputStream
- `read()` - Reads single byte
- `read(byte[] b)` - Reads into array
- `mark(int readlimit)` - Marks current position
- `reset()` - Resets to marked position
- `skip(long n)` - Skips bytes

### BufferedOutputStream
- `write(int b)` - Writes single byte
- `write(byte[] b)` - Writes array
- `flush()` - Forces buffer to be written

## Best Practices
1. Always wrap FileInputStream/FileOutputStream with buffered versions
2. Use appropriate buffer size based on your needs
3. Call `flush()` on BufferedOutputStream when needed
4. Use try-with-resources for automatic closing

## When to Use
- Reading/writing files with multiple operations
- Performance-critical file I/O
- Any file operation where buffering would help













