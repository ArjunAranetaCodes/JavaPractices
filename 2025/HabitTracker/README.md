# Habit Tracker Application

A simple full-stack habit tracking application with Angular frontend and Java Spring Boot backend for tracking daily habits, streaks, and progress.

## Project Structure

```
2025/HabitTracker/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete habits
- Track daily habit completion
- Streak tracking (current and longest streak)
- Filter habits by category
- Filter habits by status (Active, Paused, Completed)
- Search habits by name
- Visual streak indicators
- Progress tracking
- Simple and intuitive UI
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
cd 2025/HabitTracker/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8092`.

### API Endpoints

- `GET /api/habits` - Get all habits
- `GET /api/habits/{id}` - Get habit by ID
- `GET /api/habits/search?query={query}` - Search habits by name
- `GET /api/habits/category/{category}` - Get habits by category
- `GET /api/habits/status/{status}` - Get habits by status (ACTIVE, PAUSED, COMPLETED)
- `POST /api/habits` - Create new habit
- `PUT /api/habits/{id}` - Update habit
- `PUT /api/habits/{id}/complete` - Mark habit as completed for today
- `PUT /api/habits/{id}/reset` - Reset habit streak
- `DELETE /api/habits/{id}` - Delete habit

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/HabitTracker/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Habit Model

### Fields
- `id` - Unique identifier
- `name` - Habit name (required)
- `description` - Habit description
- `category` - Habit category (e.g., Health, Fitness, Learning, Productivity, Personal, etc.)
- `frequency` - Frequency (DAILY, WEEKLY, CUSTOM)
- `currentStreak` - Current consecutive days streak
- `longestStreak` - Longest streak achieved
- `status` - Habit status (ACTIVE, PAUSED, COMPLETED)
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp
- `lastCompletedDate` - Last completion date

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Simple streak tracking logic (increments on completion, resets on missed day)
- Simple and straightforward implementation

