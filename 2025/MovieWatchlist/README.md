# Movie Watchlist Application

A simple full-stack movie watchlist management application with Angular frontend and Java Spring Boot backend for tracking movies you want to watch or have watched.

## Project Structure

```
2025/MovieWatchlist/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete movies
- Mark movies as watched/unwatched
- Rate movies (1-5 stars)
- Filter movies by status (All, Watched, Unwatched)
- Filter movies by genre
- Search movies by title or director
- Display movie year and runtime
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
cd 2025/MovieWatchlist/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8091`.

### API Endpoints

- `GET /api/movies` - Get all movies
- `GET /api/movies/{id}` - Get movie by ID
- `GET /api/movies/search?query={query}` - Search movies by title or director
- `GET /api/movies/status/{status}` - Get movies by status (WATCHED, UNWATCHED)
- `GET /api/movies/genre/{genre}` - Get movies by genre
- `POST /api/movies` - Create new movie
- `PUT /api/movies/{id}` - Update movie
- `PUT /api/movies/{id}/toggle` - Toggle movie watch status
- `DELETE /api/movies/{id}` - Delete movie

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/MovieWatchlist/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Movie Model

### Fields
- `id` - Unique identifier
- `title` - Movie title (required)
- `director` - Director name
- `genre` - Movie genre (e.g., Action, Drama, Comedy, Horror, Sci-Fi, etc.)
- `year` - Release year
- `runtime` - Runtime in minutes
- `rating` - User rating (1-5)
- `status` - Watch status (WATCHED, UNWATCHED)
- `notes` - Personal notes about the movie
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Simple and straightforward implementation

