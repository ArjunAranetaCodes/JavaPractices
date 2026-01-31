# Fitness Tracker Application

A simple full-stack fitness tracking application with Angular frontend and Java Spring Boot backend for tracking workouts, exercises, and fitness progress.

## Project Structure

```
2025/FitnessTracker/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete workout sessions
- Track exercises with sets, reps, weight, and duration
- Exercise types (Cardio, Strength, Flexibility, Sports, etc.)
- Workout categories (Full Body, Upper Body, Lower Body, Core, etc.)
- Track workout date and duration
- Notes and comments for workouts
- Search workouts by name or notes
- Filter by exercise type, category, and date
- Statistics dashboard (total workouts, total exercises, etc.)
- Beautiful card-based UI with progress indicators
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
cd 2025/FitnessTracker/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8099`.

### API Endpoints

- `GET /api/workouts` - Get all workouts
- `GET /api/workouts/{id}` - Get workout by ID
- `GET /api/workouts/search?query={query}` - Search workouts by name or notes
- `GET /api/workouts/type/{type}` - Get workouts by exercise type
- `GET /api/workouts/category/{category}` - Get workouts by category
- `GET /api/workouts/date/{date}` - Get workouts by date (YYYY-MM-DD)
- `POST /api/workouts` - Create new workout
- `PUT /api/workouts/{id}` - Update workout
- `DELETE /api/workouts/{id}` - Delete workout

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/FitnessTracker/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Workout Model

### Fields
- `id` - Unique identifier
- `name` - Workout name (required)
- `exerciseType` - Type of exercise (CARDIO, STRENGTH, FLEXIBILITY, SPORTS, YOGA, PILATES, CROSSFIT, OTHER)
- `category` - Workout category (FULL_BODY, UPPER_BODY, LOWER_BODY, CORE, ARMS, LEGS, BACK, CHEST, SHOULDERS, OTHER)
- `workoutDate` - Date of workout (required)
- `durationMinutes` - Duration in minutes
- `sets` - Number of sets
- `reps` - Number of repetitions
- `weight` - Weight used (in kg or lbs)
- `distance` - Distance covered (for cardio)
- `caloriesBurned` - Estimated calories burned
- `notes` - Additional notes
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Date handling for workout tracking
- Simple and straightforward implementation

