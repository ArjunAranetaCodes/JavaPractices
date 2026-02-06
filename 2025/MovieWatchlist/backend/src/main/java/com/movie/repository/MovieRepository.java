package com.movie.repository;

import com.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(m.director) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Movie> searchByTitleOrDirector(@Param("query") String query);

    List<Movie> findByStatus(Movie.Status status);
    List<Movie> findByGenre(String genre);
}

