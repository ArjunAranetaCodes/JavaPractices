# Recipe Manager Application

A simple full-stack recipe management application with Angular frontend and Java Spring Boot backend for storing, organizing, and managing your favorite recipes.

## Project Structure

```
2025/RecipeManager/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete recipes
- Store recipe details: name, description, ingredients, instructions
- Cooking time and preparation time tracking
- Difficulty level (Easy, Medium, Hard)
- Recipe categories (Breakfast, Lunch, Dinner, Dessert, Snack, Beverage, etc.)
- Servings count
- Search recipes by name or description
- Filter recipes by category
- Filter recipes by difficulty level
- Rating system (1-5 stars)
- Beautiful card-based UI
- RESTful API backend with in-memory H2 database

## Backend (Spring Boot)

### Tech Stack
- Java 11
- Spring Boot 2.7.x
- Spring Web
- Spring Data JPA
- H2 in-memory database
- Maven

### Running Backend

```bash
cd 2025/RecipeManager/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8094`.

### API Endpoints

- `GET /api/recipes` - Get all recipes
- `GET /api/recipes/{id}` - Get recipe by ID
- `GET /api/recipes/search?query={query}` - Search recipes by name or description
- `GET /api/recipes/category/{category}` - Get recipes by category
- `GET /api/recipes/difficulty/{difficulty}` - Get recipes by difficulty level
- `POST /api/recipes` - Create new recipe
- `PUT /api/recipes/{id}` - Update recipe
- `DELETE /api/recipes/{id}` - Delete recipe

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/RecipeManager/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Recipe Model

### Fields
- `id` - Unique identifier
- `name` - Recipe name (required)
- `description` - Recipe description
- `ingredients` - List of ingredients (stored as text)
- `instructions` - Cooking instructions (stored as text)
- `prepTime` - Preparation time in minutes
- `cookTime` - Cooking time in minutes
- `servings` - Number of servings
- `difficulty` - Difficulty level (EASY, MEDIUM, HARD)
- `category` - Recipe category (e.g., Breakfast, Lunch, Dinner, Dessert, Snack, Beverage)
- `rating` - Rating (1-5)
- `imageUrl` - Optional image URL
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Ingredients and instructions are stored as text fields
- Simple and straightforward implementation
