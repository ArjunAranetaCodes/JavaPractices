import { Component, OnInit } from '@angular/core';
import { BookService } from './services/book.service';
import { Book } from './models/book';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  books: Book[] = [];
  filteredBooks: Book[] = [];
  searchTerm: string = '';
  selectedGenre: string = '';
  genres: string[] = ['Fiction', 'Non-Fiction', 'Mystery', 'Science Fiction', 'Fantasy', 'Romance', 'Biography', 'History', 'Other'];
  showModal: boolean = false;
  editingBook: Book | null = null;
  newBook: Book = {
    title: '',
    author: '',
    isbn: '',
    genre: '',
    publicationYear: undefined
  };

  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.loadBooks();
  }

  loadBooks() {
    this.bookService.getAllBooks().subscribe(
      (books) => {
        this.books = books;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading books:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.books];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.bookService.searchBooks(this.searchTerm).subscribe(
        (searchedBooks) => {
          filtered = searchedBooks;
          this.applyGenreFilter(filtered);
        },
        (error) => {
          console.error('Error searching books:', error);
        }
      );
    } else {
      this.applyGenreFilter(filtered);
    }
  }

  applyGenreFilter(books: Book[]) {
    if (this.selectedGenre && this.selectedGenre !== '') {
      this.filteredBooks = books.filter(book => book.genre === this.selectedGenre);
    } else {
      this.filteredBooks = books;
    }
  }

  onSearchChange() {
    this.applyFilters();
  }

  onGenreChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedGenre = '';
    this.applyFilters();
  }

  openModal(book?: Book) {
    if (book) {
      this.editingBook = { ...book };
      this.newBook = { ...book };
    } else {
      this.editingBook = null;
      this.newBook = {
        title: '',
        author: '',
        isbn: '',
        genre: '',
        publicationYear: undefined
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingBook = null;
  }

  saveBook() {
    if (this.editingBook) {
      this.updateBook();
    } else {
      this.createBook();
    }
  }

  createBook() {
    this.bookService.createBook(this.newBook).subscribe(
      (book) => {
        this.books.push(book);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating book:', error);
      }
    );
  }

  updateBook() {
    if (this.editingBook && this.editingBook.id) {
      this.bookService.updateBook(this.editingBook.id, this.newBook).subscribe(
        (book) => {
          const index = this.books.findIndex(b => b.id === book.id);
          if (index !== -1) {
            this.books[index] = book;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating book:', error);
        }
      );
    }
  }

  deleteBook(id: number) {
    if (confirm('Are you sure you want to delete this book?')) {
      this.bookService.deleteBook(id).subscribe(
        () => {
          this.books = this.books.filter(b => b.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting book:', error);
        }
      );
    }
  }
}




