# Library Book Management - Encapsulation with Collections

## Overview
This program demonstrates encapsulation using a LibraryBook class and a Library class that manages a collection of books. It shows how to encapsulate book data and provide controlled access to a collection of books.

## Key Concepts Demonstrated

### 1. Private Fields in Book
- `isbn` - Unique identifier for the book
- `title` - Book title
- `author` - Book author
- `isAvailable` - Book availability status

### 2. Library Class with Encapsulated Collection
- `books` - Array of LibraryBook objects
- `bookCount` - Number of books in the library

### 3. Public Methods for Collection Management
- `addBook()` - Adds a new book to the library
- `removeBook()` - Removes a book by ISBN
- `findBookByIsbn()` - Finds a book by ISBN
- `borrowBook()` - Borrows a book if available
- `returnBook()` - Returns a borrowed book
- `listAvailableBooks()` - Lists all available books

## Benefits of Encapsulation with Collections

1. **Data Hiding**: Book details are private and accessed via methods
2. **Controlled Access**: Only allowed operations can be performed on the collection
3. **Validation**: Prevents duplicate ISBNs and invalid operations
4. **Maintainability**: Easy to update logic for managing books

## Code Structure

```java
class LibraryBook {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    // Constructor, getters, and methods
}

class Library {
    private LibraryBook[] books;
    private int bookCount;
    // Methods to add, remove, borrow, return, and list books
}
```

## How to Run
1. Compile: `javac Library.java`
2. Run: `java Library`

## Expected Output
The program will demonstrate:
- Adding, removing, borrowing, and returning books
- Listing available books
- Error handling for invalid operations

## Learning Objectives
- Understand encapsulation with collections
- Learn how to manage a collection of objects
- See how to provide safe access to a collection 