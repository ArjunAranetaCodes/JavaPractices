# Event Planner Application

A simple full-stack event planning application with Angular frontend and Java Spring Boot backend for managing events, meetings, and appointments.

## Project Structure

```
2025/EventPlanner/
├── backend/          # Spring Boot REST API
└── frontend/         # Angular application
```

## Features

- Create, edit, and delete events
- Event details: title, description, date, time, location
- Event categories (Meeting, Birthday, Wedding, Conference, etc.)
- Event status (Upcoming, In Progress, Completed, Cancelled)
- Priority levels (High, Medium, Low)
- Search events by title or description
- Filter by category, status, priority, and date range
- Calendar view with date-based filtering
- Event reminders and notes
- Beautiful card-based UI with date badges
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
cd 2025/EventPlanner/backend
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8098`.

### API Endpoints

- `GET /api/events` - Get all events
- `GET /api/events/{id}` - Get event by ID
- `GET /api/events/search?query={query}` - Search events by title or description
- `GET /api/events/category/{category}` - Get events by category
- `GET /api/events/status/{status}` - Get events by status
- `GET /api/events/priority/{priority}` - Get events by priority
- `GET /api/events/date/{date}` - Get events by date (YYYY-MM-DD)
- `GET /api/events/upcoming` - Get upcoming events
- `POST /api/events` - Create new event
- `PUT /api/events/{id}` - Update event
- `DELETE /api/events/{id}` - Delete event

## Frontend (Angular)

### Running Frontend

```bash
cd 2025/EventPlanner/frontend
npm install
ng serve
```

Frontend runs on `http://localhost:4200`.

## Event Model

### Fields
- `id` - Unique identifier
- `title` - Event title (required)
- `description` - Event description
- `eventDate` - Event date (required)
- `eventTime` - Event time
- `location` - Event location
- `category` - Event category (Meeting, Birthday, Wedding, etc.)
- `status` - Event status (UPCOMING, IN_PROGRESS, COMPLETED, CANCELLED)
- `priority` - Priority level (HIGH, MEDIUM, LOW)
- `notes` - Additional notes
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp

## Notes

- H2 database is in-memory; data resets on backend restart
- CORS is configured to allow Angular dev server
- Date and time handling for event scheduling
- Simple and straightforward implementation

