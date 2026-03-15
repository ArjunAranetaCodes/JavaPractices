# Reminder Application

A simple full-stack reminder management application with Angular frontend and Java Spring Boot backend for tracking reminders with dates, priorities, and completion status.

## Project Structure

```
2025/ReminderApp/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete reminders
- Set reminder dates and times
- Priority levels (High, Medium, Low)
- Completion status tracking
- Categories for organizing reminders
- Search reminders by title or description
- Filter by status, priority, and category
- Upcoming reminders view
- Overdue reminders highlighting
- Beautiful calendar-style UI
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
cd 2025/ReminderApp/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8096`.

### API Endpoints

- `GET /api/reminders` - Get all reminders
- `GET /api/reminders/{id}` - Get reminder by ID
- `GET /api/reminders/search?query={query}` - Search reminders by title or description
- `GET /api/reminders/status/{status}` - Get reminders by status (PENDING, COMPLETED, CANCELLED)
- `GET /api/reminders/priority/{priority}` - Get reminders by priority (HIGH, MEDIUM, LOW)
- `GET /api/reminders/category/{category}` - Get reminders by category
- `GET /api/reminders/upcoming` - Get upcoming reminders
- `GET /api/reminders/overdue` - Get overdue reminders
- `POST /api/reminders` - Create new reminder
- `PUT /api/reminders/{id}` - Update reminder
- `PUT /api/reminders/{id}/complete` - Mark reminder as completed
- `DELETE /api/reminders/{id}` - Delete reminder

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/ReminderApp/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Reminder Model

### Fields
- `id` - Unique identifier
- `title` - Reminder title (required)
- `description` - Reminder description
- `reminderDate` - Date and time for the reminder
- `priority` - Priority level (HIGH, MEDIUM, LOW)
- `status` - Reminder status (PENDING, COMPLETED, CANCELLED)
- `category` - Reminder category (e.g., Work, Personal, Health, Shopping, etc.)
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Date/time handling with LocalDateTime
- Simple and straightforward implementation


