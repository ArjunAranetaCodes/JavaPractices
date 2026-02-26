# Project Management System

A simple full-stack project management application with Angular frontend and Java Spring Boot backend for managing projects, tasks, and team collaboration.

## Project Structure

```
2025/ProjectManagement/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete projects
- Track project details: name, description, status, priority, category
- Assign team members and project managers
- Set start and end dates for projects
- Track project progress (percentage)
- Budget tracking
- Project categories (Web Development, Mobile App, Marketing, Research, etc.)
- Project status (Planning, In Progress, On Hold, Completed, Cancelled)
- Priority levels (Low, Medium, High, Critical)
- Search projects by name or description
- Filter by status, priority, category, and date range
- Statistics dashboard (total projects, active projects, completed projects, etc.)
- Beautiful card-based UI with progress bars
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
cd 2025/ProjectManagement/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8100`.

### API Endpoints

- `GET /api/projects` - Get all projects
- `GET /api/projects/{id}` - Get project by ID
- `GET /api/projects/search?query={query}` - Search projects by name or description
- `GET /api/projects/status/{status}` - Get projects by status
- `GET /api/projects/priority/{priority}` - Get projects by priority
- `GET /api/projects/category/{category}` - Get projects by category
- `POST /api/projects` - Create new project
- `PUT /api/projects/{id}` - Update project
- `DELETE /api/projects/{id}` - Delete project

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/ProjectManagement/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Project Model

### Fields
- `id` - Unique identifier
- `name` - Project name (required)
- `description` - Project description
- `status` - Project status (PLANNING, IN_PROGRESS, ON_HOLD, COMPLETED, CANCELLED)
- `priority` - Priority level (LOW, MEDIUM, HIGH, CRITICAL)
- `category` - Project category (WEB_DEVELOPMENT, MOBILE_APP, MARKETING, RESEARCH, DESIGN, INFRASTRUCTURE, OTHER)
- `startDate` - Project start date
- `endDate` - Project end date
- `progress` - Progress percentage (0-100)
- `budget` - Project budget
- `teamMembers` - Team members assigned (comma-separated)
- `projectManager` - Project manager name
- `notes` - Additional notes
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Date handling for project timelines
- Progress tracking with visual progress bars
- Simple and straightforward implementation

