/**
 * Library Book Management - Encapsulation with Collections
 * Demonstrates encapsulation using a LibraryBook class and a Library class
 */
class LibraryBook {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    public LibraryBook(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void returned() {
        isAvailable = true;
    }
}

public class Library {
    private LibraryBook[] books;
    private int bookCount;

    public Library() {
        books = new LibraryBook[20];
        bookCount = 0;
    }

    public boolean addBook(String isbn, String title, String author) {
        if (findBookByIsbn(isbn) != null) {
            System.out.println("Book with ISBN " + isbn + " already exists.");
            return false;
        }
        if (bookCount >= books.length) {
            books = java.util.Arrays.copyOf(books, books.length * 2);
        }
        books[bookCount++] = new LibraryBook(isbn, title, author);
        System.out.println("Book added: " + title);
        return true;
    }

    public boolean removeBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                bookCount--;
                System.out.println("Book with ISBN " + isbn + " removed.");
                return true;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
        return false;
    }

    public LibraryBook findBookByIsbn(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn) {
        LibraryBook book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
            return false;
        }
        book.borrow();
        System.out.println("Book borrowed: " + book.getTitle());
        return true;
    }

    public boolean returnBook(String isbn) {
        LibraryBook book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (book.isAvailable()) {
            System.out.println("Book was not borrowed.");
            return false;
        }
        book.returned();
        System.out.println("Book returned: " + book.getTitle());
        return true;
    }

    public void listAvailableBooks() {
        System.out.println("\nAvailable Books:");
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                System.out.println("- " + books[i].getTitle() + " by " + books[i].getAuthor() + " (ISBN: " + books[i].getIsbn() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books available.");
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("111", "Java Programming", "John Doe");
        library.addBook("222", "Data Structures", "Jane Smith");
        library.addBook("333", "Algorithms", "Alan Turing");
        library.listAvailableBooks();
        library.borrowBook("222");
        library.listAvailableBooks();
        library.returnBook("222");
        library.removeBook("111");
        library.listAvailableBooks();
    }
} 