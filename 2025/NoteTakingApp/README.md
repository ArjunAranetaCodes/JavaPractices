# Note Taking Application

A simple full-stack note-taking application with Angular frontend and Java Spring Boot backend for creating, managing, and organizing personal notes.

## Project Structure

```
2025/NoteTakingApp/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete notes
- View all notes in a card-based layout
- Search notes by title or content
- Filter notes by category
- Rich text content support
- Timestamp tracking
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
cd 2025/NoteTakingApp/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8088`.

### API Endpoints

- `GET /api/notes` - Get all notes
- `GET /api/notes/{id}` - Get note by ID
- `GET /api/notes/search?query={query}` - Search notes by title or content
- `GET /api/notes/category/{category}` - Get notes by category
- `POST /api/notes` - Create new note
- `PUT /api/notes/{id}` - Update note
- `DELETE /api/notes/{id}` - Delete note

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/NoteTakingApp/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Note Model

### Fields
- `id` - Unique identifier
- `title` - Note title (required)
- `content` - Note content/body (required)
- `category` - Note category (e.g., Personal, Work, Ideas, etc.)
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Simple and straightforward implementation

