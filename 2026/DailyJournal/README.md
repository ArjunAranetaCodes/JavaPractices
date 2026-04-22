# Daily Journal

A Java + Angular app for short daily journal entries with title, date, mood, and content.

## Features

- Add entries: title, date, mood (Happy / Neutral / Sad), long-form content
- Search by title or content, filter by mood
- Entries listed newest-first by date
- Edit and delete entries

## Tech Stack

- **Backend:** Java 11, Spring Boot 2.7, JPA, H2 (port 8095)
- **Frontend:** Angular 15

## Run

**Backend**
```bash
cd 2026/DailyJournal/backend
mvn spring-boot:run
```

**Frontend**
```bash
cd 2026/DailyJournal/frontend
npm install
npm start
```

Open http://localhost:4200

## API

- `GET /api/entries` – list all
- `GET /api/entries/{id}` – get one
- `GET /api/entries/mood/{mood}` – by mood (HAPPY, NEUTRAL, SAD)
- `GET /api/entries/range?start=YYYY-MM-DD&end=YYYY-MM-DD` – by entry date range
- `GET /api/entries/search?q=...` – search by title
- `POST /api/entries` – create
- `PUT /api/entries/{id}` – update
- `DELETE /api/entries/{id}` – delete

## H2 Console

http://localhost:8095/h2-console  
JDBC URL: `jdbc:h2:mem:journaldb`  
User: `sa`  
Password: (empty)
