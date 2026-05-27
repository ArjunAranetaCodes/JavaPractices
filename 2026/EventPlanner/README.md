# Event Planner

A Java + Angular app to plan events with start/end time, location, category, and status.

## Features

- Add events: title, start/end (datetime-local), location, category (Work, Personal, Birthday, Other), status (Planned, Completed, Cancelled), description
- Filter by status and category, search by title or description
- List sorted by start time
- Edit and delete events

## Tech Stack

- **Backend:** Java 11, Spring Boot 2.7, JPA, H2 (port 8094)
- **Frontend:** Angular 15

## Run

**Backend**
```bash
cd 2026/EventPlanner/backend
mvn spring-boot:run
```

**Frontend**
```bash
cd 2026/EventPlanner/frontend
npm install
npm start
```

Open http://localhost:4200

## API

- `GET /api/events` – list all
- `GET /api/events/{id}` – get one
- `GET /api/events/category/{category}` – by category
- `GET /api/events/status/{status}` – by status (PLANNED, COMPLETED, CANCELLED)
- `GET /api/events/range?start=ISO&end=ISO` – events with start in range
- `GET /api/events/search?q=...` – search by title
- `POST /api/events` – create
- `PUT /api/events/{id}` – update
- `DELETE /api/events/{id}` – delete

## H2 Console

http://localhost:8094/h2-console  
JDBC URL: `jdbc:h2:mem:eventplannerdb`  
User: `sa`  
Password: (empty)
