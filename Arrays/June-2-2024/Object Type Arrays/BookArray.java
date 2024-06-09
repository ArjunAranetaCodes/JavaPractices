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