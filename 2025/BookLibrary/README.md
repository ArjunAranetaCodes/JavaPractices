# Book Library Management System

A simple full-stack book library management application with Angular frontend and Java Spring Boot backend for managing your book collection.

## Project Structure

```
2025/BookLibrary/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Add, edit, and delete books
- View all books in a list
- Search books by title or author
- Filter books by genre
- Simple and clean UI
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
cd 2025/BookLibrary/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8086`.

### API Endpoints

- `GET /api/books` - Get all books
- `GET /api/books/{id}` - Get book by ID
- `GET /api/books/search?query={query}` - Search books by title or author
- `GET /api/books/genre/{genre}` - Get books by genre
- `POST /api/books` - Create new book
- `PUT /api/books/{id}` - Update book
- `DELETE /api/books/{id}` - Delete book

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/BookLibrary/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Book Model

### Fields
- `id` - Unique identifier
- `title` - Book title (required)
- `author` - Author name (required)
- `isbn` - ISBN number
- `genre` - Book genre (e.g., Fiction, Non-Fiction, Mystery, etc.)
- `publicationYear` - Year of publication

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Simple and straightforward implementation




