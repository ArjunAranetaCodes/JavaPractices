public class Book {
    private String title;
    private String author;
    private int publicationYear;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear >= 1000 && publicationYear <= 2024) {
            this.publicationYear = publicationYear;
        } else {
            System.out.println("Invalid publication year.");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
