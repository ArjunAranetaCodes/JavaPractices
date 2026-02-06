package com.movie.service;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

    public List<Movie> searchMovies(String query) {
        return movieRepository.searchByTitleOrDirector(query);
    }

    public List<Movie> getMoviesByStatus(Movie.Status status) {
        return movieRepository.findByStatus(status);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setTitle(movieDetails.getTitle());
            movie.setDirector(movieDetails.getDirector());
            movie.setGenre(movieDetails.getGenre());
            movie.setYear(movieDetails.getYear());
            movie.setRuntime(movieDetails.getRuntime());
            movie.setRating(movieDetails.getRating());
            movie.setStatus(movieDetails.getStatus());
            movie.setNotes(movieDetails.getNotes());
            return movieRepository.save(movie);
        }
        return null;
    }

    public Movie toggleMovieStatus(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            if (movie.getStatus() == Movie.Status.UNWATCHED) {
                movie.setStatus(Movie.Status.WATCHED);
            } else {
                movie.setStatus(Movie.Status.UNWATCHED);
            }
            return movieRepository.save(movie);
        }
        return null;
    }

    public boolean deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

