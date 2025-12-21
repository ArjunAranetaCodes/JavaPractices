# Contact Management System

A simple full-stack contact management application with Angular frontend and Java Spring Boot backend for managing personal contacts.

## Project Structure

```
2025/ContactManagement/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Add, edit, and delete contacts
- View all contacts in a list
- Search contacts by name
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
cd 2025/ContactManagement/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8085`.

### API Endpoints

- `GET /api/contacts` - Get all contacts
- `GET /api/contacts/{id}` - Get contact by ID
- `GET /api/contacts/search?name={name}` - Search contacts by name
- `POST /api/contacts` - Create new contact
- `PUT /api/contacts/{id}` - Update contact
- `DELETE /api/contacts/{id}` - Delete contact

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/ContactManagement/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Contact Model

### Fields
- `id` - Unique identifier
- `name` - Contact name (required)
- `email` - Email address
- `phone` - Phone number
- `address` - Physical address

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Simple and straightforward implementation


