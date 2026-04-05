# Task Management System

A full-stack task management application built with Java Spring Boot backend and Angular frontend.

## Project Structure

```
TaskManagementSystem/
├── backend/          # Spring Boot REST API
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/taskmanagement/
│   │   │   │   ├── model/          # Task entity
│   │   │   │   ├── repository/     # Data access layer
│   │   │   │   ├── service/        # Business logic
│   │   │   │   ├── controller/     # REST endpoints
│   │   │   │   └── TaskManagementApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── pom.xml
└── frontend/         # Angular application
    ├── src/
    │   ├── app/
    │   │   ├── components/         # Angular components
    │   │   ├── services/           # Angular services
    │   │   ├── models/             # TypeScript models
    │   │   └── app.module.ts
    │   └── main.ts
    ├── package.json
    └── angular.json
```

## Features

### Backend (Java Spring Boot)
- RESTful API for task management
- JPA/Hibernate for database operations
- H2 in-memory database
- Task CRUD operations
- Filtering by status, priority, assignee
- Search functionality
- Overdue task detection

### Frontend (Angular)
- Task list with filtering and search
- Create/Edit task forms
- Status and priority management
- Responsive design
- Real-time updates

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Node.js 16+ and npm
- Angular CLI 15+

### Backend Setup

1. Navigate to the backend directory:
```bash
cd backend
```

2. Build and run the application:
```bash
mvn clean install
mvn spring-boot:run
```

The backend will start on `http://localhost:8084`

3. Access H2 Console (optional):
- URL: `http://localhost:8084/h2-console`
- JDBC URL: `jdbc:h2:mem:taskdb`
- Username: `sa`
- Password: (empty)

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
ng serve
```

The frontend will start on `http://localhost:4200`

## API Endpoints

### Tasks
- `GET /api/tasks` - Get all tasks
- `GET /api/tasks/{id}` - Get task by ID
- `POST /api/tasks` - Create new task
- `PUT /api/tasks/{id}` - Update task
- `DELETE /api/tasks/{id}` - Delete task
- `PATCH /api/tasks/{id}/status?status={status}` - Update task status

### Filtering
- `GET /api/tasks/status/{status}` - Get tasks by status
- `GET /api/tasks/priority/{priority}` - Get tasks by priority
- `GET /api/tasks/assigned/{assignedTo}` - Get tasks by assignee
- `GET /api/tasks/created/{createdBy}` - Get tasks by creator
- `GET /api/tasks/overdue` - Get overdue tasks
- `GET /api/tasks/search?query={query}` - Search tasks

## Task Model

```java
- id: Long (auto-generated)
- title: String (required)
- description: String
- status: TaskStatus (PENDING, IN_PROGRESS, COMPLETED, CANCELLED)
- priority: TaskPriority (LOW, MEDIUM, HIGH, URGENT)
- dueDate: LocalDate
- assignedTo: String
- createdBy: String
- createdAt: LocalDateTime (auto-generated)
- updatedAt: LocalDateTime (auto-generated)
- completedAt: LocalDateTime (auto-generated)
```

## Usage

1. Start both backend and frontend servers
2. Open `http://localhost:4200` in your browser
3. Create tasks, assign them, set priorities and due dates
4. Filter and search tasks
5. Update task status as you work on them
6. Mark tasks as completed when done

## Technologies Used

### Backend
- Spring Boot 2.7.0
- Spring Data JPA
- H2 Database
- Maven

### Frontend
- Angular 15
- TypeScript
- RxJS
- Angular Router
- Angular Forms

