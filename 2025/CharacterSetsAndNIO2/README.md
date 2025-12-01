# Character Sets, Encodings, and NIO.2 Text File Reading

This folder contains programs demonstrating character sets, character encodings, and various NIO.2 methods for reading text files.

## Topics Covered

1. **Character Sets and Encodings**
   - Understanding character sets (ASCII, Unicode)
   - Character encodings (UTF-8, UTF-16, ISO-8859-1)
   - Checking default character encoding in Java

2. **NIO.2 File Reading Methods**
   - `Files.readAllBytes()` - Read entire file as bytes
   - `Files.readString()` - Read entire text file as String
   - `Files.readAllLines()` - Read all lines into List
   - `Files.lines()` - Stream-based line reading

3. **Practical Applications**
   - Parsing fixed-width files
   - Extracting data from specific columns
   - Grouping and counting data
   - Processing large text files efficiently

## Key Concepts

### Character Sets
- **ASCII**: American Standard Code for Information Interchange (7-bit)
- **Unicode**: Supports all world's writing systems
- **Code Point**: Unique numerical code assigned to each character

### Character Encodings
- **UTF-8**: Variable-length encoding, most efficient and widely supported
- **UTF-16**: Fixed 2-byte encoding
- **UTF-32**: Fixed 4-byte encoding (rarely used)
- **ISO-8859-1**: 8-bit encoding for Latin alphabet

### File Reading Methods
- **readAllBytes()**: Reads entire file into byte array (any file type)
- **readString()**: Reads entire text file as String (text files only)
- **readAllLines()**: Returns List<String> of all lines
- **lines()**: Returns Stream<String> for lazy processing

## Best Practices

1. Use `readString()` for text files instead of `readAllBytes()`
2. Use `lines()` with try-with-resources for large files
3. Methods read entire file into memory (suitable for files up to ~2GB)
4. For larger files, use BufferedReader or Channel
5. Always specify charset when encoding matters

## Programs Included

1. **CharacterEncodingDemo** - Demonstrates character sets and encodings
2. **DefaultEncodingChecker** - Checks system default character encoding
3. **NIO2FileReading** - Basic NIO.2 file reading methods
4. **FixedWidthFileParser** - Parsing fixed-width files
5. **StreamBasedFileProcessing** - Using Files.lines() with streams
6. **DataGroupingAndCounting** - Grouping and counting data from files

