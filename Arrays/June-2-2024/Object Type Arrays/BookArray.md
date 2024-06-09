## Problem: 
Creating an Array of Book Objects

## Description: 
Create a program that demonstrates the use of object type arrays to store and manipulate book information.

## Input:

Book information:

Book 1: "Java Programming", "John Doe", 2020

Book 2: "Data Structures", "Jane Smith", 2019

Book 3: "Algorithms", "Bob Johnson", 2021

## Output:

Book array:

Book 1: "Java Programming", "John Doe", 2020

Book 2: "Data Structures", "Jane Smith", 2019

Book 3: "Algorithms", "Bob Johnson", 2021

## Code Answer:
```Java
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}

public class BookArray {
    public static void main(String[] args) {
        Book[] books = new Book[3];

        books[0] = new Book("Java Programming", "John Doe", 2020);
        books[1] = new Book("Data Structures", "Jane Smith", 2019);
        books[2] = new Book("Algorithms", "Bob Johnson", 2021);

        for (Book book : books) {
            System.out.println("Book: " + book.getTitle() + ", " + book.getAuthor() + ", " + book.getYear());
        }
    }
}
```

File Name: BookArray.java

This program demonstrates the use of object type arrays to store and manipulate book information. The Book class represents a book object, and the BookArray class creates an array of Book objects.

Note: Object type arrays are used to store and manipulate objects, which can contain multiple attributes and methods. This is useful for creating arrays of complex data types, like objects, that need to be stored and manipulated.