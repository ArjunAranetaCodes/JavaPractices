package com.recipe.service;

import com.recipe.model.Recipe;
import com.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElse(null);
    }

    public List<Recipe> searchRecipes(String query) {
        return recipeRepository.searchByNameOrDescription(query);
    }

    public List<Recipe> getRecipesByCategory(String category) {
        return recipeRepository.findByCategory(category);
    }

    public List<Recipe> getRecipesByDifficulty(Recipe.Difficulty difficulty) {
        return recipeRepository.findByDifficulty(difficulty);
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe recipeDetails) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            recipe.setName(recipeDetails.getName());
            recipe.setDescription(recipeDetails.getDescription());
            recipe.setIngredients(recipeDetails.getIngredients());
            recipe.setInstructions(recipeDetails.getInstructions());
            recipe.setPrepTime(recipeDetails.getPrepTime());
            recipe.setCookTime(recipeDetails.getCookTime());
            recipe.setServings(recipeDetails.getServings());
            recipe.setDifficulty(recipeDetails.getDifficulty());
            recipe.setCategory(recipeDetails.getCategory());
            recipe.setRating(recipeDetails.getRating());
            recipe.setImageUrl(recipeDetails.getImageUrl());
            return recipeRepository.save(recipe);
        }
        return null;
    }

    public boolean deleteRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
