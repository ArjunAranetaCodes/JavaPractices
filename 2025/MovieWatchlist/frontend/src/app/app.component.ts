import { Component, OnInit } from '@angular/core';
import { MovieService } from './services/movie.service';
import { Movie } from './models/movie';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  movies: Movie[] = [];
  filteredMovies: Movie[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedGenre: string = '';
  genres: string[] = ['Action', 'Drama', 'Comedy', 'Horror', 'Sci-Fi', 'Thriller', 'Romance', 'Adventure', 'Fantasy', 'Documentary'];
  showModal: boolean = false;
  editingMovie: Movie | null = null;
  newMovie: Movie = {
    title: '',
    director: '',
    genre: '',
    year: undefined,
    runtime: undefined,
    rating: undefined,
    status: 'UNWATCHED',
    notes: ''
  };

  constructor(private movieService: MovieService) {}

  ngOnInit() {
    this.loadMovies();
  }

  loadMovies() {
    this.movieService.getAllMovies().subscribe(
      (movies) => {
        this.movies = movies;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading movies:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.movies];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.movieService.searchMovies(this.searchTerm).subscribe(
        (searchedMovies) => {
          filtered = searchedMovies;
          this.applyStatusAndGenreFilters(filtered);
        },
        (error) => {
          console.error('Error searching movies:', error);
        }
      );
    } else {
      this.applyStatusAndGenreFilters(filtered);
    }
  }

  applyStatusAndGenreFilters(movies: Movie[]) {
    let filtered = [...movies];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(movie => movie.status === this.selectedStatus);
    }

    // Apply genre filter
    if (this.selectedGenre && this.selectedGenre !== '') {
      filtered = filtered.filter(movie => movie.genre === this.selectedGenre);
    }

    this.filteredMovies = filtered;
  }

  onSearchChange() {
    this.applyFilters();
  }

  onStatusChange() {
    this.applyFilters();
  }

  onGenreChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedStatus = '';
    this.selectedGenre = '';
    this.applyFilters();
  }

  openModal(movie?: Movie) {
    if (movie) {
      this.editingMovie = { ...movie };
      this.newMovie = { ...movie };
    } else {
      this.editingMovie = null;
      this.newMovie = {
        title: '',
        director: '',
        genre: '',
        year: undefined,
        runtime: undefined,
        rating: undefined,
        status: 'UNWATCHED',
        notes: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingMovie = null;
  }

  saveMovie() {
    if (this.editingMovie) {
      this.updateMovie();
    } else {
      this.createMovie();
    }
  }

  createMovie() {
    this.movieService.createMovie(this.newMovie).subscribe(
      (movie) => {
        this.movies.push(movie);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating movie:', error);
      }
    );
  }

  updateMovie() {
    if (this.editingMovie && this.editingMovie.id) {
      this.movieService.updateMovie(this.editingMovie.id, this.newMovie).subscribe(
        (movie) => {
          const index = this.movies.findIndex(m => m.id === movie.id);
          if (index !== -1) {
            this.movies[index] = movie;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating movie:', error);
        }
      );
    }
  }

  toggleMovieStatus(movie: Movie) {
    if (movie.id) {
      this.movieService.toggleMovieStatus(movie.id).subscribe(
        (updatedMovie) => {
          const index = this.movies.findIndex(m => m.id === updatedMovie.id);
          if (index !== -1) {
            this.movies[index] = updatedMovie;
          }
          this.applyFilters();
        },
        (error) => {
          console.error('Error toggling movie status:', error);
        }
      );
    }
  }

  deleteMovie(id: number) {
    if (confirm('Are you sure you want to delete this movie?')) {
      this.movieService.deleteMovie(id).subscribe(
        () => {
          this.movies = this.movies.filter(m => m.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting movie:', error);
        }
      );
    }
  }

  getWatchedCount(): number {
    return this.movies.filter(movie => movie.status === 'WATCHED').length;
  }

  getUnwatchedCount(): number {
    return this.movies.filter(movie => movie.status === 'UNWATCHED').length;
  }

  getRatingStars(rating?: number): string {
    if (!rating) return '';
    return '★'.repeat(rating) + '☆'.repeat(5 - rating);
  }

  formatRuntime(minutes?: number): string {
    if (!minutes) return 'N/A';
    if (minutes < 60) {
      return `${minutes} min`;
    }
    const hours = Math.floor(minutes / 60);
    const mins = minutes % 60;
    return mins > 0 ? `${hours}h ${mins}min` : `${hours}h`;
  }
}

