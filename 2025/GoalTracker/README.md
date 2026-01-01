# Goal Tracker Application

A simple full-stack goal tracking application with Angular frontend and Java Spring Boot backend for setting, tracking, and achieving personal and professional goals.

## Project Structure

```
2025/GoalTracker/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete goals
- Track goal progress (0-100%)
- Set target dates and deadlines
- Filter goals by status (Active, In Progress, Completed, Cancelled)
- Filter goals by category
- Filter goals by priority (High, Medium, Low)
- Search goals by title or description
- Visual progress bars
- Priority indicators
- Deadline tracking with overdue warnings
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
cd 2025/GoalTracker/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8093`.

### API Endpoints

- `GET /api/goals` - Get all goals
- `GET /api/goals/{id}` - Get goal by ID
- `GET /api/goals/search?query={query}` - Search goals by title or description
- `GET /api/goals/status/{status}` - Get goals by status (ACTIVE, IN_PROGRESS, COMPLETED, CANCELLED)
- `GET /api/goals/category/{category}` - Get goals by category
- `GET /api/goals/priority/{priority}` - Get goals by priority (HIGH, MEDIUM, LOW)
- `POST /api/goals` - Create new goal
- `PUT /api/goals/{id}` - Update goal
- `PUT /api/goals/{id}/progress` - Update goal progress
- `PUT /api/goals/{id}/complete` - Mark goal as completed
- `DELETE /api/goals/{id}` - Delete goal

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/GoalTracker/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Goal Model

### Fields
- `id` - Unique identifier
- `title` - Goal title (required)
- `description` - Goal description
- `category` - Goal category (e.g., Career, Health, Finance, Personal, Education, etc.)
- `priority` - Priority level (HIGH, MEDIUM, LOW)
- `status` - Goal status (ACTIVE, IN_PROGRESS, COMPLETED, CANCELLED)
- `progress` - Progress percentage (0-100)
- `targetDate` - Target completion date
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Progress is tracked as a percentage (0-100)
- Simple and straightforward implementation


