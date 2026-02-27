package com.recipe.repository;

import com.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(r.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Recipe> searchByNameOrDescription(@Param("query") String query);

    List<Recipe> findByCategory(String category);
    List<Recipe> findByDifficulty(Recipe.Difficulty difficulty);
}
