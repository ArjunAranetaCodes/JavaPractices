# Task Management System

A simple full-stack task management application with Angular frontend and Java Spring Boot backend for organizing and tracking tasks.

## Project Structure

```
2025/TaskManagement/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete tasks
- Track task details: title, description, priority, status, category, due date, assignee, tags
- Task status (TODO, IN_PROGRESS, DONE, CANCELLED)
- Priority levels (LOW, MEDIUM, HIGH, URGENT)
- Task categories (WORK, PERSONAL, SHOPPING, HEALTH, EDUCATION, OTHER)
- Due date tracking with overdue indicators
- Assignee management
- Tags for better organization
- Search tasks by title, description, or tags
- Filter by status, priority, category, and assignee
- Statistics dashboard (total tasks, by status, by priority, overdue tasks)
- Beautiful card-based UI with priority indicators
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
cd 2025/TaskManagement/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8102`.

### API Endpoints

- `GET /api/tasks` - Get all tasks
- `GET /api/tasks/{id}` - Get task by ID
- `GET /api/tasks/search?query={query}` - Search tasks by title, description, or tags
- `GET /api/tasks/status/{status}` - Get tasks by status
- `GET /api/tasks/priority/{priority}` - Get tasks by priority
- `GET /api/tasks/category/{category}` - Get tasks by category
- `GET /api/tasks/assignee/{assignee}` - Get tasks by assignee
- `GET /api/tasks/overdue` - Get overdue tasks
- `POST /api/tasks` - Create new task
- `PUT /api/tasks/{id}` - Update task
- `DELETE /api/tasks/{id}` - Delete task

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/TaskManagement/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Task Model

### Fields
- `id` - Unique identifier
- `title` - Task title (required)
- `description` - Task description
- `priority` - Priority level (LOW, MEDIUM, HIGH, URGENT)
- `status` - Task status (TODO, IN_PROGRESS, DONE, CANCELLED)
- `category` - Task category (WORK, PERSONAL, SHOPPING, HEALTH, EDUCATION, OTHER)
- `dueDate` - Due date (YYYY-MM-DD)
- `assignee` - Person assigned to the task
- `tags` - Comma-separated tags
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Date handling for due dates with overdue detection
- Simple and straightforward implementation

