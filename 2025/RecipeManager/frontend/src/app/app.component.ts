import { Component, OnInit } from '@angular/core';
import { RecipeService } from './services/recipe.service';
import { Recipe } from './models/recipe';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  recipes: Recipe[] = [];
  filteredRecipes: Recipe[] = [];
  searchTerm: string = '';
  selectedCategory: string = '';
  selectedDifficulty: string = '';
  categories: string[] = ['Breakfast', 'Lunch', 'Dinner', 'Dessert', 'Snack', 'Beverage', 'Appetizer', 'Salad', 'Soup', 'Main Course'];
  showModal: boolean = false;
  editingRecipe: Recipe | null = null;
  newRecipe: Recipe = {
    name: '',
    description: '',
    ingredients: '',
    instructions: '',
    prepTime: 0,
    cookTime: 0,
    servings: 1,
    difficulty: 'MEDIUM',
    category: '',
    rating: 0
  };
  selectedRating: number = 0;

  constructor(private recipeService: RecipeService) {}

  ngOnInit() {
    this.loadRecipes();
  }

  loadRecipes() {
    this.recipeService.getAllRecipes().subscribe(
      (recipes) => {
        this.recipes = recipes;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading recipes:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.recipes];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.recipeService.searchRecipes(this.searchTerm).subscribe(
        (searchedRecipes) => {
          filtered = searchedRecipes;
          this.applyCategoryAndDifficultyFilters(filtered);
        },
        (error) => {
          console.error('Error searching recipes:', error);
        }
      );
    } else {
      this.applyCategoryAndDifficultyFilters(filtered);
    }
  }

  applyCategoryAndDifficultyFilters(recipes: Recipe[]) {
    let filtered = [...recipes];

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(recipe => recipe.category === this.selectedCategory);
    }

    // Apply difficulty filter
    if (this.selectedDifficulty && this.selectedDifficulty !== '') {
      filtered = filtered.filter(recipe => recipe.difficulty === this.selectedDifficulty);
    }

    this.filteredRecipes = filtered;
  }

  onSearchChange() {
    this.applyFilters();
  }

  onCategoryChange() {
    this.applyFilters();
  }

  onDifficultyChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedCategory = '';
    this.selectedDifficulty = '';
    this.applyFilters();
  }

  openModal(recipe?: Recipe) {
    if (recipe) {
      this.editingRecipe = { ...recipe };
      this.newRecipe = { ...recipe };
      this.selectedRating = recipe.rating || 0;
    } else {
      this.editingRecipe = null;
      this.newRecipe = {
        name: '',
        description: '',
        ingredients: '',
        instructions: '',
        prepTime: 0,
        cookTime: 0,
        servings: 1,
        difficulty: 'MEDIUM',
        category: '',
        rating: 0
      };
      this.selectedRating = 0;
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingRecipe = null;
    this.selectedRating = 0;
  }

  saveRecipe() {
    this.newRecipe.rating = this.selectedRating;
    if (this.editingRecipe) {
      this.updateRecipe();
    } else {
      this.createRecipe();
    }
  }

  createRecipe() {
    this.recipeService.createRecipe(this.newRecipe).subscribe(
      (recipe) => {
        this.recipes.push(recipe);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating recipe:', error);
      }
    );
  }

  updateRecipe() {
    if (this.editingRecipe && this.editingRecipe.id) {
      this.recipeService.updateRecipe(this.editingRecipe.id, this.newRecipe).subscribe(
        (recipe) => {
          const index = this.recipes.findIndex(r => r.id === recipe.id);
          if (index !== -1) {
            this.recipes[index] = recipe;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating recipe:', error);
        }
      );
    }
  }

  deleteRecipe(id: number) {
    if (confirm('Are you sure you want to delete this recipe?')) {
      this.recipeService.deleteRecipe(id).subscribe(
        () => {
          this.recipes = this.recipes.filter(r => r.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting recipe:', error);
        }
      );
    }
  }

  setRating(rating: number) {
    this.selectedRating = rating;
    this.newRecipe.rating = rating;
  }

  getTotalRecipes(): number {
    return this.recipes.length;
  }

  getAverageRating(): number {
    if (this.recipes.length === 0) return 0;
    const ratedRecipes = this.recipes.filter(r => r.rating && r.rating > 0);
    if (ratedRecipes.length === 0) return 0;
    const total = ratedRecipes.reduce((sum, recipe) => sum + (recipe.rating || 0), 0);
    return Math.round((total / ratedRecipes.length) * 10) / 10;
  }

  getTotalTime(recipe: Recipe): number {
    const prep = recipe.prepTime || 0;
    const cook = recipe.cookTime || 0;
    return prep + cook;
  }

  formatTime(minutes: number): string {
    if (!minutes || minutes === 0) return 'N/A';
    if (minutes < 60) {
      return `${minutes} min`;
    }
    const hours = Math.floor(minutes / 60);
    const mins = minutes % 60;
    if (mins === 0) {
      return `${hours} hr`;
    }
    return `${hours} hr ${mins} min`;
  }

  getStars(rating: number): number[] {
    const stars = [];
    for (let i = 1; i <= 5; i++) {
      stars.push(i <= (rating || 0) ? 1 : 0);
    }
    return stars;
  }

  formatIngredients(ingredients: string | undefined): string {
    if (!ingredients) return 'No ingredients listed';
    return ingredients.split('\n').filter(line => line.trim()).join(', ');
  }
}
